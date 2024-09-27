package op_bancarias;

import entidades.Banco;
import usuarios.Funcionario;

public class ContaLoja extends Conta{

    double salario = 1400.00;

    public ContaLoja(double saldoAtual, String nomeUsuario, Banco banco) {
        super(saldoAtual, nomeUsuario, banco);
        this.banco = banco;
    }

    public void pagarFuncionario(Funcionario funcionario){

        if (this.getSaldo() >= salario){

            banco.transacao(this, salario, funcionario.getConta());

        }

    }
}
