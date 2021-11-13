package com.postgres.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.postgres.model.City;

@Mapper
public interface CityMapper {

	public List<City> getAllCities();

	public City getCityPopulationByNamedao(City cityObj);

	public boolean updateCityPopulationByName(City cityObj);

	public boolean deleteCitydao(City cityObj);

	public int createCity(City city);
}
