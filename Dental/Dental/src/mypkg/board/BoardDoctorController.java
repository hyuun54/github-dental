package mypkg.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.common.SuperClass;

public class BoardDoctorController extends SuperClass{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("의료진 소개 doget");
		
		super.doGet(request, response);
		String gotopage = "/board/doctorForm.jsp";
		super.GotoPage(gotopage);
	}
}
