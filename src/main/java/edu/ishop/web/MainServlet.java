package edu.ishop.web;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ishop.utils.MyRound;
import edu.ishop.model.Product;
import edu.ishop.model.ProductCategory;
import edu.ishop.services.ProductService;
import edu.ishop.services.ProductServiceFactory;

public class MainServlet extends HttpServlet {

	private final ProductService productService = ProductServiceFactory.getServiceInstance();
	
	@Override
	public void init() throws ServletException{
			}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		final List<Product> allProducts = productService.getAll();
		
		req.setAttribute("products", allProducts);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/indexMy.jsp");
		dispatcher.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		Product pr = new Product();
		pr.setId(Long.parseLong(req.getParameter("id")));
		pr.setName("\""+req.getParameter("name")+"\"");
		pr.setPrice(BigDecimal.valueOf(MyRound.round(Double.parseDouble((req.getParameter("price"))), 3)));
		pr.setDescription("\""+req.getParameter("description")+"\"");

        ProductCategory category = new ProductCategory(Long.parseLong(req.getParameter("categoryId")));
		category.setName("\""+req.getParameter("categoryName")+"\"");
		pr.setCategory(category);

		productService.save(pr);
		doGet(req, resp);
	}
}