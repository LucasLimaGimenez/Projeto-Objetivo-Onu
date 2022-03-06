<%@page import="br.fiap.entidades.Produto"%>
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
		<caption class="titulo-tabela">Relatório dos 5 produtos mais caros da empresa!</caption>
		<%
		List<Produto> lista = (List<Produto>)request.getAttribute("lista");
		for(Produto produto : lista){
		%>
				<tr><td class="distanciamento-01">ID do produto:</td><td class="distanciamento-01"><%=produto.getId_produto() %></td></tr>
				<tr><td class="distanciamento-02">ID da empresa:</td><td class="distanciamento-02"><%=produto.getId_empresa() %></td></tr>
				<tr><td class="distanciamento-02">Nome do produto:</td><td class="distanciamento-02"><%=produto.getNm_produto() %></td></tr>
				<tr><td class="distanciamento-02">Valor unitário do produto:</td><td class="distanciamento-02"><%=produto.getVl_unitario() %></td></tr>
				<tr><td class="distanciamento-02">Função do produto:</td><td class="distanciamento-02"><%=produto.getFuncao() %></td></tr>
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