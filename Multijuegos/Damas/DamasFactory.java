package Damas;

import Juegos.MultiJuegos;
import Juegos.MultiJuegosFactory;

public class DamasFactory extends MultiJuegosFactory {
    @Override
    public MultiJuegos crearJuego() {
        return new DamasLogica();
    }
}
