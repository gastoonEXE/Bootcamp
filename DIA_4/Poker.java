
package DIA_4;

public class Poker{
    
    // char [] mazo = {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};

    // char [] SPADES = {'S', 'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};
    // char [] CLUBS = {'C', 'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};
    // char [] HEARTS = {'H', 'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};
    // char [] DIAMONDS = {'D', 'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};
    
    // char [] palos = {'S', 'C', 'H', 'D'};



    //Carta [] mano = new Carta[5];


    String jugada(Carta [] mano){

        if (Carta.esINVALIDO(mano)) {
            return "INVALIDO";
        }
        if (Carta.esEscaleraColor(mano)) {
            return "Escalera Color";
        } else if (Carta.esPOKER(mano)) {
            return "Poker";
        } else if (Carta.esFULL(mano)) {
            return "Full";
        } else if (Carta.esCOLOR(mano)) {
            return "Color";
        } else if (Carta.esESCALERA(mano)) {
            return "Escalera";
        } else if (Carta.esTRIO(mano)) {
            return "Trio";
        } else if (Carta.esDOBLEPAR(mano)) {
            return "Doble Par";
        } else if (Carta.esPAR(mano)) {
            return "Par";
        }
        else {
            return "Carta Alta " /*+ CartaAlta(mano).getCarta()*/;
        }
    }

    public static void main(String[] args) {
        
        Carta [] mano = {new Carta("TD"), new Carta("9C"), new Carta("QH"), new Carta("TS"), new Carta("6H")};
        Poker g = new Poker();

        System.out.println(g.jugada(mano));
        //System.out.println(Carta.PuntosMano(mano));
        


        /*2. Responder a las siguientes preguntas */
        //
        // Total manos posibles: 2,598,960
        // Dividir las Manos favorables entre los manos posibles 

        // Si se mezclan y reparten cartas al azar: Cuál es la probabilidad de obtener una escalera de color?
        // casos posibles existentes: 10 x 4 = 40
        System.out.println("Probabilidad de Escalera Color: " + ( 40 / 2598960.0) * 100 + " %");

        // Si se mezclan y reparten cartas al azar: Cuál es la probabilidad de obtener un poker?
        // casos posibles existentes: 13 x (52 - 4) = 624
        System.out.println("Probabilidad de Poker: " + ( 624 / 2598960.0) * 100 + " %");

        // Si se mezclan y reparten cartas al azar: Cuál es la probabilidad de obtener un full house?
        // casos posibles existentes: 13 x (12 x 4) = 6240
        System.out.println("Probabilidad de Full: " + ( 6240 / 2598960.0) * 100 + " %");

        // Si se mezclan y reparten cartas al azar: Cuál es la probabilidad de obtener una escalera?
        // casos posibles existentes: 10 x (4^5 - 4) = 10200
        System.out.println("Probabilidad de Escalera: " + ( 10200 / 2598960.0) * 100 + " %");

        // Si se mezclan y reparten cartas al azar: Cuál es la probabilidad de obtener un trio? 
        // casos posibles existentes: 13 x 4 x 1176 = 61152
        System.out.println("Probabilidad de Trio: " + ( 61152 / 2598960.0) * 100 + " %");

        // Si se mezclan y reparten cartas al azar: Cuál es la probabilidad de obtener un par doble?
        // casos posibles existentes: ( 13 # 2 = 78 ) * 36 * 11 * 4 = 123552
        System.out.println("Probabilidad de Doble Par: " + ( 123552 / 2598960.0) * 100 + " %");

        //Si se mezclan y reparten cartas al azar: Cuál es la probabilidad de obtener un par?
        // casos posibles existentes: 13 * 6 * 220 * 64 = 1098240
        System.out.println("Probabilidad de Par: " + ( 1098240 / 2598960.0) * 100 + " %");

        //Si se mezclan y reparten cartas al azar: Cuál es la probabilidad de no obtener ninguna de las jugadas anteriores?
        // casos posibles existentes: 40 + 624 + 6240 + 10200 + 61152 + 123552 + 1098240 = 1302540
        System.out.println("Probabilidad de Ninguna conmbinacion jugada: " + ( 1302540 / 2598960.0) * 100 + " %");

    }

}
