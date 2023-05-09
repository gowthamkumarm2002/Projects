package swiggy;

import java.util.*;
import java.io.*;
import swiggy.*;

public class Login {

    Validation v = new Validation();
    Scanner in = new Scanner(System.in);

    File file1 = new File("Files/LoginDetails/Admindetails.txt");
    File file2 = new File("Files/HotelDetails/Logindetails.txt");
    File file3 = new File("Files/UserDetails/Information.txt");
    File file4 = new File("Files/DeliveryBoy/LoginDetails.txt");

    ArrayList<Details> dlist = new ArrayList<Details>();
    ArrayList<HotelDetails> dlist1 = new ArrayList<HotelDetails>();
    ArrayList<Details> dlist2 = new ArrayList<Details>();
    ArrayList<Details> dlist3 = new ArrayList<Details>();
    ArrayList<DeliveryBoyDetails> dlist4 = new ArrayList<DeliveryBoyDetails>();




    ObjectOutputStream oos=null;
    ObjectInputStream ois=null;
    ListIterator li = null;

    public void login() throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        while(true){
            System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" SWIGGY "+"\u001B[35m"+"=====================\n\n");
            System.out.println("\u001B[35m"+"\t\t\t\t  "+"\u001B[47m"+"  LOGIN  "+"\u001B[0m");
            System.out.println("\n\n\t\t\t\t"+"\u001B[37m"+"  1. Admin");
            System.out.println("\t\t\t\t  2. Hotel ");
            System.out.println("\t\t\t\t  3. User ");
            System.out.println("\t\t\t\t  4. Delivery Boy ");
            System.out.println("\t\t\t\t  5. Back ");
            System.out.println("\n\n\t\t"+"\u001B[35m"+"===================================================\n\n");
            System.out.print("\n\t\t\t  Enter your Choice : ");
            int num = in.nextInt();
            System.out.print("\033\143");
            switch(num){
                case 1:
                    System.out.print("\033\143");
                    in.nextLine();
                    admin();
                    break;
                case 2:
                    System.out.print("\033\143");
                    in.nextLine();
                    hotel();
                    break;
                case 3:
                    System.out.print("\033\143");
                    in.nextLine();
                    user();
                    break;
                case 4:
                    System.out.print("\033\143");
                    in.nextLine();
                    deliveryBoy();
                    break;
                case 5:
                    System.out.print("\033\143");
                    new Home().home();
                    break;
                default:
                    System.out.print("\033\143");
                    System.out.println("\u001B[31m"+"\t\t\t\tInvalid Username or Password"+"\u001B[0m");
            }
        }
    }

    public void admin()throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        int c=0;

        String username = new String();
        String pass = new String();

        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" SWIGGY "+"\u001B[35m"+"=====================\n\n");
        System.out.println("\u001B[47m"+"\u001B[35m"+"\t\t\t\t DETAILS "+"\u001B[0m");
        System.out.print("\u001B[37m"+"\n\n\t\t\t UserName      : ");
        username = in.nextLine();
        pass = v.password();
        if(file1.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file1));
            dlist = (ArrayList<Details>)ois.readObject();
            ois.close();
        }
        li = dlist.listIterator();
        while(li.hasNext()){
            Details d = (Details)li.next();
            if(username.equals(d.name) && pass.equals(d.pass)){
                System.out.println("\n\n\t\t"+"\u001B[35m"+"===================================================\n\n");
                System.out.println("\n\n\t\t\t Login Successfull");
                Thread.sleep(1000);
                c=1;
                System.out.print("\033\143");
                new AdminHome().adminHome();
            }
        }
        if(c==0){
            System.out.print("\033\143");
            System.out.println("\u001B[31m"+"\t\t\t\tInvalid Input"+"\u001B[0m");
            admin();
        }
    }
    
    public void hotel()throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        int c=0;

        String username = new String();
        String pass = new String();

        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" SWIGGY "+"\u001B[35m"+"=====================\n\n");
        System.out.println("\u001B[47m"+"\u001B[35m"+"\t\t\t\t DETAILS "+"\u001B[0m");
        System.out.print("\u001B[37m"+"\n\n\t\t\t UserName      : ");
        username = in.nextLine();
        pass = v.password();
        if(file2.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file2));
            dlist1 = (ArrayList<HotelDetails>)ois.readObject();
            ois.close();
        }
        li = dlist1.listIterator();
        while(li.hasNext()){
            HotelDetails d = (HotelDetails)li.next();
            if(username.equals(d.user_name) && pass.equals(d.pass)){
                System.out.println("\n\n\t\t"+"\u001B[35m"+"===================================================\n\n");
                System.out.println("\n\n\t\t\t Login Successfull");
                Thread.sleep(2000);
                c=1;
                System.out.print("\033\143");
                String h_name = d.h_name;
                new HotelHome().hotelHome(h_name);
            }
        }
        if(c==0){
            System.out.print("\033\143");
            System.out.println("\u001B[31m"+"\t\t\t\tInvalid Username or Password"+"\u001B[0m");
            hotel();
        }
    }

    public void user()throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        int c=0;

        String username = new String();
        String pass = new String();

        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" SWIGGY "+"\u001B[35m"+"=====================\n\n");
        System.out.println("\u001B[47m"+"\u001B[35m"+"\t\t\t\t DETAILS "+"\u001B[0m");
        System.out.print("\u001B[37m"+"\n\n\t\t\t UserName      : ");
        username = in.nextLine();
        pass = v.password();
        if(file3.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file3));
            dlist2 = (ArrayList<Details>)ois.readObject();
            ois.close();
        }
        li = dlist2.listIterator();
        while(li.hasNext()){
            Details d = (Details)li.next();
            if(username.equals(d.name) && pass.equals(d.pass)){
                System.out.println("\n\n\t\t"+"\u001B[35m"+"===================================================\n\n");
                System.out.println("\n\n\t\t\t Login Successfull");
                Thread.sleep(2000);
                c=1;
                System.out.print("\033\143");
                new UserHome().userHome(d.name);
            }
        }
        if(c==0){
            System.out.print("\033\143");
            System.out.println("\u001B[31m"+"\t\t\t\tInvalid Username or Password"+"\u001B[0m");
            user();
        }
    }

    public void deliveryBoy()throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        int c=0;

        String username = new String();
        String pass = new String();

        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" SWIGGY "+"\u001B[35m"+"=====================\n\n");
        System.out.println("\u001B[47m"+"\u001B[35m"+"\t\t\t\t DETAILS "+"\u001B[0m");
        System.out.print("\u001B[37m"+"\n\n\t\t\t UserName      : ");
        username = in.nextLine();
        pass = v.password();
        if(file4.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file4));
            dlist4 = (ArrayList<DeliveryBoyDetails>)ois.readObject();
            ois.close();
        }
        li = dlist4.listIterator();
        while(li.hasNext()){
            DeliveryBoyDetails d = (DeliveryBoyDetails)li.next();
            if(username.equals(d.user_name) && pass.equals(d.pass)){
                System.out.println("\n\n\t\t"+"\u001B[35m"+"===================================================\n\n");
                System.out.println("\n\n\t\t\t Login Successfull");
                Thread.sleep(2000);
                c=1;
                System.out.print("\033\143");
                new BoyHome().boyHome(d.user_name);
            }
        }
        if(c==0){
            System.out.print("\033\143");
            System.out.println("\u001B[31m"+"\t\t\t\tInvalid Username or Password"+"\u001B[0m");
            hotel();
        }
    }
    
}

