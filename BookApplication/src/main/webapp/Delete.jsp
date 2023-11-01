
<%@page import ="java.sql.*"%>
<%@page import="com.jnit.*" %>

<%
Connection con =DatabaseConnection.getConnection();
int id = Integer.parseInt(request.getParameter("id"));
PreparedStatement ps = con.prepareStatement("delete from book where book_id=?");
ps.setInt(1,id);
int x = ps.executeUpdate();
if(x!=0){
	response.sendRedirect("./view_book.jsp? msg=book deleted");
}
%>