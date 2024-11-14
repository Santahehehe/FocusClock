package com.AT.FocusClockBackend;

public class Membership {
	//帳號名稱
	private String account;
	//註冊日期
	private String createTime;
	//鹽質
	private String salt;
	//加鹽後的密碼(有了加鹽後的密碼就不再需要紀錄沒加鹽的密碼，
		//驗證時只要把使用者request的字串經過加密方法後驗證是否與加鹽後密碼相同就好
	private String md5password;
	

	
	//設定和取得account的function
	public void setAccount(String account) {
		this.account = account;
	}
	public String getAccount() {
		return account;
	}
	
	
	//設定和取得createTime的function
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getCreateTime() {
		return createTime;
	}
	
	//設定和取得salt的function
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getSalt() {
		return salt;
	}
	
	//設定和取得加鹽後的密碼
	public void setMd5password(String md5password) {
		this.md5password = md5password;
	}
	public String getMd5password() {
		return md5password;
	}
}
