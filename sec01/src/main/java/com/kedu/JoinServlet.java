package com.kedu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/JoinServlet")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public JoinServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter writer = response.getWriter();
		writer.print("<html><body>");
		String userName = request.getParameter("userName");
		String jumin = request.getParameter("jumin_1") + "-" + request.getParameter("jumin_2");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		if ("".equals(request.getParameter("email_dns").trim())) {
			email += "@" + request.getParameter("emailaddr");
		} else {
			email += "@" + request.getParameter("email_dns");
		}
		String zip = request.getParameter("zip");
		String addr = request.getParameter("addr1") + request.getParameter("addr2");
		String phone = request.getParameter("phone");
		String job = request.getParameter("job");

		writer.println("이름 : " + userName + "<br>");
		writer.println("주민번호 : " + jumin + "<br>");
		writer.println("아이디 : " + id + "<br>");
		writer.println("비밀번호 : " + pwd + "<br>");
		writer.println("이메일 : " + email + "<br>");
		writer.println("우편번호 : " + zip + "<br>");
		writer.println("주소 : " + addr + "<br>");
		writer.println("전화 : " + phone + "<br>");
		writer.println("직업 : " + job + "<br>");

		writer.println("관심분야 : ");
		String[] interests = request.getParameterValues("interest");
		if (interests == null) {
			writer.print("선택한 항목이 없습니다");
		} else {
			for (String interest : interests) {
				writer.print(interest + " ");
			}
		}

		writer.println("<br><a href='javascript:history.go(-1)'>다시</a></body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
