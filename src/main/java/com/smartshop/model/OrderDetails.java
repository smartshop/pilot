package com.smartshop.model;

import java.util.ArrayList;
import java.util.List;

public class OrderDetails {
	
	private List<PurchasedUnit> purchasedUnits;

	public List<PurchasedUnit> getPurchasedUnits() {
		return purchasedUnits;
	}

	public void setPurchasedUnits(List<PurchasedUnit> purchasedUnits) {
		this.purchasedUnits = purchasedUnits;
	}
	
	public void addPurchasedUnits (PurchasedUnit purchasedUnit){
		
		if(this.purchasedUnits==null){
			this.purchasedUnits = new ArrayList<PurchasedUnit>();
		}
		this.purchasedUnits.add(purchasedUnit);
		
	}


}
