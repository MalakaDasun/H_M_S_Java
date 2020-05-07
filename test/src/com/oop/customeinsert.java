package com.oop;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/customeinsert")
public class customeinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	try {
		
		String pid = request.getParameter("patientid");	
		String bid = request.getParameter("billid");
		int Amount = Integer.parseInt(request.getParameter("amount"));
		
		System.out.println(pid);
		
		int isTrue = 0;
		
		customerDButil c1 = new customerDButil();
		
		isTrue = c1.insertcustomer(pid, bid, Amount);
		System.out.println(isTrue);
			
		if(isTrue == 1) {
			RequestDispatcher dis = request.getRequestDispatcher("success.jsp");
			dis.forward(request, response);
		}
		else {
			RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
			dis2.forward(request, response);
		}
		
	} catch (Exception e) {
		// TODO: handle exception
		e.fillInStackTrace();
	}
	
	}

}
