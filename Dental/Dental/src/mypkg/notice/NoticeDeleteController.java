package mypkg.notice;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.board.BoardCounselListController;
import mypkg.common.SuperClass;
import mypkg.dao.NoticeDao;

public class NoticeDeleteController extends SuperClass{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		
		NoticeDao dao = new NoticeDao();
		
		int cnt = -999999;
		cnt = dao.DeletData(no);
		
		new NoticeListController().doGet(request, response);
	}
}
