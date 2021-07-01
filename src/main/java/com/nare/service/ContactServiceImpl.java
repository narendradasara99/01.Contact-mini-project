package com.nare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nare.entity.Contact;
import com.nare.repository.ContactRepo;

@Service
public class ContactServiceImpl implements IContactService {

	public ContactServiceImpl() {
		
	}

	@Autowired
	public ContactRepo contactRepo;

	@Override
	public Boolean saveContact(Contact contact) {
		contact.setActivesw("Y");

		if ( contact.getContact_name() != null) {
			 contactRepo.save(contact);
			return true;

		}
		return false;
	}

	
	  @Override public List<Contact> findAllContacts() {
	  
	  Contact contactfilter=new Contact(); 
	  contactfilter.setActivesw("Y");
	  Example<Contact> of = Example.of(contactfilter);
	  
	  
	  

	  
	  return contactRepo.findAll(of); }
	 

	@Override
	public Page<Contact> findAllContactsNew(Integer pageNo, Integer pageSize) {

		Contact contactfilter = new Contact();
		contactfilter.setActivesw("Y");
		Example<Contact> of = Example.of(contactfilter);
		
		
		PageRequest of2 = PageRequest.of(pageNo-1, pageSize);

		
		

		return contactRepo.findAll(of, of2);
	}

	@Override
	public Contact getContactByID(Integer id) {
		Optional<Contact> byId = contactRepo.findById(id);
		if (byId.isPresent()) {
			return byId.get();
		}
		return null;
	}

	@Override
	public Boolean deleteContact(Integer id) {
		/*
		 * boolean existsById = con.existsById(id); if(existsById) { con.deleteById(id);
		 * return true; } return false;
		 */

		Optional<Contact> findById = contactRepo.findById(id);
		if (findById.isPresent()) {
			Contact contact = findById.get();
			contact.setActivesw("N");
			contactRepo.save(contact);
			return true;
		}
		return false;

	}




}
