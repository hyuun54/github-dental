package mypkg.shopping;

import java.util.HashMap;
import java.util.Map;

//나의 카트를 관리하는 관리자
public class MyCartList {
	//orderlists : 카트에 담은 정보(상품 번호, 주문 수량)를 저장하고 있는 맵 컬렉션
	private Map<Integer, Integer> orderlists = null;
	
	public MyCartList() {
		this.orderlists = new HashMap<Integer, Integer>();
	}
	
	// 장바구니 내역을 모두 삭제합니다.
	// 주로 결재가 이루어질 때 사용이 됩니다.
	public void RemoveAllProductInfo() {
		this.orderlists.clear();
	}
	
	// 장바구니 내역 정보를 반환해줍니다.
	public Map<Integer, Integer> GetAllOrderLists(){
		return this.orderlists;
	}
	
	//장바구니 내역 정보를 수정합니다.
	public void EditOrder(int pnum, int stock) {
		// pnum은 상품 번호, stock는 수정할 수량
		this.AddOrder(pnum, stock);
	}
	
	//장바구니에 들어 있는 해당 상품을 삭제합니다.
	public void DeleteOrder(int pnum) {
		// pnum은 상품 번호
		this.orderlists.remove(pnum);
	}
	
	//장바구니에 상품을 추가합니다.
	public void AddOrder(int pnum, int stock) {
		// pnum은 상품 번호, stock는 수정할 수량
		if (this.orderlists.containsKey(pnum)) { //동일한 물건이 있는 경우
			int newstock = this.orderlists.get(pnum) + stock;
			this.orderlists.put(pnum, newstock);
		} else {
			this.orderlists.put(pnum, stock);
		}
	}
}
