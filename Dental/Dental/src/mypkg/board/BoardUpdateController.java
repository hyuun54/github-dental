package mypkg.board;


import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.bean.Board;
import mypkg.common.SuperClass;
import mypkg.dao.BoardDao;

public class BoardUpdateController extends SuperClass{
	private Board bean = null;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		
		BoardDao dao = new BoardDao();
		
		// xxx는 현재 수정하고자 하는 이전에 기입했던 게시물 1건을 의미
		Board xxx = dao.SelectDataByPk(no);
		
		request.setAttribute("bean", xxx);
		
		super.doGet(request, response);
		
		String gotopage = "/board/boUpdateForm.jsp";
		super.GotoPage(gotopage);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		bean = new Board();
		bean.setContent(request.getParameter("content"));
		bean.setNo(Integer.parseInt(request.getParameter("no")));
		bean.setPassword(request.getParameter("password"));
		bean.setRegdate(request.getParameter("regdate"));
		bean.setTitle(request.getParameter("title"));
		bean.setWriter(request.getParameter("writer"));
		
		//다음 항목들은 수정에 반영할 필요가 없습니다.
//		bean.setDepth(Integer.parseInt(request.getParameter("depth")));
//		bean.setGroupno(Integer.parseInt(request.getParameter("groupno")));
//		bean.setOrderno(Integer.parseInt(request.getParameter("orderno")));
		
		
		String gotopage = "";
		if (this.validate(request) == true) {
			// 유효성 검사 통과
			BoardDao dao = new BoardDao();
			int cnt = -999999;
			cnt = dao.UpdatData(bean);
			
			// request 객체의 내용을 보존하면서 목록 보기 페이지로 넘겨 줍니다.
			// db에서 다시 게시판 자료를 읽어 와야함
			new BoardCounselListController().doGet(request, response);
			
		}else {
			//유효성 검사 실패
			// db에서 다시 읽어올 필요없음
			request.setAttribute("bean", bean);
			super.doPost(request, response);
			gotopage = "/board/boUpdateForm.jsp";
			super.GotoPage(gotopage);
		}
	}
	
	@Override
	public boolean validate(HttpServletRequest request) {
		boolean isCheck = true ; //기본 값으로 true이고, 유효성 검사에 문제가 생기면 false으로 변경
		
		if( bean.getTitle().length() < 1 || bean.getTitle().length() > 30 ){
			request.setAttribute( "errtitle", "제목은 1글자 이상 30글자 이하이어야 합니다.");
			isCheck = false  ;
		}
		if( bean.getPassword().length() < 4 || bean.getPassword().length() > 12 ){
			request.setAttribute( "errpassword", "비밀 번호는 4자리 이상 12자리 이하이어야 합니다.");
			isCheck = false  ;
		}
		if( bean.getContent().length() < 5 || bean.getContent().length() > 200 ){
			request.setAttribute( "errcontent", "글 내용은 5자리 이상 200자리 이하이어야 합니다.");
			isCheck = false  ;
		}
		return isCheck ;
	}
}
