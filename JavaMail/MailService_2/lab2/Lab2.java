package com.jlc.lab2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.jlc.service.MailService;

public class Lab2 {
	public static void main(String[] args) {
		String to = "rohitsachan3333@gmail.com";
		String sub = "Test mail from JLCINDIA";
		String data = "<font color='red' size='6'> This is message from Java Mail sent to rohitsachan3333@gmail.com</font>";
		
		List<File> files = new ArrayList<File>();
		files.add(new File("C:\\pics\\Desert.jpg"));
		files.add(new File("C:\\pics\\Koala.jpg"));
		files.add(new File("C:\\pics\\Lighthouse.jpg"));
		files.add(new File("C:\\pics\\Tulips.jpg"));
		
		MailService.sendMailWithAttachment(to, sub, data, files);
		System.out.println("mail sent");
		
	}
}
