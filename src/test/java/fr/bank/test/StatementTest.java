package fr.bank.test;

import fr.bank.Statement;
import fr.bank.Transaction;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StatementTest {

    @Test
    public void print_statement_() {
        var statement = new Statement();
        Transaction t1 = new Transaction(LocalDate.of(2024,5,21), 1000);
        List<String> lines = statement.formatLines(List.of(t1));
        assertEquals("DATE | AMOUNT | BALANCE", lines.get(0));
        assertEquals("2024-05-21 | 1000 | 1000", lines.get(1));
    }

}