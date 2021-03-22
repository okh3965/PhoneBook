package com.java.phone;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneBookDaoImpl implements PhoneBookDao {

	private Connection getConnection() throws SQLException{
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(dburl, "C##KHOH", "1234");
			
		} catch(ClassNotFoundException e) {
			System.err.println("드라이버 로드 실패");
		}
		return conn;
	}
	
	@Override
	public List<PhoneBookVo> getList() {
		// TODO Auto-generated method stub
		
		List<PhoneBookVo> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			
			String sql = "SELECT id, name, hp, tel FROM phone_book";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Long id = rs.getLong("id");
				String name = rs.getString("name");
				String hp = rs.getString("hp");
				String tel = rs.getString("tel");
				
				PhoneBookVo vo = new PhoneBookVo(id, name, hp, tel);
				list.add(vo);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}			
		return list;
	}

	@Override
	public List<PhoneBookVo> search(String keyword) {
		List<PhoneBookVo> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "SELECT id, name, hp, tel FROM phone_book WHERE name LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			
			rs = pstmt.executeQuery();
						
			while(rs.next()) {
				PhoneBookVo vo = new PhoneBookVo();
				vo.setId(rs.getLong(1));
				vo.setName(rs.getString(2));
				vo.setHp(rs.getString(3));
				vo.setTel(rs.getString(4));
				
				list.add(vo);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public PhoneBookVo get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(PhoneBookVo vo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO phone_book VALUES(seq_phone_book.NEXTVAL, ?, ?, ?)";
		int insertedCount = 0;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getHp());
			pstmt.setString(3, vo.getTel());
			
			insertedCount = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}		
		return insertedCount == 1;
	}

	@Override
	public boolean update(PhoneBookVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int updatedCount = 0;
		
		try {
			conn = getConnection();
			String sql = "UPDATE phone_book SET name=?, hp=?, tel=? WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getHp());
			pstmt.setString(3, vo.getTel());
			
			updatedCount = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return updatedCount == 1;
	}

	@Override
	public boolean delete(Long id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int deletedCount = 0;
		
		try {
			conn = getConnection();
			String sql = "DELETE FROM phone_book WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, id);
			deletedCount = pstmt.executeUpdate();			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}		
		return deletedCount == 1;
	}

}
