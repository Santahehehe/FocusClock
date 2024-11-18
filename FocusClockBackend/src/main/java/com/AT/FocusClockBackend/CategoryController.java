package com.AT.FocusClockBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//RestController用來將class變成Bean，且回傳的是JSON格式
@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	//接受一個post請求做新增tag的動作
	@PostMapping("/add-tag")
	//用一個Category類別的物件去接前端傳過來要新增的資料
	public String addTag(@RequestBody Category category) {
		return categoryService.addTag(category);
	}
	
	//接受get請求來回傳該account的所有tag
	@GetMapping("/searchTag/{account}")
	public Category searchTag(@PathVariable String account) {
		Category category = new Category();
		category.setAccount(account);
		return categoryService.searchTag(category);
	}
}
