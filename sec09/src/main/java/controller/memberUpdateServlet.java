package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keduit.dao.MemberDAO;
import com.keduit.dto.MemberVO;


@WebServlet("/memberUpdate.do")
public class memberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		
		MemberDAO dao = MemberDAO.getInstacnce();
		MemberVO member = dao.getMember(userid);
		
		request.setCharacterEncoding("UTF-8");
		
		request.setAttribute("name", member.getName());
		request.setAttribute("userid", member.getUserid());
		request.setAttribute("pwd", member.getPwd());
		request.setAttribute("email", member.getEmail());
		request.setAttribute("phone", member.getPhone());
		request.setAttribute("admin", member.getAdmin());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/updatemember.jsp");
		dispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MemberDAO dao = MemberDAO.getInstacnce();
		MemberVO member = new MemberVO();
		
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String userid = request.getParameter("pwd");
		String pwd = request.getParameter("email");
		String email = request.getParameter("phone");
		String phone = request.getParameter("phone");
		int admin = Integer.parseInt(request.getParameter("admin"));
		
		member.setName(name);
		member.setUserid(userid);
		member.setPwd(pwd);
		member.setEmail(email);
		member.setPhone(phone);
		member.setAdmin(admin);
		dao.updateUser(member);
		
		response.sendRedirect("index.jsp");
		
		
	}

}
