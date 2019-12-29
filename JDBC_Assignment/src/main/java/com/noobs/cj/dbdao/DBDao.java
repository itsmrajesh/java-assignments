package com.noobs.cj.dbdao;

import java.util.List;

import com.noobs.cj.domain.Product;

public interface DBDao {
	
	int addProduct(Product product);
	
	int deleteProductByid(int pid);
	
	Product updateProductByid(int pid,Product product);
	
	Product searchProductByid(int pid);
	
	List<Product> viewAllProducts();
	
	int deleteAllProducts();
	
	int insertAllProducts(List<Product> products);
}
