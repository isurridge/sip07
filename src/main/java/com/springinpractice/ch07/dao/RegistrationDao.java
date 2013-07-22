/* 
 * Copyright (c) 2013 Manning Publications Co.
 * 
 * Book: http://manning.com/wheeler/
 * Blog: http://springinpractice.com/
 * Code: https://github.com/springinpractice
 */
package com.springinpractice.ch07.dao;

import com.springinpractice.ch07.domain.Registration;
import com.springinpractice.dao.Dao;

/**
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
public interface RegistrationDao extends Dao<Registration> {
	
	void create(Registration registration);
	
	Registration findByUsername(String username);
}
