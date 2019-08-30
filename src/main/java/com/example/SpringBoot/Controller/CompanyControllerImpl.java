package com.example.SpringBoot.Controller;

import java.sql.SQLException;
import java.util.List;

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

import com.example.SpringBoot.Model.Company;
import com.example.SpringBoot.Model.Sector;
import com.example.SpringBoot.Service.CompanyService;
import com.example.SpringBoot.Service.SectorService;

@Controller
public class CompanyControllerImpl implements CompanyController {

	@Autowired
	private CompanyService companyService;
	@Autowired
	private SectorService sectorService;

	public boolean insertCompany(Company company) throws SQLException {
		return companyService.insertCompany(company);

	}
	
	@RequestMapping(path = "/companyList")
	public ModelAndView getCompanyList() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("companyList");
		mv.addObject("companyList", companyService.getCompanyList());
		return mv;
	}

	@RequestMapping(value = "/registerCompany")
	public ModelAndView registerAdmin(@Valid @ModelAttribute("company") Company company, BindingResult result,
			HttpServletRequest request, HttpSession session, ModelMap map) throws SQLException {

		ModelAndView mav = null;
		if (result.hasErrors()) {
			System.out.println("errors");
			System.out.println(result.getAllErrors());
			map.addAttribute("company", company);
			mav = new ModelAndView("companyReg");
			return mav;
		}
		map.addAttribute("company", company);
		companyService.insertCompany(company);

		mav = new ModelAndView("companyList");
		mav.addObject("companyList", companyService.getCompanyList());
		return mav;

	}

	@RequestMapping(path = "/create")
	public ModelAndView registerCompany(Model model) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("companyReg");
		model.addAttribute("company", new Company());
		mv.addObject("sectorList", sectorService.getSectorList());
		return mv;
	}

	@RequestMapping(path = "/updateCompany")
	public ModelAndView updateCompany(Model model) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("updateCompany");
		model.addAttribute("updateCompany", new Company());
		return mv;
	}

	@RequestMapping(value = "/updatedDisplay")
	public ModelAndView updateCompany(@ModelAttribute("updateCompany") Company company, BindingResult result,
			HttpServletRequest request, HttpSession session, ModelMap map) throws SQLException {

		ModelAndView mav = null;
		if (result.hasErrors()) {
			System.out.println("errors");
			System.out.println(result.getAllErrors());
			map.addAttribute("updateCompany", company);
			mav = new ModelAndView("updateCompany");
			return mav;
		}
		map.addAttribute("updateCompany", company);
		companyService.updateCompany(company);

		mav = new ModelAndView("companyList");
		mav.addObject("companyList", companyService.getCompanyList());
		return mav;

	}

}
