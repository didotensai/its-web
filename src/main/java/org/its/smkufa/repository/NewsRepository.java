package org.its.smkufa.repository;

import java.util.List;

import org.its.smkufa.entity.News;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends CrudRepository<News, Long> {
	News findById(long id);

	@Query("SELECT c FROM News c WHERE c.name LIKE %?1%")
	List<News> findByName(String name);
}
