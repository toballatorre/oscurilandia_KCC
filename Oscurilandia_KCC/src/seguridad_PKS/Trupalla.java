package seguridad_PKS;

public class Trupalla extends Carro {

    // Atributos
    private final int TAMANO = 1;
    private int armadura;
    private String nombrePiloto;

    // Constructor

    /**
     * @param cantidadOcupantes
     * @param id
     * @param armadura
     * @param nombrePiloto
     */
    public Trupalla(String id, String nombrePiloto) {
        super(1, id);
        setTamano(TAMANO);
        generaArmadura();
        this.nombrePiloto = nombrePiloto;
    }

    // Metodos Get and Set
    @Override
    public char getTipo() {
        return 'T';
    }

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

    /**
     * @param nombrePiloto the nombrePiloto to set
     */
    public void setNombrePiloto(String nombrePiloto) {
        this.nombrePiloto = nombrePiloto;
    }

    private void generaArmadura() {
        this.armadura = (int) (Math.random() * 5 + 1);
    }

    @Override
    public void ubicar(int fila, int columna) {
        setFila(fila);
        setColumna(columna);
    }
}