package mypkg.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.common.SuperClass;

public class BoardJinryoTimeController extends SuperClass{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("진료 시간 안내 doget");
		
		super.doGet(request, response);
		String gotopage = "/board/jinryoTimeForm.jsp";
		super.GotoPage(gotopage);
	}
}
