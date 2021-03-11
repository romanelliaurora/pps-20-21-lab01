package lab01.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class SimpleBankAccountWithAtmTest extends BankAccountTest {


    @BeforeEach
    void beforeEach(){
        setAccountHolder(new AccountHolder("Mario", "Rossi", 1));
        setBankAccount(new SimpleBankAccountWithAtm(getAccountHolder(), 0));
    }
    @Test
    void testDepositWithAtm() {
        ((SimpleBankAccountWithAtm)getBankAccount()).depositAtm(getAccountHolder().getId(), 100);
        assertEquals(99, getBankAccount().getBalance());
    }

    @Test
    void testWithdrawWithAtm() {
        ((SimpleBankAccountWithAtm)getBankAccount()).depositAtm(getAccountHolder().getId(), 100);
        ((SimpleBankAccountWithAtm)getBankAccount()).withdrawAtm(getAccountHolder().getId(), 70);
        assertEquals(28, getBankAccount().getBalance());
    }


}