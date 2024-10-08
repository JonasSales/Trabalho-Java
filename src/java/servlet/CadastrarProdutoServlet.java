package servlet;

import bancodedados.Produto;
import dao.ProdutoDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet(name="CadastrarProdutoServlet", urlPatterns={"/CadastrarProdutoServlet"})
public class CadastrarProdutoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.getRequestDispatcher("produtos/acessar/adicionar_produto.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       
        
        String id_produto = request.getParameter("id_produto");
        String nome = request.getParameter("nome");
        String categoria = request.getParameter("categoria");
        String marca = request.getParameter("marca");
        String publico = request.getParameter("publico");
        
        Produto geral = new Produto();
        
        geral.setId_produto(Integer.parseInt(id_produto));
        geral.setNome(nome);
        geral.setCategoria(categoria);
        geral.setMarca(marca);
        geral.setPublico(publico);
        
        boolean inserido = ProdutoDAO.InserirProduto(geral);
        
        response.setContentType("text/html;charset=UTF-8"); // Definindo o tipo de conteúdo
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Resultado do Cadastro</title>");
            out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
            out.println("<script>");
            out.println("setTimeout(function() {");
            out.println("window.location.href = \"produtos/apresentacao.html\";"); // Substitua pela sua página principal
            out.println("}, 5000);"); // Redireciona após 5 segundos
            out.println("</script>");
            out.println("</head>");
            out.println("<body>");
            
            if (inserido) {
                out.println("<h1>Produto cadastrado com sucesso!</h1>");
                out.println("<p>Você será redirecionado para a página principal em 5 segundos...</p>");
            } else {
                out.println("<h1>Erro ao cadastrar produto.</h1>");
                out.println("<p>Tente novamente.</p>");
            }
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Servlet para cadastro de usuários";
    }
}
