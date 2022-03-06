package br.fiap.servlet;

import static java.lang.Integer.parseInt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.dao.ServicoDAO;

/**
 * Servlet implementation class pesquisarServicos
 */
@WebServlet("/pesquisarServico")
public class pesquisarServico extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id_servico = parseInt(request.getParameter("id_servico"));

		ServicoDAO dao = new ServicoDAO();
		PrintWriter out = response.getWriter();

		if (dao.pesquisar(id_servico)) {
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
					+ "<h1 class=\"titulo-pagina\">Serviço possui cadastro !</h1>"
					+ "<div class=\"centralizando\">"
					+ "<p class=\"texto-box\">"
					+ "<a href='index-gerenciamento.html' class='link-container'>Voltar</a>"
					+ "</p>"
					+ "</div>"
					+ "</div>"
					+ "</main>"
					);
		} else {
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
					+ "<h1 class=\"titulo-pagina\">Serviço não possui cadastro !</h1>"
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

}
