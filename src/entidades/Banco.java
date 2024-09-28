package entidades;
import op_bancarias.*;
import java.util.ArrayList;
import java.util.List;

public class Banco {

    private static int iCount = 0;
    private static final int MAX_BANCOS = 1;
    private List<Conta> contas;
    private Double cofreBanco = 0.0;

    public Banco() throws Exception {
        if (iCount >= MAX_BANCOS) {
            throw new Exception("Número máximo de bancos atingido.");
        }
        iCount++;
        contas = new ArrayList<>();
    }

    public void setCofreBanco(Double cofreBanco) {
        this.cofreBanco = cofreBanco;
    }

    public Double getCofreBanco() {
        return cofreBanco;
    }

    public synchronized void transacao(Conta contaTipo, Double valorTransacao, Conta contaDestino){

        if (contaTipo instanceof ContaCliente) {
            contaTipo.debitar(valorTransacao);
            setCofreBanco(getCofreBanco() + valorTransacao);
            contaDestino.depositar(valorTransacao);
            setCofreBanco(getCofreBanco() - valorTransacao);

        } else if (contaTipo instanceof ContaLoja && contaDestino instanceof ContaFuncionario) {
            contaTipo.debitar(valorTransacao);
            setCofreBanco(getCofreBanco() + valorTransacao);
            contaDestino.depositar(valorTransacao);
            setCofreBanco(getCofreBanco() - valorTransacao);

        }else if(contaTipo instanceof ContaFuncionario){
            contaTipo.debitar(valorTransacao);
            setCofreBanco(getCofreBanco() + valorTransacao);
            contaDestino.depositar(valorTransacao);
            setCofreBanco(getCofreBanco() - valorTransacao);

        }


    }

    public synchronized void armazenarConta(Conta conta){
        contas.add(conta);
    }
    public synchronized void exibirContas(){
        System.out.println("Contas cadastradas:");
        System.out.println("____________________");
        for(Conta conta : contas){
            System.out.println(conta.verificarConta());
            System.out.println("____________________");
        }
    }



}
