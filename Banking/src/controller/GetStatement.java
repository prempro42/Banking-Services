package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

/**
 * Servlet implementation class GetStatement
 */
public class GetStatement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		try {
			HttpSession session = request.getSession();
			
			int acc = (Integer) session.getAttribute("ACC");
			Model m = new Model();
			m.setAcc(acc);
			ArrayList<Integer> al;
			al = m.getStatement();
			session.setAttribute("AL", al);
			
		 response.sendRedirect("/Banking/getstatementsuccess.jsp");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
