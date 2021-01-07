package mypkg.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.common.SuperClass;

public class MemberLogoutController extends SuperClass{
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
					
		//로그인 정보를 세션 영역에서 지우기
		super.session.invalidate(); 
		
		String gotopage = "/common/main.jsp" ; 
		super.GotoPage(gotopage); 
		
	}
	

}