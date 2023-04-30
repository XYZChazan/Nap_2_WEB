package br.com.ufra.Servlet;


import br.com.ufra.Model.CarrinhoModel;
import br.com.ufra.Model.LivroModel;
import br.com.ufra.Util.Util;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

@WebServlet(name = "detalheServlet", value = "/detalhe-servlet")
public class DetalheServlet extends HttpServlet {

    ArrayList<LivroModel> livros;
    Util util = new Util();

    @Override
    public void init() throws ServletException {
        LivroModel livros = new LivroModel();
        this.livros = livros.geraLista();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int reqId = Integer.valueOf(req.getParameter("id"));
        LivroModel livro = this.livros.stream().filter(livroModel -> livroModel.getId() == reqId).findFirst().orElse(null);

        try {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/src/main/webapp/detalheLivro.jsp");
            req.setAttribute("livro", livro);
            dispatcher.forward(req, resp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapeador = new ObjectMapper();
        int reqId = Integer.valueOf(req.getParameter("id"));
        ArrayList<CarrinhoModel> carrinho = util.parseCoookieParaModel(req, resp);
        LivroModel livro = this.livros.stream().filter(livroModel -> livroModel.getId() == reqId).findFirst().orElse(null);
        CarrinhoModel item = carrinho.stream().filter(carrinhoModel -> carrinhoModel.getId() == reqId).findFirst().orElse(null);

        if(item != null){
            item.setQuantidade(item.getQuantidade() + 1);
            carrinho.remove(item);
            carrinho.add(item);
            resp.addCookie(new Cookie("Carrinho", URLEncoder.encode( mapeador.writeValueAsString(carrinho), "UTF-8" )));
        }else{
            carrinho.add(new CarrinhoModel(livro.getId(),livro.getNomeLivro(), livro.getPreco(), 1));
            resp.addCookie(new Cookie("Carrinho", URLEncoder.encode( mapeador.writeValueAsString(carrinho), "UTF-8" )));
        }

        doGet(req,resp);

    }
}
