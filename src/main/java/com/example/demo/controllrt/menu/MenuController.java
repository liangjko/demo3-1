package com.example.demo.controllrt.menu;


import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.menu.MenuVo;
import com.example.demo.model.menu.PageValue;
import com.example.demo.service.GoodsService;
import com.example.demo.service.menu.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CountDownLatch;

@RestController
@RequestMapping("/menu")
@CrossOrigin
public class MenuController {


//	@PostMapping("/getTopMenu")
//	@PostMapping("/getLeftMenu")
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value = "/getTopMenu", method = RequestMethod.POST)
	public JSONObject getTopMenu(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
		return goodsService.getGoodsList(pageNum, pageSize);
	}
	
	@RequestMapping(value = "/getLeftMenu", method = RequestMethod.POST)
	public List<MenuVo> getLeftMenu(@RequestParam("code") String code) {
		return menuService.getLeftMenu(code);
	}
	
	
	@RequestMapping(value = "/getPageValue", method = RequestMethod.POST)
	public PageValue getPageValue(@RequestParam("tagId") String tagId) {
		return menuService.getPageValue(tagId);
	}
	
	
	
	
	@PostMapping("/getData")
	@ResponseBody
	public String getToken() {
		System.out.println("aaa");
		System.out.println("bbb");
		System.out.println("ccc");
		return "aaaa";
	}
	
	@GetMapping("/hello")
	@ResponseBody
	public String getHello() {
		
		return "hello";
	}
	
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping(value = "/goodsList", method = RequestMethod.GET)
	public JSONObject getGoodsList(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
		return goodsService.getGoodsList(pageNum, pageSize);
	}
	
	@RequestMapping(value = "/updateGood", method = RequestMethod.POST)
	public JSONObject updateGood(@RequestBody JSONObject request) {
		return goodsService.updateGood(request);
	}
	
	private CountDownLatch countDownLatch = new CountDownLatch(2);
	private static Logger logger = LoggerFactory.getLogger(MenuController.class);

//	@ResponseBody
//	@PostMapping(value = "/getData")
//	public History getData(String history) {
//		return goodsService.getData(history);
//	}
	
	@RequestMapping(value = "/getKill", method = RequestMethod.GET)
	public void getKill(String code) {
		goodsService.getKill(code);
		System.out.println("end");
	}
	
	
	@RequestMapping(value = "/getKillBallsKill", method = RequestMethod.POST)
	public String getKillBallsKill(String code) {
		return goodsService.getKillBallsKill(code);
	}
	
	@RequestMapping(value = "/addHistory", method = RequestMethod.POST)
	public void addHistory(String code) {
		goodsService.addHistory(code);
		System.out.println("end");
	}
}
