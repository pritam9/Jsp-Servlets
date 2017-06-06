package com.charlotte.carservice.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.charlotte.carservice.Beans.*;
import com.charlotte.carservice.dao.*;


/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/AddStockServlet")
public class AddStockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String String = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStockServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		//System.out.println("servlet called");
		RequestDispatcher rd = null;
        try  {
            
           //System.out.println("registration  controller");
           //System.out.println("email id is"+reques2t.getParameter("Email"));
           //PrintWriter out = response.getWriter();
           
           
          
           String stockId=request.getParameter("stock_Id");
           int quantity=Integer.parseInt((request.getParameter("quantity")));
           float price= Float.parseFloat(request.getParameter("price"));
           String name=request.getParameter("name");
           //String password=request.getParameter("Password");
           //String contact=request.getParameter("Contact");
           StockBean sb = new StockBean(stockId, quantity, price, name);
           
                 AdminDao admin=new AdminDao();                
                 int flag = admin.addStock(sb);
                 if (flag == 0)
                 {
                	 String str = "Stock Updated successfully";
                	 request.setAttribute("msg", str);
                	
	                 rd=request.getRequestDispatcher("/admin_home.jsp");
	                 rd.include(request, response); 
          
                 }
                
                   if (flag == 1)
	                 { 
                	 String str = "Update failed";
                	 System.out.println(str);
	                 request.setAttribute("msg", str);//has to be deleted after adding this message in jsp page
	                 rd=request.getRequestDispatcher("/add_stock.jsp");  
	                 rd.include(request, response);  
                 }
                 
                           
    }  catch (Exception ex) {
    	String str = "Update failed";
    	System.out.println(str);
        request.setAttribute("msg", str);//has to be deleted after adding this message in jsp page
        rd=request.getRequestDispatcher("/add_stock.jsp");  
        rd.include(request, response); 
    	System.out.println("Exception in add stock controller");
    	ex.printStackTrace();
       }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }



}
