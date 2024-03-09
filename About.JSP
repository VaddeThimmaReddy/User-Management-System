<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" >
<title>USER MANAGEMENT SYSTEM</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
	<style>
		body {
            background-image: url('https://cdn.pixabay.com/photo/2017/02/16/19/47/bokeh-2072271_640.jpg');
            background-size: cover; /* Adjust as needed */
            margin: 0; /* Remove default body margin */
        }
	</style></head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary" style="background-color: #1c03fc;">
  <div class="container-fluid">
    <a class="navbar-brand" href="<%=request.getContextPath()%>/home">Home</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="<%=request.getContextPath()%>/purchesBooks">Purches Books</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<%=request.getContextPath()%>/about.jsp">About</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Admin Links
          </a>	
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">Action</a></li>
            <li><a class="dropdown-item" href="#">Another action</a></li>
            <li><a class="dropdown-item" href="#">Something else here</a></li>
          </ul>
        </li>
       
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="userLogin.jsp">User Login</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<%=request.getContextPath()%>/adminlogin.jsp">Admin Account</a>
        </li>
        
      </ul>
      <form class="d-flex" role="search">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>
<h4 style="color: #78233b;"><i> Admin: Thimmareddy</i></h4>
	<center><h1 style="color: #096120;"><i>USER MANAGEMENT SYSTEM</i></h1></center><hr>
	<div class="container">
	<ul>
	<h2>About</h2>
	<p>It sounds like you have designed a comprehensive user management system with specific features for practicing test questions, taking tests, displaying results, and implementing user roles with administrative capabilities. Let's break down the key features and components of your user management system:</p>
	<h3>User Management System Description:</h3>
	<h4>1. User Registration and Authentication:</h4>
	<li>Users can create accounts with unique usernames and passwords.</li>
	<li>Implemented user authentication to ensure secure access to the system.</li>
	<h4>2. User Roles:</h4>
	<li>Differentiates between regular users and administrators.</li>
	<li>Regular users can manage their own data (edit, delete).</li>
	<li>Administrators have the authority to manage all data on the website, including user data.</li>
	<h4>3. Test Question Practice:</h4>
	<li>Provides a section for users to practice test questions.</li>
	<li>Users can access a variety of questions to enhance their skills.</li>
	<h4>4. Test Taking:</h4>
	<li>Users can take tests with a predefined set of questions.</li>
	<li>The system evaluates and records test results.</li>
	<h4>5. User Home Page:</h4>
	<li>Displays personalized home pages for each user.</li>
	<li>Shows test results, performance metrics, and other relevant information.</li>
	<h4>6. User Data Management:</h4>
	<li>Users can edit and delete their personal data.</li>
	<li>Ensures data privacy and control over user information.</li>
	<h4>7. Administration Panel:</h4>
	<li>Accessible only by administrators.</li>
	<li>Provides capabilities to modify and delete any data on the website, including user data.</li>
	<li>Restricts access to the administration panel to only authorized personnel.</li>
	<h4>8. Security Measures:</h4>
	<li>Implements secure authentication practices.</li>
	<li>Ensures that only authorized personnel can access and modify sensitive information.</li>
	<h4>9. Web Technologies:</h4>
	<li>Utilizes HTML for structuring the web pages.</li>
	<li>Applies CSS for styling and layout design.</li>
	<li>Incorporates JavaScript for client-side interactivity.</li>
	<li>Integrates Bootstrap framework for responsive and mobile-friendly design.</li>
	<h4>10. J2EE Technologies:</h4>
	<li>Uses Java programming language for backend development.</li>
	<li>Implements Servlets for handling HTTP requests and responses.</li>
	<li>Utilizes JSP (JavaServer Pages) for dynamic content generation.</li>
	<li>Manages data persistence with databases (e.g., MySQL, PostgreSQL) using JDBC.</li>
	<h3>Future Enhancements:</h3>
	<li>Consider incorporating AJAX for smoother user interactions.</li>
	<li>Implement email verification during the user registration process.</li>
	<li>Provide analytics and visualizations for users to track their progress.</li>
	<li>Explore additional frameworks or libraries for frontend development.</li>
	
	</ul>
	</div>
</body>
</html>
