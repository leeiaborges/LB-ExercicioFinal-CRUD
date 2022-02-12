<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Carros</title>
<link rel="stylesheet"
	href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <h1 class="title">Lista de Carros</h1>
    <hr>
	<form action="Servlet" method="post">
		<button class="btn btn-primary"type="submit" name="option" value="insertForm">Cadastrar Carro</button>
	</form>
	<br>
	
	<h5>Total de Carros: ${listCarro.size()}</h5>
	<h5>Total de Carros com IPVA: </h5>
	
	<br>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Modelo</th>
					<th scope="col">Ano</th>
					<th scope="col">IPVA</th>
					<th scope="col">Ações</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="carro" items="${listCarro}">
					<tr>
						<form action="Servlet" method="post">
							<td>
								<c:out value="${carro.id}"/>
								<input type="hidden" name="id" value="${carro.id}"/>
							</td>
							<td><c:out value="${carro.modelo}"/></td>
							<td><c:out value="${carro.ano}"/></td>
							  
							<td><c:out value=""/></td>
							  
							<td><button class="btn btn-primary" type="submit" name="option" value="delete" style="margin-right: 10px;" >Deletar</button>
                                <button class="btn btn-primary" type="submit" name="option" value="updateForm">Atualizar</button>
                            </td>
						</form>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</div>
</body>
</html>