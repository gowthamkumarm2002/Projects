import java.io.*;
import java.util.*;

class Product implements Serializable{
    int id;
    String product_name,catagory;
    float rate,discount,quantity;
    private static final long serialVersionUID = -5008211591459042942l;
    public Product(int id,String name, String catagory, float rate, float discount, float quantity){
        this.id = id;
        this.product_name = name;
        this.catagory = catagory;
        this.rate = rate;
        this.discount = discount;
        this.quantity = quantity;
    }
    public String toString(){
        return id+" "+product_name+" "+catagory+" "+rate+" "+discount+" "+quantity+" ";
    }
}

public class dataload {
    public static void main(String args[]) throws IOException, ClassNotFoundException{
        File file1 = new File("Files/Product/Stock.txt");
        ArrayList<Product> dlist = new ArrayList<Product>();
        ObjectOutputStream oos=null;
        // dlist.add(new Product(id,name, catagory, rate, discount, quantity));

        dlist.add(new Product(101,"APPLE","FRUIT",100.0f,2.0f,1000f));
        dlist.add(new Product(102,"BANANA","FRUIT",60.0f,3.0f,1500f));
        dlist.add(new Product(103,"CHERRY","FRUIT",150.0f,2.0f,1000f));
        dlist.add(new Product(104,"DRAGONFRUIT","FRUIT",200.0f,5.0f,500f));
        dlist.add(new Product(105,"GRAPE","FRUIT",120.0f,0.0f,800f));
        dlist.add(new Product(106,"JACKFRUIT","FRUIT",300.0f,4.0f,2000f));
        dlist.add(new Product(107,"MANGO","FRUIT",50.0f,2.0f,2000f));
        dlist.add(new Product(108,"ORANGE","FRUIT",100.0f,2.0f,1000f));
        dlist.add(new Product(109,"PAPAYA","FRUIT",150.0f,10.0f,600f));
        dlist.add(new Product(110,"PINEAPPLE","FRUIT",250.0f,8.0f,1000f));




        dlist.add(new Product(201,"POTATO","VEGETABLE",30.0f,2.0f,1000f));
        dlist.add(new Product(202,"TOMATO","VEGETABLE",20.0f,3.0f,1500f));
        dlist.add(new Product(203,"BEETROOT","VEGETABLE",50.0f,2.0f,1000f));
        dlist.add(new Product(204,"MUSHROOM","VEGETABLE",150.0f,5.0f,500f));
        dlist.add(new Product(205,"CAPSICUM","VEGETABLE",120.0f,0.0f,800f));
        dlist.add(new Product(206,"BEANS","VEGETABLE",60.0f,4.0f,2000f));
        dlist.add(new Product(207,"CARROT","VEGETABLE",50.0f,2.0f,2000f));
        dlist.add(new Product(208,"CUCUMBER","VEGETABLE",100.0f,2.0f,1000f));
        dlist.add(new Product(209,"PUMPKIN","VEGETABLE",150.0f,10.0f,600f));
        dlist.add(new Product(210,"CAULIFLOWER","VEGETABLE",50.0f,8.0f,1000f));

        oos = new ObjectOutputStream(new FileOutputStream(file1));
        oos.writeObject(dlist);
        oos.close();
    }
}
