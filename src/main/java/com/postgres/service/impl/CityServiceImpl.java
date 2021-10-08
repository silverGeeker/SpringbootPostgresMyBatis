package com.postgres.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postgres.dao.CityDao;
import com.postgres.model.City;
import com.postgres.service.CityService;

@Service
public class CityServiceImpl implements CityService {

  @Autowired
  private CityDao cityDao;

  @Override
  public List<City> getAllCities() {
    return cityDao.getAllCities();
  }

  @Override
  public City getCityPopulationByName(String name) {
    return cityDao.getCityPopulationByName(name);
  }

  @Override
  public boolean updateCityPopulationByName(String name, int population) {
    return cityDao.updateCityPopulationByName(name, population);
  }

  @Override
  public boolean deleteCity(String name) {
    return cityDao.deleteCity(name);
  }

  @Override
  public City createCity(City city) {
    cityDao.createCity(city);
    return city;
  }

}
