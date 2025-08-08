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
}