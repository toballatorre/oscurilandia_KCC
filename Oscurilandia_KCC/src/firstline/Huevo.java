/**
 * Clase huevo que se implementa para poder impactar a los carros en la matriz
 */
package firstline;

import tablero.IIdentificable;
/**
 * 
 * @author KCC
 *
 */

public class Huevo implements IIdentificable {

    // ========== ATRIBUTOS ==========

    private int fila;
    private int columna;
    private int puntaje;

    // ========== CONSTRUCTORES ==========
    /**
     * Constructos para cuando no impacta un carro
     * @param fila
     * @param columna
     */
    public Huevo(int fila, int columna) {
        this.puntaje = 0;
        this.fila = fila;
        this.columna = columna;
    }
    
    /**
     * Constructor cuando impacta un carro
     * @param fila
     * @param columna
     * @param tipo
     * @param vida
     */
    public Huevo(int fila, int columna, char tipo, int vida) {
        this(fila, columna);
        asignarPuntaje(tipo, vida);
    }

    // ========== METODOS ===========

    /**
     * Asigna un puntaje segun el tipo de carro que impacta, si está vacio el
     * espacio o cuando impacta un huevo.
     * 
     * @param tipo
     * @param vida
     */
    private void asignarPuntaje(char tipo, int vida) {

        if (tipo != 'H') {
            if (tipo == 'K' && vida == 0) {
                this.puntaje = 13;
            } else if (tipo == 'K') {
                this.puntaje = 3;
            }
            if (tipo == 'C' && vida == 0) {
                this.puntaje = 9;
            } else if (tipo == 'C') {
                this.puntaje = 2;
            }
            if (tipo == 'T') {
                this.puntaje = 1;
            }
        }
    }

    // ========== GET SET ==========
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
    
    // ========== HEREDADO INTERFACE IIDENTIFICABLE ==========
    @Override
    public char getTipo() {
        return 'H';
    }
}
