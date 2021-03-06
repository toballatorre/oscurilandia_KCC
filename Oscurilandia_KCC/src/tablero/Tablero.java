package tablero;

import java.util.ArrayList;

import firstline.*;
import seguridad_PKS.*;

public class Tablero {

    // ========== CONSTANTES ==========

    public final int CANTIDAD_KROMI = 3;
    public final int CANTIDAD_CAGUANO = 5;
    public final int CANTIDAD_TRUPALLA = 10;
    public final int FILAS = 15;
    public final int COLUMNAS = 15;

    // ========== ATRIBUTOS ==========

    private ArrayList<Carro> carros = new ArrayList<Carro>();
    private ArrayList<Huevo> huevos = new ArrayList<Huevo>();
    private IIdentificable[][] tablero = new IIdentificable[FILAS][COLUMNAS];
    private int puntajeTotal;

    // =========== CONSTRUCTOR ==========

    public Tablero() {
        crearCarro();
        this.puntajeTotal = 0;
    }

    // ========== GET ==========

    /**
     * @return the FILAS
     */
    public int getFILAS() {
        return FILAS;
    }

    /**
     * @return the COLUMNAS
     */
    public int getCOLUMNAS() {
        return COLUMNAS;
    }

    public int getPuntajeTotal() {
        this.puntajeTotal = totalPuntaje();
        return puntajeTotal;
    }

    // ========== METODOS ==========
    
    /**
     * Muestra la lista de carros por tipo
     */
    public void mostrarListaCarros() {

        // Imprimir las Kromis
        System.out.printf("%10s %n", String.format("%4s %19s %14s %10s %16s %s", "id", "Cantidad Ocupantes",
                "Fecha Ingreso", "Ubicacion", "Ano Fabricacion", "Marca"));
        for (Carro carro : carros) {
            if (carro.getTipo() == 'K') {
                System.out.printf("%10s %n", carro.toString());
            }
        }
        System.out.println("");
        // Imprimir los Caguanos
        System.out.printf("%10s %n", String.format("%4s %19s %14s %10s %16s %s", "id", "Cantidad Ocupantes",
                "Fecha Ingreso", "Ubicacion", "Alcance de tiro", "Color Confetti"));
        for (Carro carro : carros) {
            if (carro.getTipo() == 'C') {
                System.out.printf("%10s %n", carro.toString());
            }
        }
        System.out.println("");
        // Imprimir los Trupalla
        System.out.printf("%10s %n", String.format("%4s %19s %14s %10s %16s %s", "id", "Cantidad Ocupantes",
                "Fecha Ingreso", "Ubicacion", "Armadura", "Nombre Piloto"));
        for (Carro carro : carros) {
            if (carro.getTipo() == 'T') {
                System.out.printf("%10s %n", carro.toString());
            }
        }
    }

    /**
     * Suma todos los puntajes de los huevos de la lista.
     * 
     * @return la suma total del puntaje
     */
    private int totalPuntaje() {
        int totalPuntaje = 0;
        for (Huevo huevo : this.huevos) {
            totalPuntaje += huevo.getPuntaje();
        }
        return totalPuntaje;
    }

    /**
     * Muestra de manera formateada la informacion de cada carro
     */
    public void muestraCarros() {
        for (Carro carro : this.carros) {
            System.out.print("[" + carro.getId() + "]");
        }
    }

    /**
     * Crea un huevo si el lugar esta vacio u ocupado por algun objeto y reemplaza
     * el objeto en la ubicacion por un huevo y lo agrega a la lista de huevos
     * 
     * @param fila
     * @param columna
     */
    public void crearHuevo(int fila, int columna) {
        // Si esta vacia O es un huevo crea el huevo con 0 puntos
        if (estaVacia(fila, columna) || tablero[fila][columna].getTipo() == 'H') {
            tablero[fila][columna] = new Huevo(fila, columna);

            // Si no esta vacia y no es un huevo crea el huevo con puntaje segun tipo de
            // carro
        } else {
            Carro c = (Carro) tablero[fila][columna];
            c.quitaVida();
            tablero[fila][columna] = new Huevo(fila, columna, c.getTipo(), c.getTamano());
        }

        // Ingresa el huevo en la lista de huevos
        Huevo h = (Huevo) tablero[fila][columna];
        huevos.add(h);
        String coordenada = String.format("(%d,%d)", h.getFila(), h.getColumna());
        System.out.println("\n" + "EL PUNTAJE DEL HUEVO ES: ");
        System.out.printf(String.format("%8s %9s %n", "Ubicacion", "Puntaje"));
        System.out.printf(String.format("%8s %5d %n", coordenada, h.getPuntaje()));
        System.out.println("");
    }

    /**
     * Crea los carros y los agrega en la matriz y en el arreglo carros
     */
    private void crearCarro() {
        int[] coordenada;

        // ========== CREAN KROMIS ==========

        int cKromi = 0;
        do {
            coordenada = creaCoordenada();
            // Confirma si esta dentro del rango y si esta vacio el espacio
            if (coordenada[0] < (FILAS - 2) && estaVacia(coordenada[0], coordenada[1])) {

                // Confirma si los demas espacios estan vacios, luego ingresa el carro
                if (estaVacia((coordenada[0] + 1), coordenada[1]) && estaVacia((coordenada[0] + 2), coordenada[1])) {

                    tablero[coordenada[0]][coordenada[1]] = new Kromi("K-" + cKromi, coordenada[0], coordenada[1]);
                    tablero[coordenada[0] + 1][coordenada[1]] = tablero[coordenada[0]][coordenada[1]];
                    tablero[coordenada[0] + 2][coordenada[1]] = tablero[coordenada[0]][coordenada[1]];
                    Carro k = (Carro) tablero[coordenada[0]][coordenada[1]];
                    carros.add(k);
                    cKromi++;
                }

            }

        } while (cKromi < CANTIDAD_KROMI);

        // ========== CREAN CAGUANOS ==========

        int cCaguano = 0;
        do {
            coordenada = creaCoordenada();

            // Confirma si esta dentro del rango y si esta vacio el espacio
            if (coordenada[1] < (COLUMNAS - 1) && estaVacia(coordenada[0], coordenada[1])) {

                // Confirma si el siguiente espacio esta vacio, luego ingresa el carro
                if (estaVacia(coordenada[0], (coordenada[1] + 1))) {

                    tablero[coordenada[0]][coordenada[1]] = new Caguano("C-" + cCaguano, coordenada[0], coordenada[1]);
                    tablero[coordenada[0]][coordenada[1] + 1] = tablero[coordenada[0]][coordenada[1]];
                    Carro c = (Carro) tablero[coordenada[0]][coordenada[1]];
                    carros.add(c);
                    cCaguano++;
                }

            }

        } while (cCaguano < CANTIDAD_CAGUANO);

        // ========== CREAN CAGUANO ==========

        int cTrupalla = 0;
        do {
            coordenada = creaCoordenada();

            // Confirma si el espacio esta vacio
            if (estaVacia(coordenada[0], coordenada[1])) {

                tablero[coordenada[0]][coordenada[1]] = new Trupalla("T-" + cTrupalla, coordenada[0], coordenada[1]);
                Carro t = (Carro) tablero[coordenada[0]][coordenada[1]];
                carros.add(t);
                cTrupalla++;
            }

        } while (cTrupalla < CANTIDAD_TRUPALLA);

    }

    /**
     * Avisa si el espacio esta vacio o no
     * 
     * @param fila
     * @param columna
     * @return retorna si esta vacio true si esta lleno false
     */
    private boolean estaVacia(int fila, int columna) {
        if (tablero[fila][columna] != null)
            return false;
        else
            return true;
    }

    /**
     * Genera una coordenada de manera aleatoria
     * 
     * @return retorna un arreglo con dos cifras, fila=0 y columna=1
     */
    private int[] creaCoordenada() {
        int[] coordenada = new int[2];

        coordenada[0] = (int) (Math.random() * FILAS);
        coordenada[1] = (int) (Math.random() * COLUMNAS);

        return coordenada;
    }

    /**
     * Muestra la matriz en pantalla con los carros y lo que haya dentro que sea
     * IUbicable
     */
    public void mostrarMatriz(boolean oculta) {

        // ========== MARGEN SUPERIOR ╔═╦═╦═╦═╦═╦═╦═╦═╦═╦═╦═╦═╦═╦═╦═╗
        System.out.printf("%3s", " ");

        for (int i = 0; i < COLUMNAS; i++) {
            if (i != COLUMNAS - 1)
                System.out.printf("%4s", i + " ");
            else
                System.out.printf("%4s %n", i + " ");
        }

        System.out.printf("%3s", " ");
        for (int i = 0; i <= COLUMNAS * 2; i++) {

            if (i % 2 == 0) {
                if (i == 0)
                    System.out.print('╔'); // ╔
                else {
                    if (i == FILAS * 2)
                        System.out.print('╗' + "\n"); // ╗
                    else
                        System.out.print('╦'); // ╦
                }
            } else {
                System.out.print("═══"); // ═
            }
        }

        // ========== MARGEN Y CONTENIDO ║K║T║ ║ ║ ║ ║ ║ ║T║ ║T║ ║ ║ ║K║

        for (int i = 0; i < FILAS; i++) {
            System.out.printf("%3s", i + " ");
            for (int j = 0; j < COLUMNAS; j++) {

                // Margen antes del contenido
                System.out.print('║'); // ║

                // Muestra el contenido vacio o no
                if (estaVacia(i, j) || (oculta && tablero[i][j].getTipo() != 'H'))
                    System.out.print("   ");
                else {
                    System.out.print(" " + tablero[i][j].getTipo() + " ");
                }
                // Margen al final del contenido y salto de linea
                if (j == COLUMNAS - 1) {
                    System.out.print('║' + "\n"); // ║
                }

            }

            // ========== MARGEN SEPARADOR DE FILAS ╠═╬═╬═╬═╬═╬═╬═╬═╬═╬═╬═╬═╬═╬═╬═╣

            if (i != FILAS - 1) {
                System.out.printf("%3s", " ");
                for (int j = 0; j <= COLUMNAS * 2; j++) {

                    if (j % 2 == 0) {
                        if (j == 0)
                            System.out.print('╠'); // ╠
                        else {
                            if (j == COLUMNAS * 2)
                                System.out.print('╣' + "\n"); // ╣
                            else
                                System.out.print('╬'); // ╬
                        }
                    } else {
                        System.out.print("═══"); // ═
                    }
                }
                // ========== MARGEN INFERIOR ╚═╩═╩═╩═╩═╩═╩═╩═╩═╩═╩═╩═╩═╩═╩═╝
            } else {
                System.out.printf("%3s", " ");
                for (int j = 0; j <= COLUMNAS * 2; j++) {

                    if (j % 2 == 0) {
                        if (j == 0)
                            System.out.print('╚');// ╚
                        else {
                            if (j == COLUMNAS * 2)
                                System.out.print('╝' + "\n"); // ╝

                            else
                                System.out.print('╩'); // ╩
                        }
                    } else {
                        System.out.print("═══"); // ═
                    }
                }
            }
        }
    }

}// ========== FIN CLASE TABLERO ==========
