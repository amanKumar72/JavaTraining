package BankSystem;

public class Account {
    private String name;
    private String accountNo;
    private Double balance;
    private String password;

    public Account(String accountNo, Double balance, String name, String password) {
        this.accountNo = accountNo;
        this.balance = balance;
        this.name = name;
        this.password = password;
    }

    public String getAccountNo() {
        return accountNo;
    }



    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
