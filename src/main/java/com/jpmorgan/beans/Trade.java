package com.jpmorgan.beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Class to define beans of Trades
 * @author Fernando
 *
 */
public class Trade {
	private ICurrency cur;
	private IEntity ent;
	private ITradeType tt;
	private Date instructionDate; 
	private Date settlementDate;
	private int units;
	private double pricePerUnit;
	private final SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy",Locale.ENGLISH);
	private Calendar c = Calendar.getInstance();
	
	public Trade(){
		
	}
	
	public Trade(
		ICurrency cur, 
		IEntity ent, 
		ITradeType tt, 
		String instructionDate, 
		String settlementDate, 
		int units,
		double pricePerUnit
	) {
		super();
		this.cur = cur;
		this.ent = ent;
		this.tt = tt;
		try {
			this.instructionDate = this.sdf.parse(instructionDate);
			this.setSettlementDate(settlementDate);
		} catch (ParseException e) {			
			e.printStackTrace();
		}
		
		this.units = units;
		this.pricePerUnit = pricePerUnit;
	}
	public ICurrency getCur() {
		return cur;
	}
	public void setCur(Currency cur) {
		this.cur = cur;
	}
	public IEntity getEnt() {
		return ent;
	}
	public void setEnt(IEntity ent) {
		this.ent = ent;
	}
	public ITradeType getTt() {
		return tt;
	}
	public void setTt(TradeType tt) {
		this.tt = tt;
	}
	public String getInstructionDate() {
		return this.sdf.format(instructionDate);
	}
	
	/**
	 * Function to save the instruction date. It receives a String but save a object of class Date.
	 * @param instructionDate String
	 */
	public void setInstructionDate(String instructionDate) {
		try {
			this.instructionDate = this.sdf.parse(instructionDate);			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	public String getSettlementDate() {
		return this.sdf.format(settlementDate);
	}
	
	/**
	 * Function to save the settlement date. It receives a String but save a object of class Date.
	 * @param instructionDate String
	 */
	public void setSettlementDate(String settlementDate) {
		try {
			this.settlementDate = this.sdf.parse(settlementDate);			
			this.c.setTime(this.settlementDate);
			int iDayOfWeek = this.c.get(Calendar.DAY_OF_WEEK);
			/*
			 * We add 1 day to settlement date until the settlement date not fall in weekend
			 */
			while(!((iDayOfWeek>=this.cur.getWeekStart())&&(iDayOfWeek<=this.cur.getWeekEnds()))){
				this.c.add(Calendar.DATE, 1);
				iDayOfWeek = this.c.get(Calendar.DAY_OF_WEEK);
			}
			this.settlementDate = this.c.getTime();			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}
	public double getPricePerUnit() {
		return pricePerUnit;
	}
	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	
	public Date getSettlementDateAsDate(){
		return this.settlementDate;
	}
	
}
