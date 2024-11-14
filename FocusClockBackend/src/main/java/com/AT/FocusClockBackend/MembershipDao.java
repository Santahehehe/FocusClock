package com.AT.FocusClockBackend;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class MembershipDao {
	
	//用來直接跟資料庫進行互動的變數
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	
	//用來新增帳號到資料庫membership table的function
	public String createNew_Membership(Membership membership) {
		//sql語法，動態決定timeBlockAccount & timeBlockStart變數
		String sql = "INSERT INTO membership(account,createTime,salt,md5password) "
				+ "VALUES (:account,:createTime, :Salt, :md5password)";
				
		//map變數是用來動態決定timeBlockAccount & timeBlockStart的
		//記得先
		//import java.util.Map; & import java.util.HashMap;
		Map<String,Object> map = new HashMap<>();
		map.put("account",membership.getAccount());
		map.put("createTime",membership.getCreateTime());
		map.put("Salt",membership.getSalt());
		map.put("md5password",membership.getMd5password());

				
		//對資料庫執行sql語法，其中的timeBlockAccount & timeBlockStart
		//套用map後的值
		namedParameterJdbcTemplate.update(sql, map);
				
		return "已新增一個帳號";
	}
	
	//用來根據帳戶名稱找到對應帳號
	public Membership findUserByAccount(Membership membership) {
		//sql語法，動態決定timeBlockAccount & timeBlockStart變數
		String sql = "SELECT salt,account,md5password,createTime FROM membership WHERE account= :account";
		
		Map<String, Object> map = new HashMap<>();
		map.put("account", membership.getAccount());
		
		List<Membership> list = namedParameterJdbcTemplate.query(sql, map, new MembershipRowMapper());
		
		if(list.size()>0){
			//System.out.println(list.get(0).getAccount());
			return list.get(0);
		}else {
			return null;
		}
	}
	
	/*
	public String findMd5PasswordByAccount(Membership membership) {
		
	}
	*/
}
