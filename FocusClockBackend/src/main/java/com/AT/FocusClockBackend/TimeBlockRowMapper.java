package com.AT.FocusClockBackend;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TimeBlockRowMapper implements RowMapper<TimeBlock> {
	@Override
	//throws SQLException:將查詢資料庫所遇到的異常拋出，叫呼叫者處理(通常用try-catch)
	//取得資料庫查詢結果rs
	public TimeBlock mapRow(ResultSet rs, int rowNum) throws SQLException{
		//建立一個等等要回傳的Membership類別變數
		TimeBlock timeBlock = new TimeBlock();
		//把查詢結果rs存入這個TimeBlock類別的變數
		//把資料庫中的1.account,2.start, 3.end, 4.duration, 5.score, 6.note, 7.tag
		//存入 1.Account 2.startTime 3.end 4.duration 5.focusScore 6.note 7.tag
		timeBlock.setAccount(rs.getString("account"));
		timeBlock.setStartTime(rs.getString("start"));
		timeBlock.setEnd(rs.getString("end"));
		timeBlock.setDuration(rs.getInt("duration"));
		timeBlock.setFocusScore(rs.getInt("score"));
		timeBlock.setNote(rs.getString("note"));
		timeBlock.setTag(rs.getString("tag"));
		
		return timeBlock;
	}
}
