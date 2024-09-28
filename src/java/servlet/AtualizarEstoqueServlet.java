
package servlet;

import bancodedados.Estoque;
import dao.EstoqueDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


@WebServlet(name="AtualizarEstoqueServlet", urlPatterns={"/AtualizarEstoqueServlet"})
public class AtualizarEstoqueServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.getRequestDispatcher("estoque/acessar/atualizar_estoque.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        double peso = Double.parseDouble(request.getParameter("quantidade"));
        String dimensoes = request.getParameter("dimensoes");
        double preco = Double.parseDouble(request.getParameter("preco"));

        
        Estoque geral = new Estoque();
        geral.setId(id);
        geral.setQuantidade(quantidade);
        geral.setPeso(peso);
        geral.setDimensoes(dimensoes);
        geral.setPreco(preco);
        
        boolean inserido = EstoqueDAO.AtualizarEstoque(geral);
        
        response.setContentType("text/html;charset=UTF-8"); // Definindo o tipo de conteúdo
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Resultado da Atualização</title>");
            out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
            out.println("<script>");
            out.println("setTimeout(function() {");
            out.println("window.location.href = \"estoque/apresentacao.html\";"); // Substitua pela sua página principal
            out.println("}, 5000);"); // Redireciona após 5 segundos
            out.println("</script>");
            out.println("</head>");
            out.println("<body>");
            
            if (inserido) {
                out.println("<h1>Estoque atualizado com sucesso!</h1>");
                out.println("<p>Você será redirecionado para a página principal em 5 segundos...</p>");
            } else {
                out.println("<h1>Produto não achado dentro do estoque.</h1>");
                out.println("<p>Certifique-se que o id exista na tabela produtos.</p>");
            }
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
