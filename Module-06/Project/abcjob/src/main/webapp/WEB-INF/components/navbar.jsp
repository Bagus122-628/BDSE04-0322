<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored = "false" %>
<header>
  <nav class="navbar navbar-expand-lg text-bg-light sticky-top">
    <div class="container">
      <a class="navbar-brand fw-bold fs-3" href="<%= request.getContextPath() %>">ABC Jobs</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse text-center" id="navbarNav">
        <ul class="navbar-nav ms-auto me-0 me-lg-auto fw-semibold text-uppercase">
          <li class="nav-item me-0 me-lg-3">
            <a class="nav-link" href="<%= request.getContextPath() %>"><i class="fa-solid fa-house"></i> Home</a>
          </li>
          <li class="nav-item me-0 me-lg-3">
            <a class="nav-link" href="search-user"><i class="fa-solid fa-user-group"></i> People</a>
          </li>
          <li class="nav-item me-0 me-lg-3">
            <a class="nav-link" href="jobs"><i class="fa-solid fa-briefcase"></i> Jobs</a>
          </li>
          
          <c:if test="${profile != null}">
            <li class="nav-item me-0 me-lg-3">
              <a href="user-profile" class="nav-link" >
                <i class="fa-solid fa-user"></i> Account
              </a>
            </li>
          </c:if>
          
          <c:if test="${admin != null}">
            <li class="nav-item me-0 me-lg-3">
              <a href="admin-dashboard" class="nav-link" >
                <i class="fa-solid fa-user"></i> Dashboard
              </a>
            </li>
          </c:if>
          
        </ul>
        
        <c:if test="${profile == null && admin == null}">
          <div class="nav-button d-flex flex-column flex-lg-row">
            <a href="login" class="btn btn-outline-secondary me-0 me-lg-3 mb-3 mb-lg-0">Login</a>
            <a href="register" class="btn btn-primary mb-3 mb-lg-0">Register</a>
          </div>
        </c:if>
        
        <c:if test="${profile != null}">
          <div class="nav-button d-flex flex-column flex-lg-row">
             <a href="logout" class="btn btn-primary me-0 me-lg-3 mb-3 mb-lg-0">Logout</a>
          </div>
        </c:if>
        
        <c:if test="${admin != null}">
          <div class="nav-button d-flex flex-column flex-lg-row">
             <a href="adminLogout" class="btn btn-primary me-0 me-lg-3 mb-3 mb-lg-0">Logout</a>
          </div>
        </c:if>
        
      </div>
    </div>
  </nav>
</header>