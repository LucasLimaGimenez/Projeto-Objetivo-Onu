package br.fiap.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.dao.ServicoDAO;
import br.fiap.entidades.Servico;

/**
 * Servlet implementation class relatorioServico
 */
@WebServlet("/relatorioServico")
public class relatorioServico extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServicoDAO dao = new ServicoDAO();
		List<Servico> lista = dao.listar();
		
		request.setAttribute("lista", lista);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("relatorioServico.jsp");
		dispatcher.forward(request, response);
	}

}
