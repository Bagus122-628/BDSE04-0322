<%@ include file="jsp-tags.jsp" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Know Your Neighborhood</title>
    <style type="text/css">
      label,
      input {
        display: block;
      }
      .error {
        color: red;
      }
    </style>
  </head>
  <body>
    <form:form action="loginUser" modelAttribute="user">
      <c:if test="${param.error != null}">
        <p class="error">Invalid username or password</p>
      </c:if>
      <label>Username</label>
      <form:input type="text" path="username" />

      <label>Password</label>
      <form:input type="password" path="password" />

      <input
        type="hidden"
        name="${_csrf.parameterName}"
        value="${_csrf.token}"
      />

      <button type="submit">Login</button>
    </form:form>
  </body>
</html>
