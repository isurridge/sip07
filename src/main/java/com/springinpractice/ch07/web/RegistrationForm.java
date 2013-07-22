/* 
 * Copyright (c) 2013 Manning Publications Co.
 * 
 * Book: http://manning.com/wheeler/
 * Blog: http://springinpractice.com/
 * Code: https://github.com/springinpractice
 */
package com.springinpractice.ch07.web;

import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
// Requires scripting engine (e.g. Rhino included automatically with Java 6)

public class RegistrationForm {
	private String username, firstName, lastName, email, city, contactPhone,
			contactName, travelArranger, company, ada, breakout1, breakout2, breakout3, breakout4, breakout5,
			breakout6, breakout7, breakout8, breakout9, breakout10, incidentals, diet, allergies, activities, 
			airportArriveTime, airportDepartureTime, roomRequirements, flightNumberArrive, flightNumberDeparture, familiarName, hotelArrive, hotelDeparture,
			roomComments, travelComments, oday, firstTimeBreakfast, airportArrive, airportDeparture;
	

	@NotNull
	@Size(min = 1, max = 50)
	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	@NotNull
	@Size(min = 1, max = 50)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "familiar_name")
	public String getFamiliarName() {
		return familiarName;
	}

	public void setFamiliarName(String familiarName) {
		this.familiarName = familiarName;
	}	
	
	
	
	@NotNull
	@Size(min = 1, max = 50)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@NotNull
	@Size(min = 1, max = 50)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@NotNull
	@Size(min = 6, max = 50)
	@Email
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Size(min = 1, max = 50)
	@Column(name = "company")
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Size(min = 6, max = 50)
	@Email
	@Column(name = "travel_arranger")
	public String getTravelArranger() {
		return travelArranger;
	}

	public void setTravelArranger(String travelArranger) {
		this.travelArranger = travelArranger;
	}

	@Size(min = 1, max = 500)
	@Column(name = "ada")
	public String getAda() {
		return ada;
	}

	public void setAda(String ada) {
		this.ada = ada;
	}

	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "contact_name")
	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "contact_phone")
	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	
	
	
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "incidentals")
	public String getIncidentals() {
		return incidentals;
	}

	public void setIncidentals(String incidentals) {
		this.incidentals = incidentals;
	}

	@Column(name = "breakout1")
	public String getBreakout1() {
		return breakout1;
	}

	public void setBreakout1(String breakout1) {
		this.breakout1 = breakout1;
	}

	@Column(name = "breakout2")
	public String getBreakout2() {
		return breakout2;
	}

	public void setBreakout2(String breakout2) {
		this.breakout2 = breakout2;
	}

	@Column(name = "breakout3")
	public String getBreakout3() {
		return breakout3;
	}

	public void setBreakout3(String breakout3) {
		this.breakout3 = breakout3;
	}

	@Column(name = "breakout4")
	public String getBreakout4() {
		return breakout4;
	}

	public void setBreakout4(String breakout4) {
		this.breakout4 = breakout4;
	}

	@Column(name = "breakout5")
	public String getBreakout5() {
		return breakout5;
	}

	public void setBreakout5(String breakout5) {
		this.breakout5 = breakout5;
	}

	@Column(name = "breakout6")
	public String getBreakout6() {
		return breakout6;
	}

	public void setBreakout6(String breakout6) {
		this.breakout6 = breakout6;
	}

	@Column(name = "breakout7")
	public String getBreakout7() {
		return breakout7;
	}

	public void setBreakout7(String breakout7) {
		this.breakout7 = breakout7;
	}

	@Column(name = "breakout8")
	public String getBreakout8() {
		return breakout8;
	}

	public void setBreakout8(String breakout8) {
		this.breakout8 = breakout8;
	}

	@Column(name = "breakout9")
	public String getBreakout9() {
		return breakout9;
	}

	public void setBreakout9(String breakout9) {
		this.breakout9 = breakout9;
	}

	@Column(name = "breakout10")
	public String getBreakout10() {
		return breakout10;
	}

	public void setBreakout10(String breakout10) {
		this.breakout10 = breakout10;
	}

	
	
	
	
	@NotNull
	//@DateTimeFormat(pattern="#{messages['date_format']}")
	@Column(name = "hotel_arrive")
	public String getHotelArrive() {
		return hotelArrive;
	}

	public void setHotelArrive(String hotelArrive) {
		this.hotelArrive = hotelArrive;
	}

	@NotNull
	//@DateTimeFormat(pattern="#{messages['date_format']}")
	@Column(name = "hotel_departure")
	public String getHotelDeparture() {
		return hotelDeparture;
	}

	public void setHotelDeparture(String hotelDeparture) {
		this.hotelDeparture = hotelDeparture;
	}
	
	
	
	
	
	
	


  
	//@DateTimeFormat(pattern="#{messages['date_format']}")
	@Column(name = "airport_arrive")
	public String getAirportArrive() {
		return airportArrive;
	}

	public void setAirportArrive(String airportArrive) {
		this.airportArrive = airportArrive;
	}


	//@DateTimeFormat(pattern="#{messages['date_format']}")
	@Column(name = "airport_departure")
	public String getAirportDeparture() {
		return airportDeparture;
	}

	public void setAirportDeparture(String airportDeparture) {
		this.airportDeparture = airportDeparture;
	}

	


	@Column(name = "airport_arrive_time")
	public String getAirportArriveTime() {
		return airportArriveTime;
	}

	public void setAirportArriveTime(String airportArriveTime) {
		this.airportArriveTime = airportArriveTime;
	}

	@Column(name = "airport_departure_time")
	public String getAirportDepartureTime() {
		return airportDepartureTime;
	}

	public void setAirportDepartureTime(String airportDepartureTime) {
		this.airportDepartureTime = airportDepartureTime;
	}	
	
	
	

	@Size(min = 1, max = 100)
	@Column(name = "room_requirements")
	public String getRoomRequirements() {
		return roomRequirements;
	}

	public void setRoomRequirements(String roomRequirements) {
		this.roomRequirements = roomRequirements;
	}
	
	
	@Size(min = 1, max = 500)
	@Column(name = "room_comments")
	public String getRoomComments() {
		return roomComments;
	}

	public void setRoomComments(String roomComments) {
		this.roomComments = roomComments;
	}
	
	
	
	@Size(min = 1, max = 100)
	@Column(name = "diet")
	public String getDiet() {
		return diet;
	}

	public void setDiet(String diet) {
		this.diet = diet;
	}
	
	

	
	@Size(min = 1, max = 500)
	@Column(name = "travel_comments")
	public String getTravelComments() {
		return travelComments;
	}

	public void setTravelComments(String travelComments) {
		this.travelComments = travelComments;
	}
	
	
	@Size(min = 1, max = 250)
	@Column(name = "allergies")
	public String getAllergies() {
		return allergies;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}
	

	@Size(min = 1, max = 100)
	@Column(name = "activities")
	public String getActivities() {
		return activities;
	}

	public void setActivities(String activities) {
		this.activities = activities;
	}
	
	
	
	
	@Size(min = 1, max = 100)
	@Column(name = "flight_number_arrive")
	public String getFlightNumberArrive() {
		return flightNumberArrive;
	}

	public void setFlightNumberArrive(String flightNumberArrive) {
		this.flightNumberArrive = flightNumberArrive;
	}
	
	@Size(min = 1, max = 100)
	@Column(name = "flight_number_departure")
	public String getFlightNumberDeparture() {
		return flightNumberDeparture;
	}

	public void setFlightNumberDeparture(String flightNumberDeparture) {
		this.flightNumberDeparture = flightNumberDeparture;
	}
	
	
	
	
	
	
	@Size(min = 1, max = 100)
	@Column(name = "oday")
	public String getOday() {
		return oday;
	}

	public void setOday(String oday) {
		this.oday = oday;
	}
	
	@Size(min = 1, max = 100)
	@Column(name = "first_time_breakfast")
	public String getFirstTimeBreakfast() {
		return firstTimeBreakfast;
	}

	public void setFirstTimeBreakfast(String firstTimeBreakfast) {
		this.firstTimeBreakfast = firstTimeBreakfast;
	}
	

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.append("username", username).append("firstName", firstName)
				.append("lastName", lastName).append("email", email)
				.append("city", city).append("company", company)
				.append("travelArranger", travelArranger).append("ada", ada)
				.append("incidentals", incidentals)
				.append("contactName", contactName)
				.append("contactPhone", contactPhone)
				.append("breakout1", breakout1).append("breakout2", breakout2)
				.append("breakout3", breakout3).append("breakout4", breakout4)
				.append("breakout5", breakout5).append("breakout6", breakout6)
				.append("breakout7", breakout7).append("breakout8", breakout8)
				.append("breakout9", breakout9)
				.append("breakout10", breakout10)
				.append("hotelArrive", hotelArrive)
				.append("hotelDeparture", hotelDeparture)
				.append("airportArrive", airportArrive)
				.append("airportDeparture", airportDeparture)
				.append("diet", diet)
				.append("allergies", allergies)
				.append("activities", activities)
				.append("flightNumberArrive", flightNumberArrive)
				.append("flightNumberDeparture", flightNumberDeparture)
				.append("familiarName", familiarName)
				.append("roomComments", roomComments)
				
				.append("travelComments", travelComments)
			
				.append("oday", oday)
				.append("firstTimeBreakfast", firstTimeBreakfast)
				.toString();
	}
}
