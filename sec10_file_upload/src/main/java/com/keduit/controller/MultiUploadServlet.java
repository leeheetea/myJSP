package com.keduit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/MultiUpload.do")
public class MultiUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset='UTF-8'");
		PrintWriter w = response.getWriter();
		
		String savePath = "upload";
		String encType = "UTF-8";
		final int UPLOADFILESIZELIMIT = 5 * 1024 * 1024;
		
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		
		MultipartRequest multi = new MultipartRequest(
				request, 
				uploadFilePath,
				UPLOADFILESIZELIMIT,
				encType,
				new DefaultFileRenamePolicy()				
				);
		Enumeration<String> files = multi.getFileNames();
		while(files.hasMoreElements()) {
			String file = files.nextElement();
			String fileName = multi.getFilesystemName(file);
			String originFileName = multi.getOriginalFileName(file);
			
			w.println("<br> 업로드 된 파일명 : " + fileName);
			w.println("<br> 원본 파일명 : " + originFileName);
			w.println("<hr>");
		}
				
	}

}
