package swiggy;

import java.util.*;
import java.io.*;
import swiggy.*;


public class AdminHome{
    Scanner in = new Scanner(System.in); 
    public void adminHome()throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        System.out.print("\033\143");
        while(true){
            System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" SWIGGY "+"\u001B[35m"+"=====================\n\n");
            System.out.println("\t\t\t\t"+"\u001B[37m"+"  1. Hotel Verify ");
            System.out.println("\t\t\t\t  2. Delivery Boy");
            System.out.println("\t\t\t\t  3. Logout");
            System.out.println("\n\n\t\t"+"\u001B[35m"+"===================================================\n\n");
            System.out.print("\n\t\t\t  Enter your Choice : ");
            int n1 = in.nextInt();
            switch(n1){
                case 1:
                    System.out.print("\033\143");
                    new Hotel().hotel();
                    break;
                case 2:
                    System.out.print("\033\143");
                    new DeliveryBoy().deliveryHome();
                    break;
                case 3:
                    System.out.print("\033\143");
                    new Home().home();
                    break;
                default:
                    System.out.print("\033\143");
                    System.out.println("\u001B[31m"+"\t\t\t\tInvalid Input"+"\u001B[0m");
            }
        }
    }

}

class Hotel {

    Validation v = new Validation();

    File file1 = new File("Files/HotelDetails/Information.txt");
    File file2 = new File("Files/HotelDetails/Logindetails.txt");
    Scanner in = new Scanner(System.in);
    int n;
    String hotelname;

    ArrayList<HotelDetails> dlist1 = new ArrayList<HotelDetails>();
    ArrayList<HotelDetails> dlist2 = new ArrayList<HotelDetails>();
    

    ObjectOutputStream oos=null;
    ObjectInputStream ois=null;
    ListIterator li = null;

    public void hotel()throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        while(true){
            System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" SWIGGY "+"\u001B[35m"+"=====================\n\n");
            System.out.println("\t\t\t\t"+"\u001B[37m"+"  1. Hotel Confirm ");
            System.out.println("\t\t\t\t  2. Hotel Requests");
            System.out.println("\t\t\t\t  3. Hotel Details");
            System.out.println("\t\t\t\t  4. Back");
            System.out.println("\n\n\t\t"+"\u001B[35m"+"===================================================\n\n");
            System.out.print("\n\t\t\t  Enter your Choice : ");
            int n1 = in.nextInt();
            switch(n1){
                case 1:
                    System.out.print("\033\143");
                    hotelconfirm();
                    break;
                case 2:
                    System.out.print("\033\143");
                    hotelwaiting();
                    break;
                case 3:
                    System.out.print("\033\143");
                    hoteldetails();
                    break;
                case 4:
                    System.out.print("\033\143");
                    new AdminHome().adminHome();
                    break;
                default:
                    System.out.print("\033\143");
                    System.out.println("\u001B[31m"+"\t\t\t\tInvalid Input"+"\u001B[0m");
            }
        }
    }
    
    public void hotelconfirm()throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        int c=0;
        in.nextLine();
        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" SWIGGY "+"\u001B[35m"+"=====================\n\n");
        System.out.print("\n\t\t\t  Enter Hotel Name : ");
        hotelname = in.nextLine();
        if(file1.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file1));
            dlist1 = (ArrayList<HotelDetails>)ois.readObject();
            ois.close();
        }
        if(file2.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file2));
            dlist2 = (ArrayList<HotelDetails>)ois.readObject();
            ois.close();
        }
        System.out.println("\u001B[35m"+"\n\t\t+================+=================+=================+=================+=================+");
        System.out.printf("\t\t|%-15s | %-15s | %-15s | %-15s | %-15s |\n","HOTEL NAME","PHONE NUM","DISTRICT","LOCATION","PIN CODE");
        System.out.println("\t\t+================+=================+=================+=================+=================+");
        for(HotelDetails h:dlist1){
            if(hotelname.equalsIgnoreCase(h.h_name)){
                c=1;
                System.out.printf("\t\t|%-15s | %-15s | %-15s | %-15s | %-15s |\n",h.h_name,h.phone_num,h.district,h.location,h.pincode);
                System.out.println("\t\t+================+=================+=================+=================+=================+");
                System.out.println("\u001B[36m"+"\n\n\t\t <--Back(2)          Confirm(1)                 Cancel(2)-->");
                n = in.nextInt();
            }
        }
        if(c==0){
            System.out.println("\t\t"+"\u001B[35m"+"| \t\t          This Hotel is not Requesting           \t\t\t |");
            System.out.println("\t\t+================+=================+=================+=================+=================+");
            System.out.println("\u001B[36m"+"\n\n\t\t <--Back(2)                                  Continue(1)-->");
            int n= in.nextInt();
            if(n==1){
                System.out.print("\033\143");
                hotelconfirm();
            }
            else{
                System.out.print("\033\143");
                hotel();
            }
        }
        else{
            if(n==1){
                for(HotelDetails h:dlist1){
                    if(hotelname.equalsIgnoreCase(h.h_name)){
                        dlist2.add(new HotelDetails(h.h_name,h.user_name,h.pass,h.phone_num,h.district,h.pincode,h.location));
                        System.out.println("\n\n\t\t\t\t Approved Succesfully");
                    }
                }
                li = dlist1.listIterator();
                while(li.hasNext()){
                    HotelDetails p1 = (HotelDetails)li.next();
                    if(hotelname.equalsIgnoreCase(p1.h_name)){
                        li.remove();
                    }
                }
                oos = new ObjectOutputStream(new FileOutputStream(file2));
                oos.writeObject(dlist2);
                oos.close();
                oos = new ObjectOutputStream(new FileOutputStream(file1));
                oos.writeObject(dlist1);
                oos.close();
                System.out.println("\u001B[36m"+"\n\n\t\t <--Back(2)                                  Continue(1)-->");
                int n = in.nextInt();
                if(n==1){
                    System.out.print("\033\143");
                    hotelconfirm();
                }
                else{
                    System.out.print("\033\143");
                    hotel();
                }
            }
            else if(n==2){
                li = dlist1.listIterator();
                while(li.hasNext()){
                    HotelDetails p1 = (HotelDetails)li.next();
                    if(hotelname.equalsIgnoreCase(p1.h_name)){
                        li.remove();
                    }
                    oos = new ObjectOutputStream(new FileOutputStream(file1));
                    oos.writeObject(dlist1);
                    oos.close();
                }
                System.out.println("\n\n\t\t\t\t Cancelled Succesfully");
                System.out.println("\u001B[36m"+"\n\n\t\t <--Back(2)                                  Continue(1)-->");
                int n = in.nextInt();
                if(n==1){
                    System.out.print("\033\143");
                    hotelconfirm();
                }
                else{
                    System.out.print("\033\143");
                    hotel();
                }
            }
            else{
                System.out.print("\033\143");
                hotel();
            }
            
        }
    }

    public void hotelwaiting()throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        int c=0;
        if(file1.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file1));
            dlist1 = (ArrayList<HotelDetails>)ois.readObject();
            ois.close();
        }
        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" SWIGGY "+"\u001B[35m"+"=====================\n\n");
        System.out.println("\u001B[35m"+"\n\t\t+================+=================+=================+=================+=================+");
        System.out.printf("\t\t|%-15s | %-15s | %-15s | %-15s | %-15s |\n","HOTEL NAME","PHONE NUM","DISTRICT","LOCATION","PIN CODE");
        System.out.println("\t\t+================+=================+=================+=================+=================+");
        for(HotelDetails h:dlist1){
            c=1;
            System.out.printf("\t\t|%-15s | %-15s | %-15s | %-15s | %-15s |\n",h.h_name,h.phone_num,h.district,h.location,h.pincode);
            System.out.println("\t\t+================+=================+=================+=================+=================+");
        }
        if(c==0){
            System.out.println("\t\t"+"\u001B[35m"+"| \t\t          Hotel not Requesting           \t\t\t\t |");
            System.out.println("\t\t+================+=================+=================+=================+=================+");
        }
        System.out.println("\u001B[36m"+"\n\n\t\t <--Back(2)                                  Continue-->");
        in.nextLine();
        in.nextLine();
        System.out.print("\033\143");
        hotel();
    }

    public void hoteldetails()throws IOException, ClassNotFoundException, FileNotFoundException, InterruptedException{
        int c=0;
        if(file2.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file2));
            dlist2 = (ArrayList<HotelDetails>)ois.readObject();
            ois.close();
        }
        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" SWIGGY "+"\u001B[35m"+"=====================\n\n");
        System.out.println("\u001B[35m"+"\n\t\t+================+=================+=================+=================+=================+");
        System.out.printf("\t\t|%-15s | %-15s | %-15s | %-15s | %-15s |\n","HOTEL NAME","PHONE NUM","DISTRICT","LOCATION","PIN CODE");
        System.out.println("\t\t+================+=================+=================+=================+=================+");
        for(HotelDetails h:dlist2){
            c=1;
            System.out.printf("\t\t|%-15s | %-15s | %-15s | %-15s | %-15s |\n",h.h_name,h.phone_num,h.district,h.location,h.pincode);
            System.out.println("\t\t+================+=================+=================+=================+=================+");
        }
        if(c==0){
            System.out.println("\t\t"+"\u001B[35m"+"| \t\t                 No Hotels                    \t\t\t\t |");
            System.out.println("\t\t+================+=================+=================+=================+=================+");
        }
        System.out.println("\u001B[36m"+"\n\n\t\t <--Back(2)                                  Continue-->");
        in.nextLine();
        in.nextLine();
        System.out.print("\033\143");
        hotel();
    }

}

class DeliveryBoy{  
    private String hotel_name = new String();
    private String phone_num = new String();
    private String district = new String();
    private String pincode = new String();
    private String username1 = new String();
    private String password1 = new String();
    private String location = new String();
    private String status = new String();


    Validation v = new Validation();

    File file1 = new File("Files/DeliveryBoy/LoginDetails.txt");

    ArrayList<DeliveryBoyDetails> dlist1 = new ArrayList<DeliveryBoyDetails>();


    ObjectOutputStream oos=null;
    ObjectInputStream ois=null;
    ListIterator li = null;

    int n;
    Scanner in = new Scanner(System.in);

    public void deliveryHome()throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        while(true){
            System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" SWIGGY "+"\u001B[35m"+"=====================\n\n");
            System.out.println("\t\t\t\t"+"\u001B[37m"+"  1. Add Delivery Boy ");
            System.out.println("\t\t\t\t  2. View Delivery Boy");
            System.out.println("\t\t\t\t  3. Delete Delivery Boy");
            System.out.println("\t\t\t\t  4. Back");
            System.out.println("\n\n\t\t"+"\u001B[35m"+"===================================================\n\n");
            System.out.print("\n\t\t\t  Enter your Choice : ");
            int n1 = in.nextInt();
            switch(n1){
                case 1:
                    System.out.print("\033\143");
                    addBoy();
                    break;
                case 2:
                    System.out.print("\033\143");
                    viewBoy();
                    break;
                case 3:
                    System.out.print("\033\143");
                    deleteBoy();
                    break;
                case 4:
                    System.out.print("\033\143");
                    new AdminHome().adminHome();
                    break;
                default:
                    System.out.print("\033\143");
                    System.out.println("\u001B[31m"+"\t\t\t\tInvalid Input"+"\u001B[0m");
            }
        }
    }
    
    public void addBoy()throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" SWIGGY "+"\u001B[35m"+"=====================\n\n");
        System.out.println("\u001B[47m"+"\u001B[35m"+"\t\t\t\t DETAILS "+"\u001B[0m");
        in.nextLine();
        System.out.print("\u001B[37m"+"\n\n\t\t\t Name          : ");
        hotel_name = in.nextLine();
        do{
            System.out.print("\u001B[37m"+"\n\n\t\t\t Phone Number  : ");
            phone_num = in.nextLine();
        }while(!v.validatePhoneNum(phone_num));
            System.out.print("\u001B[37m"+"\n\n\t\t\t District      : ");
            district = in.nextLine();
        do{
            System.out.print("\u001B[37m"+"\n\n\t\t\t Pin Code      : ");
            pincode = in.nextLine();
        }while(!v.validatePin(pincode));
        System.out.print("\u001B[37m"+"\n\n\t\t\t Locatioin     : ");
        location = in.nextLine();
        addBoy2();
    }

    public void addBoy2()throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        int c=0;
        System.out.print("\u001B[37m"+"\n\n\t\t\t UserName      : ");
        username1 = in.nextLine();
        password1 = v.password();
        if(file1.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file1));
            dlist1 = (ArrayList<DeliveryBoyDetails>)ois.readObject();
            ois.close();
        }
        li = dlist1.listIterator();
        while(li.hasNext()){
            DeliveryBoyDetails d = (DeliveryBoyDetails)li.next();
            if(username1.equals(d.user_name)){
                c=1;
            }
        }
        if(c==0){
            if(!v.validateUser(username1) || !v.validatePassword(password1)){
                System.out.print("\033\143");
                System.out.println("\u001B[31m"+"\n\t\t\t Invaild Format of Username or Password");
                System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" SWIGGY "+"\u001B[35m"+"=====================\n\n");
                System.out.println("\u001B[47m"+"\u001B[35m"+"\t\t\t\t DETAILS "+"\u001B[0m");
                addBoy2();
            }
            else{
                System.out.println("\n\n\t\t"+"\u001B[35m"+"===================================================\n\n");
                // System.out.println("\n\n\t\t"+hotel_name+username1+password1+phone_num+district+pincode);
                dlist1.add(new DeliveryBoyDetails(hotel_name.toUpperCase(),username1, password1,phone_num,district.toUpperCase(),pincode,location.toUpperCase(),"0"));
                oos = new ObjectOutputStream(new FileOutputStream(file1));
                oos.writeObject(dlist1);
                oos.close();
                System.out.println("\n\n\t\t\t Delivery Details added Succesfully");
                // System.out.println(dlist1);
                System.out.println("\u001B[36m"+"\n\n\t\t <--Back(2)                           Continue(1)-->");
                int n = in.nextInt(); 
                if(n==1){
                    System.out.print("\033\143");
                    addBoy();
                }
                else{
                    System.out.print("\033\143");
                    deliveryHome();
                }
            }
        }
        else{
            System.out.print("\033\143");
            System.out.println("\u001B[31m"+"\n\t\t\t Username Already Exists....");
            addBoy2();
        }
    }
   
    public void viewBoy()throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        int c=0;
        in.nextLine();
        if(file1.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file1));
            dlist1 = (ArrayList<DeliveryBoyDetails>)ois.readObject();
            ois.close();
        }  
        // System.out.println(dlist1);
        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" SWIGGY "+"\u001B[35m"+"=====================\n\n");
        System.out.println("\u001B[35m"+"\n\t\t+================+=================+=================+=================+=================+=================+");
        System.out.printf("\t\t|%-15s | %-15s | %-15s | %-15s | %-15s | %-15s |\n","NAME","PHONE NUM","DISTRICT","LOCATION","PIN CODE","STATUS");
        System.out.println("\t\t+================+=================+=================+=================+=================+=================+");
        for(DeliveryBoyDetails h:dlist1){
            if(!h.status.equals("0")){
                status = "Delivering";
            }
            else{
                status = "Free";
            }
            c=1;
            System.out.printf("\t\t|%-15s | %-15s | %-15s | %-15s | %-15s | %-15s |\n",h.h_name,h.phone_num,h.district,h.location,h.pincode,status);
            System.out.println("\t\t+================+=================+=================+=================+=================+=================+");
        }
        if(c==0){
            System.out.println("\t\t"+"\u001B[35m"+"                No records             \n\n");
            System.out.println("\t\t+================+=================+=================+=================+=================+=================+");
        }
        System.out.println("\u001B[36m"+"\n\n\t\t <--Back(2)                                  Continue-->");
        in.nextLine();
        System.out.print("\033\143");
        deliveryHome();
    }
   
    public void deleteBoy()throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        int c=0;
        String username;
        in.nextLine();
        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" SWIGGY "+"\u001B[35m"+"=====================\n\n");
        System.out.print("\n\t\t\t  Enter Name : ");
        username = in.nextLine();
        if(file1.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file1));
            dlist1 = (ArrayList<DeliveryBoyDetails>)ois.readObject();
            ois.close();
        }
        System.out.println("\u001B[35m"+"\n\t\t+================+=================+=================+=================+=================+");
        System.out.printf("\t\t|%-15s | %-15s | %-15s | %-15s | %-15s |\n","NAME","PHONE NUM","DISTRICT","LOCATION","PIN CODE");
        System.out.println("\t\t+================+=================+=================+=================+=================+");
        for(DeliveryBoyDetails h:dlist1){
            if(username.equalsIgnoreCase(h.h_name)){
                c=1;
                System.out.printf("\t\t|%-15s | %-15s | %-15s | %-15s | %-15s |\n",h.h_name,h.phone_num,h.district,h.location,h.pincode);
                System.out.println("\t\t+================+=================+=================+=================+=================+");
            }
        }
        
        if(c==0){
            System.out.println("\t\t"+"\u001B[35m"+"|\t\t\t\tNo Records\t\t\t\t\t         |");
            System.out.println("\t\t+================+=================+=================+=================+=================+");
            System.out.println("\u001B[36m"+"\n\n\t\t <--Back(2)                                  Continue-->");
            n = in.nextInt();
            System.out.print("\033\143");
            in.nextLine();
            deliveryHome();
        }
        else{
            System.out.println("\u001B[36m"+"\n\n\t\t <--Back(2)                              Delete(1)-->");
            n = in.nextInt();
            if(n==1){
                li = dlist1.listIterator();
                while(li.hasNext()){
                    DeliveryBoyDetails pq = (DeliveryBoyDetails)li.next();
                    if(username.equalsIgnoreCase(pq.h_name)){
                        li.remove();
                    }
                }
                oos = new ObjectOutputStream(new FileOutputStream(file1));
                oos.writeObject(dlist1);
                oos.close();
                System.out.println("\n\n\t\t\t Delivery Boy Deleted Succesfully");
                System.out.println("\n\n\t\t"+"\u001B[35m"+"===================================================\n\n");
                System.out.println("\u001B[36m"+"\n\n\t\t <--Back(2)                                   Delete(1)->");
                n = in.nextInt();
                if(n==1){
                    System.out.print("\033\143");
                    in.nextLine();
                    deleteBoy(); 
                }
                else{
                    System.out.print("\033\143");
                    in.nextLine();
                    deliveryHome();
                }

            }else if(n==2){
                System.out.print("\033\143");
                in.nextLine();
                deliveryHome();
            }
        }
    }

}

