package cn.wangzhenghao.mapper;

import java.util.List;
import cn.wangzhenghao.pojo.Menu;

public interface MenuMapper {
	List<Menu> queryManagerList();

	List<Menu> queryManagerByType(Integer type);
}