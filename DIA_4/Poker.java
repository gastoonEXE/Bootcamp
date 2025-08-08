
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

        if (esINVALIDO(mano)) {
            return "INVALIDO";
        }
        if (esEscaleraColor(mano)) {
            return "Escalera Color";
        } else if (esPOKER(mano)) {
            return "Poker";
        } else if (esFULL(mano)) {
            return "Full";
        } else if (esCOLOR(mano)) {
            return "Color";
        } else if (esESCALERA(mano)) {
            return "Escalera";
        } else if (esTRIO(mano)) {
            return "Trio";
        } else if (esDOBLEPAR(mano)) {
            return "Doble Par";
        } else if (esPAR(mano)) {
            return "Par";
        }
        else {
            return "Carta Alta " /*+ CartaAlta(mano).getCarta()*/;
        }
    }

    boolean esINVALIDO(Carta [] mano){

        if (mano.length != 5) {
            return true;
        }
        for (int i = 0; i < mano.length; i++) {
            
            if (mano[i].palo != 'S' && mano[i].palo != 'C' && mano[i].palo != 'H' && mano[i].palo != 'D') {
                return true;
                
            }            
            if (mano[i].valor < '2' || mano[i].valor > '9' && mano[i].valor != 'T' && mano[i].valor != 'J' && mano[i].valor != 'Q' && mano[i].valor != 'K' && mano[i].valor != 'A') {
                return true;
            }
        }
        return false;
    }

    boolean esEscaleraColor(Carta [] mano) {
        
        for (int i = 0; i < mano.length - 1; i++) {
            if (mano[i].palo != mano[i + 1].palo) {
                return false;
            }
        }

        //String escalera;
        
        int [] valorManoArray = new int [mano.length];
        
        boolean AsValor2 = false;
        boolean AsValorK = false;
        int indexAs = -1;
        
        for (int i = 0; i < mano.length; i++) {

            //System.out.println("Valor de la carta: " + mano[i].valor + " en asccii: " + (int) mano[i].valor + " en entero: " + ((int) mano[i].valor - 49));

            // boolean manoPruebaA = mano[i].valor >= '2';
            // boolean manoPruebaB = mano[i].valor <= '9';

            if (mano[i].valor >= '2' && mano[i].valor <= '9') {
                valorManoArray[i] = (int) mano[i].valor - 49; // Convertir el carácter a su valor numérico
                if (valorManoArray[i] == 1) {
                    AsValor2 = true;
                    //valorManoArray[i] = 1; 
                }
            }else if (mano[i].valor == 'T') {
                valorManoArray[i] = 9; // Asignar un valor 9 para T
            } else if (mano[i].valor == 'J') {
                valorManoArray[i] = 10; // Asignar un valor 10 para J
            } else if (mano[i].valor == 'Q') {
                valorManoArray[i] = 11; // Asignar un valor 11 para Q
            } else if (mano[i].valor == 'K') {
                valorManoArray[i] = 12; // Asignar un valor 12 para K
                AsValorK = true;
            } else if (mano[i].valor == 'A') {
                indexAs = i; // Guardar el índice del As
            }
        }

        if (indexAs != -1) {
            if (AsValor2) {
                valorManoArray[indexAs] = 0; // As como 2
            } else if (AsValorK) {
                valorManoArray[indexAs] = 13; // As como K
            } else {
                valorManoArray[indexAs] = 14; // As como A
            }
        }

        //System.out.println("Escalera: " + valorManoArray[0] + " " + valorManoArray[1] + " " + valorManoArray[2] + " " + valorManoArray[3] + " " + valorManoArray[4]);

        java.util.Arrays.sort(valorManoArray);

        //escalera = new String(valorManoArray.toString());
        //System.out.println("Escalera: " + valorManoArray[0] + " " + valorManoArray[1] + " " + valorManoArray[2] + " " + valorManoArray[3] + " " + valorManoArray[4]);
        //System.out.println("Mano: " + mano[0].getCarta() + " " + mano[1].getCarta() + " " + mano[2].getCarta() + " " + mano[3].getCarta() + " " + mano[4].getCarta());

        for (int i = 0; i < valorManoArray.length - 1; i++) {
            if (valorManoArray[i] + 1 != valorManoArray[i + 1]) {
                return false;
            }
        }
        return true;
    }

    boolean esPOKER(Carta [] mano) {
        // Implementar lógica para POKER
        int[] conteo = new int[mano.length];
        for (int i = 0; i < conteo.length; i++) {
            conteo[i] = 0;
        }

        for (int i = 0; i < conteo.length; i++) {
            for (int j = 0; j < conteo.length; j++) {
                if (mano[i].valor == mano[j].valor) {
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

    boolean esFULL(Carta [] mano) {
        // si hay 3 iguales y 2 iguales
        int[] conteo = new int[mano.length];
        
        for (int i = 0; i < conteo.length; i++) {
            conteo[i] = 0;
        }
        
        for (int i = 0; i < conteo.length; i++) {
            for (int j = 0; j < conteo.length; j++) {
                if (mano[i].valor == mano[j].valor) {
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

    boolean esCOLOR(Carta [] mano) {
        // si todos los Palo son iguales
        char primerPalo = mano[0].palo;
        for (int i = 1; i < mano.length; i++) {
            if (mano[i].palo != primerPalo) {
                return false;
            }            
        }
        return true;
    }

    boolean esESCALERA(Carta [] mano) {
        
        
        int [] valorManoArray = new int [mano.length];
        
        boolean AsValor2 = false;
        boolean AsValorK = false;
        int indexAs = -1;
        
        for (int i = 0; i < mano.length; i++) {

            //System.out.println("Valor de la carta: " + mano[i].valor + " en asccii: " + (int) mano[i].valor + " en entero: " + ((int) mano[i].valor - 49));

            // boolean manoPruebaA = mano[i].valor >= '2';
            // boolean manoPruebaB = mano[i].valor <= '9';

            if (mano[i].valor >= '2' && mano[i].valor <= '9') {
                valorManoArray[i] = (int) mano[i].valor - 49; // Convertir el carácter a su valor numérico
                if (valorManoArray[i] == 1) {
                    AsValor2 = true;
                    //valorManoArray[i] = 1; 
                }
            }else if (mano[i].valor == 'T') {
                valorManoArray[i] = 9; // Asignar un valor 9 para T
            } else if (mano[i].valor == 'J') {
                valorManoArray[i] = 10; // Asignar un valor 10 para J
            } else if (mano[i].valor == 'Q') {
                valorManoArray[i] = 11; // Asignar un valor 11 para Q
            } else if (mano[i].valor == 'K') {
                valorManoArray[i] = 12; // Asignar un valor 12 para K
                AsValorK = true;
            } else if (mano[i].valor == 'A') {
                indexAs = i; // Guardar el índice del As
            }
        }

        if (indexAs != -1) {
            if (AsValor2) {
                valorManoArray[indexAs] = 0; // As como 2
            } else if (AsValorK) {
                valorManoArray[indexAs] = 13; // As como K
            } else {
                valorManoArray[indexAs] = 14; // As como A
            }
        }

        System.out.println("Escalera: " + valorManoArray[0] + " " + valorManoArray[1] + " " + valorManoArray[2] + " " + valorManoArray[3] + " " + valorManoArray[4]);

        java.util.Arrays.sort(valorManoArray);

        //escalera = new String(valorManoArray.toString());
        System.out.println("Escalera: " + valorManoArray[0] + " " + valorManoArray[1] + " " + valorManoArray[2] + " " + valorManoArray[3] + " " + valorManoArray[4]);
        System.out.println("Mano: " + mano[0].getCarta() + " " + mano[1].getCarta() + " " + mano[2].getCarta() + " " + mano[3].getCarta() + " " + mano[4].getCarta());

        for (int i = 0; i < valorManoArray.length - 1; i++) {
            if (valorManoArray[i] + 1 != valorManoArray[i + 1]) {
                return false;
            }
        }
        return true;

    }

    boolean esTRIO(Carta [] mano) {
        
        int[] conteo = new int[mano.length];
        
        for (int i = 0; i < conteo.length; i++) {
            conteo[i] = 0;
        }
        
        for (int i = 0; i < conteo.length; i++) {
            for (int j = 0; j < conteo.length; j++) {
                if (mano[i].valor == mano[j].valor) {
                    conteo[i]++;
                }
            }
        }
        for (int i = 0; i < conteo.length; i++) {
            if (conteo[i] == 3) {
                return true;
            }
        }

        return false;
    }

    boolean esDOBLEPAR(Carta [] mano) {
        
        int[] conteo = new int[mano.length];
        
        for (int i = 0; i < conteo.length; i++) {
            conteo[i] = 0;
        }
        
        for (int i = 0; i < conteo.length; i++) {
            for (int j = 0; j < conteo.length; j++) {
                if (mano[i].valor == mano[j].valor) {
                    conteo[i]++;
                }
            }
        }
        // 
        int pares = 0;
        for (int i = 0; i < conteo.length; i++) {
            if (conteo[i] == 2) {
                pares++;
            }
        }

        if (pares == 4) {
            return true;
        } else {
            return false;
        }

    }

    boolean esPAR(Carta [] mano) {
        
        int[] conteo = new int[mano.length];
        
        for (int i = 0; i < conteo.length; i++) {
            conteo[i] = 0;
        }
        
        for (int i = 0; i < conteo.length; i++) {
            for (int j = 0; j < conteo.length; j++) {
                if (mano[i].valor == mano[j].valor) {
                    conteo[i]++;
                }
            }
        }
        // 
        int pares = 0;
        for (int i = 0; i < conteo.length; i++) {
            if (conteo[i] == 2) {
                pares++;
            }
        }

        if (pares == 2) {
            return true;
        } else {
            return false;
        }

    }

    Carta CartaAlta(Carta [] mano) {
        
        int [] valorManoArray = new int [mano.length];
        
        for (int i = 0; i < mano.length; i++) {

            //System.out.println("Valor de la carta: " + mano[i].valor + " en asccii: " + (int) mano[i].valor + " en entero: " + ((int) mano[i].valor - 49));

            if (mano[i].valor >= '2' && mano[i].valor <= '9') {
                valorManoArray[i] = (int) mano[i].valor - 49; // Convertir el carácter a su valor numérico
            }else if (mano[i].valor == 'T') {
                valorManoArray[i] = 9; // Asignar un valor 9 para T
            } else if (mano[i].valor == 'J') {
                valorManoArray[i] = 10; // Asignar un valor 10 para J
            } else if (mano[i].valor == 'Q') {
                valorManoArray[i] = 11; // Asignar un valor 11 para Q
            } else if (mano[i].valor == 'K') {
                valorManoArray[i] = 12; // Asignar un valor 12 para K
            } else if (mano[i].valor == 'A') {
                valorManoArray[i] = 14; // Guardar el índice del As
            }
        }
        
        int indexCartaAlta = 0;

        for (int i = 1; i < valorManoArray.length; i++) {
            if (valorManoArray[indexCartaAlta] < valorManoArray[i]) {
                indexCartaAlta = i;
            }
        }

        Carta cartaAlta = mano[indexCartaAlta];

        return cartaAlta;
    }

    public static void main(String[] args) {
        
        Carta [] mano = {new Carta("TD"), new Carta("9C"), new Carta("QH"), new Carta("KS"), new Carta("6H")};
        Poker g = new Poker();

        System.out.println(g.jugada(mano));




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
