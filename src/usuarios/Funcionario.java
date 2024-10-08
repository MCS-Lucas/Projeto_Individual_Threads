package usuarios;
import entidades.*;
import gerenciador.Main;
import op_bancarias.*;

public class Funcionario extends Pessoa implements Runnable {
    private static int iCount = 0;
    private static final int MAX_FUNCIONARIOS = 10;
    private ContaFuncionario conta;
    private ContaFuncionario contaInvestimentos;
    private Loja loja;
    private static boolean primeiroPrint= false;
    private Banco banco;

    public Funcionario(String nome, String cpf, int idade, Loja loja, Banco banco) throws Exception {
        super(nome, cpf, idade);
        if (iCount >= MAX_FUNCIONARIOS) {
            throw new Exception("Número máximo de funcionários atingido.");
        }
        iCount++;
        this.conta = new ContaFuncionario(0.0, getNome(), banco);
        this.contaInvestimentos = new ContaFuncionario(0.0, getNome(), banco);
        this.loja = loja;
        this.banco = banco;
        if (loja == null) {
            throw new Exception("Loja não pode ser nula.");
        }
        if (banco == null) {
            throw new Exception("Banco não pode ser nulo.");
        }
    }
    public ContaFuncionario getConta() {
        return conta;
    }
    public ContaFuncionario getContaInvestimentos() {
        return contaInvestimentos;
    }
    public void run() {

        StringBuilder organizador = new StringBuilder();

        try {

            Main.lock.lock();
            try {
                while (Main.clientesAtendidos != 10) {
                    Main.clientesComprando.await();
                }
            } finally {
                Main.lock.unlock();
            }

            if (!primeiroPrint) {
                organizador.append("INFORMAÇÕES FUNCIONARIOS");
                organizador.append("\n\n");
                primeiroPrint = true;
            }

            organizador.append("===================EXTRATO====================\n");
            loja.getConta().pagarFuncionario(this);
            organizador.append("Funcionário ").append(getNome()).append(" recebeu o salário.\n");
            conta.depositarInvestimento(this);
            organizador.append("Funcionário ").append(getNome()).append(" depositou 20% do salário em investimentos.\n");
            organizador.append("+============INFORMAÇÕES DA CONTA=============+\n");
            organizador.append(conta.verificarConta()).append("\n");
            organizador.append("+====INFORMAÇÕES DA CONTA DE INVESTIMENTOS====+\n");
            organizador.append(contaInvestimentos.verificarConta()).append("\n");
            organizador.append("==============================================\n");

            synchronized (System.out) {
                System.out.println(organizador.toString());
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + "\n" +
                "Cpf: " + getCpf() + "\n" +
                "Idade: " + getIdade();
    }
}
