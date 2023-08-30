package ch03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/MyServlet2")
public class MyServlet2 extends HttpServlet {
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter outPrintWriter = response.getWriter();
		outPrintWriter.println("<html>");
		outPrintWriter.println("<head>");
		outPrintWriter.println("<title>MyServelt</title>");
		outPrintWriter.println("</head>");
		outPrintWriter.println("<body>");
		outPrintWriter.println("<h1>파이팅 코리아</h1>");
		outPrintWriter.println("</body>");
		outPrintWriter.println("</html>");
	}
}
