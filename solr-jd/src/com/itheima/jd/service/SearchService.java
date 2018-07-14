package com.itheima.jd.service;

import com.itheima.jd.pojo.ResultModel;

public interface SearchService {

	ResultModel search(String queryString, String catalog_name, String price,
			int sort, int page, int rows) throws Exception;
}
