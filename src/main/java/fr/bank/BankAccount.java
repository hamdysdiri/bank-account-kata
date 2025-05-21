package fr.bank;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankAccount {
    private final List<Transaction> transactions = new ArrayList<>();
    private final Statement formatter = new Statement();
    private final Printer printer;

    public BankAccount(Printer printer) {
        this.printer = printer;
    }

    public void deposit(int amount) {
        transactions.add(new Transaction(LocalDate.now(), amount));
    }

    public void withdraw(int amount) {
        transactions.add(new Transaction(LocalDate.now(), -amount));
    }

    public List<Transaction> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }

    public void printStatement() {
        List<String> lines = formatter.formatLines(transactions);
        printer.printLines(lines);
    }

}
