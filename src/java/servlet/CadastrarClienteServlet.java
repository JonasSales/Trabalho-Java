package servlet;

import bancodedados.Cliente;
import dao.ClienteDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet(name="CadastrarClienteServlet", urlPatterns={"/CadastrarClienteServlet"})
public class CadastrarClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.getRequestDispatcher("clientes/acessar/adicionar_cliente.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        String datadenascimento = request.getParameter("datadenascimento");
        
        Cliente geral = new Cliente();
        geral.setNome(nome);
        geral.setCpf(cpf);
        geral.setEmail(email);
        geral.setDatadenascimento(datadenascimento);
        
        boolean inserido = ClienteDAO.InserirClientes(geral);
        
        response.setContentType("text/html;charset=UTF-8"); // Definindo o tipo de conteúdo
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Resultado do Cadastro</title>");
            out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
            out.println("<script>");
            out.println("setTimeout(function() {");
            out.println("window.location.href = 'clientes/apresentacao.html';"); // Substitua pela sua página principal
            out.println("}, 5000);"); // Redireciona após 5 segundos
            out.println("</script>");
            out.println("</head>");
            out.println("<body>");
            
            if (inserido) {
                out.println("<h1>Cliente cadastrado com sucesso!</h1>");
                out.println("<p>Você será redirecionado para a página principal em 5 segundos...</p>");
            } else {
                out.println("<h1>Erro ao cadastrar cliente.</h1>");
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
