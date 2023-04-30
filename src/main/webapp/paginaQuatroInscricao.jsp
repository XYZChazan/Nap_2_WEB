<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Página 4 - Cadastro Concluida</title>
</head>
<body>

	<h1>Página 4 - Inscrição Concluida</h1>
    <h2>Dados Pessoais</h2>
    <% 
        Cookie[] cookies = request.getCookies();
        String nome = null, telefone = null, dataNascimento = null, endereco = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("nome")) {
                nome = cookie.getValue();
            }
            else if (cookie.getName().equals("telefone")) {
                telefone = cookie.getValue();
            }
            else if (cookie.getName().equals("dataNascimento")) {
                dataNascimento = cookie.getValue();
            }
            else if (cookie.getName().equals("endereco")) {
                endereco = cookie.getValue();
            }
        }
    %>
    <p><b>Nome:</b> <%= nome %></p>
    <p><b>Telefone:</b> <%= telefone %></p>
    <p><b>Data de Nascimento:</b> <%= dataNascimento %></p>
    <p><b>Endereço:</b> <%= endereco %></p>
    <h2>Áreas de Atuação</h2>
    <ul>
    <% 
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("AreasAtuacao")) {
                String[] values = cookie.getValue().split(",");
                for (String value : values) {
    %>
                    <li><%= value %></li>
    <%          }
            }
        }
    %>
</ul>

</body>
</html>