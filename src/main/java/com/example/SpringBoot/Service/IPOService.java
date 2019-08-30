package com.example.SpringBoot.Service;

import java.sql.SQLException;
import java.util.List;

import com.example.SpringBoot.Model.IPODetail;

public interface IPOService {
	public boolean insertIPO(IPODetail ipo) throws SQLException;

	public List<IPODetail> getIPOList() throws SQLException;

}
