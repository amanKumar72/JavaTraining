package BankSystem;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    List<Account> accounts=new ArrayList<>();
    private String branch;

    public void withdrawal(String accountNo,String amount,String password){
        Account account=getAccount(accountNo);
        if (account==null){
            System.out.println("Account not exists first create a new account");
            return;
        }
        if(!account.getPassword().equals(password)){
            System.out.println("Password is wrong");
            return;
        }
        if(isValidAmount(amount) ){
            if(Double.parseDouble(amount)<=account.getBalance()){
            account.setBalance(account.getBalance()-Double.parseDouble(amount));
            System.out.println(amount+" rupees is withdrawal");
            }else {
                System.out.println("You have only " + account.getBalance() + " rupees ");
            }
        }else {
            System.out.println("Invalid amount");
        }
    }


    public  void deposit(String accountNo,String amount){
        Account account=getAccount(accountNo);
        if (account==null){
            System.out.println("Account not exists first create a new account");
            return;
        }
        if(isValidAmount(amount) ){
            account.setBalance(Double.parseDouble(amount)+account.getBalance());
            System.out.println(amount+" rupees is deposited");
        }else {
            System.out.println("Invalid amount");
        }
    }


    public Account createAccount(String accountNo,Double balance,String name,String password){
        return new Account(accountNo,balance,name,password);
    }

    public void changeName(String accountNo,String newName,String password){
        Account account=getAccount(accountNo);
        if (account==null){
            System.out.println("Account not exists first create a new account");
            return;
        }
        if(!account.getPassword().equals(password)){
            System.out.println("password is wrong");
            return;
        }
        account.setName(newName);
    }


    public void applyForPassbook(String accountNo,String password){
        Account account=getAccount(accountNo);
        if (account==null){
            System.out.println("Account not exists first create a new account");
            return;
        }
        if(!account.getPassword().equals(password)){
            return;
        }
        System.out.println("Thank you "+account.getName()+" for applying for the passbook. ");
    }


    public void getDetails(String accountNo){
        Account account=getAccount(accountNo);
        if (account==null){
            System.out.println("Account not exists first create a new account");
            return;
        }else {
            System.out.println("Your name : "+account.getName()+"\nYour account no : "+account.getAccountNo()+"\nYour current balance is "+account.getBalance());
        }
    }
    

    private boolean isValidAmount(String amount){
        for(int i=0;i<amount.length();i++){
            if(!Character.isDigit(amount.charAt(i))){
                return false;
            }
        }
        return true;
    }

    private Account getAccount(String accountNo){
        Account ac=null;
        for(Account account:accounts){
            if (account.getAccountNo().equals(accountNo)){
                ac=account;
            }
        }
        return ac;
    }

}
