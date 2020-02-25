/**
 * 
 */
package seguridad_PKS;

/**
 * @author KCC
 *
 */
public class Kromi extends Carro {

    // Atributos
    private final int TAMANO = 3;
    private int anoFabricacion;
    private String marca;

    // Constructor

    /**
     * @param cantidadOcupantes
     * @param id
     * @param anoFabricacion
     * @param marca
     */
    public Kromi(int cantidadOcupantes, String id) {

        super(cantidadOcupantes, id);
        setTamano(TAMANO);
        generaAno();
        generaMarca();

    }

    /**
     * Retorna el tipo que es
     * 
     * @return
     */
    @Override
    public char getTipo() {
        return 'K';
    }

    // Metodos Get and Set
    /**
     * @return the anoFabricacion
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

    private void generaAno() {
        this.anoFabricacion = (int) (Math.random() * (2020 - 1998) + 1998);
    }

    private void generaMarca() {
        String[] marcas = { "Chiwawa", "Waffles", "Caracoqueso", "Wachimingo" };
        int i = (int) (Math.random() * marcas.length);
        this.marca = marcas[i];
    }

    @Override
    public void ubicar(int fila, int columna) {
        setFila(fila);
        setColumna(columna);
    }
}
