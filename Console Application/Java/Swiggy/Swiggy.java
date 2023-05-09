package swiggy;
import java.io.*;
import java.util.*;

import swiggy.*;

abstract class AllHomes{
    abstract void home()throws IOException, ClassNotFoundException,InterruptedException,FileNotFoundException;
}

class Validation{
    static{
        System.loadLibrary("register");
    }
    public native String password();

    public boolean validateUser(String text) {
        return text.matches("^\\w{8,14}$");
    }
    public boolean validatePassword(String text){
        return text.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
    }
    public boolean validatePhoneNum(String text){
        return text.matches("^[9876][0-9]{9}$");
    }
    public boolean validatePin(String text){
        return text.matches("^[6][0-9]{5}$");
    }

}

class Welcome{
    public void welcome()throws InterruptedException,IOException,ClassNotFoundException{
            System.out.println("\u001B[36m"+"\n\n\n\t\t\t+-----------------------------------------------------------+");
            System.out.println("\u001B[36m"+"\t\t\t|\t                                                    |");
            System.out.println("\u001B[36m"+"\t\t\t|\t=============================================       |");
            System.out.println("\u001B[36m"+"\t\t\t|\t================ "+"\u001B[32m"+" WELCOME TO "+"\u001B[36m"+" ===============       |");
            System.out.println("\u001B[36m"+"\t\t\t|\t================= "+"\u001B[32m"+"  SWIGGY "+"\u001B[36m"+" =================       |");
            System.out.println("\u001B[36m"+"\t\t\t|\t=============================================       |");
            System.out.println("\u001B[36m"+"\t\t\t|\t                                                    |");
            System.out.println("\u001B[36m"+"\t\t\t+-----------------------------------------------------------+"+"\u001B[0m");
            Thread.sleep(3000);
            System.out.print("\033\143");
            new Home().home();
    }
}

class Home extends AllHomes{
    Scanner in = new Scanner(System.in);

    public void home()throws IOException, ClassNotFoundException,InterruptedException,FileNotFoundException{
        while(true){
            System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" SWIGGY "+"\u001B[35m"+"=====================\n\n");
            System.out.println("\t\t\t\t"+"\u001B[37m"+"  1. Login ");
            System.out.println("\t\t\t\t  2. Register ");
            System.out.println("\t\t\t\t  3. Exit");
            System.out.println("\n\n\t\t"+"\u001B[35m"+"===================================================\n\n");
            System.out.print("\n\t\t\t  Enter your Choice : ");
            int num = in.nextInt();
            System.out.print("\033\143");
            switch(num){
                case 1:
                    Login l = new Login();
                    l.login();
                    break;
                case 2:
                    Register r = new Register();
                    r.register();
                    break;
                case 3:
                    System.out.print("\033\143");
                    System.exit(0);
                default:
                    System.out.print("\033\143");
                    System.out.println("\u001B[31m"+"\t\t\t\tInvalid Input"+"\u001B[0m");
            }
        }
    }

}

public class Swiggy {
    public static void main(String arg[]) throws InterruptedException,IOException,ClassNotFoundException{
        System.out.print("\033\143");
        new Welcome().welcome();
    }
}


/*  javac -d . Swiggy.java
javac -d . Login.java
javac -d . Register.java
javac -d . AdminHome.java
javac -d . HotelHome.java
javac -d . UserHome.java
javac -d . BoyHome.java
javac -d . JavaSendMail.java

java -Djava.library.path=. swiggy.Swiggy */ 