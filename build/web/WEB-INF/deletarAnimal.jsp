<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
     <head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>deletar animal</title>
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
        <h1>Deletar Registro de Animal</h1><br><br>
            
            <form action="DeleteAnimal" method="post">
                    <div class ="form-inline form-group">
                        <p id="p1">Selecione o animal que deseja apagar:</p> <br>
                      
			<select name="nome">
                            <option>Selecione...</option>
                            <c:forEach items="${ListAnimais}" var="animal" >
                                <option value="${animal}">
                                    ${animal}
                                </option>
                            </c:forEach>
			</select>
                            <br><br>
                    <input type="submit" value="Confirmar"/>
		</div>
            </form>
    </div>
<body>
</html>	
