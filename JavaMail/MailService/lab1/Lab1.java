package com.jlc.lab1;
import com.jlc.service.MailService;

public class Lab1 {
	public static void main(String[] args) {
		String to = "rohitsachan3333@gmail.com";
		String sub = "Test mail from JLCINDIA";
		String data = "<font color='red' size='6'> This is message from Java Mail</font>";
		MailService.sendMail(to, sub, data);
		System.out.println("**** mail sent ****");
	}
}
