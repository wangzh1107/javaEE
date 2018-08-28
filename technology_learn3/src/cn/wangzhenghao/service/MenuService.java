package cn.wangzhenghao.service;

import java.util.List;
import cn.wangzhenghao.pojo.Menu;

public interface MenuService {
	List<Menu>  queryManagerList();

	List<Menu> queryManagerByType(Integer type);
}
