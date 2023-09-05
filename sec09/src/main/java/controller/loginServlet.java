package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.keduit.dao.MemberDAO;
import com.keduit.dto.MemberVO;

@WebServlet("/login.do")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "member/login.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDAO memberDAO = MemberDAO.getInstacnce();
		String path = "member/login.jsp";
		
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		
		int result = memberDAO.userCheck(userid, pwd);
		if(result == 1) {
			MemberVO mVO = memberDAO.getMember(userid);
			HttpSession session = request.getSession();
			request.setAttribute("loginUser", mVO);
			request.setAttribute("message", "회원 로그인 성공");
						
			path = "main.jsp";
		}
		else if(result == 0) {
			request.setAttribute("message", "비밀번호가 틀렸습니다.");
		}
		else if(result == -1) {
			request.setAttribute("message", "아이디를 확인하세요");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
		
	}

}
