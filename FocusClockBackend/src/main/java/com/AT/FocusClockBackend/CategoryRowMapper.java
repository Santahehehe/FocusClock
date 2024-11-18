package com.AT.FocusClockBackend;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


//用來處理資料庫抓回來的 行資料，讓他變成java Object
//***這邊的RowMapper函數庫要導對，import org.springframework.jdbc.core.RowMapper;
public class CategoryRowMapper implements RowMapper<Category>{
	@Override
	//throws SQLException:將查詢資料庫所遇到的異常拋出，叫呼叫者處理(通常用try-catch)
	//取得資料庫查詢結果rs
	public Category mapRow(ResultSet rs, int rowNum) throws SQLException{
		//建立一個等等要回傳的Category類別變數
		Category category = new Category();
		//把查詢結果rs存入這個TimeBlock類別的變數
		//把資料庫中的1.account,2.tag_name
		//存入 1.Account 2.tag_name
		category.setAccount(rs.getString("account"));
		category.setTag_name(rs.getString("tag_name"));
		
		return category;
	}
}
