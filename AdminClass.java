package com.UserClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminClass {
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
	public static ArrayList<String> ar = null;
	public static void adminLogin(String mobile, String password) {
		ar = new ArrayList<String>();
		String amobile = null;
		String apass = null;
		cn = myConnection();
		String query = "select admmobile, admpassword from administration where admmobile = ? and admpassword = ? ";
		try {
			stm = cn.prepareStatement(query);
			stm.setString(1, mobile );
			stm.setString(2, password );
			res = stm.executeQuery();
			while (res.next()) {
				amobile = res.getString(1);
				apass = res.getString(2);
			}
			ar.add(amobile);
			ar.add(apass);
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
	//public static ArrayList<UserBeenClass> alld = null;
	public static ArrayList<UserBeenClass> getDetails() {
		ArrayList<UserBeenClass> alld = new ArrayList<UserBeenClass>();
		 String uid = null;
		 String fullName =null;
		 String email =null;
		 String mobile =null;
		 String city =null;
		 String userName =null;
		 String password =null;
		cn = myConnection();
		try {
			stm = cn.prepareStatement("select * from userdetails");
			res = stm.executeQuery();
			while (res.next()) {
				uid = res.getString(1);
				fullName = res.getString(2);
				email = res.getString(3);
				mobile = res.getString(4);
				city = res.getString(5);
				userName = res.getString(6);
				password = res.getString(7);
				UserBeenClass ubc = new UserBeenClass(uid, fullName, email, mobile, city, userName, password);
				alld.add(ubc);
			}
			System.out.println("executed arrayList alld");
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
		return alld;
	}
	
	public static void Delete(String id1) {
		cn = myConnection();
		String query = "delete from userdetails where uid = ?";
		try {
			stm = cn.prepareStatement(query);
			stm.setString(1, id1 );
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
	
	public static ArrayList<String> select(String id) {
		ArrayList<String> ids = new ArrayList<>();
		 String uid = null;
		 String fullName =null;
		 String email =null;
		 String mobile =null;
		 String city =null;
		 String userName =null;
		 String password =null;
		cn = myConnection();
		String query = "select * from userdetails where uid = ?";
		try {
			stm = cn.prepareStatement(query);
			stm.setString(1,id);
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
			ids.add(uid);
			ids.add(fullName);
			ids.add(email);
			ids.add(mobile);
			ids.add(city);
			ids.add(userName);
			ids.add(password);
			
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
		
		return ids;
		
	}
	
	public static void AdminUpdate(UserBeenClass been1) {
		cn = myConnection();
		String query = "update userdetails set uid = ? ,uname= ?, uemail= ?,umobile= ?, ucity= ?, uusername= ?, upassword= ? where uid= ?";
		try {
			stm = cn.prepareStatement(query);
			stm.setString(1, been1.getId());
			stm.setString(2, been1.getFullName());
			stm.setString(3, been1.getEmail());
			stm.setString(4, been1.getMobile());
			stm.setString(5, been1.getCity());
			stm.setString(6, been1.getUserName());
			stm.setString(7, been1.getPassword());
			stm.setString(8, been1.getMain());
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
}
