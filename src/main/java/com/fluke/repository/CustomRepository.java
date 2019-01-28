package com.fluke.repository;

import java.sql.Connection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.internal.SessionImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.fluke.entity.Film;

@Repository
public class CustomRepository {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@PersistenceContext
	private EntityManager em;
	
	
	public Connection getConnection() {
		Session session = this.em.unwrap(Session.class);
		return ((SessionImpl) session).connection();
	}
	
	public Session getSession() {
		return this.em.unwrap(Session.class);
	}
	
	public List<Film> findFilmByRating(String rating, int page, int size, List<String> orderColumn, String direction){
		
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT * ");
		sb.append(" FROM film WHERE rating = :rating ");
		
		if(!orderColumn.isEmpty()) {
			sb.append(" ORDER BY  ");
			String cOrder = "";
			for (int i = 0; i < orderColumn.size(); i++) {
				
				String xOrder = orderColumn.get(i);
				if(0 == i) {
					cOrder += xOrder;
				} else {
					cOrder += ","+xOrder;
				}
			}
			
			cOrder += " "+direction;
			
			sb.append(cOrder);
		}
		
		int whichPage = 0;
		for (int i = 0; i <= page; i++) {
			if(i>0) {
				whichPage = whichPage+size;
			}
		}
		
		sb.append(" limit "+whichPage+","+size);	
		
		
		log.info("sql log : {} ", sb.toString());
		Query query = getSession().createNativeQuery(sb.toString(), Film.class);
		query.setParameter("rating", rating);
		
		
		List<Film> result = query.getResultList();
		
		return result;
	}
}
