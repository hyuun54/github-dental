package mypkg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mypkg.bean.Board;
import mypkg.bean.Notice;

public class NoticeDao extends SuperDao{

	public int SelectTotalCount(String mode, String keyword) {
		// 해당 모드와 키워드를 이용하여 조건에 맞는 데이터의 건수를 구해줍니다.
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;		
		
		String sql = " select count(*) as cnt from notices " ; 
		if (mode.equalsIgnoreCase("all") == false) { //equalsIgnoreCase는 true, false로 나옴
			//전체 검색이 아니면
			sql += " where " + mode + " like '%" + keyword + "%' ";
		}
		
		
		int cnt = -999999 ;

		try {
			conn = super.getConnection() ;
			pstmt = conn.prepareStatement(sql) ;
			
			// placeholder 

			rs = pstmt.executeQuery() ; 
			
			if ( rs.next() ) { 
				cnt = rs.getInt("cnt"); //alias 이름 적기
			}
			
		} catch (SQLException e) {			
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
		return cnt ;
	}

	public List<Notice> SelectDataList(int beginRow, int endRow, String mode, String keyword) {
		// 랭킹을 이용하여 해당 페이지의 데이터를 컬렉션으로 반환 합니다.
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		//sql 페이징 다시 보기
		String sql = " select no, title, writer, password, content, readhit, regdate " ;
	      sql += " from ( " ;
	      sql += " select no, title, writer, password, content, readhit, regdate, " ;
	      sql += " rank() over(order by no desc) as ranking " ;
	      sql += " from notices " ;
	      
	      if (mode.equalsIgnoreCase("all") == false) {
			sql += " where " + mode + " like '%" + keyword + "%' ";
		}
	      
	      sql += " ) " ;
	      sql += " where ranking between ?  and ?  " ;
		
		List<Notice> lists = new ArrayList<Notice>();

		try {
			conn = super.getConnection() ;
			pstmt = conn.prepareStatement(sql) ;

			// placeholder
			pstmt.setInt(1, beginRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery() ;			
			
			while( rs.next() ){
				Notice bean = new Notice();
				
				bean.setContent(rs.getString("content"));
				bean.setNo(rs.getInt("no"));
				bean.setPassword(rs.getString("password"));
				
				bean.setReadhit(rs.getInt("readhit"));
				bean.setRegdate(String.valueOf(rs.getDate("regdate")));
				
				bean.setTitle(rs.getString("title"));
				bean.setWriter(rs.getString("writer"));
				
				lists.add( bean ) ;
			}
		} catch (Exception e) {
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

	public int InsertData(Notice bean) {
		// 넘겨진 Bean 데이터를 이용하여 추가합니다.
		String sql = " insert into notices(no, title, writer, password";
		sql	+= " , content, readhit, regdate) "; //콤마조심
		sql += " values(mynotice.nextval, ?, ?, ?, ?, default, default) ";    
		
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		int cnt = -999999 ;

		try {
			conn = super.getConnection() ;
			pstmt = conn.prepareStatement(sql) ;

			// placeholder
			pstmt.setString(1, bean.getTitle());
			pstmt.setString(2, bean.getWriter());
			pstmt.setString(3, bean.getPassword());
			pstmt.setString(4, bean.getContent());
			
			cnt = pstmt.executeUpdate() ; 
			conn.commit(); 

		} catch (Exception e) {
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

	public Notice SelectDataByPk(int no) {
		// 해당 게시물 번호의 Bean 객체를 구합니다. 
		Notice bean = null ;
		
		String sql = " select * from notices ";
		sql += " where no = ? ";
		
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		try {
			conn = super.getConnection() ;
			pstmt = conn.prepareStatement(sql) ;

			// placeholder			
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery() ;
			
			while(rs.next()) {
				bean = new Notice() ;
				
				bean.setContent(rs.getString("content"));
				bean.setNo(rs.getInt("no"));
				bean.setPassword(rs.getString("password"));
				
				bean.setRegdate(String.valueOf(rs.getDate("regdate")));
				
				bean.setTitle(rs.getString("title"));
				bean.setWriter(rs.getString("writer"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
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

	public int UpdateReadhit(int no) {
		// 조회수를 1증가 시킵니다.
		String sql = " update notices set readhit = readhit + 1 ";
		sql += " where no = ? ";    
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		int cnt = -999999 ;

		try {
			conn = super.getConnection() ;
			pstmt = conn.prepareStatement(sql) ;

			// placeholder
			pstmt.setInt(1, no);
			
			cnt = pstmt.executeUpdate() ; 
			conn.commit(); 

		} catch (Exception e) {
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
		return cnt;
	}

	public int UpdatData(Notice bean) {
		// 해당 게시물을 수정합니다.
		String sql = " update notices set ";
		sql += " content=?, regdate=default, title=?, writer=? ";    
		sql += " where no = ? ";    
		
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		int cnt = -999999 ;

		try {
			conn = super.getConnection() ;
			pstmt = conn.prepareStatement(sql) ;

			// placeholder
			pstmt.setString(1, bean.getContent());
			pstmt.setString(2, bean.getTitle());
			pstmt.setString(3, bean.getWriter());
			pstmt.setInt(4, bean.getNo());
			
			cnt = pstmt.executeUpdate() ; 
			conn.commit(); 

		} catch (Exception e) {
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

	public int DeletData(int no) {
		// 게시물 삭제하기
		String sql = " delete from notices where no = ? " ;
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		int cnt = -999999 ;
		
		try {
			conn = super.getConnection() ;
			pstmt = conn.prepareStatement(sql) ;
			
			// placeholder
			pstmt.setInt(1, no);
			
			cnt = pstmt.executeUpdate() ; 
			conn.commit(); 
		
		} catch (Exception e) {
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

}
