package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogOutServlet extends HttpServlet
{
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		//Cookie ck[]=req.getCookies();
		Cookie ck=new Cookie("uname", "");
		
		ck.setValue("");
		ck.setMaxAge(0);
		res.addCookie(ck);
		pw.println("Successfully LoggedOut");
		RequestDispatcher rd=req.getRequestDispatcher("login.html");
		rd.forward(req, res);
		
		
	}
}
