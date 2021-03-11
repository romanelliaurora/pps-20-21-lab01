package lab01.example.model;

public class SimpleBankAccountWithAtm extends SimpleBankAccount {



    public SimpleBankAccountWithAtm(AccountHolder holder, double balance) {
        super(holder, balance);

    }

    public void depositAtm(final int usrID, final double amount) {
        double amountWithFee = amount -1;
        if (checkUser(usrID)) {
            setBalance(getBalance()+amountWithFee);
        }
    }
    public void withdrawAtm(final int usrID, final double amount) {
        double amountWithFee = amount +1;
        if (checkUser(usrID) && isWithdrawAllowed(amountWithFee)) {
            setBalance(getBalance()-amountWithFee);
        }
    }

}
