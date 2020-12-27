package mypkg.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.common.SuperClass;

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
		
		if (this.validate(request) == false) {
			//유효성 검사 실패
			String gotopage = "/member/meLoginForm.jsp";
			request.setAttribute("id", this.id);
			request.setAttribute("password", this.password);
			super.doPost(request, response);
			super.GotoPage(gotopage);
		}else {
			//유효성 검사 문제 없음
			
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
