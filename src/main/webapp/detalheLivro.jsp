<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        <li><a class="nav-link" href="/Nap_2/carrinho-servlet">Pagina inicial</a></li>
        <li><a class="nav-link" href="/Nap_2/carrinho-compras">Carrinho</a></li>
      </ul>
    </nav>


<div class="livro-container">
    <img src="${livro.linkImagem}" alt="Imagem do produto" style="height: 370px">
    <div class="livro-info">
        <h2 class="titulo">${livro.nomeLivro}</h2>
         <p class="precoLivro">R$ ${livro.preco}</p>
         <p>${livro.detalhe}</p>
         <p>${livro.marca}</p>
         <p>${livro.asin}</p>
         <p>${livro.edicao}</p>
         <p>${livro.idioma}</p>
         <p>${livro.numeroPagina} paginas</p>
         <p>${livro.isbnTen}</p>
         <p>${livro.isbnThirteen}</p>
         <p>${livro.dimensao}</p>
         <form action="/Nap_2/detalhe-servlet" method="post">
            <input type="hidden" name="id" value="${livro.id}">
             <button type="submit">Adicionar ao carrinho</button>
         </form>
    </div>
</div>





</body>
</html>