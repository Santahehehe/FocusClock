package com.AT.FocusClockBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//RestController用來將class變成Bean，且回傳的是Json格式
@RestController
public class TimeBlockController {
	
	//要在TimeBlockService.java把TimeBlockService加入Bean
	//然後用@Autowired指派給這個timeBlockService
	@Autowired
		//如果都要處理timeBlock就會共用這個物件
	private TimeBlockService timeBlockService;
	
	//接受post請求做新增TimeBlock的動作
	@PostMapping("/save-time")
	//用一個TimeBlock類別的物件去接前端傳過來要insert的資料
	public String insert(@RequestBody TimeBlock timeBlock) {
		return timeBlockService.createNew_TimeBlock(timeBlock);
	}
	
	
	//接受Put請求做timeBlock的修改動作
	@PutMapping("/save-time/{account}")
	public String revise(@PathVariable String account,
						@RequestBody TimeBlock timeBlock) {
		//RequestBody中已經包含
		//1.startTime(用來找對應的TimeBlock) 2.endTime 
		//3.duration 4.focusScore 5.note
		//再把前端放在url路徑的account放入timeBlock中
		timeBlock.setAccount(account);
		//System.out.println(timeBlock.getTag());
		//接著就交給timeBlockService處理
		return timeBlockService.revise_TimeBlock(timeBlock);
	}
	
	//接受Put請求做選擇tag的動作
		@PutMapping("/choose-tag/{account}")
		public String chooseTag(@PathVariable String account,
								@RequestBody TimeBlock timeBlock) {
			//RequestBody中已經包含
			//1.startTime(用來找對應的TimeBlock) 2.endTime 
			//3.duration 4.focusScore 5.note
			//再把前端放在url路徑的account放入timeBlock中
			timeBlock.setAccount(account);
			//接著就交給timeBlockService處理
			return timeBlockService.chooseTag(timeBlock);
		}
	
	@RequestMapping("/")
	public String hello() {
		return "hello from spring boot";
	}
	
	//接受get請求呼叫checkTimeBlock方法來查看帳號的時間戳記
	@GetMapping("/checkTimeBlock/{account}")
	public TimeBlock checkByAccount(@PathVariable String account) {
		TimeBlock timeBlock = new TimeBlock();
		timeBlock.setAccount(account);
		//會回傳TimeBlock的timeBlockList變數(一串timeBlock所形成的list)
		return timeBlockService.checkByAccount(timeBlock);
	}
	
}
