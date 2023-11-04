package model;

public class Tablero {
    private final int LONGITUD ;



    private Casilla[][] casillas ;
    public Tablero(){
        this.LONGITUD = 8;
        this.casillas = new Casilla[LONGITUD][LONGITUD];
        inicializarTablero();
    }

    public void inicializarTablero() {
        //asignar a todas las casillas un valor
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas.length; j++) {
                casillas[i][j] = new Casilla();
            }
        }
        ponerColoresACasillas(casillas);
    }
    public void setCasillas(Casilla[][] casillas) {
        this.casillas = casillas;
    }
    public Casilla[][] getCasillas() {
        return casillas;
    }

    private Casilla[][] ponerColoresACasillas(Casilla[][] casillas){


        for (int b = 0; b < casillas.length;b++){
            for (int n = 0; n < casillas.length;n++){
                 Color colorBTemporal;
                 Color colorNTemporal;
                if (n % 2 == 0){
                    colorBTemporal = Color.BLANCO;
                    colorNTemporal = Color.NEGRO;

                }else{
                    colorBTemporal =  Color.NEGRO;
                    colorNTemporal = Color.BLANCO;
                }
                if (b % 2 == 0){
                    casillas[b][n].setColorCasilla(colorBTemporal);

                }else {
                    casillas[b][n].setColorCasilla(colorNTemporal);
                }
            }
        }
        return casillas;
    }

    public boolean existeEnElTablero(int x,int y){
        return (x >= 0 && x < casillas.length && y >= 0 && y < casillas[0].length);
    }



}
