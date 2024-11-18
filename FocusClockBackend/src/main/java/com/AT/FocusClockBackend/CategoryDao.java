package com.AT.FocusClockBackend;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CategoryDao {
	
	//用來直接跟資料庫進行互動的變數
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	
	public String addTag(Category category) {
		//sql語法，動態決定timeBlockAccount & timeBlockStart變數
		String sql = "INSERT INTO tag_table(account,tag_name) VALUES (:tagAccount,:tagName)";
				
		//map變數是用來動態決定tagAccount & tagName的
		//記得先
		//import java.util.Map; & import java.util.HashMap;
		Map<String,Object> map = new HashMap<>();
		map.put("tagAccount",category.getAccount());
		map.put("tagName",category.getTag_name());
				
		//對資料庫執行sql語法，其中的timeBlockAccount & timeBlockStart
		//套用map後的值
		namedParameterJdbcTemplate.update(sql, map);
				
		return "已新增一種Tag分類";
	}
	
	//用來取得所有該帳號的所有tag_name，回傳的類別為一個Category的list
	public List<Category> searchTag(Category category) {
		//sql語法，動態決定timeBlockAccount & timeBlockStart變數
		String sql = "SELECT account,tag_name FROM tag_table WHERE account= :account";
						
		Map<String, Object> map = new HashMap<>();
		map.put("account", category.getAccount());
						
		List<Category> list = namedParameterJdbcTemplate.query(sql, map, new CategoryRowMapper());
				
		return list;
	}
}
