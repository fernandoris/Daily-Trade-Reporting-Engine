package com.jpmorgan.beans;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import org.springframework.stereotype.Service;
/**
 * Class to associate a DayAmounts to a specific date and print the report
 * @author fernando
 *
 */
@Service("dailyReport")
public class DailyReport {

	//Map of dates and DayAmounts
	private Map<String, DayAmounts> map = new HashMap<String, DayAmounts>();
	//SimpleDateFormat to save the dates of trades as Strings that can be sorted
	private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
	
	public DailyReport(){
		
	}
	
	/**
	 * Add the amount of a trade to the incoming amount of a day
	 * @param date Date - The date of trade
	 * @param incoming Double - The amount of trade
	 */
	public void addIncoming(Date date,double incoming){
		if(!this.map.containsKey(this.sdf.format(date))){
			this.map.put(this.sdf.format(date),new DayAmounts());
		}
		incoming = this.map.get(this.sdf.format(date)).getIncoming()+incoming;
		this.map.get(this.sdf.format(date)).setIncoming(incoming);
	}
	
	/**
	 * Add the amount of a trade to the outgoing amount of a day
	 * @param date Date - The date of trade
	 * @param outgoing Double - The amount of trade
	 */
	public void addOutgoing(Date date,double outgoing){
		if(!this.map.containsKey(this.sdf.format(date))){
			this.map.put(this.sdf.format(date),new DayAmounts());
		}
		outgoing = this.map.get(this.sdf.format(date)).getOutgoing()+outgoing;
		this.map.get(this.sdf.format(date)).setOutgoing(outgoing);
	}
	
	/**
	 * function that prints the daily report of the data stored in the Map
	 */
	public void printDailyReport(){
		SortedSet<String> keys = new TreeSet<String>(this.map.keySet());
		for (String key : keys) { 
		   System.out.println(key+" Incoming: "+this.map.get(key).getIncoming()+" Outgoing: "+this.map.get(key).getOutgoing());
		}
	}
}
