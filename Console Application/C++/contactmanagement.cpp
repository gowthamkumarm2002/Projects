#include<iostream>
#include <fstream>
#include <unistd.h>

using namespace std;

struct Contactdetails{
    long int phoneno;
    char name[50],relation[50];
};

struct ContactHistory{
    long int phoneno;
    int date[3];
    char status[50];
};

int phonecheck(long int num){
    int c=0;
    while(num!=0){
        num/=10;
        c++;
    }
    return c;
}

int alreadyphno(long int num){
    Contactdetails c;
    int n=0;
    ifstream o("Files/Contacts.txt",ios::binary | ios::in);
    if(!o){
        cout << "Error"<<endl;
    }
    while(o.read((char *)&c,sizeof(c))){
        if(c.phoneno==num){
            n=1;
        }
    }
    o.close();
    return n;
}

// welcome
class Welcome{
    private:
        int num;
    public:
    int welcome(){
        cout << "\n\n\n\t\t\t* * * * * * * * * * *\n";
        cout << "\t\t\t*                   *\n";
        cout << "\t\t\t*                   *\n";
        cout << "\t\t\t*                   *\n";
        cout << "\t\t\t*    WELCOME  TO    *\n";
        cout << "\t\t\t*                   *\n";
        cout << "\t\t\t*      CONTACT      *\n";
        cout << "\t\t\t*                   *\n";
        cout << "\t\t\t*     MANAGEMENT    *\n";
        cout << "\t\t\t*                   *\n";
        cout << "\t\t\t*      SYSTEM       *\n";
        cout << "\t\t\t*                   *\n";
        cout << "\t\t\t*                   *\n";
        cout << "\t\t\t*                   *\n";
        cout << "\t\t\t*   ->    o    <-   *\n";
        cout << "\t\t\t*    1    2    3    *\n";
        cout << "\t\t\t* * * * * * * * * * *\n";
        cin >> num;
        return num;
    }

};

// Mainmenu
class Mainmenu{
    private:
        int num;
    public:
        int mainmenu(){
            cout << "\n\n\n\t\t\t* * * * * * * * * * *\n";
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*  PHONE MAIN MENU  *\n";
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*     11.ADD        *\n";
            cout << "\t\t\t*     12.Search     *\n";
            cout << "\t\t\t*     13.View       *\n";
            cout << "\t\t\t*     14.Update     *\n";
            cout << "\t\t\t*     15.Delete     *\n";
            cout << "\t\t\t*     16.Call       *\n";
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*   ->    o    <-   *\n";
            cout << "\t\t\t*    1    2    3    *\n";
            cout << "\t\t\t* * * * * * * * * * *\n";
            cin >> num;
            return num;
        }
};



// Add contact
class Addcontact{
    private:
        char yes;
        long int phonenum;
    public:
        int addcontact(){
            Contactdetails c;
            ofstream o("Files/Contacts.txt",ios::binary | ios::app);
            if(!o){
                cout << "Error"<<endl;
            }  
            cout << "\n\n\n\t\t\t* * * * * * * * * * *\n";
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*       ADD         *\n";
            rephone:
            cout << "\t\t\t*                   *\n"<<"\t\t\t*    ";
            cout << "PH.NO  "<<"\t    *\n"<<"\t\t\t*   ";
            cin >> phonenum;
            if(phonecheck(phonenum)==10){
                if(alreadyphno(phonenum)==0){
                    c.phoneno=phonenum;
                }
                else{
                    cout << "\t\t\t*                   *\n";
                    cout << "\t\t\t*     PH.NO is      *\n";
                    cout << "\t\t\t*   Already Exist   *\n";
                    goto rephone;
                }
            }
            else{
                cout << "\t\t\t*                   *\n";
                cout << "\t\t\t*     PH.NO is      *\n";
                cout << "\t\t\t*    Not  Vaild     *\n";
                goto rephone;
            }
            cin.ignore();
            cout << "\t\t\t*     NAME \t    *\n"<<"\t\t\t*   ";
            cin.getline(c.name,15);
            cout << "\t\t\t*    RELATION       *\n"<<"\t\t\t*   ";
            cin.getline(c.relation,15);
            o.write((char *)&c,sizeof(c));
            o.close();
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*   Contact Added   *\n";
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*   Continue?(Y/N)  *\n";
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*   ->    o    <-   *\n";
            cout << "\t\t\t*    1    2    3    *\n";
            cout << "\t\t\t* * * * * * * * * * *\n";
            o.close();
            cin >> yes;
            return int(yes);
        }
};

// Search Contact
class Searchcontact{
    private:
        int yes,count=0;
        long int ph_no;
    public:
        int searchcontact(){
            Contactdetails c;
            ifstream o("Files/Contacts.txt",ios::binary | ios::in);
            if(!o){
                cout << "Error"<<endl;
            }
            cout << "\n\n\n\t\t\t* * * * * * * * * * *\n";
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*      SEARCH       *\n";
            cout << "\t\t\t*                   *\n"<<"\t\t\t*    ";
            cout << "PH.NO  "<<"\t    *\n"<<"\t\t\t*   ";
            cin >> ph_no;  
            while(o.read((char *)&c,sizeof(c))){
                if(c.phoneno==ph_no){
                    count +=1;
                    cout << "\t\t\t*                   *\n";
                    cout << "\t\t\t*                   *\n";
                    cout << "\t\t\t*  Name " << c.name <<endl;
                    cout << "\t\t\t*                   *\n";
                    cout << "\t\t\t*  No " << c.phoneno <<endl;
                    cout << "\t\t\t*                   *\n";
                    cout << "\t\t\t*  Rel  " << c.relation <<endl;
                    cout << "\t\t\t*                   *\n";
                    cout << "\t\t\t*                   *\n";
                    cout << "\t\t\t*                   *\n";
                    cout << "\t\t\t*   ->    o    <-   *\n";
                    cout << "\t\t\t*    1    2    3    *\n";
                    cout << "\t\t\t* * * * * * * * * * *\n";
                    
                }
            }
            if(count==0){
                cout << "\t\t\t*                   *\n";
                cout << "\t\t\t*                   *\n";
                cout << "\t\t\t*     NO RECORDS    *\n";
                cout << "\t\t\t*     AVAILABLE     *\n";
                cout << "\t\t\t*                   *\n";
                cout << "\t\t\t*                   *\n";
                cout << "\t\t\t*   ->    o    <-   *\n";
                cout << "\t\t\t*    1    2    3    *\n";
                cout << "\t\t\t* * * * * * * * * * *\n";
            }
            o.close();
            cin >> yes;
            return yes; 
        }
};

// View Contact
class ViewContact{
    private:
        int yes;
    public:
        int viewcontact(){
            Contactdetails c;
            ifstream o("Files/Contacts.txt",ios::binary | ios::in);
            if(!o){
                cout << "Error"<<endl;
            } 
            cout << "\n\n\n\t\t\t* * * * * * * * * * *\n";
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*      VIEW         *\n";
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*                   *\n";
            while(o.read((char *)&c,sizeof(c))){
                
                cout << "\t\t\t*  Name " << c.name <<endl;
                cout << "\t\t\t*                   *\n";
                cout << "\t\t\t*  No " << c.phoneno <<endl;
                cout << "\t\t\t*                   *\n";
                cout << "\t\t\t*  Rel  " << c.relation <<endl;
                cout << "\t\t\t*                   *\n";
                cout << "\t\t\t*                   *\n";
            }
            cout << "\t\t\t*   ->    o    <-   *\n";
            cout << "\t\t\t*    1    2    3    *\n";
            cout << "\t\t\t* * * * * * * * * * *\n";
            o.close();
            cin >> yes;
            return yes;
        }
};

// Update Contact
class Updatecontact{
    private:
        int yes,count=0;
        long int ph_no;
    public:
        int updatecontact(){
            Contactdetails c;
            fstream o("Files/Contacts.txt",ios::binary | ios::in | ios::out);
            if(!o){
                cout << "Error"<<endl;
            } 
            o.seekg(0);
            cout << "\n\n\n\t\t\t* * * * * * * * * * *\n";
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*      UPDATE       *\n";
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*                   *\n"<<"\t\t\t*    ";
            cout << "PH.NO  "<<"\t    *\n"<<"\t\t\t*   ";
            cin >> ph_no;
            while(o.read((char *)&c,sizeof(c))){
                
                if(c.phoneno==ph_no){
                    count+=1;
                    cout << "\t\t\t*                   *\n";
                    cout << "\t\t\t*                   *\n"<<"\t\t\t*    ";
                    cout << "NEW PH.NO  "<<"    *\n"<<"\t\t\t*   ";
                    cin >> c.phoneno;
                    cin.ignore();
                    cout << "\t\t\t*     NAME \t    *\n"<<"\t\t\t*   ";
                    cin.getline(c.name,15);
                    cout << "\t\t\t*    RELATION       *\n"<<"\t\t\t*   ";
                    cin.getline(c.relation,15);
                    cout << "\t\t\t*                   *\n";
                    cout << "\t\t\t*                   *\n";
                    cout << "\t\t\t*   ->    o    <-   *\n";
                    cout << "\t\t\t*    1    2    3    *\n";
                    cout << "\t\t\t* * * * * * * * * * *\n";
                    o.seekp(-sizeof(c),ios::cur);
                    o.write((char*)&c,sizeof(c));
                } 
                
            }
            if(count==0){
                cout << "\t\t\t*                   *\n";
                cout << "\t\t\t*                   *\n";
                cout << "\t\t\t*     NO RECORDS    *\n";
                cout << "\t\t\t*     AVAILABLE     *\n";
                cout << "\t\t\t*                   *\n";
                cout << "\t\t\t*                   *\n";
                cout << "\t\t\t*   ->    o    <-   *\n";
                cout << "\t\t\t*    1    2    3    *\n";
                cout << "\t\t\t* * * * * * * * * * *\n";
            }
            o.close();
            cin >> yes;
            return yes; 
        }
};

// Delete Contact
class DeleteContact{
    private:
        int yes,count=0;
        long int ph_no;
    public:
        int deletecontact(){
            Contactdetails c;
            fstream o("Files/Contacts.txt",ios::binary | ios::in );
            fstream f1("Files/temp.txt",ios::binary | ios::out);
            fstream f2("Files/Deletecontacts.txt",ios::binary | ios::out);
            if(!o){
                cout << "Error"<<endl;
            } 
            o.seekg(0);
            cout << "\n\n\n\t\t\t* * * * * * * * * * *\n";
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*      DELETE       *\n";
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*                   *\n"<<"\t\t\t*    ";
            cout << "PH.NO  "<<"\t    *\n"<<"\t\t\t*   ";
            cin >> ph_no;
            while(o.read((char *)&c,sizeof(c))){
                if(c.phoneno==ph_no){
                    count=1;
                    f2.write((char *)&c,sizeof(c));
                }
                else{
                    f1.write((char *)&c,sizeof(c));
                }
            }
            if(count==1){
                cout << "\t\t\t*                   *\n";
                cout << "\t\t\t*                   *\n";
                cout << "\t\t\t*    NUMBER  IS     *\n";
                cout << "\t\t\t*     DELETED       *\n";
                cout << "\t\t\t*                   *\n";
                cout << "\t\t\t*                   *\n";
                cout << "\t\t\t*   ->    o    <-   *\n";
                cout << "\t\t\t*    1    2    3    *\n";
                cout << "\t\t\t* * * * * * * * * * *\n";
                o.close();
                f1.close();
                f2.close();
                remove("Files/Contacts.txt");
                rename("Files/temp.txt","Files/Contacts.txt");
            }
            if(count==0){
                cout << "\t\t\t*                   *\n";
                cout << "\t\t\t*                   *\n";
                cout << "\t\t\t*     NO RECORDS    *\n";
                cout << "\t\t\t*     AVAILABLE     *\n";
                cout << "\t\t\t*                   *\n";
                cout << "\t\t\t*                   *\n";
                cout << "\t\t\t*   ->    o    <-   *\n";
                cout << "\t\t\t*    1    2    3    *\n";
                cout << "\t\t\t* * * * * * * * * * *\n";
            }
            cin >> yes;
            return yes;
        }
        

};

// Call
class Call{
    private:
        int num;
    public:
        int call(){
            cout << "\n\n\n\t\t\t* * * * * * * * * * *\n";
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*      PHONE CALL   *\n";
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*    11.MAKE CALL   *\n";
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*      HISTORY      *\n";
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*     12.View       *\n";
            cout << "\t\t\t*     13.Delete     *\n";
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*   ->    o    <-   *\n";
            cout << "\t\t\t*    1    2    3    *\n";
            cout << "\t\t\t* * * * * * * * * * *\n";
            cin >> num;
            return num;
        }

};



// Make a Call
class MakeaCall{
    private:
        long int yes,count=0;
        long int ph_no;
    public:
        long int makecall(){
            Contactdetails c;
            ifstream o("Files/Contacts.txt",ios::binary | ios::in);
            if(!o){
                cout << "Error"<<endl;
            } 
            cout << "\n\n\n\t\t\t* * * * * * * * * * *\n";
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*      SEARCH       *\n";
            cout << "\t\t\t*                   *\n"<<"\t\t\t*    ";
            cout << "PH.NO  "<<"\t    *\n"<<"\t\t\t*   ";
            cin >> ph_no; 
            while(o.read((char *)&c,sizeof(c))){
                if(c.phoneno==ph_no){
                    count+=1;
                    cout << "\t\t\t*                   *\n";
                    cout << "\t\t\t*                   *\n";
                    cout << "\t\t\t*                   *\n";
                    cout << "\t\t\t*    CONNECTING     *\n";
                    cout << "\t\t\t*                   *\n";
                    cout << "\t\t\t*                   *\n";
                    cout << "\t\t\t*                   *\n";
                    cout << "\t\t\t*   ->    o    <-   *\n";
                    cout << "\t\t\t*    1    2    3    *\n";
                    cout << "\t\t\t* * * * * * * * * * *\n";
                    sleep(2);
                    return ph_no;
                }
            }
            if(count==0){
                cout << "\t\t\t*                   *\n";
                cout << "\t\t\t*                   *\n";
                cout << "\t\t\t*                   *\n";
                cout << "\t\t\t*    NUMBER IS      *\n";
                cout << "\t\t\t*       NOT         *\n";
                cout << "\t\t\t*    AVAILABLE      *\n";
                cout << "\t\t\t*                   *\n";
                cout << "\t\t\t*                   *\n";
                cout << "\t\t\t*                   *\n";
                cout << "\t\t\t*   ->    o    <-   *\n";
                cout << "\t\t\t*    1    2    3    *\n";
                cout << "\t\t\t* * * * * * * * * * *\n";
                cin >> yes;
                return yes;
            }
        }
};

// Speacking
class Specking{
    private:
        int yes;
    public:
        int specking(long int x){
            ContactHistory ch;
            fstream o("Files/History.txt",ios::binary | ios::app);
            if(!o){
                cout << "Error";
            }
            cout << "\n\n\n\t\t\t* * * * * * * * * * *\n";
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*   " << x <<  "      *\n";
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*     Speaking to   *\n";
            cout << "\t\t\t*        the        *\n";
            cout << "\t\t\t*   Contact Number   \n";
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*        End        *\n";
            cout << "\t\t\t*         5         *\n";
            cout << "\t\t\t* * * * * * * * * * *\n";
            cin>>yes;
            if(yes==5){
                ch.phoneno =x;
                time_t now = time(0);
                tm *ltm = localtime(&now);
                ch.date[0] = ltm->tm_mday; 
                ch.date[1] = 1 + ltm->tm_mon;
                ch.date[2] = 1900 + ltm->tm_year;
                o.write((char *)&ch,sizeof(ch));
                o.close();
                return 1;
            }
        }
};

// History
class History{
    private:
        char yes1;
        int yes;
    public:
        int history(){
            ContactHistory c;
            ifstream o("Files/History.txt",ios::binary | ios::in);
            if(!o){
                cout << "Error"<<endl;
            }
            cout << "\n\n\n\t\t\t* * * * * * * * * * *\n";
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*      HISTORY      *\n";
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*                   *\n";
            while(o.read((char *)&c,sizeof(c))){
                cout << "\t\t\t*  No " << c.phoneno <<endl;
                cout << "\t\t\t*                   *\n";
                cout << "\t\t\t*  Date  " << c.date[0]<<"-"<< c.date[1]<<"-"<< c.date[2] <<endl;
                cout << "\t\t\t*                   *\n";
                cout << "\t\t\t*                   *\n";
            }
            cout << "\t\t\t*   ->    o    <-   *\n";
            cout << "\t\t\t*    1    2    3    *\n";
            cout << "\t\t\t* * * * * * * * * * *\n";
            o.close();
            cin >> yes;
            return yes;
        }
        int deletehistory(){
            ContactHistory c;
            fstream o("Files/History.txt",ios::binary | ios::in);
            if(!o){
                cout << "Error "<<endl;
            }
            cout << "\n\n\n\t\t\t* * * * * * * * * * *\n";
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*      HISTORY      *\n";
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*                   *\n";
            while(o.read((char *)&c,sizeof(c))){
                cout << "\t\t\t*  No " << c.phoneno <<endl;
                cout << "\t\t\t*                   *\n";
                cout << "\t\t\t*  Date  " << c.date[0]<<"-"<< c.date[1]<<"-"<< c.date[2] <<endl;
                cout << "\t\t\t*                   *\n";
                cout << "\t\t\t*                   *\n";
            }
            cout << "\t\t\t*    If you want    *\n";
            cout << "\t\t\t*      Delete       *\n";
            cout << "\t\t\t*   History? (Y/N)  *\n";
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*   ->    o    <-   *\n";
            cout << "\t\t\t*    1    2    3    *\n";
            cout << "\t\t\t* * * * * * * * * * *\n";
            cin >> yes1;
            return yes1;
        }
};

// Delete History
class Deletehistory{
    private:
        int yes,count=0;
        long int ph_no;
    public:
        int deletehis(){
            Contactdetails c;
            fstream o("Files/History.txt",ios::binary | ios::in );
            fstream f1("Files/temp.txt",ios::binary | ios::out);
            fstream f2("Files/DeleteHistory.txt",ios::binary | ios::out);
            if(!o){
                cout << "Error"<<endl;
            } 
            o.seekg(0);
            cout << "\n\n\n\t\t\t* * * * * * * * * * *\n";
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*      DELETE       *\n";
            cout << "\t\t\t*                   *\n";
            cout << "\t\t\t*                   *\n"<<"\t\t\t*    ";
            cout << "PH.NO  "<<"\t    *\n"<<"\t\t\t*   ";
            cin >> ph_no;
            while(o.read((char *)&c,sizeof(c))){
                if(c.phoneno==ph_no){
                    count=1;
                    f2.write((char *)&c,sizeof(c));
                }
                else{
                    f1.write((char *)&c,sizeof(c));
                }
            }
            if(count==1){
                cout << "\t\t\t*                   *\n";
                cout << "\t\t\t*                   *\n";
                cout << "\t\t\t*    HISTORY IS     *\n";
                cout << "\t\t\t*     DELETED       *\n";
                cout << "\t\t\t*                   *\n";
                cout << "\t\t\t*                   *\n";
                cout << "\t\t\t*   ->    o    <-   *\n";
                cout << "\t\t\t*    1    2    3    *\n";
                cout << "\t\t\t* * * * * * * * * * *\n";
                o.close();
                f1.close();
                f2.close();
                remove("Files/History.txt");
                rename("Files/temp.txt","Files/History.txt");
            }
            if(count==0){
                cout << "\t\t\t*                   *\n";
                cout << "\t\t\t*                   *\n";
                cout << "\t\t\t*     NO RECORDS    *\n";
                cout << "\t\t\t*     AVAILABLE     *\n";
                cout << "\t\t\t*                   *\n";
                cout << "\t\t\t*                   *\n";
                cout << "\t\t\t*   ->    o    <-   *\n";
                cout << "\t\t\t*    1    2    3    *\n";
                cout << "\t\t\t* * * * * * * * * * *\n";
            }
            cin >> yes;
            return yes;
        }
};



int main(){
    system("clear");
    rewelcome:
    Welcome w;
    int x = w.welcome();
    while(1){
        if(x==1 || x==2){
            while(1){
                remainmenu:
                system("clear");
                Mainmenu m;
                int x = m.mainmenu();
                if(x==11){
                    readd:
                    system("clear");
                    Addcontact a;
                    int y = a.addcontact();
                    if(y==89 || y==121){
                        system("clear");
                        goto readd;
                    }
                    else if(y==1 || y==2 || y==3){
                        system("clear");
                        sleep(1);
                        goto remainmenu;
                    }
                    else{
                        system("clear");
                        goto remainmenu;
                    }
                }
                
                else if(x==12){
                    system("clear");
                    Searchcontact a;
                    int y = a.searchcontact();
                    if(y==1 || y==2 || y==3){
                        system("clear");
                        sleep(1);
                        goto remainmenu;
                    }
                    else{
                        system("clear");
                        goto remainmenu;
                    }
                }
                
                else if(x==13){
                    system("clear");
                    ViewContact a;
                    int y = a.viewcontact();
                    if(y==1 || y==2 || y==3){
                        system("clear");
                        sleep(1);
                        goto remainmenu;
                    }
                    else{
                        system("clear");
                        goto remainmenu;
                    }
                }
                
                else if(x==14){
                    system("clear");
                    Updatecontact a;
                    int y = a.updatecontact();
                    if(y==1 || y==2 || y==3){
                        system("clear");
                        sleep(1);
                        goto remainmenu;
                    }
                    else{
                        system("clear");
                        goto remainmenu;
                    }
                }
                
                else if(x==15){
                    system("clear");
                    DeleteContact a;
                    int y = a.deletecontact();
                    if(y==1 || y==2 || y==3){
                        system("clear");
                        sleep(1);
                        goto remainmenu;
                    }
                    else{
                        system("clear");
                        goto remainmenu;
                    }
                }
                
                else if(x==16){
                    system("clear");
                    recall:
                    Call c;
                    int y = c.call();
                    if(y==11){
                        system("clear");
                        MakeaCall mc;
                        long int z = mc.makecall();
                        if(z>1000){
                            system("clear");
                            Specking spe;
                            int xz = spe.specking(z);
                            if(xz==1){
                                system("clear");
                                sleep(1);
                                goto recall;
                            }
                        }
                        else if(z==1 ){
                            system("clear");
                            sleep(1);
                            goto recall;
                        }
                        else if(z==2 || z==3){
                            system("clear");
                            sleep(1);
                            goto remainmenu;
                        }
                        else{
                            system("clear");
                            goto remainmenu;
                        }
                    }
                    else if(y==12){
                        system("clear");
                        History h;
                        int z = h.history();
                        if(z==1 || z==3){
                            system("clear");
                            sleep(1);
                            goto recall;
                        }
                        else if(z==2){
                            system("clear");
                            sleep(1);
                            goto remainmenu;
                        }
                        else{
                            system("clear");
                            goto remainmenu;
                        }
                    }
                    else if(y==13){
                        system("clear");
                        History h;
                        int z = h.deletehistory();
                        if(z==121 || z==89){
                            system("clear");
                            Deletehistory dh;
                            int zyx= dh.deletehis();
                            if(z==1 || z==3){
                                system("clear");
                                sleep(1);
                                goto recall;
                            }
                        }
                        if(z==1 || z==3){
                            system("clear");
                            sleep(1);
                            goto recall;
                        }
                    }
                    else if(y==1 || y==3){
                        system("clear");
                        sleep(1);
                        goto recall;
                    }
                    else if(y==2){
                        system("clear");
                        sleep(1);
                        goto remainmenu;
                    }
                    else{
                        system("clear");
                        goto remainmenu;
                    }

                }
               
                else if(x==2){
                    system("clear");
                    sleep(1);
                    goto remainmenu;
                }
                else if(x==3){
                    system("clear");
                    sleep(1);
                    goto rewelcome;
                }
                else{
                    system("clear");
                    sleep(1);
                    cout << "\t\t\t Invaild Input \n\n";
                    goto remainmenu;
                }
            }
        }
        else if(x==2){
            cout << "Ni";
            break;
        }
        else if(x==3){
            system("clear");
            sleep(1);
            goto rewelcome;
            break;
        }
        else{
            system("clear");
            sleep(1);
            cout << "\t\t\t Invaild Input \n\n";
            goto rewelcome;
        }
    }
}