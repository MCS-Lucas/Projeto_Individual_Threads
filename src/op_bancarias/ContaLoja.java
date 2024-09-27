package op_bancarias;

import usuarios.Funcionario;

public class ContaLoja extends Conta{

    double salario = 1400.00;

    public ContaLoja(double saldoAtual, String nomeUsuario) {
        super(saldoAtual, nomeUsuario);

    }

    public void pagarFuncionario(Funcionario funcionario){

        if (this.getSaldo() >= salario){

            banco.transacao(this, salario, funcionario.getConta());

        }

    }
}
