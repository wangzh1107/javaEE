package com.itheima.jd.service.impl;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.jd.dao.SearchDao;
import com.itheima.jd.pojo.ResultModel;
import com.itheima.jd.service.SearchService;

/**
 *  查询索引库Service
 * <p>Title: SearchServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */

@Service
public class SearchServiceImpl implements SearchService {
	
	@Autowired
	private SearchDao searchDao;

	@Override
	public ResultModel search(String queryString, String catalog_name, String price, int sort, int page, int rows) throws Exception {
		// 1、接收参数
		// 2、创建一个SolrQuery对象
		SolrQuery query = new SolrQuery();
		// 3、根据参数设置查询条件。
		//真正的业务逻辑无需判断朱查询条件是否有值
		if (queryString != null && !"".equals(queryString)) {
			query.setQuery(queryString);
		} else {
			query.setQuery("*:*");
		}
		//商品分类过滤条件
		if (catalog_name != null && !"".equals(catalog_name)) {
			query.addFilterQuery("product_catalog_name:" + catalog_name);
		}
		//价格区间过滤
		if (price != null && !"".equals(price)) {
			String[] strings = price.split("-");
			query.addFilterQuery("product_price:["+strings[0]+" TO "+strings[1]+"]");
		}
		//排序条件
		// 0:升序 1:降序
		if (sort == 0) {
			query.setSort("product_price", ORDER.asc);
		} else {
			query.setSort("product_price", ORDER.desc);
		}
		//分页条件
		int start = (page - 1) * rows;
		query.setStart(start);
		query.setRows(rows);
		//设置默认搜索域
		query.set("df", "product_keywords");
		//开启高亮显示
		query.setHighlight(true);
		query.addHighlightField("product_name");
		query.setHighlightSimplePre("<em style=\"color:red\">");
		query.setHighlightSimplePost("</em>");
		// 4、调用dao执行查询，得到一个ResultModel对象。
		ResultModel resultModel = searchDao.search(query);
		// 5、需要计算总页数。
		Long recordCount = resultModel.getRecordCount();
		int pageCount = (int) (recordCount / rows);
		if (recordCount % rows > 0)
			pageCount++;
		resultModel.setPageCount(pageCount);
		resultModel.setCurPage(page);
		// 6、返回ResultModel对象
		return resultModel;
	}

}
