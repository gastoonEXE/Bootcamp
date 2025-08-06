

public class Reloj {

    int horas;
    int minutos;
    int segundos;

    public Reloj() {
        this.horas = 12;
        this.minutos = 0;
        this.segundos = 0;
    }

    public Reloj(int tiempo) {
        this.horas = tiempo / 3600;
        this.minutos = tiempo % 3600 / 60;
        this.segundos = tiempo % 60;
        if (this.horas >= 24) {
            this.horas = this.horas % 24;
        }
    }

    public Reloj(int hora, int minuto, int segundo) {
        this.horas = hora;
        this.minutos = minuto;
        this.segundos = segundo;
    }

    public void setReloj(int tiempo) {
        this.horas = tiempo / 3600;
        this.minutos = tiempo % 3600 / 60;
        this.segundos = tiempo % 60;
    }

    public int getHoras() {
        return horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setHoras(int hora) {
        this.horas = hora;
    }

    public void setMinutos(int minuto) {
        this.minutos = minuto;
    }

    public void setSegundos(int segundo) {
        this.segundos = segundo;
    }

    public void tick() {
        if(this.segundos < 59) {
            this.segundos++;
        } else {
            this.segundos = 0;
            if(this.minutos < 59) {
                this.minutos++;
            } else {
                this.minutos = 0;
                if(this.horas < 23) {
                    this.horas++;
                } else {
                    this.horas = 0;
                }
            }
        }
    }

    public void addReloj( Reloj reloj) {
        this.segundos += reloj.getSegundos();
        this.minutos += reloj.getMinutos();
        this.horas += reloj.getHoras();

        if(this.segundos >= 60) {
            this.minutos += this.segundos / 60;
            this.segundos = this.segundos % 60;
        }
        if(this.minutos >= 60) {
            this.horas += this.minutos / 60;
            this.minutos = this.minutos % 60;
        }
        if(this.horas >= 24) {
            this.horas = this.horas % 24;
        }
    }

    public String toString() {
        return String.format("[%02d:%02d:%02d]", horas, minutos, segundos);
    }

    public void tickDecrement() {
        if(this.segundos > 0) {
            this.segundos--;
        } else {
            this.segundos = 59;
            if(this.minutos > 0) {
                this.minutos--;
            } else {
                this.minutos = 59;
                if(this.horas > 0) {
                    this.horas--;
                } else {
                    this.horas = 23;
                }
            }
        }

    }

    public void restaReloj(Reloj reloj) {
        this.segundos -= reloj.getSegundos();
        this.minutos -= reloj.getMinutos();
        this.horas -= reloj.getHoras();

        if(this.segundos < 0) {
            this.minutos--;
            this.segundos += 60;
        }
        if(this.minutos < 0) {
            this.horas--;
            this.minutos += 60;
        }
        if(this.horas < 0) {
            this.horas += 24;
        }
    }

}

