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
    <nav class="navegacao">
      <div>
        <ul class="arruma-menu">
          <li><a href="index.jsp">Home</a></li>
          <li><a href="index.jsp">Serviços</a></li>
          <li><a href="index.jsp">Nossos Clientes</a></li>
          <li><a href="index.jsp">Produtos</a></li>
          <li><a href="#">Logar</a></li>
        </ul>
      </div>
    </nav>
  </div>
</header>

<main class="menu-principal">

	<div class="section-formulario">
	
		<h1 class="titulo-pagina">Login</h1>

		<form class="formulario" action="login.jsp" method="post">
		
		<div class="dados">
            <label for="email">Email:</label>
            <input type="text" class="input-text" id="email" name="email" placeholder="Digite o email de administrador">
        </div>
        
        <div class="dados">
            <label for="senha">Senha:</label>
            <input type="password" class="input-text" id="senha" name="senha" placeholder="Digite a senha de administrador">
        </div>
        
        <input type="submit" class="input-enviar" value="Logar">
		
		</form>
		
		<%
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			
			if(email!=null && senha!=null && !email.isEmpty() && !senha.isEmpty()){
				if(email.equalsIgnoreCase("admin@gmail.com") && senha.equalsIgnoreCase("1234")){
				session.setAttribute("email", email);
				response.sendRedirect("index-gerenciamento.html");
				}else{
					response.sendRedirect("login.jsp");
				}
			}
		%>
    
    
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