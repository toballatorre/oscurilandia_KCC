/**
 * Clase hija de Carro que implementa la interface IIdentificable
 */
package seguridad_PKS;

/**
 * @author KCC
 *
 */
public class Kromi extends Carro {

    // ========== ATRIBUTOS ==========
    private final int TAMANO = 3;
    private int anoFabricacion;
    private String marca;

    // ========== CONSTRUCTOR ==========

    public Kromi(String id, int fila, int columna) {
        super(id, fila, columna);
        setCantidadOcupantes(10);
        setTamano(TAMANO);
        generaAnoFabricacion();
        generaMarca();
    }

    // ========== GET SET ==========
    /**
     * @return el anoFabricacion
     */
    public int getAnoFabricacion() {
        return anoFabricacion;
    }

    /**
     * @param anoFabricacion the anoFabricacion to set
     */
    public void setAnoFabricacion(int anoFabricacion) {
        this.anoFabricacion = anoFabricacion;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    // ========== TO STRING ==========

    @Override
    public String toString() {
        
        int[] ingreso = getFechaIngreso();
        String ing = String.format("%d/%d/%d", ingreso[0], ingreso[1], ingreso[2]);
        String coordenada = String.format("(%d,%d)", getFila(), getColumna());

        return String.format("%4s %19d %14s %10s %16d %s", getId(), getCantidadOcupantes(), ing, coordenada,
                anoFabricacion, marca);
    }

    // ========== METODOS ==========
    /**
     * Genera el año de fabricacion del carro Kromi
     */
    private void generaAnoFabricacion() {
        int[] fechaIngreso = getFechaIngreso();
        this.anoFabricacion = (int) (Math.random() * (fechaIngreso[2] - 1998) + 1998);
    }

    /**
     * Genera una marca de manera aleatoria
     */
    private void generaMarca() {
        String[] marcas = { "Chiwawa", "Waffles", "Caracoqueso", "Wachimingo" };
        int i = (int) (Math.random() * marcas.length);
        this.marca = marcas[i];
    }

    // ========== HEREDADO INTERFACE IIDENTIFICABLE ==========

    /**
     * Retorna el tipo de carro que es
     * 
     * @return retorna un caracter que identifica el carro
     */
    @Override
    public char getTipo() {
        return 'K';
    }
}
