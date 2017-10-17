<%-- 
    Document   : login
    Created on : 14/10/2016, 16:31:22
    Author     : isabella
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    
    <style>
        body{
            background-image:url('imagens/wpp3.jpg');
            background-repeat:repeat-x;
            margin-top: 5%;
        }
        #corpo{
            textalign: centred;
            width: 60%;
            background-color: white;
            padding: 50px;
            border: 1px;
            border-style: solid;
            border-color: black;
        }
        #camposenha{
            margin-left: 11px;
        }
        #p1{
            font-size: 150%;
            border-bottom: 6px solid #5AA157;;            
            background-color: #F2AB46;
            color:#FFFFFF;

        }
        span{
            color:red;
        }
        img{
            width:700px;
            height:228px;
        }
       
    </style>
    <body>
        <div class="container" id="corpo">
            <img src="imagens/banner.jpg" alt="descrição da imagem" /><br><br>
		<p id="p1">Por favor digite o seu nome de usuário e sua senha para conectar-se.</p>
            <div class ="form-inline form-group" >
                 <span><c:out value="${erroLogin}"/></span><br>
		<form action="autenticar" method="post">
                    <label><p>Usuário.:</label> <input class="form-control" type="text" name="login" ><br><br>
                    <label id="camposenha">Senha.</label>:<input class="form-control" type="password" name="senha"/><br><br>                
                    <input type="submit" value="Enviar"/>
                </form>
            </div>
        </div>
    </body>
</html>
