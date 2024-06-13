package com.pace.product.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.pace.product.bean.Product;
import com.pace.product.helper.DbConnector;

public class ProductDAO {
	private Connection connection = null;
	private PreparedStatement pstatement = null;
	private ResultSet resultSet = null;
	// Book book = new Book();
	ArrayList<Product> productList = null;
	private static String productQry = "select * from product";

	/****************** Get products data *******************************/
	public ArrayList<Product> getProducts() throws ClassNotFoundException, SQLException {
		// Process to get books from table into bookList : 
		//1. Get the book data from table. 
		//2. Add each book to BookList. 
		//3. Return BookList
		try {
			// open the connection
			connection = DbConnector.createConnection();
			// create pstatement
			pstatement = connection.prepareStatement(productQry);
			// get the result
			resultSet = pstatement.executeQuery();
			Product product;
			productList = new ArrayList<Product>();
			while (resultSet.next()) {
				int productId;
				String productName;
				float price;
				// declare the pojo
				product = new Product();
				// get the row details
				productId = resultSet.getInt(1);
				productName = resultSet.getString(2);
				//author = resultSet.getString(3);
				price = resultSet.getFloat(3);
				// Add this data to book bean
				// set the pojo with retrieved values from the row
				product.setProductId(productId);
				product.setPname(productName);
				//product.setAuthor(author);
				product.setPrice(price);
				// add the book to booklist
				productList.add(product);
				product = null;
			} // end of while loop

		} catch (SQLException sqlex) {

		} finally {
			// close connection
			// now data is in array list object, close the connection
			DbConnector.closeConnection();
		}

		return productList;
	}

	/******************** Show list of products ************************************/
	public void showProductList(ArrayList<Product> productList2) {
		System.out.println("In DAO layer ");
		for (Product product : productList2) {
			System.out.print(product.getProductId());
			System.out.print("\t" + product.getPname());
			//System.out.print("\t" + bo.getAuthor());
			System.out.println("\t" + product.getPrice());
		}
	}

	/**************** Inserting product data 
	 * @return *********************************/

	public int insertProductDetails(Product product) throws ClassNotFoundException, SQLException {
		connection = DbConnector.createConnection();

		String insQry = "insert into product values(?,?,?)";
		pstatement = connection.prepareStatement(insQry);
		pstatement.setInt(1, product.getProductId());
		pstatement.setString(2, product.getPname());
		pstatement.setFloat(3, product.getPrice());

		int rows = pstatement.executeUpdate();
		System.out.println(rows + " Rows Inserted!");
		DbConnector.closeConnection();
		return rows;
	}

	/**************** Deleting product *********************************/

	public boolean deleteProduct(int id) throws SQLException, ClassNotFoundException {
		pstatement = null;
		//Scanner scnr = new Scanner(System.in);
		connection = DbConnector.createConnection();
		String delQry = "delete from product where id=?";
		pstatement = connection.prepareStatement(delQry);
		pstatement.setInt(1, id);
		int rows = pstatement.executeUpdate();
		boolean isDelete = true;
		if (rows != 0) { // if rows is non-zero, it is deleted
			isDelete = true; // status of deletion
		} else {
			isDelete = false; // status of deletion
		}
		DbConnector.closeConnection();
		return isDelete;
	}
	/******************* Updating product **************************/
	public boolean updateProduct(int id) throws SQLException, ClassNotFoundException {
		pstatement = null;
		
		connection = DbConnector.createConnection();
		String updPriceQry = 
			"update product set price = price + price * 0.10 where id=?" ;
		pstatement = null;
		pstatement = connection.prepareStatement(updPriceQry);
		pstatement.setInt(1, id);
		int rows = pstatement.executeUpdate();
		boolean isUpdate = true;
		if (rows != 0) { // if row available, it is deleted
			isUpdate = true; // status of updation
		} else {
			isUpdate = false; // status of updation
		}
		DbConnector.closeConnection();
		return isUpdate;
	}

}// end of dao clas


