package com.jpmorgan.beans;

import com.jpmorgan.beans.TradeType.TypeOfTrade;

public interface ITradeType {

	public TypeOfTrade getTradeType();

	public void setTradeType(TypeOfTrade tradeType);
}
