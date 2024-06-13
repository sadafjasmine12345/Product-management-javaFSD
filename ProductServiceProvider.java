package com.pace.product.service;
import java.sql.SQLException;
import java.util.ArrayList;
import com.pace.product.bean.Product;
import com.pace.product.dao.ProductDAO;

public class ProductServiceProvider {
	ArrayList<Product> productList = new ArrayList<Product>();
	ProductDAO productDAO = new ProductDAO();

	// Reading book data service
	public ArrayList<Product> getProductService() throws ClassNotFoundException, SQLException {
		productList = productDAO.getProducts();
		return productList;
	}

	// Showing book data service
	public void showProductsService(ArrayList<Product> productList) throws ClassNotFoundException, SQLException {

		System.out.println("In service layer ");
		productList = productDAO.getProducts();
		productDAO.showProductList(productList);
	}

	// Inserting book data service
	public void insertProductService(Product product) throws ClassNotFoundException, SQLException {
		productDAO.insertProductDetails(product);
	}

	// deleting book data service
	public void deleteProductService(int id) throws ClassNotFoundException, SQLException {
		boolean isProductDeleted = productDAO.deleteProduct(id);
		if (isProductDeleted == true) {
			System.out.println("Product with id " + id + " was deleted");
		} else {
			System.out.println("Product with id " + id + " is unavailable");
		}
	}
	// updating book data service
	public void updateProductService(int id) throws ClassNotFoundException, SQLException {
		boolean isproductUpdated = productDAO.updateProduct(id);
		// boolean isBookDeleted = bookDAO.updateBook(id);
		if (isproductUpdated == true) {
			System.out.println("Product with id " + id + " was updated!");
		} else {
			System.out.println("Product with id " + id + " is unavailable!");
		}

	}
}


