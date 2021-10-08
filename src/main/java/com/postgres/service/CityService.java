package com.postgres.service;

import java.util.List;

import com.postgres.model.City;


public interface CityService {

  public List<City> getAllCities();

  public City getCityPopulationByName(String name);

  public boolean updateCityPopulationByName(String name, int population);

  public boolean deleteCity(String name);

  public City createCity(City city);

}
