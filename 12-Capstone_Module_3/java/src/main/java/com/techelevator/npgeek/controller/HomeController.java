package com.techelevator.npgeek.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.ParkDao;
import com.techelevator.npgeek.model.Survey;
import com.techelevator.npgeek.model.SurveyDao;
import com.techelevator.npgeek.model.Weather;
import com.techelevator.npgeek.model.WeatherDao;

@Controller
public class HomeController {

	@Autowired
	private ParkDao parkDao;

	@Autowired
	private WeatherDao weatherDao;

	@Autowired
	private SurveyDao surveyDao;

	// getHomePage - returns homePage
	@RequestMapping("/")
	public String getHomePage(ModelMap map) {
		List<Park> park = parkDao.getAllParks();
		map.addAttribute("park", park);
		return "homePage";
	}

	// getsurveyPage
	// returns a empty surveyPage
	@RequestMapping(path = "/surveyPage", method = RequestMethod.GET)
	public String getSurveyPage(ModelMap map) {
		if(!map.containsAttribute("newSurvey")) {
			map.addAttribute("newSurvey", new Survey());
		}
		return "surveyPage";
	}

	@RequestMapping(path = "/surveyPage", method = RequestMethod.POST)
	public String getNewSurvey(@Valid @ModelAttribute Survey newSurvey, BindingResult result, RedirectAttributes flash) {
		if (result.hasErrors()) {
			System.out.println("Errors");
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "newSurvey",
					result);
			flash.addFlashAttribute("newSurvey", newSurvey);
			return "redirect:/surveyPage";
		}		
		surveyDao.save(newSurvey);
		return "redirect:/surveyResults";
	}

	// returns detailPage
	@RequestMapping("/detailPage")
	public String getDetailPage(@RequestParam String parkcode, ModelMap map) {
		Park park = parkDao.getParkById(parkcode);
		map.addAttribute("park", park);
		List<Weather> weathers = weatherDao.getWeatherByParkCode(parkcode);
		map.addAttribute("weathers", weathers);
		return "detailPage";
	}

	// details page based on if they picked celcius or fahrenheit
	@RequestMapping(path = "/detailPage", method = RequestMethod.POST)
	public String changeTempValue(HttpSession session, @RequestParam String tempType, @RequestParam String parkcode) {
		if (tempType.equals("C")) {
			Boolean celcius = true;
			session.setAttribute("celcius", celcius);
		} else {
			Boolean celcius = false;
			session.setAttribute("celcius", celcius);
		}
		return "redirect:/detailPage?parkcode=" + parkcode;
	}

	// favorites page
	@RequestMapping(path = "/surveyResults", method = RequestMethod.GET)
	public String getSurveyResults(ModelMap map) {
		List<Park> parksurveys = parkDao.getSurveyResults();
		map.addAttribute("surveyResults", parksurveys);
		return "surveyResults";
	}
}
