package com.UserServlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.UserClass.AdminClass;
import com.UserClass.DataBaseClass;
import com.UserClass.UserBeenClass;

@WebServlet("/")
public class DefaultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String path = request.getServletPath();
			switch (path) {
			case "/purchesBooks" :
				getpurchesBooks(request , response);
				break;
			case "/edit" :
				getEditDetails(request , response);
				break;
			case "/update" :
				getUpdateDetails(request , response);
				break;
			case "/login" :
				getLoginPage(request , response);
				break;
			case "/Registration" :
				getUserregistrationPage(request , response);
				break;
			case "/Admin" :
				getAdministrationPage(request , response);
				break;
			case "/AdminAdd" :
				getAdminAdd(request , response);
				break;
			case "/delete" :
				getDeletePage(request , response);
				break;
			case "/AdminEdit" :
				getAdminEdit(request,response);
				break;
			case "/AdminEdit1" :
				getAdminEdi1(request , response);
				break;
			default :
				getHomePage(request , response);
				break;
			}
		}
	String main;
	private void getAdminEdi1(HttpServletRequest request, HttpServletResponse response) {
		String  id = request.getParameter("id");
		ArrayList<String> nl = AdminClass.select(id);
		request.setAttribute("ui", nl.get(0));
		request.setAttribute("un", nl.get(1));
		request.setAttribute("ue", nl.get(2));
		request.setAttribute("um", nl.get(3));
		request.setAttribute("uc", nl.get(4));
		request.setAttribute("uu", nl.get(5));
		request.setAttribute("up", nl.get(6));
		main = nl.get(0);
		RequestDispatcher rd = request.getRequestDispatcher("adminEditing.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			
			e.printStackTrace();
		}
	}

	private void getAdminEdit(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mob = request.getParameter("mobile");
		String city = request.getParameter("city");
		String usern = request.getParameter("username");
		String passw = request.getParameter("password");
		
		
		UserBeenClass ubc1 = new UserBeenClass( name, email, mob, city, usern, passw, id, main);
		AdminClass.AdminUpdate(ubc1);
		
		ArrayList<UserBeenClass> array = AdminClass.getDetails();
		request.setAttribute("ar", array);
		RequestDispatcher rd = request.getRequestDispatcher("administration.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	private void getDeletePage(HttpServletRequest request, HttpServletResponse response) {
		
		String  id = request.getParameter("id");
		AdminClass.Delete(id);
		ArrayList<UserBeenClass> array = AdminClass.getDetails();
		request.setAttribute("ar", array);

		RequestDispatcher rd = request.getRequestDispatcher("administration.jsp");
					try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
	}

	private void getAdminAdd(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mob = request.getParameter("mobile");
		String city = request.getParameter("city");
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		
		UserBeenClass ubc = new UserBeenClass(name, email, mob, city, user, pass);
		com.UserClass.DataBaseClass.insertUser(ubc);
		ArrayList<UserBeenClass> array = AdminClass.getDetails();
		request.setAttribute("ar", array);

		RequestDispatcher rd = request.getRequestDispatcher("administration.jsp");
					try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
	}

	private void getAdministrationPage(HttpServletRequest request, HttpServletResponse response) {
		
		String mob = request.getParameter("amob");
		String pass = request.getParameter("apass");
		AdminClass.adminLogin(mob, pass);
		String amob = AdminClass.ar.get(0);
		String apass = AdminClass.ar.get(1);
		
		if(mob.equals(amob) && pass.equals(apass)) {
			ArrayList<UserBeenClass> array = AdminClass.getDetails();
			request.setAttribute("ar", array);

			RequestDispatcher rd = request.getRequestDispatcher("administration.jsp");
						try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("adminlogin.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}

	private void getUpdateDetails(HttpServletRequest request, HttpServletResponse response) {
		String id = DataBaseClass.al.get(0);
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mob = request.getParameter("mobile");
		String city = request.getParameter("city");
		String usern = request.getParameter("username");
		String passw = request.getParameter("password");
		UserBeenClass ubc1 = new UserBeenClass( name, email, mob, city, usern, passw, id);
		DataBaseClass.update(ubc1);
		
		request.setAttribute("ui", DataBaseClass.all.get(0));
		request.setAttribute("un", DataBaseClass.all.get(1));
		request.setAttribute("ue", DataBaseClass.all.get(2));
		request.setAttribute("um", DataBaseClass.all.get(3));
		request.setAttribute("uc", DataBaseClass.all.get(4));
		request.setAttribute("uu", DataBaseClass.all.get(5));
		request.setAttribute("up", DataBaseClass.all.get(6));
		
		RequestDispatcher rd = request.getRequestDispatcher("userDetail.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			
			e.printStackTrace();
		}
	}

	private void getEditDetails(HttpServletRequest request, HttpServletResponse response) {
		
//		System.out.println(DataBaseClass.getDetails(uname, upass));
		request.setAttribute("ui", DataBaseClass.al.get(0));
		request.setAttribute("un", DataBaseClass.al.get(1));
		request.setAttribute("ue", DataBaseClass.al.get(2));
		request.setAttribute("um", DataBaseClass.al.get(3));
		request.setAttribute("uc", DataBaseClass.al.get(4));
		request.setAttribute("uu", DataBaseClass.al.get(5));
		request.setAttribute("up", DataBaseClass.al.get(6));
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("editdetails.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			
			e.printStackTrace();
		}
	}

	private void getUserregistrationPage(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mob = request.getParameter("mobile");
		String city = request.getParameter("city");
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		
		UserBeenClass ubc = new UserBeenClass(name, email, mob, city, user, pass);
		com.UserClass.DataBaseClass.insertUser(ubc);;
		RequestDispatcher rd = request.getRequestDispatcher("userLogin.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			
			e.printStackTrace();
		}
		
	}
		
	private void getLoginPage(HttpServletRequest request, HttpServletResponse response) {
		
		
			 String uname = request.getParameter("user");
			 String upass = request.getParameter("pass");
		
		System.out.println(DataBaseClass.getDetails(uname, upass));
		request.setAttribute("ui", DataBaseClass.al.get(0));
		request.setAttribute("un", DataBaseClass.al.get(1));
		request.setAttribute("ue", DataBaseClass.al.get(2));
		request.setAttribute("um", DataBaseClass.al.get(3));
		request.setAttribute("uc", DataBaseClass.al.get(4));
		request.setAttribute("uu", DataBaseClass.al.get(5));
		request.setAttribute("up", DataBaseClass.al.get(6));
		
		String name = DataBaseClass.al.get(5);
		String pass = DataBaseClass.al.get(6);
		
		if(uname.equals(name) && upass.equals(pass)) {
			RequestDispatcher rd = request.getRequestDispatcher("userDetail.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				
				e.printStackTrace();
			}
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("userLogin.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				
				e.printStackTrace();
			}
		}
		
	}

	private void getpurchesBooks(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher rd = request.getRequestDispatcher("purchesBook.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			
			e.printStackTrace();
		}
		
	}

	private void getHomePage(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
package com.UserServlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.UserClass.AdminClass;
import com.UserClass.DataBaseClass;
import com.UserClass.UserBeenClass;

@WebServlet("/")
public class DefaultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String path = request.getServletPath();
			switch (path) {
			case "/purchesBooks" :
				getpurchesBooks(request , response);
				break;
			case "/edit" :
				getEditDetails(request , response);
				break;
			case "/update" :
				getUpdateDetails(request , response);
				break;
			case "/login" :
				getLoginPage(request , response);
				break;
			case "/Registration" :
				getUserregistrationPage(request , response);
				break;
			case "/Admin" :
				getAdministrationPage(request , response);
				break;
			case "/AdminAdd" :
				getAdminAdd(request , response);
				break;
			case "/delete" :
				getDeletePage(request , response);
				break;
			case "/AdminEdit" :
				getAdminEdit(request,response);
				break;
			case "/AdminEdit1" :
				getAdminEdi1(request , response);
				break;
			default :
				getHomePage(request , response);
				break;
			}
		}
	String main;
	private void getAdminEdi1(HttpServletRequest request, HttpServletResponse response) {
		String  id = request.getParameter("id");
		ArrayList<String> nl = AdminClass.select(id);
		request.setAttribute("ui", nl.get(0));
		request.setAttribute("un", nl.get(1));
		request.setAttribute("ue", nl.get(2));
		request.setAttribute("um", nl.get(3));
		request.setAttribute("uc", nl.get(4));
		request.setAttribute("uu", nl.get(5));
		request.setAttribute("up", nl.get(6));
		main = nl.get(0);
		RequestDispatcher rd = request.getRequestDispatcher("adminEditing.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			
			e.printStackTrace();
		}
	}

	private void getAdminEdit(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mob = request.getParameter("mobile");
		String city = request.getParameter("city");
		String usern = request.getParameter("username");
		String passw = request.getParameter("password");
		
		
		UserBeenClass ubc1 = new UserBeenClass( name, email, mob, city, usern, passw, id, main);
		AdminClass.AdminUpdate(ubc1);
		
		ArrayList<UserBeenClass> array = AdminClass.getDetails();
		request.setAttribute("ar", array);
		RequestDispatcher rd = request.getRequestDispatcher("administration.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	private void getDeletePage(HttpServletRequest request, HttpServletResponse response) {
		
		String  id = request.getParameter("id");
		AdminClass.Delete(id);
		ArrayList<UserBeenClass> array = AdminClass.getDetails();
		request.setAttribute("ar", array);

		RequestDispatcher rd = request.getRequestDispatcher("administration.jsp");
					try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
	}

	private void getAdminAdd(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mob = request.getParameter("mobile");
		String city = request.getParameter("city");
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		
		UserBeenClass ubc = new UserBeenClass(name, email, mob, city, user, pass);
		com.UserClass.DataBaseClass.insertUser(ubc);
		ArrayList<UserBeenClass> array = AdminClass.getDetails();
		request.setAttribute("ar", array);

		RequestDispatcher rd = request.getRequestDispatcher("administration.jsp");
					try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
	}

	private void getAdministrationPage(HttpServletRequest request, HttpServletResponse response) {
		
		String mob = request.getParameter("amob");
		String pass = request.getParameter("apass");
		AdminClass.adminLogin(mob, pass);
		String amob = AdminClass.ar.get(0);
		String apass = AdminClass.ar.get(1);
		
		if(mob.equals(amob) && pass.equals(apass)) {
			ArrayList<UserBeenClass> array = AdminClass.getDetails();
			request.setAttribute("ar", array);

			RequestDispatcher rd = request.getRequestDispatcher("administration.jsp");
						try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("adminlogin.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}

	private void getUpdateDetails(HttpServletRequest request, HttpServletResponse response) {
		String id = DataBaseClass.al.get(0);
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mob = request.getParameter("mobile");
		String city = request.getParameter("city");
		String usern = request.getParameter("username");
		String passw = request.getParameter("password");
		UserBeenClass ubc1 = new UserBeenClass( name, email, mob, city, usern, passw, id);
		DataBaseClass.update(ubc1);
		
		request.setAttribute("ui", DataBaseClass.all.get(0));
		request.setAttribute("un", DataBaseClass.all.get(1));
		request.setAttribute("ue", DataBaseClass.all.get(2));
		request.setAttribute("um", DataBaseClass.all.get(3));
		request.setAttribute("uc", DataBaseClass.all.get(4));
		request.setAttribute("uu", DataBaseClass.all.get(5));
		request.setAttribute("up", DataBaseClass.all.get(6));
		
		RequestDispatcher rd = request.getRequestDispatcher("userDetail.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			
			e.printStackTrace();
		}
	}

	private void getEditDetails(HttpServletRequest request, HttpServletResponse response) {
		
//		System.out.println(DataBaseClass.getDetails(uname, upass));
		request.setAttribute("ui", DataBaseClass.al.get(0));
		request.setAttribute("un", DataBaseClass.al.get(1));
		request.setAttribute("ue", DataBaseClass.al.get(2));
		request.setAttribute("um", DataBaseClass.al.get(3));
		request.setAttribute("uc", DataBaseClass.al.get(4));
		request.setAttribute("uu", DataBaseClass.al.get(5));
		request.setAttribute("up", DataBaseClass.al.get(6));
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("editdetails.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			
			e.printStackTrace();
		}
	}

	private void getUserregistrationPage(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mob = request.getParameter("mobile");
		String city = request.getParameter("city");
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		
		UserBeenClass ubc = new UserBeenClass(name, email, mob, city, user, pass);
		com.UserClass.DataBaseClass.insertUser(ubc);;
		RequestDispatcher rd = request.getRequestDispatcher("userLogin.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			
			e.printStackTrace();
		}
		
	}
		
	private void getLoginPage(HttpServletRequest request, HttpServletResponse response) {
		
		
			 String uname = request.getParameter("user");
			 String upass = request.getParameter("pass");
		
		System.out.println(DataBaseClass.getDetails(uname, upass));
		request.setAttribute("ui", DataBaseClass.al.get(0));
		request.setAttribute("un", DataBaseClass.al.get(1));
		request.setAttribute("ue", DataBaseClass.al.get(2));
		request.setAttribute("um", DataBaseClass.al.get(3));
		request.setAttribute("uc", DataBaseClass.al.get(4));
		request.setAttribute("uu", DataBaseClass.al.get(5));
		request.setAttribute("up", DataBaseClass.al.get(6));
		
		String name = DataBaseClass.al.get(5);
		String pass = DataBaseClass.al.get(6);
		
		if(uname.equals(name) && upass.equals(pass)) {
			RequestDispatcher rd = request.getRequestDispatcher("userDetail.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				
				e.printStackTrace();
			}
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("userLogin.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				
				e.printStackTrace();
			}
		}
		
	}

	private void getpurchesBooks(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher rd = request.getRequestDispatcher("purchesBook.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			
			e.printStackTrace();
		}
		
	}

	private void getHomePage(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
