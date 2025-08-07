package DIA_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
public class Generala{

    // ESTA ES LA FUNCIÓN QUE HAY QUE IMPLEMENTAR
    // TAMBIÉN PUEDEN AGREGAR OTRAS FUNCIONES y/o CLASES
    // QUE NECESITEN PARA RESOLVER EL EJERCICIO DE LA
    // MANERA MÁS ORDENADA POSIBLE
    String jugada(String dados){

        if (esINVALIDO(dados)) {
            return "INVALIDO";
        }
        if (esGENERALA(dados)) {
            return "GENERALA";
        } else if (esPOKER(dados)) {
            return "POKER";
        } else if (esFULL(dados)) {
            return "FULL";
        } else if (esESCALERA(dados)) {
            return "ESCALERA";
        } else {
            return "NADA";
        }
    }

    boolean esINVALIDO(String dados){

        if (dados.length() != 5) {
            return true;
        }

        for (int i = 0; i < dados.length(); i++) {
            if((int) dados.charAt(i) - 48 > 9 || (int) dados.charAt(i) - 48 < 0){
                return true;
            }
        }
        return false;
    }

    boolean esGENERALA(String dados) {
        // si todos los dados son iguales
        char primerDado = dados.charAt(0);
        for (int i = 1; i < dados.length(); i++) {
            if (dados.charAt(i) != primerDado) {
                return false;
            }            
        }
        return true;
    }

    boolean esPOKER(String dados) {
        // si hay 4 iguales
        int[] conteo = new int[dados.length()];
        
        for (int i = 0; i < conteo.length; i++) {
            conteo[i] = 0;
        }
        
        for (int i = 0; i < conteo.length; i++) {
            for (int j = 0; j < conteo.length; j++) {
                if (dados.charAt(i) == dados.charAt(j)) {
                    conteo[i]++;
                }
            }
        }
        for (int i = 0; i < conteo.length; i++) {
            if (conteo[i] == 4) {
                return true;
            }
        }

        return false;

    }

    boolean esFULL(String dados) {
        // si hay 3 iguales y 2 iguales
        int[] conteo = new int[dados.length()];
        
        for (int i = 0; i < conteo.length; i++) {
            conteo[i] = 0;
        }
        
        for (int i = 0; i < conteo.length; i++) {
            for (int j = 0; j < conteo.length; j++) {
                if (dados.charAt(i) == dados.charAt(j)) {
                    conteo[i]++;
                }
            }
        }
        boolean tres = false;
        boolean dos = false;
        for (int i = 0; i < conteo.length; i++) {
            if (conteo[i] == 3) {
                tres = true;
            } else if (conteo[i] == 2) {
                dos = true;
            }
        }

        return tres && dos;

    }
    
    boolean esESCALERA(String dados) {

        if (dados.equals("12345") || dados.equals("23456") || dados.equals("34561")) {
            return true;
        } else {
            return false;
        }

    }



    // Ustedes pueden ignorar esto
    String[] jugadas(String[] losdados){
        String[] ret = new String[losdados.length];
        int i = 0;
        for (String dados : losdados){
            ret[i] = this.jugada(dados);
            i++;
        }
        return ret;
    }
    
    // Ustedes pueden ignorar esto
    static String[] processBatch(String fileName) throws Exception {
        Scanner sc = new Scanner(new File(fileName));
        List<String> lines = new ArrayList<String>();
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }

        sc.close();

        return lines.toArray(new String[0]);
    }
    
    public static void main(String[] args) throws Exception {
        Generala g = new Generala();

        /* IGNORAR PORQUE ESTO NO SE VA A EJECUTAR PARA USTEDES */
        if (args.length > 0) {
            String[] jugadas = processBatch(args[0]);
            String resultados[] = g.jugadas(jugadas);
            for(String res : resultados) {
                System.out.println(res);
            }
            return; 
        }
        // ESTO SI SE EJECUTA PARA USTEDES
        System.out.println(g.jugada("11111"));

        // Pruebas
        // System.out.println( "Prueba: 21A11 -> " + g.jugada("21A11"));
        // System.out.println( "Prueba: 11111 -> " + g.jugada("11111"));
        // System.out.println( "Prueba: 12345 -> " + g.jugada("12345"));
        // System.out.println( "Prueba: 23456 -> " + g.jugada("23456"));
        // System.out.println( "Prueba: 34561 -> " + g.jugada("34561"));
        // System.out.println( "Prueba: 11112 -> " + g.jugada("11112"));
        // System.out.println( "Prueba: 11122 -> " + g.jugada("11122"));
        // System.out.println( "Prueba: 11123 -> " + g.jugada("11123"));
        // System.out.println( "Prueba: 11122 -> " + g.jugada("12122"));
        // System.out.println( "Prueba: 11122 -> " + g.jugada("12112"));

        // respuestas:
        // Cuál es la probabilidad de sacar generala en un tiro? 
        //    Probabilidad = 6 / 7776 = 0.0007716 (0.07716%)
        System.out.println("Probabilidad de sacar generala en un tiro: (0.077%)");
        
        // Cuál es la probabilidad de sacar poker en un tiro?
        //   Probabilidad = 150 / 7776 = 0.0192901 (1.93%)\
        System.out.println("Probabilidad de sacar poker en un tiro: (1.93%)");

        //Cuál es la probabilidad de sacar full en un tiro?
        //   Probabilidad = 300 / 7776 = 0.03858 (3.86%)
        System.out.println("Probabilidad de sacar full en un tiro: (3.86%)");

        //Cuál es la probabilidad de sacar escalera en un tiro?
        //   Probabilidad = 360 / 7776 = 0.0463 (4.63%)
        System.out.println("Probabilidad de sacar escalera en un tiro: (4.63%)");

        //Cuál es la probabilidad de sacar nada en un tiro?
        //   Probabilidad = 6960 / 7776 = 0.8955 (89.55%)
        System.out.println("Probabilidad de sacar nada en un tiro: (89.55%)");

        //BONUS:

        //Cuál es la probabilidad de sacar generala en dos tiros?
        //   Probabilidad = 358 / 7776 = 4.60%
        System.out.println("Probabilidad de sacar generala en dos tiros: (4.60%)");

        //Cuál es la probabilidad de sacar generala en tres tiros?
        //   Probabilidad = 1196 / 7776 = 15.38%
        System.out.println("Probabilidad de sacar generala en tres tiros: (15.38%)");



    }
}