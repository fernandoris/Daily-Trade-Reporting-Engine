package com.jpmorgan.beans;

public interface ICurrency {
	
	public String getSymbol();
	
	public void setSymbol(String symbol);
	
	public int getWeekStart();
	
	public int getWeekEnds();

	public double getAgreededFx();

	public void setAgreededFx(double agreededFx);
}
