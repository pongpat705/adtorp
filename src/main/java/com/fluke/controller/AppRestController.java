package com.fluke.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fluke.entity.Book;
import com.fluke.repository.BookSpecification;
import com.fluke.repository.CustomRepository;

@RestController
@RequestMapping("/api")
public class AppRestController {

	@Autowired private CustomRepository customRepos;
	@Autowired private BookSpecification bookSpecs;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/allBookByReleaseYear")
	public ResponseEntity<Page<Book>> allBookByReleaseYear(@RequestParam Long releaseYear, Pageable pageable, HttpServletRequest request, Authentication authentication){
		
		Page<Book> body = bookSpecs.findByReleaseYear(pageable, releaseYear);
		
		ResponseEntity<Page<Book>> result = new ResponseEntity<>(body, HttpStatus.OK);
		
		log.info(" username {} ", authentication.getName());
		
		return result;
	}
	
	
}
