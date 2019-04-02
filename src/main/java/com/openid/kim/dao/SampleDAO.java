package com.openid.kim.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository("sampleDAO")
public class SampleDAO {

	public List<Map<String, Object>> selectBoardList(Map<String,Object> commandMap) {
		
		
		for( int k = 0; k< 100;k++) {
			commandMap.put(String.valueOf(k), k+" : 게시물 ");
		}
		return null;
		
	}
}
