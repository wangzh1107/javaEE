package com.itheima.jd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itheima.jd.pojo.ResultModel;
import com.itheima.jd.service.SearchService;

/**
 * 查询索引库Controller
 * <p>Title: SearchController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
@Controller
public class SearchController {
	
	private static final int ROWS = 60; 

	@Autowired
	private SearchService searchService;
	
	@RequestMapping("/list")
	public String search(String queryString, String catalog_name, String price,
			@RequestParam(defaultValue="1")int page, 
			@RequestParam(defaultValue="0")int sort, Model model) throws Exception {
		// 1）接收表单提交的数据
		// 2）调用Service把参数传递给Service
		ResultModel resultModel = searchService.search(queryString, catalog_name, price, sort, page, ROWS);
		// 3）把结果传递给jsp
		model.addAttribute("result", resultModel);
		// 4）把查询参数回显
		model.addAttribute("queryString", queryString);
		model.addAttribute("catalog_name", catalog_name);
		model.addAttribute("price", price);
		model.addAttribute("page", page);
		model.addAttribute("sort", sort);
		// 5）返回逻辑视图
		return "product_list";
	}
}
