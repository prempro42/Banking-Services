package controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Model;

/**
 * Servlet implementation class Home
 */
public class Home extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) {

		try {
			Model m = new Model();
			m.setCid(request.getParameter("cid"));
			m.setPwd(request.getParameter("pwd"));
			
			boolean status = m.login();
			
			int acc = m.getAcc();
			
			HttpSession session = request.getSession(true);
			session.setAttribute("ACC", acc);
			
			
			if (status==true)
			{

				System.out.println("the account number is "+acc);
				response.sendRedirect("/Banking/home.jsp");
			}
			
			else
			{
				response.sendRedirect("/Banking/login.jsp");
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
