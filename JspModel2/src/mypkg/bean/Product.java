package mypkg.bean;

public class Product {
	private int num;
	private String name;
	private String company;
	private String image;
	private int stock;
	private int price;
	private String category;
	private String contents;
	private int point; // 제품 1개 구매시 주어지는 포인트
	private String inputdate;
	
	@Override
	public String toString() {
		String imsi = "[num=" + num + ", name=" + name + ", company=" + company + ", image=" + image + ", stock=" + stock
				 + ", price=" + price + ", category=" + category + ", contents=" + contents + ", point=" + point + ", inputdate=" + inputdate + "]";
		return imsi;
	}
	
	public Product() {
		
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getInputdate() {
		return inputdate;
	}
	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	}
	
}
