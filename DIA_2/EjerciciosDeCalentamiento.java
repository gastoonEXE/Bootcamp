import java.util.Scanner;
import java.util.Random;

public class EjerciciosDeCalentamiento {

        public static void main(String[] args) {

        System.out.println("numeros curioso");

        Scanner Leer = new Scanner(System.in);
        String NRO;
        NRO = " ";
        
        while (!NRO.equals("exit")) {
            System.out.println("\nIngresa el ejercicio donde NN es el número de ejercicio con relleno de 0 a la izquierda, exit para salir");
            
            NRO = Leer.nextLine();

            System.out.println();

            switch (NRO) {
                case "01":
                    Ejercio01();
                    break;

                case "02":
                    Ejercio02();
                    break;

                case "03":
                    Ejercio03();
                    break;

                case "04":
                    Ejercio04();
                    break;

                default:
                    break;
            }

        }
        Leer.close();
    }
    
    public static void Ejercio01() {
            Random r = new Random();

            int[] MATRIZ = new int[10];

            int Mayor = 0;
            
            for (int index = 0; index < MATRIZ.length; index++) {
                MATRIZ[index] = r.nextInt(11)-5;
            }

            for (int index = 0; index < MATRIZ.length; index++) {
                System.out.print(MATRIZ[index] + " ");
            }

            for (int index = 0; index < MATRIZ.length; index++) {
                if (MATRIZ[index] > MATRIZ[Mayor]) {
                    Mayor = index;
                }
            }

            System.out.println();
            System.out.println("El mayor es: " + MATRIZ[Mayor]);

        }

    public static void Ejercio02() {
            Random r = new Random();

            int[] MATRIZ = new int[100];
            int[] REPITE = new int[61];

            int IndexGanador = 0;
            
            // se llena la matriz MATRIZ con números aleatorios entre -30 y 30
            for (int index = 0; index < MATRIZ.length; index++) {
                MATRIZ[index] = r.nextInt(61)-30;
            }

            // se imprime la matriz MATRIZ
            for (int index = 0; index < MATRIZ.length; index++) {
                System.out.print(MATRIZ[index] + " | ");
            }

            // se inicializa el arreglo REPITE en 0
            for (int index = 0; index < REPITE.length; index++) {
                REPITE[index] = 0;
            }
            
            // se llena el arreglo REPITE
            for (int index = 0; index < MATRIZ.length; index++) { // i= 0 
                    REPITE[MATRIZ[index] + 30]++;
                    //System.out.println("MATRIZ[" + index +"]: "+ MATRIZ[index] + " | REPITE ==>" + (MATRIZ[index] + 30) + " == " + REPITE[MATRIZ[index] + 30]);
            }

            for (int index = 0; index < REPITE.length; index++) {
                if (REPITE[index] > REPITE[IndexGanador]) {
                    IndexGanador = index;
                }
            }

            // se imprime la matriz REPITE
            // for (int index = 0; index < REPITE.length; index++) {
            //     System.out.println( index +" | "+ (index-30) + ": (" + REPITE[index] + ") ");
            // }

            System.out.println("\n");
            System.out.println("El elemento que más veces se repite es: " + (IndexGanador - 30) + " con " + REPITE[IndexGanador] + " repeticiones");

        }

    public static void Ejercio03() {
        
            String FRASE;
            Scanner Leer = new Scanner(System.in);


            System.out.println("Ingresa una frase");
            FRASE = Leer.nextLine();
            FRASE = FRASE.toUpperCase();

            int contador = 0;

            for (int index = 0; index < FRASE.length(); index++) {
                if (FRASE.charAt(index) != ' ') {
                    contador++;
                }
            }

            char[] PALINDROME = new char[contador];
            contador = 0;

            for (int index = 0; index < FRASE.length(); index++) {
                if (FRASE.charAt(index) != ' ') {
                    PALINDROME[contador] = FRASE.charAt(index);
                    contador++;
                }
            }

            boolean esPalindromo = true;

            for (int i = 0; i < PALINDROME.length; i++) {
                if (PALINDROME[i] != PALINDROME[PALINDROME.length - 1 - i]) {
                    esPalindromo = false;
                    break;
                }

            }

            if (esPalindromo) {
                System.out.println("Es un palíndromo");
            } else {
                System.out.println("No es un palíndromo");
            }


            Leer.reset();
        }

    public static void Ejercio04() {
        
            String NUMERO;
            Scanner Leer = new Scanner(System.in);

            

            System.out.println("Ingresa un Número");
            NUMERO = Leer.nextLine();
            
            int [] ARREGLO = new int[NUMERO.length()];

            for (int index = 0; index < NUMERO.length(); index++) {
                if (NUMERO.charAt(index) != ' ') {
                    ARREGLO[index] = NUMERO.charAt(index) - '0'; // Convertir el carácter a su valor numérico
                }
            }

            System.out.println("Los números del arreglo son: ");

            for (int i = 0; i < ARREGLO.length; i++) {
                System.out.print(ARREGLO[i] + " ");
            }

            Leer.reset();
        }
    
}