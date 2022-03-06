package br.fiap.servlet;

import static java.lang.Integer.parseInt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.dao.ClienteDAO;
import br.fiap.entidades.Cliente;

/**
 * Servlet implementation class alterarCliente
 */
@WebServlet("/alterarCliente")
public class alterarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id_cliente = parseInt(request.getParameter("id_cliente"));
		int id_empresa = parseInt(request.getParameter("id_empresa"));
		String nm_cliente = request.getParameter("nm_cliente");
		String cnpj = request.getParameter("cnpj");
		String endereco = request.getParameter("endereco");
		String telefone = request.getParameter("telefone");
		
		ClienteDAO dao = new ClienteDAO();
		dao.alterar(new Cliente(id_cliente, id_empresa, nm_cliente, cnpj,endereco, telefone));
		
		PrintWriter out = response.getWriter();
		out.println("<html>"
				+ "<head>"
				+ "<title>Global Solution - The Excluded Four</title>"
				+ "<link rel=\'stylesheet\' type=\'text/css\' href=\'css/style.css'>"
				+ "</head>"
				+ "<body>"
				+ "<header class='cabecalho'>"
				+ "<div class='ajusta-cabecalho'>"
				+ "<div class='logo'>"
				+ "<a href='index.html'><img src='images/logo.png' alt=''></a>"			   
			    +"</div>"
				+"</div>"
				+ "</header>"
				+ "<main class='menu-principal'>"
				+ "<div id='section-cadastrar'>"
				+ "<h1 class=\"titulo-pagina\">Dados alterados com sucesso na base de dados !</h1>"
				+ "<div class=\"centralizando\">"
				+ "<p class=\"texto-box\">"
				+ "<a href='index-gerenciamento.html' class='link-container'>Voltar</a>"
				+ "</p>"
				+ "</div>"
				+ "</div>"
				+ "</main>"
				);
	}

}
