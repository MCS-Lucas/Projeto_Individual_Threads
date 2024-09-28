package op_bancarias;
import entidades.*;
import java.util.Random;

public class ContaCliente extends Conta{

    private int iCount;
    private static final int MAX_COMPRAS = 4;

    public ContaCliente(double saldoAtual, String nomeUsuario, Banco banco) throws Exception {
        super(saldoAtual, nomeUsuario, banco);

        if (banco == null) {
            throw new Exception("O banco não pode ser nulo.");
        }
        this.banco = banco;
        this.iCount = 0;

    }

    public double comprar(Loja loja) throws Exception {

        double valorCompra = new Random().nextInt(301) + 200;

        if (iCount >= MAX_COMPRAS) {

            throw new Exception("*BANCO INFORMA* : \n--Número máximo de compras por dia atingido.--");
        }
        if (this.saldo < valorCompra) {

            throw new Exception("*BANCO INFORMA* : \n--Saldo insuficiente.--");
        }

        banco.transacao(this, valorCompra,loja.getConta());

        iCount++;
        return valorCompra;
    }
}
