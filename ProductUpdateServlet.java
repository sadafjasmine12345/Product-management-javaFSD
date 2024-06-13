package com.pace.product.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pace.product.dao.ProductDAO;

/**
 * Servlet implementation class ProductUpdateServlet
 */
public class ProductUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductDAO productDao=new ProductDAO();
		boolean rows=false;
		int id;
		id=Integer.parseInt(request.getParameter("id"));
		try {
			rows=productDao.updateProduct(id);
		}catch(Exception e) {
			System.err.println("Product data could not updated");
		}
		if(rows==true) {
			System.out.println("Product data successfully updated!");
			
		}else {
			System.out.println("Product data could not updated!");
		}
		RequestDispatcher dis=request.getRequestDispatcher("updateSuccess.html");
		dis.forward(request, response);
	}
	}


