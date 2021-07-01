package com.nare.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nare.constants.Constants;
import com.nare.entity.Contact;

import com.nare.service.IContactService;

@Controller
public class ContactsEditDeleteontroller {

	@Autowired
	public IContactService cs;
	@Autowired
	public ContactInfoController controller;

	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam("contact_id") Integer contact_id, ModelAndView m) {
		Contact contactByID = cs.getContactByID(contact_id);

		m.addObject(contactByID);
		m.setViewName(Constants.contactId);

		return m;
	}

	@RequestMapping("/delete")
	public ModelAndView delete(@RequestParam("contact_id") Integer contact_id, ModelAndView m) {
		 cs.deleteContact(contact_id);
		ModelAndView viewContacts = controller.viewContacts(null);
		return viewContacts;
	}

}
