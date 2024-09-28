<%@ page import="dao.LogDAO" %>
<%@ page import="bancodedados.Log" %>
<%@ page import="java.util.ArrayList"%>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Logs</title>
    
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
    <h1>Logs</h1>
    <a href="http://localhost:8080/log/index.html">Retornar para página principal</a>
    <%
        ArrayList<Log> logs = LogDAO.BuscarLog();
       
        // Criar tabela para exibir os logs
        out.println("<table>");
        out.println("<tr><th>Data</th><th>Hora</th><th>Ação</th><th>Tabela</th></tr>");
        
        for (Log u : logs) {
            out.println("<tr>");
            out.println("<td>" + u.getData() + "</td>");
            out.println("<td>" + u.getHora() + "</td>");
            out.println("<td>" + u.getAcao() + "</td>");
            out.println("<td>" + u.getTabela() + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");
    %>
</body>
</html>
