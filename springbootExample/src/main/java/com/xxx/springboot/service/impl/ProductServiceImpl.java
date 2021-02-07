package com.xxx.springboot.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xxx.springboot.dao.ProductDao;
import com.xxx.springboot.entity.Product;
import com.xxx.springboot.service.ProductService;


@Service("productService")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;
 
	@Override
	public List<Product> list() {
		return productDao.list();
	}
 
	@Override
	public Product queryById(int id) {
		return productDao.queryById(id);
	}
 
	@Override
	public int add(Product product) {
		return productDao.add(product);
	}
 
	@Override
	public int update(Product product) {
		return productDao.update(product);
	}
 
	@Override
	public int delete(int id) {
		return productDao.delete(id);
	}
 
}
