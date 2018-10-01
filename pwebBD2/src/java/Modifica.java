import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet(urlPatterns = {"/Modifica"})
public class Modifica extends HttpServlet {
     int idL;
     String nombreNew;
     String editorialNew;
     int numero_paginaNew;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Modifica</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Modifica at " + request.getContextPath() + "</h1>");
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
        //
            PrintWriter out = response.getWriter();
               
                idL=Integer.parseInt(request.getParameter("id_libro2"));
                
        try {
            //processRequest(request, response);

            conexion conex = new conexion();
            Connection con=conex.conectar();
            String sql="SELECT* FROM libros WHERE idLibro='"+idL+"'";
            PreparedStatement pstmt =con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery(sql);
                while(rs.next()){
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Modificar</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Registrado</h1>");
                out.println("<table border=2><tr>");
                     out.println("<table border=2><tr>"
                    +"<td>ID libro: "+rs.getString("idLibro")+"</td>"
                    +"<td>Nombre libro: "+rs.getString("nombre")+"</td>"
                    +"<td>Editorial: "+rs.getString("editorial")+"</td>"
                            + "<td>Número paginas: "+rs.getString("numeroPag")+"</td></tr></table>");
                }
           
                out.println("<br><br>");
                out.println("<p>Campos modificables : </p>");
                out.println("<form action='http://localhost:8080/pwebBD2/Change' method='post'>");
                out.println("ID = <input type='text' name='idLibroM'value= "+idL+" disabled><br>");
                out.println("Nombre:   <input type='text'  name='nombrenew'><br>");
                out.println("Editorial: <input type='text' name='editorialnew'><br>");
                out.println("Paginas:   <input type='text' name='numeroPaginaNew'><br>");
                out.println("<input type='submit' value='Modificar' name='modifica'>");
                out.println("</form>");
           
                
                //COMO CACHO LOS CAMPOS DE TEXTBOX A UNA VARIABLE GLOBLAL
                // PARA DESPUES ENVIARLOS A 'CHANGE.JAVA', QUE ES DONDE HAGO QUERY DE UPDATE PARA MODIFICAR
                //CABE RESALTAR QUE EL USO DE LA VARIABLE GLOBAL COMO 'ID', PARA REALIZAR LA QUERY SE EJECUTA CON EXITO
                //YA QUE INDICA PERFECTAMENTE A QUE 'ID' DE LIBRO SE REFIERE
                //Y SE EJECUTA LA QUERY, PERO JAMAS REALIZA CAMBIOS PORQUE NO PUEDO TOMAR NINGUN VALOR INSERTADO EN 
                //LAS LINEAS 77-85 DE ESTE CODE Y ESTE ARCHIVO.
               
        } catch (SQLException ex) {
            Logger.getLogger(Modifica.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
  protected void modifica(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            //PrintWriter out = response.getWriter();
  }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
