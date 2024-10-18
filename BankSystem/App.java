package BankSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Bank BOB=new Bank();
        Long accountNumber=1000000L;
//        Account user1=BOB.createAccount(String.valueOf(accountNumber++), 1000.50,"aman","user1");
//        Account user2=BOB.createAccount(String.valueOf(accountNumber++), 10000.00,"vibhor","user2");
//        Account user3=BOB.createAccount(String.valueOf(accountNumber++), 50000.00,"satyam","user3");

        Scanner scanner=new Scanner(System.in);
        System.out.printf("%10s","Welcome to Bank of Baroda");
;       int choice=0;


        String wantToContinue="yes";
        while(wantToContinue.equalsIgnoreCase("yes")){
            System.out.println("Choose the options what you want \n" +
                    "1. Create new Account\n" +
                    "2. Withdrawal amount\n" +
                    "3. Deposit Amount\n" +
                    "4. Apply for Passbook\n" +
                    "5. Change the name in account\n" +
                    "6. Check your details");
            choice=scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    System.out.println("Enter your name ");
                    String name=scanner.nextLine();
                    System.out.println("Enter password for your account");
                    String password=scanner.nextLine();
                    System.out.println("Enter amount you want to add");
                    Double balance=scanner.nextDouble();
                    String acn=String.valueOf(accountNumber++);
                    Account account=BOB.createAccount(acn,balance,name,password);
                    if (account==null){
                        System.out.println("Account not created ");
                        break;
                    }else {
                        System.out.println("Your account is created and account no is "+acn);
                    }
                    BOB.accounts.add(account);
                    break;
                case 2:
                    System.out.println("Enter your account No");
                    String accountNo=scanner.nextLine();
                    System.out.println("Enter your password");
                    String password1=scanner.nextLine();
                    System.out.println("Enter the amount to withdrawal");
                    String amount=scanner.next();
                    BOB.withdrawal(accountNo,amount,password1);

                    break;
                case 3:
                    System.out.println("Enter your account No");
                    String accountNo3=scanner.nextLine();
                    System.out.println("Enter the amount to deposit");
                    String amount3=scanner.nextLine();
                    BOB.deposit(accountNo3,amount3);

                    break;
                case 4:
                    System.out.println("Enter your account No");
                    String accountNo4=scanner.nextLine();
                    System.out.println("Enter your password");
                    String password4=scanner.nextLine();
                    BOB.applyForPassbook(accountNo4,password4);

                    break;
                case 5:
                    System.out.println("Enter your account No");
                    String accountNo5=scanner.nextLine();
                    System.out.println("Enter your password");
                    String password5=scanner.nextLine();
                    System.out.println("Enter the new name ");
                    String newName =scanner.nextLine();
                    BOB.changeName(accountNo5,newName,password5);

                    break;
                case 6:
                    System.out.println("Enter your account No");
                    String accountNo6=scanner.nextLine();
                    BOB.getDetails(accountNo6);
                    break;
                default:
                    System.out.println("Wrong Choice ");
            }
            scanner.nextLine();
            System.out.println("Do you Want to continue ? type yes to continue ");
            wantToContinue= scanner.nextLine();
        }
        scanner.close();
    }
}
