package entidades;
import op_bancarias.Conta;
import usuarios.Funcionario;
import java.util.ArrayList;
import java.util.List;

public class Loja {

    private static int iCount = 0;
    private static final int MAX_LOJAS = 2;
    private static final int MAX_FUNCIONARIOSL = 2;
    private List<Funcionario> funcionarios;

    public Loja() throws Exception{
        if (iCount >= MAX_LOJAS) {
            throw new Exception("Número máximo de lojas atingido.");
        }
        iCount++;
        this.funcionarios = new ArrayList<>();

    }

    public void addFuncionario(Funcionario funcionario) throws Exception {
        if (funcionarios.size() >= MAX_FUNCIONARIOSL) {
            throw new Exception("Número máximo de funcionários por loja atingido.");
        }
        funcionarios.add(funcionario);
    }
}
