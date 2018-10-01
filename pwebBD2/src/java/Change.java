import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/Change"})
public class Change extends Modifica {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Change</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Change at " + request.getContextPath() + "</h1>");
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
            throws ServletException, IOException  {  
      PrintWriter out = response.getWriter();
        
      Modifica mod=new Modifica();
      try {
            conexion conex = new conexion();
            Connection con=conex.conectar();
            
            int num_p,idBook;
            String nombreL, editL,sqlQ;
            nombreL= mod.nombreNew;
            editL=mod.editorialNew;
            num_p=mod.numero_paginaNew;
            idBook = mod.idL;
            
            //nombreL=request.getParameter("nombrenew");
            
            //Query Update
            sqlQ=("UPDATE libros SET nombre='"+nombreL+"',editorial='"+editL+"',numeroPag='"+num_p+"' WHERE idLibro='"+idBook+"'");
            PreparedStatement pstmt2=con.prepareStatement(sqlQ);
            pstmt2.executeUpdate(sqlQ);
          
        } catch (SQLException ex) {
            Logger.getLogger(Modifica.class.getName()).log(Level.SEVERE, null, ex);
        }
      
 
        //Query ok CHECKED RUN>>>UPDATE libros SET nombre='nuevoNombre',editorial='editorialNuevo"',numeroPag='xxx' WHERE idLibro= X;
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>CambioRealizado</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Cambios realizado</h1>");
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
