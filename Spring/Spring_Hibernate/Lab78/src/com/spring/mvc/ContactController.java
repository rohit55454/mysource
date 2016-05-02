package com.spring.mvc;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.service.ContactService;
import com.spring.to.ContactTo;


@Controller
public class ContactController {

	@Autowired
	ContactCommandValidator ccValidator;
	
	@Autowired
	SearchContactCommandValidator sccValidator;
	
	@Autowired
	ContactService cs;
	
	@RequestMapping(value="/addContact.jlc")
	public String showAddContactForm(Map<String, Object> map){
		System.out.println("showAddContactForm()...");
		ContactCommand cc = new ContactCommand();
		map.put("contactCommand", cc);
		
		return "AddContactDef";
	}
	
	@RequestMapping(value="/searchContact.jlc")
	public String showSearchContactForm(Map<String, Object> map) {
		System.out.println("showSearchContactForm()....");
		SearchContactCommand scc = new SearchContactCommand();
		map.put("searchContactCommand", scc);
		
		return "SearchContactDef";
	}
	
	@RequestMapping(value="/addContactSubmit.jlc")
	public String addContact(@ModelAttribute("contactCommand") ContactCommand cc,
			Errors errors, HttpServletRequest request) {
		System.out.println("addContact()...");
		
	//	1. Do Validations	
		ccValidator.validate(cc, errors);
		if(errors.hasErrors())
			return "AddContactDef";
			
	//	2. Collect input Data
		String fn = cc.getFname();
		String ln = cc.getLname();
		String em = cc.getEmail();
		String ph = cc.getPhone();
		
	//	3. Call Business Service
		ContactTo cto = new ContactTo();
		cto.setFname(fn);
		cto.setLname(ln);
		cto.setEmail(em);
		cto.setPhone(Long.parseLong(ph));
		int cid = cs.addContact(cto);
		
	//	4.	Store data as Attribute
		cto.setCid(cid);
		request.setAttribute("CTO", cto);
		
	//	5.	return Tiles Def
		return "AddContactSuccessDef";
	}
	
	@RequestMapping(value="/editContactSubmit.jlc")
	public String editContact(Map<String, Object> map, HttpSession session) {
		System.out.println("editContact()....");
		ContactCommand cc = new ContactCommand();
		map.put("contactCommand", cc);
		session.setAttribute("EDIT", "TRUE");
		
		return "SearchResultsDef";
	}
	
	@RequestMapping(value="/updateContactSubmit.jlc")
	public String updateContact(@ModelAttribute("contactCommand") ContactCommand cc,
			Errors errors, HttpServletRequest request) {
		System.out.println("updateContact()....");
		
	//	1.	Do Validations
		ccValidator.validate(cc, errors);
		if(errors.hasErrors())
			return "SearchResultsDef";
		
	//	2.	Collect Input Data
		String cid = cc.getCid();
		String fn = cc.getFname();
		String ln = cc.getLname();
		String em = cc.getEmail();
		String ph = cc.getPhone();
		
	//	3.	Contact Business Service
		ContactTo cto = new ContactTo();
		cto.setCid(Integer.parseInt(cid));
		cto.setFname(fn);
		cto.setLname(ln);
		cto.setEmail(em);
		cto.setPhone(Long.parseLong(ph));
		cs.updateContact(cto);
		
		
	//	4.	return Tiles Def
		
		return "UpdateContactSuccessDef";
	}
	
	@RequestMapping(value="/searchContactSubmit.jlc")
	public String searchContact(@ModelAttribute("searchContactCommand") SearchContactCommand scc,
			Errors errors, HttpServletRequest request) {
		System.out.println("searchContact()....");
		
	//	1.	Do Validations
		sccValidator.validate(scc, errors);
		if(errors.hasErrors())
			return "SearchContactDef";
		
	//	2.	Collect Input Data
		String em = scc.getEmail();
	
	//	3.	Contact Business Service
		ContactTo cto = cs.getContactByEmail(em);
		if(cto == null){
			request.setAttribute("NOT_FOUND", "No records Found");
			return "SearchContactDef";
		}
		else {
	//	4.	Store Data as Attribute
			HttpSession sess = request.getSession();
			sess.setAttribute("CTO", cto);
			sess.setAttribute("EDIT", "FALSE");
		}
		
	//	5.	return Tiles Def
		
		return "SearchResultsDef";
	}
		
}
