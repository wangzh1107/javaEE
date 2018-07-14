package com.itheima.jd.dao;

import org.apache.solr.client.solrj.SolrQuery;

import com.itheima.jd.pojo.ResultModel;

public interface SearchDao {

	ResultModel search(SolrQuery query) throws Exception;
}
