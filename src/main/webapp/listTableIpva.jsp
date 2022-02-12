<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de IPVA</title>
<link rel="stylesheet"
	href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1 class="title">Lista de IPVA's</h1>
    <hr>
	<form action="ServletIpva" method="post">
		<button class="btn btn-warning" type="submit" name="option" value="insertForm">Cadastrar IPVA</button>
	</form>
	
		<table class="table">
			<thead>
				<tr>
					<th>Id</th>
					<th>Ano</th>
					<th>Ações</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ipva" items="${listIpva}">
					<tr>
						<form action="ServletIpva" method="post">
							<td>
								<c:out value="${ipva.id}"/>
								<input type="hidden" name="id" value="${ipva.id}"/>
							</td>
							<td><c:out value="${ipva.ano}"/></td>
							<td><button class="btn btn-warning" type="submit" name="option" value="delete" style="margin-right: 10px;">Deletar</button>
							    <button class="btn btn-warning" type="submit" name="option" value="updateForm">Atualizar</button>
							</td>
						</form>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</div>
	
</body>
</html>