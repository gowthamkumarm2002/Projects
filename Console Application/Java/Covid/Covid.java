package covid;

import java.util.*;
import java.io.*;
import covid.*;

class HospitalDetails implements Serializable{
    String name,city,district,state,country,bed,doctor,username,password;
    HospitalDetails(String name,String city,String district,String state,String country,String bed,String doctor,String username,String password){
        this.name = name;
        this.city = city;
        this.district = district;
        this.state = state;
        this.country =country;
        this.bed = bed;
        this.doctor = doctor;
        this.username = username;
        this.password = password;
    }
    public String toString(){
        return name+" "+city+" "+district+" "+state+" "+country+" "+bed+" "+doctor+" "+username+" "+password+" ";
    }
}

class PatientDetails implements Serializable{
    String name,city,district,state,country,status,age,gender,h_name;
    PatientDetails(String name,String city,String district,String state,String country,String status,String age,String gender,String h_name){
        this.name = name;
        this.city = city;
        this.district = district;
        this.state = state;
        this.country =country;
        this.status = status;
        this.age = age;
        this.gender = gender;
        this.h_name = h_name;
    }
    public String toString(){
        return name+" "+city+" "+district+" "+state+" "+country+" "+status+" "+age+" "+gender+" "+h_name+" ";
    }
}

class PatientTest implements Serializable{
    String name,city,district,state,country,age,gender,temp,symptoms;
    PatientTest(String name,String city,String district,String state,String country,String age,String gender,String temp,String symptoms){
        this.name = name;
        this.city = city;
        this.district = district;
        this.state = state;
        this.country =country;
        this.age = age;
        this.gender = gender;
        this.temp = temp;
        this.symptoms = symptoms;
    }
    public String toString(){
        return name+" "+city+" "+district+" "+state+" "+country+" "+age+" "+gender+" "+temp+" "+symptoms+" ";
    }
}



class Welcome{
    public void welcome()throws InterruptedException,IOException,ClassNotFoundException{
            System.out.println("\u001B[36m"+"\n\n\n\t\t\t+-----------------------------------------------------------+");
            System.out.println("\u001B[36m"+"\t\t\t|\t                                                    |");
            System.out.println("\u001B[36m"+"\t\t\t|\t=============================================       |");
            System.out.println("\u001B[36m"+"\t\t\t|\t================ "+"\u001B[32m"+" WELCOME TO "+"\u001B[36m"+" ===============       |");
            System.out.println("\u001B[36m"+"\t\t\t|\t================= "+"\u001B[32m"+"  COVID  "+"\u001B[36m"+" =================       |");
            System.out.println("\u001B[36m"+"\t\t\t|\t================= "+"\u001B[32m"+" ANALYSER"+"\u001B[36m"+" =================       |");
            System.out.println("\u001B[36m"+"\t\t\t|\t=============================================       |");
            System.out.println("\u001B[36m"+"\t\t\t|\t                                                    |");
            System.out.println("\u001B[36m"+"\t\t\t+-----------------------------------------------------------+"+"\u001B[0m");
            Thread.sleep(2000);
            System.out.print("\033\143");
            Home h = new Home();
            h.home();
    }
}

class Home{
    Scanner in = new Scanner(System.in);

    public void home() throws IOException, ClassNotFoundException,InterruptedException{
        while(true){
            System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" COVID ANALYSER "+"\u001B[35m"+"=====================\n\n");
            System.out.println("\t\t\t\t"+"\u001B[37m"+"  1. Admin ");
            System.out.println("\t\t\t\t  2. Hospital ");
            System.out.println("\t\t\t\t  3. Covid Test ");
            System.out.println("\t\t\t\t  4. Vaccination");
            System.out.println("\t\t\t\t  5. Graph");
            System.out.println("\t\t\t\t  6. Exit");
            System.out.println("\n\n\t\t"+"\u001B[35m"+"===========================================================\n\n");
            System.out.print("\n\t\t\t  Enter your Choice : ");
            int num = in.nextInt();
            System.out.print("\033\143");
            switch(num){
                case 1:
                    System.out.print("\033\143");
                    new AdminHome().adminLogin();
                    break;
                case 2:
                    System.out.print("\033\143");
                    new Hospital().hospitalLogin();
                    break;
                case 3:
                    System.out.print("\033\143");
                    new CovidTest().covidTestHome();
                    break;
                case 4:
                    System.out.print("\033\143");
                    new Vacination().vaccination();
                    break;
                case 5:
                    System.out.print("\033\143");
                    new Graph().graph();
                    System.exit(0);
                case 6:
                    System.out.print("\033\143");
                    System.exit(0);
                default:
                    System.out.print("\033\143");
                    System.out.println("\u001B[31m"+"\t\t\t\tInvalid Input"+"\u001B[0m");
            }
        }
    }

}

class AdminHome{
    char password[];
    Console console;
    Scanner in = new Scanner(System.in);

    File file1 = new File("Files/Hospital/HospitalDetails.txt");
    File file2 = new File("Files/Patient/Vaccination.txt");
    File file3 = new File("Files/Patient/PatientDetails.txt");


    ObjectOutputStream oos=null;
    ObjectInputStream ois=null;
    ListIterator li = null;

    String name,city,district,state,country,bed,doctor;


    public boolean validateUser(String text) {
        return text.matches("^\\w{8,14}$");
    }
    public boolean validatePassword(String text){
        return text.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
    }

    public void adminLogin()throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        String username = new String();
        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" COVID ANALYSER "+"\u001B[35m"+"=====================\n\n");
        System.out.println("\t\t                     LOGIN  \n\n  ");
        System.out.print("\t\t\t UserName    : ");
        username = in.nextLine();
        if((console = System.console())!=null){
            System.out.print("\n\n\t\t\t Password    : ");
            password = console.readPassword();
        }
        String pass = new String(password);
        System.out.println("\n\n\t\t"+"\u001B[35m"+"===========================================================\n\n");
        if(username.equals("Admin123") && pass.equals("Admin@123")){
            System.out.println("\n\n\t\t\t Login Successfull");
            Thread.sleep(2000);
            System.out.print("\033\143");   
            adminHome();
        }
        else{
            System.out.print("\033\143");   
            System.out.println("\u001B[31m"+"\t\t\t\tInvalid Username or Password"+"\u001B[0m");
            adminLogin();
        }
        
    }
    
    public void adminHome()throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        System.out.print("\033\143");
        while(true){
            System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" COVID ANALYSER "+"\u001B[35m"+"=====================\n\n");
            System.out.println("\t\t\t\t"+"\u001B[37m"+"  1. Add Hospital ");
            System.out.println("\t\t\t\t  2. View Hospital");
            System.out.println("\t\t\t\t  3. View Patient");
            System.out.println("\t\t\t\t  4. Vaccinated Person");
            System.out.println("\t\t\t\t  5. Logout");
            System.out.println("\n\n\t\t"+"\u001B[35m"+"===========================================================\n\n");
            System.out.print("\n\t\t\t  Enter your Choice : ");
            int n1 = in.nextInt();
            switch(n1){
                case 1:
                    System.out.print("\033\143");
                    addHospital();
                    break;
                case 2:
                    System.out.print("\033\143");
                    viewHospital();
                    break;
                case 3:
                    System.out.print("\033\143");
                    viewPatients();
                    break;
                case 4:
                    System.out.print("\033\143");
                    viewVaccination();
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




    public void addHospital()throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        LinkedList<HospitalDetails> list = new LinkedList<HospitalDetails>();
        if(file1.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file1));
            list = (LinkedList<HospitalDetails>)ois.readObject();
            ois.close();
        }  
        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" COVID ANALYSER "+"\u001B[35m"+"=====================\n\n");
        System.out.println("\u001B[47m"+"\u001B[35m"+"\t\t\t\t HOSPITAL DETAILS "+"\u001B[0m");
        in.nextLine();
        System.out.print("\u001B[37m"+"\n\n\t\t\t Name          : ");
        name = in.nextLine();
        System.out.print("\u001B[37m"+"\n\n\t\t\t City          : ");
        city = in.nextLine();
        System.out.print("\u001B[37m"+"\n\n\t\t\t District      : ");
        district = in.nextLine();
        System.out.print("\u001B[37m"+"\n\n\t\t\t State         : ");
        state = in.nextLine();
        System.out.print("\u001B[37m"+"\n\n\t\t\t Country       : ");
        country = in.nextLine();
        System.out.print("\u001B[37m"+"\n\n\t\t\t No.of Beds    : ");
        bed = in.nextLine();
        System.out.print("\u001B[37m"+"\n\n\t\t\t No.of Doctors : ");
        doctor = in.nextLine();
        addUsername();
    }
 
    public void addUsername()throws IOException,ClassNotFoundException,FileNotFoundException,InterruptedException{
        int c=0;
        LinkedList<HospitalDetails> list = new LinkedList<HospitalDetails>();
        System.out.print("\u001B[37m"+"\n\n\t\t\t UserName      : ");
        String username = in.nextLine();
        if((console = System.console())!=null){
        System.out.print("\u001B[37m"+"\n\n\t\t\t Password      : ");
            password = console.readPassword();
        }
        String pass = new String(password);
        if(file1.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file1));
            list = (LinkedList<HospitalDetails>)ois.readObject();
            ois.close();
        }
        li = list.listIterator();
        while(li.hasNext()){
            HospitalDetails d = (HospitalDetails)li.next();
            if(username.equals(d.username)){
                c=1;
            }
        }
        if(c==0){
            if(!validateUser(username) || !validatePassword(pass.toString())){
                System.out.print("\033\143");
                System.out.println("\u001B[31m"+"\n\t\t\t Invaild Format of Username or Password");
                System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" SWIGGY "+"\u001B[35m"+"=====================\n\n");
                System.out.println("\u001B[47m"+"\u001B[35m"+"\t\t\t\t DETAILS "+"\u001B[0m");
                addUsername();
            }
            else{
                list.add(new HospitalDetails(name.toUpperCase(), city.toUpperCase(), district.toUpperCase(), state.toUpperCase(), country.toUpperCase(), bed.toUpperCase(), doctor.toUpperCase() ,username,pass));
                oos = new ObjectOutputStream(new FileOutputStream(file1));
                oos.writeObject(list);
                oos.close();
                System.out.println("\n\n\t\t"+"\u001B[35m"+"===========================================================\n\n");
                System.out.println("\u001B[32m"+"\t\t\t\tHospital Added Successfully");
                System.out.println("\n\n\t\t"+"\u001B[35m"+"===========================================================\n\n");
                System.out.println("\u001B[36m"+"\n\n\t\t <--Back(2)                                   Add(1)-->");
                int x = in.nextInt();
                if(x==1){
                    System.out.print("\033\143");
                    addHospital();
                }
                else{
                    System.out.print("\033\143");
                    adminHome();
                }
                
            }
        }
        else{
            System.out.print("\033\143");
            System.out.println("\u001B[31m"+"\n\t\t\t Username Already Exists....");
            addUsername();
        }        
    }
    
    public void viewHospital()throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        int c=0;
        in.nextLine();
        LinkedList<HospitalDetails> list1 = new LinkedList<HospitalDetails>();

        if(file1.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file1));
            list1 = (LinkedList<HospitalDetails>)ois.readObject();
            ois.close();
        }  
        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" COVID ANALYSER "+"\u001B[35m"+"=====================\n\n");
        System.out.println("\u001B[35m"+"\n\t\t+================+=================+=================+=================+=================+=================+=================+");
        System.out.printf("\t\t|%-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |\n","NAME","CITY","DISTRICT","STATE","COUNTRY","BEDS","DOCTERS");
        System.out.println("\t\t+================+=================+=================+=================+=================+=================+=================+");
        for(HospitalDetails h:list1){
            c=1;
            System.out.printf("\t\t|%-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |\n",h.name,h.city,h.district,h.state,h.country,h.bed,h.doctor);
            System.out.println("\t\t+================+=================+=================+=================+=================+=================+=================+");
        }
        if(c==0){
            System.out.println("\t\t"+"\u001B[35m"+"|\t\t\t\t\t\t  No records    \t\t\t\t\t\t\t\t     |");
            System.out.println("\t\t+================+=================+=================+=================+=================+=================+");
        }
        System.out.println("\n\n\t\t"+"\u001B[35m"+"===========================================================\n\n");
        System.out.println("\u001B[36m"+"\n\n\t\t <--Back(2)                                  Continue-->");
        in.nextLine();
        System.out.print("\033\143");
        adminHome();
    }

    public void viewPatients()throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        int c=0;
        in.nextLine();
        LinkedList<PatientDetails> list = new LinkedList<PatientDetails>();
        if(file3.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file3));
            list = (LinkedList<PatientDetails>)ois.readObject();
            ois.close();
        }  
        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" COVID ANALYSER "+"\u001B[35m"+"=====================\n\n");
        System.out.println("\u001B[35m"+"\n\t\t+================+============+============+=================+=================+");
        System.out.printf("\t\t|%-15s | %-10s | %-10s | %-15s | %-15s |\n","NAME","AGE","GENDER","STATUS","HOSPITAL NAME");
        System.out.println("\t\t+================+============+============+=================+=================+");
        for(PatientDetails h:list){
            String status;
            if(h.status.equals("0")){
                status = "TREATMENT";
            }
            else if(h.status.equals("1")){
                status = "DISCHARGED";
            }
            else{
                status = "DEATH";
            }
            c=1;
            System.out.printf("\t\t|%-15s | %-10s | %-10s | %-15s | %-15s |\n",h.name,h.age,h.gender,status,h.h_name);
            System.out.println("\t\t+================+============+============+=================+=================+");
            
        }    
        if(c==0){
            System.out.println("\t\t"+"\u001B[35m"+"|\t\t\t\t\t\t  No records    \t\t\t\t\t\t\t\t     |");
            System.out.println("\t\t+================+============+============+=================+=================+");
        }
        System.out.println("\n\n\t\t"+"\u001B[35m"+"===========================================================\n\n");
        System.out.println("\u001B[36m"+"\n\n\t\t <--Back(2)                                  Continue-->");
        in.nextLine();
        System.out.print("\033\143");
        adminHome();
    }


    public void viewVaccination()throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        int c=0;
        in.nextLine();
        LinkedList<PatientTest> list = new LinkedList<PatientTest>();
        if(file2.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file2));
            list = (LinkedList<PatientTest>)ois.readObject();
            ois.close();
        }  
        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" COVID ANALYSER "+"\u001B[35m"+"=====================\n\n");
        System.out.println("\u001B[35m"+"\n\t\t+================+============+============+=================+=================+=================+=================+=================+");
        System.out.printf("\t\t|%-15s | %-10s | %-10s | %-15s | %-15s | %-15s | %-15s | %-15s |\n","NAME","AGE","GENDER","CITY","DISTRICT","STATE","COUNTRY","VACCINE");
        System.out.println("\t\t+================+============+============+=================+=================+=================+=================+=================+");
        for(PatientTest h:list){
            c=1;
            System.out.printf("\t\t|%-15s | %-10s | %-10s | %-15s | %-15s | %-15s | %-15s | %-15s |\n",h.name,h.age,h.gender,h.city,h.district,h.state,h.country,h.temp);
            System.out.println("\t\t+================+============+============+=================+=================+=================+=================+=================+");
        }    
        if(c==0){
            System.out.println("\t\t"+"\u001B[35m"+"|\t\t\t\t\t\t  No records    \t\t\t\t\t\t\t\t     |");
            System.out.println("\t\t+================+============+============+=================+=================+=================+=================+=================+");
        }
        System.out.println("\n\n\t\t"+"\u001B[35m"+"===========================================================\n\n");
        System.out.println("\u001B[36m"+"\n\n\t\t <--Back(2)                                  Continue-->");
        in.nextLine();
        System.out.print("\033\143");
        adminHome();
    }


}

class Hospital{
    char password[];
    Console console;
    Scanner in = new Scanner(System.in);

    File file1 = new File("Files/Hospital/HospitalDetails.txt");
    File file2 = new File("Files/Patient/PatientDetails.txt");

    ObjectOutputStream oos=null;
    ObjectInputStream ois=null;
    ListIterator li = null;

    public void hospitalLogin()throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        int c=0;
        LinkedList<HospitalDetails> list = new LinkedList<HospitalDetails>();
        if(file1.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file1));
            list = (LinkedList<HospitalDetails>)ois.readObject();
            ois.close();
        }
        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" COVID ANALYSER "+"\u001B[35m"+"=====================\n\n");
        System.out.println("\t\t                     LOGIN  \n  ");
        System.out.print("\u001B[37m"+"\n\n\t\t\t UserName      : ");
        String username = in.nextLine();
        if((console = System.console())!=null){
        System.out.print("\u001B[37m"+"\n\n\t\t\t Password      : ");
            password = console.readPassword();
        }
        String pass = new String(password);
        
        for(HospitalDetails d:list){
            if(username.equals(d.username) && pass.equals(d.password)){
                System.out.println("\n\n\t\t"+"\u001B[35m"+"===================================================\n\n");
                System.out.println("\n\n\t\t\t Login Successfull");
                Thread.sleep(1000);
                c=1;
                System.out.print("\033\143");
                hospitalHome(username);
            }
        }
        if(c==0){
            System.out.print("\033\143");
            System.out.println("\u001B[31m"+"\t\t\t\tInvalid Input"+"\u001B[0m");
            hospitalLogin();
        }
    }   

    public void hospitalHome(String username)throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        System.out.print("\033\143");
        while(true){
            System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" COVID ANALYSER "+"\u001B[35m"+"=====================\n\n");
            System.out.println("\t\t\t\t"+"\u001B[37m"+"  1. Add Patients ");
            System.out.println("\t\t\t\t  2. View Patients");
            System.out.println("\t\t\t\t  3. Update Patient");
            System.out.println("\t\t\t\t  4. Logout");
            System.out.println("\n\n\t\t"+"\u001B[35m"+"===========================================================\n\n");
            System.out.print("\n\t\t\t  Enter your Choice : ");
            int n1 = in.nextInt();
            switch(n1){
                case 1:
                    System.out.print("\033\143");
                    addPatients(username);
                    break;
                case 2:
                    System.out.print("\033\143");
                    viewPatients(username);
                    break;
                case 3:
                    System.out.print("\033\143");
                    updatePatients(username);
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

    public void addPatients(String username)throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        String name,city,district,state,country,status,age,gender;
        LinkedList<PatientDetails> list = new LinkedList<PatientDetails>();
        if(file2.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file2));
            list = (LinkedList<PatientDetails>)ois.readObject();
            ois.close();
        }  
        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" COVID ANALYSER "+"\u001B[35m"+"=====================\n\n");
        System.out.println("\u001B[47m"+"\u001B[35m"+"\t\t\t\t HOSPITAL DETAILS "+"\u001B[0m");
        in.nextLine();
        System.out.print("\u001B[37m"+"\n\n\t\t\t Name          : ");
        name = in.nextLine();
        System.out.print("\u001B[37m"+"\n\n\t\t\t Age           : ");
        age = in.nextLine();
        System.out.print("\u001B[37m"+"\n\n\t\t\t Gender (M/F)  : ");
        gender = in.nextLine();
        System.out.print("\u001B[37m"+"\n\n\t\t\t City          : ");
        city = in.nextLine();
        System.out.print("\u001B[37m"+"\n\n\t\t\t District      : ");
        district = in.nextLine();
        System.out.print("\u001B[37m"+"\n\n\t\t\t State         : ");
        state = in.nextLine();
        System.out.print("\u001B[37m"+"\n\n\t\t\t Country       : ");
        country = in.nextLine();
        list.add(new PatientDetails(name.toUpperCase(), city.toUpperCase(), district.toUpperCase(), state.toUpperCase(), country.toUpperCase(), "0", age, gender.toUpperCase(), username));
        oos = new ObjectOutputStream(new FileOutputStream(file2));
        oos.writeObject(list);
        oos.close();
        System.out.println("\n\n\t\t"+"\u001B[35m"+"===========================================================\n\n");
        System.out.println("\u001B[32m"+"\t\t\t\tPatient Added Successfully");
        System.out.println("\n\n\t\t"+"\u001B[35m"+"===========================================================\n\n");
        System.out.println("\u001B[36m"+"\n\n\t\t <--Back(2)                                   Add(1)-->");
        int x = in.nextInt();
        if(x==1){
            System.out.print("\033\143");
            addPatients(username);
        }
        else{
            System.out.print("\033\143");
            hospitalHome(username);
        }
    }
 
    public void viewPatients(String username)throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        int c=0;
        in.nextLine();
        LinkedList<PatientDetails> list = new LinkedList<PatientDetails>();
        if(file2.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file2));
            list = (LinkedList<PatientDetails>)ois.readObject();
            ois.close();
        }  
        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" COVID ANALYSER "+"\u001B[35m"+"=====================\n\n");
        System.out.println("\u001B[35m"+"\n\t\t+================+============+============+=================+=================+=================+=================+=================+");
        System.out.printf("\t\t|%-15s | %-10s | %-10s | %-15s | %-15s | %-15s | %-15s | %-15s |\n","NAME","AGE","GENDER","CITY","DISTRICT","STATE","COUNTRY","STATUS");
        System.out.println("\t\t+================+============+============+=================+=================+=================+=================+=================+");
        for(PatientDetails h:list){
            String status;
            if(username.equalsIgnoreCase(h.h_name)){
                if(h.status.equals("0")){
                    status = "TREATMENT";
                }
                else if(h.status.equals("1")){
                    status = "DISCHARGED";
                }
                else{
                    status = "DEATH";
                }
                c=1;
                System.out.printf("\t\t|%-15s | %-10s | %-10s | %-15s | %-15s | %-15s | %-15s | %-15s |\n",h.name,h.age,h.gender,h.city,h.district,h.state,h.country,status);
                System.out.println("\t\t+================+============+============+=================+=================+=================+=================+=================+");
            }
        }    
        if(c==0){
            System.out.println("\t\t"+"\u001B[35m"+"|\t\t\t\t\t\t  No records    \t\t\t\t\t\t\t\t     |");
            System.out.println("\t\t+================+============+============+=================+=================+=================+=================+=================+");
        }
        System.out.println("\n\n\t\t"+"\u001B[35m"+"===========================================================\n\n");
        System.out.println("\u001B[36m"+"\n\n\t\t <--Back(2)                                  Continue-->");
        in.nextLine();
        System.out.print("\033\143");
        hospitalHome(username);
    }

    public void updatePatients(String username)throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        int c=0;
        in.nextLine();
        LinkedList<PatientDetails> list = new LinkedList<PatientDetails>();
        if(file2.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file2));
            list = (LinkedList<PatientDetails>)ois.readObject();
            ois.close();
        }  
        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" COVID ANALYSER "+"\u001B[35m"+"=====================\n\n");
        String name = new String();
        System.out.print("\n\n\t\t\t Patient Name    : ");
        name = in.nextLine();
        System.out.println("\u001B[35m"+"\n\t\t+================+============+============+=================+=================+=================+=================+=================+");
        System.out.printf("\t\t|%-15s | %-10s | %-10s | %-15s | %-15s | %-15s | %-15s | %-15s |\n","NAME","AGE","GENDER","CITY","DISTRICT","STATE","COUNTRY","STATUS");
        System.out.println("\t\t+================+============+============+=================+=================+=================+=================+=================+");
        for(PatientDetails h:list){
            String status;
            if(username.equalsIgnoreCase(h.h_name) && name.equalsIgnoreCase(h.name)){
                if(h.status.equals("0")){
                    status = "TREATMENT";
                }
                else if(h.status.equals("1")){
                    status = "DISCHARGED";
                }
                else{
                    status = "DEATH";
                }
                c=1;
                System.out.printf("\t\t|%-15s | %-10s | %-10s | %-15s | %-15s | %-15s | %-15s | %-15s |\n",h.name,h.age,h.gender,h.city,h.district,h.state,h.country,status);
                System.out.println("\t\t+================+============+============+=================+=================+=================+=================+=================+");
                if(!h.status.equals("2")){
                    System.out.print("\n\n\t\tIf you want update Status (Y/N)    : ");
                    String s = in.next();
                    if(s.equals("Y") || s.equals("y")){
                        in.nextLine();
                        System.out.print("\u001B[35m"+"\n\n\t\t\t Status (0/1/2) : ");
                        h.status = in.nextLine();
                    }
                    System.out.println("\n\n\t\t"+"\u001B[35m"+"===========================================================\n\n");
                    System.out.println("\u001B[32m"+"\t\t\t\tPatient Update Successfully");
                    oos = new ObjectOutputStream(new FileOutputStream(file2));
                    oos.writeObject(list);
                    oos.close();
                }
            }
        }    
        if(c==0){
            System.out.println("\t\t"+"\u001B[35m"+"|\t\t\t\t\t\t  No records    \t\t\t\t\t\t\t\t     |");
            System.out.println("\t\t+================+============+============+=================+=================+=================+=================+=================+");
        }
        System.out.println("\n\n\t\t"+"\u001B[35m"+"===========================================================\n\n");
        System.out.println("\u001B[36m"+"\n\n\t\t <--Back(2)                                  Continue-->");
        in.nextLine();
        System.out.print("\033\143");
        hospitalHome(username);
    }

}

class CovidTest{

    File file1 = new File("Files/Patient/CovidTest.txt");

    ObjectOutputStream oos=null;
    ObjectInputStream ois=null;
    ListIterator li = null;

    Scanner in = new Scanner(System.in);

    public String status(String temp){
        float t = Float.valueOf(temp);
        if(t>105.0f){
            return "POSITIVE";
        }
        else{
            return "NEGATIVE";
        }
    }

    public void covidTestHome()throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        while(true){
            System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" COVID ANALYSER "+"\u001B[35m"+"=====================\n\n");
            System.out.println("\t\t\t\t"+"\u001B[37m"+"  1. Register ");
            System.out.println("\t\t\t\t  2. View Results");
            System.out.println("\t\t\t\t  3. Back");
            System.out.println("\n\n\t\t"+"\u001B[35m"+"===========================================================\n\n");
            System.out.print("\n\t\t\t  Enter your Choice : ");
            int n1 = in.nextInt();
            switch(n1){
                case 1:
                    System.out.print("\033\143");
                    register();
                    break;
                case 2:
                    System.out.print("\033\143");
                    viewResult();
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

    public void register()throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        String name,city,district,state,country,status,age,gender,temp,symptoms;
        LinkedList<PatientTest> list = new LinkedList<PatientTest>();
        if(file1.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file1));
            list = (LinkedList<PatientTest>)ois.readObject();
            ois.close();
        }  
        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" COVID ANALYSER "+"\u001B[35m"+"=====================\n\n");
        System.out.println("\u001B[47m"+"\u001B[35m"+"\t\t\t\t DETAILS "+"\u001B[0m");
        in.nextLine();
        System.out.print("\u001B[37m"+"\n\n\t\t\t Name          : ");
        name = in.nextLine();
        System.out.print("\u001B[37m"+"\n\n\t\t\t Age           : ");
        age = in.nextLine();
        System.out.print("\u001B[37m"+"\n\n\t\t\t Gender (M/F)  : ");
        gender = in.nextLine();
        System.out.print("\u001B[37m"+"\n\n\t\t\t Temp(Celsius) : ");
        temp = in.nextLine();
        System.out.print("\u001B[37m"+"\n\n\t\t\t Symptoms(in %): ");
        symptoms = in.nextLine();
        System.out.print("\u001B[37m"+"\n\n\t\t\t City          : ");
        city = in.nextLine();
        System.out.print("\u001B[37m"+"\n\n\t\t\t District      : ");
        district = in.nextLine();
        System.out.print("\u001B[37m"+"\n\n\t\t\t State         : ");
        state = in.nextLine();
        System.out.print("\u001B[37m"+"\n\n\t\t\t Country       : ");
        country = in.nextLine();
        list.add(new PatientTest(name.toUpperCase(), city.toUpperCase(), district.toUpperCase(), state.toUpperCase(), country.toUpperCase(), age, gender.toUpperCase(),temp,symptoms));
        oos = new ObjectOutputStream(new FileOutputStream(file1));
        oos.writeObject(list);
        oos.close();
        System.out.println("\n\n\t\t"+"\u001B[35m"+"===========================================================\n\n");
        System.out.println("\u001B[32m"+"\t\t\t\tCovid Test register Successfully");
        System.out.println("\n\n\t\t"+"\u001B[35m"+"===========================================================\n\n");
        System.out.println("\u001B[36m"+"\n\n\t\t <--Back(2)                                   Add(1)-->");
        int x = in.nextInt();
        if(x==1){
            System.out.print("\033\143");
            register();
        }
        else{
            System.out.print("\033\143");
            covidTestHome();
        }
    }
    
    public void viewResult()throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        int c=0;
        in.nextLine();
        LinkedList<PatientTest> list = new LinkedList<PatientTest>();
        if(file1.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file1));
            list = (LinkedList<PatientTest>)ois.readObject();
            ois.close();
        }  
        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" COVID ANALYSER "+"\u001B[35m"+"=====================\n\n");
        String name = new String();
        System.out.print("\n\n\t\t\t Patient Name    : ");
        name = in.nextLine();
        for(PatientTest h:list){
            if(name.equalsIgnoreCase(h.name)){
                String s = status(h.temp);
                System.out.println("\u001B[35m"+"\n\t\t\t+=================+=================+");
                System.out.println("\t\t\t|\t\t\t\t    |");
                System.out.println("\t\t\t|\t     COVID TEST   \t    |");
                System.out.println("\t\t\t|\t\t\t\t    |");
                System.out.println("\u001B[35m"+"\t\t\t+=================+=================+");
                System.out.printf("\t\t\t| %-15s | %-15s |","NAME",h.name);
                System.out.println("\u001B[35m"+"\n\t\t\t+=================+=================+");
                System.out.printf("\t\t\t| %-15s | %-15s |","AGE",h.age);
                System.out.println("\u001B[35m"+"\n\t\t\t+=================+=================+");
                System.out.printf("\t\t\t| %-15s | %-15s |","GENDER",h.gender);
                System.out.println("\u001B[35m"+"\n\t\t\t+=================+=================+");
                System.out.printf("\t\t\t| %-15s | %-15s |","CITY",h.city);
                System.out.println("\u001B[35m"+"\n\t\t\t+=================+=================+");
                System.out.printf("\t\t\t| %-15s | %-15s |","DISTRICT",h.district);
                System.out.println("\u001B[35m"+"\n\t\t\t+=================+=================+");
                System.out.printf("\t\t\t| %-15s | %-15s |","STATE",h.state);
                System.out.println("\u001B[35m"+"\n\t\t\t+=================+=================+");
                System.out.printf("\t\t\t| %-15s | %-15s |","COUNTRY",h.country);
                System.out.println("\u001B[35m"+"\n\t\t\t+=================+=================+");
                System.out.printf("\t\t\t| %-15s | %-15s |","RESULT",s);
                System.out.println("\u001B[35m"+"\n\t\t\t+=================+=================+");
                c=1;
               }
        }    
        if(c==0){
            System.out.println("\n\n\t\t+================+=================+=================+");
            System.out.println("\t\t"+"\u001B[35m"+"|\t\t    No records  \t\t     |");
            System.out.println("\t\t+================+=================+=================+");
        }
        System.out.println("\n\n\t\t"+"\u001B[35m"+"===========================================================\n\n");
        System.out.println("\u001B[36m"+"\n\n\t\t <--Back(2)                                  Continue-->");
        in.nextLine();
        System.out.print("\033\143");
        covidTestHome();
    }

}

class Vacination{
    Scanner in = new Scanner(System.in);
    File file1 = new File("Files/Patient/Vaccination.txt");

    ObjectOutputStream oos=null;
    ObjectInputStream ois=null;
    ListIterator li = null;
    public void vaccination()throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        while(true){
            System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" COVID ANALYSER "+"\u001B[35m"+"=====================\n\n");
            System.out.println("\t\t\t\t"+"\u001B[37m"+"  1. Covaxin ");
            System.out.println("\t\t\t\t  2. Covishield ");
            System.out.println("\t\t\t\t  3. Back ");
            System.out.println("\n\n\t\t"+"\u001B[35m"+"===========================================================\n\n");
            System.out.print("\n\t\t\t  Enter your Choice : ");
            int n1 = in.nextInt();
            switch(n1){
                case 1:
                    System.out.print("\033\143");
                    register(n1);
                    break;
                case 2:
                    System.out.print("\033\143");
                    register(n1);
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

    public void register(int n)throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        String name,city,district,state,country,status,age,gender,temp,symptoms;
        LinkedList<PatientTest> list = new LinkedList<PatientTest>();
        if(file1.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file1));
            list = (LinkedList<PatientTest>)ois.readObject();
            ois.close();
        }  
        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" COVID ANALYSER "+"\u001B[35m"+"=====================\n\n");
        System.out.println("\u001B[47m"+"\u001B[35m"+"\t\t\t\t DETAILS "+"\u001B[0m");
        in.nextLine();
        System.out.print("\u001B[37m"+"\n\n\t\t\t Name          : ");
        name = in.nextLine();
        System.out.print("\u001B[37m"+"\n\n\t\t\t Age           : ");
        age = in.nextLine();
        System.out.print("\u001B[37m"+"\n\n\t\t\t Gender (M/F)  : ");
        gender = in.nextLine();
        System.out.print("\u001B[37m"+"\n\n\t\t\t City          : ");
        city = in.nextLine();
        System.out.print("\u001B[37m"+"\n\n\t\t\t District      : ");
        district = in.nextLine();
        System.out.print("\u001B[37m"+"\n\n\t\t\t State         : ");
        state = in.nextLine();
        System.out.print("\u001B[37m"+"\n\n\t\t\t Country       : ");
        country = in.nextLine();
        if(n==1){
            list.add(new PatientTest(name.toUpperCase(), city.toUpperCase(), district.toUpperCase(), state.toUpperCase(), country.toUpperCase(), age, gender.toUpperCase(),"COVAXIN","0"));
        }
        else if(n==2){
            list.add(new PatientTest(name.toUpperCase(), city.toUpperCase(), district.toUpperCase(), state.toUpperCase(), country.toUpperCase(), age, gender.toUpperCase(),"COVISHIELD","0"));
        }
        oos = new ObjectOutputStream(new FileOutputStream(file1));
        oos.writeObject(list);
        oos.close();
        System.out.println("\n\n\t\t"+"\u001B[35m"+"===========================================================\n\n");
        System.out.println("\u001B[32m"+"\t\t\t\tCovid Test register Successfully");
        System.out.println("\n\n\t\t"+"\u001B[35m"+"===========================================================\n\n");
        System.out.println("\u001B[36m"+"\n\n\t\t <--Back(2)                                   Add(1)-->");
        int x = in.nextInt();
        if(x==1){
            System.out.print("\033\143");
            register(n);
        }
        else{
            System.out.print("\033\143");
            vaccination();
        }
    }
 
}


class Graph{
    File file3 = new File("Files/Patient/PatientDetails.txt");
    ObjectOutputStream oos=null;
    ObjectInputStream ois=null;
    ListIterator li = null;
    Scanner in = new Scanner(System.in);
    public void graph()throws IOException,ClassNotFoundException,FileNotFoundException,InterruptedException{
        int c=0;
        LinkedList<PatientDetails> list = new LinkedList<PatientDetails>();
        if(file3.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file3));
            list = (LinkedList<PatientDetails>)ois.readObject();
            ois.close();
        }  
        System.out.println("\n\n\n\t\t"+"\u001B[35m"+"===================== "+"\u001B[33m"+" COVID ANALYSER "+"\u001B[35m"+"=====================\n\n");
        System.out.print("\n\t\t\tEnter Country : ");
        String con = in.nextLine();
        int female=0,male=0,total=0;
        for(PatientDetails h:list){
            if(con.equalsIgnoreCase(h.country)){
                if(h.gender.equalsIgnoreCase("M")){
                    male+=1;
                }
                else{
                    female+=1;
                }
                total+=1;
                c+=1;
            }
        }
        float f_per=0f,m_per=0f;
        if(total!=0){
            m_per = (male/total)*100;
            f_per = (female/total)*100; 
        }
        
        System.out.println("\n\n\t\t\t Male     : "+male+"\t"+m_per+"%");
        System.out.println("\n\t\t\t Female   : "+female+"\t"+f_per+"%");
        System.out.println("\n\t\t\t Total    : "+total);

        System.out.println("\n\n\t\t"+"\u001B[35m"+"===========================================================\n\n");
        System.out.println("\u001B[36m"+"\n\n\t\t <--Back(2)                                  Continue-->");
        in.nextLine();
        System.out.print("\033\143");
        new Home().home();
    }
}


public class Covid {
    public static void main(String arg[]) throws InterruptedException,IOException,ClassNotFoundException{
        System.out.print("\033\143");
        new Welcome().welcome();
    }
}


/* javac -d . Covid.java
java -Djava.library.path=. covid.Covid */