package com.AT.FocusClockBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//RestController用來將class變成Bean，且回傳的是Json格式
@RestController
public class TimeBlockController {
	
	//把TimeBlockService加入Bean然後指派給這個timeBlockService
	@Autowired
		//如果都要處理timeBlock就會共用這個物件
	private TimeBlockService timeBlockService;
	
	//接受post請求做新增TimeBlock的動作
	@PostMapping("/index")
	//用一個TimeBlock類別的物件去接前端傳過來要insert的資料
	public String insert(@RequestBody TimeBlock timeBlock) {
		return timeBlockService.createNew_TimeBlock(timeBlock);
	}
	
	
	//接受Put請求做timeBlock的修改動作
	@PutMapping("/index/{account}")
	public String revise(@PathVariable String account,
						@RequestBody TimeBlock timeBlock) {
		//RequestBody中已經包含
		//1.startTime(用來找對應的TimeBlock) 2.endTime 
		//3.duration 4.focusScore 5.note
		//再把前端放在url路徑的account放入timeBlock中
		timeBlock.setAccount(account);
		//接著就交給timeBlockService處理
		return timeBlockService.revise_TimeBlock(timeBlock);
	}
	
	@RequestMapping("/")
	public String hello() {
		return "hello from spring boot";
	}
	
	
	
}
