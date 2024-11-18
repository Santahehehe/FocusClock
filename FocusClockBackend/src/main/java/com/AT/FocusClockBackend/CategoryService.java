package com.AT.FocusClockBackend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryService {
	@Autowired
	private CategoryDao categoryDao;
	
	public String addTag(Category category) {
		return categoryDao.addTag(category);
	}
	
	//用來回傳該帳號的所有tag_name
	//先從categoryDao.searchTag接收一個List<Category>
	//接著在Service層把這個List<Category>存入Category的CategoriesLists
	public Category searchTag(Category category) {
		List<Category> categories = categoryDao.searchTag(category);
		
		Category result = new Category();
		result.setCategoriesList(categories);
		
		return result;
	}
}
