package com.UserClass;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DataBaseClass {
	private static Connection cn = null;
	private static PreparedStatement stm = null;
	private static ResultSet res = null;
	
	private static String path = "jdbc:mySQL://localhost:3306/USER_MANAGEMENT_SYSTEM";
	private static String user = "root";
	private static String pass = "reddy995";
	
	public static Connection myConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(path, user, pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cn;
	}
	
	public static void insertUser(UserBeenClass been) {
		cn = myConnection();
		String query = "insert into userdetails (uname, uemail, umobile, ucity, uusername, upassword) values(?, ?, ?, ?, ?, ?)";
		try {
			stm = cn.prepareStatement(query);
			stm.setString(1, been.getFullName());
			stm.setString(2, been.getEmail());
			stm.setString(3, been.getMobile());
			stm.setString(4, been.getCity());
			stm.setString(5, been.getUserName());
			stm.setString(6, been.getPassword());
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(res!=null) {
				try {
					res.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stm!=null) {
				try {
					stm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(cn!=null) {
				try {
					cn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static ArrayList<String> al = null;
	public static ArrayList<String> getDetails(String name, String pass) {
		al = new ArrayList<>();
		 String uid = null;
		 String fullName =null;
		 String email =null;
		 String mobile =null;
		 String city =null;
		 String userName =null;
		 String password =null;
		cn = myConnection();
		String query = "select * from userdetails where uusername = ? and upassword = ? ";
		try {
			stm = cn.prepareStatement(query);
			stm.setString(1, name);
			stm.setString(2, pass);
			res = stm.executeQuery();
			while(res.next()) {
				uid = res.getString(1);
				fullName = res.getString(2);
				email = res.getString(3);
				mobile = res.getString(4);
				city = res.getString(5);
				userName = res.getString(6);
				password = res.getString(7);
			}
			al.add(uid);
			al.add(fullName);
			al.add(email);
			al.add(mobile);
			al.add(city);
			al.add(userName);
			al.add(password);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(res!=null) {
				try {
					res.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stm!=null) {
				try {
					stm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(cn!=null) {
				try {
					cn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return al;
		
	}
	public static ArrayList<String> all = null;
	public static void update(UserBeenClass been) {
		all = new ArrayList<>();
		 String uid = null;
		 String fullName =null;
		 String email =null;
		 String mobile =null;
		 String city =null;
		 String userName =null;
		 String password =null;
		cn = myConnection();
		String query1 = "update userdetails set uname= ?, uemail= ?,umobile= ?, ucity= ?, uusername= ?, upassword= ? where uid= ?";
		try {
			stm = cn.prepareStatement(query1);
			stm.setString(1, been.getFullName());
			stm.setString(2, been.getEmail());
			stm.setString(3, been.getMobile());
			stm.setString(4, been.getCity());
			stm.setString(5, been.getUserName());
			stm.setString(6, been.getPassword());
			stm.setString(7, been.getId());
			stm.executeUpdate();
			System.out.println("User details are updated success fully........");
			
			String query = "select * from userdetails where uusername = ? and upassword = ? ";
			stm = cn.prepareStatement(query);
			stm.setString(1, been.getUserName());
			stm.setString(2, been.getPassword());
			res = stm.executeQuery();
			while(res.next()) {
				uid = res.getString(1);
				fullName = res.getString(2);
				email = res.getString(3);
				mobile = res.getString(4);
				city = res.getString(5);
				userName = res.getString(6);
				password = res.getString(7);
			}
			all.add(uid);
			all.add(fullName);
			all.add(email);
			all.add(mobile);
			all.add(city);
			all.add(userName);
			all.add(password);
			
			}
		 catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(res!=null) {
				try {
					res.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stm!=null) {
				try {
					stm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(cn!=null) {
				try {
					cn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
