package com.example.demo.dao;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.Good;
import com.example.demo.model.History;
import com.example.demo.model.Size;
import com.example.demo.model.menu.Menu;
import com.example.demo.model.menu.MenuVo;
import com.example.demo.model.menu.PageValue;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface MenuMapper {
	@Select("SELECT * FROM test.goods")
	List<Good> getGoodsList();
	
	
	@Select("SELECT * FROM test.tb_menu where tag_id = #{tagId}")
	PageValue getPageValue(String tagId);
	
	@Update("UPDATE test.goods SET type=#{type},name=#{name},price=#{price},size=#{size},status=#{status},description=#{description} WHERE id=#{id}")
	void updateGood(JSONObject request);
	
	
	@Select("SELECT * FROM test.ts_menu")
	List<MenuVo> getLeftMenu(String code);
	
	
	@Select("SELECT * FROM test.size")
	Size selectSize();
	
	@Update("UPDATE test.size set size=#{size-1} where id = #{id} ")
	void updateSize(Size size);
	
	@Select("SELECT * FROM test.history where id < #{size} order by id desc  limit 3 offset 0 ")
	List<History> findHistory(String size);
	
	@Insert("insert into test.history (id,one,two,three,four,five,six,seven) values (#{id},#{one},#{two},#{three},#{four},#{five},#{six},#{seven})")
	void addHistory(History history);
	
}
