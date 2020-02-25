package firstline;

import tablero.IUbicable;

public class Huevo implements IUbicable {

    private int fila;
    private int columna;
    private int puntaje;
    
    // ========== CONSTRUCTORES ==========
    
    public Huevo(int fila, int columna) {
        this.puntaje = 0;
        ubicar(fila, columna);
    }

    public Huevo(int fila, int columna, char tipo, int vida) {
        this(fila, columna);
        asignarPuntaje(tipo, vida);
    }
    // ========== METODOS ===========
    /**
     * 
     * @param tipo
     * @param vida
     */
    private void asignarPuntaje(char tipo, int vida) {
        
        if (tipo == 'H') {
            this.puntaje = 0;
        }else {
            if (tipo == 'K' && vida == 0) {
                this.puntaje = 13;
            }else if(tipo == 'K') {
                this.puntaje = 3;
            }
            if (tipo == 'C' && vida == 0) {
                this.puntaje = 9;
            }else if(tipo == 'C'){
                this.puntaje = 2;
            }
            if (tipo == 'T') {
                this.puntaje = 1;
            }
        }
        
    }

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
