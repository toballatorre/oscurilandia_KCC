/**
 * 
 */
package seguridad_PKS;

/**
 * @author KCC
 *
 */
public class Caguano extends Carro {
    // Atributos
    private int alcanceTiro;
    private String colorConfeti;

    // Constructor
    /**
     * @param tamano
     * @param cantidadOcupantes
     * @param fechaIngreso
     * @param fila
     * @param columna
     * @param id
     * @param alcanceTiro
     * @param colorConfeti
     */
    public Caguano(int tamano, int cantidadOcupantes, int fechaIngreso, int fila, int columna, String id,
            int alcanceTiro, String colorConfeti) {

        super(tamano, cantidadOcupantes, fechaIngreso, id);

        this.alcanceTiro = alcanceTiro;
        this.colorConfeti = colorConfeti;
        ubicar(fila, columna);
    }

    // Metodos Get and Set
    @Override
    public char getTipo() {
        return 'C';
    }

    /**
     * @return the alcanceTiro
     */
    public int getAlcanceTiro() {
        return alcanceTiro;
    }

    /**
     * @param alcanceTiro the alcanceTiro to set
     */
    public void setAlcanceTiro(int alcanceTiro) {
        this.alcanceTiro = alcanceTiro;
    }

    /**
     * @return the colorConfeti
     */
    public String getColorConfeti() {
        return colorConfeti;
    }

    /**
     * @param colorConfeti the colorConfeti to set
     */
    public void setColorConfeti(String colorConfeti) {
        this.colorConfeti = colorConfeti;
    }

    @Override
    public void ubicar(int fila, int columna) {
        setFila(fila);
        setColumna(columna);
    }
}
