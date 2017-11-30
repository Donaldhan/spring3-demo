package cn.home.modules.transaction.service;

import cn.home.modules.transaction.entity.Menu;

public interface MenuService {
	public abstract void saveMenu(Menu menu);

	public abstract void updateMenu(Menu menu);

	public abstract void deleteMenu(Menu menu);
}
