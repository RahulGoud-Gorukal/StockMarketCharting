package com.example.SpringBoot.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.SpringBoot.Model.StockExchange;
import com.example.SpringBoot.Service.StockExchangeService;

@Controller
public class StockExchangeControllerImpl implements StockExchangeController {
	@Autowired
	private StockExchangeService stockService;

	@Override
	public boolean insertStockRecord(StockExchange stockExchange) throws Exception {
		// TODO Auto-generated method stub

		return stockService.insertStockRecord(stockExchange);
	}

	/*@Override
	public StockExchange updateStockRecord(StockExchange stockExchange) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public List<StockExchange> getStockList() throws Exception {
		// TODO Auto-generated method stub
		return stockService.getStockList();
	}

	@RequestMapping(path = "/insertStock")
	public ModelAndView registerStockPage(Model model) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("stockReg");
		model.addAttribute("stockRegister", new StockExchange());
		return mv;
	}

	@RequestMapping(path = "/stockList")
	public ModelAndView getCompanyList() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("stockList");
		mv.addObject("stockList", stockService.getStockList());
		return mv;
	}

	@RequestMapping(value = "/stockInsert")
	public ModelAndView registerStock(@ModelAttribute("stockRegister") StockExchange stockExchange,
			BindingResult result, HttpServletRequest request, HttpSession session, ModelMap map) throws Exception {

		ModelAndView mav = null;
		if (result.hasErrors()) {
			System.out.println("errors");
			System.out.println(result.getAllErrors());
			map.addAttribute("stockRegister", stockExchange);
			mav = new ModelAndView("stockReg");
			return mav;
		}
		map.addAttribute("stockRegister", stockExchange);
		stockService.insertStockRecord(stockExchange);
		mav = new ModelAndView("stockList");
		mav.addObject("stockList", stockService.getStockList());
		return mav;

	}

}
