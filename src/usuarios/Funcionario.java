package usuarios;

public class Funcionario {
    private static int iCount = 0;
    private static final int MAX_FUNCIONARIOS = 4;

    private String nome;
    private String cpf;
    private int idade;


    Funcionario(int numeroConta, double saldoInicial, int senha, String nomeUsuario) throws Exception {
        if (iCount >= MAX_FUNCIONARIOS) {
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
}
