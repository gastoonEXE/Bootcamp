package DIA_4;

public class Carta {
    
    public char palo;
    public char valor;

    public Carta(char valor, char palo) {
        this.palo = palo;
        this.valor = valor;
    }

    public Carta(String carta) {
        this.palo = carta.charAt(1);
        this.valor = carta.charAt(0);
    }

    String getCarta() {
        return "" + this.valor + this.palo;
    }

    String valorPalo(){
        return "" + this.valor + this.palo;
    }

    static String GetMano(Carta[] mano) {
        String manoStr = "";
        for (int i = 0; i < mano.length; i++) {
            manoStr += mano[i].getCarta() + " ";
        }
        return manoStr.trim();
    }

    static int PuntosMano(Carta[] mano, int indx){

        int [] valorManoArray = new int [mano.length];

        for (int i = 0; i < mano.length; i++) {

            if (mano[i].valor >= '2' && mano[i].valor <= '9') {
                valorManoArray[i] = (int) mano[i].valor - 49; // Convertir el carácter a su valor numérico
                if (valorManoArray[i] == 1) {
                }
            }else if (mano[i].valor == 'T') {
                valorManoArray[i] = 9; // Asignar un valor 9 para T
            } else if (mano[i].valor == 'J') {
                valorManoArray[i] = 10; // Asignar un valor 10 para J
            } else if (mano[i].valor == 'Q') {
                valorManoArray[i] = 11; // Asignar un valor 11 para Q
            } else if (mano[i].valor == 'K') {
                valorManoArray[i] = 12; // Asignar un valor 12 para K
                //AsValorK = true;
            } else if (mano[i].valor == 'A') {
                valorManoArray[i] = 14;
            }
        }

        java.util.Arrays.sort(valorManoArray);

        return valorManoArray[indx];
        
    }
    static int PuntosMano(Carta[] mano) {
        int puntos = 0;
        if (Carta.esINVALIDO(mano)) {
            return puntos;
        }
        if (Carta.esEscaleraColor(mano)) {
            return 30;
        } else if (Carta.esPOKER(mano)) {
            return 28;
        } else if (Carta.esFULL(mano)) {
            return 26;
        } else if (Carta.esCOLOR(mano)) {
            return 24;
        } else if (Carta.esESCALERA(mano)) {
            return 22;
        } else if (Carta.esTRIO(mano)) {
            return 20;
        } else if (Carta.esDOBLEPAR(mano)) {
            return 18;
        } else if (Carta.esPAR(mano)) {
            return 16;
        }
        else {
            // Devuelve el punto de la carta más alta  

            int [] valorManoArray = new int [mano.length];
            
            for (int i = 0; i < mano.length; i++) {

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

            return valorManoArray[indexCartaAlta] /*+ CartaAlta(mano).getCarta()*/;
        }
    }


    static boolean esINVALIDO(Carta [] mano){

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

    static boolean esEscaleraColor(Carta [] mano) {
        
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

    static boolean esPOKER(Carta [] mano) {
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

    static boolean esFULL(Carta [] mano) {
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

    static boolean esCOLOR(Carta [] mano) {
        // si todos los Palo son iguales
        char primerPalo = mano[0].palo;
        for (int i = 1; i < mano.length; i++) {
            if (mano[i].palo != primerPalo) {
                return false;
            }            
        }
        return true;
    }

    static boolean esESCALERA(Carta [] mano) {
        
        
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

    static boolean esTRIO(Carta [] mano) {
        
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

    static boolean esDOBLEPAR(Carta [] mano) {
        
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

    static boolean esPAR(Carta [] mano) {
        
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

    static Carta CartaAlta(Carta [] mano) {
        
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

}