package gerenciador;
import entidades.Loja;
import usuarios.Funcionario;
import usuarios.Cliente;
import entidades.Banco;
import op_bancarias.*;

import javax.print.attribute.standard.PrinterStateReasons;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;


public class Main {
    public static int clientesAtendidos = 0;
    public static Lock lock = new ReentrantLock();
    public static Condition clientesComprando = lock.newCondition();
    public Conta conta;

    public static void main(String[] args) throws Exception {

        int i;
        Scanner scanner = new Scanner(System.in);
        String[] nome = {"Lucas", "Eduardo", "Guilherme", "Yago","Carolina","Luiz","Adriana","Ana", "Allan", "Matheus", "Victor","Gustavo", "Gabriel", "João"};
        String[] cpf = {"321.654.987-00", "789.456.123-00","123.456.789-00", "987.654.321-00", "321.654.987-00", "789.456.123-00","123.456.789-00", "987.654.321-00", "321.654.987-00", "789.456.123-00","123.456.789-00", "987.654.321-00", "321.654.987-00", "789.456.123-00"};
        int[] idade = {21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34};
        String[] nomeLoja = {"Adidas", "Nike"};
        StringBuilder printer = new StringBuilder();

        Banco banco = new Banco();

        if (banco == null) {
            throw new Exception("O banco não pode ser nulo.");
        }

        List<Thread> t = new ArrayList<>();
        List<Loja> lojas = new ArrayList<>();

        for(i = 0; i < 2; i++) {
            try {
                Loja loja = new Loja(nomeLoja[i], banco);
                lojas.add(loja);
                System.out.println("Loja " + loja.getNomeLoja() + " cadastrada com sucesso.");
                banco.armazenarConta(loja.getConta());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println();
        System.out.println();

        for(i = 0; i < 4; i++) {
            try {
                Loja empregadora = lojas.get(i % 2);
                Funcionario funcionario = new Funcionario(nome[i], cpf[i], idade[i], empregadora, banco);
                empregadora.addFuncionario(funcionario);
                banco.armazenarConta(funcionario.getConta());
                System.out.println("Funcionário " + funcionario.getNome() + " cadastrado com na Loja " + empregadora.getNomeLoja() + " sucesso.");
                Thread thread = new Thread(funcionario);
                t.add(thread);
                thread.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println();
        System.out.println();

        for(i = 4; i < 14; i++) {
            try {
                Cliente cliente = new Cliente(nome[i], cpf[i], idade[i], lojas, banco);
                System.out.println("Cliente " + cliente.getNome() + " cadastrado com sucesso.");
                banco.armazenarConta(cliente.getConta());
                Thread thread = new Thread(cliente);
                t.add(thread);
                thread.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println();
        System.out.println();

        for(Thread thread : t) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        printer.append("------------------------------------------\n");
        printer.append("===============INFORMAÇÕES DA LOJA===============\n");
        printer.append(lojas.get(0).getConta().verificarConta()).append("\n\n");
        printer.append("FUNCIONÁRIOS:").append("\n\n");
        printer.append("------------------------------------------\n");
        for (Funcionario funcionario : lojas.get(0).getFuncionarios()) {
            printer.append(funcionario.toString()).append("\n");
            printer.append("------------------------------------------\n");
        }
        printer.append("\n");
        printer.append("===============INFORMAÇÕES DA LOJA===============\n");
        printer.append(lojas.get(1).getConta().verificarConta()).append("\n\n");
        printer.append("FUNCIONÁRIOS:").append("\n\n");
        printer.append("------------------------------------------\n");
        for (Funcionario funcionario : lojas.get(1).getFuncionarios()) {
            printer.append(funcionario.toString()).append("\n");
            printer.append("------------------------------------------\n");
        }

        System.out.println(printer.toString());
    }
}
