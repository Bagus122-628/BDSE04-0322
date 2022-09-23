<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../components/header.jsp" %>
<link href="css/send-bulk-email.css" rel="stylesheet" />
<link>
</head>
<body>
	<!-- The sidebar -->
    <div class="sidebar">
      <div class="header">ABC Jobs Community Portal</div>
      <ul>
        <li>
          <a href="admin-dashboard"> <i class="fa-solid fa-gauge-high"></i> Dashboard</a>
        </li>
        <li>
          <a href="<%= request.getContextPath() %>"> <i class="fa-solid fa-house"></i> Home</a>
        </li>
        <li>
          <a href="adminLogout"> <i class="fa-solid fa-right-from-bracket"></i> Logout</a>
        </li>
      </ul>
    </div>

    <!-- Page content -->
    <div class="content">
      <div class="content-header">
        <div class="admin-text-header pt-2">
          <h3 class="fw-semibold">Administration System</h3>
        </div>
      </div>

      <div class="content-edit">
        <form:form action="sendBulkEmail" method="post" modelAttribute="bulkEmail" id="form">
          <div class="row justify-content-center">
            <div class="col-xxl-5 col-xl-6 col-lg-8 col-md-12">
              <div class="d-flex flex-column regis-wrapper">
                <div class="heading">
                  <h2>Send Bulk Email</h2>
                </div>

                <!-- hidden -->
                <div class="form-group">
                  <form:hidden path="id_bulk_email" class="form-control" />
                </div>

                <!-- Subject -->
                <div class="form-group">
                  <label for="subject">Subject</label>
                  <form:input path="subject" type="text"  class="form-control" />
                </div>

                <!-- Body -->
                <div class="form-group">
                  <label for="content">Content</label>
                  <form:textarea path="content" class="form-control" />
                </div>

                <button type="submit" class="btn btn-primary mt-4">Send Email</button>
              </div>
            </div>
          </div>
        </form:form>
      </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>