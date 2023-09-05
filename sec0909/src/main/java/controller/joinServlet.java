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


@WebServlet("/join.do")
public class joinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "member/join.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int joinResult = 0;
		MemberVO mVO = new MemberVO();
		response.setCharacterEncoding("UTF-8");
		
		mVO.setName(request.getParameter("name"));
		mVO.setUserid(request.getParameter("userid"));
		mVO.setPwd(request.getParameter("pwd"));
		mVO.setEmail(request.getParameter("email"));
		mVO.setPhone(request.getParameter("phone"));
		mVO.setAdmin(Integer.parseInt(request.getParameter("admin")));
		
		MemberDAO dao = MemberDAO.getInstacnce();
		joinResult = dao.joinUser(mVO);
		
		if(joinResult > 0) {
			request.setAttribute("message", "회원가입에 성공하셨습니다.");
		} else {
			request.setAttribute("message", "회원가입에 실패했습니다.");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/login.jsp");
		dispatcher.forward(request, response);
			
	}

}
