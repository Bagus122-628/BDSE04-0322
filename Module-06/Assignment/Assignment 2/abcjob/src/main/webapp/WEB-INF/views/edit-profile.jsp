<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../components/header.jsp" %>
<link href="css/edit-profile.css" rel="stylesheet" />
<link>
</head>
<body>
	<div class="root">
      <%@ include file="../components/navbar.jsp" %>

      <main>
        <div class="container mt-5 mb-5">
          <form action="" method="post" id="form" onsubmit="return checkValidation()">
            <div class="row justify-content-center">
              <div class="col-lg-5 col-md-8">
                <div class="d-flex flex-column regis-wrapper">
                  <div class="heading">
                    <h2>Edit Profile</h2>
                  </div>

                  <!-- Email -->
                  <div class="form-group">
                    <label for="email">Email</label>
                    <input type="text" name="email" placeholder="sulivan@email.com" class="form-control" id="email" />
                  </div>
                  <p class="error errorEmail">Email is required</p>

                  <!-- First Name -->
                  <div class="form-group">
                    <label for="first_name">First Name</label>
                    <input type="text" name="first_name" placeholder="Alex" class="form-control" id="fname" />
                  </div>
                  <p class="error errorFname">First Name is required</p>

                  <!-- Last Name -->
                  <div class="form-group">
                    <label for="last_name">Last Name</label>
                    <input type="text" name="last_name" placeholder="Sulivan" class="form-control" id="lname" />
                  </div>
                  <p class="error errorLname">Last Name is required</p>

                  <!-- Country -->
                  <div class="form-group">
                    <label for="country">Country</label>
                    <input type="text" name="country" placeholder="Indonesia" class="form-control" id="country" />
                  </div>
                  <p class="error errorCountry">Country is required</p>

                  <!-- City -->
                  <div class="form-group">
                    <label for="city">City</label>
                    <input type="text" name="city" placeholder="Bali" class="form-control" id="city" />
                  </div>
                  <p class="error errorCity">City is required</p>

                  <button type="submit" class="btn btn-primary mt-4">Edit Profile</button>
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