package com.kim.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.openid.kim.data.PageCriteria;

/**
 * 
 * @author dream reference mfranklin
 *
 */
public class JpaUtil {

	public static <T> T getSingleResult(List<T> list) {
		switch(list.size()) {
			case 0:
				return null;
			case 1:
				return list.get(0);
			default:
				throw new IllegalStateException("Expected single result, got " + list.size());
		}
		
	}
	

	/**
	 * Get a page of results from the specified TypedQuery
	 * by using the given PageCriteria to limit the query
	 * results. The PageCriteria will override any size or
	 * offset already specified on the query. 
	 * 
	 * @param query
	 * @param pageCriteria
	 * @return
	 */
	public static <T> List<T> getResultPage(TypedQuery<T> query, PageCriteria pageCriteria){
		query.setMaxResults(pageCriteria.getPageSize());
		query.setFirstResult( pageCriteria.getPageNumber()*pageCriteria.getPageSize());
		return query.getResultList();
	}
	
	public static <T> T saveOrUpdate(EntityManager entityManager , T entity) {
		T temp = entityManager.merge( entity );
		entityManager.flush();
		return temp;
	}
}
