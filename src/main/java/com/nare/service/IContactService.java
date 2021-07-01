package com.nare.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.nare.entity.Contact;

@Service
public interface IContactService{

	public Boolean saveContact(Contact contact);

	 public List<Contact> findAllContacts(); 
	public Page<Contact> findAllContactsNew(Integer pageNo,Integer pageSize);
	public Contact getContactByID(Integer id);
	public Boolean deleteContact(Integer id);

	
	

}
