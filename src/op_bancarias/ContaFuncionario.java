package op_bancarias;

import entidades.Banco;
import usuarios.Funcionario;

public class ContaFuncionario extends Conta{

    public ContaFuncionario(double saldoAtual, String nomeUsuario, Banco banco) {
        super(saldoAtual, nomeUsuario);
        this.banco = banco;
    }

    public void depositarInvestimento(Funcionario funcionario){

        banco.transacao(this, (funcionario.getConta().getSaldo() * 0.20), funcionario.getContaInvestimentos());

    }
}
