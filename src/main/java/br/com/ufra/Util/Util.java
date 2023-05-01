package br.com.ufra.Util;

import br.com.ufra.Model.CarrinhoModel;
import br.com.ufra.Model.LivroModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;

public class Util {
    ArrayList<LivroModel> livros;

    public Util(){
        LivroModel livros = new LivroModel();
        this.livros = livros.geraLista();
    }

    public ArrayList<CarrinhoModel> parseCoookieParaModel(HttpServletRequest req, HttpServletResponse resp) throws JsonProcessingException, UnsupportedEncodingException {
        String valorCookie = Arrays.stream(req.getCookies()).filter(cookie -> "Carrinho".equals(cookie.getName())).findFirst().map(Cookie::getValue).orElse(null);

        ObjectMapper mapeador = new ObjectMapper();
        ArrayList<CarrinhoModel> carrinho = null;
        if(valorCookie != null){
            carrinho = mapeador.readValue(URLDecoder.decode(valorCookie, "UTF-8"), new TypeReference<ArrayList<CarrinhoModel>>() { });
            System.out.println("carrinho do cookie " + carrinho);

        }else{
            carrinho = new ArrayList<CarrinhoModel>();
            resp.addCookie(new Cookie("Carrinho", URLEncoder.encode( mapeador.writeValueAsString(carrinho), "UTF-8" )));
        }

        return carrinho;
    }
}
