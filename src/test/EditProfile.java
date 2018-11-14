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

public class EditProfile extends HttpServlet
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
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
			PrintWriter pw=res.getWriter();
			res.setContentType("text/html");
			
			Cookie ck[]=req.getCookies();
			if(ck==null)
			{
				pw.println("Login 1st...");
				RequestDispatcher rd=req.getRequestDispatcher("login.html");
				rd.include(req, res);
			}
			else
			{
				pw.print("WELCOME..."+ck[0].getValue());
				pw.println("<br><form action='update' method='post'>");
				pw.println("First Name : <input type='text' name='fName1' value="+ub.getfName()+"><br>");
				pw.println("Last Name : <input type='text' name='lName1' value="+ub.getlName()+"><br>");
				pw.println("Address : <input type='text' name='addr1' value="+ub.getAddr()+"><br>");
				pw.println("Phone No. : <input type='text' name='phNo1' value="+ub.getPhNo()+"><br>");
				pw.println("Email Id : <input type='text' name='mId1' value="+ub.getmId()+"><br>");
				pw.println("<input type='submit'  value='Update'><br>");
				pw.println("</form>");
			}
		
	}
}
