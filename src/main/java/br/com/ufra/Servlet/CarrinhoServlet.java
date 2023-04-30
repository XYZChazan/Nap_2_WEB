package br.com.ufra.Servlet;

import br.com.ufra.Model.CarrinhoModel;
import br.com.ufra.Model.LivroModel;
import br.com.ufra.Util.Util;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;


@WebServlet(name = "carrinhoServlet", value = "/carrinho-servlet")
public class CarrinhoServlet extends HttpServlet {

    ArrayList<LivroModel> livros;
    ArrayList<CarrinhoModel> carrinho;
    Util util = new Util();

    @Override
    public void init() throws ServletException {
        LivroModel livros = new LivroModel();
        this.livros = livros.geraLista();
        this.carrinho = new ArrayList<CarrinhoModel>();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/src/main/webapp/PaginaInicialLoja.jsp");
            request.setAttribute("listar", this.livros);
            dispatcher.forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operacao = req.getParameter("tipoOperacao");
        System.out.println(operacao);
        int reqId = Integer.valueOf(req.getParameter("id"));
        adicionaNoCarrinho(req,resp,reqId);
        doGet(req,resp);
    }

    public void adicionaNoCarrinho(HttpServletRequest req, HttpServletResponse resp, int reqId) throws UnsupportedEncodingException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<CarrinhoModel> carrinho = util.parseCoookieParaModel(req, resp);
        LivroModel livro = this.livros.stream().filter(livroModel -> livroModel.getId() == reqId).findFirst().orElse(null);
        CarrinhoModel item = carrinho.stream().filter(carrinhoModel -> carrinhoModel.getId() == reqId).findFirst().orElse(null);
        if(item != null) {
            item.setQuantidade(item.getQuantidade() + 1);
            carrinho.remove(item);
            carrinho.add(item);
            resp.addCookie(new Cookie("Carrinho", URLEncoder.encode( mapper.writeValueAsString(carrinho), "UTF-8" )));
        }else {
            carrinho.add(new CarrinhoModel(livro.getId(), livro.getNomeLivro(), livro.getPreco(), 1));
            resp.addCookie(new Cookie("Carrinho", URLEncoder.encode( mapper.writeValueAsString(carrinho), "UTF-8" )));
        }
        System.out.println(this.carrinho);
    }
}
