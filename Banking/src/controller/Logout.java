package controller;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 *
	 * 
	 */

	public void service(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		session.invalidate();
		// String s="you have been successfully logged"

		try {
			response.sendRedirect("/Banking/index.jsp");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
