package com.example.SpringBoot.Controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.SpringBoot.Model.Sector;
import com.example.SpringBoot.Service.SectorService;

@Controller
public class SectorControllerImpl implements SectorController {
	@Autowired
	private SectorService sectorService;
	
	@RequestMapping(path = "/createSector")
	public ModelAndView registerSector(Model model) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sectorReg");
		model.addAttribute("sector",new Sector());
		return mv;
	}	
	
	@RequestMapping(value = "/registerSector")
	public ModelAndView registerAdmin(@Valid @ModelAttribute("sector") Sector sector, BindingResult result,
			HttpServletRequest request, HttpSession session, ModelMap map) throws SQLException {
		
		ModelAndView mav = null;
		if(result.hasErrors()){
			System.out.println("errors");
			System.out.println(result.getAllErrors());
			map.addAttribute("sector", sector);
			mav = new ModelAndView("sectorReg");
			return mav;
		}
		map.addAttribute("sector", sector);
		//companyService.insertCompany(company);
		sectorService.insertSector(sector);
		mav = new ModelAndView("sectorList");
		mav.addObject("sectorList", sectorService.getSectorList());
		return mav;

	}

	@Override
	public boolean insertSector(Sector sector) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ModelAndView getSectorList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
