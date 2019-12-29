package com.noobs.cj.dbdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.noobs.cj.dbutil.DBUtil;
import com.noobs.cj.domain.Product;

public class DBDaoImpl implements DBDao {

	private DBUtil dbUtil = DBUtil.obj;
	private Connection con;
	private PreparedStatement pst;
	private Statement st;
	private ResultSet rs;
	private final String addQuery = "INSERT INTO PRODUCTS (PNAME,PRICE,DISCOUNT) VALUES (?,?,?)";
	private final String deleteQuery = "DELETE FROM PRODUCTS WHERE PID = ?";
	private final String updateQuery = "UPDATE PRODUCTS SET PNAME = ? , PRICE = ? , DISCOUNT = ? WHERE PID = ?";
	private final String searchQuery = "SELECT * FROM PRODUCTS WHERE PID = ?";
	private final String getAllProductsQuery = "SELECT * FROM PRODUCTS";
	private final String deleteAllProductsQuery="DELETE FROM PRODUCTS";

	@Override
	public int addProduct(Product product) {
		con = dbUtil.getConnection();
		try {
			pst = con.prepareStatement(addQuery);
			pst.setString(1, product.getpName());
			pst.setDouble(2, product.getPrice());
			pst.setDouble(3, product.getDiscount());
			int rowsChanged = pst.executeUpdate();
			if (rowsChanged == 1) {
				System.out.println("product added successfully");
			}
		} catch (SQLException e) {
			System.out.println("Error adding product ");
			e.printStackTrace();
		}
		return getCount();
	}

	private int getCount() {
		String countQuery = "SELECT COUNT(PID) FROM PRODUCTs";
		con = dbUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery(countQuery);
			if (rs.next()) {
				return rs.getInt(1) + 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteProductByid(int pid) {
		con = dbUtil.getConnection();
		try {
			pst = con.prepareStatement(deleteQuery);
			pst.setInt(1, pid);
			int rowsChanged = pst.executeUpdate();
			if (rowsChanged == 1) {
				System.out.println("Product deleted succesfully with pid : " + pid);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error in deleting product with pid : " + pid);
		}
		return pid;
	}

	@Override
	public Product updateProductByid(int pid, Product product) {
		con = dbUtil.getConnection();
		try {
			pst = con.prepareStatement(updateQuery);
			pst.setString(1, product.getpName());
			pst.setDouble(2, product.getPrice());
			pst.setDouble(3, product.getDiscount());
			pst.setInt(4, pid);
			int rowsChanged = pst.executeUpdate();
			if (rowsChanged == 1) {
				System.out.println("product updated successfully");
				return product;
			}
		} catch (SQLException e) {
			System.out.println("Error updating product ");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Product searchProductByid(int pid) {
		con = dbUtil.getConnection();
		Product product = null;
		try {
			pst = con.prepareStatement(searchQuery);
			pst.setInt(1, pid);
			rs = pst.executeQuery();
			if (rs.next()) {
				product = new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public List<Product> viewAllProducts() {
		con = dbUtil.getConnection();
		Product product = null;
		List<Product> productList = new ArrayList<>();
		try {
			st = con.createStatement();
			rs = st.executeQuery(getAllProductsQuery);
			while (rs.next()) {
				product = new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4));
				productList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productList;
	}


	@Override
	public int deleteAllProducts() {
		con=dbUtil.getConnection();
		try {
			st=con.createStatement();
			int rowsChanged = st.executeUpdate(deleteAllProductsQuery);
			if (rowsChanged > 0) {
				System.out.println(rowsChanged+" products deleted");
				return rowsChanged;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int insertAllProducts(List<Product> products) {
		return 0;
	}

}
