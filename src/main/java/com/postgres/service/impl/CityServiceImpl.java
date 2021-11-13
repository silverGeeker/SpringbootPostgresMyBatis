package com.postgres.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postgres.dao.CityDao;
import com.postgres.model.City;
import com.postgres.service.CityService;

@Service
public class CityServiceImpl implements CityService {

	private static final Logger LOGGER = LogManager.getLogger(CityServiceImpl.class.getName());
	private static final String EXCEPTION_MSG = "Exception occured";

	@Autowired
	private CityDao cityDao;

	@Override
	public List<City> getAllCities() {
		return cityDao.getAllCities();
	}

	@Override
	public Map<String, Object> getCityPopulationByName(City cityObj) {
		Map<String, Object> resultMap = new HashMap<>();
		List<String> errorList = new ArrayList<>();

		cityObj = cityDao.getCityPopulationByNamedao(cityObj);

		// boolean cityExists=true;
		if (errorList.isEmpty()) {
			resultMap.put("status", "success");
			resultMap.put("CityPopulation", cityObj);
			resultMap.put("errorList", errorList);
			resultMap.put("message", "City Found");
		} else {
			resultMap.put("status", "success");
			resultMap.put("errorList", errorList);
			resultMap.put("message", "City Not Found");
		}
		return resultMap;
	}

	@Override
	public Map<String, Object> updateCityPopulationByName(City city) {
		Map<String, Object> resultMap = new HashMap<>();
		List<String> errorList = new ArrayList<>();
		
		cityDao.updateCityPopulationByName(city);
		
		if (errorList.isEmpty()) {
			resultMap.put("status", "success");
			resultMap.put("errorList", errorList);
			resultMap.put("message", "City Update");
		} else {
			resultMap.put("status", "success");
			resultMap.put("errorList", errorList);
			resultMap.put("message", "City unable to update");
		}
		return resultMap;
	}

	@Override
	public Map<String, Object> deleteCity(City cityObj) {
		Map<String, Object> resultMap = new HashMap<>();
		List<String> errorList = new ArrayList<>();
		
		cityDao.deleteCitydao(cityObj);
		
		if (errorList.isEmpty()) {
			resultMap.put("status", "success");
			resultMap.put("errorList", errorList);
			resultMap.put("message", "City deleted");
		} else {
			resultMap.put("status", "success");
			resultMap.put("errorList", errorList);
			resultMap.put("message", "City unable to delete");
		}
		return resultMap;
		//return cityDao.deleteCity(name);
	}

	@Override
	public Map<String, Object> createCity(City city) {
		Map<String, Object> resultMap = new HashMap<>();
		List<String> errorList = new ArrayList<>();
		
		cityDao.createCity(city);
		
		if (errorList.isEmpty()) {
			resultMap.put("status", "success");
			resultMap.put("errorList", errorList);
			resultMap.put("message", "City Created");
		} else {
			resultMap.put("status", "success");
			resultMap.put("errorList", errorList);
			resultMap.put("message", "City unable to add");
		}
		return resultMap;
	}

}
