package DIA_4;

import java.util.ArrayList;
import java.util.List;

public class MyClass {
    // este es el único método que tienen que desarrollar
    // para hacerlo, pueden hacer uso de otras clases (si es necesario),
    // pero la corrección del ejercicio será automática en base a este
    // método que está acá
    public String ganadores(List<Carta[]> jugadas){

        System.out.println("Cantidad de jugadas: " + jugadas.size());
        for (Carta[] mano : jugadas) {
            System.out.println("JUGADA ======================");
            for (Carta c : mano) {
                System.out.println(c.valorPalo());
            }
        }

        if (Carta.PuntosMano(jugadas.get(0)) > Carta.PuntosMano(jugadas.get(1))) {
            return Carta.GetMano(jugadas.get(0));
        } else {
            return Carta.GetMano(jugadas.get(1));
            
        }
    }

    public static void main(String args[]) {
        MyClass mc = new MyClass();
        List<Carta[]> jugadas = new ArrayList<Carta[]>();

        Carta[] m1 = new Carta[5];
        m1[0] = new Carta("AH");
        m1[1] = new Carta("AD");
        m1[2] = new Carta("TH");
        m1[3] = new Carta("TC");
        m1[4] = new Carta("6S");
        Carta[] m2 = new Carta[5];
        m2[0] = new Carta("AH");
        m2[1] = new Carta("KD");
        m2[2] = new Carta("QH");
        m2[3] = new Carta("3C");
        m2[4] = new Carta("3S");

        jugadas.add(m1);
        jugadas.add(m2);

        String ganadores = mc.ganadores(jugadas);
        System.out.println("Ganadores = " + ganadores);

    }
    
}
