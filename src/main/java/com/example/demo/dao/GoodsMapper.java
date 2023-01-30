package com.example.demo.dao;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.Good;
import com.example.demo.model.History;
import com.example.demo.model.Size;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodsMapper {
	@Select("SELECT * FROM test.goods")
	List<Good> getGoodsList();
	
	@Update("UPDATE test.goods SET type=#{type},name=#{name},price=#{price},size=#{size},status=#{status},description=#{description} WHERE id=#{id}")
	void updateGood(JSONObject request);
	
	@Select("SELECT * FROM test.size")
	Size selectSize();
	
	@Update("UPDATE test.size set size=#{size-1} where id = #{id} ")
	void updateSize(Size size);
	
	@Select("SELECT * FROM test.history where id < #{size} order by id desc  limit 3 offset 0 ")
	List<History> findHistory(String size);
	
	@Insert("insert into test.history (id,one,two,three,four,five,six,seven) values (#{id},#{one},#{two},#{three},#{four},#{five},#{six},#{seven})")
	void addHistory(History history);
	
}
