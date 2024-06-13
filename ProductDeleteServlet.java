package com.pace.product.controller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pace.product.bean.Product;
import com.pace.product.dao.ProductDAO;

/**
 * Servlet implementation class ProductDeleteServlet
 */
public class ProductDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDeleteServlet() {
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
		boolean rows=false;
		int id;
		String name;
		float price;
		id=Integer.parseInt(request.getParameter("id"));
		PrintWriter out=response.getWriter();
		out.println("Product id"+id);
		try {
			rows=productDao.deleteProduct(id);
		}catch(Exception e) {
			System.err.println("Could not delete product!");
		}
		if(rows==true) {
			System.out.println("Product data successfully deleted");
		}else {
			System.out.println("Product data could not delete");
		}
		RequestDispatcher dis=request.getRequestDispatcher("deleteSuccess.html");
		dis.forward(request, response);
	}

	}


