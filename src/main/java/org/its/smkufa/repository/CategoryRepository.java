package org.its.smkufa.repository;

import java.util.List;

import org.its.smkufa.entity.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {
Category findById(long id);

@Query("SELECT c FROM Category c WHERE c.name LIKE %?1%")
List<Category> findByName(String name);
}
