package entidades;

public class Loja {

    private static int iCount = 0;
    private static final int MAX_LOJAS = 2;
    Loja(int numeroConta, double saldoInicial, int senha, String nomeUsuario) throws Exception{
        if (iCount >= MAX_LOJAS) {
            throw new Exception("Número máximo de lojas atingido.");
        }
        iCount++;

    }
}
