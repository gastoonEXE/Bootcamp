package NimJava;

public class Jugador {
    private String nombre;

    private boolean MiTurno;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setTurno(boolean EsMiTurno) {
        this.MiTurno = EsMiTurno;
    }

    public boolean EsMiTurno() {
        return MiTurno;
    }

    public void siguienteTurno() {
        this.MiTurno = !this.MiTurno;
    }
}
