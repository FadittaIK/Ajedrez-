import Ajedrez.AjedrezFactory;
import Damas.DamasFactory;
import DamasChinas.DamasChinasFactory;
import GatosYRaton.GatosRatonFactory;
import Juegos.MultiJuegos;
import SoldadosdelRey.SoldadosReyFactory;
import model.Terminal;

public class Main {
    public static void main(String[] args) {


        Terminal terminal = new Terminal();
        terminal.bienvenida();
        int juego = terminal.seleccionaUnJuego();
        switch (juego) {
            case 1 -> {
                MultiJuegos juego1 = new AjedrezFactory().crearJuego();
                juego1.inicializaCasillas();
            }
            case 2 -> {
                MultiJuegos juego2 = new DamasFactory().crearJuego();
                juego2.inicializaCasillas();
            }
            case 3 -> {
                MultiJuegos juego3 = new SoldadosReyFactory().crearJuego();
                juego3.inicializaCasillas();
            }
            case 4 -> {
                MultiJuegos juego4 = new GatosRatonFactory().crearJuego();
                juego4.inicializaCasillas();
            }
            case 5 -> {
                MultiJuegos juego5 = new DamasChinasFactory().crearJuego();
                juego5.inicializaCasillas();
            }
            default -> terminal.invalidValor();
        }
    }
}