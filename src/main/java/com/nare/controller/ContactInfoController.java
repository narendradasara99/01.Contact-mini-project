package com.nare.controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import com.nare.constants.Constants;
import com.nare.entity.Contact;
import com.nare.service.IContactService;

@Controller
public class ContactInfoController {
	@Autowired
	public IContactService cs;
	
	@RequestMapping("/load")
	public String loadForm(Contact c, Model m) {

		m.addAttribute(Constants.contactId, c);
		return Constants.contactId;
	}

	@RequestMapping("/savecontact")
	public String saveContact(Contact c, Model m) {

		

		if (c != null && !"".equals( c.getContact_name())&&c.getMobileNumber()!=null&& !"".equals( c.getEmail())) {
			cs.saveContact(c);
			  Contact c1 = new Contact();
			m.addAttribute(Constants.contactId, c1);
			m.addAttribute("msg", "succesfully  saved contact");

		} else {
			m.addAttribute("msg", " contact not saved , pls fil all  the fields properly");

		}

		return Constants.contactId;

	}

	/*
	 * @GetMapping("/viewcontacts") public ModelAndView viewContacts(HttpServlet h)
	 * { ModelAndView modelAndView = new ModelAndView(); List<Contact>
	 * findAllContacts = cs.findAllContacts(); modelAndView.addObject("contacts",
	 * findAllContacts); modelAndView.setViewName("viewcontacts"); return
	 * modelAndView; }
	 */

	@GetMapping("/viewcontacts")
	public ModelAndView viewContacts(HttpServletRequest req) {

		

		ModelAndView modelAndView = new ModelAndView();
		Integer pageSize = 2;
		Integer pageNo = 1;
		if(req!=null) {
		String parameter = req.getParameter("pno");
		if (parameter != null && !"".equals(parameter)) {
			pageNo = Integer.parseInt(parameter);
		}}
		Page<Contact> findAllContact = cs.findAllContactsNew(pageNo, pageSize);
		int totalPages = findAllContact.getTotalPages();
		List<Contact> findAllContacts = findAllContact.getContent();
		modelAndView.addObject("contacts", findAllContacts);
		modelAndView.setViewName("viewcontacts");
		modelAndView.addObject("pno", totalPages);

		modelAndView.addObject("curno", pageNo);
		return modelAndView;
	}
}
