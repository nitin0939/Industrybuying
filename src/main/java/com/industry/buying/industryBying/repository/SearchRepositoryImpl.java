package com.industry.buying.industryBying.repository;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.industry.buying.industryBying.model.SearchDataModel;

@Repository
public class SearchRepositoryImpl implements SearchRespository{

	@Autowired
	private SessionFactory entityManagerFactory;
	@Override
	public List<SearchDataModel> findByQuery(String query) {
		List<SearchDataModel> list=null;;
		Session session = entityManagerFactory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
		Query HQLquery = session.createQuery("FROM SearchDataModel WHERE Message like concat('%',:Message,'%')");
		HQLquery.setParameter("Message", query);
        list = HQLquery.list();
        tx.commit();	
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
		
		return list;
	}

}
