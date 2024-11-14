package com.AT.FocusClockBackend;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

@Component
public class MembershipService {
	
	@Autowired
	private MembershipDao membershipDao;
	
	//新增帳號商業邏輯
	public String createNew_Membership(Membership membership) {
		//驗證輸入欄位(先不做)
		
		//檢查帳號是否重複註冊(先不做)
		
		//產生鹽值
		String salt = UUID.randomUUID().toString().toUpperCase().replaceAll("-", "");
		//密碼加密
		String md5Password = getMd5Password(membership.getMd5password(), salt);
		//新增會員物件的slat&md5Password變數值
		membership.setSalt(salt);
		membership.setMd5password(md5Password);
		
		//呼叫Dao層把資料加入資料庫
		return membershipDao.createNew_Membership(membership);
	}
	
	//登入商業邏輯
	public Boolean login(Membership membership) {
		//前端請求的密碼變數之加密結果
		String frontPassword;
		//用來比較的Membership類別變數
		Membership compareMembership = new Membership();
		
		//設定用來比較的compareMembership變數(鹽值拿來給使用者輸入的值加密)
		compareMembership = membershipDao.findUserByAccount(membership);
		//把使用者輸入的密碼用剛剛得到的鹽值進行加密
		frontPassword = getMd5Password(membership.getMd5password(),compareMembership.getSalt());
		
		//印出帳號的鹽值
		//System.out.println("前端輸入帳號的鹽值"+compareMembership.getSalt());
		//印出正確的密碼
		//System.out.println("正確的密碼"+compareMembership.getMd5password());
		//印出前端輸入的密碼加密後的結果
		/*
		System.out.println("鹽值+前端輸入的密碼"+frontPassword);
		System.out.println("前端輸入加密後結果"+frontPassword);
		*/
		//比對輸入的密碼和資料庫中的密碼
		if(compareMembership.getMd5password().equals(frontPassword)) {
			//System.out.println("登入成功");
			return true;//登入成功
		}else {
			//System.out.println("登入失敗");
			return false;//登入失敗
		}
	}
	
	//用來對密碼進行鹽值加密
	private String getMd5Password(String password, String salt) {
		// 對password + salt 進行三次加密
		String str = salt + password;
		//印出salt + password
		//System.out.println("鹽值加輸入的密碼"+str);
		for (int i = 0; i < 3; i++) {
			str = DigestUtils.md5DigestAsHex(str.getBytes()).toUpperCase();
		}
		return str;
	}
}
