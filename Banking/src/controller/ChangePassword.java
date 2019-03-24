 package controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Model;

/**
 * Servlet implementation class ChangePassword
 */
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void service(HttpServletRequest request, HttpServletResponse response)
	{
		
		Model m = new Model();
		String opwd = request.getParameter("opwd");
		String npwd = request.getParameter("npwd");
		m.setPwd(opwd);
		
		
		try {
			boolean status = m.changePassword(npwd);
			
			if (status== true)
			{
				response.sendRedirect("/Banking/changepasswordsuccess.jsp");
			}
			else
			{
				response.sendRedirect("/Banking/changepasswordfail.jsp");
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
