package usuarios;
import op_bancarias.ContaCliente;

public class Cliente extends Pessoa implements Runnable{

    private static int iCount = 0;
    private static final int MAX_CLIENTES = 10;
    private ContaCliente conta;

    public Cliente(String nome, String cpf, int idade) throws Exception {
        super(nome, cpf, idade);
        if (iCount >= MAX_CLIENTES) {
            throw new Exception("Número máximo de clientes atingido.");
        }
        iCount++;

        this.conta = new ContaCliente(2000.0,getNome());
    }

    public ContaCliente getConta() {
        return conta;
    }

    public void run() {



    }


}