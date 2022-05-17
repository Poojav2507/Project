import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class sale
 */
@WebServlet("/sale")

public class sale extends HttpServlet
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
		String h=req.getParameter("t8");
		String i=req.getParameter("t9");
		String j=req.getParameter("t10");
		String k=req.getParameter("t11");
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		PreparedStatement ps=con.prepareStatement("insert into billing values(?,?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1,a);
		ps.setString(2,b);
		ps.setString(3,c);
		ps.setString(4,d);
		ps.setString(5,e);
		ps.setString(6,f);
		ps.setString(7,g);
		ps.setString(8,h);
		ps.setString(9,i);
		ps.setString(10,j);
		ps.setString(11,k);
		ps.execute(); 
		res.sendRedirect("submit2.html");
		
		}
		catch(Exception ae)
		{
			ae.printStackTrace();
		}
	}

	}