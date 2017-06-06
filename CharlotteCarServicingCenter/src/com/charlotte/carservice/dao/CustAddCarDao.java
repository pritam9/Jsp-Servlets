package com.charlotte.carservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.charlotte.carservice.Beans.vehiclesBean;

public class CustAddCarDao {
 public int addCar(vehiclesBean v )
 {
	 try {
			Connection connection = null;
	    	 PreparedStatement stmt = null;
	    	 ProductionConnectionData connectionData=new ProductionConnectionData();
	    	  connection = connectionData.getConnection();
	    	 String query = null;
	          query = "insert into vehicles values(?,?,?,?,?,?)";
	           //System.out.println("123");   
	        stmt = connection.prepareStatement(query);
	        //System.out.println("456");   
	        stmt.setString(1, v.getVin_no());
	        stmt.setString(2, v.getCar_no());
	        stmt.setString(3, v.getCar_type());
	        stmt.setString(4, v.getBrand_name());
	        stmt.setString(5, v.getCar_model());
	        stmt.setString(6, v.getEmail_id());
	        stmt.executeUpdate();
	        System.out.println("inserted the car details");
	        return 0;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("exception in add car method");
			return 1;
		}
		
			 }
}
