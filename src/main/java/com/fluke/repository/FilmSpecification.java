package com.fluke.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.fluke.entity.Film;

@Repository
public class FilmSpecification {

	@Autowired
	FilmRepository filmRepos;

	public Page<Film> findByRating(Pageable pageable, String rating, String releaseYear) {

		Specification<Film> spec = Specification.where(null);

		if (!StringUtils.isEmpty(rating)) {

			String value = rating.toLowerCase();
			value = StringUtils.trimAllWhitespace(value);

			final String param = value;

			// AND LOWER(rating) = :rating
			Specification<Film> specRating = (Specification<Film>) (root, query, builder) -> builder
					.like(root.get("rating"), "%" + param + "%")

			;

			spec = spec.and(Specification.where(specRating));
		}

		if (null != releaseYear && !StringUtils.isEmpty(releaseYear)) {

			String value = releaseYear.toLowerCase();

			final String param = value;

			// AND release_year = :releaseYear
			Specification<Film> specReleaseYear = (Specification<Film>) (root, query, builder) -> builder
					.equal(root.get("releaseYear"), param);

			spec = spec.and(Specification.where(specReleaseYear));
		}

		Page<Film> result = filmRepos.findAll(spec, pageable);

		return result;
	}
}
