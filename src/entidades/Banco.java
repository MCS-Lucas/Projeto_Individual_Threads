package entidades;
import op_bancarias.Conta;
import java.util.ArrayList;
import java.util.List;

public class Banco {

    private static int iCount = 0;
    private static final int MAX_BANCOS = 1;
    private List<Conta> contas;
    private Conta opContas;


    public Banco() throws Exception {
        if (iCount >= MAX_BANCOS) {
            throw new Exception("Número máximo de bancos atingido.");
        }
        iCount++;
        contas = new ArrayList<>();
    }
    public void armazenarConta(Conta conta){
        contas.add(conta);
    }
    public void exibirContas(){
        System.out.println("Contas cadastradas:");
        System.out.println("____________________");
        for(Conta conta : contas){
            System.out.println(conta.verificarConta());
            System.out.println("____________________");
        }
    }

}
