package mypkg.bean;

public class Reservation {
	private String no;
	private String name;
	private String rephone;
	private String sector;
	private String redate;
	private String rehour;
	private String comments;
	
	
	public Reservation() {
		super();	
	}
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRephone() {
		return rephone;
	}
	public void setRephone(String rephone) {
		this.rephone = rephone;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getRedate() {
		return redate;
	}
	public void setRedate(String redate) {
		this.redate = redate;
	}
	public String getRehour() {
		return rehour;
	}
	public void setRehour(String rehour) {
		this.rehour = rehour;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
		
}


