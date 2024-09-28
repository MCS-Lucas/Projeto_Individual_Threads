package op_bancarias;
import java.util.Random;
import entidades.Banco;


    public class Conta {

    private Random random = new Random();
    protected int numeroConta;
    protected double saldo;
    protected String nomeUsuario;
    protected Banco banco;

    public Conta( double saldoAtual, String nomeUsuario, Banco banco){

        if (banco == null) {
            throw new IllegalArgumentException("O banco não pode ser nulo.");
        }

        this.nomeUsuario = nomeUsuario;
        this.numeroConta = random.nextInt(2001) + 1000;
        this.saldo = saldoAtual;
        this.banco = banco;

    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public Banco getBanco() {
        return banco;
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
                "\nSaldo Atual: " + getSaldo();
       }

}
