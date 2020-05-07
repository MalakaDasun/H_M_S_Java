package com.oop;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

/**
 * Servlet implementation class UpdateBillServlet
 */
//@WebServlet("/UpdateBillServlet")
public class UpdateBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int amount = Integer.parseInt(request.getParameter("ammou"));
		HttpSession session = request.getSession();
		String patid = (String) session.getAttribute("patid");
		String billid = (String) session.getAttribute("billid");
		
		customerDButil util = new customerDButil();
		int result = util.updateBill(amount, billid);
		
		System.out.println(result);
	}

}
