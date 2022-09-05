<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>ABC Jobs</title>
	<link 
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" 
    rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <script src="https://kit.fontawesome.com/848830b72b.js"></script>
</head>
<body>
	<div class="root">
	  <header>
	    <%@ include file="header.jsp" %>
	  </header>
	
	  <main class="main_content">
	    <section id="registration-confirmation" class="mt-5">
		  <div class="container d-flex justify-content-center">
		    <div class="confirmation d-flex flex-column text-center">
		      <h2 class="fw-semibold">
		        Thanks for registering <i class="fa-solid fa-check text-success"></i>
		      </h2>
		      <p class="text-secondary">
		        Your account has been created and a verification email has been sent to your registered email address.
		      </p>
		      <div class="wrapper">
			      <a href="<%= request.getContextPath() %>/register.jsp">
			      	<button class="btn btn-primary mt-3">CONTINUE</button>
			      </a>
		      </div>
		    </div>
		  </div>
		</section>
	  </main>
	
	  <footer>
	    <%@ include file="footer.jsp" %>
	  </footer>
	</div>

    <script type="text/javascript" src="js/validator.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>