package com.fluke.soap;

import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.fluke.entity.Film;
import com.fluke.repository.FilmRepository;
import com.fluke.soap.io.spring.guides.gs_producing_web_service.GetFilmRequest;
import com.fluke.soap.io.spring.guides.gs_producing_web_service.GetFilmResponse;

@Endpoint
public class FilmEndpoint {

	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
	
	@Autowired FilmRepository filmRepos;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getFilmRequest")
	@ResponsePayload
	public GetFilmResponse getCountry(@RequestPayload GetFilmRequest request) {
		GetFilmResponse response = new GetFilmResponse();
		Pageable pageable = new PageRequest(request.getPage(), request.getSize());
		
		Page<Film> searchResults = filmRepos.findByRating(pageable, request.getRating());
		for (Film film : searchResults.getContent()) {
			com.fluke.soap.io.spring.guides.gs_producing_web_service.Film x = new com.fluke.soap.io.spring.guides.gs_producing_web_service.Film();
			x.setDescription(film.getDescription());
			x.setFilmId(film.getFilmId());
			x.setLanguageId(film.getLanguageId());
			GregorianCalendar c = new GregorianCalendar();
			c.setTime(film.getLastUpdate());
			XMLGregorianCalendar date2;
			try {
				date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
			} catch (DatatypeConfigurationException e) {
				date2 = null;
				e.printStackTrace();
			}
			x.setLastUpdate(date2);
			x.setLength(film.getLength());
			x.setOriginalLanguageId(null == film.getOriginalLanguageId()? 0 : film.getOriginalLanguageId());
			x.setRating(film.getRating());
			x.setReleaseYear(null == film.getReleaseYear()? 0 : film.getReleaseYear());
			x.setRentalDuration(null == film.getRentalDuration()? 0 : film.getRentalDuration());
			x.setRentalRate(null != film.getRentalRate()? 0 : film.getRentalRate().intValue());
			x.setReplacementCost(null == film.getReplacementCost()? 0 : film.getReplacementCost().intValue());
			x.setSpecialFeatures(film.getSpecialFeatures());
			x.setTitle(film.getTitle());
			
			response.getFilm().add(x);
		}
		

		return response;
	}
}
