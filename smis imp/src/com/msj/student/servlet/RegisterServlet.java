package com.msj.student.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  req.setCharacterEncoding("UTF-8");
	  boolean isMultipart = ServletFileUpload.isMultipartContent(req);
	  if(!isMultipart){
		  return;
	  }
	  try {
		  // Create a factory for disk-based file items
	  FileItemFactory factory = new DiskFileItemFactory();
	  // Create a new file upload handler
	  ServletFileUpload upload = new ServletFileUpload(factory);
	  // Parse the request
		@SuppressWarnings("unchecked")
		List<FileItem>items = upload.parseRequest(req);
		for (FileItem fileItem : items) {
			if(fileItem.isFormField()){
				System.out.println(fileItem.getFieldName());
			}else{
				String fileName = UUID.randomUUID().toString();
				String extension = FilenameUtils.getExtension(fileItem.getName());
				String realPath = req.getServletContext().getRealPath("/upload");
				fileItem.write(new File(realPath,fileName+"."+extension));
				
			}
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
}
}
