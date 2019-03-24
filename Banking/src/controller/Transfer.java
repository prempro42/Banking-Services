package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

/**
 * Servlet implementation class Transfer
 */
public class Transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		try {
			Model m = new Model();
			
			HttpSession session = request.getSession();
			int acc = (Integer) session.getAttribute("ACC");
			m.setAcc(acc);
			
			String tamt = request.getParameter("tamt");
			boolean status = m.transfer(tamt);
			
			if(status==true)
			{
				response.sendRedirect("/Banking/transfersuccess.jsp");
			}
			else
			{
				response.sendRedirect("/Banking/transferfail.jsp");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
