import java.util.Scanner;

class AccountBank {
    private String name;
    private String surname;
    private int cpf;
    private double balance;

    public AccountBank(String name, String surname, int cpf) {
        this.name = name;
        this.surname = surname;
        this.cpf = cpf;
        this.balance = 0.0;
    }

    public void deposit(double value) {
        if (value > 0) {
            balance += value;
            System.out.printf("Depósito de R$%.2f realizado com sucesso.%n", value);
            showBalance();
        } else {
            System.out.println("Error! Valor inválido para depósito.");
        }
    }

    public void withdraw(double value) {
        if (value > 0 && value <= balance) {
            balance -= value;
            System.out.printf("Saque de R$%.2f realizado com sucesso.%n", value);
            showBalance();
        } else {
            System.out.println("Error! Saldo insuficiente para realizar o saque.");
        }
    }

    public void showBalance() {
        System.out.printf("Saldo disponível: R$%.2f%n", balance);
    }
}

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo(a) ao seu Banco!");

        System.out.print("Por favor, digite seu nome: ");
        String name = scanner.nextLine();
        System.out.print("Por favor, digite seu sobrenome: ");
        String surname = scanner.nextLine();
        System.out.print("Por favor, digite seu CPF: ");
        int cpf = scanner.nextInt();

        AccountBank account = new AccountBank(name, surname, cpf);

        while (true) {
            System.out.println("\nO que você deseja fazer?");
            System.out.println("[1] - Consultar saldo");
            System.out.println("[2] - Realizar depósito");
            System.out.println("[3] - Realizar saque");
            System.out.println("[4] - Encerrar acesso");
            System.out.print("Opção: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    account.showBalance();
                    break;
                case 2:
                    System.out.print("Digite o valor do depósito: ");
                    double deposit = scanner.nextDouble();
                    account.deposit(deposit);
                    break;
                case 3:
                    System.out.print("Digite o valor do saque: ");
                    double withdraw = scanner.nextDouble();
                    account.withdraw(withdraw);
                    break;
                case 4:
                    System.out.println("Encerrando aplicação. Obrigado!");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }
}
