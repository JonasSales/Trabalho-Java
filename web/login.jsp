

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% String erro = (String)request.getAttribute("erro"); %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Página de Login</h1>
        
        <form action="http://localhost:8080/LoginServlet" method="post">
            <h2>Login</h2>



            <label>Email:</label>
            <input type="email" id="email" name="email" maxlength="100"
                   required>

            <label>Senha:</label>
            <input type="password" id="senha" name="senha"
                   required>

            <input type="submit" value="Adicionar">
            <%if (erro != null) {
                    out.print(erro);
                }
            %>
        
        </form>
    </body>
</html>
