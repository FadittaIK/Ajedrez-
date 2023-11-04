package SoldadosdelRey;

import Juegos.MultiJuegos;
import Juegos.MultiJuegosFactory;

public class SoldadosReyFactory extends MultiJuegosFactory {
    @Override
    public MultiJuegos crearJuego() {
        return new SoldadosdelReyLogica();
    }
}
