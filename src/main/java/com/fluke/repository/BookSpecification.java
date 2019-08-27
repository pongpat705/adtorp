package com.fluke.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.fluke.entity.Book;

@Repository
public class BookSpecification {

	@Autowired
	private BookRepository bookRepos;

	public Page<Book> findByReleaseYear(Pageable pageable, Long releaseYear) {

		Specification<Book> spec = Specification.where(null);


		if (null != releaseYear && !StringUtils.isEmpty(releaseYear)) {


			final Long param = releaseYear;

			// AND release_year = :releaseYear
			Specification<Book> specReleaseYear = (Specification<Book>) (root, query, builder) -> builder
					.equal(root.get("releaseYear"), param);

			spec = spec.and(Specification.where(specReleaseYear));
		}

		Page<Book> result = bookRepos.findAll(spec, pageable);

		return result;
	}
}
