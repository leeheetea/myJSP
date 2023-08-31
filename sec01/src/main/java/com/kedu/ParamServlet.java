package com.kedu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ParamServlet")
public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String userId = request.getParameter("id");
		System.out.println(request.getParameter("age"));
		int age = Integer.parseInt(request.getParameter("age"));
		
		PrintWriter printWriter = response.getWriter();
		printWriter.println("<html><head></head><body>");
		printWriter.println("당신이 입력한 자료 입니다.<br>");
		printWriter.print("아이디 : ");
		printWriter.println(userId);
		printWriter.print("나이 : ");
		printWriter.println(age);
		printWriter.println("<br><a href=javascript:history.go(-1)>다시입력</a>");
		printWriter.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		String userId = request.getParameter("id");
		System.out.println(request.getParameter("age"));
		int age = Integer.parseInt(request.getParameter("age"));
		
		PrintWriter printWriter = response.getWriter();
		printWriter.println("<html><head></head><body>");
		printWriter.println("당신이 입력한 자료 입니다.<br>");
		printWriter.print("아이디 : ");
		printWriter.println(userId);
		printWriter.print("나이 : ");
		printWriter.println(age);
		printWriter.println("<br><a href=javascript:history.go(-1)>다시입력</a>");
		printWriter.println("</body></html>");
		
	}
	

}
