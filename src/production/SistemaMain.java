package production;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaMain {

    public static void menu(ArrayList<AgendaPagamento> listaAgenda,ArrayList<Empregado> listaEmpregados) {

        Scanner input = new Scanner(System.in);
        System.out.printf("Selecione a opção que deseja:%n");
        int parada = 1;


       do {

            int opcao,procurarIdentificacao;
            int identificacao = 2;
            int identificacaoSindicato = 1;

            System.out.printf("=========================================%n" 
            		+ "[1] Adicionar um novo empregado%n"
                    + "[2] Remover empregado%n"
                    + "[3] Lançar um cartão de ponto%n"
                    + "[4] Lançar um resultado de venda%n"
                    + "[5] Lançar uma taxa de serviço%n"
                    + "[6] Alterar detalhes de um empregado%n"
                    + "[7] Rodar folha de pagamento%n"
                    + "[8] Voltar/Proceder%n"
                    + "[9] Agenda de pagamento%n"
                    + "[10] Criar nova agenda de pagamento%n" 
                    + "[0] Sair%n" +
                    "=========================================%n");
            opcao = input.nextInt();
            parada = opcao;

            switch (opcao){
                case 1:
                    Empregado newEmpregado;
                    String nome;
                    String endereco,opcaoTipoo,opcaoPagamento;
                    int opcaoAux,cont = 1;
                    boolean comissionado = false;

                    System.out.print("Nome: ");
                    nome = input.next();
                    System.out.print("Endereco: ");
                    endereco = input.next();
                    System.out.printf("Selecione o tipo: [1] Horista [2] Assalariado%n");
                    opcaoAux = input.nextInt();
                    int percentualComissao=0;

                    if(opcaoAux == 2){
                        opcaoTipoo = "Assalariado";
                        System.out.println("Comissionado ? [1] Sim [2] Não");
                        if(input.nextInt() == 1){
                            comissionado = true;
                            System.out.println("Percentual de comissão: ");
                            percentualComissao = input.nextInt();
                        }

                    }else
                        opcaoTipoo = "Horista";
                    System.out.println("Selecione o metodo de pagamento:");
                    System.out.printf("[1] Cheque pelos correios [2] Cheque em mãos [3] Depósito em conta bancária");
                    opcaoAux = input.nextInt();
                    if(opcaoAux == 1)
                        opcaoPagamento = "Cheque pelos correios";
                    else if(opcaoAux == 2)
                        opcaoPagamento = "Cheque em maos";
                    else
                        opcaoPagamento = "Deposito em conta bancaria";
                    System.out.printf("Selecione a agenda de pagamento:%n");
                    for(AgendaPagamento auxliar : listaAgenda){
                        System.out.printf("[%d] %s%n", cont++,auxliar.getAgenda());
                    }
                    opcaoAux = input.nextInt();

                    AgendaPagamento opcaoAgenda = listaAgenda.get(--opcaoAux);

                    System.out.printf("Data de inicio do empregado:%n");
                    int dia,mes,ano;
                    System.out.printf("Dia: ");
                    dia = input.nextInt();
                    System.out.print("Mes: ");
                    mes = input.nextInt();;
                    System.out.println("Ano: ");
                    ano = input.nextInt();;
                    Date inicioData = new Date(mes,dia,ano);
                    CartaoPonto cartaoPonto = new CartaoPonto(identificacao);

                    newEmpregado = new Empregado(nome,endereco,identificacao++,opcaoTipoo,opcaoPagamento,
                            opcaoAgenda,inicioData,cartaoPonto,comissionado);

                    newEmpregado.setPercentualComissao(percentualComissao);

                    System.out.println("Faz parte do sindicato ? [1] Sim [2] Não");
                    if(input.nextInt() == 1){
                        newEmpregado.setSindicato(true);
                        newEmpregado.setIdentificacaoSindicato(identificacaoSindicato++);
                        System.out.println("Taxa sindical: ");
                        newEmpregado.setTaxaSindical(input.nextInt());
                    }
                    listaEmpregados.add(newEmpregado);
                    System.out.println("Empregado registrado!");
                    break;

                case 2:
                    System.out.println("Deseja ver a lista de empregados Cadastrados ? [1] Sim [2] Não");

                    if(input.nextInt() == 1){
                        for(Empregado auxiliar : listaEmpregados){
                            System.out.printf("%d - %s%n", auxiliar.getIdentificacao(),auxiliar.getNome());
                        }
                    }
                    System.out.println("Digite a identificação do empregado que deseja remover:");
                    procurarIdentificacao = input.nextInt();
                    cont = 0;
                    for(Empregado auxiliar : listaEmpregados){
                        if(auxiliar.getIdentificacao() == procurarIdentificacao){
                            listaEmpregados.remove(cont);
                            break;
                        }
                        cont++;
                    }
                    System.out.println("Empregado removido!");
                    break;

                case 3:
                    System.out.printf("Digite a identificação do empregado: ");
                    procurarIdentificacao = input.nextInt();
                    for(Empregado auxiliar : listaEmpregados){
                        if(auxiliar.getIdentificacao() == procurarIdentificacao){
                            if(auxiliar.getTipo().intern() == "Horista"){
                                CartaoPonto cartaoAuxiliar = auxiliar.getCartaoPonto();

                                ArrayList<DataPontos> listaDatas = cartaoAuxiliar.getDataPontos();

                                System.out.printf("Digite a data de hoje:%nDia: ");
                                dia = input.nextInt();
                                System.out.printf("Mes: ");
                                mes = input.nextInt();
                                System.out.printf("Ano: ");
                                ano = input.nextInt();
                                Date newData = new Date(mes,dia,ano);
                                System.out.printf("Hora de chegada: ");
                                int horaChegada = input.nextInt();
                                System.out.printf("Hora de saida:");
                                int horaSaida = input.nextInt();
                                int horasTrabalhadas = horaSaida-horaChegada;
                                DataPontos pontoAulixiar = new DataPontos(newData,horaChegada,horaSaida);
                                listaDatas.add(pontoAulixiar);
                                if(horasTrabalhadas > 8){
                                    horasTrabalhadas -= 8;
                                    auxiliar.setHoraExtra(horasTrabalhadas);
                                    System.out.println("Pronto!");
                                }
                            }else
                                System.out.println("Esse empregado não é horista!");

                            break;
                        }


                    }
                    break;


                case 4:
                    System.out.println("Digite a identificação do empregado:");
                    procurarIdentificacao = input.nextInt();
                    for(Empregado auxiliar : listaEmpregados){
                        if(auxiliar.getIdentificacao() == procurarIdentificacao){
                           if(auxiliar.getTipo().intern() == "Assalariado" && auxiliar.isComissionado()){

                               System.out.print("Data da venda: ");
                               Date newDate = new Date(input.nextInt(),input.nextInt(),input.nextInt());
                               System.out.println("Valor da venda: ");
                               int valorVenda = input.nextInt();
                               auxiliar.setValorVendasFeitas(valorVenda);
                               System.out.println("Pronto!");
                           }else
                               System.out.println("Esse empregado não é assalariado ou não é comissionado");

                           break;
                        }
                    }
                    break;

                case 5:
                    System.out.println("Digite a identificação do empregado:");
                    procurarIdentificacao = input.nextInt();
                    for(Empregado auxiliar : listaEmpregados){
                        if(auxiliar.getIdentificacao() == procurarIdentificacao){
                            if(auxiliar.isSindicato()){
                                System.out.print("Valor da taxa: ");
                                int valorTaxa = input.nextInt();
                                auxiliar.setSalario(-valorTaxa);
                                System.out.println("Pronto!");
                            }else
                                System.out.println("Empregado não pertence ao sindicato");
                            break;
                        }
                    }
                    break;

                case 6:
                    System.out.println("Digite a identificação do empregado:");
                    procurarIdentificacao = input.nextInt();
                    for(Empregado auxiliar : listaEmpregados){
                        if(auxiliar.getIdentificacao() == procurarIdentificacao){

                            System.out.println("O que deseja alterar ?");
                            System.out.printf("[1] Nome%n[2] Endereço%n[3] Tipo%n[4] Método de pagamento%n" +
                                    "[5] Entrar ou sair do sindicato%n[6] Taxa sindical%n");

                            int opcaoAlterar = input.nextInt();
                            switch (opcaoAlterar){
                                case 1:
                                    System.out.print("Novo nome: ");
                                    auxiliar.setNome(input.next());
                                    System.out.println("Pronto!");
                                    break;

                                case 2:
                                    System.out.println("Novo endereço: ");
                                    auxiliar.setEndereco(input.next());
                                    System.out.println("Pronto!");
                                    break;

                                case 3:
                                    System.out.println("Selecione o novo tipo:");
                                    System.out.println("[1] Horista [2] Assalariado");
                                    if(input.nextInt() == 1)
                                        auxiliar.setTipo("Horista");
                                    else
                                        auxiliar.setTipo("Assalariado");
                                    System.out.println("Pronto");
                                    break;
                                case 4:
                                    System.out.println("Selecione o novo método de pagamento:");
                                    System.out.printf("[1] Cheque pelos correios [2] Cheque em mãos [3] Depósito em conta bancária%n");
                                    int opcaoMetodo = input.nextInt();
                                    if(opcaoMetodo == 1)
                                        auxiliar.setMetodoPagamento("Cheque pelos correios");
                                    else if(opcaoMetodo == 2)
                                        auxiliar.setMetodoPagamento("Cheque em maos");
                                    else
                                        auxiliar.setMetodoPagamento("Deposito em conta bancaria");
                                    System.out.println("Pronto");
                                    break;
                                case 5:
                                    System.out.println("[1] Entrar [2] Sair");
                                    if(input.nextInt() == 1)
                                        auxiliar.setSindicato(true);
                                    else
                                        auxiliar.setSindicato(false);
                                    System.out.println("Pronto");
                                    break;
                                case 6:
                                    System.out.printf("Valor da nova taxa: ");
                                    auxiliar.setTaxaSindical(input.nextInt());
                                    System.out.println("Pronto");
                                    break;
                                default:
                                    System.out.println("Opção inválida!");
                                    break;
                            }

                            break;
                        }

                    }
                    break;
                case 7:
                    System.out.println("Digite a data de hoje: [MÊS] [DIA] [ANO]");
                    Date datePagamento = new Date(input.nextInt(),input.nextInt(),input.nextInt());
                    Date datePagamentoEmpregado;
                    boolean deveSerPago = false;
                    int[] diasPorMes = datePagamento.getDaysPerMonth();
                    int quantidadeDiasTrabalhados=-1;
                    for(Empregado empregadoAtual : listaEmpregados){
                        AgendaPagamento agendaEmpregadoAtual = empregadoAtual.getAgendaPagamento();
                        datePagamentoEmpregado = empregadoAtual.getPagamento();
                        if(agendaEmpregadoAtual.isMensalmente()){
                            if(datePagamento.getMonth() != datePagamentoEmpregado.getMonth()
                                    && agendaEmpregadoAtual.getDia() == datePagamento.getDay())
                                deveSerPago = true;
                        }else{
                            if(datePagamento.getMonth() != datePagamentoEmpregado.getMonth()){

                                quantidadeDiasTrabalhados += diasPorMes[datePagamentoEmpregado.getMonth()]
                                        - datePagamentoEmpregado.getDay();
                                quantidadeDiasTrabalhados += datePagamento.getDay();

                            }
                            else{
                                quantidadeDiasTrabalhados = datePagamento.getDay() - datePagamentoEmpregado.getDay();
                            }
                        }
                        if(agendaEmpregadoAtual.isSemanalmente()){
                            if(quantidadeDiasTrabalhados >= agendaEmpregadoAtual.getDia()*7)
                                deveSerPago = true;
                        }

                        if(deveSerPago){
                            if(empregadoAtual.getTipo().intern() == "Horista"){
                                CartaoPonto cartaoEmpregadoAtual = empregadoAtual.getCartaoPonto();
                                ArrayList<DataPontos> pontosEmpregadoAtual = cartaoEmpregadoAtual.getDataPontos();
                                int horasTrabalhadas=0;
                                int horasExtras=0;
                                int contAux;
                                for(DataPontos auxiliar : pontosEmpregadoAtual){

                                    if(auxiliar.getHoraSaida()-auxiliar.getHoraChegada() <= 8)
                                        horasTrabalhadas+= auxiliar.getHoraSaida()-auxiliar.getHoraChegada();
                                    else{
                                        horasTrabalhadas += 8;
                                        horasExtras += auxiliar.getHoraSaida()-auxiliar.getHoraChegada() - 8;
                                    }
                                }
                                System.out.printf("Empregado %s trabalhou %d horas e tem %d horas extras%n",
                                        empregadoAtual.getNome(),horasTrabalhadas,horasExtras);
                                //Calcula de acordo com a taxa e adiciona ao empregado.setSalario, desconta as taxas do sindicato
                                //e realiza o pagemento
                            }else if(empregadoAtual.isComissionado()){
                                int valor = empregadoAtual.getValorVendasFeitas()*(empregadoAtual.getPercentualComissao()/100);
                                //valor + salario do mes
                                empregadoAtual.setSalario( valor );
                                //PAGO
                            }else{
                                //empregadoAtual.getSalario();
                                //PAGO
                            }
                        }
                    }
                    break;

                case 8:
                    System.out.println("Função não disponivel");
                    break;

                case 9:
                    System.out.print("Digite a identificação do empregado: ");
                    procurarIdentificacao = input.nextInt();
                    for(Empregado auxiliarEmpregado : listaEmpregados){
                        if(auxiliarEmpregado.getIdentificacao() == procurarIdentificacao){
                            int contAux=1;
                            System.out.println("Selecione a nova agenda que deseja:");
                            for(AgendaPagamento auxiliarAgenda: listaAgenda){
                                System.out.printf("[%d] %s%n",contAux++,auxiliarAgenda.getAgenda());
                            }
                            int selecionarAgenda = input.nextInt();
                            for(AgendaPagamento auxiliarAgenda: listaAgenda){
                                if(contAux == selecionarAgenda){
                                    auxiliarEmpregado.setAgendaPagamento(auxiliarAgenda);
                                    System.out.println("Pronto!");
                                    break;
                                }
                            }

                            break;
                        }
                    }
                    break;

                case 10:
                    System.out.printf("[1] Mensal [2] Semanal");
                    AgendaPagamento newAgenda;
                    if(input.nextInt() == 1){
                        System.out.printf("(-1 Representa o ultimo dia útil do mês)Dia: ");
                        newAgenda = new AgendaPagamento(input.nextInt(),true,false);
                    }else{
                        System.out.printf("A cada quantas semanas ?%n");
                        newAgenda = new AgendaPagamento(input.nextInt(),false,true);
                    }
                    listaAgenda.add(newAgenda);
                    System.out.println("Pronto!");
                    break;
            }


        } while(parada != 0);

    }

    public static ArrayList<AgendaPagamento> iniciarAgenda(ArrayList<AgendaPagamento> agendaPagamento) {
        AgendaPagamento inicio = new AgendaPagamento(1,false,true);
        agendaPagamento.add(inicio);
        inicio = new AgendaPagamento(1,true,false);
        agendaPagamento.add(inicio);
        inicio = new AgendaPagamento(2,false,true);
        agendaPagamento.add(inicio);
        return agendaPagamento;
    }

    public static ArrayList<Empregado> iniciarEmpregados(ArrayList<Empregado> listaEmpregados){
        Empregado newEmpregado = new Empregado("Eduardo","Rua 7 de setembro",1,"Horista",
                "Cheque em maos",new AgendaPagamento(1,true,false),
                new Date(1,1,2018),new CartaoPonto(1),false);
        listaEmpregados.add(newEmpregado);
        return listaEmpregados;
    }

    public static void main(String[] args) {

        ArrayList<AgendaPagamento> agendaPagamento = new ArrayList<AgendaPagamento>();
        ArrayList<Empregado> listaEmpregados = new ArrayList<Empregado>();

        menu(iniciarAgenda(agendaPagamento),iniciarEmpregados(listaEmpregados));
    }
}
