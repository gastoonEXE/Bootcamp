package NimJava;

import java.util.Scanner;

public class Nim {

    public static void main(String[] args) {
        Scanner Leer = new Scanner(System.in);

        System.out.print("Jugador 1, ingrese su nombre: ");
        
        Jugador Jugador1 = new Jugador(Leer.nextLine());
        
        System.out.print("Jugador 2, ingrese su nombre: ");

        Jugador Jugador2 = new Jugador(Leer.nextLine());

        Tablero tablero = new Tablero();

        tablero.mostrarTablero();

        Jugador1.setTurno(true);
        Jugador2.setTurno(false);

        char pila;
        int cantidad;

        while (tablero.estaVacio() == false) {
            
            if (Jugador1.EsMiTurno()) {
                do {
                    System.out.print(Jugador1.getNombre() + ", elija una pila: ");
                    pila = Leer.next().toUpperCase().charAt(0);
                    System.out.print("Cuantos quitara de la pila " + pila + ": ");
                    cantidad = Leer.nextInt();   

                } while (tablero.quitarFichas(pila, cantidad) == false);
                tablero.mostrarTablero();
                Jugador1.siguienteTurno();
                Jugador2.siguienteTurno();
                if (tablero.estaVacio() == true) {
                    System.out.println(Jugador2.getNombre() + ", ya no quedan contadores, asi que... Ganaste!");
                }
            }
            else {

                do {
                    System.out.print(Jugador2.getNombre() + ", elija una pila: ");
                    pila = Leer.next().toUpperCase().charAt(0);
                    System.out.print("Cuantos quitara de la pila " + pila + ": ");
                    cantidad = Leer.nextInt();                    
                } while (tablero.quitarFichas(pila, cantidad) == false);

                tablero.mostrarTablero();
                Jugador1.siguienteTurno();
                Jugador2.siguienteTurno();
                if (tablero.estaVacio() == true) {
                    System.out.println(Jugador1.getNombre() + ", ya no quedan contadores, asi que... Ganaste!");
                }
            }
        }

        Leer.close();
    }


}
