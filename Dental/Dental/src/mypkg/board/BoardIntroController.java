package mypkg.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.common.SuperClass;

public class BoardIntroController extends SuperClass{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("병원 소개 doget");
		
		super.doGet(request, response);
		String gotopage = "/board/introForm.jsp";
		super.GotoPage(gotopage);
	}
}
