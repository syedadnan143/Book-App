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

public class AddBook extends HttpServlet  {
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
	
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
	   String book_name=request.getParameter("book_name");
	   String book_author=request.getParameter("book_author");
	   String book_publisher=request.getParameter("book_publisher");
	   String book_copies=request.getParameter("book_copies");
	   int book_price=Integer.parseInt(request.getParameter("book_price"));
	   String sql ="insert into book(book_name,book_price,book_author,book_publisher,book_copies)values(?,?,?,?,?)";
	   PrintWriter pw = response.getWriter();
	   try {
		   ps=connection.prepareStatement(sql);
		   ps.setString(1,book_name);
		   ps.setInt(2,book_price);
		   ps.setString(3,book_author);
		   ps.setString(4,book_publisher);
		   ps.setString(5,book_copies); 
		   int x = ps.executeUpdate();
		   
		   if(x!=0)
			   response.sendRedirect("./home.html?msg=Book Added");
//		   pw.println("<h1 align='center'> Registered Succussfully</h1>");
	   }
		   catch (Exception e){
		          e.printStackTrace();
		      }
	   
	    
	   
  }
}
