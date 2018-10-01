
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/Elimina"})
public class Elimina extends HttpServlet {
   
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Elimina</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Elimina at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        int idL;
        idL=Integer.parseInt(request.getParameter("id_libro3"));
        try {
            //processRequest(request, response);
            
            
            
            conexion conex= new conexion();
            Connection con = conex.conectar();
            String sql="DELETE from libros WHERE idLibro='"+idL+"'";
            //PreparedStatement pstmt =con.prepareStatement(sql);
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);   
            
        } catch (SQLException ex) {
            Logger.getLogger(Elimina.class.getName()).log(Level.SEVERE, null, ex);
        }
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>CambioRealizados</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>ELIMINADO libro con id #"+idL+" </h1>");
                out.println("<form action='http://localhost:8080/pwebBD2/formularioBiblio.html'>"); 
                out.println("<p> Volver al menú principal :</p>");                                                        
                out.println("<br>"); 
                out.println("<input type='submit' value='Back' name='back'>");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
}
