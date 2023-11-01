<!DOCTYPE html>
<html>

<body bgcolor="gray">
	<br><br><br>
<h1 align = "center"> welcome to the book application>
<br><br><br>
<a href="profile.jsp">profile</a>
<a href="add_book.html">add book</a>
<a href="view_book">view book</a>
</h1>
<br><br>
<table border = "2" cellpadding="20" width="400 height="200" align="center" >
<tr>
<td>Id</td><td>name</td><td>email</td><td>phone</td><td>address</td> 
</tr>

<%@page import ="java.sql.*"%>
<%@page import="com.jnit.*" %>

<%
Connection con =DatabaseConnection.getConnection();
String email=(String)session.getAttribute("email");
PreparedStatement ps= con.prepareStatement("select * from  user where username=?");
ps.setString(1,email);
ResultSet rs = ps.executeQuery();
System.out.println(email);
while(rs.next()){
	
%>
<tr>
<td><%=rs.getInt(1)%></td>
<td><%=rs.getString(2)%></td>
<td><%=rs.getString(4)%></td>
<td><%=rs.getInt(5)%></td>
<td><%=rs.getString(6)%></td>
</tr>





<%} %>

</table>
</body>
</html>