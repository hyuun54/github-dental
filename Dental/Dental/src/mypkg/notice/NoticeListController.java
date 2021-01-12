package mypkg.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.bean.Notice;
import mypkg.common.SuperClass;
import mypkg.dao.NoticeDao;
import mypkg.utility.FlowParameters;
import mypkg.utility.Paging;

public class NoticeListController extends SuperClass{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeDao dao = new NoticeDao();
		
		// 페이징과 필드 검색을 위한 파라미터를 우선 챙깁니다.
		FlowParameters parameters 
			= new FlowParameters(
					request.getParameter("pageNumber"), 
					request.getParameter("pageSize"), 
					request.getParameter("mode"), 
					request.getParameter("keyword")
					);
		System.out.println("페이지 정보 : " + parameters.toString());
		
		int totalCount 
			= dao.SelectTotalCount(
				parameters.getMode(),
				parameters.getKeyword()
				);
		
		String contextPath = request.getContextPath();
		String myurl = contextPath + "/tooth?command=boCounselList";
		
		Paging pageInfo
			= new Paging(
				parameters.getPageNumber(), 
				parameters.getPageSize(), 
				totalCount, 
				myurl, 
				parameters.getMode(), 
				parameters.getKeyword()
				);
	
		// % 는 like 연산자 때문에 넣었습니다.
		List<Notice> lists = dao.SelectDataList(
				pageInfo.getBeginRow(), 
				pageInfo.getEndRow(), 
				parameters.getMode(), 
				parameters.getKeyword()
				);
		
		//바인딩 해야할 목록
		request.setAttribute("lists", lists); //공지 게시물 목록
		
		//페이징 관련 항목
		request.setAttribute("pagingHtml", pageInfo.getPagingHtml()); 
		request.setAttribute("pagingStatus", pageInfo.getPagingStatus()); 
		
		//검색 필드의 상태 값 저장을 위한 항목들
		request.setAttribute("mode", parameters.getMode()); 
		request.setAttribute("keyword", parameters.getKeyword()); 
		
		// 상세 보기, 수정, 삭제, 답글 등의 링크에 사용될 parameter list 문자열
		request.setAttribute("parameters", parameters.toString());
		
		super.doGet(request, response);
		
		String gotopage = "notice/noList.jsp";
		super.GotoPage(gotopage);
		}
}
