package modelo;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


// Modelo HC (Hard Codeado): Los datos se guardan en la RAM. Solo sirve para testear la app.
public class ModeloHC implements Modelo {

    private List<Juego> juegosGuardados;

    public ModeloHC() {
        this.juegosGuardados = new ArrayList<>();
        crearJuegosFake();
    }

    @Override
    public List<Juego> getJuegos() {
        return new ArrayList(this.juegosGuardados); // Copia de la lista original
    }

    @Override
    public Juego getJuego(int id) {
        int i = 0;
        Juego encontrado = null;
        while (i < this.juegosGuardados.size() && encontrado == null) {
            Juego a = this.juegosGuardados.get(i);
            if (a.getId() == id) {
                encontrado = a;
            } else {
                i++;
            }
        }
        if (encontrado == null) {
            throw new RuntimeException("No se encontró juegos con ID " + id);
        }
        return encontrado;
    }

    @Override
    public int addJuego(Juego juego) {
        this.juegosGuardados.add(juego);
        return 0;
    }

    @Override
    public int updateJuego(Juego a) {
        Juego target = getJuego(a.getId());
        int idx = this.juegosGuardados.indexOf(target);
        this.juegosGuardados.set(idx, a);
        return 0;
    }

    @Override
    public int removeJuego(int id) {
        Juego target = getJuego(id);
        this.juegosGuardados.remove(target);
        return 0;
    }

    private void crearJuegosFake() {
        try (InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("carasFake.properties")) {
            Properties props = new Properties();
            props.load(is);
            this.juegosGuardados.add(new Juego(1, "Hollow knight", "Team cherry", "2017-02-24", "Juego estilo metroidvania de exploración en un vasto mundo de insectos con combate y plataformeo", "Metroidvania", "https://www.nintenderos.com/wp-content/uploads/2016/07/Hollow-Knight.jpg", "https://store.steampowered.com/app/367520/Hollow_Knight/"));
            this.juegosGuardados.add(new Juego(2, "Crosscode", "Team cherry", "2017-02-24", "Juego estilo metroidvania de exploración en un vasto mundo de insectos con combate y plataformeo", "Metroidvania", "https://www.nintenderos.com/wp-content/uploads/2016/07/Hollow-Knight.jpg", "https://store.steampowered.com/app/367520/Hollow_Knight/"));
            this.juegosGuardados.add(new Juego(3, "Outer wilds", "Team cherry", "2017-02-24", "Juego estilo metroidvania de exploración en un vasto mundo de insectos con combate y plataformeo", "Metroidvania", "https://www.nintenderos.com/wp-content/uploads/2016/07/Hollow-Knight.jpg", "https://store.steampowered.com/app/367520/Hollow_Knight/"));
        } catch (IOException ex) {
            throw new RuntimeException("No se pudieron cargar las caras fake");
        }
    }
}
