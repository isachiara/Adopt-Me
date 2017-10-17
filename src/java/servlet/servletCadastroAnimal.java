/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;
import Connection.AnimalJDBCDAO;
import Model.Animal;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author isabella
 */
@WebServlet(name = "servletCadastroAnimal", urlPatterns = {"/servletCadastroAnimal"})
public class servletCadastroAnimal extends HttpServlet {

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
        RequestDispatcher cadastrar = request.getRequestDispatcher("WEB-INF/cadastroanimal.jsp");
        cadastrar.forward(request, response);
    }

    
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
          HttpSession session = request.getSession(false);
          session.getAttribute("usuario");
          AnimalJDBCDAO animalJDBC = new AnimalJDBCDAO();
          Animal animal = new Animal ();
          
       
          animal.setNome(request.getParameter("nomeAnimal"));
          animal.setTipo(request.getParameter("Tipo"));
          animal.setIdade(request.getParameter("idadeAnimal"));
          animal.setCaract(request.getParameter("describeAnimal"));
          animal.setTratamento(request.getParameter("tratamento"));
                    
          int fk = (int) session.getAttribute("user");
          
          animalJDBC.save(animal, fk); 
          
          
          
        RequestDispatcher cadastroFeito = request.getRequestDispatcher("perfil");
        cadastroFeito.forward(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
