package tablero;

import java.util.ArrayList;

import firstline.*;
import seguridad_PKS.*;

public class Tablero {

    public final int CANTIDAD_KROMI = 3;
    public final int CANTIDAD_CAGUANO = 5;
    public final int CANTIDAD_TRUPALLA = 10;
    private final char[] MARGENES = { '╔', '╗', '╦', '║', '╠', '═', '╣', '╬', '╚', '╝', '╩' };

    public final int FILAS = 15;
    public final int COLUMNAS = 15;

    private ArrayList<Carro> carros;
    private ArrayList<Huevo> huevos;
    private IUbicable[][] tablero = new IUbicable[FILAS][COLUMNAS];

    public Tablero() {
        crearCarro();
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

                    tablero[coordenada[0]][coordenada[1]] = new Kromi(3, 5, 12345, coordenada[0], coordenada[1],
                            "K-" + cKromi, 1998, "Flaco");
                    tablero[coordenada[0] + 1][coordenada[1]] = tablero[coordenada[0]][coordenada[1]];
                    tablero[coordenada[0] + 2][coordenada[1]] = tablero[coordenada[0]][coordenada[1]];
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

                    tablero[coordenada[0]][coordenada[1]] = new Caguano(2, 7, 98765, coordenada[0], coordenada[1],
                            "C-" + cCaguano, 1998, "Flaco");
                    tablero[coordenada[0]][coordenada[1] + 1] = tablero[coordenada[0]][coordenada[1]];
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

                tablero[coordenada[0]][coordenada[1]] = new Trupalla(1, 1, 768586, coordenada[0], coordenada[1],
                        "T-" + cTrupalla, 1, "Grackor");
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
    public void mostrarMatriz() {

        // ========== MARGEN SUPERIOR ╔═╦═╦═╦═╦═╦═╦═╦═╦═╦═╦═╦═╦═╦═╦═╗

        for (int i = 0; i <= COLUMNAS * 2; i++) {

            if (i % 2 == 0) {
                if (i == 0)
                    System.out.print(MARGENES[0]); // ╔
                else {
                    if (i == FILAS * 2)
                        System.out.print(MARGENES[1] + "\n"); // ╗
                    else
                        System.out.print(MARGENES[2]); // ╦
                }
            } else {
                System.out.print(MARGENES[5]); // ═
            }
        }

        // ========== MARGEN Y CONTENIDO ║K║T║ ║ ║ ║ ║ ║ ║T║ ║T║ ║ ║ ║K║

        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {

                // Margen antes del contenido
                System.out.print(MARGENES[3]); // ║

                // Muestra el contenido vacio o no
                if (estaVacia(i, j))
                    System.out.print(" ");
                else {
                    if (tablero[i][j].getTipo() == 'K') {
                        System.out.print("K");
                    }
                    if (tablero[i][j].getTipo() == 'C') {
                        System.out.print("C");
                    }
                    if (tablero[i][j].getTipo() == 'T') {
                        System.out.print("T");
                    }
                }
                // Margen al final del contenido y salto de linea
                if (j == COLUMNAS - 1)
                    System.out.print(MARGENES[3] + "\n"); // ║

            }

            // ========== MARGEN SEPARADOR DE FILAS ╠═╬═╬═╬═╬═╬═╬═╬═╬═╬═╬═╬═╬═╬═╬═╣

            if (i != FILAS - 1) {
                for (int j = 0; j <= COLUMNAS * 2; j++) {

                    if (j % 2 == 0) {
                        if (j == 0)
                            System.out.print(MARGENES[4]); // ╠
                        else {
                            if (j == COLUMNAS * 2)
                                System.out.print(MARGENES[6] + "\n"); // ╣
                            else
                                System.out.print(MARGENES[7]); // ╬
                        }
                    } else {
                        System.out.print(MARGENES[5]); // ═
                    }
                }
                // ========== MARGEN INFERIOR ╚═╩═╩═╩═╩═╩═╩═╩═╩═╩═╩═╩═╩═╩═╩═╝
            } else {
                for (int j = 0; j <= COLUMNAS * 2; j++) {

                    if (j % 2 == 0) {
                        if (j == 0)
                            System.out.print(MARGENES[8]);// ╚
                        else {
                            if (j == COLUMNAS * 2)
                                System.out.print(MARGENES[9] + "\n"); // ╝
                            else
                                System.out.print(MARGENES[10]); // ╩
                        }
                    } else {
                        System.out.print(MARGENES[5]); // ═
                    }
                }

            }
        }
    }

}// ========== FIN CLASE TABLERO ==========
