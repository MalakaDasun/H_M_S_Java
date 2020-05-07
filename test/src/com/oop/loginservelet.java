//package com.customer;
package com.oop;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/loginservelet")
public class loginservelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String PatientID = request.getParameter("patientid");
		String BillID = request.getParameter("billid");
		
		try {
			customer cus;
			customerDButil obj = new customerDButil();
			cus = (customer) obj.validate(PatientID, BillID);
			//List<customer> cusDetails = obj.validate(PatientID, BillID);
			HttpSession session = request.getSession();
			session.setAttribute("patid", cus.getPatienID());
			session.setAttribute("billid", cus.getBillID());
			request.setAttribute("cus", cus);
			RequestDispatcher dis = request.getRequestDispatcher("useraccount.jsp");
			dis.forward(request, response);
			//.sendRedirect("useraccount.jsp");
			
			//System.out.println(cusDetails.get(0));
			
			System.out.println(cus.getAmount() + "amm");
			
		}
	
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
