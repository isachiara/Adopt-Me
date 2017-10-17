<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
     <head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>pagina de edição</title>
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

</style>
<body>
    <div class = "container" id="corpo">
        <h1>Editar Dados Pessoais:</h1><br><br>
            
            <form action="EditarPerfil" method="post">
                <div class ="container-fluid">
                    <div class ="form-inline form-group">
                        <p id="p1">Dados inicias:</p> <br>
			<label for="nome">Nome:</label>
			<input class="form-control" name="nome" maxlength = "70" type="text">
			<label for="sobrenome">Sobrenome:</label>
                        <input class="form-control" name="sobrenome" type="text"><br><br>
			<label for="sel1">Data de Nascimento:</label>
                        <input class ="form-control" name = "data_nascimento" type ="text">					
                    </div>			
                    
                    <div class="form-inline">
			<label for="genero">Gênero:</label>
                            <label class="radio-inline"><input type="radio" value = "F" name="genero">Feminino</label>
                            <label class="radio-inline"><input type="radio" value = "M" name="genero">Masculino</label>
                            <label class="radio-inline"><input type="radio" value = "O" name="genero">Outros</label>
                    </div><br>
					
                    <div class ="form-group form-inline">
                       <p id="p1">Endereço:</p> <br>
                            <label for="CEP">CEP:</label>
                            <input class="form-control" type="int" name="cep" title="Digite o CPF no formato xxxxx-xxx">        
                            <label for="cidade">Cidade:</label>
                            <input class="form-control" maxlength = "100" type="text" name="cidade">                       
                            <label for="estado">Estado:</label>
                            <input class="form-control" maxlength = "100" type="text" name="estado">	<br><br>					
                            <label for="bairro">Bairro:</label>
                            <input class="form-control" maxlength = "100" type="text" name="bairro">
                    </div>
				 
                    <div class ="form-inline form-group">
                        <p id="p1">Contato:</p> <br>			
                        <label for="telefone">Telefone:</label>
			<input class="form-control" maxlength="10" type="text" name="tel">						
                        <label for="celular">Celular:</label>
			<input class="form-control" maxlength="11" type="text" name="cel">
                    </div><br>
                    
                                      
                    <input type="submit" value="Confirmar"/>
		</div>
            </form>
    </div>
<body>
</html>	
