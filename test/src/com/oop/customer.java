package com.oop;

public class customer {
	@Override
	public String toString() {
		return "customer [PatienID=" + PatienID + ", BillID=" + BillID + ", Amount=" + Amount + "]";
	}

	private String PatienID;
	private String BillID;
	private int Amount;
	
	public customer(String patientid, String billid, int amount) {
		
		PatienID = patientid;
		BillID = billid;
		Amount = amount;
	}

	public String getPatienID() {
		return PatienID;
	}

	public String getBillID() {
		return BillID;
	}

	public int getAmount() {
		return Amount;
	}

	
	
	
	
}
