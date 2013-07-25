/* 
 * Copyright (c) 2013 Manning Publications Co.
 * 
 * Book: http://manning.com/wheeler/
 * Blog: http://springinpractice.com/
 * Code: https://github.com/springinpractice
 */
package com.springinpractice.ch07.dao.hbn;

import javax.inject.Inject;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springinpractice.ch07.dao.RegistrationDao;
import com.springinpractice.ch07.domain.Registration;
import com.springinpractice.dao.hibernate.AbstractHbnDao;

/**
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
@Repository
public class HbnRegistrationDao extends AbstractHbnDao<Registration> implements
		RegistrationDao {
	private static final Logger LOG = LoggerFactory
			.getLogger(HbnRegistrationDao.class);
	
	
	//private static final String UPDATE_HOTELARRIVE_SQL =
	//		"update registration set hotel_Arrive = ? where username = ?";
		
	//@Inject private JdbcTemplate jdbcTemplate;
	
	
	
	
	
	/*
	
	public void update(Registration registration) {
		LOG.debug("Updating Registration");
		update(registration);
	}

	public void create(Registration registration) {
		LOG.debug("Creating Registration");
		create(registration);

	}
	*/


	public Registration findByUsername(String username) {
		Query q = getSession().getNamedQuery("findRegistrationByUsername");
		q.setParameter("username", username);
		return (Registration) q.uniqueResult();
	}
}
