package com.example.SpringBoot.Controller;

import java.sql.SQLException;

import org.springframework.web.servlet.ModelAndView;

import com.example.SpringBoot.Model.Sector;

public interface SectorController {
	public boolean insertSector(Sector sector) throws SQLException;

	//public Company updateCompany(Company company);

	public ModelAndView getSectorList() throws Exception;

}
