package op_bancarias;
import java.util.Random;

public class Conta {

    protected Random random = new Random();
    private int numeroConta;
    private double saldo;
    private String nomeUsuario;

    Conta( double saldoInicial, String nomeUsuario){

        this.nomeUsuario = nomeUsuario;
        this.numeroConta = random.nextInt(2001) + 1000;
        this.saldo = saldo;

    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public void debitar(double valor){
        this.saldo -= valor;
    }
    public void depositar(double valor){
        this.saldo += valor;
    }

}
