package mypkg.product;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.common.SuperClass;
import mypkg.dao.ProductDao;
import mypkg.utility.FlowParameters;

public class ProductDeleteController extends SuperClass{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 해당 상품을 삭제하는 컨트롤러입니다.
		// 주문 상세 테이블의 remark 컬럼을 수정해야 합니다.
		// 상품 행을 삭제합니다.
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		FlowParameters parameters = new FlowParameters(
				request.getParameter("pageNumber"), 
				request.getParameter("pageSize"), 
				request.getParameter("mode"),
				request.getParameter("keyword")
				);
		
		System.out.println(parameters.toString());
		
		ProductDao dao = new ProductDao();
	
		int cnt = -999999;
		cnt = dao.DeletData(num);
		
		new ProductListController().doGet(request, response);
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
