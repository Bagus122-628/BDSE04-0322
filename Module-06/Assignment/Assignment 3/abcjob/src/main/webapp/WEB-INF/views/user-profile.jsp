<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../components/header.jsp" %>
<link href="css/user-profile.css" rel="stylesheet" />
<link>
</head>
<body>
	<div class="root">
      <%@ include file="../components/navbar.jsp" %>

      <main>
        <section id="user-profile">
          <div class="container">
            <div class="d-flex mt-5">
              <!-- profile -->
              <main class="me-3 main-profile">
                <div class="profile">
                  <div class="banner">
                    <img src="images/user/banner/banner1.jpg" alt="" />
                  </div>
                  <div class="p-4 pt-5 position-relative">
                    <div class="profile-picture position-absolute">
                      <img src="images/user/user-default.png" alt="" />
                    </div>
                    <div class="d-flex justify-content-between">
                      <h3 class="name">${profile.first_name} ${profile.last_name}</h3>
                      <!-- Edit -->
                      <div class="d-flex flex-column">
                        <a class="btn btn-primary" href="edit-profile">Edit Profile</a>
                      </div>
                    </div>
                    <p class="address m-0 mb-1">${profile.country}, ${profile.city}</p>
                    <p class="company"><i class="fa-solid fa-building"></i> Facebook</p>
                    <div class="d-flex">
                      <div class="dropdown">
                        <button class="btn btn-primary dropdown-toggle me-3" type="button" data-bs-toggle="dropdown" aria-expanded="false">Add profile section</button>
                        <ul class="dropdown-menu">
                          <li><a class="dropdown-item" href="">About</a></li>
                          <li><a class="dropdown-item" href="">Jobs</a></li>
                          <li><a class="dropdown-item" href="">Posts</a></li>
                          <li><a class="dropdown-item" href="">People</a></li>
                        </ul>
                      </div>
                      <div class="dropdown">
                        <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">More</button>
                        <ul class="dropdown-menu">
                          <li><a class="dropdown-item" href="edit-profile">Edit Profile</a></li>
                          <li><a class="dropdown-item" href="change-password">Change Password</a></li>
                        </ul>
                      </div>
                    </div>
                  </div>
                </div>

                <ul class="navigation d-flex mt-3 list-unstyled fw-semibold">
                  <li class="nav-profile">About</li>
                  <li class="nav-profile">Jobs</li>
                  <li class="nav-profile">Posts</li>
                  <li class="nav-profile">People</li>
                </ul>
                <section class="about">
                  <div class="d-flex justify-content-between">
                    <h5>About</h5>
                    <button class="btn btn-outline-secondary">Edit About</button>
                  </div>
                  <p class="mt-3">Lorem ipsum dolor sit amet consectetur, adipisicing elit. Neque officia veritatis, totam itaque voluptatum eaque aut similique! Sunt est illo expedita, deserunt eius pariatur tempore.</p>
                </section>
              </main>
              <!-- aside -->
              <aside class="d-none d-md-flex flex-column">
                <div class="people d-flex flex-column p-3">
                  <h5 class="mb-3">People you may know</h5>
                  <div class="people-profile d-flex mb-3">
                    <div class="image me-3">
                      <img src="images/user/user2.png" alt="" />
                    </div>
                    <div class="detail">
                      <p>Ryan Kovic </p>
                      <p class="text-secondary">Indonesia, Jakarta</p>
                      <p class="text-secondary"><i class="fa-solid fa-building"></i> Google</p>
                    </div>
                  </div>
                </div>
              </aside>
            </div>
          </div>
        </section>
      </main>

      <%@ include file="../components/footer.jsp" %>
   	</div>
</body>
</html>