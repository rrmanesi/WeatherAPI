package com.tts.weatherapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class WeatherController {
	
	@Autowired
	private WeatherService weatherService;
	
	@GetMapping
	public String getIndex(Model model)
	{
		//Response response = weatherService.getForecast("43210");
		model.addAttribute("last", weatherService.getLastEntries());
		model.addAttribute("request", new Request("77479"));
		return "index";
	}
	
	@PostMapping
	public String postIndex(Request request,Model model)
	{
		Response response = weatherService.getForecast(request.getZipCode());
		model.addAttribute("last", weatherService.getLastEntries());
		model.addAttribute("data", response);
		return "index";
	}


}
