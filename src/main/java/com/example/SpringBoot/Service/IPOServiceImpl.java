package com.example.SpringBoot.Service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBoot.Dao.IPODao;
import com.example.SpringBoot.Model.IPODetail;

@Service
public class IPOServiceImpl implements IPOService {
	@Autowired
	private IPODao ipoDao;

	@Override
	public boolean insertIPO(IPODetail ipo) throws SQLException {
		// TODO Auto-generated method stub
		ipoDao.save(ipo);
		return true;

	}

	@Override
	public List<IPODetail> getIPOList() throws SQLException {
		return ipoDao.findAll();
	}

}
