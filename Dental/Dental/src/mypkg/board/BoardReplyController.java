package mypkg.board;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.bean.Board;
import mypkg.common.SuperClass;
import mypkg.dao.BoardDao;

public class BoardReplyController extends SuperClass{
	private Board bean = null;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		String gotopage = "/board/boReplyForm.jsp";
		super.GotoPage(gotopage);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		bean = new Board();
		
		//no는 시퀀스가 알아서 처리하므로 무시합니다.
//		bean.setNo(no);
		
		bean.setContent(request.getParameter("content"));
		bean.setPassword(request.getParameter("password"));
		bean.setRegdate(request.getParameter("regdate"));
		bean.setTitle(request.getParameter("title"));
		bean.setWriter(request.getParameter("writer"));
		
		int groupno = Integer.parseInt(request.getParameter("groupno"));
		bean.setGroupno(groupno);
		
		int depth = Integer.parseInt(request.getParameter("depth"));
		bean.setDepth(depth + 1);
		
		
		String gotopage = "";
		if (this.validate(request) == true) {
			BoardDao dao = new BoardDao();
			int cnt = -9999;
			cnt = dao.ReplyData(bean, groupno);
			
			new BoardCounselListController().doGet(request, response);
		}else {
			request.setAttribute("bean", bean);
			super.doPost(request, response);
			gotopage = "/board/boReplyForm.jsp";
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
