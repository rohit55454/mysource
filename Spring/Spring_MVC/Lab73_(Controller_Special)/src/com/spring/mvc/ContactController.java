package com.spring.mvc;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes
public class ContactController {

	@Autowired
	ContactCommandValidator ccValidator;

	@Autowired
	SearchContactCommandValidator sscValidator;

	@RequestMapping(value = "/addContact.jlc")
	public String showAddContactForm(Map<String, Object> map) {
		System.out.println("showAddContactForm()....");
		ContactCommand cc = new ContactCommand();
		map.put("contactCommand", cc);
		return "addContact";

	}

	@RequestMapping(value = "/searchContact.jlc")
	public String showSearchContactForm(Map<String, Object> map) {
		System.out.println("showSearchContactForm()....");
		SearchContactCommand ssc = new SearchContactCommand();
		map.put("searchContactCommand", ssc);
		return "searchContact";
	}

	@RequestMapping(value = "/addContactSubmit.jlc")
	public String addContact(@ModelAttribute("contactCommand") ContactCommand cc, Errors errors,
			HttpServletRequest request) {
		System.out.println("addContact()....");
		ccValidator.validate(cc, errors);
		if (errors.hasErrors())
			return "addContact";

		String fn = cc.getFname();
		String ln = cc.getLname();
		String em = cc.getEmail();
		String ph = cc.getPhone();

		System.out.println(fn);
		System.out.println(ln);
		System.out.println(em);
		System.out.println(ph);

		ContactTo cto = new ContactTo();
		cto.setFname(fn);
		cto.setLname(ln);
		cto.setEmail(em);
		cto.setPhone(ph);

		request.setAttribute("CTO", cto);

		return "addContactSuccess";
	}

	@RequestMapping(value = "/searchContactSubmit.jlc")
	public String searchContact(@ModelAttribute("searchContactCommand") SearchContactCommand ssc, Errors errors,
			HttpServletRequest request) {
		System.out.println("searchContact()....");
		sscValidator.validate(ssc, errors);

		if (errors.hasErrors())
			return "searchContact";

		String em = ssc.getEmail();
		System.out.println(em);

		ContactTo cto = new ContactTo();
		cto.setFname("rohit");
		cto.setLname("sachan");
		cto.setEmail(em);
		cto.setPhone("999999");

		HttpSession sess = request.getSession();
		sess.setAttribute("CTO", cto);
		sess.setAttribute("EDIT", "FALSE");

		return "searchResults";
	}

	@RequestMapping(value = "/updateContactSubmit.jlc")
	public String updateContact(@ModelAttribute("contactCommand") ContactCommand cc, Errors errors,
			HttpServletRequest request) {
		System.out.println("updateContact()....");

		ccValidator.validate(cc, errors);
		if (errors.hasErrors())
			return "searchResults";

		String fn = cc.getFname();
		String ln = cc.getLname();
		String em = cc.getEmail();
		String ph = cc.getPhone();

		System.out.println(fn);
		System.out.println(ln);
		System.out.println(em);
		System.out.println(ph);

		ContactTo cto = new ContactTo();
		cto.setFname(fn);
		cto.setLname(ln);
		cto.setEmail(em);
		cto.setPhone(ph);

		request.setAttribute("CTO", cto);

		return "updateContactSuccess";
	}

	@RequestMapping(value = "/editContactSubmit.jlc")
	public String editContact(Map<String, Object> map, HttpSession sess) {

		System.out.println("editContact()....");
		ContactCommand cc = new ContactCommand();
		map.put("contactCommand", cc);
		sess.setAttribute("EDIT", "TRUE");

		return "searchResults";
	}

}
