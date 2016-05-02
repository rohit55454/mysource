package com.spring.mvc;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

	@RequestMapping(value="/uploadfile.jlc", method=RequestMethod.POST)
	public @ResponseBody String uploadFile(@RequestParam("name") String name, 
			@RequestParam("file") MultipartFile file) {
		
		String msg = "";
		
		if(file.isEmpty())
			msg = "selected file is empty";
		else {
			try{
				byte[] data = file.getBytes();
				File dir = new File("D:/files");
				if(!dir.exists())	dir.mkdirs();
				File f = new File(dir, file.getOriginalFilename());
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(f));
				stream.write(data);
				stream.close();
				msg = "File Uploaded Successfully "+f.getAbsolutePath();
				
			}catch (Exception e) {
				e.printStackTrace();
				msg = "error in uploading file";
			}
		
		}
		return msg;
	}
	
	
}
