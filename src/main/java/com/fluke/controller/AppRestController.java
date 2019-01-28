package com.fluke.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fluke.entity.Film;
import com.fluke.repository.CustomRepository;
import com.fluke.repository.FilmRepository;
import com.fluke.repository.FilmSpecification;

@RestController
@RequestMapping("/api")
public class AppRestController {

	@Autowired FilmRepository filmRepos;
	@Autowired FilmSpecification filmSpecs;
	@Autowired CustomRepository customRepos;
	
	@GetMapping("/allFilmsByRatingViaRepos")
	public ResponseEntity<List<Film>> allFilmsByRepos(){
		
		List<Film> body = filmRepos.findAll();
		
		ResponseEntity<List<Film>> result = new ResponseEntity<List<Film>>(body, HttpStatus.OK);
		
		return result;
	}
	
	
	@GetMapping("/allFilmsByRatingViaReposNamedMethod")
	public ResponseEntity<Page<Film>> allFilmsByReposNamedMethod(Pageable pageable, @RequestParam String rating){
		Page<Film> body = filmRepos.findByRating(pageable, rating);
		
		ResponseEntity<Page<Film>> result = new ResponseEntity<Page<Film>>(body, HttpStatus.OK);
		
		return result;
	}
	
	@GetMapping("/allFilmsByRatingViaReposCustomNativeQueryMethod")
	public ResponseEntity<Page<Film>> allFilmsByReposCustomNativeQueryMethod(Pageable pageable, @RequestParam String rating){
		
		Page<Film> body = filmRepos.findByRatingViaNativeSql(pageable, rating);
		
		ResponseEntity<Page<Film>> result = new ResponseEntity<Page<Film>>(body, HttpStatus.OK);
		
		return result;
	}
	
	@GetMapping("/allFilmsByRatingViaSpecification")
	public ResponseEntity<Page<Film>> allFilmsBySpecification(Pageable pageable, @RequestParam String rating){
		
		Page<Film> body = filmSpecs.findByRating(pageable, rating);
		
		ResponseEntity<Page<Film>> result = new ResponseEntity<Page<Film>>(body, HttpStatus.OK);
		
		return result;
	}
	
	@GetMapping("/allFilmsByRatingViaNativeQuery")
	public ResponseEntity<List<Film>> allFilmsByNativeQuery(@RequestParam String rating, @RequestParam int page, @RequestParam int size, @RequestParam List<String> orderColumn, @RequestParam String direction){
		
		List<Film> body = customRepos.findFilmByRating(rating, page, size, orderColumn, direction);
		
		ResponseEntity<List<Film>> result = new ResponseEntity<List<Film>>(body, HttpStatus.OK);
		
		return result;
	}
}
