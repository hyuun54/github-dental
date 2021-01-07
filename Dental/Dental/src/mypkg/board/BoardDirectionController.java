package mypkg.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.common.SuperClass;

public class BoardDirectionController extends SuperClass{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("오시는 길 doget");
		
		super.doGet(request, response);
		String gotopage = "/board/directionForm.jsp";
		super.GotoPage(gotopage);
	}
}
