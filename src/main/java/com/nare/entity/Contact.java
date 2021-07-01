package com.nare.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name="CONTACTS")
public class Contact {
	@GeneratedValue
	@Id
	@Column(name="CONTACT_ID")
	private Integer contact_id;
	@Column(name="CONTACT_NAME")
	private String Contact_name;
	@Column(name="CONTACT_NUMBER")
	private Long mobileNumber;
	@Column(name="CONACT_EMAIL")
	private String email;
	@Column(name="ACTIVE_SW")
	private  String activesw;
	@CreationTimestamp
	@Column(name="CONTACT_CREATE_DATE", updatable=false)
	private LocalDate insertDate;
	@UpdateTimestamp
	@Column(name="CONTACT_UPDATE_DATE", insertable = false)
	private LocalDate upDate;
	public Integer getContact_id() {
		return contact_id;
	}
	public void setContact_id(Integer contact_id) {
		this.contact_id = contact_id;
	}
	public String getContact_name() {
		return Contact_name;
	}
	public void setContact_name(String contact_name) {
		Contact_name = contact_name;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getActivesw() {
		return activesw;
	}
	public void setActivesw(String activesw) {
		this.activesw = activesw;
	}
	public LocalDate getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(LocalDate insertDate) {
		this.insertDate = insertDate;
	}
	public LocalDate getUpDate() {
		return upDate;
	}
	public void setUpDate(LocalDate upDate) {
		this.upDate = upDate;
	}
	@Override
	public String toString() {
		return "Contact [contact_id=" + contact_id + ", Contact_name=" + Contact_name + ", mobileNumber=" + mobileNumber
				+ ", email=" + email + ", activesw=" + activesw + ", insertDate=" + insertDate + ", upDate=" + upDate
				+ "]";
	}

	
	
	
 
}
