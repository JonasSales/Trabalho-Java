<%@ page import="java.sql.*" %>
<%@ page import="dao.ProdutoDAO"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="bancodedados.Produto"%>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Listar Produtos</title>
    
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f4f4f4;
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
    <h1>Lista de Produtos</h1>
    <a href="http://localhost:8080/produtos">Retornar para página principal</a>
    <%
        // Configurações da conexão
        ArrayList<Produto> produtos = ProdutoDAO.BuscarProdutos();
       
        // Criar tabela para exibir os clientes
        out.println("<table>");
        out.println("<tr><th>ID</th><th>Nome</th><th>Categoria</th><th>Marca</th><th>Publico</th></tr>");
        
        for (Produto u : produtos) {
            out.println("<tr>");
            out.println("<td>" + u.getId_produto() + "</td>");
            out.println("<td>" + u.getNome() + "</td>");
            out.println("<td>" + u.getCategoria() + "</td>");
            out.println("<td>" + u.getMarca() + "</td>");
            out.println("<td>" + u.getPublico() + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");
    %>
</body>
</html>
