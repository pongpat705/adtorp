package com.fluke.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fluke.entity.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long>, JpaSpecificationExecutor<Film>{
	
	Page<Film> findByRating(Pageable pageable, String rating);
	
	
	@Query(value=" SELECT * FROM film WHERE rating = :rating ",
			countQuery = " SELECT count(*) FROM film WHERE rating = :rating ",
			nativeQuery = true)
	Page<Film> findByRatingViaNativeSql(Pageable pageable, @Param(value="rating") String rating);

}
