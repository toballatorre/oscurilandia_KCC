package tablero;

import tablero.HerramientasMain;

public class Main {

    public static void main(String[] args) {

        // Bucle de opcion de menus
        boolean salirMenu = false;
        Tablero camaraSecreta = new Tablero();// Se crea el tablero con los carros

        do {

            boolean continuar = true;
            int op = HerramientasMain.ingresarOpcion();

            switch (op) {
            case 1: // MUESTRA LA LISTA DE CARROS
                camaraSecreta.mostrarListaCarros();

                break;
            case 2: // MUESTRA EL TABLERO CON LAS UBICACIONES
                camaraSecreta.mostrarMatriz(false);
                break;

            case 3: // JUEGO LANZAR HUEVOS
                do {
                    continuar = HerramientasMain.jugarLanzarHuevos(camaraSecreta);
                } while (continuar);

                System.out.println("\n" + "PUNTAJE TOTAL: " + camaraSecreta.getPuntajeTotal());

                break;
            case 4:
                System.out.println("Adios!");
                salirMenu = true;
                break;
            }
            System.out.println("");
            
        } while (!salirMenu);

    } // FIN MAIN
}