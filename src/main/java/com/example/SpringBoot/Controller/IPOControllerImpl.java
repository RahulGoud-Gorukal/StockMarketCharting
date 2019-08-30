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

import com.example.SpringBoot.Model.IPODetail;
import com.example.SpringBoot.Service.CompanyService;
import com.example.SpringBoot.Service.IPOService;
import com.example.SpringBoot.Service.StockExchangeService;

@Controller
public class IPOControllerImpl implements IPOController {

	@Autowired
	private IPOService ipoService;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private StockExchangeService stockExchangeService;
	
	@Override
	public boolean insertIPO(IPODetail ipo) throws SQLException {
		// TODO Auto-generated method stub
		return ipoService.insertIPO(ipo);
	}

	@Override
	public List<IPODetail> getIPOList() throws SQLException {
		// TODO Auto-generated method stub
		return ipoService.getIPOList();
	}
		
	@RequestMapping(path = "/ipoList")
		public ModelAndView getIPO() throws Exception {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("ipoList");
			mv.addObject("ipoList",ipoService.getIPOList());
			return mv;
		}

		@RequestMapping(value = "/registerIpo")
		public ModelAndView registerIPO(@Valid @ModelAttribute("ipo")IPODetail ipo, BindingResult result,
				HttpServletRequest request, HttpSession session, ModelMap map) throws Exception {

			ModelAndView mav = null;
			if (result.hasErrors()) {
				System.out.println("errors");
				System.out.println(result.getAllErrors());
				map.addAttribute("ipo", ipo);
				mav = new ModelAndView("ipoReg");
				return mav;
			}
			map.addAttribute("ipo", ipo);
			ipoService.insertIPO(ipo);

			mav = new ModelAndView("ipoList");
			mav.addObject("ipoList", ipoService.getIPOList());
			mav.addObject("companyList",companyService.getCompanyList());
			mav.addObject("stockList",stockExchangeService.getStockList());
			return mav;

		}

		@RequestMapping(path = "/createIpo")
		public ModelAndView createIPO(Model model) throws Exception {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("ipoReg");
			model.addAttribute("ipo", new IPODetail());
			mv.addObject("ipoList", ipoService.getIPOList());
			mv.addObject("companyList",companyService.getCompanyList());
			mv.addObject("stockList",stockExchangeService.getStockList());
			return mv;
		
	}

}
