package swiggy;

import java.util.*;
import java.io.*;
import swiggy.*;

public class BoyHome {

    Scanner in = new Scanner(System.in);

    File file1 = new File("Files/DeliveryBoy/Orders.txt");
    File file2 = new File("Files/DeliveryBoy/LoginDetails.txt");

    ArrayList<DeliveryBoyOrders> dlist1 = new ArrayList<DeliveryBoyOrders>();
    ArrayList<DeliveryBoyDetails> dlist2 = new ArrayList<DeliveryBoyDetails>();

    Validation v = new Validation();

    ObjectOutputStream oos=null;
    ObjectInputStream ois=null;
    ListIterator li = null;
   
    public void boyHome(String username)throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        while(true){
            System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" SWIGGY "+"\u001B[35m"+"=====================\n\n");
            System.out.println("\t\t\t\t"+"\u001B[37m"+"  1. Delivering Orders");
            System.out.println("\t\t\t\t  2. Total Orders");
            System.out.println("\t\t\t\t  3. Update Details");
            System.out.println("\t\t\t\t  4. Logout");
            System.out.println("\n\n\t\t"+"\u001B[35m"+"===================================================\n\n");
            System.out.print("\n\t\t\t  Enter your Choice : ");
            int n1 = in.nextInt();
            switch(n1){
                case 1:
                    System.out.print("\033\143");
                    d_orders(username);
                    break;
                case 2:
                    System.out.print("\033\143");
                    t_orders(username);
                    break;
                case 3:
                    System.out.print("\033\143");
                    update_details(username);
                    break;   
                case 4:
                    System.out.print("\033\143");
                    new Home().home();
                    break;
                default:
                    System.out.print("\033\143");
                    System.out.println("\u001B[31m"+"\t\t\t\tInvalid Input"+"\u001B[0m");
            }
        }
    }

    public void d_orders(String username)throws IOException,ClassNotFoundException, FileNotFoundException,InterruptedException{
        int no=1,c=0;
        if(file1.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file1));
            dlist1 = (ArrayList<DeliveryBoyOrders>)ois.readObject();
            ois.close();
        }
        // System.out.println(dlist1);

        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" SWIGGY "+"\u001B[35m"+"=====================\n\n");
        System.out.println("\n\n\t\t\t+=================+=================+");
        System.out.printf("\t\t\t| %-15s | %-15s |\n"," TRACKING ID"," NAME OF USER");
        System.out.println("\t\t\t+=================+=================+");
        for(DeliveryBoyOrders h:dlist1){
            if(username.equalsIgnoreCase(h.id)){
                String status = new String();
                if(h.status.equals("0")){
                    status = "Delivering";
                    System.out.println("\t\t\t|\t\t\t\t    |");
                    System.out.println("\t\t\t|\tSTATUS : "+status+"\t    |");
                    System.out.println("\t\t\t|\t\t\t\t    |");
                    System.out.println("\t\t\t+=================+=================+");
                    c=1;   
                    System.out.printf("\t\t\t| %-15s | %-15s |\n",h.delivery_name,h.u_name);
                    System.out.println("\t\t\t+=================+=================+");
                }
            }
            
        }
        if(c==0){
            System.out.println("\t\t\t"+"\u001B[35m"+"| \t     No Deliveries \t    |");
            System.out.println("\t\t\t+=================+=================+");
        }
        System.out.println("\u001B[36m"+"\n\n\t\t <--Back(2)                           Continue-->");
        in.nextLine(); 
        in.nextLine(); 
        System.out.print("\033\143");
        boyHome(username);
    }

    public void t_orders(String username)throws IOException,ClassNotFoundException, FileNotFoundException,InterruptedException{
        int no=1,c=0;
        if(file1.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file1));
            dlist1 = (ArrayList<DeliveryBoyOrders>)ois.readObject();
            ois.close();
        }
        // System.out.println(dlist1);

        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" SWIGGY "+"\u001B[35m"+"=====================\n\n");
        System.out.println("\n\n\t\t\t+=================+=================+");
        System.out.printf("\t\t\t| %-15s | %-15s |\n"," TRACKING ID"," NAME OF USER");
        System.out.println("\t\t\t+=================+=================+");
        for(DeliveryBoyOrders h:dlist1){
            if(username.equalsIgnoreCase(h.id)){
                String status = new String();
                if(h.status.equals("0")){
                    status = "Delivering";
                }
                else{
                    status = " Deliveried";
                }
                System.out.println("\t\t\t|\t\t\t\t    |");
                System.out.println("\t\t\t|\tSTATUS : "+status+"\t    |");
                System.out.println("\t\t\t|\t\t\t\t    |");
                System.out.println("\t\t\t+=================+=================+");
                c=1;   
                System.out.printf("\t\t\t| %-15s | %-15s |\n",h.delivery_name,h.u_name);
                System.out.println("\t\t\t+=================+=================+");
                } 
        }
        if(c==0){
            System.out.println("\t\t\t"+"\u001B[35m"+"| \t     No Deliveries \t    |");
            System.out.println("\t\t\t+=================+=================+");
        }
        System.out.println("\u001B[36m"+"\n\n\t\t <--Back(2)                           Continue-->");
        in.nextLine(); 
        in.nextLine(); 
        System.out.print("\033\143");
        boyHome(username);
    }

    public void update_details(String username)throws IOException,ClassNotFoundException,FileNotFoundException,InterruptedException{
        int c=0;
        String s,location,district,pincode;
        in.nextLine();
        if(file2.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file2));
            dlist2 = (ArrayList<DeliveryBoyDetails>)ois.readObject();
            ois.close();
        }  
        // System.out.println(dlist1);
        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" SWIGGY "+"\u001B[35m"+"=====================\n\n");
        System.out.println("\u001B[35m"+"\n\t\t+================+=================+=================+=================+=================+");
        System.out.printf("\t\t|%-15s | %-15s | %-15s | %-15s | %-15s |\n","NAME","PHONE NUM","DISTRICT","LOCATION","PIN CODE");
        System.out.println("\t\t+================+=================+=================+=================+=================+");
        for(DeliveryBoyDetails h:dlist2){
            if(username.equalsIgnoreCase(h.user_name)){
                c=1;
                System.out.printf("\t\t|%-15s | %-15s | %-15s | %-15s | %-15s |\n",h.h_name,h.phone_num,h.district,h.location,h.pincode);
                System.out.println("\t\t+================+=================+=================+=================+=================+");
                System.out.print("\n\n\t\tIf you want update District (Y/N)    : ");
                s = in.nextLine();
                if(s.equals("Y") || s.equals("y")){
                    System.out.print("\u001B[37m"+"\n\n\t\t\t District  : ");
                    district = in.nextLine();
                    h.district = district.toUpperCase();
                }
                System.out.print("\u001B[35m"+"\n\n\t\tIf you want update Location (Y/N)    : ");
                s = in.nextLine();
                if(s.equals("Y") || s.equals("y")){
                    System.out.print("\u001B[37m"+"\n\n\t\t\t Location : ");
                    location = in.nextLine();
                    h.location = location.toUpperCase();
                }

                System.out.print("\u001B[35m"+"\n\n\t\tIf you want update Pincode  (Y/N)    : ");
                s = in.nextLine();
                if(s.equals("Y") || s.equals("y")){
                    do{
                        System.out.print("\u001B[37m"+"\n\n\t\t\t Pin Code      : ");
                        pincode = in.nextLine();
                        h.pincode = pincode;
                    }while(!v.validatePin(pincode));
                }
                System.out.println("\u001B[36m"+"\n\n\t\t\t Updated Successfully..");
                oos = new ObjectOutputStream(new FileOutputStream(file2));
                oos.writeObject(dlist2);
                oos.close();
            }
        }
        if(c==0){
            System.out.println("\t\t"+"\u001B[35m"+"                No records             \n\n");
            System.out.println("\t\t+================+=================+=================+=================+=================+");
        }
        System.out.println("\u001B[36m"+"\n\n\t\t <--Back(2)                                  Continue-->");
        int n = in.nextInt();
        System.out.print("\033\143");
        boyHome(username);
    }

}

