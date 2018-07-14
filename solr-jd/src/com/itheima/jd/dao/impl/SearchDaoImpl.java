package com.itheima.jd.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itheima.jd.dao.SearchDao;
import com.itheima.jd.pojo.ProductModel;
import com.itheima.jd.pojo.ResultModel;

/**
 * 索引库查询Dao
 * <p>Title: SearchDaoImpl</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
@Repository
public class SearchDaoImpl implements SearchDao {
	
	@Autowired
	private SolrServer solrServer;

	@Override
	public ResultModel search(SolrQuery query) throws Exception {
		// 1）根据SolrQuery对象执行查询
		QueryResponse queryResponse = solrServer.query(query);
		//取高亮对象
		Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
		// 2）取查询结果的总记录数
		SolrDocumentList solrDocumentList = queryResponse.getResults();
		long numFound = solrDocumentList.getNumFound();
		// 3）取商品列表，需要封装到ProductModel对象中
		List<ProductModel> productList = new ArrayList<>();
		for (SolrDocument solrDocument : solrDocumentList) {
			ProductModel product = new ProductModel();
			product.setCatalog_name((String) solrDocument.get("product_catalog_name"));
			String name = "";
			//取高亮结果
			List<String> list = highlighting.get(solrDocument.get("id")).get("product_name");
			if (list != null && list.size() > 0) {
				name = list.get(0);
			} else {
				name = (String) solrDocument.get("product_name");
			}
			product.setName(name);
			product.setPicture((String) solrDocument.get("product_picture"));
			product.setPid((String) solrDocument.get("id"));
			product.setPrice((float) solrDocument.get("product_price"));
			//添加到商品列表
			productList.add(product);
		}
		// 4）取高亮结果
		// 5）创建一个ResultModel对象
		ResultModel resultModel = new ResultModel();
		resultModel.setProductList(productList);
		resultModel.setRecordCount(numFound);
		// 6）返回结果
		return resultModel;
	}

}
