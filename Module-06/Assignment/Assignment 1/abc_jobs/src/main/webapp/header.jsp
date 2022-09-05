<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<nav class="navbar navbar-expand-lg text-bg-light sticky-top">
  <div class="container">
    <a class="navbar-brand fw-bold fs-3" href="">ABC Jobs</a>
    <button
      class="navbar-toggler"
      type="button"
      data-bs-toggle="collapse"
      data-bs-target="#navbarNav"
      aria-controls="navbarNav"
      aria-expanded="false"
      aria-label="Toggle navigation"
    >
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse text-center" id="navbarNav">
      <ul class="navbar-nav ms-auto me-0 me-lg-auto fw-semibold text-uppercase">
        <li class="nav-item me-0 me-lg-3">
          <a class="nav-link" href=""><i class="fa-solid fa-house"></i> Home</a>
        </li>
        <li class="nav-item me-0 me-lg-3">
          <a class="nav-link" href=""><i class="fa-solid fa-user-group"></i> People</a>
        </li>
        <li class="nav-item me-0 me-lg-3">
          <a class="nav-link" href=""><i class="fa-solid fa-briefcase"></i> Jobs</a>
        </li>
      </ul>
      <div class="nav-button d-flex flex-column flex-lg-row">
      	<a href="">
      		<button class="btn btn-outline-secondary me-0 me-lg-3 mb-3 mb-lg-0">Login</button>
      	</a>
        <a href="<%= request.getContextPath() %>/registration">
        	<button class="btn btn-primary mb-3 mb-lg-0">Register</button>
        </a>
      </div>
    </div>
  </div>
</nav>
    