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
    public final int TAMANO = 2;
    private int alcanceTiro;
    private String colorConfeti;

    // Constructor
   
    /**
     * @param cantidadOcupantes
     * @param id
     * @param alcanceTiro
     * @param colorConfeti
     */
    public Caguano(int cantidadOcupantes, String id, int alcanceTiro, String colorConfeti) {
        super(cantidadOcupantes, id);
        setTamano(TAMANO);
        this.alcanceTiro = alcanceTiro;
        this.colorConfeti = colorConfeti;
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
