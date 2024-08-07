package AssignmentFolder.day0807;

public class Account {
    private String accountNo;
    private boolean creditLine;
    private int creditLineLimit;
    private int balance;

    public Account() {
    }

    public Account(String accountNo, boolean creditLine, int creditLineLimit, int balance) {
        setAccountNo(accountNo);
        setCreditLine(creditLine);
        setCreditLineLimit(creditLineLimit);
        setBalance(balance);
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public void setCreditLine(boolean creditLine) {
        this.creditLine = creditLine;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setCreditLineLimit(int creditLineLimit) {
        this.creditLineLimit = creditLineLimit;
    }

    public void withdraw(int money) throws limitExcessException {

        if (this.creditLine) {
            if (this.balance + this.creditLineLimit - money < 0) {
                throw new limitExcessException();
            } else {
                this.balance -= money;
            }
        } else {
            this.balance -= money;
            if (this.balance < 0) {
                throw new limitExcessException();
            }
        }

    }

    public void deposit(int money) {
        this.balance += money;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" 계좌번호: " + this.accountNo + ", 잔고: " + this.balance);
        if (this.creditLine == true) {
            sb.append("\t [[ -" + this.creditLineLimit + "원 마이너스 통장 ]]");
        }
        return sb.toString();
    }


}

