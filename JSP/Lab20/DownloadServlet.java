package com.jlc.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String fname = req.getParameter("filename");
		String path = req.getRealPath("/");
		path = path + "WEB-INF/files";
		File dir = new File(path);
		File file = new File(dir, fname);
		
		String mimeType = getServletContext().getMimeType(file.getName());
		if(mimeType == null){
			mimeType = "application/octet-stream";
		}
		res.setContentType(mimeType);
		res.setContentLength((int)file.length());
	//	attachment;filename = "java 7.pdf"
		if(file.getName().endsWith(".mp3")){
			res.addHeader("Content-Disposition", "attachment;filename=\""+file.getName()+"\"");
		}else{
			res.addHeader("Content-Disposition", "attachment;filename=\""+file.getName()+"\"");
		}
		
		OutputStream out = res.getOutputStream();
		FileInputStream fis = new FileInputStream(file);
		while(true){
			int ab = fis.read();
			if(ab == -1) break;
			out.write(ab);
		}
	}
}
