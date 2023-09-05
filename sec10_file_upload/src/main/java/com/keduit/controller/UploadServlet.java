package com.keduit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/upload.do")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
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
				new DefaultFileRenamePolicy());
		
		String fileName = multi.getFilesystemName("uploadFile");
		if (fileName == null) {
			System.out.println("파일이 업로드 되지 않았습니다.");
		}
		else {
			w.println("<br> 글쓴이 : " + multi.getParameter("name"));
			w.println("<br> 제목 : " + multi.getParameter("title"));
			w.println("<br> 파일명 : " + fileName);
		}
		
	}

}
