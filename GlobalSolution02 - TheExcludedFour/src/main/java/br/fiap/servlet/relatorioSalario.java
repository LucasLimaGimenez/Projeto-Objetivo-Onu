package br.fiap.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.dao.FuncionarioDAO;
import br.fiap.entidades.Funcionario;

/**
 * Servlet implementation class relatorioSalario
 */
@WebServlet("/relatorioSalario")
public class relatorioSalario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		FuncionarioDAO dao = new FuncionarioDAO();
		List<Funcionario> lista = dao.listar();
		
		request.setAttribute("lista", lista);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("relatorioSalario.jsp");
		dispatcher.forward(request, response);
		
	}

}
