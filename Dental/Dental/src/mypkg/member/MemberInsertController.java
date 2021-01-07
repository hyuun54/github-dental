package mypkg.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.bean.Member;
import mypkg.common.SuperClass;
import mypkg.dao.MemberDao;

public class MemberInsertController extends SuperClass{
	private Member bean = null;
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		super.doGet(request, response);
		String gotopage = "member/meInsertFrom.jsp" ;
		super.GotoPage(gotopage);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		bean = new Member();
		bean.setName( request.getParameter("name"));
		bean.setId( request.getParameter("id") );
		bean.setAddress1( request.getParameter("address1") );	
		bean.setAddress2( request.getParameter("address2") );
		bean.setGender( request.getParameter("gender") );
		if( request.getParameter("mpoint") != null || request.getParameter("mpoint").equals("") == false ){
			bean.setMpoint( Integer.parseInt( request.getParameter("mpoint") ));				
		}
		bean.setPassword( request.getParameter("password") );
		bean.setZipcode( request.getParameter("zipcode") );
		bean.setPhone( request.getParameter("phone") );
		bean.setEmail( request.getParameter("email") );
		bean.setBirthdate( request.getParameter("birthdate") );
		
		String gotopage = "";
		if ( this.validate( request ) == true ) {
			gotopage = "member/meLoginForm.jsp";		
			//DAO 객체를 생성한다.
			MemberDao mdao = new MemberDao();			
			int cnt = -99999 ; 			
			//Bean 객체를 이용하여 해당 게시물을 추가한다.
			cnt = mdao.InsertData(bean) ;
			
			super.session.setAttribute( "message" , "축하합니다. 회원 가입이 되었습니다. 로그인 후  메인 페이지로 이동하겠습니다." );
			// 회원 가입을 성공하면, 바로 로그인되도록 처리해줍니다.
			// doGet() 메소드를 사용하면 안되욧....
			// doPost() 메소드를 호출하여 바로 로그인을 수행합니다.
			new MemberLoginController().doPost(request, response);
		}else {
			gotopage = "member/meInsertForm.jsp";  
			request.setAttribute("bean", bean);
			super.doPost(request, response);
			super.GotoPage( gotopage );
			}	
	}
	@Override
	public boolean validate(HttpServletRequest request) {
		boolean isCheck = true; // 기본 값으로 true이고 , 유효성 검사에 문제가 생기면 false으로 변경 
		
		if( bean.getId().length() < 4 || bean.getId().length() > 10 ){
			request.setAttribute( super.PREFIX + "id", "아이디는 4자리 이상 10자리 이하이어야 합니다.");
			isCheck = false  ;
		}
		return isCheck;
	}
}
