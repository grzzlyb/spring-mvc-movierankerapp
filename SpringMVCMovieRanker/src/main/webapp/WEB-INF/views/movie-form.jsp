<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Movie</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-movie-style.css">
</head>
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Movie Ranker</h2>
		</div>

		<div id="container">
			<h3>Save Movie</h3>

			<form:form action="saveMovie" modelAttribute="movie" method="POST">
				<form:hidden path="id" />
				<table>
					<tbody>
						<tr>
							<td><label>Movie name:</label></td>
							<td><form:input path="movieName" />
						</tr>
						<tr>
							<td><label>Genre:</label></td>
							<td><form:input path="genre" />
						</tr>
						<tr>
							<td><label>Release Date:</label></td>
							<td><form:input path="releaseDate" />
						</tr>
						<tr>
							<td><label>Rating:</label></td>
							<td><form:input path="rating" />
						</tr>
						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Save" class="save" />
						</tr>
					</tbody>
				</table>
			</form:form>

			<div style=""></div>

			<p>
				<a href="${pageContext.request.contextPath}/movie/list">Back to
					list</a>
			</p>
		</div>
	</div>
</body>
</html>