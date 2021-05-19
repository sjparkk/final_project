package com.itwill.funstream.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwill.funstream.domain.Movie;
import com.itwill.funstream.domain.Subscribe;
import com.itwill.funstream.service.MovieService;
import com.itwill.funstream.service.SubsUserInfoService;
import com.itwill.funstream.service.SubscribeService;
import com.itwill.funstream.util.moviepagemaker.MovieListPageDto;
import com.itwill.funstream.util.moviepagemaker.MovieListPageMakerDto;

@Controller
public class MovieController {
   @Autowired
   private MovieService movieService;
   @Autowired
   private SubscribeService subscribeService;
   @Autowired
   private SubsUserInfoService subsUserInfoService;
   
   public MovieController() {
   }

   //movie_detail - 나리
   @RequestMapping(value = "movie_detail")
   public String movie_detail(@RequestParam("movie_no") String movie_noStr,
                        HttpSession session,
                        Model model) {
      String forwardPath = "";
      String sUserNo = String.valueOf(session.getAttribute("sUserNo"));

      if (movie_noStr == null || movie_noStr.equals("")) {
         forwardPath = "redirect:movie_main";
      }else{
         try {
        	
        	 int movie_no = Integer.parseInt(movie_noStr);
             Map movieDetailMap = movieService.movieDetailMap(movie_no);
             model.addAttribute("movieDetailMap", movieDetailMap);
            boolean isExistence = false;
            
            if(sUserNo.equals("null")||sUserNo.equals("")) {
            	isExistence = false;
            	model.addAttribute("sameGenreMovieList", movieService.findFourMovieListByGenreNo((int)movieDetailMap.get("genreNo")));
            }else {
            	isExistence = subsUserInfoService.existenceCheckUserNo(Integer.parseInt(sUserNo));
            	model.addAttribute("sameGenreMovieList", movieService.findFourMovieListByGenreNo((int)movieDetailMap.get("genreNo")));
            }
            model.addAttribute("isExistence", isExistence);

				forwardPath = "movie_detail";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return forwardPath;
	}

	// 현민
	@LoginCheck
	@RequestMapping("movie_wishlist")
	public String movie_wishlist(@RequestParam("pageno") String pageno, Model model, HttpSession session) {
		if (pageno == null || pageno.equals("")) {
			pageno = "1";
		}
		String sUserNo = String.valueOf(session.getAttribute("sUserNo"));
		MovieListPageMakerDto movieListPage = movieService.findMovieWishListByUserNo(Integer.parseInt(pageno),
				Integer.parseInt(sUserNo));
		model.addAttribute("movieListPage", movieListPage);
		return "movie_wishlist";
	}

	@RequestMapping("user_subscribe_form")
	public String user_subscribe_payment(Model model, HttpSession session) {
		String sUserNo = String.valueOf(session.getAttribute("sUserNo"));
		List<Subscribe> subscribeList = subscribeService.subscribeList();
		model.addAttribute("subscribeList", subscribeList);
		return "user_subscribe_form";
	}

	@ResponseBody
	@RequestMapping(value = "wishList", produces = "text/plain;charset=UTF-8")
	public String wishList(@RequestParam("movie_no") int movie_no, HttpSession session) {
		String r = "";
		String sUserNo = String.valueOf(session.getAttribute("sUserNo"));
		boolean result = movieService.wishList(Integer.parseInt(sUserNo), movie_no);
		if (result) {
			r = "success";
		} else {
			r = "fail";
		}
		return r;
	}

	// 혜조
	@RequestMapping("movie_main")
	public String movie_main(@RequestParam("pageno") String pageno, @RequestParam String genre_no, Model model,
			HttpSession session) {
		String forwardPath = "";
		MovieListPageMakerDto movieListPage = null;
		if (pageno == null | pageno.equals("")) {
			pageno = "1";
		}
		String sUserNo = String.valueOf(session.getAttribute("sUserNo"));
		try {
			if (Integer.parseInt(genre_no) == 0) {
				if (sUserNo.equals("null") || sUserNo.equals("")) {
					movieListPage = movieService.selectMovieAll(Integer.parseInt(pageno));
				} else {
					movieListPage = movieService.selectMovieAllAndUserNo(Integer.parseInt(sUserNo),
							Integer.parseInt(pageno));
				}
				model.addAttribute("genre_no", 0);
			} else {
				if (sUserNo.equals("null") || sUserNo.equals("")) {
					movieListPage = movieService.findMovieListByGenreNo(Integer.parseInt(pageno),
							Integer.parseInt(genre_no));
				} else {
					movieListPage = movieService.findMovieListByGenreNoAndUserNo(Integer.parseInt(pageno),
							Integer.parseInt(genre_no), Integer.parseInt(sUserNo));
				}
				String genreName = movieService.findGenreNameByGenreNo(Integer.parseInt(genre_no));
				model.addAttribute("genreName", genreName);
				model.addAttribute("genre_no", genre_no);
			}
			model.addAttribute("movieListPage", movieListPage);
			model.addAttribute("sUserNo", sUserNo);
			forwardPath = "movie_main";
		} catch (Exception e) {
			forwardPath = "";
			e.printStackTrace();
		}
		return forwardPath;
	}

	@RequestMapping("movie_search")
	public String movie_search(String search, String pageno, Model model, HttpSession session) {
		String forwardPath = "";
		MovieListPageMakerDto movieListPage = null;
		String sUserNo = String.valueOf(session.getAttribute("sUserNo"));
		if (pageno == null | pageno.equals("")) {
			pageno = "1";
		}
		if (sUserNo.equals("null") || sUserNo.equals("")) {
			movieListPage = movieService.findMovieListBySearch(Integer.parseInt(pageno), search);
		} else {
			movieListPage = movieService.findMovieListBySearchAndUserNo(Integer.parseInt(pageno), search, Integer.parseInt(sUserNo));
		}
		model.addAttribute("movieListPage", movieListPage);
		model.addAttribute("search", search);
		forwardPath = "movie_search";
		return forwardPath;
	}

}
