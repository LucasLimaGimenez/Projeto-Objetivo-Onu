package br.fiap.servlet;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.dao.FuncionarioDAO;
import br.fiap.entidades.Funcionario;

/**
 * Servlet implementation class alterarFuncionario
 */
@WebServlet("/alterarFuncionario")
public class alterarFuncionario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id_funcionario = parseInt(request.getParameter("id_funcionario"));
		int id_empresa = parseInt(request.getParameter("id_empresa"));
		String nm_funcionario = request.getParameter("nm_funcionario");
		String rg = request.getParameter("rg");
		String endereco = request.getParameter("endereco");
		String telefone = request.getParameter("telefone");
		double salario = parseDouble(request.getParameter("salario"));
		
		FuncionarioDAO dao = new FuncionarioDAO();
		dao.alterar(new Funcionario(id_funcionario, id_empresa, nm_funcionario,rg,endereco, telefone, salario));
		
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