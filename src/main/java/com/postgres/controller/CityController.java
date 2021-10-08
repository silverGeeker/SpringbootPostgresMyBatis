package com.postgres.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.postgres.model.City;
import com.postgres.service.CityService;

@RestController
public class CityController {

	@Autowired
	private CityService cityService;

	@GetMapping("/v1/cities")
	public ResponseEntity<List<City>> getAllCities() {
		List<City> cities = cityService.getAllCities();
		return new ResponseEntity<>(cities, HttpStatus.OK);
	}

	@GetMapping("/v1/cities/{name}")
	public ResponseEntity<City> getCityPopulationByName(@PathVariable String name) {
		City city = cityService.getCityPopulationByName(name);
		return new ResponseEntity<>(city, HttpStatus.OK);
	}

	@PostMapping("/v1/cities")
	public ResponseEntity<Object> createCity(@Valid @RequestBody City city) {
		City insertedCity = cityService.createCity(city);
		return new ResponseEntity<>(insertedCity, HttpStatus.OK);
	}

	@PutMapping("v1/cities/{name}")
	public ResponseEntity<City> updateCityPopulationByName(@PathVariable String name, @RequestParam int population) {
		cityService.updateCityPopulationByName(name, population);
		City city = cityService.getCityPopulationByName(name);
		return new ResponseEntity<>(city, HttpStatus.OK);
	}

	@DeleteMapping("v1/cities/{name}")
	public ResponseEntity<String> deleteCity(@PathVariable String name) {
		cityService.deleteCity(name);
		return new ResponseEntity<>("All cities with name=" + name + " has been deleted", HttpStatus.OK);
	}

}
