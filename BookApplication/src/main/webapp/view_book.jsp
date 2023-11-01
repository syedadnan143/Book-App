<body bgcolor="gray">
	<br><br><br>
<h1 align = "center"> welcome to the book application
<br><br><br>
<a href="profile.jsp">profile</a>
<a href="add_book.html">add book</a>
<a href="view_book">view book</a>
</h1>
<br><br>
<table border = "2" cellpadding="20" width="400 height="200"  >
<tr>
<td>Id</td><td>Book name</td><td>Book Price</td><td>Book Author</td><td>Book Publisher </td> <td>Book Copies </td> <td>Update</td> <td>Delete</td>
</tr>

<%@page import ="java.sql.*"%>
<%@page import="com.jnit.*" %>

<%
Connection con =DatabaseConnection.getConnection();
//String email=(String)session.getAttribute("email");
PreparedStatement ps= con.prepareStatement("select * from book");
//ps.setString(1,email);
ResultSet rs = ps.executeQuery();
while(rs.next()){
	
%>
<tr>
<td><%=rs.getInt(1)%></td>
<td><%=rs.getString(2)%></td>
<td><%=rs.getInt(3)%></td>
<td><%=rs.getString(4)%></td>
<td><%=rs.getString(5)%></td>
<td><%=rs.getString(6)%></td>
<td><a href="update.jsp?id=<%=rs.getInt(1)%>">update</a>
<td><a href="Delete.jsp?id=<%=rs.getInt(1)%>">delete</a>
</tr>





<%} %>

</table>
</body>
</html>