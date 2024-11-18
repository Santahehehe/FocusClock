package com.AT.FocusClockBackend;

import java.util.List;

public class Category {
	//知道是哪個帳號的標籤
	private String account;
	//分類名稱
	private String tag_name;
	//用來回傳多筆分類標籤
	private List<Category> categoriesList;
	
	
	//設定和取得帳號名稱
	public void setAccount(String account) {
		this.account = account;
	}
	public String getAccount() {
		return account;
	}
	
	//設定和取得標籤名稱
	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}
	public String getTag_name() {
		return tag_name;
	}
	
	//設定和取得timeBlockList的function
	public void setCategoriesList(List<Category> categoriesList) {
		this.categoriesList = categoriesList;
	}
	public List<Category> getCategoriesList(){
		return categoriesList;
	}
}
