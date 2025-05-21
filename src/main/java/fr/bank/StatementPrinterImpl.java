package fr.bank;

import java.util.List;

public class StatementPrinterImpl implements Printer{
    private final java.io.PrintStream out;
    public StatementPrinterImpl(java.io.PrintStream out) {
        this.out = out;
    }

    @Override
    public void printLines(List<String> lines) {
        lines.forEach(out::println);
    }
}
