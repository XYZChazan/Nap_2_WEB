

import java.io.IOException;
import java.net.URLDecoder;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		response.setContentType("text/html");
        
        //pega os parametros dos formularios
		//pega os parametros dos formularios
        String nome = request.getParameter("nome");
        System.out.println("nome: " + nome); // Debugging
        
        String telefone = request.getParameter("telefone");
        System.out.println("telefone: " + telefone); // Debugging
        
        String dataNascimento = request.getParameter("dataNascimento");
        System.out.println("data de nascimento: " + dataNascimento); // Debugging
        
        String endereco = request.getParameter("endereco");
        System.out.println("endereço: " + endereco); // Debugging
        
        String[] areasAtuacao = request.getParameterValues("areasAtuacao");
        if (areasAtuacao != null) {
            for (String area : areasAtuacao) {
                System.out.println("área de atuação: " + area); // Debugging
            }
        }
        
        
        
        // Criação dos cookies com os valores dos parâmetros
        Cookie cookieNome = new Cookie("nome", nome != null ? nome : "");
        cookieNome.setMaxAge(60*60);
        
        Cookie cookieTelefone = new Cookie("telefone", telefone != null ? telefone : "");
        cookieTelefone.setMaxAge(60*60);
        
        Cookie cookieDataNascimento = new Cookie("dataNascimento", dataNascimento != null ? dataNascimento : "");
        cookieDataNascimento.setMaxAge(60*60);
        
        Cookie cookieEndereco = new Cookie("endereco", endereco != null ? endereco : "");
        cookieEndereco.setMaxAge(60*60);
        
        
        
        // Adiciona os cookies à resposta
        response.addCookie(cookieNome);
        response.addCookie(cookieTelefone);
        response.addCookie(cookieDataNascimento);
        response.addCookie(cookieEndereco);
        if (cookieNome != null && cookieNome != null) {
        	response.sendRedirect("paginaDoisInscricao.html");
        }
        // direciona para a página 4
        if (nome != null && telefone != null && dataNascimento != null && endereco != null) {
        response.sendRedirect("paginaQuatroInscricao.jsp");
        }
}

}
