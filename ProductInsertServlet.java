package com.pace.product.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pace.product.bean.Product;
import com.pace.product.dao.ProductDAO;

/**
 * Servlet implementation class ProductInsertServlet
 */
public class ProductInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductDAO productDao=new ProductDAO();
		Product product=new Product();
		int rows=0;
		int id;
		String name;
		float price;
		id=Integer.parseInt(request.getParameter("id"));
		name=request.getParameter("name");
		//author=request.getParameter("author");
		price=Float.parseFloat(request.getParameter("price"));
		//make the pojo ready with data
		product.setProductId(id);
		product.setPname(name);
		//book.setAuthor(author);
		product.setPrice(price);
		//pojo is ready with data
		System.out.println(product.getPname());
		try {
			rows=productDao.insertProductDetails(product);
		}catch(Exception e) {
			System.err.println("Product data could not inserted!");
		}
		if(rows==1) {
			System.out.println("Product data successfully inserted!");
			RequestDispatcher dis=request.getRequestDispatcher("insertSuccess.html");
			dis.forward(request, response);
			
		}else {
			System.out.println("Product data could not insert");
		}
		
	}
	}


