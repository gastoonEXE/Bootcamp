
import java.util.Scanner;

public class RelojDemo{

    public static void main(String[] args) {
        
        Scanner Leer = new Scanner(System.in);

        System.out.println("\nIngresa una cantidad de segundos");

        int entrada = Leer.nextInt();

        Reloj reloj = new Reloj (entrada);

        System.out.println("Reloj A: " + reloj.toString());

        for (int i = 0; i < 10; i++) {
            reloj.tick();
            System.out.println("Reloj A: " + reloj.toString());
        }

        System.out.println("\nIngresa otra cantidad de segundos");

        entrada = Leer.nextInt();
        
        Reloj hora = new Reloj(entrada);

        //hora.segundos++;

        System.out.println("Reloj B inicial: " + hora.toString() );

        reloj.restaReloj(hora); 

        System.out.println("Reloj A Después de restar " + hora.toString() + ": " + reloj.toString() );

        Leer.close();
        
    }

    public void metodoRamaMain(){
        System.out.println("Hola");
        System.out.println("Hola 2");
        System.out.println("Hola 3");
        System.out.println("Hola 4");
    }
}
