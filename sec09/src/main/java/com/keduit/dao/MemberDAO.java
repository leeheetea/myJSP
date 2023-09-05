package com.keduit.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.keduit.dto.MemberVO;

import java.rmi.activation.ActivateFailedException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;

public class MemberDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static MemberDAO instance = new MemberDAO();
	
	private MemberDAO() {
	}
	
	public static MemberDAO getInstacnce() {
		return instance;
	}
	
	public Connection getConnection() {
		
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public int userCheck(String userid, String pwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select pwd from member where userid = ?";
		int result = -1;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("pwd") != null &&
				   rs.getString("pwd").equals(pwd)) {
						result = 1;
				} else {
					result = 0;
				}
			} else {
				result = -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public MemberVO getMember(String userid) {
		MemberVO mVO = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member where userid = ?";
		
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				mVO = new MemberVO();				
				mVO.setName(rs.getString("name"));;
				mVO.setUserid(rs.getString("userid"));
				mVO.setPwd(rs.getString("pwd"));
				mVO.setEmail(rs.getString("email"));
				mVO.setPhone(rs.getString("phone"));
				mVO.setAdmin(rs.getInt("admin"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mVO;
	}
	
	public int conformId(String userid) {
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select userid from member where userid = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return result = 1;
			} else {
				return result = -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int joinUser(MemberVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into member values(?,?,?,?,?,?)";
		int result = 0;
		
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			String name = vo.getName();
			String userid = vo.getUserid();
			String pwd = vo.getPwd();
			String email = vo.getEmail();
			String phone = vo.getPhone();
			int admin = vo.getAdmin();
			
			pstmt.setString(1, name);
			pstmt.setString(2, userid);
			pstmt.setString(3, pwd);
			pstmt.setString(4, email);
			pstmt.setString(5, phone);
			pstmt.setInt(6, admin);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int updateUser(MemberVO vo) {
	    String sql = "UPDATE member SET name = ?, pwd = ?, email = ?, phone = ?, admin = ? WHERE userid = ?";
	    int result = 0;
	    
	    // try-with-resources 구문 사용
	    try (Connection conn = getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	         
	        // VO에서 데이터 가져오기
	        String name = vo.getName();
	        String userid = vo.getUserid();
	        String pwd = vo.getPwd();
	        String email = vo.getEmail();
	        String phone = vo.getPhone();
	        int admin = vo.getAdmin();
	        
	        // PreparedStatement 파라미터 설정
	        pstmt.setString(1, name);
	        pstmt.setString(2, pwd);
	        pstmt.setString(3, email);
	        pstmt.setString(4, phone);
	        pstmt.setInt(5, admin);
	        pstmt.setString(6, userid);
	        
	        // 쿼리 실행 및 결과 처리
	        result = pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return result;
	}
	
}
