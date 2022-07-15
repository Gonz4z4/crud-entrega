/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.List;

/**
 *
 * @author gonza
 */
public interface Modelo {
    public List<Juego> getJuegos(); //retorna lista de juego
    
    public Juego getJuego(int id); //retorna por id
    
    public int addJuego(Juego juego); //agrega juego
    
    public int updateJuego(Juego juego); //modifica juego
    
    public int removeJuego(int id); //borra juego
}
