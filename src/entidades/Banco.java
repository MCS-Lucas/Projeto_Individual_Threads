package entidades;
import op_bancarias.Conta;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    private static int iCount = 0;
    private static final int MAX_BANCOS = 1;
    private List<Conta> contas;

    Banco() throws Exception {
        if (iCount >= MAX_BANCOS) {
            throw new Exception("Número máximo de bancos atingido.");
        }
        iCount++;
        this.contas = new ArrayList<>();
    }
    public void adicionarConta(Conta conta) {
        this.contas.add(conta);
    }
    public List<Conta> getContas(){
        return contas;
    }
}
