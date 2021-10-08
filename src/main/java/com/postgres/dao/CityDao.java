package com.postgres.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.postgres.mappers.CityMapper;
import com.postgres.model.City;

@Repository
public class CityDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<City> getAllCities() {
		CityMapper mapper = sqlSession.getMapper(CityMapper.class);
		return mapper.getAllCities();
	}

	public City getCityPopulationByName(String name) {
		CityMapper mapper = sqlSession.getMapper(CityMapper.class);
		return mapper.getCityPopulationByName(name);
	}

	public boolean updateCityPopulationByName(String name, int population) {
		CityMapper mapper = sqlSession.getMapper(CityMapper.class);
		return mapper.updateCityPopulationByName(name, population);
	}

	public boolean deleteCity(String name) {
		CityMapper mapper = sqlSession.getMapper(CityMapper.class);
		return mapper.deleteCity(name);
	}

	public City createCity(City city) {
		CityMapper mapper = sqlSession.getMapper(CityMapper.class);
		mapper.createCity(city);
		return city;
	}

}
