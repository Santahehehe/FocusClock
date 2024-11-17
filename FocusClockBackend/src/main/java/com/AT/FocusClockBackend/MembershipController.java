package com.AT.FocusClockBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController:用來將class變成Bean，且回傳的是Json格式
@RestController
//負責取得前端請求並進行驗證參數
public class MembershipController {
	
	//指派Bean裡面的MembershipService給底下的MembershipService物件
	//如果可指派類別有兩個以上就要加上Qualifier來指定要指派哪個類別給MembershipService物件
	@Autowired
	//用來處理MembershipController function中的商業邏輯
	private MembershipService membershipService;
	
	//接受Post請求做Membership註冊動作
	@PostMapping("/register")
	public String register(@RequestBody Membership membership) {
		return membershipService.createNew_Membership(membership);
	}
	
	
	//接受Post請求做登入動作(因為post有信封，資安比較好)
	@PostMapping("/login")
	public Boolean login(@RequestBody Membership membership) {
		//印出前端傳來驗證的帳號密碼
		/*
		System.out.println("前端輸入的帳號"+membership.getAccount());
		System.out.println("前端輸入的密碼"+membership.getMd5password());
		*/
		
		return membershipService.login(membership);
	}
	
	
	
	
	
}
