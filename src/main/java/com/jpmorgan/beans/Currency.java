package com.jpmorgan.beans;

public class Currency implements ICurrency{

	private String symbol;
	private int weekStart;
	private int weekEnds;
	private double agreededFx;
	
	public Currency(String symbol,double agreededFx){
		this.symbol = symbol;
		this.agreededFx = agreededFx;
		this.init();
	}
	
	public Currency() {
		
	}	
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
		this.init();
	}
	public int getWeekStart() {
		return weekStart;
	}
	
	public int getWeekEnds() {
		return weekEnds;
	}
	
	/**
	 * Function that initializes the weekends depending on the currency
	 */
	private void init(){
		int ws = 2;
		int we = 6;
		if(this.symbol.equals("SAR")||this.symbol.equals("AED")){
			ws = 1;
			we = 5;
		}else if(this.symbol.equals("USD")){
			ws = 2;
			we = 6;
			//I suppose if the currency is USD the agreededFX is 1
			this.agreededFx = 1;
		}else{
			ws = 2;
			we = 6;
		}
		this.weekStart = ws;
		this.weekEnds = we;
	}

	public double getAgreededFx() {
		return agreededFx;
	}

	public void setAgreededFx(double agreededFx) {
		//I prevent agreededFX change if the currency is USD
		if(!this.symbol.equals("USD"))
			this.agreededFx = agreededFx;
	}

	
	
}
