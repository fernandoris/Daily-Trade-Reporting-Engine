package com.jpmorgan.reports;

import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jpmorgan.beans.DailyReport;
import com.jpmorgan.beans.Ranking;
import com.jpmorgan.beans.Trade;

public class App 
{
	public static ApplicationContext appContext = new ClassPathXmlApplicationContext("com/jpmorgan/beans/beans.xml");
	//Queue of trades
	public static LinkedBlockingQueue<Trade> queue = new LinkedBlockingQueue<Trade>();
	//Maps for rankings
	public static Ranking rankingIncoming = new Ranking("Incoming Ranking:");
	public static Ranking rankingOutgoing = new Ranking("Outgoing Ranking:");

	
    public static void main( String[] args )
    {
    	
    	App.loadQueue();
    	while(!App.queue.isEmpty()){
    		Trade t = App.queue.poll();
    		App.processTrade(t);    		
    	}
    	DailyReport dr = (DailyReport) App.appContext.getBean("dailyReport");
    	dr.printDailyReport();
    	App.rankingIncoming.printRanking();
    	App.rankingOutgoing.printRanking();
    }
    
    
    /**
     * Function that load the Queue with data from beans.
     * I thought of using a socket to collect the input data but would have needed another program to 
     * send the data to the socket. I also thought about loading the data from an input file but 
     * I found it more elegant to use Spring
     */
    private static void loadQueue(){
    	
       
    	for(int i =1;i<=App.appContext.getBeansOfType(com.jpmorgan.beans.Trade.class).size();i++){
    		App.queue.add((Trade) appContext.getBean("trade"+i));
    	}
    	
    }
    
    /**
     * This function receives a Trade object calculate its amount and pass it to rankings and 
     * daily reports.
     * @param trade
     */
    private static void processTrade(Trade trade){
    	DailyReport dr = (DailyReport) App.appContext.getBean("dailyReport");
    	Double amount = trade.getPricePerUnit()*trade.getUnits()*trade.getCur().getAgreededFx();
    	if(trade.getTt().getTradeType()==com.jpmorgan.beans.TradeType.TypeOfTrade.B){
    		dr.addOutgoing(trade.getSettlementDateAsDate(),amount);
    		App.rankingOutgoing.addAmount(trade.getEnt(), amount);
    	}else{
    		dr.addIncoming(trade.getSettlementDateAsDate(),amount);
    		App.rankingIncoming.addAmount(trade.getEnt(), amount);
    	}
    }
    
}
