package NimJava;

public class Tablero {
    private int A;
    private int B;
    private int C;

    public Tablero() {
        this.A = 3;
        this.B = 4;
        this.C = 5;
    }

    public boolean quitarFichas(char pila, int cantidad) {
        if (pila == 'A' && cantidad <= A) {
            A = A - cantidad;
            return true;
        } else if (pila == 'B' && cantidad <= B) {
            B = B - cantidad;
            return true;
        } else if (pila == 'C' && cantidad <= C) {
            C = C - cantidad;
            return true;
        } else {
            System.out.println();
            System.out.println("Movimiento inválido");
            System.out.println();
            return false;
        }
    }
    
    public boolean estaVacio() {
        return A == 0 && B == 0 && C == 0;
    }

    public void mostrarTablero() {
        System.err.println();
        System.out.println("A: " + A + "    B: " + B + "    C: " + C);
        System.err.println();
    }
    
}
