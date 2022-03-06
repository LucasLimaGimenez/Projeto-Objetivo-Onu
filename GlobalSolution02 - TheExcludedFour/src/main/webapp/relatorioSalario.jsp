<%@page import="br.fiap.entidades.Funcionario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Global Solution - The Excluded Four</title>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body> 

<header class="cabecalho">
  <div class="ajusta-cabecalho">
    <div class="logo"> 
      <a href="index.html"><img src="images/logo.png" alt=""></a> 
    </div>
  </div>
</header>

<main class="menu-principal">

<div class="section-relatorio">
		
		<table class="tabela">
		<caption class="titulo-tabela">Relatório dos 5 maiores salários da empresa!</caption>
		<%
		List<Funcionario> lista = (List<Funcionario>)request.getAttribute("lista");
		for(Funcionario funcionario : lista){
		%>
				<tr><td class="distanciamento-01">ID do funcionário:</td><td class="distanciamento-01"><%=funcionario.getId_funcionario() %></td></tr>
				<tr><td class="distanciamento-02">ID da empresa:</td><td class="distanciamento-02"><%=funcionario.getId_empresa() %></td></tr>
				<tr><td class="distanciamento-02">Nome do funcionário:</td><td class="distanciamento-02"><%=funcionario.getNm_funcionario() %></td></tr>
				<tr><td class="distanciamento-02">RG do funcionário:</td><td class="distanciamento-02"><%=funcionario.getRg() %></td></tr>
				<tr><td class="distanciamento-02">Endereço do funcionário:</td><td class="distanciamento-02"><%=funcionario.getEndereco() %></td></tr>
				<tr><td class="distanciamento-02">Telefone do funcionário:</td><td class="distanciamento-02"><%=funcionario.getTelefone() %></td></tr>
				<tr><td class="distanciamento-02">Salário do funcionário:</td><td class="distanciamento-02"><%=funcionario.getSalario() %></td></tr>
			<% } %>
		</table>
		
		
    	
    	<div class="centralizando">
		<p class="texto-box">
			<a href="relatorio.html" class="link-container">Voltar</a>
		</p>
	
		</div>

</div>

  	

</main>	
  

<div id="footer">
  <div>
    <div class="first">
      <a href="index.html"><img src="images/logo.png" alt=""></a> 
      <p>Acreditamos em um futuro melhor e isso começa cuidando dos nossos rios e lagos tão preciosos!</p>
      <div>
        <p>Telefone Comercial : <span>(11)962607842</span></p>
        <p>Email : <span>theexcludedfour@gmail.com</span></p>
        <p>Blog : <span>theexcludedfour@blog.com.br</span></p>
      </div>
    </div>
    <div>
      <h3 class="titulo-footer">Nos siga nas redes sociais !</h3>
      <p class="texto-footer">Conheça melhor nossos projetos e nossas atividades,frequentemente postamos nossas atividades em nossas redes sociais, não percam! </p>
      <div class="arruma-icon"> <a href="https://www.facebook.com/" class="facebook"></a> <a href="https://twitter.com/" class="twitter"></a> <a href="https://www.linkedin.com/" class="linked-in"></a> </div>
    </div>
    <div>
      <h3 class="titulo-footer">Nos envie um email !</h3>
      <p>Gostaria de nos contatar para futuras negociações?</p>
      <form action="#">
        <label for="subscribe">
          <input type="text" id="subscribe" maxlength="30" placeholder="Email">
        </label>
        <input class="submit" type="submit" value="Enviar">
      </form>
    </div>
  </div>
</div>
</body>
</html>