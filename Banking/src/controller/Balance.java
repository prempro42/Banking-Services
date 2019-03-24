package controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

public class Balance extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {


		
	
		try {
			HttpSession session = request.getSession();
			int acc = (Integer) session.getAttribute("ACC");

			Model m = new Model();
			m.setAcc(acc);
			boolean status = m.checkBalance();
			int balance = m.getBalance();
			
			if(status==true)
			{
				session.setAttribute("balance", balance);
				System.out.println("the balance is "+balance);
				response.sendRedirect("/Banking/balance.jsp");
				
			}
			
			else
			{
				response.sendRedirect("/Banking/balancefail.jsp");
			}
		
		
		} catch (Exception e) {
			
				response.sendRedirect("/Banking/sessionexpired.jsp");
			
			
			e.printStackTrace();
		}

	}

}
