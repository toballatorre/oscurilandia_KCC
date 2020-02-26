/**
 * Esta clase contiene metodos que usa la clase Main para limpiar la visual y 
 * que se vea bien bonito ;)
 */
package tablero;

import java.util.Scanner;

class HerramientasMain {

    private static Scanner entradaOpcion;
    private static Scanner entradaSeguirLanzando;
    private static Scanner entradaUbicacion;

    /**
     * Este es el juego de lanzar huevos
     * 
     * @param tablero
     * @return
     */
    public static boolean jugarLanzarHuevos(Tablero tablero) {
        // Se ingresa por consola la ubicacion donde se lanzara el huevo
        tablero.mostrarMatriz(false);
        HerramientasMain.lanzarHuevo(tablero);

        // continuar lanzando huevos?
        System.out.println("Desea continuar? (s/n)");
        return HerramientasMain.seguirLanzando();
    }

    /**
     * Metodo para lanzar los huevos.
     * 
     * @param tablero para lanzar los huevo ahi
     */
    public static void lanzarHuevo(Tablero tablero) {

        int fila;
        int columna;

        System.out.println("Ingrese la fila: ");
        fila = ingresarUbicacion(tablero.getFILAS());
        System.out.println("Ingrese la columna: ");
        columna = ingresarUbicacion(tablero.getCOLUMNAS());

        tablero.crearHuevo(fila, columna);
    }

    public static int ingresarOpcion() {
        entradaOpcion = new Scanner(System.in);
        int numero; // Variable nuemrica
        do {
            System.out.println("Ingrese una opcion");
            System.out.println("1. Mostrar lista de carros");
            System.out.println("2. Mostrar tablero con las ubicaciones");
            System.out.println("3. Lanzar huevos");
            System.out.println("4. Salir");

            while (!entradaOpcion.hasNextInt()) {
                System.out.println("Ingrese un numero.");
                entradaOpcion.next();
            }

            numero = entradaOpcion.nextInt();
        } while (numero < 1 || numero > 4); // mientras numero es menor a 1 o numero es mayor 4, continua
        return numero;
    }

    /**
     * Retorna un booleano si quiere seguir o no lanzando huevos
     * 
     * @return true para seguir, false para no
     */
    public static boolean seguirLanzando() {
        entradaSeguirLanzando = new Scanner(System.in);
        char letra; // Variable char

        do {
            while (entradaSeguirLanzando.hasNextInt()) {
                System.out.println("Ingrese una letra.");
                entradaSeguirLanzando.next();
            }

            letra = entradaSeguirLanzando.next().toLowerCase().charAt(0);

        } while (!(letra == 's' || letra == 'n'));

        if (letra == 's')
            return true;
        else
            return false;
    }

    /**
     * Metodo para ingresar de manera segura las coordenadas por consola dentro del
     * rango del tablero y que sea un numero positivo y no una letra
     * 
     * @param limite
     * @return
     */
    public static int ingresarUbicacion(int limite) {
        entradaUbicacion = new Scanner(System.in);
        int numero; // Variable nuemrica
        do {
            System.out.print("Un valor entre 0.." + (limite - 1) + ": ");

            while (!entradaUbicacion.hasNextInt()) {
                System.out.println("Ingrese un numero.");
                entradaUbicacion.next();
            }

            numero = entradaUbicacion.nextInt();
        } while (numero < 0 || numero > limite - 1); // mientras numero es 0 continua o numero es mayor 14
        return numero;
    }

}
