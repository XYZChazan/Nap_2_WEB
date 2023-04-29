

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        String dataNascimento = request.getParameter("dataNascimento");
        String endereco = request.getParameter("endereco");
        String[] areasAtuacao = request.getParameterValues("areasAtuacao");
        
      
        Cookie cookieNome = new Cookie("nome", nome);
        cookieNome.setMaxAge(60*60); 
        response.addCookie(cookieNome);
        
        Cookie cookieTelefone = new Cookie("telefone", telefone);
        cookieTelefone.setMaxAge(60*60); 
        response.addCookie(cookieTelefone);
        
        Cookie cookieDataNascimento = new Cookie("dataNascimento", dataNascimento);
        cookieDataNascimento.setMaxAge(60*60); 
        response.addCookie(cookieDataNascimento);
        
        Cookie cookieEndereco = new Cookie("endereco", endereco);
        cookieEndereco.setMaxAge(60*60); 
        response.addCookie(cookieEndereco);
        
        if (areasAtuacao != null) {
            for (int i = 0; i < areasAtuacao.length; i++) {
                Cookie cookieArea = new Cookie("area"+i, areasAtuacao[i]);
                cookieArea.setMaxAge(60*60); 
                response.addCookie(cookieArea);
            }
        }
        
        // direciona para a página 4
        response.sendRedirect("paginaQuatroInscricao.jsp");
    }

}
