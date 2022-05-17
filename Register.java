import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/Register")
public class Register extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
				res.setContentType("text/html");
				PrintWriter pw=res.getWriter();
				String a=req.getParameter("t1");
				String b=req.getParameter("t2");
				String c=req.getParameter("t3");
				String d=req.getParameter("t4");
				String e=req.getParameter("t5");
				String f=req.getParameter("t6");
				String g=req.getParameter("t7");
				try
				{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
				PreparedStatement ps=con.prepareStatement("insert into  registar1 values(?,?,?,?,?,?,?)");
				ps.setString(1,a);
				ps.setString(2,b);
				ps.setString(3,c);
				ps.setString(4,d);
				ps.setString(5,e);
				ps.setString(6,f);
				ps.setString(7,g);
				ps.execute();
				res.sendRedirect("login.html");
		}
		catch(Exception ae)
	{
		ae.printStackTrace();
	}
	}
}