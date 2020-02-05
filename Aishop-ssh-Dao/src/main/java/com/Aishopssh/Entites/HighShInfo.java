package com.Aishopssh.Entites;

import java.io.Serializable;

public class HighShInfo implements Serializable {
	private String shopName;
	private String shopDim;
	private int priceMin;
	private int priceMax;
	private int shopType;

	public HighShInfo(String shopName, String shopDim, int priceMin, int priceMax, int shopType) {
		this.shopName = shopName;
		this.shopDim = shopDim;
		this.priceMin = priceMin;
		this.priceMax = priceMax;
		this.shopType = shopType;
	}

	public HighShInfo(){}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopDim() {
		return shopDim;
	}

	public void setShopDim(String shopDim) {
		this.shopDim = shopDim;
	}

	public int getPriceMin() {
		return priceMin;
	}

	public void setPriceMin(int priceMin) {
		this.priceMin = priceMin;
	}

	public int getPriceMax() {
		return priceMax;
	}

	public void setPriceMax(int priceMax) {
		this.priceMax = priceMax;
	}

	public int getShopType() {
		return shopType;
	}

	public void setShopType(int shopType) {
		this.shopType = shopType;
	}
}
