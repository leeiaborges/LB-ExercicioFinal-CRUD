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

<!-- STYLE DA PÁGINA  -->

<style>
    nav.navbar{
        background-color: #ffc107;
    }

    #navbar-brand{
        color: black;
    }

    .form{
        width: 40%;
        margin-top: 20px;
    }

    .container-form{
        display: flex;
        justify-content: center;
    }
    </style>
<!-- STYLE DA PÁGINA  -->


<body>

    <nav class="navbar navbar-expand-lg navbar-light">
        <div class="container-fluid">
            <a class="navbar-brand" id="navbar-brand" href="#">Raia Drogasil</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
                aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <a class="nav-link active" id="navbar-brand" aria-current="page" href="form.jsp">Carros</a>
                    <a class="nav-link active" id="navbar-brand" aria-current="page" href="">IPVA</a>
                </div>
            </div>
        </div>
    </nav>

    <div class="container">
        <div class="container-form">
            
            <div class="form">

                <h1 class="title">Cadastro de IPVA</h1>

	<form action="ServletIpva" method="post">
		<c:choose>
			<c:when test="${ipva == null }">
				<label class="form-label">Ano:</label><input class="form-control" type="text" name="ano" required/>
			     <br>
				<button class="btn btn-warning"  type="submit" name="option" value="insert" role="button">Salvar</button>
			</c:when>
			<c:otherwise>
				<input type="hidden" name="id" value="${ipva.id}"/>
				<label class="form-label">Ano:</label><input class="form-control" type="text" name="ano" value="${ipva.ano}" required/>
			    <br>
				<button class="btn btn-warning" type="submit" name="option" value="update">Atualizar</button>
			</c:otherwise>
		</c:choose>
	</form>
            </div>
        </div>
    </div>
    
</body>
</html>