package production;

public class Empregado {

    private String nome;
    private String endereco;
    private int identificacao;
    private String tipo;
    private String metodoPagamento;
    private boolean sindicato = false;
    private Date dataPagamento;
    private int identificacaoSindicato;
    private AgendaPagamento agendaPagamento;
    private CartaoPonto cartaoPonto;
    private boolean comissionado=false;
    private int horaExtra=0;
    private int valorVendasFeitas=0;
    private int salario=0;
    private int taxaSindical=0;
    private int percentualComissao;

    public Empregado(String nome, String endereco, int identificacao, String tipo, String metodoPagamento,
                     AgendaPagamento agendaPagamento, Date dataPagamento, CartaoPonto cartaoPonto,Boolean comissionado) {

        this.comissionado = comissionado;
        this.agendaPagamento = agendaPagamento;
        this.nome = nome;
        this.endereco = endereco;
        this.identificacao = identificacao;
        this.tipo = tipo;
        this.metodoPagamento = metodoPagamento;
        this.dataPagamento = dataPagamento;
        this.cartaoPonto = cartaoPonto;

    }


    public void setPercentualComissao(int percentualComissao) {
        this.percentualComissao = percentualComissao;
    }

    public int getPercentualComissao() {
        return percentualComissao;
    }

    public Date getPagamento() {
        return dataPagamento;
    }

    public void setPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public void setAgendaPagamento(AgendaPagamento agendaPagamento) {
        this.agendaPagamento = agendaPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTaxaSindical() {
        return taxaSindical;
    }

    public void setTaxaSindical(int taxaSindical) {
        this.taxaSindical = taxaSindical;
    }

    public void setSindicato(boolean sindicato){

        this.sindicato = sindicato;
    }

    public boolean isSindicato() {
        return sindicato;
    }

    public String getNome() {
        return this.nome;
    }

    public int getIdentificacao() {
        return this.identificacao;
    }

    public CartaoPonto getCartaoPonto() {
        return this.cartaoPonto;
    }

    public void setCartaoPonto(CartaoPonto cartaoPonto) {
        this.cartaoPonto = cartaoPonto;
    }

    public void setComissionado(boolean comissionado) {
        this.comissionado = comissionado;
    }

    public void setHoraExtra(int horaExtra) {

        this.horaExtra += horaExtra;
    }

    public int getHoraExtra() {

        return horaExtra;
    }

    public String getTipo() {
        return tipo;
    }

    public int getValorVendasFeitas() {
        return valorVendasFeitas;
    }

    public void setValorVendasFeitas(int valorVendasFeitas) {

        this.valorVendasFeitas += valorVendasFeitas;
    }

    public boolean isComissionado() {
        return comissionado;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario += salario;
    }

    public int getIdentificacaoSindicato() {
        return identificacaoSindicato;
    }

    public void setIdentificacaoSindicato(int identificacaoSindicato) {
        this.identificacaoSindicato = identificacaoSindicato;
    }


    public AgendaPagamento getAgendaPagamento() {
        return agendaPagamento;
    }
}
