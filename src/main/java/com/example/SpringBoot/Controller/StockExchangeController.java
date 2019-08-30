package com.example.SpringBoot.Controller;


import java.util.List;


import com.example.SpringBoot.Model.StockExchange;


public interface StockExchangeController {
	public boolean insertStockRecord(StockExchange stockExchange)throws Exception;
	//public StockExchange updateStockRecord(StockExchange stockExchange);
	public List<StockExchange> getStockList() throws Exception;

}
