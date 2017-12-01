package cn.home.modules.orm.dao.impl;

import java.util.Collection;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.home.modules.orm.dao.ProductDao;

/**
 * @author donald
 * 2017年12月1日
 * 下午1:27:06
 */
@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public Collection loadProductsByCategory(String category) {
		return this.sessionFactory.getCurrentSession()
				.createQuery("from test.Product product where product.category=?")
				.setParameter(0, category).list();
	}
}
