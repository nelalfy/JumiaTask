<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.TreeMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<html>
<head>
<title>Filtering Customers</title>

<style>
* {
  box-sizing: border-box;
}


#myTable {
  border-collapse: collapse;
  width: 100%;
  border: 1px solid #ddd;
  font-size: 18px;
}

#myTable th, #myTable td {
  text-align: left;
  padding: 12px;
}

#myTable tr {
  border-bottom: 1px solid #ddd;
}

#myTable tr.header, #myTable tr:hover {
  background-color: #f1f1f1;
}

</style>

</head>
<body>
	<table id="myTable">
		<c:forEach var="entry" items="${customerFilter}">
			<tr>
				<td>Country Code: <c:out value="${entry.key}" /></td>
				<c:forEach items="${entry.value}" var="customer">
					<tr>
						<td><c:out value="${customer.id}" /></td>
						<td><c:out value="${customer.name}" /></td>
						<td><c:out value="${customer.phone}" /></td>
					</tr>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>

</body>
</html>