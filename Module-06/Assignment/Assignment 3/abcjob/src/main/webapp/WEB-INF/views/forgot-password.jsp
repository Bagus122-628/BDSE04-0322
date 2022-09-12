<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../components/header.jsp" %>
<link href="css/forgot-password.css" rel="stylesheet" />
<link>
</head>
<body>
	<div class="root">
      <%@ include file="../components/navbar.jsp" %>

      <main>
        <section id="forgot-password">
          <div class="container mt-5">
            <div class="d-flex justify-content-center">
              <div class="forgot-password-form d-flex flex-column text-center">
                <i class="fa-solid fa-lock"></i>
                <h2 class="fw-semibold">Forgot Password</h2>
                <p class="mb-3 text-secondary">Enter your email and we'll send you a link to reset your password</p>
                <!-- Form -->
                <form action="forgot-password-confirmation" method="post" id="form" onsubmit="return checkValidation()" class="d-flex flex-column">
                  <div class="form-group">
                    <input id="email" class="form-control" type="text" placeholder="Enter your email" />
                    <!-- Error Message -->
                    <p class="error errorEmail text-start">Email is required</p>
                    <p class="error invalidEmail text-start">Invalid email</p>
                  </div>
                  <button type="submit" class="btn btn-primary mt-3">Submit</button>
                </form>
              </div>
            </div>
          </div>
        </section>
      </main>

      <%@ include file="../components/footer.jsp" %>
   	</div>
   	<script src="js/forgot-password.js"></script>
</body>
</html>