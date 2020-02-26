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
    public Caguano(String id, int fila, int columna) {
        super(id, fila, columna);
        setCantidadOcupantes(4);
        setTamano(TAMANO);
        this.alcanceTiro = 10;
        generaColor();
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
    /**
     * 
     */
    private void generaColor() {
        String[] colores = { "Rojo", "Rosado", "Rojo Maraco Intenso", "Verde Limon", "Sangre De Toro"};
        int i = (int) (Math.random() * colores.length);
        this.colorConfeti = colores[i];
    }
}
