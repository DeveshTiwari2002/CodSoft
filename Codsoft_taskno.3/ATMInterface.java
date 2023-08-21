import java.util.Scanner;

// ATM interface
interface ATM {
    void checkBalance();

    void deposit();

    void withdraw();
}

// ATM implementation
class ATMImpl implements ATM {
    private double balance;

    public ATMImpl() {
        balance = 0.0;
    }

    @Override
    public void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }

    @Override
    public void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount you want to deposit: $");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
            checkBalance();
        } else {
            System.out.println("Invalid amount. Deposit amount should be positive.");
        }
    }

    @Override
    public void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount you want to withdraw: $");
        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
            checkBalance();
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        ATM atm = new ATMImpl();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nATM MENU");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    atm.deposit();
                    break;
                case 3:
                    atm.withdraw();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
