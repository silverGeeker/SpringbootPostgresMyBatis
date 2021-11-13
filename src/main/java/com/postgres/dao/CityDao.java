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

	public City getCityPopulationByNamedao(City cityObj) {
		CityMapper mapper = sqlSession.getMapper(CityMapper.class);
		return mapper.getCityPopulationByNamedao(cityObj);
	}

	public boolean updateCityPopulationByName(City cityObj) {
		CityMapper mapper = sqlSession.getMapper(CityMapper.class);
		return mapper.updateCityPopulationByName(cityObj);
	}

	public boolean deleteCitydao(City cityObj) {
		CityMapper mapper = sqlSession.getMapper(CityMapper.class);
		return mapper.deleteCitydao(cityObj);
	}

	public int createCity(City city) {
		CityMapper mapper = sqlSession.getMapper(CityMapper.class);
		return mapper.createCity(city);
	}

}
