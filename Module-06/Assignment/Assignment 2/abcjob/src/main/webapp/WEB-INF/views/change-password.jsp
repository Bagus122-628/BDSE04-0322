<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../components/header.jsp" %>
<link href="css/change-password.css" rel="stylesheet" />
<link>
</head>
<body>
	<div class="root">
      <%@ include file="../components/navbar.jsp" %>

	  <main>
        <div class="container mt-5 mb-5">
          <form action="" method="post" id="form" onsubmit="return changePassword()">
            <div class="row justify-content-center">
              <div class="col-lg-5 col-md-8">
                <div class="d-flex flex-column form-wrapper">
                  <div class="heading">
                    <h2>Change Password</h2>
                  </div>

                  <!-- Old Password -->
                  <div class="form-group">
                    <label for="password">Old Password</label>
                    <input type="password" name="password" placeholder="Old Password" class="form-control" id="password" />
                  </div>
                  <p class="error errorPassword">Old Password is required</p>

                  <!-- New Password -->
                  <div class="form-group">
                    <label for="password">New Password</label>
                    <input type="password" name="password" placeholder="New Password" class="form-control" id="password" />
                  </div>
                  <p class="error errorNewPassword">New Password is required</p>

                  <button type="submit" class="btn btn-primary mt-4">Change Password</button>
                </div>
              </div>
            </div>
          </form>
        </div>
      </main>

      <%@ include file="../components/footer.jsp" %>
   	</div>
</body>
</html>