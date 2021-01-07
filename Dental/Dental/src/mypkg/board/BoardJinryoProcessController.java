package mypkg.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.common.SuperClass;

public class BoardJinryoProcessController extends SuperClass{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("시술 과정 doget");
		
		super.doGet(request, response);
		String gotopage = "/board/jinryoProcessForm.jsp";
		super.GotoPage(gotopage);
	}
}
