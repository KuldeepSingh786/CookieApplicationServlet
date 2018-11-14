package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.spi.servicecontext.UEInfoServiceContext;

public class ViewServlet extends HttpServlet
{
	public ServletContext sc;
	public UserBean ub;
	
	@Override
	public void init()
	{
		sc=this.getServletContext();
		ub=(UserBean) sc.getAttribute("beanRef");
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		Cookie ck[]=req.getCookies();
		if(ck==null)
		{
			pw.println("Login 1st......");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
		else
		{
			pw.print("WELCOME..."+ck[0].getValue());
			String uName= ck[0].getValue();
			RequestDispatcher rd=req.getRequestDispatcher("link.html");
			rd.include(req, res);
			
			pw.println("<br>====User Details====");
			pw.println("<br> First Name : "+ub.getfName());
			pw.println("<br> Last Name : "+ub.getlName());
			pw.println("<br> Address : "+ub.getAddr());
			pw.println("<br> Mail Id : "+ub.getmId());
			pw.print("<br> Phone No. : "+ub.getPhNo());
		}
		
	}
	
}
