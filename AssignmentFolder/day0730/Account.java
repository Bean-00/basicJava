package AssignmentFolder.day0730;

public class Account {
    String accNo;
    int balance;

    public Account(String s) {
        this.accNo = s;
        System.out.println(accNo + " 계좌가 개설되었습니다.");
    }

    void setBalance(int balance) {
        this.balance = balance;
    }

    void save(int money) {
        this.balance += money;
        System.out.println(accNo + " 계좌에 " + money + "만원이 입금되었습니다.");
    }

    void deposit(int money) {
        this.balance -= money;
        System.out.println(accNo + " 계좌에 " + money + "만원이 출금되었습니다.");
    }

    String getAccNo() {
        return accNo;
    }

    int getBalance() {
        return this.balance;
    }

}
