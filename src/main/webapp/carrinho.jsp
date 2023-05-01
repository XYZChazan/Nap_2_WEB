<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.ArrayList, br.com.ufra.Model.LivroModel"%>
<html>
    <head>
    <meta charset="utf-8">
    <title>Loja</title>
    <link rel="stylesheet" href="/src/main/webapp/CSS/style2.css">
    <link rel="stylesheet" href="/src/main/webapp/CSS/style.css">
</head>
<body>

    <nav class="nav-principal">
      <ul style="display: flex; list-style-type: none;">
        <li><a class="nav-link" href="/Nap_2/carrinho-servlet"">Pagina inicial</a></li>
        <li><a class="nav-link" href="#">Carrinho</a></li>
      </ul>
    </nav>

    <c:forEach var="item" items="${carrinho}">
        <div class="cart-item">
              <div class="item-image">

              </div>
              <div class="item-info">
                <h3 class="item-name">${item.nomeLivro}</h3>
                <p class="item-price">Preço unitário: R$ ${item.preco}</p>
                <c:set var="subtotal" value="${item.preco * item.quantidade}" />
                <p class="item-price">Subtotal: R$ <fmt:formatNumber value="${subtotal}" /></p>
                <div class="item-quantity">
                  <label for="quantity">Quantidade:</label>
                  <input type="number" name="quantity" id="quantity" value="${item.quantidade}" readonly>
                </div>
              </div>
              <form action="/Nap_2/carrinho-compras" method="post">
                <div class="item-remove">
                   <input type="hidden" name="id" value="${item.id}">
                   <button type="submit">Remover</button>
                </div>
              </form>
            </div>

    </c:forEach>




</body>
</html>