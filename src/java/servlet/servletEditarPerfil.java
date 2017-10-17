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
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author isabella
 */
public class servletEditarPerfil extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/editarperfil.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        HttpSession session = request.getSession(false);
        
           PerfilJDBCDAO perfilDAO = new PerfilJDBCDAO();
           Perfil perfil = new Perfil();
           EnderecoJDBCDAO enderecoDAO = new EnderecoJDBCDAO();
           Endereco endereco = new Endereco();
        
           perfil.setNome(request.getParameter("nome"));
           perfil.setSobrenome(request.getParameter("sobrenome"));
           perfil.setDate(request.getParameter("data_nascimento"));
           perfil.setGenero(request.getParameter("genero"));
           perfil.setTelefone(request.getParameter("tel"));
           perfil.setCelular(request.getParameter("cel"));
           
           endereco.setCep(request.getParameter("cep"));
           endereco.setCidade(request.getParameter("cidade"));
           endereco.setBairro(request.getParameter("bairro"));
           endereco.setEstado(request.getParameter("estado"));
           
           int id = (int) session.getAttribute("user");
           
            perfilDAO.updateTable(perfil, id);
            enderecoDAO.updateTable(endereco, id);
            
            RequestDispatcher cadastroFeito = request.getRequestDispatcher("perfil");
            cadastroFeito.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
