package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

/**
 * Servlet implementation class ForgotPassword
 */
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			
			String npwd = request.getParameter("npwd");
			HttpSession session = request.getSession();
			 
			Model m = new Model();
			System.out.println(session.getAttribute("email"));
			System.out.println(npwd);
			
			
			boolean status = m.forgotPassword(npwd, (String) session.getAttribute("email"));
			
			if(status==true) {
				response.sendRedirect("/Banking/changepasswordsuccess.jsp");
			}
			
			else
			{
				response.sendRedirect("/Banking/changepasswordfail.jsp");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
