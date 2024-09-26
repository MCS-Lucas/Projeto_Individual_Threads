package op_bancarias;

public class Conta {

    private int numeroConta;
    private double saldo;
    private int senha;
    private String nomeUsuario;

    Conta(int numeroConta, double saldoInicial, int senha, String nomeUsuario){

        this.nomeUsuario = nomeUsuario;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.senha = senha;

    }

    public void getnomeUsuario(String nomeUsuario){
        this.nomeUsuario = nomeUsuario;
    }
    public String setnomeUsuario(){
        return nomeUsuario;
    }
    public void getnumeroConta(int numeroConta){
        this.numeroConta = numeroConta;
    }
    public int setnumeroConta(){
        return numeroConta;
    }
    public void getsaldo(double saldo){
        this.saldo = saldo;
    }
    public double setsaldo(){
        return saldo;
    }
    public void getsenha(int senha){
        this.senha = senha;
    }
    public int setsenha(){
        return senha;
    }
    public void debitar(double valor){
        this.saldo -= valor;
    }
    public void depositar(double valor){
        this.saldo += valor;
    }

}
