package com.example.demo;

import com.alibaba.druid.util.StringUtils;
import com.example.demo.model.menu.MenuVo;

import java.util.ArrayList;
import java.util.List;

public class MenuTree {
	
	// 流程：数据库查出的菜单记录装载在承载菜单的列表中---
	//         构建树（获取根节点，遍历根节点，对每一个根节点构建子树）---得到最终树形菜单
	
	// 承载菜单的列表
	private List<MenuVo> MenuVoList = new ArrayList<>();
	// 带参构造器，将数据库中的菜单数据记录，装载在我们承载菜单的列表中
	public MenuTree(List<MenuVo> menuVoList){
		this.MenuVoList = menuVoList;
	}
	
	// 获取根节点
	public List<MenuVo> getRootNode(){
		List<MenuVo> rootNode = new ArrayList<>();
		for (MenuVo menuVo : MenuVoList) {
			if (StringUtils.isEmpty(menuVo.getFaIndex())){
				rootNode.add(menuVo);
			}
		}
		return rootNode;
	}
	
	// 构建子树
	public MenuVo buildChildren(MenuVo rootNode){
		List<MenuVo> childrenTree = new ArrayList<>();
		for (MenuVo menuVo : MenuVoList) {
			if (menuVo.getIndex().equals(rootNode.getFaIndex())){
				childrenTree.add(buildChildren(menuVo));
			}
		}
//		rootNode.setChildList(childrenTree);
		return rootNode;
	}
	
	// 构建树
	public List<MenuVo> buildTree(){
		List<MenuVo> menuVos = getRootNode();
		for (MenuVo menuVo : menuVos) {
			buildChildren(menuVo);
		}
		return menuVos;
	}
}