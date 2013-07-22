/* 
 * Copyright (c) 2013 Manning Publications Co.
 * 
 * Book: http://manning.com/wheeler/
 * Blog: http://springinpractice.com/
 * Code: https://github.com/springinpractice
 */
package com.springinpractice.ch07.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/**
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
@NamedQuery(
	name = "findEventById",
	query = "from Event where id = :id")
@Entity
@Table(name = "event")
public class Event {
	private Long id;
	private String chairName, email, sessionTitle, sessionDesc, sessionSlot;
	private Date dateCreated;
	private String interest;
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long getId() { return id; }
	
	@SuppressWarnings("unused")
	private void setId(Long id) { this.id = id; }
	
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "chair_name")
	public String getChairName() { return chairName; }

	public void setChairName(String chairName) { this.chairName = chairName; }
	


	@Size(min = 6, max = 50)
	@Email
	@Column(name = "email")
	public String getEmail() { return email; }

	public void setEmail(String email) { this.email = email; }
	
	
	

	@Size(min = 1, max = 50)
	@Column(name = "session_title")
	public String getSessionTitle() { return sessionTitle; }
	
	public void setSessionTitle(String sessionTitle) { this.sessionTitle = sessionTitle; }
	
	
	@Size(min = 1, max = 50)
	@Column(name = "session_desc")
	public String getSessionDesc() { return sessionDesc; }
	
	public void setSessionDesc(String sessionDesc) { this.sessionDesc = sessionDesc; }

	@Size(min = 1, max = 50)
	@Column(name = "session_slot")
	public String getSessionSlot() { return sessionSlot; }
	
	public void setSessionSlot(String sessionSlot) { this.sessionSlot = sessionSlot; }

	
	
	@Column(name = "date_created")
	public Date getDateCreated() { return dateCreated; }
	
	public void setDateCreated(Date dateCreated) { this.dateCreated = dateCreated; }
}
