package usuarios;
import op_bancarias.ContaFuncionario;

public class Funcionario extends Pessoa implements Runnable{
    private static int iCount = 0;
    private static final int MAX_FUNCIONARIOS = 4;
    private ContaFuncionario conta;

    public Funcionario(String nome, String cpf, int idade) throws Exception {
        super(nome, cpf, idade);
        if (iCount >= MAX_FUNCIONARIOS) {
            throw new Exception("Número máximo de clientes atingido.");
        }
        iCount++;
        this.conta = new ContaFuncionario(0.0,getNome());
    }

    public ContaFuncionario getConta() {
        return conta;
    }

    public void run() {

    }
}
