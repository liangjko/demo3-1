package com.example.demo.service;


import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.History;
import com.example.demo.model.Size;
import org.springframework.stereotype.Service;

@Service
public interface GoodsService {
	// 查询
	JSONObject getGoodsList(int pageNum, int pageSize);
	// 更新
	JSONObject updateGood(JSONObject request);
	
	Size selectSize();
	
	void updateSize(Size size);
	
	History getData(String history);
	
	void getKill(String code);
	
	String getKillBallsKill(String code);
	
	void addHistory(String code);
}
