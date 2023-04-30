<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Página 4 - Cadastro Realizado</title>
</head>
<body>

	<h1>Página 4 - Inscrição</h1>
    <h2>Dados Pessoais</h2>
    <p><b>Nome:</b> <%= request.getParameter("nome") %></p>
    <p><b>Telefone:</b> <%= request.getParameter("telefone") %></p>
    <p><b>Data de Nascimento:</b> <%= request.getParameter("dataNascimento") %></p>
    <p><b>Endereço:</b> <%= request.getParameter("endereco") %></p>
    <h2>Áreas de Atuação</h2>
    <ul>
      <% String[] areasAtuacao = request.getParameterValues("areasAtuacao");
         if (areasAtuacao != null) {
           for (String area : areasAtuacao) { %>
             <li><%= area %></li>
           <% }
         } %>
    </ul>

</body>
</html>