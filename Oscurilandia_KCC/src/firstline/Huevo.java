package firstline;

import tablero.IUbicable;

public class Huevo implements IUbicable {

    private int fila;
    private int columna;
    private int puntaje;

    public Huevo(int fila, int columna) {
        this.puntaje = 0;
        ubicar(fila, columna);
    }

//    public Huevo(int fila, int columna, char tipo) {
//        this(fila, columna);
//        asignarPuntaje(tipo);
//    }

    /**
     * @return the fila
     */
    public int getFila() {
        return fila;
    }

    /**
     * @param fila the fila to set
     */
    public void setFila(int fila) {
        this.fila = fila;
    }

    /**
     * @return the columna
     */
    public int getColumna() {
        return columna;
    }

    /**
     * @param columna the columna to set
     */
    public void setColumna(int columna) {
        this.columna = columna;
    }

    /**
     * @return the puntaje
     */
    public int getPuntaje() {
        return puntaje;
    }

    /**
     * @param puntaje the puntaje to set
     */
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    @Override
    public void ubicar(int fila, int columna) {
        setColumna(columna);
        setFila(fila);
    }

    @Override
    public char getTipo() {
        return 'H';
    }
}
