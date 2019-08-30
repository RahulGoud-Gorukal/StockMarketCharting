package com.example.SpringBoot.Service;

import java.sql.SQLException;
import java.util.List;

import com.example.SpringBoot.Model.Sector;

public interface SectorService {

	public boolean insertSector(Sector sector) throws SQLException;

	public boolean updateSector(Sector sector);

	public List<Sector> getSectorList() throws SQLException;

}
