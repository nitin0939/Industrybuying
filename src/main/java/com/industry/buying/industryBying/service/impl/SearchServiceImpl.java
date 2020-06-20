package com.industry.buying.industryBying.service.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.industry.buying.industryBying.Enum.ColumnValueEnum;
import com.industry.buying.industryBying.model.SearchDataModel;
import com.industry.buying.industryBying.repository.SearchRespository;
import com.industry.buying.industryBying.response.cube;
import com.industry.buying.industryBying.response.google;
import com.industry.buying.industryBying.response.ibm;
import com.industry.buying.industryBying.response.searchResponse;
import com.industry.buying.industryBying.response.truth;
import com.industry.buying.industryBying.service.ISearchService;

@Service
public class SearchServiceImpl implements ISearchService{
	
	  @Autowired
	  private SessionFactory entityManagerFactory;
	  
	  @Autowired
	  private SearchRespository searchRespository;
	
	@Override  
	public searchResponse searchQuery(String query) {
		searchResponse response=new searchResponse();
		List<SearchDataModel> listObjects=null;
			
		listObjects = getQueryResult(query);
		if(null == listObjects)
			return response;
		response.setTotal_matches(listObjects.size());
		
		processResult(response, listObjects);
		return response;
	}
	
	private List<SearchDataModel> getQueryResult(String query){
		List<SearchDataModel> listObjects=null;
		
		listObjects = searchRespository.findByQuery(query);
		
		return listObjects;
	}
	
	private void processResult(searchResponse response, List<SearchDataModel> listObjects) {
		long truthSpam=0L;
		long truthNotSpam=0L;
		long cubeSpam=0L;
		long cubeNotSpam=0L;
		long googleSpam=0L;
		long googleNotSpam=0L;
		long ibmSpam=0L;
		long ibmNotSpam=0L;
		
		double googleSpamAVG=0.0D;
		double googleNotSpamAVG=0.0D;
		double ibmSpamAVG=0.0D;
		double ibmNotSpamAVG=0.0D;
		
		truth truth=new truth();
		cube cube=new cube();
		google google = new google();
		ibm ibm=new ibm();
				
		response.setTruth(truth);
		response.setCube(cube);
		response.setGoogle(google);
		response.setIbm(ibm);
		
		for(SearchDataModel searchData: listObjects) {
			if(searchData.getTruth().equalsIgnoreCase(ColumnValueEnum.NOTSPAM.getValue())) {
				truthNotSpam++;
			}if(searchData.getTruth().equalsIgnoreCase(ColumnValueEnum.SPAM.getValue())) {
				truthSpam++;
			}
			
			if(searchData.getCube().equalsIgnoreCase(ColumnValueEnum.NOTSPAM.getValue())) {
				cubeNotSpam++;
			}if(searchData.getCube().equalsIgnoreCase(ColumnValueEnum.SPAM.getValue())) {
				cubeSpam++;
			}
			
			if(searchData.getCube().equalsIgnoreCase(ColumnValueEnum.NOTSPAM.getValue())) {
				googleNotSpam++;
			}if(searchData.getCube().equalsIgnoreCase(ColumnValueEnum.SPAM.getValue())) {
				googleSpam++;
			}
			
			if(searchData.getCube().equalsIgnoreCase(ColumnValueEnum.NOTSPAM.getValue())) {
				ibmNotSpam++;
			}if(searchData.getCube().equalsIgnoreCase(ColumnValueEnum.SPAM.getValue())) {
				ibmSpam++;
			}
			
			googleSpamAVG +=searchData.getGoogle_spam();
			googleNotSpamAVG +=searchData.getGoogle_not_spam();
			
			ibmSpamAVG +=searchData.getIbm_spam();
			ibmNotSpamAVG +=searchData.getIbm_not_spam();
		}
		
		truth.setSpam(truthSpam);
		truth.setNot_spam(truthNotSpam);
		
		cube.setSpam(cubeSpam);
		cube.setNot_spam(cubeNotSpam);
		
		google.setSpam(googleSpam);
		google.setNot_spam(googleNotSpam);
		
		ibm.setSpam(ibmSpam);
		ibm.setNot_spam(ibmNotSpam);
		
		if(!(Double.compare(googleSpam, 0) == 0)) {
			google.setAvg_spam_score((float)round2(googleSpamAVG/googleSpam));
			
		}
		else
			google.setAvg_spam_score((float)googleSpamAVG);
		
		if(!(Double.compare(googleNotSpam, 0) == 0)) {
			google.setAvg_not_spam_score((float)round2(googleNotSpamAVG/googleNotSpam));
			
		}
		else
			google.setAvg_not_spam_score((float)googleNotSpamAVG);
		
		if(!(Double.compare(ibmSpam, 0) == 0)) {
			ibm.setAvg_spam_score((float)round2(ibmSpamAVG/ibmSpam));
		}
		else
			ibm.setAvg_spam_score((float)ibmSpamAVG);
		if(!(Double.compare(ibmNotSpam, 0) == 0)) {
			ibm.setAvg_not_spam_score((float)round2(ibmNotSpamAVG/ibmNotSpam));
		}
		else
			ibm.setAvg_not_spam_score((float)ibmNotSpamAVG);
	}
	
	public static double round2(double d) {
        long result = Math.round((d * 100));
        return (result / 100.00);
    }
}
