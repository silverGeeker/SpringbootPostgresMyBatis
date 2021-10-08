package com.postgres.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.postgres.model.City;

@Mapper
public interface CityMapper {

	public List<City> getAllCities();

	public City getCityPopulationByName(String name);

	public boolean updateCityPopulationByName(String name, int population);

	public boolean deleteCity(String name);

	public int createCity(City city);
}
