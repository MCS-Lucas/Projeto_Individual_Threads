package op_bancarias;

import entidades.Banco;
import usuarios.Funcionario;

public class ContaFuncionario extends Conta{

    public ContaFuncionario(double saldoAtual, String nomeUsuario, Banco banco) throws Exception {
        super(saldoAtual, nomeUsuario, banco);
        if (banco == null) {
            throw new Exception("O banco não pode ser nulo.");
        }
        this.banco = banco;
    }

    public double depositarInvestimento(Funcionario funcionario){

        double valorDepositado = funcionario.getConta().getSaldo() * 0.20;
        banco.transacao(this, (funcionario.getConta().getSaldo() * 0.20), funcionario.getContaInvestimentos());

        return valorDepositado;
    }
}
