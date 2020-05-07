package com.oop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class customerDButil {
	
	static String url = "jdbc:mysql://localhost:3306/patient";
	static String user = "root";
	static String pass = "MDnayana##99";
	
	public static customer validate(String patientid , String billid) {
		
		
		//ArrayList<customer> cus = new ArrayList<customer>();
		
		
		
		customer cust = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement psStatement = con.prepareStatement("SELECT * FROM patient.customer where PatientID = ? and BillID = ?");
			psStatement.setString(1, patientid);
			psStatement.setString(2, billid);
			
			ResultSet resultSet = psStatement.executeQuery();
			
			
			while(resultSet.next()) {
				
				String patient = resultSet.getString("PatientID");
				String bill = resultSet.getString("BillID");
				int amm = resultSet.getInt("Amount");
				
				cust = new customer(patient, bill, amm);
				
				System.out.println(patient);
				System.out.println(bill);
				System.out.println(amm);
				
				//cus.add(cust);
				
			}
			
			//Statement stmt = con.createStatement();
			
			//String sql = "select * from customer where PatientID = '"+patientid+"' BillID = '"+billid+"' ";
			
			/// rs = stmt.executeQuery(sql);
			
//			if(rs.next()) {
//				String PatientID = rs.getString(1);
//				String BillID = rs.getString(2);
//				int Amount = rs.getInt(3);
//				
//				customer c = new customer(PatientID,BillID,Amount);
//				cus.add(c);
//			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		 
		return cust;
		
	}
	
	public int insertcustomer(String pid , String bid , int ammo) {
		
		int isSuccess = 0;
		
		System.out.println(pid);
		
		String url = "jdbc:mysql://localhost:3306/patient";
		String user = "root";
		String pass = "MDnayana##99";
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			

			//Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement psStatement = con.prepareStatement("INSERT INTO `patient`.`customer` (`PatientID`, `BillID`, `Amount`) VALUES (?,?,?)");
			psStatement.setString(1, pid);
			psStatement.setString(2, bid);
			psStatement.setInt(3, ammo);
			
			System.out.println(pid);
			
			isSuccess = psStatement.executeUpdate();
			System.out.println(isSuccess);
			
			
			//Statement stmt = con.createStatement();
			
//			String sql = "insert into customer values ('"+pid+"', '"+bid+"' , ammo)" ;
//			int rs = stmt.executeUpdate(sql);
//			
//			if(rs > 0) {
//				isSuccess = true;
//			}
//			else {
//				isSuccess = false; 
//			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return isSuccess;
		
		
	}
	
	public int updateBill(int amm, String billid) {
		
		int result = 0;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement preparedStatement = con.prepareStatement("UPDATE `patient`.`customer` SET `Amount` = ? WHERE (`BillID` = ?)");
			preparedStatement.setInt(1, amm);
			preparedStatement.setString(2, billid);
			result = preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return result;
		
	}
	
public int delUser(String billid) {
		
		int result = 0;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement preparedStatement = con.prepareStatement("DELETE FROM `patient`.`customer` WHERE (`BillID` = ?)");
			preparedStatement.setString(1, billid);
			result = preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return result;
		
	}
	
}























