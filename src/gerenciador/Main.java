package gerenciador;
import entidades.Loja;
import usuarios.Funcionario;
import usuarios.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {

        int i;
        Scanner scanner = new Scanner(System.in);
        String[] nome = {"Lucas", "Eduardo", "Guilherme", "Yago","Carolina","Luiz","Adriana","Ana", "Allan", "Matheus", "Victor","Gustavo", "Gabriel", "João"};
        String[] cpf = {"321.654.987-00", "789.456.123-00","123.456.789-00", "987.654.321-00", "321.654.987-00", "789.456.123-00","123.456.789-00", "987.654.321-00", "321.654.987-00", "789.456.123-00","123.456.789-00", "987.654.321-00", "321.654.987-00", "789.456.123-00"};
        int[] idade = {21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34};

        List<Thread> t = new ArrayList<>();


        for(i = 0; i < 4; i++) {
            try {
                Funcionario funcionario = new Funcionario(nome[i], cpf[i], idade[i]);
                System.out.println("Funcionário " + (i + 1) + " cadastrado com sucesso.");

                Thread thread = new Thread(funcionario);
                t.add(thread);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for(i = 4; i < 14; i++) {
            try {
                Cliente cliente = new Cliente(nome[i], cpf[i], idade[i]);
                System.out.println("Cliente " + (i -3) + " cadastrado com sucesso.");

                Thread thread = new Thread(cliente);
                t.add(thread);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
