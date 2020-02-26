/**
 * Clase hija de Carro que implementa la interface IIdentificable
 */
package seguridad_PKS;

/**
 * @author KCC
 */
public class Trupalla extends Carro {

    // ========== ATRIBUTOS ===========

    private final int TAMANO = 1;
    private int armadura;
    private String nombrePiloto;

    // ========== CONSTRUCTOR ==========

    /**
     * @param cantidadOcupantes
     * @param id
     * @param armadura
     * @param nombrePiloto
     */
    public Trupalla(String id, int fila, int columna) {
        super(id, fila, columna);
        setCantidadOcupantes(1);
        setTamano(TAMANO);
        generaArmadura();
        generaNombre();
    }

    // ========== GET SET ==========

    /**
     * @return the armadura
     */
    public int getArmadura() {
        return armadura;
    }

    /**
     * @param armadura the armadura to set
     */
    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }

    /**
     * @return the nombrePiloto
     */
    public String getNombrePiloto() {
        return nombrePiloto;
    }
    
    // ========== METODOS ==========

    /**
     * @param nombrePiloto the nombrePiloto to set
     */
    public void setNombrePiloto(String nombrePiloto) {
        this.nombrePiloto = nombrePiloto;
    }
    
    /**
     * Genera un nombre aleatorio de entre la lista de nombres que se dispone
     */
    private void generaNombre() {
        String[] nombres = { "Pepe", "Juan", "Antonia", "Destroyer", "Goliath", "Karla", "Shina" };
        int i = (int) (Math.random() * nombres.length);
        this.nombrePiloto = nombres[i];
    }

    /**
     * Genera de manera aleatoria el nivel de armadura entre 1 y 5
     */
    private void generaArmadura() {
        int min = 1;
        int max = 5;
        this.armadura = (int) (Math.random() * max + min);
    }

    // ========== HEREDADO INTERFACE IIDENTIFICABLE ==========
    @Override
    public char getTipo() {
        return 'T';
    }
}