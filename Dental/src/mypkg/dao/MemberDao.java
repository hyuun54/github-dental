package mypkg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import mypkg.bean.Member;

public class MemberDao extends SuperDao{

	public Member SelectData(String id, String password) {
		// 아이디랑 비번으로 db에 있는지 비교
		// 있으면 bean(member) 반환
		Member bean = null;
		
		String sql = " select * from members where id = ? and password = ? ";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = super.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				//사용자 있음
				bean = new Member();
				bean.setAddress1(rs.getString("address1"));
				bean.setAddress2(rs.getString("address2"));
				
				String mydate = String.valueOf(rs.getDate("birthdate"));
				bean.setBirthdate(mydate);
				
				bean.setEmail(rs.getString("email"));
				bean.setGender(rs.getString("gender"));
				bean.setId(id);
				bean.setMpoint(rs.getInt("mpoint"));
				bean.setName(rs.getString("name"));
				bean.setPassword(password);
				bean.setPhone(rs.getString("phone"));
				bean.setZipcode(rs.getString("zipcode"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(rs != null) {rs.close();}
				if(pstmt != null) {pstmt.close();}
				if(conn != null) {conn.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return bean;
	}
	
}
