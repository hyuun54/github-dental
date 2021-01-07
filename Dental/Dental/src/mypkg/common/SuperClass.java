package mypkg.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SuperClass implements SuperController, Validator{
	public static final String PREFIX = "err";
	private HttpServletRequest request = null;
	private HttpServletResponse response = null;
	protected HttpSession session = null;
	
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//SuperClass에서 request, response, session 객체 생성
		this.request = request;
		this.response= response;
		this.session = request.getSession();
	}
	
	@Override
	public boolean validate(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doProcess(request, response);
		
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doProcess(request, response);
	}
	
	public void setErrorMessage(String message) {
		// request 영역에 "errmsg"이라는 이름으로 오류 메시지를 바인딩합니다.
		// 오류 메시지는 common.jsp 파일의 하단에서 보여 줍니다.
		this.request.setAttribute("errmsg", message);
	}
	
	public void GotoPage(String url) {
		RequestDispatcher dispatcher = this.request.getRequestDispatcher(url);
		
		try {
			dispatcher.forward(this.request, this.response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
