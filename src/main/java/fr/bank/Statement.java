package fr.bank;

import java.io.PrintStream;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Statement {
    private static final String HEADER = "DATE | AMOUNT | BALANCE";
    private static final DateTimeFormatter DTF = DateTimeFormatter.ISO_LOCAL_DATE;

    public List<String> formatLines(List<Transaction> transactions) {
        List<String> lines = new ArrayList<>();
        lines.add(HEADER);
        int balance = 0;
        for (Transaction t : transactions) {
            balance += t.amount();
            lines.add(String.format(
                    "%s | %d | %d",
                    t.date().format(DTF),
                    t.amount(),
                    balance
            ));
        }
        return lines;
    }

}
