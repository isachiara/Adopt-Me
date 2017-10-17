<%-- 
    Document   : perfil
    Created on : 19/10/2016, 19:11:02
    Author     : isabella
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>perfil</title>
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
        #perfil{
            width: 100%;
        }
        h1{
            color:#5AA157;
            font-weight: bold;
        }
        p{
            font-size: 150%;
            border-bottom: 6px solid #5AA157;;            
            background-color: #F2AB46;
            color:#FFFFFF;

        }
        a{
           margin-right: 20px;
        }
    </style>
    <body>
        <div class="container" id="corpo">
            <h1>Bem Vindo ao seu Perfil:</h1><br><br>

            <div class = "container" id="perfil">
                <p>Informações de usuário:</p><br>
                    Nome: ${requestScope.pessoa.getNome()}<br>
                    Sobrenome: ${requestScope.pessoa.getSobrenome()} <br>
                    Sexo: ${requestScope.pessoa.getGenero()} <br>
                    Data de nascimento: ${requestScope.pessoa.getDate()}<br>

                    <br><p>Endereço:</p>
                    CEP: ${requestScope.endereco.getCep()}<br>
                    Estado: ${requestScope.endereco.getEstado()} <br> 
                    Cidade: ${requestScope.endereco.getCidade()} <br>
                    Bairro: ${requestScope.endereco.getBairro()} <br>

                    <br><p>Contato:</p>
                    Telefone: ${requestScope.pessoa.getTelefone()} <br>
                    Celular: ${requestScope.pessoa.getCelular()}<br>
                    
                    <div>
                    <br><p>Sua lista de animais:</p> <!-- tabela Java -->
                    <c:forEach items="${animal}" var="item">
                        ${item.nome}<br>
                    </c:forEach>
                    </div>
                </div>

                <div class="container">
                    <br><br>
                    <a href="Lista" action="get">Lista Adoção</a>
                    <a href="cadastro_de_animais" action="get">Cadastrar Animal</a>
                    <a href="EditarPerfil" action="get">Editar dados pessoais</a>
                    <a href="DeleteAnimal" action="get">Deletar animal</a>
                    <a href="ExcluirPerfil" action="get">Excluir Perfil</a> 
                    <a href="Logout" >Sair</a>
                    
                </div>
            
            </div>
        </body>
</html>
