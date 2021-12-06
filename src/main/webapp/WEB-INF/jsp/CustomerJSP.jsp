<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>View Customers</title>

<style>
* {
	box-sizing: border-box;
}

#myInput {
	background-position: 10px 10px;
	background-repeat: no-repeat;
	width: 100%;
	font-size: 16px;
	padding: 12px 20px 12px 40px;
	border: 1px solid #ddd;
	margin-bottom: 12px;
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

.button {
	background-color: #4CAF50;
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}
</style>
</head>
<body>
	<th><input type="button" class="button"
		onclick="location.href='/customers/Countryfilter'" value="Filter"></th>

	<input type="text" id="myInput" onkeyup="filterByPhone()"
		placeholder="Search for Country Code" title="Type in a Country Code">

	<table id="myTable">
		<thead>
			<tr>

			</tr>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Phone</th>
				<th>Valid</th>
			</tr>
		</thead>
		<tbody>
			<%
			int i = 0;
			%>
			<c:forEach items="${customers}" var="customer">
				<tr>
					<td>${customer.id}</td>
					<td>${customer.name}</td>
					<td>${customer.phone}</td>
					<td>
						<%
						boolean valid = ((ArrayList<Boolean>) request.getAttribute("validatePhone")).get(i);
						out.print(valid);
						i++;
						%>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<script>
		function filterByPhone() {
			var input, filter, table, tr, td, i, txtValue;
			input = document.getElementById("myInput");
			filter = input.value.toUpperCase();
			table = document.getElementById("myTable");
			tr = table.getElementsByTagName("tr");
			for (i = 0; i < tr.length; i++) {
				td = tr[i].getElementsByTagName("td")[2];
				if (td) {
					txtValue = td.textContent || td.innerText;
					if (txtValue.toUpperCase().indexOf(filter) > -1) {
						tr[i].style.display = "";
					} else {
						tr[i].style.display = "none";
					}
				}
			}
		}
	</script>
</body>
</html>