package com.jnit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserLogin extends HttpServlet  {
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
	  
	   String password=request.getParameter("password");
	   String email=request.getParameter("email");
	   String sql ="select * from user where email=? and password=?";
	   PrintWriter pw = response.getWriter();
	   try {
		   ps=connection.prepareStatement(sql);
		   ps.setString(1, email);
		   ps.setString(2, password);
		   HttpSession hs = request.getSession();
		   ResultSet rs =ps.executeQuery();
		  
		   if(rs.next()) {
			   hs.setAttribute("Id",rs.getInt(1));
			   hs.setAttribute("email",rs.getString(2));
			   response.sendRedirect("./home.html");
			   
			   
			   
		   }
	   }
		   catch (Exception e){
		          e.printStackTrace();
		      }
	   
	    
	   
  }
}
