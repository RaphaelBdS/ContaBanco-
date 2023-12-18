import java.math.BigDecimal;
import java.util.Scanner;

public class ContaTerminal {
    enum Atributo {
        NUMERO,
        AGENCIA,
        NOME,
        SALDO

    }

    public static void main(String[] args) throws Exception {

        String entrada = "";
        String agencia = "";
        String nome = "";
        int numeroConta = 0;
        BigDecimal saldo = new BigDecimal("0.00");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor digite o(a): " + Atributo.NUMERO + " da conta\nDigite s para sair!");
        entrada = scanner.nextLine();

        if (validaEntrada(entrada, Integer.class))
            numeroConta = Integer.parseInt(entrada);

        System.out.println("Por favor digite o(a): " + Atributo.AGENCIA + "\nDigite s para sair!");
        entrada = scanner.nextLine();

        if (validaEntrada(entrada, String.class))
            agencia = entrada;

        System.out.println("Por favor digite o(a): " + Atributo.NOME + "\nDigite s para sair!");
        entrada = scanner.nextLine();

        if (validaEntrada(entrada, String.class))
            nome = entrada;

        System.out.println("Por favor digite o(a): " + Atributo.SALDO + "\nDigite s para sair!");
        entrada = scanner.nextLine();

        if (validaEntrada(entrada, BigDecimal.class))
            saldo = new BigDecimal(entrada);

        System.out.println("-----------\nOlá " + nome + ", obrigado por criar uma conta em nosso banco.");
        System.out.println("Sua agência é " + agencia + " e conta " + numeroConta + ".");
        System.out.println("Seu saldo de " + saldo + " já está disponível para saque.\n---------");

        System.out.println("Saindo.....");

        scanner.close();

    }

    public static boolean validaEntrada(Class<?> type, String mensagem, String entrada) {
        System.out.println(mensagem);
        return validaEntrada(entrada, type);
    }

    public static boolean validaEntrada(String entrada, Class<?> type) {

        try {
            switch (type.getSimpleName()) {
                case "Integer":
                    Integer.parseInt(entrada);
                    break;
                case "Float":
                    Float.parseFloat(entrada);
                    break;
                case "BigDecimal":
                    new BigDecimal(entrada);
                    break;
                case "Long":
                    Long.parseLong(entrada);
                    break;
                case "String":
                    //
                    break;
                default:
                    return false;
            }
        } catch (NumberFormatException nfe) {
            System.err.println("Entrada inválida!");
            return false;
        }
        return true;
    }
}
