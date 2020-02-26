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
    public Trupalla(String id, int fila, int columna) {
        super(id, fila, columna);
        setCantidadOcupantes(1);
        setTamano(TAMANO);
        generaArmadura();
        generaNombre();
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

    private void generaNombre() {
        String[] nombres = { "Pepe", "Juan", "Antonia", "Destroyer", "Goliath", "Karla", "Shina" };
        int i = (int) (Math.random() * nombres.length);
        this.nombrePiloto = nombres[i];
    }

    /**
     * 
     */
    private void generaArmadura() {
        this.armadura = (int) (Math.random() * 5 + 1);
    }
}