package com.example.SpringBoot.Service;

import java.util.List;

import com.example.SpringBoot.Model.StockExchange;



public interface StockExchangeService {
	public boolean insertStockRecord(StockExchange stockExchange) throws Exception;
   // public StockExchange updateStockRecord(StockExchange stockExchange);
	public List<StockExchange> getStockList() throws Exception;
}
