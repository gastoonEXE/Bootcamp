
import java.util.Random;
import java.util.Scanner;

public class VacasYToros {

    public static void main(String[] args) {
        
        int [] MATRIZ = new int[4] ;
        int [] ENTRADA = new int[4] ;
        Random r = new Random();
        Scanner Leer = new Scanner(System.in);

        for (int index = 0; index < MATRIZ.length; index++) {
            
            int x = r.nextInt(9)+1;
            
            if (index == 0) {
                MATRIZ[index] = x;
            }
            else
            {
                while(BUSCA(MATRIZ, x) == 1){
                    x = r.nextInt(9)+1;
                }
                MATRIZ[index] = x;
            }
            //System.out.println(MATRIZ[index]);
        }
        //System.out.println("");

        // for (int index = 0; index < MATRIZ.length; index++) {
        //     System.out.print(MATRIZ[index]+"");
        // }
        System.out.println("\nIngresa 4 numeros sin separaciones");

        String NUMERO = Leer.nextLine();

        while(NUMERO.length() != 4 || LETRAS(NUMERO)) {
            System.out.println("La entrada es incorrecta, Ingresa 4 numeros sin separaciones");
            NUMERO = Leer.nextLine();
        }

        int Vacas;
        int Toros;

        ENTRADA[0] = (int) NUMERO.charAt(0) - 48;
        ENTRADA[1] = (int) NUMERO.charAt(1) - 48;
        ENTRADA[2] = (int) NUMERO.charAt(2) - 48;
        ENTRADA[3] = (int) NUMERO.charAt(3) - 48;


        do {
            Vacas = 0;
            Toros = 0;

            for (int index = 0; index < MATRIZ.length; index++) {
                if (MATRIZ[index] == ENTRADA[index]) {
                    Toros++;
                }
                else{
                    if(BUSCA(MATRIZ, ENTRADA[index]) == 1){
                        Vacas++;
                    }
                }
            }     
            System.out.println("\n" + Vacas + " Vacas, " + Toros + " Toros."); 
            if (Toros != 4) {
                System.out.println("Por favor, intente de nuevo: ");
                NUMERO = Leer.nextLine();

                while(NUMERO.length() != 4 || LETRAS(NUMERO)) {
                    System.out.println("La entrada es incorrecta, Ingresa 4 numeros sin separaciones");
                    NUMERO = Leer.nextLine();
                }

                ENTRADA[0] = (int) NUMERO.charAt(0) - 48;
                ENTRADA[1] = (int) NUMERO.charAt(1) - 48;
                ENTRADA[2] = (int) NUMERO.charAt(2) - 48;
                ENTRADA[3] = (int) NUMERO.charAt(3) - 48;                               
            }
        } while (Toros != 4);


        //System.out.println(NUMERO);
        System.out.println("\n¡Felicidades! El número secreto era: ");
        for (int i : ENTRADA) {
            System.out.print(i + " ");
        }
        Leer.close();
    }

    public static int BUSCA(int[] MATRIZ, int X) { //funcion busca en el array
        int re = 0;
        for (int index = 0; index < MATRIZ.length; index++) {
            if (MATRIZ[index] == X){
                re = 1;
            }
        }
        // si en el Array no existe ese numero, retorna 0
        return re;
    }

    public static boolean LETRAS(String NUMERO) {
        boolean re = false;
        for (int i = 0; i < NUMERO.length(); i++) {
            if((int) NUMERO.charAt(i) - 48 > 9 || (int) NUMERO.charAt(i) - 48 < 0){
                re = true;
            }
        }
        return re;
    }
    
}