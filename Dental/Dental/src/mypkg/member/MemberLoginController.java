package mypkg.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.bean.Member;
import mypkg.common.SuperClass;
import mypkg.dao.MemberDao;

public class MemberLoginController extends SuperClass{
	private String id = null;
	private String password = null;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("회원 로그인 호출됨");
		super.doGet(request, response);
		String gotopage = "/member/meLoginForm.jsp";
		super.GotoPage(gotopage);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.id = request.getParameter("id");
		this.password = request.getParameter("password");
		
		String gotopage = "";
		
		if (this.validate(request) == false) {
			//유효성 검사 실패
			gotopage = "/member/meLoginForm.jsp";
			request.setAttribute("id", this.id);
			request.setAttribute("password", this.password);
			super.doPost(request, response);
			super.GotoPage(gotopage);
		}else {
			//유효성 검사 문제 없음
			MemberDao dao = new MemberDao();
			Member bean = dao.SelectData(this.id, this.password);
			
			super.doPost(request, response);
			
			if (bean == null) {
				//아이디 패스워드 일치하는 항목 없음
				gotopage = "member/meLoginForm.jsp";
				String errfail = "가입하지 않은 아이디이거나, 잘못된 비밀번호입니다";
				request.setAttribute("errfail", errfail);
				
				super.GotoPage(gotopage);
			} else {
				//로그인 성공
				//bean을 session에 loginfo로 바인딩 
				super.session.setAttribute("loginfo", bean);
				gotopage = "common/main.jsp";
				
				super.GotoPage(gotopage);
			}
		}
	}
	
	@Override
	public boolean validate(HttpServletRequest request) {
		boolean isCheck = true; // 기본값은 true
		
		//만일 유효성 검사에 문제가 있으면 false로 변경합니다
		if (this.id.length() == 0) {
			request.setAttribute("errid", "아이디를 입력해주세요.");
			isCheck = false;
		}
		if (this.password.length() == 0) {
			request.setAttribute("errpassword", "비밀번호를 입력해주세요.");
			isCheck = false;
		}
		
		return isCheck;
	}
}
