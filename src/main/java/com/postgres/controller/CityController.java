package com.postgres.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.postgres.model.City;
import com.postgres.service.CityService;
import com.postgres.service.impl.CityServiceImpl;

@RestController
public class CityController {
	
	private static final Logger LOGGER = LogManager.getLogger(CityServiceImpl.class.getName());
	//private static final String EXCEPTION_MSG = "Exception occured";

	@Autowired
	private CityService cityService;

	@GetMapping("/v1/getAllCities")
	public ResponseEntity<List<City>> getAllCities() {
		List<City> cities = cityService.getAllCities();
		return new ResponseEntity<>(cities, HttpStatus.OK);
	}

	@PostMapping("/v1/getCityPopulationByName")
	public Map<String, Object> getCityPopulationByName(@RequestBody City cityObj, HttpServletRequest req) {
		Map<String, Object> resultMap = new HashMap<>();
		try{
			resultMap=cityService.getCityPopulationByName(cityObj);
		}catch(Exception e){
			LOGGER.error("Exception"+e.getCause());
		}
		return resultMap;
	}

	@PostMapping("/v1/createCity")
	public Map<String, Object> createCity(@Valid @RequestBody City city, HttpServletRequest req) {
		Map<String, Object> resultMap = new HashMap<>();
		try{
			resultMap=cityService.createCity(city);
		}catch(Exception e){
			LOGGER.error("Exception"+e.getCause());
		}
		return resultMap;
	}

	@PostMapping("v1/updateCities")
	public Map<String, Object> updateCityPopulationByName(@RequestBody City cityObj, HttpServletRequest req) {
		Map<String, Object> resultMap = new HashMap<>();
		try{
			resultMap=cityService.updateCityPopulationByName(cityObj);
		}catch(Exception e){
			LOGGER.error("Exception"+e.getCause());
		}
		return resultMap;
	}
	
	@PostMapping("v1/deleteCities")
	public Map<String, Object> deleteCity(@RequestBody City cityObj, HttpServletRequest req) {
		Map<String, Object> resultMap = new HashMap<>();
		try{
			resultMap=cityService.deleteCity(cityObj);
		}catch(Exception e){
			LOGGER.error("Exception"+e.getCause());
		}
		return resultMap;
	}

}
