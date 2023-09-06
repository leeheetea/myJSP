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

	public void upateReadCount(String num) {
		String sql = "update board set readcount = readcount + 1 where num = ?";

		Connection conn = null;
		;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
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

			while (rs.next()) {
				BoardVO bVO = new BoardVO();

				int num = rs.getInt("num");
				String pass = rs.getString("pass");
				String email = rs.getString("email");
				String title = rs.getString("title");
				String name = rs.getString("name");
				int readcount = rs.getInt("readcount");
				Timestamp writedate = rs.getTimestamp("writedate");

				bVO.setNum(num);
				bVO.setPass(pass);
				bVO.setEmail(email);
				bVO.setTitle(title);
				bVO.setReadcount(readcount);
				bVO.setName(name);
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

		String sql = "INSERT INTO board (num, name, email, pass, title, content) "
				+ "VALUES (board_seq.nextval, ?, ?, ?, ?, ?)";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, boardData.getName());
			pstmt.setString(2, boardData.getEmail());
			pstmt.setString(3, boardData.getPass());
			pstmt.setString(4, boardData.getTitle());
			pstmt.setString(5, boardData.getContent());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public BoardVO selectOne(String num) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO boardVO = new BoardVO();

		String sql = "select * from board where num = " + num;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				boardVO.setName(rs.getString("name"));
				boardVO.setPass(rs.getString("pass"));
				boardVO.setEmail(rs.getString("email"));
				boardVO.setContent(rs.getString("content"));
				boardVO.setNum(rs.getInt("num"));
				boardVO.setTitle(rs.getString("title"));
				boardVO.setReadcount(rs.getInt("readcount"));
				boardVO.setWritedate(rs.getTimestamp("writedate"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return boardVO;
	}

	public void deleteBoard(String num) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from board where num = " + num;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}

	public void updateBoard(BoardVO boardVO) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update board set name =?, pass =?, email = ?, title = ?, content = ? where num = ? ";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, boardVO.getName());
			pstmt.setString(2, boardVO.getPass());
			pstmt.setString(3, boardVO.getEmail());
			pstmt.setString(4, boardVO.getTitle());
			pstmt.setString(5, boardVO.getContent());
			pstmt.setInt(6, boardVO.getNum());
			
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

}
