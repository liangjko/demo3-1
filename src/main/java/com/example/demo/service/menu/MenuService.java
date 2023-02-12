package com.example.demo.service.menu;


import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.History;
import com.example.demo.model.Size;
import com.example.demo.model.menu.MenuVo;
import com.example.demo.model.menu.PageValue;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MenuService {
	// 查询
	JSONObject getGoodsList(int pageNum, int pageSize);
	
	List<MenuVo> getLeftMenu(String code);
	PageValue getPageValue(String tagId);
	// 更新
	JSONObject updateGood(JSONObject request);
	
	Size selectSize();
	
	void updateSize(Size size);
	
	History getData(String history);
	
	void getKill(String code);
	
	String getKillBallsKill(String code);
	
	void addHistory(String code);
}
