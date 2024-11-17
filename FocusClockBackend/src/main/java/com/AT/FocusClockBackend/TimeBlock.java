package com.AT.FocusClockBackend;

import java.util.List;

public class TimeBlock {
	//用來記錄帳戶名稱
	private String account;
	//紀錄開始時間(用字串形式，直接顯示就好)
	private String startTime;
	//紀錄結束時間(用字串形式，直接顯示就好)
	private String end;
	//前端傳過來的資料是秒總數，要顯示的時候要記得轉換(/60變分，再/60變hr)
	private Integer duration;
	//專注力分數
	private Integer focusScore;
	//備註欄位
	private String note;
	//timeBlock分類標籤
	private String tag;
	//用來回傳多筆時間戳記
	private List<TimeBlock> timeBlockList;

	//設定和取得account變數function
	public void setAccount(String account) {
		this.account = account;
	}
	public String getAccount() {
		return account;
	}
	
	//設定和取得start變數function
		public void setStartTime(String startTime) {
			this.startTime = startTime;
		}
		public String getStartTime() {
			return startTime;
		}
	
	//設定和取得end變數function
	public void setEnd(String end) {
		this.end = end;
	}
	public String getEnd() {
		return end;
	}
	
	//設定和取得duration變數function
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public Integer getDuration() {
		return duration;
	}
	
	//設定和取得focusScore變數function
	public void setFocusScore(Integer focusScore) {
		this.focusScore = focusScore;
	}
	public Integer getFocusScore() {
		return focusScore;
	}
	
	//設定和取得note變數function
	public void setNote(String note) {
		this.note = note;
	}
	public String getNote() {
		return note;
	}
	
	//設定和取得tag變數function
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getTag() {
		return tag;
	}
	
	//設定和取得timeBlockList的function
	public void setTimeBlockList(List<TimeBlock> timeBlockList) {
		this.timeBlockList = timeBlockList;
	}
	public List<TimeBlock> getTimeBlockList(){
		return timeBlockList;
	}
}
