package mypkg.utility;

public class pageTest {

	public static void main(String[] args) {
		String _pageNumber = "2";
		String _pageSize = "10";
		int totalCount = 33;
		String url = "boList.jsp";
		String mode = ""; //검색모드
		String keyword = ""; //검색 키워드
		
		Paging pageInfo 
			= new Paging(_pageNumber, _pageSize, totalCount, url, mode, keyword);
		
		//pageTest.jsp 파일을 만들고, 아래 결과물을 <body> 태그에 넣어서 실행
		
		System.out.println(pageInfo.getPagingHtml());
	}

}
