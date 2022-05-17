import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/login")
public class login extends HttpServlet
{
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
	
	res.setContentType("text/html");
	PrintWriter pw=res.getWriter();
	String a=req.getParameter("t1");
	String b=req.getParameter("t2");
	try
	{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
	PreparedStatement ps=con.prepareStatement("select * from registar1 where  username=? and  password=?");
	ps.setString(1,a);
	ps.setString(2,b);
	ResultSet rs=ps.executeQuery();
	int x=0;
	while(rs.next())
	{
		x=1; //when uusername/password match
	}
	if(x==1)
	{
		
		res.sendRedirect("index.html");
	}
	else
	{
		System.out.println("worng user name/password");
		res.sendRedirect("submit.html");
	}
	}
	catch(Exception ae)
{
ae.printStackTrace();
}}	}	