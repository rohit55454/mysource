package com.jlcindia.struts1;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.upload.FormFile;

public class UploadAction extends Action{
	@Override
	public ActionForward execute(ActionMapping am, ActionForm af, HttpServletRequest req, HttpServletResponse res) throws Exception {
		DynaActionForm df = (DynaActionForm)af;
		String em = (String)df.get("email");
		System.out.println(em);
		FormFile resume = (FormFile)df.get("myfile");
		String filePath = "D:/tmp";
		String fileName = resume.getFileName();
		File file = new File(filePath, fileName);
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(resume.getFileData());
		fos.flush();
		fos.close();
		req.setAttribute("fileName", fileName);
		req.setAttribute("filePath", filePath);
		
		return am.findForward("success");
	}
	

}
