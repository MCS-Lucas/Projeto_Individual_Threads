package usuarios;
import gerenciador.Main;
import static gerenciador.Main.lock;
import static gerenciador.Main.clientesComprando;
import op_bancarias.ContaCliente;
import entidades.*;
import java.util.List;

public class Cliente extends Pessoa implements Runnable {
    private static int iCount = 0;
    private static final int MAX_CLIENTES = 10;
    private ContaCliente conta;
    private List<Loja> lojas;
    private Banco banco;

    public Cliente(String nome, String cpf, int idade, List<Loja> lojas, Banco banco) throws Exception {
        super(nome, cpf, idade);
        if (iCount >= MAX_CLIENTES) {
            throw new Exception("Número máximo de clientes atingido.");
        }
        iCount++;
        this.conta = new ContaCliente(2000.0, getNome(), banco);
        this.lojas = lojas;
        this.banco = banco;
        if (lojas == null || lojas.isEmpty()) {
            throw new Exception("Lista de lojas não pode ser nula ou vazia.");
        }
        if (banco == null) {
            throw new Exception("Banco não pode ser nulo.");
        }
    }
    public ContaCliente getConta() {

        return conta;
    }

    public void run() {

        StringBuilder organizador = new StringBuilder();

        try {

            organizador.append("===================EXTRATO====================\n");

            for (int i = 0; i < 2; i++) {
                double valorCompra = conta.comprar(lojas.get(0));
                organizador.append("Cliente ").append(getNome()).append(" comprou na loja ").append(lojas.get(0).getNomeLoja()).append("\n");
                organizador.append("Valor da transação: R$ ").append(String.format("%.2f", valorCompra)).append("\n");
                organizador.append("------------------------------------------\n");

            }
            for (int i = 0; i < 2; i++) {
                double valorCompra = conta.comprar(lojas.get(1));
                organizador.append("Cliente ").append(getNome()).append(" comprou na loja ").append(lojas.get(1).getNomeLoja()).append("\n");
                organizador.append("Valor da transação: R$ ").append(String.format("%.2f", valorCompra)).append("\n");
                organizador.append("------------------------------------------\n");
            }
            organizador.append("+============INFORMAÇÕES DA CONTA=============+\n");
            organizador.append(conta.verificarConta()).append("\n");
            organizador.append("==============================================\n");

        } catch (Exception e) {
            organizador.append(e.getMessage()).append("\n");
        }

        synchronized (System.out) {
            System.out.println(organizador.toString());
        }

        Main.lock.lock();
        try {
            Main.clientesAtendidos++;
            if (Main.clientesAtendidos == 10) {
                Main.clientesComprando.signalAll();
            }
        } finally {
            Main.lock.unlock();
        }
    }
}


