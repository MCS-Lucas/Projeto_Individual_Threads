package op_bancarias;
import entidades.*;
import java.util.Random;

public class ContaCliente extends Conta{

    private static int iCount = 0;
    private static final int MAX_COMPRAS = 4;

    public ContaCliente(double saldoAtual, String nomeUsuario) {
        super(saldoAtual, nomeUsuario);

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
