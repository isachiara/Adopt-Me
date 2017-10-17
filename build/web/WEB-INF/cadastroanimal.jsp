<%-- 
    Document   : cadastroanimal
    Created on : 19/10/2016, 19:12:34
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
        <title>Cadastro Animal</title>
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
        #p1{
            border-bottom: 6px solid #5AA157;;            
            background-color: #F2AB46;
            font-size: 150%;
            color:#FFFFFF;
           

        }  
        h1{
            color:#5AA157;
            font-weight: bold;
        }
</style>
    <body>
        <div class = "container" id="corpo">
            <h1>Cadastrar Animal:</h1><br><br>
            <form action="servletCadastroAnimal" method="post">
                <div class ="container-fluid">
                    <div class ="form-inline form-group">
                        <p id="p1">Dados inicias:</p> <br>
                        <label>Nome do animal:</label>
                        <input class="form-control" type="text" name="nomeAnimal"><br><br>
                        <label>Tipo:</label>
                         <select name="Tipo">
                            <option>Selecione..</option>
                            <option value="cachorro" required>Cachorro</option>
                            <option value="gato" required>Gato</option>
                            <option value="passsaro" required>Pássaro</option>
                            <option value="outro" required>Outro</option>
                          </select> 
                        <span>Observação: Em caso de "Outro" especificar em Caracteristicas.</span>
                        <br><br>
                        <label>Idade:</label>
                        <select name="idadeAnimal">
                            <option>Selecione..</option>
                            <option value="Filhote" required>Filhote</option>
                            <option value="Adulto" required>Adulto</option>
                            <option value="Idoso" required>Idoso</option>
                        </select> <br><br>

                        <label>Caracteristicas:</label><br> <!--fazer campo para o usuário escrever até 200 caracteres-->
                            <div id="cid_4" class="form-input-wide jf-required">
                                <textarea id="input_4" class="form-textarea validate[required]" name="describeAnimal" cols="40" rows="6"></textarea><br><br>
                            </div>
                        <label>Possui tratamento veterinário?</label><br>
                        <input class="form-control" type="radio" value="sim" name="tratamento">Sim<br>
                        <input class="form-control" type="radio" value="nao" name="tratamento">Não<br><br>

                        <input type="submit" value="Confirmar"/>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
