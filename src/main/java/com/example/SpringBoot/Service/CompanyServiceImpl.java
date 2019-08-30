package com.example.SpringBoot.Service;

import java.sql.SQLException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBoot.Dao.CompanyDao;
import com.example.SpringBoot.Model.Company;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDao companyDao;
	
	@Override
	public boolean insertCompany(Company company) throws SQLException {
		// TODO Auto-generated method stub
		//return companyDao.insertCompany(company) ;
		 companyDao.save(company) ;
		 return true;

	}

	@Override
	public boolean updateCompany(Company company) {
		// TODO Auto-generated method stub
		companyDao.save(company) ;
		 return true;
		
	}

	@Override
	public List<Company> getCompanyList() throws SQLException {
		//return companyDao.getCompanyList();
		return companyDao.findAll();
	}

}
