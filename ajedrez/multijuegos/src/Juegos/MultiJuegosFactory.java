package Juegos;


public abstract   class MultiJuegosFactory {

    public MultiJuegos crear(){

        MultiJuegos juegos = crearJuego();
        return  juegos;
    }
   protected abstract MultiJuegos crearJuego();
}
