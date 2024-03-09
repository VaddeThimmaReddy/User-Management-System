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
	</style>
</head>
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
          <a class="nav-link" href="#">youtube</a>
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
	<center>
	<h4>Add new user!!!</h4>
		<form action="AdminAdd" method="post">
		<label>Enter your Name: </label>
		<input type="text" name="name" id="tbname"/><br/>
	
		<label>Enter your Email: </label>
		<input type="email" name="email" id="tbemail"/><br/>
		
		<label>Enter your Mobile Number: </label>
		<input type="tel" name="mobile" id="tbmobile"/><br/>
		
		<label>Enter your City: </label>
		<input type="text" name="city" id="tbcity"/><br/>
		
		<label>Enter your User Name: </label>
		<input type="text" name="username" id="tbusername"/><br/>
		
		<label>Choose your PassWord: </label>
		<input type="password" name="password" id="tbpassword"/><br/>
		
		<input type="submit" name="register" id="btnreg">
	</form>
	</center>
</body>
</html>
