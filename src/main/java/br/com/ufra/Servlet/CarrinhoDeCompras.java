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


@WebServlet(name = "carrinhoDeComprasServlet", value = "/carrinho-compras")
public class CarrinhoDeCompras extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<LivroModel> livros;
    Util util = new Util();
    ObjectMapper mapeador = new ObjectMapper();

    @Override
    public void init() throws ServletException {
        LivroModel livros = new LivroModel();
        this.livros = livros.geraLista();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<CarrinhoModel> carrinho = util.parseCoookieParaModel(req,resp);

        try {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/src/main/webapp/carrinho.jsp");
            req.setAttribute("carrinho", carrinho);
            dispatcher.forward(req, resp);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int reqId = Integer.valueOf(req.getParameter("id"));
        ArrayList<CarrinhoModel> carrinho = util.parseCoookieParaModel(req,resp);
        CarrinhoModel item = carrinho.stream().filter(carrinhoModel -> carrinhoModel.getId() == reqId).findFirst().orElse(null);

        if(item != null){
            item.setQuantidade(item.getQuantidade() - 1);
            carrinho.remove(item);
            if(item.getQuantidade() > 0){
                carrinho.add(item);
            }else{
                carrinho.remove(item);

            }
            resp.addCookie(new Cookie("Carrinho", URLEncoder.encode( mapeador.writeValueAsString(carrinho), "UTF-8" )));
        }
        resp.sendRedirect("/carrinho-compras");
    }
}
