package mypkg.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.bean.Member;
import mypkg.bean.Notice;
import mypkg.common.SuperClass;
import mypkg.dao.NoticeDao;
import mypkg.utility.FlowParameters;

public class NoticeDetailViewController extends SuperClass{
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		int cnt = -999999;
		NoticeDao dao = new NoticeDao();
		
		Notice bean = dao.SelectDataByPk(no);
		
		FlowParameters parameters
		= new FlowParameters(
				request.getParameter("pageNumber"), 
				request.getParameter("pageSize"),
				request.getParameter("mode"), 
				request.getParameter("keyword")
				);
		
		super.doGet(request, response);
		
		if (bean != null) {
			//admin이 아니면 조회수를 +1 증가 시킵니다.
			// 1) bean.getWriter()와 세션의 loginfo의 id를 비교합니다.
			// 동일하지 않으면 조회수를 +1
			
			//login : 현재 접속한 사람의 정보를 저장하고 있는 객체입니다.
			if (super.session.getAttribute("loginfo") != null) {
				Member login = (Member)super.session.getAttribute("loginfo");
				if (!login.getId().equals("admin")) {
					cnt = dao.UpdateReadhit(no);
				}
			}else {
				cnt = dao.UpdateReadhit(no);
			}
			
			request.setAttribute("bean", bean);
			request.setAttribute("parameters", parameters.toString());
			
			//상세 보기로 이동
			String gotopage = "notice/noticeDetailView.jsp";
			super.GotoPage(gotopage);
			//
		}else {
			// 목록 페이지로 다시 돌아갑니다.
			// 다음과 같이 코딩하면 request 와 response 객체가 그대로 다시 넘어갑니다.
			new NoticeListController().doGet(request, response);
		}
		
	}
}
