package br.fiap.servlet;

import static java.lang.Integer.parseInt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.dao.EmpresaDAO;
import br.fiap.entidades.Empresa;

/**
 * Servlet implementation class alterarEmpresa
 */
@WebServlet("/alterarEmpresa")
public class alterarEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id_empresa = parseInt(request.getParameter("id_empresa"));
		String nm_empresa = request.getParameter("nm_empresa");
		String cnpj = request.getParameter("cnpj");
		String endereco = request.getParameter("endereco");
		String telefone = request.getParameter("telefone");
		
		EmpresaDAO dao = new EmpresaDAO();
		dao.alterar(new Empresa(id_empresa, nm_empresa, cnpj, endereco, telefone));
		
		PrintWriter out = response.getWriter();
		out.println("<html>"
				+ "<head>"
				+ "<title>Global Solution - The Excluded Four</title>"
				+ "<link rel='stylesheet' type='text/css' href='css/style.css'>"
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
				+ "<h1 class='titulo-pagina'>Dados alterados com sucesso na base de dados !</h1>"
				+ "<div class='centralizando'>"
				+ "<p class='texto-box'>"
				+ "<a href='index-gerenciamento.html' class='link-container'>Voltar</a>"
				+ "</p>"
				+ "</div>"
				+ "</div>"
				+ "</main>"
				);
			
	}

}
