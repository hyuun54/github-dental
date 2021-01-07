package mypkg.bean;

public class Order {
	private int oid;
	private String mid;
	private String orderdate;
	private String remark;
	
	@Override
	public String toString() {
		String imsi = "[oid=" + oid + ", mid=" + mid + ", orderdate=" + orderdate + ", remark=" + remark + "]";
		return imsi;
	}
	
	public Order() {
		
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
