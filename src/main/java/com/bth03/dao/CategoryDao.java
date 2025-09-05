package com.bth03.dao;

import java.util.List;

import com.bth03.entity.Category;

public interface CategoryDao {
	void insert(Category category);

	void update(Category category);

	void delete(int cateid);

	Category findById(int cateid);

	List<Category> findAll();

	List<Category> findByUserId(int userid);

}
