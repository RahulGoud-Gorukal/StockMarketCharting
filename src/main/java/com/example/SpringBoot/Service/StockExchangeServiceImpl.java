package com.example.SpringBoot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBoot.Dao.StockExchangeDao;
import com.example.SpringBoot.Model.StockExchange;


@Service
public class StockExchangeServiceImpl implements StockExchangeService {

	@Autowired
	private StockExchangeDao stockExchangeDao;

	@Override
	public boolean insertStockRecord(StockExchange stockExchange) throws Exception {
		// TODO Auto-generated method stub
		 stockExchangeDao.save(stockExchange);
		 return true;
	}
/*
	@Override
	public StockExchange updateStockRecord(StockExchange stockExchange) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public List<StockExchange> getStockList() throws Exception {
		// TODO Auto-generated method stub
		return stockExchangeDao.findAll();
	}

}
