package fr.bank.test;

import fr.bank.BankAccount;
import fr.bank.Printer;
import fr.bank.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;

public class BankAccountTest {
    Printer printer;
    BankAccount account;
    @Before
    public void setUp() {
        printer = createMock(Printer.class);
        account = new BankAccount(printer);

    }
    @Test
    public void deposit_should_add_transaction() {
        replay(printer);
        account.deposit(200);
        List<Transaction> txs = account.getTransactions();
        assertEquals(1, txs.size());
        assertEquals(200, txs.getFirst().amount());
        verify(printer);
    }

    @Test
    public void withdraw_should_add_transaction() {
        replay(printer);
        account.withdraw(150);
        List<Transaction> txs = account.getTransactions();
        assertEquals(1, txs.size());
        assertEquals(-150, txs.getFirst().amount());
        verify(printer);
    }

}
