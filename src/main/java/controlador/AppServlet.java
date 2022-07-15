package controlador;

import modelo.ModeloFactory;
import modelo.Modelo;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;

/**
 *
 * @author gonza
 */
@WebServlet(name = "AppServlet", urlPatterns = {"/app"})
public class AppServlet extends HttpServlet {
    
    private Modelo model;
    private final String URI_LIST = "listadoJuegos.jsp";
    
    @Override
        public void init() throws ServletException{
            this.model=getModelo();
        }
   
    @Override //mostrar los alumnos
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher(URI_LIST).forward(request, response); //con esta linea llamo a el listado
            }
    
    @Override // añadir, borrar o modificar los alumnos
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            }

     private Modelo getModelo() throws ServletException { //Consigue el modelo de la modelo factory
         Modelo m = null;
        try ( InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties")) {
            Properties props = new Properties();
            props.load(is);
            String tipoModelo = props.getProperty("tipoModelo");
            m = ModeloFactory.getInstance().crearModelo(tipoModelo);
        } catch (IOException ex) {
            throw new ServletException("Error de E/S al al leer 'config' para iniciar el Servlet", ex);
        }
        return m;
    }
        
}