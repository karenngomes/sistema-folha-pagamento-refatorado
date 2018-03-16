package production;

import java.util.ArrayList;

public class CartaoPonto {

    private int identificacao;

    private ArrayList<DataPontos> dataPontos = new ArrayList<DataPontos>();

    public CartaoPonto(int identificacao){

        this.identificacao = identificacao;
    }

    public ArrayList<DataPontos> getDataPontos() {

        return dataPontos;
    }
}
