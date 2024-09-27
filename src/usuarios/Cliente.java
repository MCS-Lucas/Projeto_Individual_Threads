package usuarios;
import gerenciador.Main;
import static gerenciador.Main.lock;
import static gerenciador.Main.clientesComprando;
import op_bancarias.ContaCliente;
import entidades.*;
import java.util.List;

public class Cliente extends Pessoa implements Runnable{

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

        this.conta = new ContaCliente(2000.0,getNome(), banco);
        this.lojas = lojas;
        this.banco = banco;

    }

    public ContaCliente getConta() {
        return conta;
    }

    public void run() {
        try {
            for (int i = 0; i < 2; i++) {
                conta.comprar(lojas.get(0));
            }
            for (int i = 0; i < 2; i++) {
                conta.comprar(lojas.get(1));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        lock.lock(); // Adquirir o lock
        try {
            Main.clientesAtendidos++;
            if (Main.clientesAtendidos == 10) {
                clientesComprando.signalAll(); // Sinalizar todas as threads aguardando
            }
        } finally {
            lock.unlock(); // Liberar o lock
        }
    }
}


