/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author gonza
 */
public class Juego {

//Atributos
    private int id;
    private String nombre;
    private String desarrollador;
    private LocalDate fechaLanzamiento;
    private String descripcion;
    private String genero;
    private String caratula;
    private String linkCompra;

    
//CONSTRUCTORES
    public Juego(){}
    public Juego(int id) {
        setId(id);
    }
    public Juego(String nombre, String desarrollador, String fechaLanzamiento, String descripcion, String genero, String caratula, String linkCompra) {
        this(0, nombre, desarrollador, fechaLanzamiento, descripcion, genero, caratula, linkCompra);
    }
    public Juego(String nombre, String desarrollador, String fechaLanzamiento, String descripcion, String genero, String linkCompra) {
        this(0, nombre, desarrollador, fechaLanzamiento, descripcion, genero, "", linkCompra);
    }
    public Juego(int id, String nombre, String desarrollador, String fechaLanzamiento, String descripcion, String genero, String caratula, String linkCompra) {
        setId(id);
        setNombre(nombre);
        setDesarrollador(desarrollador);
        setFechaLanzamiento(fechaLanzamiento);
        setDescripcion(descripcion);
        setGenero(genero);
        setCaratula(caratula);
        setLinkCompra(linkCompra);
        }
    
    
//SETTERS
    public void setId(int id) {
        if (id < 0) {
            throw new RuntimeException("Valor para ID inconsistente");
        }
        this.id = id;
    }
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new RuntimeException("No se ha provisto un nombre");
        }
        this.nombre = nombre.trim();
    }
    public void setDesarrollador(String desarrollador) {
        if (desarrollador == null || desarrollador.trim().isEmpty()) {
            throw new RuntimeException("No se ha proveido el nombre de un desarrollador");
        }
        this.desarrollador = desarrollador.trim();
    }
    public void setFechaLanzamiento(String fechaLanzamiento) {
        if (fechaLanzamiento == null || fechaLanzamiento.trim().isEmpty()) {
            throw new RuntimeException("No se ha provisto una fecha de lanzamiento");
        }
        try {
            LocalDate posibleFecha = LocalDate.parse(fechaLanzamiento.trim());
            if (posibleFecha.isAfter(LocalDate.now())) {
                throw new RuntimeException("La fecha de nacimiento proveída es posterior al día de hoy");
            }
            this.fechaLanzamiento = posibleFecha;
        } catch (DateTimeParseException ex) {
            throw new RuntimeException("La fecha de nacimiento proveída no es válida", ex);
        }
    }
    public void setDescripcion(String descripcion) {
         if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new RuntimeException("No se ha proveido una descripcion");}
        this.descripcion = descripcion.trim();
    }
    public void setGenero(String genero) {
        if (genero == null || genero.trim().isEmpty()) {
            throw new RuntimeException("No se ha proveido un género");}
        this.genero = genero.trim();
    }
    public void setCaratula(String caratula) {
        if (caratula == null || caratula.trim().isEmpty()) {
            throw new RuntimeException("No se ha proveido una carátula");}
        this.caratula = caratula.trim();
    }
    public void setLinkCompra(String linkCompra) {
        if (linkCompra == null || linkCompra.trim().isEmpty()) {
            throw new RuntimeException("No se ha proveido una link de compra");}
        this.linkCompra = linkCompra.trim();
    }
    
    
//GETTERS
    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getDesarrollador() {
        return desarrollador;
    }
    public String getFechaLanzamiento() {
        return fechaLanzamiento.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
    public String getDescripcion() {
        return descripcion;
    }
    public String getGenero() {
        return genero;
    }
    public String getCaratula() {
        return caratula;
    }
    public String getLinkCompra() {
        return linkCompra;
    }

    
//TO STRING
    @Override
    public String toString() {
        return "Juego{" + "id=" + id + ", nombre=" + nombre + ", desarrollador=" + desarrollador + ", fechaLanzamiento=" + fechaLanzamiento + ", descripcion=" + descripcion + ", genero=" + genero + ", caratula=" + caratula + ", linkCompra=" + linkCompra + '}';
    }
    

}
    
    

