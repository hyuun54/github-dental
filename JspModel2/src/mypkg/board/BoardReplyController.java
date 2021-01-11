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
		
		String gotopage = "board/boReplyForm.jsp";
		super.GotoPage(gotopage);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		bean = new Board();
		
		//no는 시퀀스가 알아서 처리하므로 무시합니다.
//		bean.setNo(no);
		//조회 수는 기본 값으로 채우질 예정
//		bean.setReadhit(request.getParameter("readhit"));
		
		bean.setContent(request.getParameter("content"));
		bean.setPassword(request.getParameter("password"));
		bean.setRegdate(request.getParameter("regdate"));
		bean.setSubject(request.getParameter("subject"));
		bean.setWriter(request.getParameter("writer"));
		
		int groupno = Integer.parseInt(request.getParameter("groupno"));
		bean.setGroupno(groupno);
		
		int orderno = Integer.parseInt(request.getParameter("orderno"));
		bean.setOrderno(orderno + 1);
		
		int depth = Integer.parseInt(request.getParameter("depth"));
		bean.setDepth(depth + 1);
		
		
		String gotopage = "";
		if (this.validate(request) == true) {
			BoardDao dao = new BoardDao();
			int cnt = -9999;
			cnt = dao.ReplyData(bean, groupno, orderno);
			
			new BoardListController().doGet(request, response);
		}else {
			request.setAttribute("bean", bean);
			super.doPost(request, response);
			gotopage = "board/boReplyForm.jsp";
			super.GotoPage(gotopage);
		}
	}
	
	@Override
	public boolean validate(HttpServletRequest request) {
		boolean isCheck = true;
				
		return isCheck;
	}
}
