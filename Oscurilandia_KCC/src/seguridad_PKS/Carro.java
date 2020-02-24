/**
 * 
 */
package seguridad_PKS;

import tablero.IUbicable;

/**
 * @author KCC
 *
 */
public abstract class Carro implements IUbicable {

    // Atributos
    private int tamano;
    private int cantidadOcupantes;
    private int fechaIngreso;
    private int fila;
    private int columna;
    private String id;

    /**
     * Constructor con todos los atributos
     * 
     * @param tamano
     * @param cantidadOcupantes
     * @param fechaIngreso
     * @param ubicacionTablero
     * @param id
     */
    public Carro(int tamano, int cantidadOcupantes, int fechaIngreso, String id) {
        super();
        this.tamano = tamano;
        this.cantidadOcupantes = cantidadOcupantes;
        this.fechaIngreso = fechaIngreso;
        this.fila = fila;
        this.columna = columna;
        this.id = id;
    }

    /**
     * @return the tamano
     */
    public int getTamano() {
        return tamano;
    }

    /**
     * @param tamano the tamano to set
     */
    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    /**
     * @return the cantidadOcupantes
     */
    public int getCantidadOcupantes() {
        return cantidadOcupantes;
    }

    /**
     * @param cantidadOcupantes the cantidadOcupantes to set
     */
    public void setCantidadOcupantes(int cantidadOcupantes) {
        this.cantidadOcupantes = cantidadOcupantes;
    }

    /**
     * @return the fechaIngreso
     */
    public int getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * @param fechaIngreso the fechaIngreso to set
     */
    public void setFechaIngreso(int fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
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

}