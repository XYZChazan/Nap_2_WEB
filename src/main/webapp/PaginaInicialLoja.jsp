<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page import="java.util.ArrayList, br.com.ufra.Model.LivroModel"%>
<html>
    <head>
    <meta charset="utf-8">
    <title>Loja</title>
    <link rel="stylesheet" href="/src/main/webapp/CSS/style.css">
</head>
<body>

    <nav class="nav-principal">
      <ul style="display: flex; list-style-type: none;">
        <li><a class="nav-link" href="#">Pagina inicial</a></li>
        <li><a class="nav-link" href="/Nap_2/carrinho-compras">Carrinho</a></li>
      </ul>
    </nav>

    <div class="card-container">
        <c:forEach  var="linha" items="${listar}" >
              <div class="card">
                <img src="${linha.linkImagem}" alt="Imagem do produto">
                <h2>${linha.nomeLivro}</h2>
                <p class="preco">R$ ${linha.preco}</p>
                <p class="detalhe">${linha.detalhe}</p>
                <div class="botoes">
                <form action="/Nap_2/carrinho-servlet" method="post">
                  <input type="hidden" name="id" value="${linha.id}">
                  <button type="submit" name="tipoOperacao" value="adicionar">Adicionar ao carrinho</button>
                </form>
                <form action="/Nap_2/detalhe-servlet" method="get">
                  <input type="hidden" name="id" value="${linha.id}">
                  <button type="submit">Detalhar</button>
                </form>
                </div>
              </div>
        </c:forEach>
    </div>

</body>
</html>