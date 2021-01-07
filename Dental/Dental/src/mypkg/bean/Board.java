package mypkg.bean;

public class Board {
	private int no;
	private String title;
	private String writer;
	private String password;
	private String content;
	private String regdate;
	private String reply;
	private int groupno ;
	private int depth ;
	private String remark;


	public Board() {
	}


	@Override
	public String toString() {
		return "Board [no=" + no + ", title=" + title + ", writer=" + writer + ", password=" + password + ", content="
				+ content + ", regdate=" + regdate + ", reply=" + reply + ", groupno="
				+ groupno + ", depth=" + depth + ", remark=" + remark + "]";
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
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		if (reply.equalsIgnoreCase("complete")) {
			this.reply = "답변 완료";
		}else if (reply.equalsIgnoreCase("reply")) {
			this.reply = "답변";
		}else {
			this.reply = "미완료";
		}
			
		
	}
	public int getGroupno() {
		return groupno;
	}
	public void setGroupno(int groupno) {
		this.groupno = groupno;
	}
	
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}	
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}	
}
