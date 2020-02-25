package tablero;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Tablero camaraSecreta = new Tablero();
        camaraSecreta.mostrarMatriz();

        int fila;
        int columna;
        String op;
        boolean continuar = true;

        do {
            System.out.println("Ingrese coordenadas entre 0..14");
            Scanner entrada = new Scanner(System.in);
                fila = entrada.nextInt();
                columna = entrada.nextInt();

            camaraSecreta.crearHuevo(fila, columna);
            camaraSecreta.mostrarMatriz();

            System.out.println("Desea continuar? (s/n)");
            op = entrada.next();
            if (!op.equals("s")) {
                continuar = false;
            }

        } while (continuar);

        camaraSecreta.muestraHuevos();
        camaraSecreta.muestraCarros();

    }

}
