package op_bancarias;
import java.util.Random;
import entidades.Banco;


    public class Conta {

    private Random random = new Random();
    protected int numeroConta;
    protected double saldo;
    protected String nomeUsuario;
    protected Banco banco;

    Conta( double saldoAtual, String nomeUsuario){

        this.nomeUsuario = nomeUsuario;
        this.numeroConta = random.nextInt(2001) + 1000;
        this.saldo = saldoAtual;

    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void debitar(double valor){
        this.saldo -= valor;
    }
    public void depositar(double valor){
        this.saldo += valor;
    }

    public String verificarConta(){
        return "Nome: " + getNomeUsuario() +
                "\nNúmero da conta: " + getNumeroConta() +
                "\nSaldo: " + getSaldo();
       }

}
