package com.postgres.service;

import java.util.List;
import java.util.Map;

import com.postgres.model.City;


public interface CityService {

  public List<City> getAllCities();

  public Map<String, Object> getCityPopulationByName(City cityObj);

  public Map<String, Object> updateCityPopulationByName(City cityObj);

  public Map<String, Object> deleteCity(City cityObj);

  public Map<String, Object> createCity(City city);

}
