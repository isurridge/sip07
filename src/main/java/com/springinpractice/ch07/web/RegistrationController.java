/* 
 * Copyright (c) 2013 Manning Publications Co.
 * 
 * Book: http://manning.com/wheeler/
 * Blog: http://springinpractice.com/
 * Code: https://github.com/springinpractice
 */
package com.springinpractice.ch07.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.validation.Valid;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.hibernate.type.DateType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.format.datetime.joda.DateTimeParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springinpractice.ch07.domain.Account;
import com.springinpractice.ch07.domain.Registration;
import com.springinpractice.ch07.service.RegistrationService;

/**
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
@Controller
@RequestMapping("/events")
public class RegistrationController {
	private static final String VN_REG_FORM = "events/regForm";
	private static final String VN_EDIT_REG_FORM = "events/editRegForm";
	private static final String VN_REG_OK = "redirect:events/reg_ok.html";
	private static final Logger log = LoggerFactory
			.getLogger(RegistrationController.class);
	
	
	@Inject private RegistrationService registrationService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setAllowedFields(new String[] { 
			"username",	"firstName", "lastName", "email", "city", "contactPhone", "contactName", "travelArranger", "company", "ada",
			"breakout1", "breakout2", "breakout3", "breakout4", "breakout5", "breakout6", "breakout7", "breakout8","breakout9", "breakout10",
			"hotelArrive", "hotelDeparture", "airportArrive", "airportDeparture", "airportArriveTime", "airportDepartureTime", "incidentals", "diet", "allergies", "activities",
			"roomRequirements", "flightNumberArrive", "flightNumberDeparture", "familiarName", "roomComments", "travelComments", "oday", "firstTimeBreakfast"
		});
		
		// Converts empty string to null, which is nice since most validation rules fire only if the field isn't null.
		  binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
		//  SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
		  //dateFormat.setLenient(false);  
		//  binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));  
	}
	

	
	
	
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String getRegistrationForm(Model model) {
		
		Map<String, List<String>> map = new HashMap<String, List<String>>();
        map.putAll(loadRadioButtons());
  
        model.addAttribute("model", map );       
              
        model.addAttribute("registration", new RegistrationForm() );
    
        Object[] arr = model.asMap().values().toArray();
        
        for(int i = 0; i < arr.length; i++){        
        log.debug("Attributes Get: " + arr[i].toString() );
        
        }
		
		return VN_REG_FORM;

   
	}
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public String getRegistration(@PathVariable("username") String username, Model model) {

      
  
		Registration registration = registrationService.getRegistrationByUsername(username);
		
		if(!registration.equals(null)){
			model.addAttribute(registration);
			Map<String, List<String>> map = new HashMap<String, List<String>>();
	        map.putAll(loadRadioButtons());  
	        model.addAttribute("model", map ); 
			log.debug("My username is: " + registration.getUsername());
			return  VN_EDIT_REG_FORM;
		}
		return  "/new";
		
	}
	
	
	
	@RequestMapping(value = "/{username}", method = RequestMethod.PUT)
	public String updateRegistrationForm(
			@ModelAttribute("registration") @Valid RegistrationForm form, BindingResult result, Model model) {
			
			Map<Object, Object> map = new HashMap<Object, Object>();
	        map.putAll(loadRadioButtons());
	        model.addAttribute("model", map );       
	       
	        log.debug("Attributes Put Form: " + form.toString());
			
		registrationService.updateRegistration(toEditRegistration(form), result);
		return (result.hasErrors() ? VN_EDIT_REG_FORM : VN_REG_OK);
	}
	
	
	


	@RequestMapping(value = "", method = RequestMethod.POST)
	public String postRegistrationForm(
			@ModelAttribute("registration") @Valid RegistrationForm form, BindingResult result, Model model) {
			
			Map<Object, Object> map = new HashMap<Object, Object>();
	        map.putAll(loadRadioButtons());
	        model.addAttribute("model", map );       
	       
	        log.debug("Attributes Post Form: " + form.toString());
			
		registrationService.addRegistration(toRegistration(form), result);
		return (result.hasErrors() ? VN_REG_FORM: VN_REG_OK);
	}
	
	
	
	
	
	
	
	

	

	
	
	
	
	
	
	private Map<String, List<String>> loadRadioButtons(){
		
        Map<String, List<String>> referenceData = new HashMap<String, List<String>>();

        referenceData.put("breakout1Map", registrationService.buildSessionSelection("1"));
        referenceData.put("breakout2Map", registrationService.buildSessionSelection("2"));  
        referenceData.put("breakout3Map", registrationService.buildSessionSelection("3"));  
        referenceData.put("breakout4Map", registrationService.buildSessionSelection("4"));  
        referenceData.put("breakout5Map", registrationService.buildSessionSelection("5"));  
        referenceData.put("breakout6Map", registrationService.buildSessionSelection("6"));  
        referenceData.put("breakout7Map", registrationService.buildSessionSelection("7"));  
        referenceData.put("breakout8Map", registrationService.buildSessionSelection("8"));  
        referenceData.put("breakout9Map", registrationService.buildSessionSelection("9"));  
        referenceData.put("breakout10Map", registrationService.buildSessionSelection("10"));
        referenceData.put("incidentalsList", registrationService.loadIncidentals()); 
        referenceData.put("dietList", registrationService.loadDiet());
        referenceData.put("activitiesList", registrationService.loadActivities());
        referenceData.put("roomRequirementsList", registrationService.loadRoomRequirements());
        
		return referenceData;
		
	}

	
	

	private static Registration toRegistration(RegistrationForm form) {
	
		Registration registration = new Registration();
		registration.setUsername(form.getUsername());
		registration.setFirstName(form.getFirstName());
		registration.setFamiliarName(form.getFamiliarName());
		registration.setLastName(form.getLastName());
		registration.setEmail(form.getEmail());
		registration.setCity(form.getCity());
		registration.setCompany(form.getCompany());
		registration.setTravelArranger(form.getTravelArranger());
		registration.setAda(form.getAda());
		registration.setIncidentals(form.getIncidentals());
		registration.setContactName(form.getContactName());
		registration.setContactPhone(form.getContactPhone());
		registration.setBreakout1(form.getBreakout1());
		registration.setBreakout2(form.getBreakout2());
		registration.setBreakout3(form.getBreakout3());
		registration.setBreakout4(form.getBreakout4());
		registration.setBreakout5(form.getBreakout5());
		registration.setBreakout6(form.getBreakout6());
		registration.setBreakout7(form.getBreakout7());
		registration.setBreakout8(form.getBreakout8());
		registration.setBreakout9(form.getBreakout9());
		registration.setBreakout10(form.getBreakout10());  
		
		registration.setHotelArrive(form.getHotelArrive());
		registration.setHotelDeparture(form.getHotelDeparture());
		registration.setAirportArrive(form.getAirportArrive());
		registration.setAirportDeparture(form.getAirportDeparture());
		
		
		
		registration.setAirportArriveTime(form.getAirportArriveTime());
		registration.setAirportDepartureTime(form.getAirportDepartureTime());
		
		registration.setFlightNumberArrive(form.getFlightNumberArrive());
		registration.setFlightNumberDeparture(form.getFlightNumberDeparture());
		
		registration.setDiet(form.getDiet());
		registration.setAllergies(form.getAllergies());
		registration.setActivities(form.getActivities());
		
		registration.setRoomRequirements(form.getRoomRequirements());
		registration.setRoomComments(form.getRoomComments());
		registration.setTravelComments(form.getTravelComments());
		registration.setOday(form.getOday());		
		registration.setFirstTimeBreakfast(form.getFirstTimeBreakfast());
		return registration;
	}
	
	
	private Registration toEditRegistration(RegistrationForm form) {
		
		Registration registration = registrationService.getRegistrationByUsername(form.getUsername());
		registration.setUsername(form.getUsername());
		registration.setFirstName(form.getFirstName());
		registration.setFamiliarName(form.getFamiliarName());
		registration.setLastName(form.getLastName());
		registration.setEmail(form.getEmail());
		registration.setCity(form.getCity());
		registration.setCompany(form.getCompany());
		registration.setTravelArranger(form.getTravelArranger());
		registration.setAda(form.getAda());
		registration.setIncidentals(form.getIncidentals());
		registration.setContactName(form.getContactName());
		registration.setContactPhone(form.getContactPhone());
		registration.setBreakout1(form.getBreakout1());
		registration.setBreakout2(form.getBreakout2());
		registration.setBreakout3(form.getBreakout3());
		registration.setBreakout4(form.getBreakout4());
		registration.setBreakout5(form.getBreakout5());
		registration.setBreakout6(form.getBreakout6());
		registration.setBreakout7(form.getBreakout7());
		registration.setBreakout8(form.getBreakout8());
		registration.setBreakout9(form.getBreakout9());
		registration.setBreakout10(form.getBreakout10());  
		
		registration.setHotelArrive(form.getHotelArrive());
		registration.setHotelDeparture(form.getHotelDeparture());
		registration.setAirportArrive(form.getAirportArrive());
		registration.setAirportDeparture(form.getAirportDeparture());
		
		
		
		registration.setAirportArriveTime(form.getAirportArriveTime());
		registration.setAirportDepartureTime(form.getAirportDepartureTime());
		
		registration.setFlightNumberArrive(form.getFlightNumberArrive());
		registration.setFlightNumberDeparture(form.getFlightNumberDeparture());
		
		registration.setDiet(form.getDiet());
		registration.setAllergies(form.getAllergies());
		registration.setActivities(form.getActivities());
		
		registration.setRoomRequirements(form.getRoomRequirements());
		registration.setRoomComments(form.getRoomComments());
		registration.setTravelComments(form.getTravelComments());
		registration.setOday(form.getOday());		
		registration.setFirstTimeBreakfast(form.getFirstTimeBreakfast());
		return registration;
	}
	
	
	
	
	
}
