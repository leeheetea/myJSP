package com.kedu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdditonalServlet01
 */
@WebServlet("/add")
public class AdditonalServlet01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		int num1 = 20;
		int num2 = 10;
		int add = num1 + num2;
		PrintWriter printWriter = response.getWriter();
		printWriter.println("<html><head><title>additon</title></head>");
		printWriter.println("<body>");
		printWriter.println("<h1>계산기</h1>");
		printWriter.print(num1 + " + " + num2 + " = " + add);
		printWriter.println("</body></html>");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
