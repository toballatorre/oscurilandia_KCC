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
    private String fechaIngreso;
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
        this.fechaIngreso = generaFecha();
        this.fila = fila;
        this.columna = columna;
        this.id = id;
    }

    // ========== GET SET ===========

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
    public String getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * @param fechaIngreso the fechaIngreso to set
     */
    public void setFechaIngreso(String fechaIngreso) {
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

    // ========== METODOS ==========

    private String generaFecha() {
        int dia;
        int mes;
        int ano;

        ano = (int) ((Math.random() * (2020 - 1998)) + 1998);
        mes = (int) (Math.random() * 12 + 1);

        // Si es bisiesto o no
        if (ano % 4 == 0 && ano % 100 == 0 && ano % 400 == 0) {

            if (mes == 2) // Si es bisiesto
                dia = (int) (Math.random() * 29 + 1);

            else {
                if (mes == 4 && mes == 6 && mes == 9 && mes == 11)
                    dia = (int) (Math.random() * 30 + 1);
                else
                    dia = (int) (Math.random() * 31 + 1);
            }
        } else {
            if (mes == 2) // No es bisiesto
                dia = (int) (Math.random() * 28 + 1);

            else {
                if (mes == 4 && mes == 6 && mes == 9 && mes == 11)
                    dia = (int) (Math.random() * 30 + 1);
                else
                    dia = (int) (Math.random() * 31 + 1);
            }
        }
        return dia + "-" + mes + "-" + ano;
    }
}