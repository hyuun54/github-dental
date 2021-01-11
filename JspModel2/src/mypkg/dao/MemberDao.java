package mypkg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mypkg.bean.Member;

public class MemberDao extends SuperDao{
	public MemberDao() {
		
	}
	
	//아이디와 비번을 사용하여 해당 회원이 존재하나요?
	//bean에 있는member
	public Member SelectData(String id, String password) {
		Member bean = null;
		
		String sql = " select * from members where id = ? and password = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = super.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {//해당 사용자 발견됨
				bean = new Member();
				bean.setAddress1(rs.getString("address1"));
				bean.setAddress2(rs.getString("address2"));
				bean.setGender(rs.getString("gender"));
				
				String[] hobby = rs.getString("hobby").split(",");
				bean.setHobby(hobby);
				
				bean.setId(rs.getString("id"));
				bean.setJob(rs.getString("job"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setZipcode(rs.getString("zipcode"));
				//날짜
				String mydate = String.valueOf(rs.getDate("hiredate"));
				bean.setHiredate(mydate);
				//숫자
				bean.setMpoint(rs.getInt("mpoint"));
				bean.setSalary(rs.getInt("salary"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
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

	public Member SelectData(String id) {
		// 아이디 정보를 이용하여 회원을 찾아 줍니다.
		Member bean = null;
		
		String sql = " select * from members where id = ? ";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = super.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {//해당 사용자 발견됨
				bean = new Member();
				bean.setAddress1(rs.getString("address1"));
				bean.setAddress2(rs.getString("address2"));
				bean.setGender(rs.getString("gender"));
				String[] hobby = rs.getString("hobby").split(",");
				bean.setHobby(hobby);
				bean.setId(rs.getString("id"));
				bean.setJob(rs.getString("job"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setZipcode(rs.getString("zipcode"));
				//날짜
				String mydate = String.valueOf(rs.getDate("hiredate"));
				bean.setHiredate(mydate);
				//숫자
				bean.setMpoint(rs.getInt("mpoint"));
				bean.setSalary(rs.getInt("salary"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
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

	public int UpdateData(Member bean) {
		//회원 정보를 수정합니다.
		String sql = " update members set ";
		sql += " name=?, ";    
		sql += " password=?, ";    
		sql += " salary=?, ";    
		sql += " hiredate=?, ";    
		sql += " gender=?, ";    
		sql += " hobby=?, ";    
		sql += " job=?, ";    
		sql += " zipcode=?, ";    
		sql += " address1=?, ";    
		sql += " address2=?, ";    
		sql += " mpoint=? ";    //마지막에 ,없는거 조심
		sql += " where id = ? ";    
		
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		int cnt = -999999 ;

		try {
			conn = super.getConnection() ;
			pstmt = conn.prepareStatement(sql) ;

			// placeholder
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getPassword());
			pstmt.setInt(3, bean.getSalary());
			pstmt.setString(4, bean.getHiredate());
			pstmt.setString(5, bean.getGender());
			pstmt.setString(6, bean.getHobby());
			pstmt.setString(7, bean.getJob());
			pstmt.setString(8, bean.getZipcode());
			pstmt.setString(9, bean.getAddress1());
			pstmt.setString(10, bean.getAddress2());
			pstmt.setInt(11, bean.getMpoint());
			pstmt.setString(12, bean.getId());
			
			cnt = pstmt.executeUpdate() ; 
			conn.commit(); 

		} catch (Exception e) {
			SQLException err = (SQLException)e ;			
			cnt = - err.getErrorCode() ;			
			e.printStackTrace();
			try {
				conn.rollback(); 
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} finally{
			try {
				if(pstmt != null){pstmt.close();}
				if(conn != null){conn.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cnt ;
	}

	public List<Member> SelectDataList() {
		// 회원 리스트 보기
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;

		String sql = " select * from members order by id "; 
		
		List<Member> lists = new ArrayList<Member>();

		try {
			conn = super.getConnection() ;
			pstmt = conn.prepareStatement(sql) ;

			// placeholder

			rs = pstmt.executeQuery() ;			
			while( rs.next() ){
				Member bean = new Member();
				
				bean.setAddress1(rs.getString("address1"));
				bean.setAddress2(rs.getString("address2"));
				bean.setGender(rs.getString("gender"));
				bean.setHiredate(String.valueOf(rs.getDate("hiredate")));
				String[] hobby = rs.getString("hobby").split(",");
				bean.setHobby(hobby);
				bean.setId(rs.getString("id"));
				bean.setJob(rs.getString("job"));
				bean.setMpoint(rs.getInt("mpoint"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setSalary(rs.getInt("salary"));
				bean.setZipcode(rs.getString("zipcode"));
				
				lists.add( bean ) ;
			}
		} catch (Exception e) {
			SQLException err = (SQLException)e ;			
			int cnt = - err.getErrorCode() ;			
			e.printStackTrace();
			try {
				conn.rollback(); 
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} finally{
			try {
				if(rs != null){ rs.close(); }
				if(pstmt != null){ pstmt.close(); }
				if(conn != null){conn.close();}
			} catch (Exception e2) {
				e2.printStackTrace(); 
			}
		}
		
		return lists ;
	}

	public Member SelectDataByPk(String id) {
		// 회원 1명 상세보기
		Member bean = null ;
		
		String sql = " select * from members ";
		sql += " where id = ? ";
		
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		try {
			conn = super.getConnection() ;
			pstmt = conn.prepareStatement(sql) ;

			// placeholder
			pstmt.setString(1, id);
						
			rs = pstmt.executeQuery() ;
			
			while(rs.next()) {
				bean = new Member() ;
				
				bean.setAddress1(rs.getString("address1"));
				bean.setAddress2(rs.getString("address2"));
				bean.setGender(rs.getString("gender"));
				bean.setHiredate(String.valueOf(rs.getDate("hiredate")));
				String[] hobby = rs.getString("hobby").split(",");
				bean.setHobby(hobby);
				bean.setId(rs.getString("id"));
				bean.setJob(rs.getString("job"));
				bean.setMpoint(rs.getInt("mpoint"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setSalary(rs.getInt("salary"));
				bean.setZipcode(rs.getString("zipcode"));
			}
			
			System.out.println("ok");
		} catch (Exception e) {
			SQLException err = (SQLException)e ;			
			int cnt = - err.getErrorCode() ;			
			e.printStackTrace();
			try {
				conn.rollback(); 
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} finally {
			try {
				if(rs != null) {rs.close();}
				if(pstmt != null) {pstmt.close();}
				if(conn != null) {conn.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return bean ;
	}

	public int DeleteData(String id) {
		// boards.remark 수정, orders.remark 수정
		// 해당 id를 이용하여 회원 탈퇴를 수행합니다.
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		int cnt = -999999 ;
		Member bean = null; //탈퇴하는 회원의 Bean 정보
		
		try {
			conn = super.getConnection() ;
			conn.setAutoCommit(false); 
			
			bean = this.SelectDataByPk(id);
			
			//SelectDataByPk()메소드 후에 conn이 닫히는 걸 예방
			if(conn == null) {conn = super.getConnection() ;}
			
			// boards.remark 수정
			String sql = " update boards set remark = ? " ;
			sql += " where writer = ?" ;
			pstmt = conn.prepareStatement(sql) ;
			
			// 심형래(sim09)가 회원 탈퇴를 하였습니다.
			String imsi = bean.getName() + "(" + id + ")가 회원 탈퇴를 하였습니다.";
			pstmt.setString(1, imsi);	
			pstmt.setString(2, id);	
			
			cnt = pstmt.executeUpdate() ; 
			
			//orders.remark 수정
			sql = " update orders set remark = ? " ;
			sql += " where mid = ?" ;
			
			if(pstmt != null) {pstmt.close();}
			pstmt = conn.prepareStatement(sql) ;
			
			pstmt.setString(1, imsi);	
			pstmt.setString(2, id);	
			
			cnt = pstmt.executeUpdate() ;
			
			// 회원 탈퇴하기			
			sql = " delete from members " ;
			sql += " where id = ?  " ; 
			
			if(pstmt !=null) {pstmt.close();}
			
			pstmt = conn.prepareStatement(sql) ;
			
			pstmt.setString(1, id);		
			
			cnt = pstmt.executeUpdate() ;
			
			conn.commit(); 

		} catch (Exception e) {
			SQLException err = (SQLException)e ;			
			cnt = - err.getErrorCode() ;			
			e.printStackTrace();
			try {
				conn.rollback(); 
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} finally{
			try {
				if(pstmt != null){pstmt.close();}
				if(conn != null){conn.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cnt ;
	}

	public int InsertData(Member bean) {
		// TODO Auto-generated method stub
		System.out.println( bean.toString() ); 
		String sql = " insert into members(id, name, password,salary, hiredate,                gender,hobby,job, zipcode,address1,  address2,mpoint) " ; 
		sql += " values(                 ?, ?,    ?,       ?,    to_date(?, 'yyyy/MM/dd'),   ?,    ?,    ?,  ?,      ?,   ?,    ? ) " ;

		PreparedStatement pstmt = null ;
		int cnt = -99999 ;
		try {
			conn = super.getConnection() ;
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;
			//개발자가 수정할 곳 2 : ? 수정할 것
			pstmt.setString(1, bean.getId() );
			pstmt.setString(2, bean.getName() );
			pstmt.setString(3, bean.getPassword());
			pstmt.setInt(4, bean.getSalary() );
			pstmt.setString(5, bean.getHiredate() );
			pstmt.setString(6, bean.getGender() );
			pstmt.setString(7, bean.getHobby() );
			pstmt.setString(8, bean.getJob());
			pstmt.setString(9, bean.getZipcode() );
			pstmt.setString(10, bean.getAddress1());
			pstmt.setString(11, bean.getAddress2() );
			pstmt.setInt(12, bean.getMpoint() );
			
			cnt = pstmt.executeUpdate() ; 
			conn.commit(); 
		} catch (Exception e) {
			SQLException err = (SQLException)e ;
			//getErrorCode() : 오라클 오류 상수가 리턴
			//예 : not null 이면 1400 
			cnt = - err.getErrorCode() ;			
			e.printStackTrace();
			try {
				conn.rollback(); 
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} finally{
			try {
				if( pstmt != null ){ pstmt.close(); }
				if(conn != null){conn.close();} 
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cnt ;
	}
}
