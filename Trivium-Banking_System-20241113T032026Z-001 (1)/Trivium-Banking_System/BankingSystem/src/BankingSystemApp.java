import services.*;
import models.*;
import java.util.*;

public class BankingSystemApp {
    public static void main(String[] args) {
        BankingService service = new BankingServiceImpl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\nBanking System");
                System.out.println("1. Add Customer");
                System.out.println("2. Add Account");
                System.out.println("3. Add Beneficiary");
                System.out.println("4. Add Transaction");
                System.out.println("5. Find Customer by ID");
                System.out.println("6. List Accounts by Customer");
                System.out.println("7. List Transactions by Account");
                System.out.println("8. List Beneficiaries by Customer");
                System.out.println("9. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Clear the buffer

                switch (choice) {
                    case 1:
                        addCustomer(service, scanner);
                        break;
                    case 2:
                        addAccount(service, scanner);
                        break;
                    case 3:
                        addBeneficiary(service, scanner);
                        break;
                    case 4:
                        addTransaction(service, scanner);
                        break;
                    case 5:
                        findCustomerById(service, scanner);
                        break;
                    case 6:
                        listAccountsByCustomer(service, scanner);
                        break;
                    case 7:
                        listTransactionsByAccount(service, scanner);
                        break;
                    case 8:
                        listBeneficiariesByCustomer(service, scanner);
                        break;
                    case 9:
                        System.out.println("Thank you for using the Banking System!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    private static void addCustomer(BankingService service, Scanner scanner) {
        System.out.print("Enter Customer ID: ");
        int cid = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Contact: ");
        String contact = scanner.nextLine();
        service.addCustomer(new Customer(cid, name, address, contact));
        System.out.println("Customer added successfully!");
    }

    private static void addAccount(BankingService service, Scanner scanner) {
        System.out.print("Enter Account ID: ");
        int accountId = scanner.nextInt();
        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer
        System.out.print("Enter Account Type (Saving/Current): ");
        String type = scanner.nextLine();
        System.out.print("Enter Initial Balance: ");
        double balance = scanner.nextDouble();
        service.addAccount(new Account(accountId, customerId, type, balance));
        System.out.println("Account added successfully!");
    }

    private static void addBeneficiary(BankingService service, Scanner scanner) {
        System.out.print("Enter Beneficiary ID: ");
        int beneficiaryId = scanner.nextInt();
        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer
        System.out.print("Enter Beneficiary Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Beneficiary Account Number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter Bank Details: ");
        String bankDetails = scanner.nextLine();
        service.addBeneficiary(new Beneficiary(beneficiaryId, customerId, name, accountNumber, bankDetails));
        System.out.println("Beneficiary added successfully!");
    }

    private static void addTransaction(BankingService service, Scanner scanner) {
        System.out.print("Enter Transaction ID: ");
        int transactionId = scanner.nextInt();
        System.out.print("Enter Account ID: ");
        int accountId = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer
        System.out.print("Enter Transaction Type (Deposit/Withdraw): ");
        String type = scanner.nextLine();
        System.out.print("Enter Amount: ");
        double amount = scanner.nextDouble();
        service.addTransaction(new Transaction(transactionId, accountId, type, amount));
        System.out.println("Transaction added successfully!");
    }

    private static void findCustomerById(BankingService service, Scanner scanner) {
        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();
        Customer customer = service.findCustomerById(customerId);
        if (customer != null) {
            System.out.println("Customer Details: " + customer);
        } else {
            System.out.println("Customer not found.");
        }
    }

    private static void listAccountsByCustomer(BankingService service, Scanner scanner) {
        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();
        List<Account> accounts = service.getAccountsByCustomerId(customerId);
        if (!accounts.isEmpty()) {
            System.out.println("Accounts for Customer ID: " + customerId);
            accounts.forEach(System.out::println);
        } else {
            System.out.println("No accounts found for this customer.");
        }
    }

    private static void listTransactionsByAccount(BankingService service, Scanner scanner) {
        System.out.print("Enter Account ID: ");
        int accountId = scanner.nextInt();
        List<Transaction> transactions = service.getTransactionsByAccountId(accountId);
        if (!transactions.isEmpty()) {
            System.out.println("Transactions for Account ID: " + accountId);
            transactions.forEach(System.out::println);
        } else {
            System.out.println("No transactions found for this account.");
        }
    }

    private static void listBeneficiariesByCustomer(BankingService service, Scanner scanner) {
        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();
        List<Beneficiary> beneficiaries = service.getBeneficiariesByCustomerId(customerId);
        if (!beneficiaries.isEmpty()) {
            System.out.println("Beneficiaries for Customer ID: " + customerId);
            beneficiaries.forEach(System.out::println);
        } else {
            System.out.println("No beneficiaries found for this customer.");
        }
    }
}
