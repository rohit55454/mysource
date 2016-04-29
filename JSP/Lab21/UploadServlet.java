package com.jlc.servlet;

import java.io.IOException;
import java.io.Writer;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name="uploadServlet", urlPatterns={"/upload.jlc"})
@MultipartConfig(location="C:/uploaded", fileSizeThreshold=1024*1024*10, maxFileSize=1024*1024*50)

public class UploadServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Collection<Part> parts = req.getParts();
		for(Part part : parts){
			System.out.println("Name : "+part.getName());
			System.out.println("Header : ");
			for(String headerName : part.getHeaderNames()){
				System.out.println(headerName+"\t\t"+part.getHeader(headerName));
			}
			String fileInfo = part.getHeader("content-disposition");
			String fnames[] = fileInfo.split("\"");
			String fname = fnames[fnames.length - 1];
			
			System.out.println("Size : "+ part.getSize());
			part.write(fname);
		}
		Writer out = res.getWriter();
		out.write("<h1>File uploaded to D:\\uploaded");
	}
}
