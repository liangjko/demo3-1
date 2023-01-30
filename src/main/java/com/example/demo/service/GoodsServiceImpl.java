package com.example.demo.service;


import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.GoodsMapper;
import com.example.demo.model.History;
import com.example.demo.model.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service(value = "GoodsService")
public class GoodsServiceImpl implements GoodsService{
	
	@Autowired
	private GoodsMapper goodsMapper;
	
	
	@Override
	public JSONObject getGoodsList(int pageNum, int pageSize) {
		JSONObject result = new JSONObject();
		try {
//			PageHelper.startPage(pageNum, pageSize);
//			PageInfo<Good> pageInfo = new PageInfo(goodsMapper.getGoodsList());
//
//			result.put("code", "0");
//			result.put("msg", "操作成功！");
//			result.put("data", pageInfo.getList());
//			result.put("count", pageInfo.getTotal());
		} catch (Exception e) {
			result.put("code", "500");
			result.put("msg", "查询异常！");
		}
		return result;
	}
	
	@Override
	public JSONObject updateGood(JSONObject request) {
		JSONObject result = new JSONObject();
		try {
			goodsMapper.updateGood(request);
			result.put("code", "0");
			result.put("msg", "操作成功！");
		} catch (Exception e) {
			result.put("code", "500");
			result.put("msg", "修改商品异常！");
		}
		return result;
	}
	
	@Override
	public Size selectSize() {
		return goodsMapper.selectSize();
	}
	
	@Override
	public void updateSize(Size size) {
		goodsMapper.updateSize(size);
	}
	
	@Override
	public History getData(String history) {
		History history1 = JSONObject.parseObject(history,History.class);
		
		return null;
	}
	
	@Override
	public void getKill(String code) {
		List<History> list = goodsMapper.findHistory(code);
		History history1 =  list.get(0);
//		一：首尾和杀法，用上期的首尾和可杀一码。（大于35则减去35）
		System.out.println(history1.getSeven() + history1.getOne());
//二：首尾和除以3杀法，用上期的首尾和除以3的得数可杀一码。（取整）
		System.out.println(Math.round((history1.getSeven() + history1.getOne())/3));
//三：前跨乘后跨再除以8杀法，用上期的前跨乘以后跨再除以8的得数可杀一码。（取整）
		Integer front = history1.getFive()- history1.getOne();
		Integer after = history1.getSeven()-history1.getSix();
		System.out.println(Math.round((front * after)/8));
//四：前跨杀号法，用上期的前跨可杀一码（第五位减去第一位的得数）
		System.out.println(front);
//五：后和杀号法，用上期的后和可杀一码。
		System.out.println(history1.getSeven()+ history1.getSix());
//六：龙头+后区小号杀号法，用上期第一位红球加上后区小号的得数可杀一码。
		System.out.println(history1.getSix()+ history1.getOne());
//七：龙头+后区大号杀号法，用上期第一位红球加上后区大号的得数可杀一码。
		System.out.println(history1.getSeven()+ history1.getOne());
//八：前2位和值杀号法，用上期红球的一位加二位的得数可杀一码。
		Integer frontTwo = history1.getOne()+ history1.getTwo();
		System.out.println(frontTwo);
//九：前2位和的均值杀法，用上期红球的一位加二位的得数再除以2（进位取整）可杀一码。
		System.out.println(Math.ceil(frontTwo/2));
//十：首尾和的差值杀号法，用上二期的首尾和相减（大号-小号）的得数可杀一码。
		History history2 = list.get(1);
		Integer resout2 = Math.abs(history2.getOne()- history2.getSeven());
		Integer resout1 = Math.abs(history1.getOne()- history1.getSeven());
		System.out.println(Math.abs(resout1 - resout2));
//十一：前区尾和杀号法，用上期五码红球的尾数（个位）相加的得数可杀一码。
		Integer sum = history1.getOne()%10 + history1.getTwo()%10 +
						history1.getThree()%10 + history1.getFour()%10 + history1.getFive()%10;
		System.out.println(sum);
//十二：前区尾和均值杀号法，用上期五码红球的尾数相加后再除以2（进位取整）的得数可杀一码。
		System.out.println(Math.ceil(sum/2));
//十三：用上期的龙头加10可杀一码。
		System.out.println(history1.getOne()+10);
//十四：用上期的龙头+12可杀一码。
		System.out.println(history1.getOne()+12);
//十五：用上期的后区之和+3可杀一码。
		System.out.println(history1.getSix()+history1.getSeven()+3);
//十六：用上期的后区之积+3可杀一码。（大于35则依次减去12）
		System.out.println(history1.getSix() * history1.getSeven() +3);
//十七：用上期前区的第五位减去后区第二位大号可杀一码。
		System.out.println(history1.getFive() - history2.getSeven());
//十八：用上期的第五位减去12的得数可杀一码。
		System.out.println(history1.getFive() - 12);
//十九：用上期同尾号的差值可杀一码。
//		List<Integer> last = new ArrayList<>();
//			last.set(0,history1.getOne()%10);
		System.out.println(history1);
		System.out.println("同尾号差值");
//二十：用上期的前后尾和除以10的得数可杀一码。（取整）
		System.out.println(Math.round((sum+ history1.getSeven()%10 + history1.getSix()%10)/10));
//廿一：用上期第三位红球乘以7再除以10的得数可杀一码。（取整）
		System.out.println(Math.round(history1.getThree() * 7 /10));
//廿二：用上期凤尾的个位+十位可杀一码。
//		System.out.println(history1.get);
//廿三：用上期凤尾的个位与十位互减的得数可杀一码。
		System.out.println(Math.abs((history1.getFive()/10%10)-(history1.getFour()%10)));
//廿四：用上期的凤尾减去上二三期龙头的得数可杀一码。
		System.out.println(history1.getFive()-history2.getOne()-list.get(2).getOne());
//廿六：用上期第五位减去第四位的得数可杀一码。
		System.out.println(history1.getFive()-history1.getFour());
//廿七：用上期第五位红球减去后区一位的得数可杀一码。
		System.out.println(history1.getFive()  -  history1.getSix());
//廿八：用上期第三位红球的个位加十位的得数可杀一码。
		System.out.println((history1.getThree()/10%10)+(history1.getThree()%10));
	}
	
	
	@Override
	public String getKillBallsKill(String code) {
		List<History> list = goodsMapper.findHistory(code);
		History history1 =  list.get(0);
		Integer front = history1.getFive()- history1.getOne();
		Integer after = history1.getSeven()-history1.getSix();
		Set<Integer> result = new HashSet<>();
		
		result.add(history1.getSeven() + history1.getOne());
		result.add(Math.round((history1.getSeven() + history1.getOne())/3));
		result.add(Math.round((front * after)/8));
		result.add(front);
		result.add(history1.getSeven()+ history1.getSix());
		result.add(history1.getSix()+ history1.getOne());
		result.add(history1.getSeven()+ history1.getOne());
		Integer frontTwo = history1.getOne()+ history1.getTwo();
		result.add(frontTwo);
		result.add(Integer.valueOf((int) Math.ceil(frontTwo/2)));
		History history2 = list.get(1);
		Integer resout2 = Math.abs(history2.getOne()- history2.getSeven());
		Integer resout1 = Math.abs(history1.getOne()- history1.getSeven());
		result.add(Math.abs(resout1 - resout2));
		Integer sum = history1.getOne()%10 + history1.getTwo()%10 +
						history1.getThree()%10 + history1.getFour()%10 + history1.getFive()%10;
		result.add(sum);
		result.add((int) Math.ceil(sum/2));
		result.add(history1.getOne()+10);
		result.add(history1.getOne()+12);
		result.add(history1.getSix()+history1.getSeven()+3);
		result.add(history1.getSix() * history1.getSeven() +3);
		result.add(history1.getFive() - history2.getSeven());
		result.add(history1.getFive() - 12);
		result.add(Math.round((sum+ history1.getSeven()%10 + history1.getSix()%10)/10));
		result.add(Math.round(history1.getThree() * 7 /10));
		result.add(Math.abs((history1.getFive()/10%10)-(history1.getFour()%10)));
		result.add(history1.getFive()-history2.getOne()-list.get(2).getOne());
		result.add(history1.getFive()-history1.getFour());
		result.add(11111111);
		result.add(history1.getFive()  -  history1.getSix());
		result.add((history1.getThree()/10%10)+(history1.getThree()%10));
		return result.toString();
	}
	
	@Override
	public void addHistory(String code) {
//		History history = JSONObject.parseObject(code,History.class);
		String[] aa  = code.split(",");
		History history = new History();
			history.setId(Integer.valueOf(aa[0]));
			history.setOne(Integer.valueOf(aa[1]));
			history.setTwo(Integer.valueOf(aa[2]));
			history.setThree(Integer.valueOf(aa[3]));
			history.setFour(Integer.valueOf(aa[4]));
			history.setFive(Integer.valueOf(aa[5]));
			history.setSix(Integer.valueOf(aa[6]));
			history.setSeven(Integer.valueOf(aa[7]));
		goodsMapper.addHistory(history);
		
	}
}
