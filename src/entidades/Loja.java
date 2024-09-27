package entidades;
import op_bancarias.ContaCliente;
import op_bancarias.ContaLoja;
import usuarios.Funcionario;
import java.util.ArrayList;
import java.util.List;

public class Loja {

    private static int iCount = 0;
    private static final int MAX_LOJAS = 2;
    private static final int MAX_FUNCIONARIOSL = 2;
    private List<Funcionario> funcionarios;
    private String nomeLoja;
    private ContaLoja conta;
    private Banco banco;



    public Loja(String nomeLoja) throws Exception{
        if (iCount >= MAX_LOJAS) {
            throw new Exception("Número máximo de lojas atingido.");
        }
        iCount++;
        this.nomeLoja = nomeLoja;
        this.conta = new ContaLoja(0.0,getNomeLoja(), banco);
        this.funcionarios = new ArrayList<>();

    }

    public String getNomeLoja() {
        return nomeLoja;
    }

    public void addFuncionario(Funcionario funcionario) throws Exception {
        if (funcionarios.size() >= MAX_FUNCIONARIOSL) {
            throw new Exception("Número máximo de funcionários por loja atingido.");
        }
        funcionarios.add(funcionario);
    }
    public ContaLoja getConta() {
        return conta;
    }

}
