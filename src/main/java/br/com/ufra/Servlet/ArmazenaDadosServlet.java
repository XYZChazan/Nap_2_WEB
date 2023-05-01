package br.com.ufra.Servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ArmazenaDadosServlet")
public class ArmazenaDadosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ArmazenaDadosServlet() {
        super();
    }

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
        
        //pega os parametros dos formularios
		
		Cookie cookieNome = null;
        
        Cookie cookieTelefone = null;
        
        Cookie cookieDataNascimento = null;
        
        Cookie cookieEndereco = null;
		
        String nome = request.getParameter("nome");
        System.out.println("nome: " + nome); 
        
        String telefone = request.getParameter("telefone");
        System.out.println("telefone: " + telefone); 
        
        if(nome != null && telefone != null) {
        	
	        cookieNome = new Cookie("nome", nome);
	        
	        cookieNome.setMaxAge(60*60);
	        
	        cookieTelefone = new Cookie("telefone", telefone );
	        
	        cookieTelefone.setMaxAge(60*60);
	        
	        response.addCookie(cookieNome);
	        response.addCookie(cookieTelefone);
	        
	        response.sendRedirect("paginaDoisInscricao.html");
        
        }
        
        String dataNascimento = request.getParameter("dataNascimento");
        System.out.println("data de nascimento: " + dataNascimento); // Debugging
        
        String endereco = request.getParameter("endereco");
        System.out.println("endereço: " + endereco); // Debugging
        
        if(dataNascimento != null && endereco != null) {
        	
        	cookieDataNascimento = new Cookie("dataNascimento", dataNascimento);
            
        	cookieDataNascimento.setMaxAge(60*60);
            
            cookieEndereco = new Cookie("endereco", endereco);
            
            cookieEndereco.setMaxAge(60*60);
            
            response.addCookie(cookieDataNascimento);
            response.addCookie(cookieEndereco);
            
            response.sendRedirect("paginaTresInscricao.html");
               
        }
        
        Cookie[] cookies = null;
        String[] areasSelecionadas = request.getParameterValues("areasAtuacao");
        if (areasSelecionadas != null) {
            cookies = new Cookie[areasSelecionadas.length];
            for (int i = 0; i < areasSelecionadas.length; i++) {
                cookies[i] = new Cookie("AreasAtuacao", areasSelecionadas[i]);
                response.addCookie(cookies[i]);
                System.out.println("areasSelecionadas: " + areasSelecionadas); // Debugging
            }
            
         // direciona para a página 4
            
            response.sendRedirect("paginaQuatroInscricao.jsp");
            
        }
        
        
        
}

}
