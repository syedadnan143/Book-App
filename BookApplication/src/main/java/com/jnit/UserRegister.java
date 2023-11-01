package com.jnit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserRegister extends HttpServlet  {
	Connection connection = null;
	PreparedStatement ps = null;
	public void init(ServletConfig config) {
		try {
			connection = DatabaseConnection.getConnection();
		} catch (ClassNotFoundException e) {
//			 TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
//			 TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
	   String username=request.getParameter("username");
	   String password=request.getParameter("password");
	   String email=request.getParameter("email");
	   String address=request.getParameter("address");
	   int phone=Integer.parseInt(request.getParameter("phone"));
	   String sql ="insert into user(username,password,email,phone,address)values(?,?,?,?,?)";
	   PrintWriter pw = response.getWriter();
	   try {
		   ps=connection.prepareStatement(sql);
		   ps.setString(1,username);
		   ps.setString(2,password);
		   ps.setString(3,email);
		   ps.setInt(4,phone);
		   ps.setString(5,address);
		   int x = ps.executeUpdate();
		   
		   if(x!=0)
			   response.sendRedirect("./login.html");
//		   pw.println("<h1 align='center'> Registered Succussfully</h1>");
	   }
		   catch (Exception e){
		          e.printStackTrace();
		      }
	   
	    
	   
  }
}
