package com.AT.FocusClockBackend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TimeBlockService {
	@Autowired
	private TimeBlockDao timeBlockDao;
	
	//用來新增time_Block中的data row
	public String createNew_TimeBlock(TimeBlock timeBlock) {
		return timeBlockDao.createNew_TimeBlock(timeBlock);
	}
	
	//用來修改time_Block中已經存在的data row
	public String revise_TimeBlock(TimeBlock timeBlock) {
		return timeBlockDao.revise_TimeBlock(timeBlock);
	}
	
	//用來選擇time_Block中的tag
	public String chooseTag(TimeBlock timeBlock) {
		return timeBlockDao.chooseTag(timeBlock);
	}
	
	//用來查看帳號的時間戳記
	public TimeBlock checkByAccount(TimeBlock timeBlock) {
		List<TimeBlock> timeBlocks = timeBlockDao.checkByAccount(timeBlock);
		
		TimeBlock result = new TimeBlock();
		result.setTimeBlockList(timeBlocks);
		
		return result;
	}
	
}
