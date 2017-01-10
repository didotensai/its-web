package org.its.smkufa.service;

import java.util.List;

import javax.inject.Inject;

import org.its.smkufa.entity.Category;
import org.its.smkufa.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class RestCategoryService implements CategoryService {

	@Inject
	private CategoryRepository categoryRepository;

	@Override
	public Category getCategoryByid(long id) {
		// TODO Auto-generated method stub
		return categoryRepository.findById(id);
	}

	@Override
	public List<Category> findCategoryByName(String name) {
		// TODO Auto-generated method stub
		return categoryRepository.findByName(name);
	}

	@Override
	@Transactional
	public Category saveCategory(Category category) {
		// TODO Auto-generated method stub
		category.setId(0);
		return categoryRepository.save(category);
	}

	@Override
	@Transactional
	public Category updateCategory(long id, Category category) {
		// TODO Auto-generated method stub
		Category c = getCategoryByid(category.getId());
		if (c != null) {
			c.setName(category.getName());
			c.setSubCategory(category.getSubCategory());
		}
		return c;
	}

	@Override
	@Transactional
	public void deleteCategory(long id) {
		categoryRepository.delete(id);

	}

}
