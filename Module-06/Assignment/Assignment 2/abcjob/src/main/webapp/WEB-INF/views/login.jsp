<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../components/header.jsp" %>
<link href="css/login.css" rel="stylesheet" />
<link>
</head>
<body>
	<div class="root">
      <%@ include file="../components/navbar.jsp" %>

      <main>
        <section id="login">
          <div class="container mt-5">
            <div class="d-flex justify-content-center">
              <div class="login-form">
                <h2 class="fw-semibold">Login</h2>
                <p class="text-secondary">Stay updated on your professional world</p>
                <!-- Login Form -->
                <form action="user-profile" method="get" class="mt-4 d-flex flex-column" id="form">
                  <div class="form-group">
                    <input id="loginEmail" class="form-control mb-3" type="text" placeholder="Email or phone" />
                  </div>
                  <div class="form-group">
                    <input id="loginPassword" class="form-control" type="password" placeholder="Password" />
                  </div>
                  <div class="forgot-password mt-3 mb-3 text-end">
                    <a class="text-decoration-none" href="forgot-password">Forgot Password?</a>
                  </div>
                  <button class="btn btn-primary" type="submit">Login</button>
                </form>

                <p class="p-0 mt-3">
                  Dont have an account?
                  <a class="text-primary text-decoration-none" href="register"> Register </a>
                </p>
              </div>
            </div>
          </div>
        </section>
      </main>

      <%@ include file="../components/footer.jsp" %>
   	</div>
</body>
</html>