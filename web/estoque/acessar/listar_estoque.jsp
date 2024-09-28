<%@ page import="dao.EstoqueDAO" %>
<%@ page import="bancodedados.Estoque" %>
<%@ page import="java.util.ArrayList"%>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Produtos</title>
    
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f4f4f4;
        }
        a{
            text-decoration: none;
            color: #333;
            font-weight: bold;
        }
        a:hover{
            color: #4CAF50;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 12px;
            text-align: left;
            border: 1px solid #ddd;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #ddd;
        }
    </style>
</head>
<body>
    <h1>Estoque</h1>
    <a href="http://localhost:8080/estoque">Retornar para página principal</a>
    <%
        ArrayList<Estoque> estoque = EstoqueDAO.BuscarEstoque();
       
        // Criar tabela para exibir os clientes
        out.println("<table>");
        out.println("<tr><th>ID</th><th>Nome</th><th>Quantidade</th><th>Peso</th><th>Dimensoes</th><th>Preço</th></tr>");
        
        for (Estoque u : estoque) {
            out.println("<tr>");
            out.println("<td>" + u.getId() + "</td>");
            out.println("<td>" + u.getNome() + "</td>");
            out.println("<td>" + u.getQuantidade() + "</td>");
            out.println("<td>" + u.getPeso() + "</td>");
            out.println("<td>" + u.getDimensoes() + "</td>");
            out.println("<td>" + u.getPreco() + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        
    %>
</body>
</html>
