package mypkg.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.bean.Board;
import mypkg.bean.Member;
import mypkg.common.SuperClass;
import mypkg.dao.BoardDao;
import mypkg.dao.MemberDao;
import mypkg.utility.FlowParameters;

public class BoardDetailViewController extends SuperClass{
	private String boPassword;
	private int no;
	private FlowParameters parameters = null;
	private Board bean = null;
	private BoardDao dao = null;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member memberBean = null;
		this.no = Integer.parseInt(request.getParameter("no"));
		
		this.dao = new BoardDao();
		
		this.bean = dao.SelectDataByPk(no);
		
		this.parameters
		= new FlowParameters(
				request.getParameter("pageNumber"), 
				request.getParameter("pageSize"),
				request.getParameter("mode"), 
				request.getParameter("keyword")
				);
		
		
		super.doGet(request, response);
		if (super.session.getAttribute("loginfo") != null) {
			memberBean = (Member) super.session.getAttribute("loginfo");
			if (memberBean.getId().equals("admin")) {
				//관리자 아이디의 경우 비밀번호 입력 생략
				String gotopage = "/board/boardDetailView.jsp";
				request.setAttribute("bean", this.bean);
				
				super.doGet(request, response);
				super.GotoPage(gotopage);
			}
		}
		
		
		if (this.bean != null) {
			if (this.bean.getReply().equals("답변")) {
				//답변의 경우 비밀번호 생략
				String gotopage = "/board/boardDetailView.jsp";
				request.setAttribute("bean", this.bean);
				
				super.doGet(request, response);
				super.GotoPage(gotopage);
			}else {
				//답변이 아닐 경우 비밀번호 입력창
				request.setAttribute("parameters", parameters.toString());
				
				super.doGet(request, response);
				String gotopage = "/board/passwordForm.jsp";
				super.GotoPage(gotopage);
			}
		}else {
			new BoardCounselListController().doGet(request, response);
		}
		
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.boPassword = request.getParameter("boPassword");
		
		String gotopage = "";
		
		if (this.validate(request) == false) {
			//유효성 검사 실패
			gotopage = "/board/passwordForm.jsp";
			super.GotoPage(gotopage);
		}else {
			//유효성 검사 문제 없음
			
			if (this.bean.getPassword().equals(this.boPassword)) {
				//게시물 패스워드 일치함
				gotopage = "/board/boardDetailView.jsp";
				request.setAttribute("bean", this.bean);
				
				super.doPost(request, response);
				super.GotoPage(gotopage);
			} else {
				//패스우드 일치하지 않음
				gotopage = "/board/passwordForm.jsp";
				String errfail = "잘못된 비밀번호입니다";
				request.setAttribute("errfail", errfail);
				
				super.doPost(request, response);
				super.GotoPage(gotopage);
			}
		}
	}
	
	@Override
	public boolean validate(HttpServletRequest request) {
		boolean isCheck = true; // 기본값은 true
		
		//만일 유효성 검사에 문제가 있으면 false로 변경합니다
		if (this.boPassword.length() == 0) {
			request.setAttribute("errboPassword", "비밀번호를 입력해주세요.");
			isCheck = false;
		}
		
		return isCheck;
	}
}
