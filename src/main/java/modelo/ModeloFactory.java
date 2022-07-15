/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author gonza
 */
public class ModeloFactory {
    
    private ModeloFactory() {}
    
    private static ModeloFactory mf = null;

    public static ModeloFactory getInstance() {
        if (mf == null) {
            mf = new ModeloFactory();
        }
        return mf;
    }
    
    public Modelo crearModelo(String nombreModelo) {
        Modelo m = null;
        String nombreClase = mf.getClass().getPackage().getName() + ".Modelo" + nombreModelo;
        try {
            m = (Modelo) Class.forName(nombreClase).getDeclaredConstructor().newInstance();
        } catch (Exception ex) {
            throw new RuntimeException("Ocurrió un error al instanciar un modelo de tipo " + nombreClase, ex);
        }
        return m;
    }  
}
