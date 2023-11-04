package GatosYRaton;

import Juegos.MultiJuegos;
import Juegos.MultiJuegosFactory;

public class GatosRatonFactory extends MultiJuegosFactory {
    @Override
    public MultiJuegos crearJuego() {
        return new GatosYRatonLogica();
    }
}
