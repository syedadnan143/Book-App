<!DOCTYPE html>
<html>

<body bgcolor="gray">
	<br><br><br>
<h1 align = "center"> welcome to the book application>
<br><br><br>

<a href="profile.jsp">profile</a>
<a href="add_book.html">add book</a>
<a href="view_book.jsp">view book</a>
</h1>
<%@page import ="java.sql.*"%>
<%@page import="com.jnit.*" %>

<%
Connection con =DatabaseConnection.getConnection();
int id = Integer.parseInt(request.getParameter("id"));
String email=(String)session.getAttribute("email");
PreparedStatement ps= con.prepareStatement("select * from  book where book_id=?");
ps.setInt(1,id);
ResultSet rs = ps.executeQuery();
if(rs.next()){
	
%>
<form action="./update_book.jsp" method="post">
<input type="hidden" name="book_id" value = "<%=rs.getString(1)%>" >
<input type="text" name="book name" value = "<%=rs.getString(2)%>" >
<input type="number" name="book_price"value = "<%=rs.getInt(3)%>" >
<input type="text" name="book_author"	value = "<%=rs.getString(4)%>">
<input type="text" name="book_publisher"value = "<%=rs.getString(5)%>">
<input type="text" name="book_copies"	value = "<%=rs.getString(6)%>">
<input type="submit" value="update Book">
</form>
<%} %>
</body>
</html>