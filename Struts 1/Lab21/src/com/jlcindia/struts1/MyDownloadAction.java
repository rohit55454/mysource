package com.jlcindia.struts1;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DownloadAction;
import org.apache.struts.validator.DynaValidatorForm;

public class MyDownloadAction extends DownloadAction{

	@Override
	protected StreamInfo getStreamInfo(ActionMapping am, ActionForm af, HttpServletRequest req, HttpServletResponse res) throws Exception {
		ServletContext ctx = req.getSession().getServletContext();
		DynaValidatorForm df = (DynaValidatorForm)af;
		String fileName = df.get("filename").toString();
		System.out.println(fileName);
		
		String path = ctx.getRealPath("/WEB-INF/files/");
		File file = new File(path+"/"+fileName);
		String contentType = ctx.getMimeType(file.getName());
		
		if(contentType == null)
			contentType = "application/octet-stream";
		
		// to open in browser
		res.setHeader("Content-disposition", "inline;filename="+fileName);
		// to download
		//res.setHeader("Content-disposition", "attachment;filename="+fileName);
		res.setContentLength((int)file.length());
		
		return new FileStreamInfo(contentType, file);
	}

}
