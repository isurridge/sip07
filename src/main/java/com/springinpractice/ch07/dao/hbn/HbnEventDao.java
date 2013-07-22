/* 
 * Copyright (c) 2013 Manning Publications Co.
 * 
 * Book: http://manning.com/wheeler/
 * Blog: http://springinpractice.com/
 * Code: https://github.com/springinpractice
 */
package com.springinpractice.ch07.dao.hbn;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springinpractice.ch07.dao.EventDao;
import com.springinpractice.ch07.domain.Event;
import com.springinpractice.dao.hibernate.AbstractHbnDao;

/**
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
@Repository
public class HbnEventDao extends AbstractHbnDao<Event> implements EventDao {
	private static final Logger LOG = LoggerFactory.getLogger(HbnEventDao.class);
	
	private static final String SELECT_BKSESSIONS_SQL =
		"select session_title, session_slot from event where session_type = ?";
	
	private static final String SELECT_ACTIVITIES_SQL =
			"select session_title from event  where session_type  = ?";
		

	
	@Inject private JdbcTemplate jdbcTemplate;
	
	public void create(Event event) {
		LOG.debug("Creating Event");
		create(event);
		
	}

	public List<Event> findAllBreakouts(){
		 
		List<Event> breakouts = new ArrayList<Event>();
	 
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(SELECT_BKSESSIONS_SQL, "breakout");
		for (Map row : rows) {
			Event event = new Event();
			event.setSessionTitle((String)row.get("session_title"));
			event.setSessionSlot((String)row.get("session_slot"));
			breakouts.add(event);
		}
	 
		return breakouts;
	}

	
	public List<Event> findAllActivities(){
		 
		List<Event> activities = new ArrayList<Event>();
	 
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(SELECT_ACTIVITIES_SQL, "activity");
		for (Map row : rows) {
			Event event = new Event();
			event.setSessionTitle((String)row.get("session_title"));
			activities.add(event);
		}
	 
		return activities;
	}
	
	
	
	
	
	
	
	@Override
	public Event findById(String id) {
		Query q = getSession().getNamedQuery("findEventById");
		q.setParameter("id", id);
		return (Event) q.uniqueResult();
	}
}
