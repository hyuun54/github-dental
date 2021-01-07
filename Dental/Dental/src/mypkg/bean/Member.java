package mypkg.bean;

public class Member {
	private String id;
	private String name;
	private String password;
	private String birthdate ;
	private String gender;
	private String zipcode;
	private String address1;
	private String address2;
	private String phone;
	private String email;
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", password=" + password + ", birthdate=" + birthdate
				+ ", gender=" + gender + ", zipcode=" + zipcode + ", address1=" + address1 + ", address2=" + address2
				+ ", phone=" + phone + ", email=" + email + ", mpoint=" + mpoint + "]";
	}
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getMpoint() {
		return mpoint;
	}
	public void setMpoint(int mpoint) {
		this.mpoint = mpoint;
	}
	private int mpoint;
}

