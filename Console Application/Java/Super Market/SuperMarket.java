
import java.util.*;
import java.io.*;

class Color{
    // Declaring ANSI_RESET so that we can reset the color
    public static final String ANSI_RESET = "\u001B[0m";
  
	// Text Color
    public static final String BLACK   = "\u001B[30m";
	public static final String RED     = "\u001B[31m";
	public static final String GREEN   = "\u001B[32m";
	public static final String YELLOW  = "\u001B[33m";
	public static final String BLUE    = "\u001B[34m";
	public static final String PURPLE  = "\u001B[35m";
	public static final String CYAN    = "\u001B[36m";
	public static final String WHITE   = "\u001B[37m";

	// Background Color
	public static final String BLACK_BACKGROUND  = "\u001B[40m";
	public static final String RED_BACKGROUND    = "\u001B[41m";
	public static final String GREEN_BACKGROUND  = "\u001B[42m";
	public static final String YELLOW_BACKGROUND = "\u001B[43m";
	public static final String BLUE_BACKGROUND   = "\u001B[44m";
	public static final String PURPLE_BACKGROUND = "\u001B[45m";
	public static final String CYAN_BACKGROUND   = "\u001B[46m";
	public static final String WHITE_BACKGROUND  = "\u001B[47m";
}

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

class Product implements Serializable{
    private static final long serialVersionUID = -5008211591459042942l;
    int id;
    String product_name,catagory;
    float rate,discount,quantity;
    public Product(int id,String name, String catagory, float rate, float discount, float quantity){
        this.id = id;
        this.product_name = name;
        this.catagory = catagory;
        this.rate = rate;
        this.discount = discount;
        this.quantity = quantity;
    }
    public static Comparator<Product> ProductId = new Comparator<Product>() {
        public int compare(Product s1, Product s2) {
            int id1 = s1.id;
            int id2 = s2.id;
            return id1-id2;   
        }
    };
    public String toString(){
        return id+" "+product_name+" "+catagory+" "+rate+" "+discount+" "+quantity+" ";
    }
}

class UserCart implements Serializable{
    private static final long serialVersionUID = 8203243867311216466l;
    int id;
    String username;
    float quantity;
    public UserCart(String username,int id, float quantity){
        this.username = username;
        this.id = id;
        this.quantity = quantity;
    }
    public static Comparator<UserCart> UserNamesort = new Comparator<UserCart>() {
        public int compare(UserCart s1, UserCart s2) {
            String id1 = s1.username;
            String id2 = s2.username;
            return id1.compareTo(id2);  
        }
    };
    public static Comparator<UserCart> ProductId = new Comparator<UserCart>() {
        public int compare(UserCart s1, UserCart s2) {
            int id1 = s1.id;
            int id2 = s2.id;
            return id1-id2;   
        }
    };
    public String toString(){
        return username+" "+id+" "+quantity+" ";
    }
}

class BilledDetails implements Serializable{
    private static final long serialVersionUID = -7120200936935765830l;
    int id;
    String product_name,catagory,username,casierName;
    float rate,discount,quantity,dis_rate,final_rate;
    public BilledDetails(int id,String name, String username,float rate, float discount, float quantity,float dis_rate, float final_rate,String casierName){
        this.id = id;
        this.product_name = name;
        this.username = username;
        this.rate = rate;
        this.discount = discount;
        this.quantity = quantity;
        this.dis_rate = dis_rate;
        this.final_rate = final_rate;
        this.casierName = casierName;
    }
    public String toString(){
        return id+" "+product_name+" "+username+" "+rate+" "+discount+" "+quantity+" "+dis_rate+" "+final_rate+" "+casierName+" ";
    }
}

class Welcome extends Color{
    public void welcome(){
        try { 
            System.out.println(CYAN+"\n\n\n\t\t\t+-----------------------------------------------------------+");
            System.out.println(CYAN+"\t\t\t|\t                                                    |");
            System.out.println(CYAN+"\t\t\t|\t=============================================       |");
            System.out.println(CYAN+"\t\t\t|\t================ "+GREEN+" WELCOME TO "+CYAN+" ===============       |");
            System.out.println(CYAN+"\t\t\t|\t================= "+GREEN+" KRISHNA "+CYAN+" =================       |");
            System.out.println(CYAN+"\t\t\t|\t=============== "+GREEN+" SUPERMARKET "+CYAN+" ===============       |");
            System.out.println(CYAN+"\t\t\t|\t=============================================       |");
            System.out.println(CYAN+"\t\t\t|\t                                                    |");
            System.out.println(CYAN+"\t\t\t+-----------------------------------------------------------+"+ANSI_RESET);
            Thread.sleep(1000);
            Home h = new Home();
            System.out.print("\033\143");
            h.home();
        }
        catch (Exception expn){  
            System.out.println(expn);  
        }  
    }   
}

class Home{
    Login l = new Login();
    Register r = new Register();
    Scanner in = new Scanner(System.in);

    public void login() throws IOException, ClassNotFoundException{
        while(true){
            System.out.println("\n\n\n\t\t"+"\u001B[35m"+"=============== "+"\u001B[33m"+"KRISHNA SUPERMARKET "+"\u001B[35m"+"===============\n\n");
            System.out.println("\t\t\t\t"+"\u001B[37m"+"  1. Admin Login ");
            System.out.println("\t\t\t\t  2. Casier Login");
            System.out.println("\t\t\t\t  3. Back");
            System.out.println("\n\n\t\t"+"\u001B[35m"+"===================================================\n\n");
            System.out.print("\n\t\t\t  Enter your Choice : ");
            int n1 = in.nextInt();
            switch(n1){
                case 1:
                    System.out.print("\033\143");
                    l.login(n1);
                    break;
                case 2:
                    System.out.print("\033\143");
                    l.login(n1);
                    break;
                case 3:
                    System.out.print("\033\143");
                    home();
                    break;
                default:
                    System.out.print("\033\143");
                    System.out.println("\u001B[31m"+"\t\t\t\tInvalid Input"+"\u001B[0m");
            }
        }
    }

    public void register() throws IOException, ClassNotFoundException{
        while(true){
            System.out.println("\n\n\n\t\t"+"\u001B[35m"+"=============== "+"\u001B[33m"+"KRISHNA SUPERMARKET "+"\u001B[35m"+"===============\n\n");
            System.out.println("\t\t\t\t"+"\u001B[37m"+"  1. Admin Register ");
            System.out.println("\t\t\t\t  2. Casier Register");
            System.out.println("\t\t\t\t  3. Back");
            System.out.println("\n\n\t\t"+"\u001B[35m"+"===================================================\n\n");
            System.out.print("\n\t\t\t  Enter your Choice : ");
            int n2 = in.nextInt();
            switch(n2){
                case 1:
                    System.out.print("\033\143");
                    r.register(n2);
                    break;
                case 2:
                    System.out.print("\033\143");
                    r.register(n2);
                    break;
                case 3:
                    System.out.print("\033\143");
                    home();
                    break;
                default:
                    System.out.print("\033\143");
                    System.out.println("\u001B[31m"+"\t\t\t\tInvalid Input"+"\u001B[0m");
            }
        }
    }
    
    public void home() throws IOException, ClassNotFoundException{
        while(true){
            System.out.println("\n\n\n\t\t"+"\u001B[35m"+"=============== "+"\u001B[33m"+"KRISHNA SUPERMARKET "+"\u001B[35m"+"===============\n\n");
            System.out.println("\t\t\t\t"+"\u001B[37m"+"  1. Login ");
            System.out.println("\t\t\t\t  2. Register ");
            System.out.println("\t\t\t\t  3. User Entry ");
            System.out.println("\t\t\t\t  4. Exit");
            System.out.println("\n\n\t\t"+"\u001B[35m"+"===================================================\n\n");
            System.out.print("\n\t\t\t  Enter your Choice : ");
            int num = in.nextInt();
            System.out.print("\033\143");
            switch(num){
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    UserEntryHome u = new UserEntryHome();
                    u.userEntryHome();
                    break;
                case 4:
                    System.out.print("\033\143");
                    System.exit(0);
                default:
                    System.out.print("\033\143");
                    System.out.println("\u001B[31m"+"\t\t\t\tInvalid Input"+"\u001B[0m");
            }
        }
        

        

    }
}

class Login{
    char password[];
    Console console;
    Scanner in = new Scanner(System.in);
    
    public static String toString(char[] a){
        String string = new String(a);
        return string;
    }

    public void login(int x) throws IOException, ClassNotFoundException{
        File file1 = new File("Files/LoginDetails/Admindetails.txt");
        File file2 = new File("Files/LoginDetails/CasierDetails.txt");
        ArrayList<Details> dlist = new ArrayList<Details>();
        ObjectInputStream ois=null;
        ListIterator li = null;
        while(true){
            int c=0;
            String username = new String();
            System.out.println("\n\n\n\t\t"+"\u001B[35m"+"=============== "+"\u001B[33m"+"KRISHNA SUPERMARKET "+"\u001B[35m"+"===============\n\n");
            System.out.println("\t\t                     LOGIN  \n\n  ");
            System.out.print("\t\t\t UserName    : ");
            username = in.nextLine();
            if((console = System.console())!=null){
                System.out.print("\t\t\t Password    : ");
                password = console.readPassword();
            }
            String pass = toString(password);
            System.out.println("\n\n\t\t"+"\u001B[35m"+"===================================================\n\n");
            switch(x){
                case 1:
                    if(file1.isFile()){
                        ois = new ObjectInputStream(new FileInputStream(file1));
                        dlist = (ArrayList<Details>)ois.readObject();
                        ois.close();
                    }
                    li = dlist.listIterator();
                    while(li.hasNext()){
                        Details d = (Details)li.next();
                        if(username.equals(d.name) && pass.equals(d.pass)){
                            System.out.println("\n\n\t\t\t Login Successfull");
                            c=1;
                            System.out.print("\033\143");   
                            AdminPage ap = new AdminPage();
                            ap.adminPage();
                        }
                    }
                    if(c==0){
                        System.out.print("\033\143");
                        System.out.println("\u001B[31m"+"\t\t\t\tInvalid Input"+"\u001B[0m");
                        login(x);
                    }
                    break;
                case 2:
                    if(file2.isFile()){
                        ois = new ObjectInputStream(new FileInputStream(file2));
                        dlist = (ArrayList<Details>)ois.readObject();
                        ois.close();
                    }
                    li = dlist.listIterator();
                    while(li.hasNext()){
                        Details d = (Details)li.next();
                        if(username.equals(d.name) && pass.equals(d.pass)){
                            System.out.println("\n\n\t\t\t Login Successfull");
                            c=1;
                            System.out.print("\033\143"); 
                            CasierHome ch =new CasierHome();
                            ch.casierHome(username);
                        }
                    }
                    if(c==0){
                        System.out.print("\033\143");
                        System.out.println("\u001B[31m"+"\t\t\t\tInvalid Input"+"\u001B[0m");
                        login(x);
                    }
                    break;
            }
        }
        
    }
}

class Register {
    char password[];
    Console console;
    Scanner in = new Scanner(System.in);

    File file1 = new File("Files/LoginDetails/Admindetails.txt");
    File file2 = new File("Files/LoginDetails/CasierDetails.txt");
    ArrayList<Details> dlist = new ArrayList<Details>();
    ObjectOutputStream oos=null;
    ObjectInputStream ois=null;
    ListIterator li = null;

    public static String toString(char[] a){
        String string = new String(a);
        return string;
    }
    public void register(int x) throws IOException, ClassNotFoundException{
        int c=0;
        String username = new String();
        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"=============== "+"\u001B[33m"+"KRISHNA SUPERMARKET "+"\u001B[35m"+"===============\n\n");
        System.out.println("\t\t                     REGISTER  \n\n  ");
        System.out.print("\t\t\t UserName    : ");
        username = in.nextLine();
        if((console = System.console())!=null){
            System.out.print("\t\t\t Password    : ");
            password = console.readPassword();
        }
        String pass = toString(password);
        System.out.println("\n\n\t\t"+"\u001B[35m"+"===================================================\n\n");
        if(x==1){
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
                dlist.add(new Details(username, pass));
                oos = new ObjectOutputStream(new FileOutputStream(file1));
                oos.writeObject(dlist);
                oos.close();
                System.out.println("\u001B[32m"+"\n\n\t\t\t\tRegister Successfully");
                System.out.println("\u001B[36m"+"\n\n\t\t <--Back(2)                           Login(1)-->");
                // System.out.println(dlist);
                int n = in.nextInt();
                System.out.print("\033\143");
                if(n==1){
                    Home h = new Home();
                    h.login();
                }
                else{
                    Home h = new Home();
                    h.home();
                }
            }
            else{
                System.out.print("\033\143");
                System.out.println("\u001B[31m"+"\t\t\t\tUser is already exists.."+"\u001B[0m");
                System.out.println("\n\n\n\t\t"+"\u001B[35m"+"=============== "+"\u001B[33m"+"KRISHNA SUPERMARKET "+"\u001B[35m"+"===============\n\n");
                System.out.print("\u001B[37m"+"\n\t\t\t\t 1. Login \n\t\t\t\t 2. Register \n\t\t\t\t 3. Back");
                System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================================================\n\n");
                System.out.print("\n\t\t\t Enter your choice : ");
                int n = in.nextInt();
                switch(n){
                    case 1:
                        System.out.print("\033\143");
                        Login l = new Login();
                        in.nextLine();
                        l.login(x); 
                        break;
                    case 2:
                        System.out.print("\033\143");
                        in.nextLine();
                        register(x);
                        break;
                    default:
                        System.out.print("\033\143");
                        Home h = new Home();
                        h.home();
                        break;
                }
            }
        }
        else if(x==2){
            if(file2.isFile()){
                ois = new ObjectInputStream(new FileInputStream(file2));
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
                dlist.add(new Details(username, pass));
                oos = new ObjectOutputStream(new FileOutputStream(file2));
                oos.writeObject(dlist);
                oos.close();
                System.out.println("\u001B[32m"+"\n\n\t\t\t\tRegister Successfully");
                // System.out.println(dlist);
                System.out.println("\u001B[36m"+"\n\n\t\t <--Back(2)                           Login(1)-->\n\t\t\t\t");
                int n = in.nextInt();
                System.out.print("\033\143");
                if(n==1){
                    Home h = new Home();
                    h.login();
                }
                else{
                    Home h = new Home();
                    h.home();
                }
            }
            else{
                System.out.print("\033\143");
                System.out.println("\u001B[31m"+"\t\t\t\tUser is already exists.."+"\u001B[0m");
                System.out.println("\n\n\n\t\t"+"\u001B[35m"+"=============== "+"\u001B[33m"+"KRISHNA SUPERMARKET "+"\u001B[35m"+"===============\n\n");
                System.out.print("\u001B[37m"+"\n\t\t\t\t 1. Login \n\t\t\t\t 2. Register \n\t\t\t\t 3. Back");
                System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================================================\n\n");
                System.out.print("\n\t\t\t Enter your choice : ");
                int n = in.nextInt();
                switch(n){
                    case 1:
                        System.out.print("\033\143");
                        Login l = new Login();
                        in.nextLine();
                        l.login(x); 
                        break;
                    case 2:
                        System.out.print("\033\143");
                        in.nextLine();
                        register(x);
                        break;
                    default:
                        System.out.print("\033\143");
                        Home h = new Home();
                        h.home();
                        break;
                }
            }
        }
    }
}

class AdminPage{
    Scanner in = new Scanner(System.in);
    int id;
    String name,catagory;
    float rate,discount,quantity;

    public void adminPage() throws IOException, ClassNotFoundException{
        while(true){
            System.out.println("\n\n\n\t\t"+"\u001B[35m"+"=============== "+"\u001B[33m"+"KRISHNA SUPERMARKET "+"\u001B[35m"+"===============\n\n");
            System.out.println("\t\t\t\t  1. Add Product");
            System.out.println("\t\t\t\t  2. View Product");
            System.out.println("\t\t\t\t  3. Search Product");
            System.out.println("\t\t\t\t  4. Update Product");
            System.out.println("\t\t\t\t  5. Delete Product");
            System.out.println("\t\t\t\t  6. Billed Details");
            System.out.println("\t\t\t\t  7. Back");
            System.out.println("\n\n\t\t"+"\u001B[35m"+"===================================================\n\n");
            System.out.print("\n\t\t\t  Enter your Choice : ");
            int num = in.nextInt();
            System.out.print("\033\143");
            switch(num){
                case 1:
                    addProduct();
                    break;
                case 2:
                    viewProduct();
                    break;
                case 3:
                    searchProduct();
                    break;
                case 4:
                    updateProduct();
                    break;
                case 5:
                    deleteProduct();
                    break;
                case 6:
                    billedDetails();
                    break;
                case 7:
                    System.out.print("\033\143");
                    Home h = new Home();
                    h.home();
                    break;
                default:
                    System.out.print("\033\143");
                    System.out.println("\u001B[31m"+"\t\t\t\tInvalid Input"+"\u001B[0m");
            }
        }
    }
    
    public void addProduct() throws IOException, ClassNotFoundException{
        File file1 = new File("Files/Product/Stock.txt");
        ArrayList<Product> dlist = new ArrayList<Product>();
        ObjectOutputStream oos=null;
        ObjectInputStream ois=null;
        ListIterator li = null;
        int c=0;
        if(file1.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file1));
            dlist = (ArrayList<Product>)ois.readObject();
            ois.close();
        }
        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"=============== "+"\u001B[33m"+"KRISHNA SUPERMARKET "+"\u001B[35m"+"===============\n\n");
        System.out.print("\n\t\t\t\t Product Id             : ");
        id = in.nextInt();
        li = dlist.listIterator();
        while(li.hasNext()){
            Product d = (Product)li.next();
            if(id==d.id){
                c=1;
                break;
            }
        }
        if(c==0){
            in.nextLine();
            System.out.print("\n\t\t\t\t Product Name           : ");
            name = in.nextLine().toUpperCase();
            System.out.print("\n\t\t\t\t Product Catagory       : ");
            catagory = in.nextLine().toUpperCase();
            System.out.print("\n\t\t\t\t Rate per Kg            : ");
            rate = in.nextFloat();
            System.out.print("\n\t\t\t\t Discount(below 100%)   : ");
            discount = in.nextFloat();
            System.out.print("\n\t\t\t\t Quantity in Kg         : ");
            quantity = in.nextFloat();
            System.out.println("\n\n\t\t"+"\u001B[35m"+"===================================================\n\n");
            
            dlist.add(new Product(id,name.toUpperCase(), catagory.toUpperCase(), rate, discount, quantity));
            oos = new ObjectOutputStream(new FileOutputStream(file1));
            oos.writeObject(dlist);
            oos.close();
            System.out.println("\n\t\t\tProduct added Successfully");
            System.out.println("\n\n\t\t"+"\u001B[35m"+"===================================================\n\n");
            System.out.println("\n\n\t\t <--Back(2)                           Continue(1)-->");
            System.out.print("\t\t\t\t\t");
            int n = in.nextInt();
            if(n==1){
                System.out.print("\033\143");
                addProduct();
            }
            else{
                System.out.print("\033\143");
                adminPage();
            }
        }
        else if(c==1){
            System.out.print("\033\143");
            System.out.println("\u001B[31m"+"\n\n\t\t\tProduct ID is already exists...");
            addProduct();
        }
    }

    public void viewProduct() throws IOException, ClassNotFoundException {
        File file1 = new File("Files/Product/Stock.txt");
        ArrayList<Product> dlist = new ArrayList<Product>();
        ObjectOutputStream oos=null;
        ObjectInputStream ois=null;
        ListIterator li = null;
        if(file1.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file1));
            dlist = (ArrayList<Product>)ois.readObject();
            ois.close();
        }
        Collections.sort(dlist, Product.ProductId);
        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"=============== "+"\u001B[33m"+"KRISHNA SUPERMARKET "+"\u001B[35m"+"===============\n\n");
        System.out.println("\n\t\t+===============================================================================================+");
        System.out.printf("\t\t|%-15s %-15s %-15s %-15s %-15s %-10s \t|\n","ID","NAME","CATAGORY","RATE","DISCOUNT","QUANTITY");
        System.out.printf("\t\t|%-15s %-15s %-15s %-15s %-15s %-10s \t|\n","","","","(in Rs)","(in %)","(in Kgs)");
        System.out.println("\t\t+===============================================================================================+");
        for(Product a:dlist){
            System.out.printf("\t\t| %-15d %-15s %-15s %-15.2f %-15.2f %-10.2f \t|\n",a.id,a.product_name,a.catagory,a.rate,a.discount,a.quantity);
            System.out.println("\t\t+===============================================================================================+");

        }
        System.out.println("\n\n\t\t <--Back(2)                              Continue-->");
        System.out.print("\t\t\t\t\t");
        int n = in.nextInt();
        System.out.print("\033\143");
        adminPage();
        
    }

    public void searchProduct() throws IOException, ClassNotFoundException{
        File file1 = new File("Files/Product/Stock.txt");
        ArrayList<Product> dlist = new ArrayList<Product>();
        ObjectOutputStream oos=null;
        ObjectInputStream ois=null;
        ListIterator li = null;
        int c=0;
        if(file1.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file1));
            dlist = (ArrayList<Product>)ois.readObject();
            ois.close();
        }
        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"=============== "+"\u001B[33m"+"KRISHNA SUPERMARKET "+"\u001B[35m"+"===============\n\n");
        System.out.print("\n\t\t\t\t Product Id             : ");
        id = in.nextInt();
        System.out.println("\n\t\t+===============================================================================================+");
        System.out.printf("\t\t|%-15s %-15s %-15s %-15s %-15s %-10s \t|\n","ID","NAME","CATAGORY","RATE","DISCOUNT","QUANTITY");
        System.out.printf("\t\t|%-15s %-15s %-15s %-15s %-15s %-10s \t|\n","","","","(in Rs)","(in %)","(in Kgs)");
        System.out.println("\t\t+===============================================================================================+");
        for(Product a:dlist){
            if(id==a.id){
                c+=1;
                System.out.printf("\t\t| %-15d %-15s %-15s %-15.2f %-15.2f %-10.2f \t|\n",a.id,a.product_name,a.catagory,a.rate,a.discount,a.quantity);
                System.out.println("\t\t+===============================================================================================+");
            }
        }
        if(c==0){
            System.out.println("\t\t| \t\t\t\t\t No Records \t\t\t\t\t        |");
            System.out.println("\t\t+===============================================================================================+");
        }
        System.out.println("\n\n\t\t <--Back(2)                              Search(1)-->");
        System.out.print("\t\t\t\t\t");
        int n = in.nextInt();
        if(n==1){
            System.out.print("\033\143");
            searchProduct();
        }
        else{
            System.out.print("\033\143");
            adminPage();
        }
    }
    
    public void updateProduct() throws IOException, ClassNotFoundException{
        File file1 = new File("Files/Product/Stock.txt");
        ArrayList<Product> dlist = new ArrayList<Product>();
        ObjectOutputStream oos=null;
        ObjectInputStream ois=null;
        ListIterator li = null;
        int c=0;
        if(file1.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file1));
            dlist = (ArrayList<Product>)ois.readObject();
            ois.close();
        }
        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"=============== "+"\u001B[33m"+"KRISHNA SUPERMARKET "+"\u001B[35m"+"===============\n\n");
        System.out.print("\n\t\t\t\t Product Id             : ");
        id = in.nextInt();
        System.out.println("\n\t\t+===============================================================================================+");
        System.out.printf("\t\t|%-15s %-15s %-15s %-15s %-15s %-10s \t|\n","ID","NAME","CATAGORY","RATE","DISCOUNT","QUANTITY");
        System.out.printf("\t\t|%-15s %-15s %-15s %-15s %-15s %-10s \t|\n","","","","(in Rs)","(in %)","(in Kgs)");
        System.out.println("\t\t+===============================================================================================+");
        for(Product a:dlist){
            String s;
            if(id==a.id){
                c+=1;
                System.out.printf("\t\t| %-15d %-15s %-15s %-15.2f %-15.2f %-10.2f \t|\n",a.id,a.product_name,a.catagory,a.rate,a.discount,a.quantity);
                System.out.println("\t\t+===============================================================================================+");
                System.out.print("\n\t\t\tIf you want update Name (Y/N)     : ");
                s = in.next();
                if(s.equals("Y") || s.equals("y")){
                    in.nextLine();
                    System.out.print("\n\t\t\t\tProduct Name           : ");
                    name = in.nextLine();
                    a.product_name = name;
                }
                System.out.print("\n\t\t\tIf you want update Catagory (Y/N) : ");
                s = in.next();
                if(s.equals("Y") || s.equals("y")){
                    in.nextLine();
                    System.out.print("\n\t\t\t\tProduct Catagory       : ");
                    catagory = in.nextLine();
                    a.catagory = catagory;
                }
                System.out.print("\n\t\t\tIf you want update Rate (Y/N)     : ");
                s = in.next();
                if(s.equals("Y") || s.equals("y")){
                    System.out.print("\n\t\t\t\tRate per Kg            : ");
                    rate = in.nextFloat();
                    a.rate = rate;
                }
                System.out.print("\n\t\t\tIf you want update Discount (Y/N) : ");
                s = in.next();
                if(s.equals("Y") || s.equals("y")){
                    System.out.print("\n\t\t\t\tDiscount(below 100%)   : ");
                    discount = in.nextFloat();
                    a.discount = discount;
                }
                System.out.print("\n\t\t\tIf you want Add Quantity (Y/N)    : ");
                s = in.next();
                if(s.equals("Y") || s.equals("y")){
                    System.out.print("\n\t\t\t\tQuantity in Kg         : ");
                    quantity = in.nextFloat();
                    a.quantity += quantity;
                }
            }
        }
        if(c==0){
            System.out.println("\t\t| \t\t\t\t\t No Records \t\t\t\t\t        |");
            System.out.println("\t\t+===============================================================================================+");

        }
        else{
            oos = new ObjectOutputStream(new FileOutputStream(file1));
            oos.writeObject(dlist);
            oos.close();
            System.out.println("\n\t\t\tProduct added Successfully");
        }
        System.out.println("\n\n\t\t <--Back(2)                              Update(1)-->");
        System.out.print("\t\t\t\t\t");
        int n = in.nextInt();
        if(n==1){
            System.out.print("\033\143");
            updateProduct();
        }
        else{
            System.out.print("\033\143");
            adminPage();
        }
    }

    public void deleteProduct() throws IOException, ClassNotFoundException{
        File file1 = new File("Files/Product/Stock.txt");
        ArrayList<Product> dlist = new ArrayList<Product>();
        ObjectOutputStream oos=null;
        ObjectInputStream ois=null;
        ListIterator li = null;
        int c=0;
        if(file1.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file1));
            dlist = (ArrayList<Product>)ois.readObject();
            ois.close();
        }
        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"=============== "+"\u001B[33m"+"KRISHNA SUPERMARKET "+"\u001B[35m"+"===============\n\n");
        System.out.print("\n\t\t\t\t Product Id             : ");
        id = in.nextInt();
        System.out.println("\n\t\t+===============================================================================================+");
        System.out.printf("\t\t|%-15s %-15s %-15s %-15s %-15s %-10s \t|\n","ID","NAME","CATAGORY","RATE","DISCOUNT","QUANTITY");
        System.out.printf("\t\t|%-15s %-15s %-15s %-15s %-15s %-10s \t|\n","","","","(in Rs)","(in %)","(in Kgs)");
        System.out.println("\t\t+===============================================================================================+");
        for(Product a:dlist){
            if(id==a.id){
                c+=1;
                System.out.printf("\t\t| %-15d %-15s %-15s %-15.2f %-15.2f %-10.2f \t|\n",a.id,a.product_name,a.catagory,a.rate,a.discount,a.quantity);
                System.out.println("\t\t+===============================================================================================+");
            }
        }
        li = dlist.listIterator();
        while(li.hasNext()){
            Product p = (Product)li.next();
            if(id==p.id){
                li.remove();
                c++;
            }
        }
        if(c==0){
            System.out.println("\t\t| \t\t\t\t\t No Records \t\t\t\t\t        |");
            System.out.println("\t\t+===============================================================================================+");
        }
        else{
            oos = new ObjectOutputStream(new FileOutputStream(file1));
            oos.writeObject(dlist);
            oos.close();
            System.out.println("\n\t\t\tProduct Deleted Successfully");
        }
        System.out.println("\n\n\t\t <--Back(2)                              Delete(1)-->");
        System.out.print("\t\t\t\t\t");
        int n = in.nextInt();
        if(n==1){
            System.out.print("\033\143");
            deleteProduct();
        }
        else{
            System.out.print("\033\143");
            adminPage();
        }
    }

    public void billedDetails() throws IOException, ClassNotFoundException{

        File file3 = new File("Files/Product/BilledDetails.txt");
        ArrayList<BilledDetails> dlist = new ArrayList<BilledDetails>();
        ObjectOutputStream oos=null;
        ObjectInputStream ois=null;
        if(file3.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file3));
            dlist = (ArrayList<BilledDetails>)ois.readObject();
            ois.close();
        }
        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"=============== "+"\u001B[33m"+"KRISHNA SUPERMARKET "+"\u001B[35m"+"===============\n\n");
        System.out.println("\n\t\t+================================================+");
        System.out.printf("\t\t|%-15s %-15s %-15s |\n","USERNAME","AMOUNT","CASIER");
        System.out.println("\t\t+================================================+");
        for(BilledDetails c:dlist){
            if(id==0 && c.final_rate!=0.0f){
            System.out.printf("\t\t|%-15s %-15.2f %-15s |\n",c.username,c.final_rate,c.casierName);
            System.out.println("\t\t+================================================+");

            }
        }
        System.out.println("\n\n\t\t <--Back(2)                              Continue-->");
        System.out.print("\t\t\t\t\t");
        int n = in.nextInt();
        if(n==2)
            System.out.print("\033\143");
            adminPage();
    }
}

class UserEntryHome{
    Home h = new Home();
    Scanner in = new Scanner(System.in);
    public void userEntryHome() throws IOException, ClassNotFoundException{
        while(true){
            System.out.println("\n\n\n\t\t"+"\u001B[35m"+"=============== "+"\u001B[33m"+"KRISHNA SUPERMARKET "+"\u001B[35m"+"===============\n\n");
            System.out.println("\t\t\t\t"+"\u001B[37m"+"  1. Order ");
            System.out.println("\t\t\t\t  2. View Cart");
            System.out.println("\t\t\t\t  3. Back");
            System.out.println("\n\n\t\t"+"\u001B[35m"+"===================================================\n\n");
            System.out.print("\n\t\t\t  Enter your Choice : ");
            int n1 = in.nextInt();
            switch(n1){
                case 1:
                    System.out.print("\033\143");
                    UserOrder u = new UserOrder();
                    u.userEntry();
                    break;
                case 2:
                    System.out.print("\033\143");
                    ViewCart v = new ViewCart();
                    v.viewCart();
                    break;
                case 3:
                    System.out.print("\033\143");
                    h.home();
                    break;
                default:
                    System.out.print("\033\143");
                    System.out.println("\u001B[31m"+"\t\t\t\tInvalid Input"+"\u001B[0m");
            }
        }
    }
}

class UserOrder{
    int id=0,m=0;
    String username;
    float quantity;
    Scanner in = new Scanner(System.in);
    File file1 = new File("Files/Product/Stock.txt");
    File file2 = new File("Files/User/Cart.txt");
    ArrayList<Product> dlist = new ArrayList<Product>();
    ArrayList<UserCart> user = new ArrayList<UserCart>();
    ObjectOutputStream oos=null;
    ObjectInputStream ois=null;
    ListIterator li = null;
    UserEntryHome ueh = new UserEntryHome();

    public void userEntry() throws IOException, ClassNotFoundException{
        if(file1.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file1));
            dlist = (ArrayList<Product>)ois.readObject();
            ois.close();
        }
        if(file2.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file2));
            user = (ArrayList<UserCart>)ois.readObject();
            ois.close();
        }
        TreeSet<String> trlist = new TreeSet<>();
        for(Product b:dlist){
            trlist.add(b.catagory);
        }
        Iterator<String> itr=trlist.iterator();  
        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"=============== "+"\u001B[33m"+"KRISHNA SUPERMARKET "+"\u001B[35m"+"===============\n\n");
        if(username==null){
            System.out.print("\n\t\t\t Enter Your Name : ");
            username = in.nextLine();
            username.toUpperCase();
        }
        System.out.println("\n\n\t\t\t+======= PRODUCTS =======+");
        int i=1;
        while(itr.hasNext()){  
            System.out.printf("\t\t\t| %-5d %-10s %-20s",i++,itr.next(),"\t |");  
            System.out.println("\n\t\t\t+========================+");
        } 
        int n = trlist.size();
        String arr[] = new String[n];
        arr = trlist.toArray(arr);
        if(m==0){
            do{
                System.out.print("\n\n\n\t\t\t Enter your Choice: ");
                m= in.nextInt();
            }while(m>n);
        }
        if(m<=n){
            String find = new String(arr[m-1]);
            System.out.println("\n\n\n\t\t+===============================================================================+");
            System.out.printf("\t\t|%-15s %-15s %-15s %-15s %-10s \t|\n","ID","NAME","RATE","DISCOUNT","QUANTITY");
            System.out.printf("\t\t|%-15s %-15s %-15s %-15s %-10s \t|\n","","","(in Rs)","(in %)","(in Kgs)");
            System.out.println("\t\t+===============================================================================+");
            Collections.sort(dlist, Product.ProductId);
            for(Product a:dlist){
                if(find.equalsIgnoreCase(a.catagory)){
                    System.out.printf("\t\t| %-15d %-15s %-15.2f %-15.2f %-10.2f \t|\n",a.id,a.product_name,a.rate,a.discount,a.quantity);
                    System.out.println("\t\t+===============================================================================+");
                }
            }
            System.out.println("\n\n\t\t\t <--Back(2)                                   Order(1)-->");
            System.out.print("\t\t\t\t\t\t\t");
            int x = in.nextInt();
            switch(x){
                case 1:
                    oos = new ObjectOutputStream(new FileOutputStream(file1));
                    oos.writeObject(dlist);
                    oos.close();
                    oos = new ObjectOutputStream(new FileOutputStream(file2));
                    oos.writeObject(user);
                    oos.close();
                    System.out.println("\n\n\t\t+===============================================================================+");
                    addcart(find);
                    break;
                case 2:
                    oos = new ObjectOutputStream(new FileOutputStream(file1));
                    oos.writeObject(dlist);
                    oos.close();
                    oos = new ObjectOutputStream(new FileOutputStream(file2));
                    oos.writeObject(user);
                    oos.close();
                    System.out.println("\n\n\t\t\t Product are added in cart\n\n\t\t\t\t");
                    System.out.print("\033\143");
                    ueh.userEntryHome();
                default:
                    System.out.print("\033\143");
                    ueh.userEntryHome();
            }
        }
        else{
            System.out.print("\033\143");
            System.out.println("\u001B[31m"+"\t\t\t\tInvalid Input"+"\u001B[0m");
            userEntry();
        }
    }
    
    public void addcart(String find) throws IOException, ClassNotFoundException{
        String s = new String();
        if(file1.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file1));
            dlist = (ArrayList<Product>)ois.readObject();
            ois.close();
        }
        if(file2.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file2));
            user = (ArrayList<UserCart>)ois.readObject();
            ois.close();
        }
        do{
            int pid=0,count=0;
            System.out.print("\n\n\t\t\t Product Id       : ");
            id = in.nextInt();
            for(Product p:dlist){
                if(id==p.id && find.equals(p.catagory)){
                    pid++;
                    System.out.print("\n\t\t\t Quantity in kgs  : ");
                    quantity = in.nextFloat();
                    for(UserCart ucs:user){
                        if(id == ucs.id && username.equalsIgnoreCase(ucs.username)){
                            count++;
                            quantity += ucs.quantity;
                            p.quantity -= quantity;
                            li = user.listIterator();
                            while(li.hasNext()){
                                UserCart pq = (UserCart)li.next();
                                if(id==pq.id && username.equalsIgnoreCase(ucs.username)){
                                    li.remove();
                                }
                            }
                            user.add(new UserCart(username.toUpperCase() , id, quantity));
                            in.nextLine();
                            // System.out.println(user);
                            System.out.print("\n\n\t\t\t\t If want to continue (Y/N): ");
                            s = in.nextLine();
                            if(!s.equals("Y") || !s.equals("y")){
                                System.out.println("\t\t+===============================================================================+");
                                break;
                            }
                        }
                    }
                    if(quantity<=p.quantity && count==0){
                        p.quantity -= quantity;
                        user.add(new UserCart(username.toUpperCase() , id, quantity));
                        in.nextLine();
                        // System.out.println(user);
                        System.out.print("\n\n\t\t\t\t If want to continue (Y/N): ");
                        s = in.nextLine();
                        if(!s.equals("Y") || !s.equals("y")){
                            System.out.println("\t\t+===============================================================================+");
                            break;
                        }
                    }
                    else if(quantity>=p.quantity){
                        System.out.println("Out of Stock");
                        addcart(find);
                    }
                }
            }
            if(pid==0){
                System.out.print("\033\143");
                System.out.println("\u001B[31m"+"\t\t\t\tInvalid Input"+"\u001B[0m");
                userEntry();
            }
        }while(s.equals("Y") || s.equals("y"));
        System.out.println("\n\n\t\t\t <--Back(3)         Confirm(2)               Order(1)-->");
        System.out.print("\t\t\t\t\t\t\t");
        int x = in.nextInt();
        switch(x){
            case 1:
                System.out.print("\033\143");
                m=0;
                oos = new ObjectOutputStream(new FileOutputStream(file1));
                oos.writeObject(dlist);
                oos.close();
                oos = new ObjectOutputStream(new FileOutputStream(file2));
                oos.writeObject(user);
                oos.close();
                userEntry();
                in.nextLine();
                break;
            case 2:
                oos = new ObjectOutputStream(new FileOutputStream(file1));
                oos.writeObject(dlist);
                oos.close();
                oos = new ObjectOutputStream(new FileOutputStream(file2));
                oos.writeObject(user);
                oos.close();
                System.out.println("\n\n\t\t\t Product are added in cart\n\n\t\t\t\t");
                int y = in.nextInt();
                System.out.print("\033\143");
                ueh.userEntryHome();
                break;
            default:
                System.out.print("\033\143");
                ueh.userEntryHome();
        }
        
    }

}

class ViewCart{
    int id=0,m=0;
    String username;
    float quantity;
    Scanner in = new Scanner(System.in);
    File file2 = new File("Files/User/Cart.txt");
    ArrayList<UserCart> user = new ArrayList<UserCart>();
    ObjectOutputStream oos=null;
    ObjectInputStream ois=null;

    public void viewCart() throws IOException, ClassNotFoundException{
        int c=0;
        if(file2.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file2));
            user = (ArrayList<UserCart>)ois.readObject();
            ois.close();
        }
        Collections.sort(user, UserCart.ProductId);
        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"=============== "+"\u001B[33m"+"KRISHNA SUPERMARKET "+"\u001B[35m"+"===============\n\n");
        System.out.print("\n\t\t\t  Enter Your Name : ");
        username = in.nextLine();
        System.out.println("\n\n\n\t\t\t+=========+==============+");
        System.out.printf("\t\t\t|  %-6s | %-12s |\n","ID","QUANTITY");
        System.out.println("\t\t\t+=========+==============+");
        for(UserCart uc:user){
            if(username.equalsIgnoreCase(uc.username)){
                c++;
                System.out.printf("\t\t\t|  %-6d | %-12.2f |\n",uc.id,uc.quantity);
                System.out.println("\t\t\t+=========+==============+");
            }
        }
        if(c==0){
            System.out.print  ("\t\t\t|       No records       |");
            System.out.println("\n\t\t\t+=========+==============+");
        }
        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================================================\n\n");
        System.out.println("\n\n\t\t <--Back(2)                              Continue-->");
        System.out.print("\t\t\t\t\t");
        int n = in.nextInt();
        if(n==1){
            System.out.print("\033\143");
            in.nextLine();
            viewCart();
        }
        else{
            System.out.print("\033\143");
            UserEntryHome ueh = new UserEntryHome();
            ueh.userEntryHome();    
        }
    }
}

class CasierHome{
    Home h = new Home();
    Scanner in = new Scanner(System.in);
    public void casierHome(String xyz) throws IOException, ClassNotFoundException{
        while(true){
            System.out.println("\n\n\n\t\t"+"\u001B[35m"+"=============== "+"\u001B[33m"+"KRISHNA SUPERMARKET "+"\u001B[35m"+"===============\n\n");
            System.out.println("\t\t\t\t"+"\u001B[37m"+"  1. Bill ");
            System.out.println("\t\t\t\t  2. Waiting");
            System.out.println("\t\t\t\t  3. Back");
            System.out.println("\n\n\t\t"+"\u001B[35m"+"===================================================\n\n");
            System.out.print("\n\t\t\t  Enter your Choice : ");
            int n1 = in.nextInt();
            switch(n1){
                case 1:
                    System.out.print("\033\143");
                    Bill b = new Bill();
                    b.bill(xyz);
                    break;
                case 2:
                    System.out.print("\033\143");
                    Waiting w = new Waiting();
                    w.waiting(xyz);
                    break;
                case 3:
                    System.out.print("\033\143");
                    h.home();
                    break;
                default:
                    System.out.print("\033\143");
                    System.out.println("\u001B[31m"+"\t\t\t\tInvalid Input"+"\u001B[0m");
            }
        }
    }
}

class Bill{
    int id=0,m=0;
    String username;
    float quantity;
    Scanner in = new Scanner(System.in);
    File file1 = new File("Files/Product/Stock.txt");
    File file2 = new File("Files/User/Cart.txt");
    File file3 = new File("Files/Product/BilledDetails.txt");
    ArrayList<Product> dlist = new ArrayList<Product>();
    ArrayList<UserCart> user = new ArrayList<UserCart>();
    ArrayList<BilledDetails> billedlist = new ArrayList<BilledDetails>();
    ObjectOutputStream oos=null;
    ObjectInputStream ois=null;
    ListIterator li = null;
    public void bill(String xyz) throws IOException, ClassNotFoundException{
        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"=============== "+"\u001B[33m"+"KRISHNA SUPERMARKET "+"\u001B[35m"+"===============\n\n");
        System.out.print("\n\t\t\t  Enter Your Name : ");
        username = in.nextLine();
        if(file1.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file1));
            dlist = (ArrayList<Product>)ois.readObject();
            ois.close();
        }
        if(file2.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file2));
            user = (ArrayList<UserCart>)ois.readObject();
            ois.close();
        }
        if(file3.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file3));
            billedlist = (ArrayList<BilledDetails>)ois.readObject();
            ois.close();
        }
        System.out.println("\n\t\t+===============================================================================================+");
        System.out.printf("\t\t|%-15s %-15s %-15s %-15s %-15s %-10s \t|\n","ID","NAME","MRP","DISCOUNT","QUANTITY","RATE");
        System.out.printf("\t\t|%-15s %-15s %-15s %-15s %-15s %-10s \t|\n","","","(in Rs)","(in %)","(in Kgs)","(in Rs)");
        System.out.println("\t\t+===============================================================================================+");
        float final_rate=0;
        for(UserCart uc:user){
            if(username.equalsIgnoreCase(uc.username)){
                for(Product p:dlist){
                    if(uc.id==p.id){
                        // id name rate discount quantity dis.rate 
                        float dis_rate;
                        dis_rate = (p.rate-((p.rate*p.discount)/100))*uc.quantity;
                        final_rate += dis_rate;
                        System.out.printf("\t\t|%-15d %-15s %-15.2f %-15.2f %-15.2f %-10.2f \t|\n",uc.id,p.product_name,p.rate,p.discount,uc.quantity,dis_rate);
                        System.out.println("\t\t+===============================================================================================+");
                        billedlist.add(new BilledDetails(uc.id, p.product_name, username, p.rate, p.discount, uc.quantity, dis_rate, 0.0f, ""));                    }
                }
            }
        }
        li = user.listIterator();
        while(li.hasNext()){
            UserCart p1 = (UserCart)li.next();
            if(username.equalsIgnoreCase(p1.username)){
                li.remove();
            }
        }
        billedlist.add(new BilledDetails(0, " ", username, 0.0f, 0.0f, 0.0f, 0.0f, final_rate, xyz));
        System.out.printf("\t\t\t\t\t\t\t\t\t\t\t| %-5s %-13.2f|\n","Total : ",final_rate);
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t+=======================+");
        System.out.println("\n\n\t\t\t\t <--Back(2)                                      Confirm(1)-->");
        System.out.print("\t\t\t\t\t\t\t\t");
        // System.out.println(billedlist);
        int n = in.nextInt();
        if(n==1){
            oos = new ObjectOutputStream(new FileOutputStream(file3));
            oos.writeObject(billedlist);
            oos.close();
            oos = new ObjectOutputStream(new FileOutputStream(file2));
            oos.writeObject(user);
            oos.close();
            System.out.print("\033\143");
            CasierHome h = new CasierHome();
            h.casierHome(xyz);
        }
        else{
            System.out.print("\033\143");
            CasierHome h = new CasierHome();
            h.casierHome(xyz);
        }

    }
}

class Waiting{
    int id=0,m=0;
    String username;
    float quantity;
    Scanner in = new Scanner(System.in);
    File file1 = new File("Files/Product/Stock.txt");
    File file2 = new File("Files/User/Cart.txt");
    ArrayList<Product> dlist = new ArrayList<Product>();
    ArrayList<UserCart> user = new ArrayList<UserCart>();
    ObjectOutputStream oos=null;
    ObjectInputStream ois=null;
    public void waiting(String xyz)throws IOException, ClassNotFoundException{
        if(file2.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file2));
            user = (ArrayList<UserCart>)ois.readObject();
            ois.close();
        }
        Collections.sort(user,UserCart.UserNamesort);
        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"=============== "+"\u001B[33m"+"KRISHNA SUPERMARKET "+"\u001B[35m"+"===============\n");
        System.out.println("\t\t\t    WAITING FOR BILLING\n");
        System.out.println("\t\t"+"\u001B[35m"+"===================================================\n");
        for(UserCart uc:user){
            // System.out.println(uc.username+"  "+username+" \n");
            if(username==null || (!username.equalsIgnoreCase(uc.username))){
                System.out.println("\n\n\t\t\t+========================+");
                username = uc.username;
                System.out.printf("\t\t\t|\t%-10s\t |",uc.username);
                System.out.println("\n\t\t\t+==========+=============+");
            }
            System.out.printf("\t\t\t| %-8d | %-10.2f  |\n",uc.id,uc.quantity);
            System.out.println("\t\t\t+==========+=============+");
        }
        System.out.println("\n\n\t\t"+"\u001B[35m"+"===================================================\n");
        System.out.println("\n\n\t\t <--Back(2)                              Continue-->");
        System.out.print("\t\t\t\t\t");
        int n = in.nextInt();
        if(n==2){
            System.out.print("\033\143");
            CasierHome h = new CasierHome();
            h.casierHome(xyz);
        }

    }
}

public class SuperMarket{
    public static void main(String arg[]) {
        System.out.print("\033\143");
        Welcome w = new Welcome();
        w.welcome();
    }  
}
