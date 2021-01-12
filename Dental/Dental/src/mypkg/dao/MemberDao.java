package mypkg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	public int InsertData(Member bean) {
		System.out.println( bean.toString() ); 
		String sql = " insert into members(id, name, password, birthdate , gender, zipcode, address1, address2, phone, email ,mpoint) ";
		sql += " values( ?, ?, ?, to_date(?, 'yyyy/MM/dd'), ?, ?, ?, ?, ?, ?, ? ) ";	
		
		PreparedStatement pstmt = null ;
		int cnt = -99999 ;
		try {
			conn = super.getConnection() ;
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;
			
			pstmt.setString(1, bean.getId() );
			pstmt.setString(2, bean.getName() );
			pstmt.setString(3, bean.getPassword());			
			pstmt.setString(4, bean.getBirthdate());
			pstmt.setString(5, bean.getGender());		
			pstmt.setString(6, bean.getZipcode() );
			pstmt.setString(7, bean.getAddress1());
			pstmt.setString(8, bean.getAddress2() );			
			pstmt.setString(9, bean.getPhone());
			pstmt.setString(10, bean.getEmail());
			pstmt.setInt(11, bean.getMpoint() );
		
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
		return cnt;
	}

	public Member SelectDataByPk(String id) {		
		// 아이디 정보를 이용하여 회원을 찾아 줍니다.
		
		Member bean = null ;
		
		String sql = "select * from members where id = ? ";
		
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		try {
			conn = super.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
			
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
				bean.setPassword(rs.getString("password"));
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

	public int UpdateData(Member bean) {
		//회원 정보수정
		String sql = " update members set ";
		sql += " name = ?, ";
		sql += " password = ?, ";
		sql += " birthdate = ?, ";
		sql += " gender = ?, ";
		
		sql += " phone = ?, ";
		sql += " email = ?, ";
		
		sql += " zipcode = ?, ";
		sql += " address1 = ?, ";
		sql += " address2 = ?, ";		
		sql += " mpoint = ? ";
		sql += " where id = ?  "; 
 
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		int cnt = -999999 ;

		try {
			conn = super.getConnection() ;
			pstmt = conn.prepareStatement(sql) ;

			// placeholder
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getPassword());			
			pstmt.setString(3, bean.getBirthdate());								
			pstmt.setString(4, bean.getGender());
			
			pstmt.setString(5, bean.getPhone());
			pstmt.setString(6, bean.getEmail());
			
			pstmt.setString(7, bean.getZipcode());
			pstmt.setString(8, bean.getAddress1());
			pstmt.setString(9, bean.getAddress2());			
			pstmt.setInt(10, bean.getMpoint());
			pstmt.setString(11, bean.getId());
			
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

	public int DeleteData(String id) {
		// boards.remark 수정, orders.remark 수정
		// 해당 id를 이용하여 회원 탈퇴를 수행	
		
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		int cnt = -999999 ;
		Member bean = null ; //탈퇴하는 회원의 Bean 정보		
		
		try {
			conn = super.getConnection() ;
			conn.setAutoCommit(false); 
			
			bean = this.SelectDataByPk(id);
			
			if(conn == null) {conn = super.getConnection() ;}
						
			// 탈퇴할 회원이 남긴 게시물 정보의 remark 컬럼 정보를 수정합니다.
			String sql = " update boards set remark = ? " ;
			sql += " where writer = ?" ;
			pstmt = conn.prepareStatement(sql) ;
			
			// 심형래(sim09)가 회원 탈퇴를 하였습니다.
			String imsi = bean.getName() + "(" + id + ")가 회원 탈퇴를 하였습니다." ;
			pstmt.setString(1, imsi);
			pstmt.setString(2, id);
			
			cnt = pstmt.executeUpdate() ; 
			
			// orders.remark 수정
			sql = " update orders set remark = ? ";
			sql += " where mid = ? " ;
			if(pstmt !=null) {pstmt.close();}
			pstmt = conn.prepareStatement(sql) ;
			
			pstmt.setString(1, imsi);
			pstmt.setString(2, id);
			
			cnt = pstmt.executeUpdate() ; 
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

	public int SelectTotalCount() {
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;		
		
		String sql = "select count(*) as cnt from members " ; 
		int cnt = -999999 ;

		try {
			conn = super.getConnection() ;
			pstmt = conn.prepareStatement(sql) ;
			
			// placeholder 

			rs = pstmt.executeQuery() ; 
			
			if ( rs.next() ) { 
				cnt = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {			
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
				if( rs != null){ rs.close(); } 
				if( pstmt != null){ pstmt.close(); } 
				if(conn != null){conn.close();}
			} catch (Exception e2) {
				e2.printStackTrace(); 
			}
		} 		
		return cnt  ; 
	}

	public List<Member> SelectDataList(int beginRow, int endRow) {
		String sql = "select id, name, password, birthdate , gender, zipcode, address1, address2, phone, email ,mpoint, ranking "; 
		sql += " from " ; 
		sql += " ( " ;
		sql += " select id, name, password, birthdate , gender, zipcode, address1, address2, phone, email ,mpoint, rank() over( order by id asc ) as ranking " ;
		sql += " from members  " ;
		sql += " ) " ;
		sql += " where ranking between ? and ? " ;
		
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;

		
		List<Member> lists = new ArrayList<Member>();

		try {
			conn = super.getConnection() ;
			pstmt = conn.prepareStatement(sql) ;

			pstmt.setInt(1, beginRow);
			pstmt.setInt(2, endRow);

			rs = pstmt.executeQuery() ;			
			while( rs.next() ){
				Member bean = new Member();
				bean.setAddress1( rs.getString("address1") );
				bean.setAddress2( rs.getString("address2") );
				bean.setGender( rs.getString("gender") );				
				bean.setId( rs.getString("id") );
				
				bean.setEmail(rs.getString("email"));
				bean.setPhone(rs.getString("phone"));
				
				bean.setZipcode( rs.getString("zipcode") );
				bean.setPassword( rs.getString("password") );
				bean.setName(rs.getString("name"));
				
			
				
				//날짜는 String.valueOf( rs.getDate() ) 의 형식
				bean.setBirthdate( String.valueOf(rs.getDate("birthdate")) );
				
				//숫자는 Integer.parsteInt()
				bean.setMpoint( Integer.parseInt(rs.getString("mpoint")) );
				
				
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
	
}
