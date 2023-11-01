
<%@page import ="java.sql.*"%>
<%@page import="com.jnit.*" %>

<%
Connection con =DatabaseConnection.getConnection();
int id = Integer.parseInt(request.getParameter("book_id"));
String book_name=request.getParameter("book_name");
String book_author=request.getParameter("book_author");
String book_publisher=request.getParameter("book_publisher");
String book_copies=request.getParameter("book_copies");
int book_price=Integer.parseInt(request.getParameter("book_price"));
PreparedStatement ps = con.prepareStatement("update book set book_name=?, book_price=?, book_author=?,book_publisher=?,book_copies=? where book_id=?");
ps.setString(1,book_name);
ps.setInt(2,book_price);
ps.setString(3,book_author);
ps.setString(4,book_publisher);
ps.setString(5,book_copies);
ps.setInt(6,id);
int x = ps.executeUpdate();
if(x!=0)
	response.sendRedirect("view_book.jsp? msg=bookupdated");
%>