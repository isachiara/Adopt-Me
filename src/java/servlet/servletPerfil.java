package servlet;

import Connection.AnimalJDBCDAO;
import Connection.EnderecoJDBCDAO;
import Connection.PerfilJDBCDAO;
import Model.Animal;
import Model.Endereco;
import Model.Perfil;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class servletPerfil extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            PerfilJDBCDAO perfilDAO = new PerfilJDBCDAO();
            EnderecoJDBCDAO enderecoDAO = new EnderecoJDBCDAO();
            AnimalJDBCDAO animalDAO = new AnimalJDBCDAO();
            
            Perfil perfil;
            Endereco endereco;
            ArrayList<Animal> animal = new ArrayList<Animal>();

            HttpSession session = request.getSession();
            
            int id = (int) session.getAttribute("user");
          
            perfil = perfilDAO.retornarDado(id);
            endereco = enderecoDAO.retornarDado(id);
            animal = animalDAO.listPerfil(id);
          
            request.setAttribute("pessoa",perfil);
            request.setAttribute("endereco",endereco);
            request.setAttribute("animal",animal);
            
            RequestDispatcher perfilPronto = request.getRequestDispatcher("WEB-INF/perfil.jsp");
            perfilPronto.forward(request, response);
        
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
