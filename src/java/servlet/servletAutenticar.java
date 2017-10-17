package servlet;

import Connection.PerfilJDBCDAO;
import Model.Perfil;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Aluno
 */
@WebServlet(name = "servletAutenticar", urlPatterns = {"/servletAutenticar"})

public class servletAutenticar extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {            
          
       
            
        
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PerfilJDBCDAO userDAO = new PerfilJDBCDAO();
        Perfil user;
        
        boolean resultado;
        resultado = userDAO.search(request.getParameter("login"), request.getParameter("senha"));
        
       if(resultado == true){
                request.getSession().invalidate();
                HttpSession session = request.getSession(true);
                session.setAttribute("user", userDAO.getID(request.getParameter("login")));
                RequestDispatcher login = request.getRequestDispatcher("perfil");
                login.forward(request, response);
                       
        }else{
            request.setAttribute("erroLogin", "E-mail ou senha inválidos.");
            RequestDispatcher login = request.getRequestDispatcher("WEB-INF/login.jsp");
            login.forward(request, response);
        }
        
    }

    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
