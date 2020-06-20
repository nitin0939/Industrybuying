package com.industry.buying.industryBying.service.impl;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.industry.buying.industryBying.constants.ApplicationConstant;
import com.industry.buying.industryBying.model.SearchDataModel;
import com.industry.buying.industryBying.service.ICSVService;
import com.opencsv.CSVReader;

@Service
public class CSVServiceImpl implements ICSVService{
	
	  @Autowired
	  private SessionFactory entityManagerFactory;
	
	@Override
	public Map<String, Object> uploadData(MultipartFile file) {
		Path path = null;
		Map<String, Object> map=new HashMap<String, Object>();
		Long count=0L;
		Session session = entityManagerFactory.getCurrentSession();
		Transaction tx = null;
		try {
			byte[] bytes = file.getBytes();
			String originalFileName = file.getOriginalFilename();
			String fileName = originalFileName.substring(0, originalFileName.lastIndexOf("."));
			fileName = fileName.replace(' ', '_');
			String fileExt = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);

			String filePath = ApplicationConstant.TEMP_FILE_DIRECTORY + "/" + fileName + "." + fileExt;
			path = Paths.get(filePath);
			Files.write(path, bytes);

			CSVReader reader;
			String  nextLine[]=new String[10];
			FileReader fr =  null;
			fr = new FileReader(filePath);
			reader = new CSVReader(fr, ',', '\'', 1);
			int i=0;


			tx = session.beginTransaction();
			try {
				while ((nextLine = reader.readNext()) != null)
				{
					//Long id = Long.valueOf(nextLine[0]);
					String Message = nextLine[1];
					String truth = nextLine[2];
					String cube = nextLine[3];
					String google = nextLine[4];
					Double google_spam = Double.valueOf(nextLine[5]);
					Double google_not_spam = Double.valueOf(nextLine[6]);
					String ibm = nextLine[7];
					Double ibm_spam = Double.valueOf(nextLine[8]);
					Double ibm_not_spam = Double.valueOf(nextLine[9]);


					SearchDataModel searchData = new SearchDataModel(Message, truth, cube, google, google_spam, google_not_spam, ibm, ibm_spam, ibm_not_spam);
					session.save(searchData);
					count++;
					i++;
					if( i == 1000 ) {
						session.flush();
						session.clear();
					}

				} 
				tx.commit();
			}catch (HibernateException e) {
				map.put("status", "failed");
				map.put("message", "error in processing file");
				System.out.println("Count of row is "+count);
				if (tx!=null) tx.rollback();
				e.printStackTrace(); 
			} finally {
				session.close(); 
			}
			System.out.println();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("Count of row is###########################: "+count);
			e1.printStackTrace();
		}
		map.put("status", "success");
		map.put("message", "file has processed successfully");
		map.put("Total item Processed", count);
		return map;
	}

}
