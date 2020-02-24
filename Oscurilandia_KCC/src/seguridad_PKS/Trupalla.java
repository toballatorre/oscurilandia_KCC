package seguridad_PKS;

public class Trupalla extends Carro {

    // Atributos
    private int armadura;
    private String nombrePiloto;

    // Constructor
    /**
     * @param tamano
     * @param cantidadOcupantes
     * @param fechaIngreso
     * @param fila
     * @param columna
     * @param id
     * @param armadura
     * @param nombrePiloto
     */
    public Trupalla(int tamano, int cantidadOcupantes, int fechaIngreso, int fila, int columna, String id, int armadura,
            String nombrePiloto) {
        super(tamano, cantidadOcupantes, fechaIngreso, id);
        this.armadura = armadura;
        this.nombrePiloto = nombrePiloto;
        ubicar(fila, columna);
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

    @Override
    public void ubicar(int fila, int columna) {
        setFila(fila);
        setColumna(columna);
    }
}