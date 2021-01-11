package mypkg.member;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.bean.Member;
import mypkg.common.SuperClass;
import mypkg.dao.MemberDao;

public class MemberDetailViewController extends SuperClass{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		MemberDao dao = new MemberDao();
		
		Member bean = dao.SelectDataByPk(id);
		
		request.setAttribute("bean", bean);
		
		super.doGet(request, response);
		
		String gotopage = "member/meDetailView.jsp";
		super.GotoPage(gotopage);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
		String gotopage = "";
		if (this.validate(request) == true) {
			gotopage = "";
			super.GotoPage(gotopage);
		}else {
			gotopage = "";
			super.GotoPage(gotopage);
		}
	}
	
	@Override
	public boolean validate(HttpServletRequest request) {
		boolean isCheck = true;
				
		return isCheck;
	}
}
