<%-- 
    Document   : listaAdocao
    Created on : 23/10/2016, 15:44:45
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
        <title>Lista</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <style>    
     body{
            background-image:url('imagens/wpp3.jpg');
            background-repeat:repeat-x;
            margin-top: 2%;
            margin-bottom: 2%;
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
        #elemento{
            color: black;

        }
        #tipo{
            font-size:20px;
            font-weight: bold;
            padding-left:10px;
            width: 100%;
            border-bottom: 6px solid #5AA157;;            
            background-color: #F2AB46;
            color:#FFFFFF;
        }
        h1{
            color:#5AA157;
            font-weight: bold;
        }
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        th, td {
            padding: 5px;
            text-align: left;    
        }
        span{
            color: red;
        }
</style>
    <body>
        <div class="container" id="corpo">
            <h1>Lista de Animais para Adoção:</h1><br><br>
            <div id="lista">
                <p id="tipo">Lista de ${tipo}s:</p>
                
                <span><c:out value="${ListaVazia}"/></span><br><br>
                
                <c:forEach items="${animais}" var="animal">
                    <table>
                    
                    <tr>
                        <th>Nome: </th>
                        <td>${animal.nome}</td>
                    </tr>
                    <tr>
                        <th>Idade: </th>
                        <td>${animal.idade}</td>
                    </tr>
                    
                    <tr>
                        <th>Caracteristcas: </th>
                        <td>${animal.caract}</td>
                    </tr>
                    <tr>
                        <th>Possui tratamento veterinário: </th>
                        <td>${animal.tratamento}</td>
                    </tr>
                    <tr>
                        <th>Email para contato: </th>
                        <td>${animal.dono}</td>
                    </tr>
                    
                    </table>
                    <br>
                </c:forEach>
                
                    <a href="perfil">Voltar</a>

                
            </div>
        </div>   
    </body>
</html>
