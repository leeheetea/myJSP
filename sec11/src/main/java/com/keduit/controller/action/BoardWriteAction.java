package com.keduit.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keduit.dao.BoardDAO;
import com.keduit.dto.BoardVO;



public class BoardWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String email = request.getParameter("email");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
	
		BoardDAO bDao = BoardDAO.getInstance();
		
		BoardVO dVo = new BoardVO();
		
		dVo.setName(name);
		dVo.setPass(pass);
		dVo.setEmail(email);
		dVo.setTitle(title);
		dVo.setContent(content);
		bDao.insertBoard(dVo);
		
		String url ="/board/boardList.jsp";
		List<BoardVO> boardList = bDao.selectAllBoards();
		
		response.sendRedirect("index.jsp");
		
	}

}
