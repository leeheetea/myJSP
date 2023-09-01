package com.keduit;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberBean member = new MemberBean();
		request.setCharacterEncoding("UTF-8");
		member.setName(request.getParameter("name"));
		member.setUserId(request.getParameter("uesrId"));
		member.setPwd(request.getParameter("pwd"));
		member.setNickName(request.getParameter("nickName"));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("05_elMember2.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberBean member = new MemberBean();
		request.setCharacterEncoding("UTF-8");
		member.setName(request.getParameter("name"));
		member.setUserId(request.getParameter("uesrId"));
		member.setPwd(request.getParameter("pwd"));
		member.setNickName(request.getParameter("nickName"));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("05_elMember.jsp");
		dispatcher.forward(request, response);
	}

}
