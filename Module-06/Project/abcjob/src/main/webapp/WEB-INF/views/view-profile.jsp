<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../components/header.jsp" %>
<link href="css/view-profile.css" rel="stylesheet" />
<link>
</head>
<body>
	<div class="root">
      <%@ include file="../components/navbar.jsp" %>

	<main>
        <section id="profile-user">
          <div class="container">
            <div class="d-flex mt-5">
              <!-- profile -->
              <main class="me-3 main-profile">
                <div class="profile">
                  <div class="banner">
                    <img src="images/user/banner/banner2.jpg" alt="" />
                  </div>
                  <div class="p-4 pt-5 position-relative">
                    <div class="profile-picture position-absolute">
                      <img src="images/user/user-default.png" alt="" />
                    </div>
                    <div class="d-flex justify-content-between">
                      <h3 class="name">${view.first_name} ${view.last_name}</h3>
                    </div>
                    <p class="address m-0 mb-1">${view.country}, ${view.city}</p>
                    <p class="company"><i class="fa-solid fa-building"></i> ${view.getJob().getCompany_name()}</p>
                    <div class="d-flex">
                      <button class="btn btn-primary me-3">Follow ${view.first_name}</button>
                      <button class="btn btn-outline-dark">More</button>
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
                      <p>Bobi Herdian</p>
                      <p class="text-secondary">Indonesia, Bali</p>
                      <p class="text-secondary"><i class="fa-solid fa-building"></i> Facebook</p>
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