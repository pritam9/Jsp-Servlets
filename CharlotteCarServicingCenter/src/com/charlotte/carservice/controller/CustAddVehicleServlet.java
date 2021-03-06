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
@WebServlet("/CustAddVehicleServlet")
public class CustAddVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String String = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustAddVehicleServlet() {
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
        try  {
            
           //System.out.println("registration  controller");
           //System.out.println("email id is"+reques2t.getParameter("Email"));
           //PrintWriter out = response.getWriter();
           RequestDispatcher rd = null;
           
          
           String vinno=request.getParameter("vinno");
           String carnumber = request.getParameter("carno");
           String cartype=request.getParameter("cartype");
           String Brandname=request.getParameter("brandname");
           String carmodel=request.getParameter("carmodel");
           String email= "abc0@test.com"; //set the email of the customer logged in using session
           vehiclesBean vehicle= new vehiclesBean(vinno, carnumber, cartype, Brandname, carmodel, email);
           CustAddCarDao addcar = new CustAddCarDao();                      
                              
                 int flag = addcar.addCar(vehicle);
                 if (flag == 0)
                 {
                	 System.out.println("flag is 0");
                	 String str = "car added successfully";
                	 request.setAttribute("msg", str);
                	
	                 rd=request.getRequestDispatcher("/index.html");
	                 rd.include(request, response); 
          
                 }
                
                   if (flag == 1)
	                 { 
                	   System.out.println("flag is 1 and car is not added");
                	 String str = "Adding car failed";
                	 System.out.println(str);
	                 request.setAttribute("msg", str);//has to be deleted after adding this message in jsp page
	                 rd=request.getRequestDispatcher("/index.html");  
	                 rd.include(request, response);  
                 }
                 
                           
    }  catch (Exception ex) {
    	System.out.println("Exception in add car controller");
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
