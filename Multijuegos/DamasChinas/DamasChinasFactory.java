package DamasChinas;

import Juegos.MultiJuegos;
import Juegos.MultiJuegosFactory;

public class DamasChinasFactory extends MultiJuegosFactory {
    @Override
    public MultiJuegos crearJuego() {
        return new DamasChLogica();
    }
}
