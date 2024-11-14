package com.AT.FocusClockBackend;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

//將資料庫查詢出來的數據，轉換成java object
public class MembershipRowMapper implements RowMapper<Membership> {
	@Override
	//throws SQLException:將查詢資料庫所遇到的異常拋出，叫呼叫者處理(通常用try-catch)
	//取得資料庫查詢結果rs
	public Membership mapRow(ResultSet rs, int rowNum) throws SQLException{
		//建立一個等等要回傳的Membership類別變數
		Membership membership = new Membership();
		//把查詢結果存入這個membership變數
		membership.setAccount(rs.getString("account"));
		membership.setSalt(rs.getString("salt"));
		membership.setMd5password(rs.getString("md5password"));
		membership.setCreateTime(rs.getString("createtime"));
		
		return membership;
	}
}
