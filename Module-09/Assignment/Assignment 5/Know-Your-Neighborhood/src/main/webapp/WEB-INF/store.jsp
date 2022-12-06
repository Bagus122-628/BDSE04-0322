<%@ include file="jsp-tags.jsp" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Know Your Neighborhood</title>
  </head>
  <body>
    <a href="<%= request.getContextPath() %>/addStore">Add Store</a>

    <table border="1" style="margin-top: 20px">
      <tr>
        <th>Store Name</th>
        <th>Phone Number</th>
        <th>Localities</th>
        <th>Action</th>
      </tr>

      <c:forEach items="${stores}" var="store">
        <tr>
          <td>${store.name}</td>
          <td>${store.phone_number}</td>
          <td>${store.localities}</td>
          <td>
            <a
              href="<%= request.getContextPath() %>/editStore?id=${store.id_store}"
              >Edit Store</a
            >
            <a
              href="<%= request.getContextPath() %>/deleteStore?id=${store.id_store}"
              >Delete Store</a
            >
          </td>
        </tr>
      </c:forEach>

      <c:if test="${stores.isEmpty()}">
        <tr>
          <td colspan="4" style="text-align: center">No stores</td>
        </tr>
      </c:if>
    </table>
  </body>
</html>
