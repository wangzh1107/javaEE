package cn.wangzhenghao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.wangzhenghao.service.MenuService;

@RestController
public class MenuController {
	@Autowired
	private MenuService menuService;

	@RequestMapping("menu")
	public List queryManagerList() {
		return menuService.queryManagerList();
	}
	
	@RequestMapping("type")
	public List queryManagerByType(Integer type) {
		System.out.println("type:"+type);
		return menuService.queryManagerByType(type);
	}
}
