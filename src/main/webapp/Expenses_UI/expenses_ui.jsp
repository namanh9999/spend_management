<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="java.util.List"%>
<%@page import="model.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Expenses Form</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
</head>
<%
String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath();
%>
<body>
	<jsp:include page="../headers/Header_Only_Logo.jsp"></jsp:include>
	<form action="<%=url%>/InputProcessor" method="get">
		<input type="hidden" name="action" value="addValue">
		<div class="container form-outline">
			<label class="form-label" for="textAreaExample">Category</label>
			<div>
				<select name="category" class="form-select"
					aria-label="Default select example">
					<%
					List<Category> list = (List) session.getAttribute("listCategory");
					for (Category cate : list) {
					%>
					<option value="<%=cate.getId()%>"><%=cate.getName()%></option>
					<%
					}
					%>
				</select> <label class="form-label" for="textAreaExample">Amount</label> <input
					class="form-control" name="amount" type="number"
					placeholder="Amount">
			</div>

			<label class="form-label" for="textAreaExample">Payment
				Method</label>
			<div class="input-group mb-2">
				<select name="paymentMethod" class="form-select"
					aria-label="Select option">
					<option value="Cash">Cash</option>
					<option value="Credit Card">Credit Card</option>
					<option value="Debit Card">Debit Card</option>
					<option value="Bank Transfer">Bank Transfer</option>
				</select> <input type="text" name="tag" class="form-control"
					placeholder="Tag" aria-label="Server">
			</div>
			<label class="form-label" for="textAreaExample">Describe</label>
			<textarea name="describe" class="form-control" id="textAreaExample"
				rows="4"></textarea>
		</div>

			<label class="form-label" for="textAreaExample">
				</label>
		<div align="center">
			<button type="submit" class="btn btn-primary">Add</button>
		</div>
	</form>
	<jsp:include page="../footers/Footer_UI.jsp"></jsp:include>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
</body>
</html>