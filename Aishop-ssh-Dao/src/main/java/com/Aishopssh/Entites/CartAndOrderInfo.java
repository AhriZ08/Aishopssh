package com.Aishopssh.Entites;

public class CartAndOrderInfo<Ta, Tb> {
	private Ta cartlist;
	private Tb orderinfo;
	public Ta getCartlist() {
		return cartlist;
	}
	public void setCartlist(Ta cartlist) {
		this.cartlist = cartlist;
	}
	public Tb getOrderinfo() {
		return orderinfo;
	}
	public void setOrderinfo(Tb orderinfo) {
		this.orderinfo = orderinfo;
	}
	@Override
	public String toString() {
		return "CartAndOrderInfo [cartlist=" + cartlist + ", orderinfo=" + orderinfo + "]";
	}

}
