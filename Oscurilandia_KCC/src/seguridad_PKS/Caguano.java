/**
 * Clase hija de Carro que implementa la interface IIdentificable
 */
package seguridad_PKS;

/**
 * @author KCC
 *
 */
public class Caguano extends Carro {

    // ========== ATRIBUTOS ==========

    public int TAMANO = 2;
    private int alcanceTiro;
    private String colorConfeti;

    // ========== CONSTRUCTOR ==========

    public Caguano(String id, int fila, int columna) {
        super(id, fila, columna);
        setCantidadOcupantes(4);
        setTamano(TAMANO);
        this.alcanceTiro = 10;
        generaColor();
    }

    // ========== GET SET ===========

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
    
    // ========== TO SRING ==========
    @Override
    public String toString() {
        
        int[] ingreso = getFechaIngreso();
        String ing = String.format("%d/%d/%d", ingreso[0], ingreso[1], ingreso[2]);
        String coordenada = String.format("(%d,%d)", getFila(), getColumna());

        return String.format("%4s %19d %14s %10s %16d %s", getId(), getCantidadOcupantes(), ing, coordenada,
                alcanceTiro, colorConfeti);
    }
    
    // ========== METODOS ==========

    /**
     * 
     */
    private void generaColor() {
        String[] colores = { "Rojo", "Rosado", "Rojo Maraco Intenso", "Verde Limon", "Sangre De Toro" };
        int i = (int) (Math.random() * colores.length);
        this.colorConfeti = colores[i];
    }

    // ========== HEREDADO INTERFACE IIDENTIFICABLE ==========
    
    /**
     * Retorna el tipo de carro que es
     * 
     * @return retorna un caracter que identifica el carro
     */
    @Override
    public char getTipo() {
        return 'C';
    }
}
