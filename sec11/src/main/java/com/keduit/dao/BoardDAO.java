package com.keduit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.keduit.dto.BoardVO;

import util.DBManager;

public class BoardDAO {
	
	private static BoardDAO instacne = new BoardDAO();
	
	public static BoardDAO getInstance() {
		return instacne;
	}

	private BoardDAO() {		
	}
	
	public List<BoardVO> selectAllBoards() {
		
		List<BoardVO> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "select * from board order by num desc";
		
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				BoardVO bVO = new BoardVO();
				
				int num = rs.getInt("num");
				String pass = rs.getString("pass");
				String email = rs.getString("email");
				String title = rs.getString("title");
				String content = rs.getString("readcount");
				int readcount = rs.getInt("readcount");
				Timestamp writedate = rs.getTimestamp("writedate");
				
				bVO.setNum(num);
				bVO.setPass(pass);
				bVO.setEmail(email);
				bVO.setTitle(title);
				bVO.setReadcount(readcount);
				bVO.setContent(content);
				bVO.setWritedate(writedate);
				
				list.add(bVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	

	public void insertBoard(BoardVO boardData) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
	    String sql = "INSERT INTO board (num, name, email, pass, title, content) " +
                "VALUES (board_seq.nextval, ?, ?, ?, ?, ?)";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, boardData.getName());
			pstmt.setString(2, boardData.getEmail());
			pstmt.setString(3, boardData.getPass());
			pstmt.setString(4, boardData.getTitle());
			pstmt.setString(5, boardData.getContent());
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
}
