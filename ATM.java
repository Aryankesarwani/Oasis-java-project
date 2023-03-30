import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.SQLOutput;
import java.util.*;
class BankAccount{
    static void Register(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Name: ");
        ATM.name = sc.nextLine();
        System.out.println("Enter UserName: ");
        String user = sc.nextLine();
        System.out.println("Enter Password: ");
        String pass = sc.nextLine();
        System.out.println("Enter Your Account No. : ");
        ATM.accno = sc.nextLong();
        System.out.println("Registration Successfull.......    ");
        System.out.println("............................................................................................");
        ATM.prompt();
        while(true){
            display(ATM.name);
            int c = sc.nextInt();
            if(c == 1){
                login(user,pass);
                break;
            }
            else {
                if(c == 2)
                    System.exit(0);
                else System.out.println("Please Choose Correct One:.....");
            }
        }
        
    }
    static void display(String name){}
    static void login(String user, String pass){}
}
class transaction {
    static void withdraw(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Amount to Withdraw: ");
        int wcash = sc.nextInt();
        if(wcash <= ATM.balance){
            ATM.balance = ATM.balance - wcash ;
            ATM.history.add(Integer.toString(wcash));
            ATM.history.add("Withdraw");
            System.out.println("Amount Rs: "+wcash+" /- Withdrawn Successfull..");
        }
        else{
            System.out.println("Insufficient Balance ----");
        }
        ATM.prompt();
    }
    static void deposite(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Amout to deposite: ");
        int dcash = sc.nextInt();
        ATM.updatebalance(dcash);
        ATM.history.add(Integer.toString(dcash));
        ATM.history.add("Deposite");
        System.out.println("Amount Rs: "+dcash+" /- Deposited Successfull..");
        System.out.println("............................................................................................");
        ATM.prompt();
    }
    static void transfer(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter receiving Body: ");
        int num = sc.nextInt();
        System.out.println("Enter Amount to be Transfer: ");
        int tcash=sc.nextInt();
        if(tcash <= ATM.balance){
            ATM.balance = ATM.balance - tcash ;
            ATM.history.add(Integer.toString(tcash));
            ATM.history.add("Withdraw");
            System.out.println("Amount Rs: "+tcash+" /- Transferred Successfull..");
        }
        else
            System.out.println("Insufficient Balance ");
    }
}
class check{
    static void checkbalance(){
       System.out.println("Balance is in your Account:");
       ATM.showbalance();
       ATM.prompt();
    }
}
class his{
    static void t_history(){
        System.out.println("...................................");
        System.out.println("Transaction History :");
        int k=0;
        if(ATM.balance > 0){
            for(int i=0;i<ATM.history.size()/2 ; i++){
                for(int j=0;j<2;j++){
                    System.out.println(ATM.history.get(k)+" ");
                    k++;
                }
                System.out.println(".............................");
            }
        }
        else System.out.println("Account Empty ");
        ATM.prompt();
    }
}
public class ATM {
    public static String name;
    public static int balance=0;
    public static long accno;
    public static ArrayList<String> history = new ArrayList<String>();
    static void updatebalance(int dcash){
        balance = balance + dcash;
    }
    static void showbalance(){
        System.out.println(balance);
    }
    public static void homepage(){
        System.out.println("\033[H\033[23");
        Scanner sc = new Scanner(System.in);
        System.out.println("   WELCOME TO MY ATM...");
        System.out.println("........................................");
        System.out.println("Select one Option: ");
        System.out.println("1. Register");
        System.out.println("2. Exit");
        System.out.println("Enter Choice");
        int c = sc.nextInt();
        if(c == 1){
            BankAccount.Register();
        }
        else {
            if(c == 2)
                System.exit(0);
            else {
                System.out.println("Please Choose Correct One:.....");
                homepage();
            }
        }
    }
    static void prompt(){
        Scanner sc = new Scanner (System.in);
        System.out.println("WELCOME "+ ATM.name+"!TO ATM SYSTEM");
        System.out.println("...................................");
        System.out.println("Select One Option: ");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposite");
        System.out.println("3. Transfer");
        System.out.println("4. check balance");
        System.out.println("5. Transaction History");
        System.out.println("6. Exit");
        System.out.println("Enter Your Choise: ");
        int c=sc.nextInt();
        switch(c){
            case 1: transaction.withdraw();
            case 2: transaction.deposite();
            case 3: transaction.transfer();
            case 4: check.checkbalance();
            case 5: his.t_history();
            case 6: System.exit(0);
        }
    }
    public static void main(String[]   args){
        homepage();
    }
}