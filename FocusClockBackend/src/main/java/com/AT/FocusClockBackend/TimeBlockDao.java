package com.AT.FocusClockBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

@Component
public class TimeBlockDao {
	
	//用來直接跟資料庫進行互動的變數
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	//用來新增time_Block中的data row
	public String createNew_TimeBlock(TimeBlock timeBlock) {
		//sql語法，動態決定timeBlockAccount & timeBlockStart變數
		String sql = "INSERT INTO time_block(account,start) VALUES (:timeBlockAccount,:timeBlockStart)";
		
		//map變數是用來動態決定timeBlockAccount & timeBlockStart的
		//記得先
		//import java.util.Map; & import java.util.HashMap;
		Map<String,Object> map = new HashMap<>();
		map.put("timeBlockAccount",timeBlock.getAccount());
		map.put("timeBlockStart",timeBlock.getStartTime());
		
		//對資料庫執行sql語法，其中的timeBlockAccount & timeBlockStart
		//套用map後的值
		namedParameterJdbcTemplate.update(sql, map);
		
		return "已新增一筆TimeBlock";
	}
	
	//用來修改time_Block中已經存在的data row
	public String revise_TimeBlock(TimeBlock timeBlock) {
		//sql語法:根據account, start去修改
		//該timeBlock的 end, duration, score, note
		String sql = "UPDATE time_block SET end = :endTime, duration = :durationTime,"
				+ "score = :focusScore, note = :timeBlockNote, tag = :timeBlockTag "
				+ "WHERE  account = :timeBlockAccount AND start = :startTime";

		//map變數是用來動態決定timeBlockAccount & timeBlockStart的
		//記得先
		//import java.util.Map; & import java.util.HashMap;
		Map<String,Object> map = new HashMap<>();
		//要用它來找timeBlock的變數
		map.put("timeBlockAccount",timeBlock.getAccount());
		map.put("startTime",timeBlock.getStartTime());

		//要放入的變數
		map.put("endTime",timeBlock.getEnd());
		map.put("durationTime",timeBlock.getDuration());
		map.put("focusScore",timeBlock.getFocusScore());
		map.put("timeBlockNote",timeBlock.getNote());
		map.put("timeBlockTag",timeBlock.getTag());
		System.out.println(timeBlock.getNote());
		
		//對資料庫執行sql語法，其中的timeBlockAccount & timeBlockStart
		//套用map後的值
		namedParameterJdbcTemplate.update(sql, map);
				
		return "已修改timeBlock";
	}
	
	//用來選擇time_Block中的tag
	public String chooseTag(TimeBlock timeBlock) {
		//sql語法:根據account, start去修改
		//該timeBlock的 end, duration, score, note
		String sql = "UPDATE time_block SET tag = :timeBlockTag "
					+ "WHERE  account = :timeBlockAccount AND start = :startTime";

			//map變數是用來動態決定timeBlockAccount & timeBlockStart的
			//記得先
			//import java.util.Map; & import java.util.HashMap;
			Map<String,Object> map = new HashMap<>();
			//要用它來找timeBlock的變數
			map.put("timeBlockAccount",timeBlock.getAccount());
			map.put("startTime",timeBlock.getStartTime());

			//要放入的變數
			map.put("timeBlockTag",timeBlock.getTag());
			
			
			//對資料庫執行sql語法，其中的timeBlockAccount & timeBlockStart
			//套用map後的值
			namedParameterJdbcTemplate.update(sql, map);
					
			return "已選擇Tag";
		}
	
	//用來取得所有該帳號的時間戳記，回傳的類別為一個TimeBlock的list
	public List<TimeBlock> checkByAccount(TimeBlock timeBlock){
		//sql語法，動態決定timeBlockAccount & timeBlockStart變數
		String sql = "SELECT account,start,end,duration,score,note,tag FROM time_block WHERE account= :account";
				
		Map<String, Object> map = new HashMap<>();
		map.put("account", timeBlock.getAccount());
				
		List<TimeBlock> list = namedParameterJdbcTemplate.query(sql, map, new TimeBlockRowMapper());
		
		return list;
	}
}
