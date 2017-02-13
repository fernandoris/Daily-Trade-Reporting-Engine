package com.jpmorgan.beans;

/**
 * Bean to save the incoming and outgoing data of a day.
 * @author Fernando
 *
 */
public class DayAmounts {
	
	//Total amount of income
	private double incoming = 0;
	//Total amount of outgoing
	private double outgoing = 0;

	public DayAmounts(){
		
	}
	
	public double getIncoming() {
		return incoming;
	}
	public void setIncoming(double incoming) {
		this.incoming = incoming;
	}
	public double getOutgoing() {
		return outgoing;
	}
	public void setOutgoing(double outgoing) {
		this.outgoing = outgoing;
	}
	
	
	
}
