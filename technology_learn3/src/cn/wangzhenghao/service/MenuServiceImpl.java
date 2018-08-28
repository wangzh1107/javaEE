package cn.wangzhenghao.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.wangzhenghao.mapper.MenuMapper;
import cn.wangzhenghao.pojo.Menu;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuMapper menuMapper;
	@Override
	public List<Menu> queryManagerList() {
		return menuMapper.queryManagerList();
	}
	@Override
	public List<Menu> queryManagerByType(Integer type) {
		return menuMapper.queryManagerByType(type);
	}
}
