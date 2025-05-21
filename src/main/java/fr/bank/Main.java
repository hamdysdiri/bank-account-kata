package fr.bank;

public class Main {
    public static void main(String[] args) {
        Printer printer = new StatementPrinterImpl(System.out);
        var account = new BankAccount(printer);

        account.deposit(1000);
        account.withdraw(300);
        account.deposit(500);
        account.printStatement();
    }
}