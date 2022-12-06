<%@ include file="jsp-tags.jsp" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Know Your Neighborhood</title>
  </head>
  <body>
    <a href="<%= request.getContextPath() %>/stores">View Stores</a>

    <p>${message}</p>

    <table border="1" style="margin-top: 20px">
      <tr>
        <th>Store Name</th>
        <th>Phone Number</th>
        <th>Localities</th>
      </tr>

      <c:forEach items="${stores}" var="store">
        <tr>
          <td>${store.name}</td>
          <td>${store.phone_number}</td>
          <td>${store.localities}</td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
