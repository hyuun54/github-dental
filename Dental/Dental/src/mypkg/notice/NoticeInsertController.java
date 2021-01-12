package mypkg.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.bean.Notice;
import mypkg.common.SuperClass;
import mypkg.dao.NoticeDao;

public class NoticeInsertController extends SuperClass{
	private Notice bean = null ;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		String gotopage = "/notice/noInsertForm.jsp";
		super.GotoPage(gotopage);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		bean  = new Notice();
		//bean.setNo(no); //시퀀스는 필요 없음
		bean.setContent( request.getParameter("content") );
		bean.setTitle( request.getParameter("title") );
		bean.setWriter( request.getParameter("writer") );	
		
		System.out.println( bean );
		
		if ( this.validate( request ) == false ) {			
			request.setAttribute("bean", bean);
			super.doPost(request, response);
			String gotopage = "/notice/noInsertForm.jsp";
			super.GotoPage(gotopage);
		}else{
			//DAO 객체를 생성한다.
			NoticeDao dao = new NoticeDao();			
			int cnt = -99999 ; 			
			//Bean 객체를 이용하여 해당 게시물을 추가한다.
			cnt = dao.InsertData(bean) ;
			new NoticeListController().doGet( request, response );
		}
	}
	
	@Override
	public boolean validate(HttpServletRequest request) {
		final String PREFIX = "err" ;
		boolean isCheck = true ; //기본 값으로 true이고, 유효성 검사에 문제가 생기면 false으로 변경
		
		if( bean.getTitle().length() < 1 || bean.getTitle().length() > 30 ){
			request.setAttribute( PREFIX + "title", "제목은 1글자 이상 30글자 이하이어야 합니다.");
			isCheck = false  ;
		}
		if( bean.getContent().length() < 5 || bean.getContent().length() > 200 ){
			request.setAttribute( PREFIX + "content", "글 내용은 5자리 이상 200자리 이하이어야 합니다.");
			isCheck = false  ;
		}
		return isCheck ;
	}
}
