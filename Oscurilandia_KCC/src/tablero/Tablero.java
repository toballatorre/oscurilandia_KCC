package tablero;

import java.util.ArrayList;
import java.util.Arrays;

import firstline.*;
import seguridad_PKS.*;

public class Tablero {

    public final int CANTIDAD_KROMI = 3;
    public final int CANTIDAD_CAGUANO = 5;
    public final int CANTIDAD_TRUPALLA = 10;
    private final char[] margenes = { '╔', '╗', '╦', '║', '╠', '═', '╣', '╬', '╚', '╝', '╩' };

    public final int FILAS = 15;
    public final int COLUMNAS = 15;

    private Carro[] carros = new Carro[18];
    private ArrayList<Huevo> huevos;
    private IUbicable[][] tablero = new IUbicable[FILAS][COLUMNAS];

    public Tablero() {
        crearCarro();
    }

    private void crearCarro() {

        int cKromi = 0;
        int[] c;

        // Creamos las Kromis
        do {
            c = creaCoordenada();

            if (c[0] < (FILAS - 2) && estaVacia(c[0], c[1])) {// Si esta dentro del rango y esta vacio el punto de
                                                              // inicio

                if (estaVacia((c[0] + 1), c[1]) && estaVacia((c[0] + 2), c[1])) {// si esta vacio los demas

                    tablero[c[0]][c[1]] = new Kromi(3, 5, 12345, c[0], c[1], "K-" + cKromi, 1998, "Flaco");
                    tablero[c[0] + 1][c[1]] = tablero[c[0]][c[1]];
                    tablero[c[0] + 2][c[1]] = tablero[c[0]][c[1]];
                    cKromi++;
                }

            }

        } while (cKromi < CANTIDAD_KROMI);

        // Creamos los Caguanos
        int cCaguano = 0;
        do {
            c = creaCoordenada();

            if (c[1] < (COLUMNAS - 1) && estaVacia(c[0], c[1])) {// Si esta dentro del rango y esta vacio el punto de
                                                                 // inicio

                if (estaVacia(c[0], (c[1] + 1))) {// si esta vacio lo demas

                    tablero[c[0]][c[1]] = new Caguano(2, 7, 98765, c[0], c[1], "C-" + cCaguano, 1998, "Flaco");
                    tablero[c[0]][c[1] + 1] = tablero[c[0]][c[1]];
                    cCaguano++;
                }

            }

        } while (cCaguano < CANTIDAD_CAGUANO);

        // Creamos los Trupallas
        int cTrupalla = 0;
        do {
            c = creaCoordenada();

            if (estaVacia(c[0], c[1])) {// Si esta vacio

                tablero[c[0]][c[1]] = new Trupalla(1, 1, 768586, c[0], c[1], "T-" + cTrupalla, 1, "Grackor");
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
    
    public void mostrarMatriz() {
        for (int i = 0; i <= COLUMNAS * 2; i++) {

            if (i % 2 == 0) {
                if (i == 0)
                    System.out.print(margenes[0]);
                else {
                    if (i == FILAS * 2)
                        System.out.print(margenes[1] + "\n");
                    else
                        System.out.print(margenes[2]);
                }
            } else {
                System.out.print(margenes[5]);
            }
        }
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(margenes[3]);
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
                if (j == COLUMNAS - 1)
                    System.out.print(margenes[3] + "\n");

            }
            if (i != FILAS - 1) {
                for (int j = 0; j <= COLUMNAS * 2; j++) {

                    if (j % 2 == 0) {
                        if (j == 0)
                            System.out.print(margenes[4]);
                        else {
                            if (j == COLUMNAS * 2)
                                System.out.print(margenes[6] + "\n");
                            else
                                System.out.print(margenes[7]);
                        }
                    } else {
                        System.out.print(margenes[5]);
                    }
                }
            } else {
                for (int j = 0; j <= COLUMNAS * 2; j++) {

                    if (j % 2 == 0) {
                        if (j == 0)
                            System.out.print(margenes[8]);
                        else {
                            if (j == COLUMNAS * 2)
                                System.out.print(margenes[9] + "\n");
                            else
                                System.out.print(margenes[10]);
                        }
                    } else {
                        System.out.print(margenes[5]);
                    }
                }

            }
        }
    }

}
