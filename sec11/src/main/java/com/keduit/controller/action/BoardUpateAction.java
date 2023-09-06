package com.keduit.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keduit.dao.BoardDAO;
import com.keduit.dto.BoardVO;

public class BoardUpateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardVO boardVO = new BoardVO();
		BoardDAO dao = BoardDAO.getInstance();
		
		String num = request.getParameter("num");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String email = request.getParameter("email");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		boardVO.setNum(Integer.parseInt(num));
		boardVO.setName(name);
		boardVO.setPass(pass);
		boardVO.setEmail(email);
		boardVO.setTitle(title);
		boardVO.setContent(content);
		
		dao.updateBoard(boardVO);
		
		response.sendRedirect("index.jsp");
	
	}

}
