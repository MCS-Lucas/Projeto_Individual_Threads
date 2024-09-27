package usuarios;
import entidades.*;
import gerenciador.Main;
import op_bancarias.*;

    public class Funcionario extends Pessoa implements Runnable{
        private static int iCount = 0;
        private static final int MAX_FUNCIONARIOS = 4;
        private ContaFuncionario conta, contaInvestimentos;
        private Loja loja;
        private Banco banco;

        public Funcionario(String nome, String cpf, int idade, Loja loja) throws Exception {
            super(nome, cpf, idade);
            if (iCount >= MAX_FUNCIONARIOS) {
                throw new Exception("Número máximo de clientes atingido.");
            }
            iCount++;
            this.conta = new ContaFuncionario(0.0,getNome(), banco);
            this.contaInvestimentos = new ContaFuncionario(0.0,getNome(), banco);
            this.loja = loja;

        }
        public ContaFuncionario getConta() {
            return conta;
        }
        public ContaFuncionario getContaInvestimentos() {
            return contaInvestimentos;
        }

        public void run() {

            try{
                synchronized (Main.class) {
                    while (Main.clientesAtendidos < 10) {
                        Main.clientesComprando.await();
                    }
                }

                loja.getConta().pagarFuncionario(this);

                conta.depositarInvestimento(this);

            }catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
    }
