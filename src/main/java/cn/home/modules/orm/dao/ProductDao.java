package cn.home.modules.orm.dao;

import java.util.Collection;

public interface ProductDao {

	public abstract Collection loadProductsByCategory(String category);

}
