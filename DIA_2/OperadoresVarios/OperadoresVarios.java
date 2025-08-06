

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class OperadoresVarios {

    
    public static void main(String[] args) {
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

                case "05":
                    Ejercio05();
                    break;

                case "06":
                    Ejercio06();
                    break;

                case "07":
                    Ejercio07();
                    break;

                case "08":
                    Ejercio08();
                    break;

                case "09":
                    Ejercio09();
                    break;

                case "10":
                    Ejercio10();
                    break;

                default:
                    break;
            }

        }
        Leer.close();
    }


    public static void Ejercio01() {
        
            Number var1 = 0;
            Number var2 = 0;
            Scanner Leer = new Scanner(System.in);

            System.out.println("Ingresa 1 numero");
            var1 = Leer.nextInt();
            System.out.println("Ingresa otro numero");
            var2 = Leer.nextInt();

            int SUMA = var1.intValue() + var2.intValue();
            int RESTA = var1.intValue() - var2.intValue();
            int MULT = var1.intValue() * var2.intValue();
            float DIV = var1.floatValue() / var2.floatValue();
            int MOD = var1.intValue() % var2.intValue();
            
            System.out.println("Su Suma es: "+ SUMA);
            System.out.println("Su Resta es: "+ RESTA);
            System.out.println("Su Multiplicación es: "+ MULT);
            System.out.println("Su División es: "+ DIV);
            System.out.println("Su Módulo es: "+ MOD);

            Leer.reset();
        }
    
    public static void Ejercio02() {
        
            Number var1 = 0;
            Number var2 = 0;
            Scanner Leer = new Scanner(System.in);

            System.out.println("Ingresa 1 numero");
            var1 = Leer.nextInt();
            System.out.println("Ingresa otro numero");
            var2 = Leer.nextInt();

            int A = var1.intValue();
            int B = var2.intValue();

            if (A == B) {
                System.out.println("Los numeros son Iguales");
            }
            else if (A > B) {
                System.out.println("El numero mayor es: " + A);                
            }
            else{
                System.out.println("El numero mayor es: " + B);
            }

            Leer.reset();
        }
    public static void Ejercio03() {
        
            String var1 = "Alexis Canete";

            System.out.println("\"Bienvenido " + var1 +"\"");

        }

    public static void Ejercio04() {
        
            String var1;
            Scanner Leer = new Scanner(System.in);

            System.out.println("Tu nombre");
            var1 = Leer.nextLine();

            System.out.println("\"Bienvenido " + var1 +"\"");

            Leer.reset();
        }

    public static void Ejercio05() {
        
            Number var1 = 0;
            Scanner Leer = new Scanner(System.in);

            System.out.println("Ingresa 1 numero");
            var1 = Leer.nextInt();

            int A = var1.intValue();

            if (A % 2 == 0) {
                System.out.println("El número SI es divisible entre 2");
            }
            else{
                System.out.println("El número NO es divisible entre 2");
            }

            Leer.reset();
        }

    public static void Ejercio06() {
        
            Number var1 = 0;
            Scanner Leer = new Scanner(System.in);

            System.out.println("Ingresa el precio de un producto");
            var1 = Leer.nextFloat();

            float A = var1.floatValue();
            final float IVA = (float) 0.1;

            float RESULT = A + (A*IVA);

            System.out.println("El precio final con IVA es: "+ RESULT );

            Leer.reset();
        }

    public static void Ejercio07() {
        
            for (int index = 0; index <= 100; index++) {
                if (index % 2 == 0 || index % 3 == 0) {
                    System.out.print(index + ", ");
                }
            }
            System.out.println();
        }

    public static void Ejercio08() {
        
            Number var1 = 0;
            Scanner Leer = new Scanner(System.in);
            int A;

            do {
                System.out.println("Ingresa 1 numero");
                var1 = Leer.nextInt();
                A = var1.intValue();                
            } while (A <= 0);

            System.out.println(A);

            Leer.reset();
        }

    public static void Ejercio09() {
        
            String CONTRA = "hola1234";
            String PASS;
            Scanner Leer = new Scanner(System.in);
            int TRY = 0;

            while(TRY < 3){
                System.out.println("Ingresa la Contrasena:");
                PASS = Leer.nextLine();
                if (PASS.equals(CONTRA)) {
                    System.out.println("Correcto!");
                    TRY = 4;
                } else {
                    System.out.println("Fallaste jaja!!");
                    TRY++;
                }
            }

            Leer.reset();
        }

    public static void Ejercio10() {
        
            String DIA;
            Scanner Leer = new Scanner(System.in);

            System.out.println("Ingresa un Dia de la Semana");
            DIA = Leer.nextLine();

            DIA = DIA.toUpperCase();

            ArrayList<String> SEMANA = new ArrayList<>(Arrays.asList("LUNES", "MARTES", "MIERCOLES", "JUEVES", "VIERNES"));

            if (SEMANA.contains(DIA)) {
                System.out.println("SI es un laboral");
            }
            else{
                System.out.println("NO es un laboral");
            }

            Leer.reset();
        }

}

