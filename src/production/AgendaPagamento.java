package production;

public class AgendaPagamento {

    private String agenda;
    private int dia=0;
    private boolean mensalmente=false;
    private boolean semanalmente=false;

    public AgendaPagamento(int dia,boolean mensalmente,boolean semanalmente){
        if(mensalmente && !semanalmente){
            this.agenda = "Mensal " + dia;
            this.dia = dia;
            this.mensalmente = true;
        }
        else if(!mensalmente && semanalmente){
            this.agenda = "Semanal " + dia;
            this.semanalmente = true;
        }else
            System.out.println("Erro!");
    }


    public int getDia() {
        return dia;
    }

    public boolean isMensalmente() {
        return mensalmente;
    }

    public boolean isSemanalmente() {
        return semanalmente;
    }

    public String getAgenda() {
        return this.agenda;
    }

}
