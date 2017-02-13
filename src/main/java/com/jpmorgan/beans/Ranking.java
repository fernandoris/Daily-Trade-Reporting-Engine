package com.jpmorgan.beans;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

public class Ranking {

	private Map<IEntity, Double> map = new HashMap<IEntity, Double>();
	private String name;
	
	public Ranking(String name){
		this.name = name;
	}
	
	public void addAmount(IEntity ent,double amount){
		if(!this.map.containsKey(ent)){
			this.map.put(ent, 0.0);
		}
		amount = this.map.get(ent)+amount;
		this.map.replace(ent, amount);
	}
	
	public void printRanking(){
		System.out.println(this.name);
		this.map.entrySet().stream().sorted(Map.Entry.<IEntity, Double>comparingByValue().reversed()) 
        .limit(10) 
        .forEach(System.out::println); 
	}
	
	
}
