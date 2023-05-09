package swiggy;

import java.util.*;
import java.io.*;
import swiggy.*;

class UserOrderCart implements Serializable{
    String d_name,rate,discount,u_name,quantity,location;
    UserOrderCart(String d_name,String quantity,String rate,String discount,String u_name,String location){
        this.u_name = u_name;
        this.d_name = d_name;
        this.quantity = quantity;
        this.rate = rate;
        this.discount = discount;
        this.location = location;
    }
    public String toString(){
        return u_name+" "+d_name+" "+quantity+" "+rate+" "+discount+" "+location+" ";
    }
}


class UserBill implements Serializable{
    String d_name,rate,discount,u_name,quantity,ori_rate,tracking_id,status,location;
    UserBill(String d_name,String quantity,String rate,String discount,String u_name,String ori_rate,String id,String status,String location){
        this.u_name = u_name;
        this.d_name = d_name;
        this.quantity = quantity;
        this.rate = rate;
        this.discount = discount;
        this.ori_rate = ori_rate;
        this.tracking_id = id;
        this.status = status;
        this.location = location;
    }
    public String toString(){
        return u_name+" "+d_name+" "+quantity+" "+rate+" "+discount+" "+ori_rate+" "+" "+tracking_id+" "+status+" "+location+" ";
    }
}

class DeliveryBoyOrders implements Serializable{
    private static final long serialVersionUID = 1882195534059526899l;
    String id,u_name,delivery_name,status;
    DeliveryBoyOrders(String id,String u_name,String delivery_name,String status){
        this.id = id;
        this.u_name = u_name;
        this.delivery_name = delivery_name;
        this.status = status;
    }
    public String toString(){
        return delivery_name+" "+u_name+" "+id+" "+status+" ";
    }
}

class MyThreads extends Thread{
    ObjectOutputStream oos=null;
    ObjectInputStream ois=null;
    ListIterator li = null;
    Scanner in = new Scanner(System.in);
    File file4 = new File("Files/UserDetails/BilledDetails.txt");
    File file5 = new File("Files/DeliveryBoy/LoginDetails.txt");
    File file6 = new File("Files/DeliveryBoy/Orders.txt");

    String d_name = new String();
    LinkedList<UserBill> dlist4 = new LinkedList<UserBill>();
    ArrayList<DeliveryBoyDetails> dlist5 = new ArrayList<DeliveryBoyDetails>();
    ArrayList<DeliveryBoyOrders> dlist6 = new ArrayList<DeliveryBoyOrders>();

    MyThreads(String id){
        super(id);
        start();
    }
    public void run(){
        try{
            Thread.sleep(1000*60*3);
            if(file4.isFile()){
                ois = new ObjectInputStream(new FileInputStream(file4));
                dlist4 = (LinkedList<UserBill>)ois.readObject();
                ois.close();
            }
            if(file5.isFile()){
                ois = new ObjectInputStream(new FileInputStream(file5));
                dlist5 = (ArrayList<DeliveryBoyDetails>)ois.readObject();
                ois.close();
            }
            if(file6.isFile()){
                ois = new ObjectInputStream(new FileInputStream(file6));
                dlist6 = (ArrayList<DeliveryBoyOrders>)ois.readObject();
                ois.close();
            }
            for(UserBill h:dlist4){
                if(currentThread().getName().equals(h.tracking_id)){
                    h.status ="1";
                }
            }
            // System.out.println(currentThread().getName());
            for(DeliveryBoyOrders h:dlist6){
                if(currentThread().getName().equals(h.delivery_name)){
                    h.status ="1";
                    // System.out.println(h.delivery_name);
                    for(DeliveryBoyDetails h1:dlist5){
                        if(h.id.equals(h1.user_name)){
                            h1.status ="0";
                            // System.out.println(h.id+" "+h1.user_name);
                        }
                    }
                }
            }
            
            oos = new ObjectOutputStream(new FileOutputStream(file4));
            oos.writeObject(dlist4);
            oos.close();
            oos = new ObjectOutputStream(new FileOutputStream(file5));
            oos.writeObject(dlist5);
            oos.close();
            oos = new ObjectOutputStream(new FileOutputStream(file6));
            oos.writeObject(dlist6);
            oos.close();

            // System.out.println(dlist5+"\n");
            // System.out.println(dlist6+"\n");

        }
        catch (Exception e) { 
            e.printStackTrace();
        }
    }
}


public class UserHome {

    Scanner in = new Scanner(System.in);
    private String district = new String();
    private String dish_name = new String();
    private String h_name = new String();
    private String d_name = new String();
    private String rates = new String();
    private String discounts = new String();
    private String location = new String();
    private Float rate,discount,quentity;
    private String id = "0";
    int x;

    File file1 = new File("Files/HotelDetails/DishDetails.txt");
    File file2 = new File("Files/HotelDetails/Logindetails.txt");
    File file3 = new File("Files/UserDetails/Cartdetails.txt");
    File file4 = new File("Files/UserDetails/BilledDetails.txt");
    File file5 = new File("Files/DeliveryBoy/LoginDetails.txt");
    File file6 = new File("Files/DeliveryBoy/Orders.txt");


    LinkedList<DishDetails> dlist1 = new LinkedList<DishDetails>();
    ArrayList<HotelDetails> dlist2 = new ArrayList<HotelDetails>();
    LinkedList<UserOrderCart> dlist3 = new LinkedList<UserOrderCart>();
    LinkedList<UserBill> dlist4 = new LinkedList<UserBill>();
    LinkedList<UserBill> dlist5 = new LinkedList<UserBill>();
    ArrayList<DeliveryBoyOrders> dlist9 = new ArrayList<DeliveryBoyOrders>();




    ObjectOutputStream oos=null;
    ObjectInputStream ois=null;
    ListIterator li = null;

    
    public void userHome(String username)throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        while(true){
            System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" SWIGGY "+"\u001B[35m"+"=====================\n\n");
            System.out.println("\t\t\t\t"+"\u001B[37m"+"  1. Add to Cart");
            System.out.println("\t\t\t\t  2. View Cart & Order");
            System.out.println("\t\t\t\t  3. My Order");
            System.out.println("\t\t\t\t  4. Track the Order");
            System.out.println("\t\t\t\t  5. Logout");
            System.out.println("\n\n\t\t"+"\u001B[35m"+"===================================================\n\n");
            System.out.print("\n\t\t\t  Enter your Choice : ");
            int n1 = in.nextInt();
            switch(n1){
                case 1:
                    System.out.print("\033\143");
                    in.nextLine();
                    order(username);
                    break;
                case 2:
                    System.out.print("\033\143");
                    viewCartDetails(username);
                    break;
                case 3:
                    System.out.print("\033\143");
                    my_orders(username);
                    break;
                case 4:
                    System.out.print("\033\143");
                    track_the_order(username);
                    break;
                case 5:
                    System.out.print("\033\143");
                    new Home().home();
                    break;
                default:
                    System.out.print("\033\143");
                    System.out.println("\u001B[31m"+"\t\t\t\tInvalid Input"+"\u001B[0m");
            }
        }
    }

    public void order(String username)throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" SWIGGY "+"\u001B[35m"+"=====================\n\n");
        System.out.print("\u001B[37m"+"\n\n\t\t\t District      : ");
        district = in.nextLine();
        System.out.print("\033\143");
        hotelNumber(username,district.toUpperCase());
    }

    public void hotelNumber(String username,String district)throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        int c=0;
        if(file2.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file2));
            dlist2 = (ArrayList<HotelDetails>)ois.readObject();
            ois.close();
        }
        int no=1,n,h_no;
        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" SWIGGY "+"\u001B[35m"+"=====================\n\n");
        System.out.println("\u001B[35m"+"\n\t\t+==========+=================+=================+=================+=================+");
        System.out.printf("\t\t| %-8s | %-15s | %-15s | %-15s | %-15s |\n","NO","HOTEL NAME","PHONE NUM","DISTRICT","LOCATION");
        System.out.println("\t\t+==========+=================+=================+=================+=================+");
        for(HotelDetails h:dlist2){
            if(district.equalsIgnoreCase(h.district)){
                c=1;
                System.out.printf("\t\t| %-8d | %-15s | %-15s | %-15s | %-15s |\n",no++,h.h_name,h.phone_num,h.district,h.location);
                System.out.println("\t\t+==========+=================+=================+=================+=================+");
            }
        }
        if(c==0){
            System.out.println("\t\t"+"\u001B[35m"+"| \t\t          No Hotels                    \t\t\t\t   |");
            System.out.println("\t\t+==========+=================+=================+=================+=================+");
            System.out.println("\u001B[36m"+"\n\n\t\t\t <--Back(2)                           Continue-->");
            int z = in.nextInt();
            if(z==1){
                System.out.print("\033\143");
                order(username);
            }
            else{
                System.out.print("\033\143");
                userHome(username);
            }
        }
        else{
            System.out.println("\u001B[36m"+"\n\n\t\t\t <--Back(2)                           View Dish(1)-->");
            int z = in.nextInt();
            if(z==1){
                hotelNumber1(username, district,no);
            }
            else{
                System.out.print("\033\143");
                userHome(username);
            }
        }
    }

    public void hotelNumber1(String username,String district,int h_no)throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        System.out.print("\n\n\t\t\t Enter Hotel No    : ");
        int no = in.nextInt();
        if(h_no<=no){
            System.out.println("\u001B[31m"+"\t\t\t\tInvalid Hotel No"+"\u001B[35m");
            in.nextLine();
            hotelNumber1(username, district, h_no);
        }
        else{
            in.nextLine();
            dishName(no, username, district);
        }
    }

    public void dishName(int h_no,String username,String district)throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        int i=0,c1=0,no=1,d_no;
        for(HotelDetails h:dlist2){
            while(h_no-1==i){
                h_name = h.h_name;
                location = h.location;
                break;
            }
            i++;
        }
        if(file1.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file1));
            dlist1 = (LinkedList<DishDetails>)ois.readObject();
            ois.close();
        }
        System.out.print("\033\143");
        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" SWIGGY "+"\u001B[35m"+"=====================\n\n");
        System.out.println("\t\t+==========+=================+=================+=================+");
        System.out.printf("\t\t| %-8s | %-15s | %-15s | %-15s |\n","NO","DISH NAME","RATE(per Kgs)","DISCOUNT");
        System.out.println("\t\t+==========+=================+=================+=================+");
        for(DishDetails h:dlist1){
            if(h_name.equalsIgnoreCase(h.h_name)){
                c1=1;
                System.out.printf("\t\t| %-8d | %-15s | %-15s | %-15s |\n",no++,h.d_name,h.rate,h.discount);
                System.out.println("\t\t+==========+=================+=================+=================+");
            }
        }
        if(c1==0){
            System.out.println("\t\t"+"\u001B[35m"+"| \t\t           No Dish   \t\t\t\t |");
            System.out.println("\t\t+==========+=================+=================+=================+");
            System.out.println("\u001B[36m"+"\n\n\t\t <--Back(2)                           Contine-->");
            in.nextLine();
            System.out.print("\033\143");
            hotelNumber(username, district);
        }
        else{
            System.out.print("\u001B[36m"+"\n\n\t\t <--Back(2)                           Add to Cart(1) -->\n\n\t\t\t\t");
            int n = in.nextInt();
            if(n==1){
                dishName2(h_no, username, district,no,location);
            }
            else{
                System.out.print("\033\143");
                hotelNumber(username, district);
            }
        }
    }

    public void dishName2(int h_no,String username,String district,int no,String location)throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        System.out.print("\n\n\t\t\t Enter Dish No     : ");
        int d_no = in.nextInt();
        if(d_no>=no){
            System.out.println("\u001B[31m"+"\t\t\t\tInvalid Dish No"+"\u001B[35m");
            dishName2(h_no, username, district, d_no,location);
        }
        else{
            order1(d_no, username,district,no,location);
        }
    }

    public void order1(int d_no,String username,String district,int no,String location)throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        int i=0,c1=0;
        for(DishDetails h:dlist1){
            while(d_no-1==i){
                d_name = h.d_name;
                rates = h.rate;
                discounts = h.discount; 
                break;
            }
            i++;
        }
        if(file3.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file3));
            dlist3 = (LinkedList<UserOrderCart>)ois.readObject();
            ois.close();
        }
        System.out.print("\n\n\t\t\t Quentity (in Kgs) : ");
        quentity = in.nextFloat();
        dlist3.add(new UserOrderCart(d_name, String.valueOf(quentity), rates, discounts,username,location));
        in.nextLine();
        // System.out.println(dlist3);
        System.out.print("\n\n\t\t\t\t If want to continue (Y/N): ");
        String s = in.nextLine();
        if(s.equals("Y") || s.equals("y")){
            oos = new ObjectOutputStream(new FileOutputStream(file3));
            oos.writeObject(dlist3);
            oos.close();
            dishName2(d_no, username, district,no,location);
        }
        else{
            oos = new ObjectOutputStream(new FileOutputStream(file3));
            oos.writeObject(dlist3);
            oos.close();
            System.out.println("\u001B[36m"+"\n\n\t\t\t <--Back(2)                           Add Dish(1)-->");
            int n = in.nextInt();
            if(n==1){
                dishName2(d_no, username, district, no, location);
            }
            else{
                System.out.print("\033\143");
                userHome(username);
            }
        }
       
    }



    public void viewCartDetails(String username)throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        int i=0,c1=0,no=1,d_no;
        if(file3.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file3));
            dlist3 = (LinkedList<UserOrderCart>)ois.readObject();
            ois.close();
        }
        if(file4.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file4));
            dlist4 = (LinkedList<UserBill>)ois.readObject();
            ois.close();
        }
        System.out.print("\033\143");
        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" SWIGGY "+"\u001B[35m"+"=====================\n\n");
        System.out.println("\t\t+==========+=================+=================+=================+=================+");
        System.out.printf("\t\t| %-8s | %-15s | %-15s | %-15s | %-15s |\n","NO","DISH NAME","MRP","DISCOUNT","QUANTITY");
        System.out.println("\t\t+==========+=================+=================+=================+=================+");
        for(UserOrderCart h:dlist3){
            if(username.equalsIgnoreCase(h.u_name)){
                c1=1;
                System.out.printf("\t\t| %-8d | %-15s | %-15s | %-15s | %-15s |\n",no++,h.d_name,h.rate,h.discount,h.quantity);
                System.out.println("\t\t+==========+=================+=================+=================+=================+");
            }
        }
        if(c1==0){
            System.out.println("\t\t"+"\u001B[35m"+"| \t\t\t\t     No Dish   \t\t\t\t\t   |");
            System.out.println("\t\t+==========+=================+=================+=================+=================+");
            System.out.println("\u001B[36m"+"\n\n\t\t\t <--Back(2)                           Continue-->");
            int x= in.nextInt();
            System.out.print("\033\143");
            userHome(username);
        }
        else{
            System.out.println("\u001B[36m"+"\n\n\t\t\t <--Back(2)                             Order(1)-->");
            no= in.nextInt();
            if(no==1){
                System.out.print("\033\143");
                viewCartDetails1(username);
            }
            else{
                System.out.print("\033\143");
                userHome(username);
            }
        }
    }

    public void viewCartDetails1(String username)throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        int i=0,c1=0,no=1,d_no;
        LinkedList<UserBill> dlist6 = new LinkedList<UserBill>();

        if(file3.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file3));
            dlist3 = (LinkedList<UserOrderCart>)ois.readObject();
            ois.close();
        }
        if(file4.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file4));
            dlist6 = (LinkedList<UserBill>)ois.readObject();
            ois.close();
        }
        System.out.print("\033\143");
        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" SWIGGY "+"\u001B[35m"+"=====================\n\n");
        int min=100000,max=1000000;
        int b = (int)(Math.random()*(max-min+1)+min);
        System.out.println("\n\t\t\t Tracking Id : "+b);
        System.out.println("\n\n\t\t+==========+=================+=================+=================+=================+=================+");
        System.out.printf("\t\t| %-8s | %-15s | %-15s | %-15s | %-15s | %-15s |\n","NO","DISH NAME","MRP","DISCOUNT","QUANTITY","RATE");
        System.out.println("\t\t+==========+=================+=================+=================+=================+=================+");
        float final_rate=0F;
        for(UserOrderCart h:dlist3){
            if(username.equalsIgnoreCase(h.u_name)){
                c1=1;
                float dis_rate,rate,discount,quantity;
                rate = Float.valueOf(h.rate);
                discount = Float.valueOf(h.discount);
                quantity = Float.valueOf(h.quantity);
                dis_rate = (rate-((rate*discount)/100))*quantity;
                final_rate += dis_rate;
                System.out.printf("\t\t| %-8d | %-15s | %-15s | %-15s | %-15s |   %-13.2f |\n",no++,h.d_name,h.rate,h.discount,h.quantity,dis_rate);
                System.out.println("\t\t+==========+=================+=================+=================+=================+=================+");
            }
        }
        if(c1==0){
            System.out.println("\t\t"+"\u001B[35m"+"| \t\t\t\t     No Dish   \t\t\t\t\t   |");
            System.out.println("\t\t+==========+=================+=================+=================+=================+=================+");
            System.out.println("\u001B[36m"+"\n\n\t\t <--Back(2)                           Continue-->");
            in.nextLine();
            System.out.print("\033\143");
            hotelNumber(username, district);
        }
        else{
            System.out.printf("\t\t"+"\u001B[35m"+"  \t\t\t\t\t\t\t\t |    TOTAL\t   :   %.2f \t     |\n",final_rate);
            System.out.println("\t\t\t\t\t\t\t\t\t\t +=================+=================+");
            System.out.print("\u001B[36m"+"\n\n\t\t <--Back(2)                           Confirm(1) -->\n\n\t\t\t\t");
            x = in.nextInt();
            if(x==1){
                for(UserOrderCart h:dlist3){
                    if(username.equalsIgnoreCase(h.u_name)){
                        c1+=1;
                        float dis_rate,rate,discount,quantity;
                        rate = Float.valueOf(h.rate);
                        discount = Float.valueOf(h.discount);
                        quantity = Float.valueOf(h.quantity);
                        dis_rate = (rate-((rate*discount)/100))*quantity;
                        final_rate += dis_rate;
                        dlist6.add(new UserBill( h.d_name, h.quantity, h.rate, h.discount, username,String.valueOf(dis_rate),String.valueOf(b),"0",h.location));
                    }
                }
                oos = new ObjectOutputStream(new FileOutputStream(file4));
                oos.writeObject(dlist6);
                // System.out.println(dlist6);
                int xy = assignDeliveryBoy(username,String.valueOf(b));
                // System.out.print(xy);
                if(xy==1){
                    // System.out.println("Hello");
                    li = dlist3.listIterator();
                    while(li.hasNext()){
                        UserOrderCart h = (UserOrderCart)li.next();
                        if(username.equalsIgnoreCase(h.u_name)){
                            li.remove();
                        }
                    }
                    in.nextLine();
                    System.out.print("\n\n\t\t\t Enter Email Id : ");
                    String email = in.nextLine();
                    oos = new ObjectOutputStream(new FileOutputStream(file3));
                    oos.writeObject(dlist3);
                    oos.close();
                    oos = new ObjectOutputStream(new FileOutputStream(file4));
                    oos.writeObject(dlist6);
                    oos.close();
                    new JavaSendMail().sendMail(email,username,String.valueOf(b));
                    System.out.println("\n\n\t\t\tOrder Details are sent to your mail id successfully...");
                    System.out.print("\u001B[36m"+"\n\n\t\t <--Back(2)                           Continue-->\n\n\t\t\t\t");
                    in.nextLine();
                    deliveringOrder(String.valueOf(b),username);
                }
                else{
                    if(file4.isFile()){
                        ois = new ObjectInputStream(new FileInputStream(file4));
                        dlist6 = (LinkedList<UserBill>)ois.readObject();
                        ois.close();
                    }
                    li = dlist6.listIterator();
                    while(li.hasNext()){
                        UserBill h = (UserBill)li.next();
                        if(String.valueOf(b).equals(h.tracking_id)){
                            li.remove();
                        }
                    }
                    oos = new ObjectOutputStream(new FileOutputStream(file4));
                    oos.writeObject(dlist6);
                    oos.close();
                    // System.out.println("UserBill"+dlist6);
                    // System.out.println("Cart"+dlist3);
                    System.out.println("\n\t\t\t No Delivery Boys At This Moment. After Try again");
                    System.out.print("\u001B[36m"+"\n\n\t\t <--Back(2)                           Continue-->\n\n\t\t\t\t");
                    in.nextLine();
                    in.nextLine();
                    System.out.print("\033\143");
                    userHome(username);
                }
            }
            else{
                System.out.print("\033\143");
                userHome(username);
            }
        }
    }

    public void deliveringOrder(String id,String username)throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        Thread th = new Thread(new MyThreads(id));
        System.out.print("\033\143");
        userHome(username);
    }

    public int assignDeliveryBoy(String username,String id)throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        LinkedList<UserBill> dlist6 = new LinkedList<UserBill>();
        ArrayList<DeliveryBoyDetails> dlist7 = new ArrayList<DeliveryBoyDetails>();

        String location = new String();
        if(file4.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file4));
            dlist6 = (LinkedList<UserBill>)ois.readObject();
            ois.close();
        }
        if(file5.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file5));
            dlist7 = (ArrayList<DeliveryBoyDetails>)ois.readObject();
            ois.close();
        }
        // System.out.println(dlist6);
        for(UserBill h:dlist6){
            if(username.equalsIgnoreCase(h.u_name)){
                location = h.location;
                // System.out.println("h.location  :    "+h.location);
                break;
            }
        }
        // System.out.println("location  :    "+location);
        // System.out.println(dlist7);
        int xyz = randomBoy(location, username, id);
        // System.out.println("ydgsa"+xyz);
        return xyz;
    }

    public int randomBoy(String location,String username,String id)throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        int c=0,i=1,ran=0,l=0;
        ArrayList<DeliveryBoyDetails> dlist7 = new ArrayList<DeliveryBoyDetails>();
        ArrayList<DeliveryBoyOrders> dlist8 = new ArrayList<DeliveryBoyOrders>();
        if(file5.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file5));
            dlist7 = (ArrayList<DeliveryBoyDetails>)ois.readObject();
            ois.close();
        }
        if(file6.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file6));
            dlist8 = (ArrayList<DeliveryBoyOrders>)ois.readObject();
            ois.close();
        }
        // System.out.println("Random No : "+b);
        // System.out.println("details"+dlist7);
        // System.out.println("Orders"+dlist8);
        for(DeliveryBoyDetails d:dlist7){
            // System.out.println("hi"+dlist7);
            if(c==0){
                // System.out.println(location +"   "+d.location);
                if(location.equalsIgnoreCase(d.location)){
                    l+=1;
                    // System.out.println("hel");

                    if(d.status.equals("0")){
                        d.status = "1";
                        c=1;
                        oos = new ObjectOutputStream(new FileOutputStream(file5));
                        oos.writeObject(dlist7);
                        oos.close();
                        // return delivery_name+" "+u_name+" "+id+" ";
                        ran = 1;
                        dlist8.add(new DeliveryBoyOrders(d.user_name, username, id,"0"));
                        // System.out.println("hjkiansa"+dlist7);
                        oos = new ObjectOutputStream(new FileOutputStream(file6));
                        oos.writeObject(dlist8);
                        oos.close();
                    }
                }
            }
        }
        // System.out.println("hi  "+c);
        return c;
    }    



    public void my_orders(String username)throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        int no=1,c=0;
        if(file4.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file4));
            dlist5 = (LinkedList<UserBill>)ois.readObject();
            ois.close();
        }
        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" SWIGGY "+"\u001B[35m"+"=====================\n\n");
        System.out.println("\n\n\t\t+==========+=================+=================+=================+=================+=================+");
        System.out.printf("\t\t| %-8s | %-15s | %-15s | %-15s | %-15s | %-15s |\n","NO","DISH NAME","MRP","DISCOUNT","QUANTITY","RATE");
        System.out.println("\t\t+==========+=================+=================+=================+=================+=================+");
        for(UserBill h:dlist5){
            if(username.equalsIgnoreCase(h.u_name)){
                if(!id.equals(h.tracking_id)){
                    id = h.tracking_id;
                    no =1;
                    String status = new String();
                    if(h.status.equals("0")){
                        status = "Delivering";
                    }
                    else{
                        status = " Delivered";
                    }
                    System.out.println("\t\t|\t\t\t\t\t\t\t\t\t\t\t\t     |");
                    System.out.println("\t\t|\t\t\t       TRACKIND ID : "+h.tracking_id+"\t\t\t STATUS : "+status+"         |");
                    System.out.println("\t\t|\t\t\t\t\t\t\t\t\t\t\t\t     |");
                    System.out.println("\t\t+==========+=================+=================+=================+=================+=================+");
                }
                c=1;   
                System.out.printf("\t\t| %-8d | %-15s | %-15s | %-15s | %-15s | %-15s |\n",no++,h.d_name,h.rate,h.discount,h.quantity,h.ori_rate);
                System.out.println("\t\t+==========+=================+=================+=================+=================+=================+");
            }
        }
        if(c==0){
            System.out.println("\t\t"+"\u001B[35m"+"| \t\t\t\t     No Orders \t\t\t\t\t\t\t     |");
            System.out.println("\t\t+==========+=================+=================+=================+=================+=================+");
        }
        System.out.println("\u001B[36m"+"\n\n\t\t <--Back(2)                           Contine-->");
        in.nextLine(); 
        in.nextLine();
        System.out.print("\033\143");
        id = "0";
        userHome(username);
    }



    public void track_the_order(String username)throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        int no=1,c=0,t=0;
        if(file4.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file4));
            dlist4 = (LinkedList<UserBill>)ois.readObject();
            ois.close();
        }
        in.nextLine();
        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" SWIGGY "+"\u001B[35m"+"=====================\n\n");
        System.out.print("\u001B[37m"+"\n\n\t\t\t Tracking ID       : ");
        id = in.nextLine();
        System.out.println("\u001B[35m"+"\n\n\t\t+==========+=================+=================+=================+=================+=================+");
        System.out.printf("\t\t| %-8s | %-15s | %-15s | %-15s | %-15s | %-15s |\n","NO","DISH NAME","MRP","DISCOUNT","QUANTITY","RATE");
        System.out.println("\t\t+==========+=================+=================+=================+=================+=================+");
        for(UserBill h:dlist4){
            if(username.equalsIgnoreCase(h.u_name)){
                if(id.equals(h.tracking_id)){
                    String status = new String();
                    if(h.status.equals("0")){
                        status = "Delivering";
                    }
                    else{
                        status = " Delivered";
                    }
                    if(t==0){
                        t=1;
                        System.out.println("\t\t|\t\t\t\t\t\t\t\t\t\t\t\t     |");
                        System.out.println("\t\t|\t\t\t       TRACKIND ID : "+h.tracking_id+"\t\t\t STATUS : "+status+"         |");
                        System.out.println("\t\t|\t\t\t\t\t\t\t\t\t\t\t\t     |");
                        System.out.println("\t\t+==========+=================+=================+=================+=================+=================+");
                    }
                    c=1;
                    System.out.printf("\t\t| %-8d | %-15s | %-15s | %-15s | %-15s | %-15s |\n",no++,h.d_name,h.rate,h.discount,h.quantity,h.ori_rate);
                    System.out.println("\t\t+==========+=================+=================+=================+=================+=================+");
                }
            }
        }
        if(c==0){
            System.out.println("\t\t"+"\u001B[35m"+"| \t\t\t\t     No Dish   \t\t\t\t\t\t\t     |");
            System.out.println("\t\t+==========+=================+=================+=================+=================+=================+");   
        }
        System.out.println("\u001B[36m"+"\n\n\t\t <--Back(2)                           Contine-->");
        in.nextLine();
        System.out.print("\033\143");
        userHome(username);
        
    }

}

