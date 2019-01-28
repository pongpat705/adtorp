package com.fluke.component;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fluke.entity.Film;
import com.fluke.repository.FilmRepository;

@Component
public class Startup {
	
	List<Film> films;
	

	@Autowired
	FilmRepository filmRepos;
	
	
	@PostConstruct
	public void init() {
		
		films = filmRepos.findAll();
		
	}
	

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}
	
	

}
