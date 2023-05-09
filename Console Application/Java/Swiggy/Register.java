package swiggy;

import java.util.*;
import java.io.*;
import swiggy.*;


class Details implements Serializable{
    String name,pass;
    Details(String name,String pass){
        this.name = name;
        this.pass = pass;
    }
    public String toString(){
        return name+" "+pass+" ";
    }
}

class HotelDetails implements Serializable{
    String h_name,user_name,pass,phone_num,district,pincode,location;
    HotelDetails(String h_name,String user,String pass,String phone,String dis,String pin,String location){
        this.h_name = h_name;
        this.user_name = user;
        this.pass = pass;
        this.phone_num = phone;
        this.district = dis;
        this.pincode = pin;
        this.location = location;
    }
    public String toString(){
        return h_name+" "+user_name+" "+pass+" "+phone_num+" "+district+" "+pincode+" "+location;
    }
}

class DeliveryBoyDetails implements Serializable{
    private static final long serialVersionUID = 274624230428851979l;
    String h_name,user_name,pass,phone_num,district,pincode,location,status;
    DeliveryBoyDetails(String h_name,String user,String pass,String phone,String dis,String pin,String location,String status){
        this.h_name = h_name;
        this.user_name = user;
        this.pass = pass;
        this.phone_num = phone;
        this.district = dis;
        this.pincode = pin;
        this.location = location;
        this.status = status;
    }
    public String toString(){
        return h_name+" "+user_name+" "+pass+" "+phone_num+" "+district+" "+pincode+" "+location+" "+status;
    }
}

public class Register {

    Scanner in = new Scanner(System.in);

    Validation v = new Validation();


    File file1 = new File("Files/LoginDetails/Admindetails.txt");
    File file2 = new File("Files/HotelDetails/Information.txt");
    File file3 = new File("Files/UserDetails/Information.txt");

    ArrayList<Details> dlist = new ArrayList<Details>();
    ArrayList<HotelDetails> dlist1 = new ArrayList<HotelDetails>();
    ArrayList<Details> dlist2 = new ArrayList<Details>();



    ObjectOutputStream oos=null;
    ObjectInputStream ois=null;
    ListIterator li = null;

    private String hotel_name = new String();
    private String phone_num = new String();
    private String district = new String();
    private String pincode = new String();
    private String username1 = new String();
    private String password1 = new String();
    private String location = new String();


    public void register() throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        while(true){
            System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" SWIGGY "+"\u001B[35m"+"=====================\n\n");
            System.out.println("\u001B[47m"+"\u001B[35m"+"\t\t\t\t REGISTRATION "+"\u001B[0m");
            System.out.println("\n\n\t\t\t\t"+"\u001B[37m"+"  1. Admin");
            System.out.println("\t\t\t\t  2. Hotel ");
            System.out.println("\t\t\t\t  3. User ");
            System.out.println("\t\t\t\t  4. Back ");
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
                    new Home().home();
                    break;
                default:
                    System.out.print("\033\143");
                    System.out.println("\u001B[31m"+"\t\t\t\tInvalid Input"+"\u001B[0m");
            }
        }
    }
    
    public void admin()throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        int c=0;
        String username = new String();
        String pass = new String();

        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" SWIGGY "+"\u001B[35m"+"=====================\n\n");
        System.out.println("\u001B[47m"+"\u001B[35m"+"\t\t\t\t DETAILS "+"\u001B[0m");
        System.out.println("\u001B[31m"+"\n\n\t\t  Note : Username should be atleast 8 to 16 char (EX: Ganesh123)\n\t\t\t Password Should be exactly 8 to 16char (Ex: Ganesh@1234)");
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
            if(username.equals(d.name)){
                c=1;
            }
        }
        if(c==0){
            if(!v.validateUser(username) || !v.validatePassword(pass)){
                System.out.print("\033\143");
                System.out.println("\u001B[31m"+"\n\t\t\t Invaild Format of Username or Password");
                admin();
            }
            else{
                System.out.println("\n\n\t\t"+"\u001B[35m"+"===================================================\n\n");
                dlist.add(new Details(username, pass));
                oos = new ObjectOutputStream(new FileOutputStream(file1));
                oos.writeObject(dlist);
                oos.close();
                System.out.println("\n\n\t\t\t\t Register Succesfully");
                System.out.println("\u001B[36m"+"\n\n\t\t <--Back(2)                           Login(1)-->");
                int n = in.nextInt();
                if(n==1){
                    System.out.print("\033\143");
                    new Login().login();
                }
                else{
                    System.out.print("\033\143");
                    register();
                }
            }
        }
        else{
            System.out.print("\033\143");
            System.out.println("\u001B[31m"+"\n\t\t\t Username Already Exists....");
            admin();
        }
    }

    public void hotel()throws IOException,ClassNotFoundException,FileNotFoundException,InterruptedException{    
        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" SWIGGY "+"\u001B[35m"+"=====================\n\n");
        System.out.println("\u001B[47m"+"\u001B[35m"+"\t\t\t\t DETAILS "+"\u001B[0m");
        System.out.print("\u001B[37m"+"\n\n\t\t\t Hotel Name    : ");
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
        hoteluser();
    }

    public void hoteluser()throws IOException,ClassNotFoundException,FileNotFoundException,InterruptedException{
        int c=0;
        System.out.print("\u001B[37m"+"\n\n\t\t\t UserName      : ");
        username1 = in.nextLine();
        password1 = v.password();
        if(file2.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file2));
            dlist1 = (ArrayList<HotelDetails>)ois.readObject();
            ois.close();
        }
        li = dlist1.listIterator();
        while(li.hasNext()){
            HotelDetails d = (HotelDetails)li.next();
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
                hoteluser();
            }
            else{
                System.out.println("\n\n\t\t"+"\u001B[35m"+"===================================================\n\n");
                // System.out.println("\n\n\t\t"+hotel_name+username1+password1+phone_num+district+pincode);
                dlist1.add(new HotelDetails(hotel_name.toUpperCase(),username1, password1,phone_num,district.toUpperCase(),pincode,location.toUpperCase()));
                oos = new ObjectOutputStream(new FileOutputStream(file2));
                oos.writeObject(dlist1);
                oos.close();
                System.out.println("\n\n\t\t\t\t Request sended Succesfully");
                // System.out.println(dlist1);
                System.out.println("\u001B[36m"+"\n\n\t\t <--Back(2)                           Continue-->");
                int n = in.nextInt();
                if(n==1){
                    System.out.print("\033\143");
                    new Home().home();
                }
                else{
                    System.out.print("\033\143");
                    register();
                }
                
            }
        }
        else{
            System.out.print("\033\143");
            System.out.println("\u001B[31m"+"\n\t\t\t Username Already Exists....");
            hoteluser();
        }        
    }

    public void user()throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        int c=0;
        String username = new String();
        String pass = new String();

        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" SWIGGY "+"\u001B[35m"+"=====================\n\n");
        System.out.println("\u001B[47m"+"\u001B[35m"+"\t\t\t\t DETAILS "+"\u001B[0m");
        System.out.println("\u001B[31m"+"\n\n\t\t  Note : Username should be atleast 8 to 16 char (EX: Ganesh123)\n\t\t\t Password Should be exactly 8 to 16char (Ex: Ganesh@1234)");
        System.out.print("\u001B[37m"+"\n\n\t\t\t UserName      : ");
        username = in.nextLine();
        pass = v.password();
        if(file3.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file3));
            dlist2 = (ArrayList<Details>)ois.readObject();
            ois.close();
        }
        li = dlist.listIterator();
        while(li.hasNext()){
            Details d = (Details)li.next();
            if(username.equals(d.name)){
                c=1;
            }
        }
        if(c==0){
            if(!v.validateUser(username) || !v.validatePassword(pass)){
                System.out.print("\033\143");
                System.out.println("\u001B[31m"+"\n\t\t\t Invaild Format of Username or Password");
                user();
            }
            else{
                System.out.println("\n\n\t\t"+"\u001B[35m"+"===================================================\n\n");
                dlist2.add(new Details(username, pass));
                oos = new ObjectOutputStream(new FileOutputStream(file3));
                oos.writeObject(dlist2);
                oos.close();
                System.out.println("\n\n\t\t\t\t Register Succesfully");
                System.out.println("\u001B[36m"+"\n\n\t\t <--Back(2)                           Login(1)-->");
                int n = in.nextInt();
                if(n==1){
                    System.out.print("\033\143");
                    new Login().login();
                }
                else{
                    System.out.print("\033\143");
                    register();
                }
            }
        }
        else{
            System.out.print("\033\143");
            System.out.println("\u001B[31m"+"\n\t\t\t Username Already Exists....");
            user();
        }
    }

}

