package mypkg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mypkg.bean.Board;

public class BoardDao extends SuperDao{

	public List<Board> SelectDataList(int beginRow, int endRow, String mode, String keyword) {
		// 랭킹을 이용하여 해당 페이지릐 데이터를 컬렉션으로 반환 합니다.
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		int cnt = -999999;
		
		//sql 페이징 다시 보기
		String sql = " select no, subject, writer, password, content, readhit, regdate, groupno, orderno, depth, remark " ;
	      sql += " from ( " ;
	      sql += " select no, subject, writer, password, content, readhit, regdate, groupno, orderno, depth, remark,  " ;
	      sql += " rank() over(order by groupno desc, orderno asc) as ranking " ;
	      sql += " from boards " ;
	      
	      if (mode.equalsIgnoreCase("all") == false) {
			sql += " where " + mode + " like '" + keyword + "' ";
		}
	      
	      sql += " ) " ;
	      sql += " where ranking between ?  and ?  " ;
		
		List<Board> lists = new ArrayList<Board>();

		try {
			conn = super.getConnection() ;
			pstmt = conn.prepareStatement(sql) ;

			// placeholder
			pstmt.setInt(1, beginRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery() ;			
			
			while( rs.next() ){
				Board bean = new Board();
				
				bean.setContent(rs.getString("content"));
				bean.setDepth(rs.getInt("depth"));
				bean.setGroupno(rs.getInt("groupno"));
				bean.setNo(rs.getInt("no"));
				bean.setOrderno(rs.getInt("orderno"));
				bean.setPassword(rs.getString("password"));
				bean.setReadhit(rs.getInt("readhit"));
				
				bean.setRegdate(String.valueOf(rs.getDate("regdate")));
				
				bean.setSubject(rs.getString("subject"));
				bean.setWriter(rs.getString("writer"));
				bean.setRemark(rs.getString("remark"));
				
				lists.add( bean ) ;
			}
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
				if(rs != null){ rs.close(); }
				if(pstmt != null){ pstmt.close(); }
				if(conn != null){conn.close();}
			} catch (Exception e2) {
				e2.printStackTrace(); 
			}
		}
		
		return lists ;
	}

	public int SelectTotalCount(String mode, String keyword) {
		// 해당 모드와 키워드를 이용하여 조건에 맞는 데이터의 건수를 구해줍니다.
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;		
		
		String sql = " select count(*) as cnt from boards " ; 
		if (mode.equalsIgnoreCase("all") == false) {
			//전체 검색이 아니면
			sql += " where " + mode + "like '" + keyword + "' ";
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
		return cnt ;
	}

	public int InsertData(Board bean) {
		// 넘겨진 Bean 데이터를 이용하여 추가합니다.
		String sql = " insert into boards(no, subject, writer, password";
		sql	+= " , content, readhit, regdate, groupno, orderno, depth) "; //콤마조심
		sql += " values(myboard.nextval, ?, ?, ?, ?, default, to_date(?, 'yyyy/MM/dd'), myboard.currval, default, default) ";    
		
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		int cnt = -999999 ;

		try {
			conn = super.getConnection() ;
			pstmt = conn.prepareStatement(sql) ;

			// placeholder
			pstmt.setString(1, bean.getSubject());
			pstmt.setString(2, bean.getWriter());
			pstmt.setString(3, bean.getPassword());
			pstmt.setString(4, bean.getContent());
			pstmt.setString(5, bean.getRegdate());
			
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

	public Board SelectDataByPk(int no) {
		// 해당 게시물 번호의 Bean 객체를 구합니다. 
		Board bean = null ;
		
		String sql = " select * from boards ";
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
				bean = new Board() ;
				
				bean.setContent(rs.getString("content"));
				bean.setDepth(rs.getInt("depth"));
				bean.setGroupno(rs.getInt("groupno"));
				bean.setNo(rs.getInt("no"));
				bean.setOrderno(rs.getInt("orderno"));
				bean.setPassword(rs.getString("password"));
				bean.setReadhit(rs.getInt("readhit"));
				
				bean.setRegdate(String.valueOf(rs.getDate("regdate")));
				
				bean.setSubject(rs.getString("subject"));
				bean.setWriter(rs.getString("writer"));
				bean.setRemark(rs.getString("remark"));
			}
			
			System.out.println("ok");
		} catch (Exception e) {
			SQLException err = (SQLException)e ;			
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

	public int UpdateReadhit(int no) {
		// 조회수를 1증가 시킵니다.
		String sql = " update boards set readhit = readhit + 1 ";
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

	public int UpdatData(Board bean) {
		// 해당 게시물을 수정합니다.
		String sql = " update boards set ";
		sql += " content=?, password=?, regdate=?, subject=?, writer=?, remark=? ";    
		sql += " where no = ? ";    
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		int cnt = -999999 ;

		try {
			conn = super.getConnection() ;
			pstmt = conn.prepareStatement(sql) ;

			// placeholder
			pstmt.setString(1, bean.getContent());
			pstmt.setString(2, bean.getPassword());
			pstmt.setString(3, bean.getRegdate());
			pstmt.setString(4, bean.getSubject());
			pstmt.setString(5, bean.getWriter());
			pstmt.setString(6, bean.getRemark());// 6번인거 주의
			pstmt.setInt(7, bean.getNo());
			
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

	public int DeletData(int no) {
		// 게시물 삭제하기
		String sql = " delete from boards where no = ? " ;
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

	public int ReplyData(Board bean, int groupno, int orderno) {
		// 1)답글 추가하기
		// 2)동일 그룹의 orderno 컬럼 갱신하기
		String sql = " insert into boards ";
		sql += " ( ";    
		sql += " no, subject, writer, password, content, readhit, regdate, groupno, orderno, depth, remark ";    
		sql += " ) ";    
		sql += " values ";    
		sql += " ( ";    
		sql += " myboard.nextval, ?, ?, ?, ?, default, to_date(?, 'yyyy/MM/dd'), ?, ?, ?, ? ";    
		sql += " ) ";    

		Connection conn = null ;
		PreparedStatement pstmt = null ;
		int cnt = -999999 ;

		try {
			conn = super.getConnection() ;
			pstmt = conn.prepareStatement(sql) ;

			// placeholder
			// subject, writer, password, content, regdate, groupno, orderno, depth ";    
			pstmt.setString(1, bean.getSubject());
			pstmt.setString(2, bean.getWriter());
			pstmt.setString(3, bean.getPassword());
			pstmt.setString(4, bean.getContent());
			pstmt.setString(5, bean.getRegdate());
			pstmt.setInt(6, bean.getGroupno());
			pstmt.setInt(7, bean.getOrderno());
			pstmt.setInt(8, bean.getDepth());
			pstmt.setString(9, bean.getRemark());
			
			cnt = pstmt.executeUpdate() ; 
			
			//동일 그룹의 orderno 컬럼을 갱신합니다.
			//초기화 해야됨
			sql = " update boards set orderno = orderno + 1 ";
			sql += " where groupno = ? and orderno > ? ";
			
			pstmt = null;
			pstmt = conn.prepareStatement(sql);
			
			cnt = -999999;
			
			pstmt.setInt(1, groupno);
			pstmt.setInt(2, orderno);
			
			cnt = pstmt.executeUpdate();
			
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
}


