/* 
 * Copyright (c) 2013 Manning Publications Co.
 * 
 * Book: http://manning.com/wheeler/
 * Blog: http://springinpractice.com/
 * Code: https://github.com/springinpractice
 */
package com.springinpractice.ch07.service;

import java.util.List;

import org.springframework.validation.Errors;

import com.springinpractice.ch07.domain.Registration;

/**
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
public interface RegistrationService {

	boolean addRegistration(Registration registration, Errors errors);
	List<String> buildSessionSelection(String fieldName);
    List<String> loadIncidentals();
    List<String> loadDiet();
	List<String> loadActivities();
	
	List<String> loadRoomRequirements();
}
