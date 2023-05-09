package swiggy;

import java.util.*;
import java.io.*;
import swiggy.*;

class DishDetails implements Serializable{
    String d_name,rate,discount,h_name;
    DishDetails(String d_name,String rate,String discount,String h_name){
        this.h_name = h_name;
        this.d_name = d_name;
        this.rate = rate;
        this.discount = discount;
    }
    public String toString(){
        return h_name+" "+d_name+" "+rate+" "+discount+" ";
    }
}

public class HotelHome {
    private String dish_name = new String();
    private Float rate,discount;

    LinkedList<DishDetails> dlist1 = new LinkedList<DishDetails>();

    File file1 = new File("Files/HotelDetails/DishDetails.txt");

    int n;
    Scanner in = new Scanner(System.in);
    ObjectOutputStream oos=null;
    ObjectInputStream ois=null;
    ListIterator li = null;

    public void hotelHome(String h_name)throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        while(true){
            System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" SWIGGY "+"\u001B[35m"+"=====================\n\n");
            System.out.println("\t\t\t\t"+"\u001B[37m"+"  1. Add Dish ");
            System.out.println("\t\t\t\t  2. View Dish");
            System.out.println("\t\t\t\t  3. Update Dish");
            System.out.println("\t\t\t\t  4. Delete Dish");
            System.out.println("\t\t\t\t  5. Logout");
            System.out.println("\n\n\t\t"+"\u001B[35m"+"===================================================\n\n");
            System.out.print("\n\t\t\t  Enter your Choice : ");
            int n1 = in.nextInt();
            switch(n1){
                case 1:
                    System.out.print("\033\143");
                    in.nextLine();
                    addDish(h_name);
                    break;
                case 2:
                    System.out.print("\033\143");
                    viewDish(h_name);
                    break;
                case 3:
                    System.out.print("\033\143");
                    in.nextLine();
                    updateDish(h_name);
                    break;
                case 4:
                    System.out.print("\033\143");
                    in.nextLine();
                    deleteDish(h_name);
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

    public void addDish(String h_name)throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        int c=0;
        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" SWIGGY "+"\u001B[35m"+"=====================\n\n");
        System.out.println("\u001B[47m"+"\u001B[35m"+"\t\t\t\t DETAILS "+"\u001B[0m");
        System.out.print("\u001B[37m"+"\n\n\t\t\t Dish Name       : ");
        dish_name = in.nextLine();
        if(file1.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file1));
            dlist1 = (LinkedList<DishDetails>)ois.readObject();
            ois.close();
        }
        li = dlist1.listIterator();
        while(li.hasNext()){
            DishDetails d = (DishDetails)li.next();
            if(dish_name.equalsIgnoreCase(d.d_name)){
                c=1;
            }
        }
        if(c==0){
            System.out.print("\u001B[37m"+"\n\n\t\t\t Rate (per Kgs)  : ");
            rate = in.nextFloat();
            System.out.print("\u001B[37m"+"\n\n\t\t\t Discount (100%) : ");
            discount = in.nextFloat();
            dlist1.add(new DishDetails(dish_name.toUpperCase() ,String.valueOf(rate), String.valueOf(discount), h_name.toUpperCase()));
            oos = new ObjectOutputStream(new FileOutputStream(file1));
            oos.writeObject(dlist1);
            oos.close();
            System.out.println("\n\n\t\t"+"\u001B[35m"+"===================================================\n\n");
            System.out.println("\n\n\t\t\t\t Dish added Succesfully");
            System.out.println("\u001B[36m"+"\n\n\t\t <--Back(2)                           Add(1)-->");
            int n = in.nextInt();
            if(n==1){
                System.out.print("\033\143");
                in.nextLine();
                addDish(h_name);
            }
            else{
                System.out.print("\033\143");
                hotelHome(h_name);
            }
        }
        else{
            System.out.print("\033\143");
            System.out.println("\u001B[31m"+"\t\t\t\tDish is Already exists...."+"\u001B[0m");
            addDish(h_name);
        }
    }

    public void viewDish(String h_name)throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        int c=0;
        if(file1.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file1));
            dlist1 = (LinkedList<DishDetails>)ois.readObject();
            ois.close();
        }
        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" SWIGGY "+"\u001B[35m"+"=====================\n\n");
        System.out.println("\u001B[35m"+"\n\t\t+================+=================+=================+");
        System.out.printf("\t\t|%-15s | %-15s | %-15s |\n","DISH NAME","RATE","DISCOUNT");
        System.out.println("\t\t+================+=================+=================+");
        for(DishDetails h:dlist1){
            c=1;
            System.out.printf("\t\t|%-15s | %-15s | %-15s |\n",h.d_name,h.rate,h.discount);
            System.out.println("\t\t+================+=================+=================+");
        }
        if(c==0){
            System.out.println("\t\t"+"\u001B[35m"+"| \t\t          No Dish           \t\t\t\t |");
            System.out.println("\t\t+================+=================+=================+");
        }
        System.out.println("\u001B[36m"+"\n\n\t\t <--Back(2)                           Continue-->");
        in.nextInt();
        System.out.print("\033\143");
        hotelHome(h_name);
    }

    public void updateDish(String h_name)throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        int c=0;
        String d_name;
        if(file1.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file1));
            dlist1 = (LinkedList<DishDetails>)ois.readObject();
            ois.close();
        }
        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" SWIGGY "+"\u001B[35m"+"=====================\n\n");
        System.out.print("\n\t\t\t  Dish Name : ");
        d_name = in.nextLine();
        System.out.println("\u001B[35m"+"\n\t\t+================+=================+=================+");
        System.out.printf("\t\t|%-15s | %-15s | %-15s |\n","DISH NAME","RATE","DISCOUNT");
        System.out.println("\t\t+================+=================+=================+");
        for(DishDetails h:dlist1){
            String s;
            if(d_name.equalsIgnoreCase(h.d_name)){
                System.out.printf("\t\t|%-15s | %-15s | %-15s |\n",h.d_name,h.rate,h.discount);
                System.out.println("\t\t+================+=================+=================+");
                c=1;
                System.out.print("\n\n\t\tIf you want update Rate (Y/N)    : ");
                s = in.next();
                if(s.equals("Y") || s.equals("y")){
                    System.out.print("\u001B[37m"+"\n\n\t\t\t Rate (per Kgs)  : ");
                    rate = in.nextFloat();
                    h.rate = String.valueOf(rate);
                }
                System.out.print("\u001B[35m"+"\n\n\t\tIf you want update Discount (Y/N) : ");
                s = in.next();
                if(s.equals("Y") || s.equals("y")){
                    System.out.print("\u001B[37m"+"\n\n\t\t\t Discount (100%) : ");
                    discount = in.nextFloat();
                    h.discount = String.valueOf(discount);
                }
            }
        }
        
        if(c==0){
            System.out.println("\t\t"+"\u001B[35m"+"| \t\t    No Dish  \t\t\t     |");
            System.out.println("\t\t+================+=================+=================+");
            System.out.println("\n\n\t\t"+"\u001B[35m"+"===================================================\n\n");
            System.out.println("\u001B[36m"+"\n\n\t\t <--Back(2)                           Update(1)-->");
            int n = in.nextInt();
            if(n==1){
                System.out.print("\033\143");
                in.nextLine();
                updateDish(h_name);
            }
            else{
                System.out.print("\033\143");
                hotelHome(h_name);
            }
        }
        else{
            oos = new ObjectOutputStream(new FileOutputStream(file1));
            oos.writeObject(dlist1);
            oos.close();
            System.out.println("\n\n\t\t"+"\u001B[35m"+"===================================================\n\n");
            System.out.println("\u001B[36m"+"\n\n\t\t <--Back(2)                           Update(1)-->");
            int n = in.nextInt();
            if(n==1){
                System.out.print("\033\143");
                in.nextLine();
                updateDish(h_name);
            }
            else{
                System.out.print("\033\143");
                hotelHome(h_name);
            }
        }
    }

    public void deleteDish(String h_name)throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        int c=0;
        String d_name;
        if(file1.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file1));
            dlist1 = (LinkedList<DishDetails>)ois.readObject();
            ois.close();
        }
        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" SWIGGY "+"\u001B[35m"+"=====================\n\n");
        System.out.print("\n\t\t\t  Dish Name : ");
        d_name = in.nextLine();
        System.out.println("\u001B[35m"+"\n\t\t+================+=================+=================+");
        System.out.printf("\t\t|%-15s | %-15s | %-15s |\n","DISH NAME","RATE","DISCOUNT");
        System.out.println("\t\t+================+=================+=================+");
        for(DishDetails h:dlist1){
            if(d_name.equalsIgnoreCase(h.d_name)){
                System.out.printf("\t\t|%-15s | %-15s | %-15s |\n",h.d_name,h.rate,h.discount);
                System.out.println("\t\t+================+=================+=================+");
                c=1;
            }
        }
        
        if(c==1){
            System.out.println("\n\n\t\t"+"\u001B[35m"+"===================================================\n\n");
            System.out.println("\u001B[36m"+"\n\n\t\t <--Back(3)           Confirm(1)          Cancel(2)-->");
            n =in.nextInt();
            if(n==1){
                li = dlist1.listIterator();
                while(li.hasNext()){
                    DishDetails pq = (DishDetails)li.next();
                    if(d_name.equalsIgnoreCase(pq.d_name)){
                        li.remove();
                    }
                }
                oos = new ObjectOutputStream(new FileOutputStream(file1));
                oos.writeObject(dlist1);
                oos.close();
                // System.out.println(dlist1);
                System.out.println("\n\n\t\t"+"\u001B[35m"+"===================================================\n\n");
                System.out.println("\u001B[36m"+"\n\n\t\t <--Back(2)                           Delete(1)-->");
                int n = in.nextInt();
                if(n==1){
                    System.out.print("\033\143");
                    in.nextLine();
                    deleteDish(h_name);
                }
                else{
                    System.out.print("\033\143");
                    hotelHome(h_name);
                }
            }
            else{
                System.out.print("\033\143");
                hotelHome(h_name);
            }   
        }
        else{
            System.out.println("\t\t"+"\u001B[35m"+"| \t\t    No Dish  \t\t\t     |");
            System.out.println("\t\t+================+=================+=================+");
            System.out.println("\n\n\t\t"+"\u001B[35m"+"===================================================\n\n");
            System.out.println("\u001B[36m"+"\n\n\t\t <--Back(2)                           Delete(1)-->");
            int n = in.nextInt();
            if(n==1){
                System.out.print("\033\143");
                in.nextLine();
                deleteDish(h_name);
            }
            else{
                System.out.print("\033\143");
                hotelHome(h_name);
            }
        }
    }

}


