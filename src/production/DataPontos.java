package production;

public class DataPontos {

    private Date data;
    private int horaChegada;
    private int horaSaida;

    public DataPontos(Date data,int horaChegada,int horaSaida){

        this.data = data;
        this.horaChegada = horaChegada;
        this.horaSaida = horaSaida;
    }

    public Date getData() {
        return data;
    }

    public int getHoraChegada() {
        return horaChegada;
    }

    public int getHoraSaida() {
        return horaSaida;
    }
}
