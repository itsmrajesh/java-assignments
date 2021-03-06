package com.nubes.cj.driver;

import java.util.List;
import java.util.Scanner;

import com.nubes.cj.dbdao.DBDao;
import com.nubes.cj.dbdao.DBDaoImpl;
import com.nubes.cj.domain.Product;

public class App {
	private static DBDao dbDao = new DBDaoImpl();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1.Add Product 2.Delete by ID 3.Update by iD 4.Search by ID 5.View All Products ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				// add product
				dbDao.addProduct(new Product("HP PAVILON", 63000.50, 3000.50));
				break;
			case 2:
				// 2.Delete by ID
				dbDao.deleteProductByid(1);
				break;
			case 3:
				// 3.update by ID
				dbDao.updateProductByid(1, new Product("HP LAPTOP", 63000.50, 2500));
				break;
			case 4:
				// 4.search by ID
				Product product = dbDao.searchProductByid(1);
				System.out.println(product);
				break;
			case 5:
				// 5.view all products
				List<Product> productList = dbDao.viewAllProducts();
				for (Product p : productList) {
					System.out.println(p);
				}
				break;
			default:
				System.out.println("Select from 1-5 only");
				break;
			}
		}

	}

}
