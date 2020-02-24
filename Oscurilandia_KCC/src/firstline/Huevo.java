package firstline;

import tablero.IUbicable;

public class Huevo implements IUbicable{

    private int fila;
    private int columna;
    private int puntaje;

    public Huevo(int fila, int columna, char tipo) {
        this.fila = fila;
        this.columna = columna;
        this.puntaje = 0;
    }

    @Override
    public void ubicar(int fila, int columna) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public char getTipo() {
        return 'H';
    }
}
