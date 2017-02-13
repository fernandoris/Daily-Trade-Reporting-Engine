package com.jpmorgan.reports;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.jpmorgan.beans.Currency;
import com.jpmorgan.beans.Trade;

public class TradeTest {
	
	private Trade t;
	
	@Before
	public void before(){
		this.t= new Trade();
	}
	
	@Test
	public void dateOfTradeTest(){
		Currency cur = new Currency("USD",0);
		this.t.setCur(cur);
		this.t.setSettlementDate("12 Feb 2017");
		assertEquals("13 Feb 2017",this.t.getSettlementDate());
		this.t.setCur(new Currency("SAR",0.10));
		this.t.setSettlementDate("11 Feb 2017");
		assertEquals("12 Feb 2017",this.t.getSettlementDate());
		this.t.setCur(new Currency("AED",0.10));
		this.t.setSettlementDate("10 Feb 2017");
		assertEquals("12 Feb 2017",this.t.getSettlementDate());
	}
	
}
