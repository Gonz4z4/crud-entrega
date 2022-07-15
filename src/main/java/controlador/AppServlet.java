package controlador;

import modelo.ModeloFactory;
import modelo.Modelo;
import modelo.Juego;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;

@WebServlet(name = "AppServlet", urlPatterns = {"/app"})
public class AppServlet extends HttpServlet {
    
    private Modelo model;
    private final String URI_LIST = "listadoJuegos.jsp";
    private final String URI_REMOVE = "/WEB-INF/pages/juegos/borrarJuego.jsp";
    private final String URI_EDIT = "/WEB-INF/pages/juegos/editarJuego.jsp";
    
    @Override
    public void init() throws ServletException{
        this.model=getModelo();
    }
   
    @Override //mostrar los juegos
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        accion = accion == null ? "" : accion;
        switch (accion) {
            case "edit":             
                request.getRequestDispatcher(URI_EDIT).forward(request, response);
                break;
            case "remove":
                request.getRequestDispatcher(URI_REMOVE).forward(request, response);
                break;
            default:
                request.setAttribute("listaJuegos", model.getJuegos());
                request.getRequestDispatcher(URI_LIST).forward(request, response);
            }//con esta linea llamo a el listado

            }
    
    @Override // añadir, borrar o modificar los juegos
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Juego juego;
        String accion = request.getParameter("accion");
        accion = accion == null ? "" : accion;
        int id;
        switch (accion) {
            case "add":
                juego = new Juego();
                cargarJuegoSegunParams(juego, request);
                model.addJuego(juego);
                break;
            case "update":
                id = Integer.parseInt(request.getParameter("id"));
                juego = model.getJuego(id);
                cargarJuegoSegunParams(juego, request);
                model.updateJuego(juego);
                break;
            case "delete":
                id = Integer.parseInt(request.getParameter("id"));
                model.removeJuego(id);
                break;
        }
        doGet(request, response);
    }
    
    private void cargarJuegoSegunParams(Juego a, HttpServletRequest request) {
        a.setNombre(request.getParameter("nombre"));
        a.setDesarrollador(request.getParameter("desarrollador"));
        a.setCaratula(request.getParameter("caratula"));
        a.setFechaLanzamiento(request.getParameter("fechaLanzamiento"));
        a.setDescripcion(request.getParameter("descripcion"));
        a.setLinkCompra("linkCompra");
        a.setGenero("genero");
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