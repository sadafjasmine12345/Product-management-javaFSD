package com.pace.product.controller;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.pace.product.bean.Product;
import com.pace.product.service.ProductServiceProvider;

/**
 * Servlet implementation class ProductServlet
 */
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Product product =new Product();
		ArrayList<Product>productList=new ArrayList<Product>();
		ProductServiceProvider productServiceProvider=new ProductServiceProvider();
		try {
			productList=productServiceProvider.getProductService();
			HttpSession session=request.getSession();
			session.setAttribute("productlist",productList);
			RequestDispatcher dis=request.getRequestDispatcher("showProductDetails.jsp");
			dis.forward(request,response);
		}catch(Exception e) {
			System.out.println("Product data could not found");
		}
	}
	}


