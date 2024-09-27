package usuarios;
import op_bancarias.Conta;

public class Cliente implements Runnable{

    private static int iCount = 0;
    private static final int MAX_CLIENTES = 10;

    private String nome;
    private String cpf;
    private int idade;


    public Cliente(String nome, String cpf, int idade) throws Exception {
        if (iCount >= MAX_CLIENTES) {
            throw new Exception("Número máximo de clientes atingido.");
        }
        iCount++;
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public void run() {

    }
}