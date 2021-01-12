package mypkg.bean;

public class Notice {
	private int no; //글번호
	private String title; //제목
	private String writer; //작성자
	private String password = "1234"; //글비밀번호
	private String content; //글내용
	private int readhit; //조회수
	private String regdate; //작성일자
	
	@Override
	public String toString() {
		String imsi = "[no=" + no + ", title=" + title + ", writer=" + writer + ", password=" + password + ", content=" + content
				 + ", readhit=" + readhit + ", regdate=" + regdate + "]";
		return imsi;
	}
	
	public Notice() {
			
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadhit() {
		return readhit;
	}
	public void setReadhit(int readhit) {
		this.readhit = readhit;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
}
