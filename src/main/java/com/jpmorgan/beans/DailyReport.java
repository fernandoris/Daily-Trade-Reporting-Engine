package com.jpmorgan.beans;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

@Service("dailyReport")
public class DailyReport {

	private Map<String, DayAmounts> map = new HashMap<String, DayAmounts>();
	private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
	
	public DailyReport(){
		
	}
	
	public void addIncoming(Date date,double incoming){
		if(!this.map.containsKey(this.sdf.format(date))){
			this.map.put(this.sdf.format(date),new DayAmounts());
		}
		incoming = this.map.get(this.sdf.format(date)).getIncoming()+incoming;
		this.map.get(this.sdf.format(date)).setIncoming(incoming);
	}
	
	public void addOutgoing(Date date,double outgoing){
		if(!this.map.containsKey(this.sdf.format(date))){
			this.map.put(this.sdf.format(date),new DayAmounts());
		}
		outgoing = this.map.get(this.sdf.format(date)).getOutgoing()+outgoing;
		this.map.get(this.sdf.format(date)).setOutgoing(outgoing);
	}
	
	public void printDailyReport(){
		SortedSet<String> keys = new TreeSet<String>(this.map.keySet());
		for (String key : keys) { 
		   System.out.println(key+" Incoming: "+this.map.get(key).getIncoming()+" Outgoing: "+this.map.get(key).getOutgoing());
		}
	}
}
