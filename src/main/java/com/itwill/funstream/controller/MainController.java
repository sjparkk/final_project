package com.itwill.funstream.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.funstream.service.FundingService;
import com.itwill.funstream.service.MovieService;
import com.itwill.funstream.util.moviepagemaker.MovieListPageMakerDto;

@Controller
public class MainController {
	@Autowired
	private FundingService fundingService;
	@Autowired
	private MovieService movieService;
	
	@RequestMapping("index")
	public String main(Model model,HttpSession session) throws Exception {
		
		MovieListPageMakerDto movieList = null;
		
		model.addAttribute("fundingList", fundingService.findAllFundingOrderByPercentDesc());
		
		
		String sUserNo = String.valueOf(session.getAttribute("sUserNo"));

		if(sUserNo.equals("null")||sUserNo.equals("")) {
			 movieList = movieService.selectMovieAll(1);
		} else {
			movieList = movieService.selectMovieAllAndUserNo(Integer.parseInt(sUserNo), 1);
		}
		
		model.addAttribute("movieList", movieList);
		fundingService.createFunding();
		
		return "index";
	}
	
}
