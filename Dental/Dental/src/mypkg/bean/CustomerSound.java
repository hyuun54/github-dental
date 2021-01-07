package mypkg.bean;

public class CustomerSound {
	private int no;
	private String name;
	private String phone;
	private String reason; //칭찬합니다 불편합니다 개선해주세요
	private String content; //내용
	
	@Override
	public String toString() {
		String imsi = "[no=" + no + ", name=" + name + ", phone=" + phone + ", reason=" + reason + ", content=" + content + "]";
		return imsi;
	}
	
	public CustomerSound() {
		
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
