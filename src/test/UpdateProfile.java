package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateProfile extends HttpServlet
{
		public ServletContext sc;
		public UserBean ub;
		public Connection con;
		
		@Override
		public void init()
		{
			sc=this.getServletContext();
			ub=(UserBean) sc.getAttribute("beanRef");
			con=DBConnection.getCon();
		}
		
		@Override
		public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
		{
			PrintWriter pw=res.getWriter();
			res.setContentType("text/html");
			
			Cookie ck[]=req.getCookies();
			if(ck==null)
			{
				pw.println("Login 1st....");
				RequestDispatcher rd=req.getRequestDispatcher("login.html");
				rd.include(req, res);
				
			}
			else
			{
				pw.println("WELCOME...."+ck[0].getValue());
				RequestDispatcher rd=req.getRequestDispatcher("link.html");
				rd.include(req, res);
				
				String fName=req.getParameter("fName1");
				String lName=req.getParameter("lName1");
				String addr=req.getParameter("addr1");
				long phNo=Long.parseLong(req.getParameter("phNo1"));
				String mId=req.getParameter("mId1");
				
				
				ub.setfName(fName);
				ub.setlName(lName);
				ub.setAddr(addr);
				ub.setPhNo(phNo);
				ub.setmId(mId);
				
				try
				{
					PreparedStatement ps=con.prepareStatement("update UserReg14 set fname=?,lname=?,addr=?,phno=?,mailid=? where uname=? and pword=?");
					ps.setString(1, fName);
					ps.setString(2, lName);
					ps.setString(3, addr);
					ps.setLong(4, phNo);
					ps.setString(5, mId);
					ps.setString(6, ub.getuName());
					ps.setString(7, ub.getpWord());
					
					int k= ps.executeUpdate();
					if(k>0)
					{
						pw.println("<br>PROFILE UPDATED!!");
					}	
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
			
		}

}
