package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet
{
	public ServletContext sc;
	public Connection con;
	public UserBean ub;
	
	@Override
	public void init()
	{
		sc=this.getServletContext();
		con=DBConnection.getCon();
		ub=new UserBean();
	}
	
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		String uName=req.getParameter("uname");
		String pWord=req.getParameter("pword");
		
		try
		{
			PreparedStatement ps=con.prepareStatement("select * from UserReg14 where uname=? and pword=?");
			ps.setString(1, uName);
			ps.setString(2, pWord);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				ub.setuName(rs.getString(1));
				ub.setpWord(rs.getString(2));
				ub.setfName(rs.getString(3));
				ub.setlName(rs.getString(4));
				ub.setAddr(rs.getString(5));
				ub.setPhNo(rs.getLong(6));
				ub.setmId(rs.getString(7));
				
				sc.setAttribute("beanRef", ub);
				
				Cookie ck=new Cookie("uname", uName);
				res.addCookie(ck);
				
				pw.print("WELCOME..."+ck.getValue());
				RequestDispatcher rd=req.getRequestDispatcher("link.html");
				
				rd.include(req, res);
				
			}
			else
			{
				pw.println("Invalid user Name or Password");
				RequestDispatcher rd=req.getRequestDispatcher("login.html");
				rd.include(req, res);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
