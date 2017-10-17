/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import Connection.EnderecoJDBCDAO;
import Connection.PerfilJDBCDAO;
import Model.Endereco;
import Model.Perfil;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aluno
 */
@WebServlet(name = "servletCadastro", urlPatterns = {"/servletCadastro"})
public class servletCadastro extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        RequestDispatcher cadastrar = request.getRequestDispatcher("WEB-INF/cadastro.jsp");
        cadastrar.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException {
           PerfilJDBCDAO perfilDAO = new PerfilJDBCDAO();
           Perfil perfil = new Perfil();
           
           EnderecoJDBCDAO enderecoDAO = new EnderecoJDBCDAO ();
           Endereco endereco = new Endereco ();
           
           perfil.setEmail(request.getParameter("email"));
           perfil.setSenha(request.getParameter("senha"));
           perfil.setNome(request.getParameter("nome"));
           perfil.setSobrenome(request.getParameter("sobrenome"));
           perfil.setDate(request.getParameter("data_nascimento"));
           perfil.setGenero(request.getParameter("genero"));
           perfil.setTelefone(request.getParameter("tel"));
           perfil.setCelular(request.getParameter("cel"));

           perfilDAO.save(perfil);
           int idPerfil = perfilDAO.getID(request.getParameter("email"));
           
           endereco.setCep(request.getParameter("cep"));
           endereco.setCidade(request.getParameter("cidade"));
           endereco.setBairro(request.getParameter("bairro"));
           endereco.setEstado(request.getParameter("estado"));
                     
           enderecoDAO.save(endereco);
           enderecoDAO.defineFK(idPerfil);
           
        RequestDispatcher cadastroFeito = request.getRequestDispatcher("WEB-INF/login.jsp");
        cadastroFeito.forward(request, response);
  
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
