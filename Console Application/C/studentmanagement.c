#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct login{
    char username[50],password[10],bug[3];
}login;


char getch(){
  char c; // This function should return the keystroke without allowing it to echo on screen

  system("stty raw");    
  system("stty -echo");  // Echo off
  c = getchar();
  system("stty cooked"); // Cooked input - reset
  system("stty echo");   // Echo on - Reset
  return c;
}

typedef struct student{
    int rollno,sem,result;
    char name[50],bug[2];
    struct subject{
        int mark;
    }sub[5];
    int total,grade;
    float gcpa;
}student;


/// Coordinator Login password----//
void read(){
    login log;
    FILE *fpread;
    fpread = fopen("/home/local/ZOHOCORP/gowtham-pt6112/Downloads/StdResult/coordinatorlogin.txt","r");
    while(fread(&log,sizeof(log),1,fpread)){
        printf("\n%-15s%-20s",log.username,log.password);
    }
    fclose(fpread);
}


/// Student login password-----//
void read2(){
    login log;
    FILE *fpread;
    fpread = fopen("/home/local/ZOHOCORP/gowtham-pt6112/Downloads/StdResult/studentlogin.txt","r");
    while(fread(&log,sizeof(log),1,fpread)){
        printf("\n%-15s%-20s",log.username,log.password);
    }
    fclose(fpread);
}


/// Username and password Valid Check------//
int compare(char a[],char b[]){
    int flag=0,i=0;
    while(a[i]!='\0' &&b[i]!='\0')
    {
       if(a[i]!=b[i])
       {
           flag=1;
           break;
       }
       i++;
    }
    if(flag==0)
        return 0;
    else
        return 1;
}


/// All student Result View---//
void display(char uname[50]){
    system("clear");
    student s1;
    int count=0,press,choice2,found=0;
    char a[]="Sem",b[]="Rollno",c[]="Sub1",d[]="Sub2",e[]="Sub3",f[]="Sub4",g[]="Sub5",h[]="Total",i[]="GPA",j[]="Grade",k[]="Name",l[]="Result";
    FILE *fpdisplay;
    fpdisplay = fopen("/home/local/ZOHOCORP/gowtham-pt6112/Downloads/StdResult/result.txt","r");
    while(fread(&s1,sizeof(student),1,fpdisplay)){
        found=1;
        if(count==0){
            printf("\n###----------Results-----------###\n");
            printf("\n%-5s%-8s%-8s%-6s%-6s%-6s%-6s%-6s%-7s%-7s%-7s%-7s\n",a,b,k,c,d,e,f,g,h,i,j,l);
            count++;
        }
        printf("\n%-5d%-8d%-8s",s1.sem,s1.rollno,s1.name);
        for(int j=0;j<5;j++){
            printf("%-6d",s1.sub[j].mark);
        }
        printf("%-7d%-7.2f%-7c",s1.total,s1.gcpa,s1.grade);
        if(s1.result==1){
            printf("Pass");
        }else{
            printf("Fail");
        }
    }
    fclose(fpdisplay);
    if(!found){
        printf("No record available");
    }
    printf("\n\nIf go for Back press 1 : ");
    scanf("%d",&press);
    if(press==1){
        system("clear");
        printf("\n###--------NAME : %s--------###\n",uname);
        printf("\n1. Show All Result\n2. Add Result\n3. Logout\n");
        printf("\nEnter your choice : ");
        scanf("%d",&choice2);
        switch(choice2){
            case 1:
                display(uname);
                break;
            case 2:
                marks(uname);
                break;
            case 3:
                coordinator();
                break;
        }
    }

}

int semexists(int sem,int rollno){
    student s1;
    int found=0;
    FILE *fpdisplay;
    fpdisplay = fopen("/home/local/ZOHOCORP/gowtham-pt6112/Downloads/StdResult/result.txt","r");
    while(fread(&s1,sizeof(student),1,fpdisplay)){
        if(s1.rollno==rollno && s1.sem==sem){
            found=1;
        }
    }
    if(!found){
        return 0;
    }
    else{
        return 1;
    }
    fclose(fpdisplay);
}

/// Marks adding ----------//
void marks(char uname[50]){
    system("clear");
    student *stu;
    int n=1,k=0,i,j,choice2,press,result=0,sem,rollno;
    FILE *fpresult;
    stu = (student*)calloc(n,sizeof(student));
    fpresult = fopen("/home/local/ZOHOCORP/gowtham-pt6112/Downloads/StdResult/result.txt","a");
    if(fpresult==NULL){
        printf("Error");
        exit(1);
    }
    stu[k].total=0;
    stu[k].gcpa=0;
    for(i=0;i<n;i++){
        printf("\n###--------Add Student Marks--------###\n");
        printf("\nEnter Reg No                  : ");
        scanf("%d",&rollno);
        resem:
        printf("Enter Semester No             : ");
        scanf("%d",&sem);
        if(semexists(sem,rollno)==0){
            stu->rollno = rollno;
            stu->sem = sem;
            gets(stu->bug);
            printf("Enter Name                    : ");
            gets(stu->name);
            for(j=0;j<5;j++){
                printf("Enter Marks of the Subject %d  : ",j+1);
                scanf("%d",&stu[i].sub[j].mark);
                if(stu[i].sub[j].mark>=50){
                    result++;
                }
                stu[i].total += stu[i].sub[j].mark;
            }
            float grade = stu[i].total / 50.0;
            stu[i].gcpa = stu[i].total / 50.0;
            if(result==5){
                if(grade>=9.0 && grade<=10.0){
                    stu[i].grade = 79;
                }else if(grade>=8.0 && grade<9.0){
                    stu[i].grade = 65;
                }else if(grade>=7.0 && grade<8.0){
                    stu[i].grade = 66;
                }else if(grade>=6.0 && grade<7.0){
                    stu[i].grade = 67;
                }else if(grade>=5.0 && grade<6.0){
                    stu[i].grade = 68;
                }
                stu[i].result = 1;
            }else{
                stu[i].grade = 45;
                stu[i].result = 0;
            }
            fwrite(&stu[i],sizeof(student),1,fpresult);
        }else{
            printf("Semester Results Already added\n");
            goto resem;
        }
    }
    printf("\nData are Inserted");
    fclose(fpresult);
    printf("\nIf go for Back press 1 : ");
    scanf("%d",&press);
    if(press==1){
        system("clear");
        printf("\n###--------NAME : %s--------###\n",uname);
        printf("\n1. Show All Result\n2. Add Result\n3. Logout\n");
        printf("\nEnter your choice : ");
        scanf("%d",&choice2);
        switch(choice2){
            case 1:
                display(uname);
                break;
            case 2:
                marks(uname);
                break;
            case 3:
                coordinator();
                break;
        }
    }
}


/// Student Result View---///
void result(int rollno){
    system("clear");
    student s1;
    int sem,found=0,n,count=0,press;
    char a[]="Sem",b[]="Rollno",c[]="Sub1",d[]="Sub2",e[]="Sub3",f[]="Sub4",g[]="Sub5",h[]="Total",i[]="GPA",j[]="Grade",k[]="Name",l[]="Result";
    FILE *fpdisplay;
    result1:
    printf("\n###--------NAME : %d--------###\n",rollno);
    printf("\n1. Overall Result\n2. Sem Result\n3. Logout\n");
    printf("\nEnter your Choice : ");
    scanf("%d",&n);
    switch(n){
    case 1:
        system("clear");
        fpdisplay = fopen("/home/local/ZOHOCORP/gowtham-pt6112/Downloads/StdResult/result.txt","r");
        while(fread(&s1,sizeof(student),1,fpdisplay)){
            if((s1.rollno==rollno)){
                found = 1;
                if(count==0){
                    printf("\n###--------Results---------###\n");
                    printf("\n\tNAME        : %s\n\tROLL NUMBER : %d\n\n",s1.name,s1.rollno);
                    printf("\n%-5s%-6s%-6s%-6s%-6s%-6s%-7s%-7s%-7s%-7s\n",a,c,d,e,f,g,h,i,j,l);
                    count++;
                }
                printf("\n%-6d",s1.sem);
                for(int j=0;j<5;j++){
                    printf("%-6d",s1.sub[j].mark);
                }
                printf("%-7d%-7.2f%-7c",s1.total,s1.gcpa,s1.grade);
                if(s1.result==1){
                    printf("Pass");
                }else{
                    printf("Fail");
                }
            }
        }
        if(!found){
            printf("\n\nNo record available");
        }
        printf("\n\nIf you go for Back press 1 : ");
        scanf("%d",&press);
        if(press==1){
            system("clear");
            count--;
            goto result1;
        }else{
            system("clear");
            home();
        }
        fclose(fpdisplay);
        break;
    case 2:
        system("clear");
        int found1=0;
        printf("\nEnter your Sem No  : ");
        scanf("%d",&sem);
        fpdisplay = fopen("/home/local/ZOHOCORP/gowtham-pt6112/Downloads/StdResult/result.txt","r");
        while(fread(&s1,sizeof(student),1,fpdisplay)){
            if((s1.sem==sem) && (s1.rollno==rollno)){
                found1 = 1;
                if(count==0){
                    printf("\n###--------Results---------###\n");
                    printf("\n\tNAME        : %s\n\tROLL NUMBER : %d\n\n",s1.name,s1.rollno);
                    printf("\n%-5s%-6s%-6s%-6s%-6s%-6s%-7s%-7s%-7s%-7s\n",a,c,d,e,f,g,h,i,j,l);
                    count++;
                }
                printf("\n%-6d",s1.sem);
                for(int j=0;j<5;j++){
                    printf("%-6d",s1.sub[j].mark);
                }
                printf("%-7d%-7.2f%-7c",s1.total,s1.gcpa,s1.grade);
                if(s1.result==1){
                    printf("Pass");
                }else{
                    printf("Fail");
                }
            }
        }
        if(!found1){
            printf("\nNo record available");
            count = 1;
        }
        printf("\n\nIf you go for Back press 1 : ");
        scanf("%d",&press);
        if(press==1){
            system("clear");
            count--;
            goto result1;
        }
        fclose(fpdisplay);
        break;
    case 3:
        studentlogin();
        break;
    default:
        system("clear");
        home();
        break;
    }
}


/// Exist User for student ///
int existstudent(char username[50]){
    login log;
    int found=0;
    FILE *fpread;
    fpread = fopen("/home/local/ZOHOCORP/gowtham-pt6112/Downloads/StdResult/studentlogin.txt","r");
    printf("\n%s",username);
    while(fread(&log,sizeof(log),1,fpread)){
        printf("%s",log.username);
        if(log.username==username){
            found =1;
        }
    }

    if(found)
        return 0;
    else
        return 1;
    fclose(fpread);
}

/// Coordinator---------//
void coordinator(){
    incrt:
    system("clear");
    login l;
    int found=0,press;
    char ch;
    FILE *fpadd,*fpcheck;
    printf("\n###----------Press Anyone----------###\n");
    printf("\n1. Login\n2. Register\n3. Back\n");
    int choice,choice2;
    char uname[50],upass[50];
    re:
    printf("\nEnter your choice  :");
    scanf("%d",&choice);
    system("clear");
    switch(choice){
    case 1:
        relogin:
        fpcheck = fopen("/home/local/ZOHOCORP/gowtham-pt6112/Downloads/StdResult/coordinatorlogin.txt","r");
        if(fpcheck==NULL){
            printf("Error While file Opening");
            exit(1);
        }
        gets(l.bug);
        printf("\n----------------LOGIN--------------------\n");
        printf("\nEnter Username    : ");
        gets(uname);
        printf("Enter Password    : ");
        for(int i = 0;i < 100;i++){
            ch = getch();
            if(ch == 13)
            break;
            upass[i]= ch;
            ch = '*' ;
            printf("%c", ch);
        }
         while(fread(&l,sizeof(login),1,fpcheck)){
            if((strlen(l.username)==strlen(uname)) && (strlen(l.password)==strlen(upass))){
                if(compare(l.username,uname)==0 && compare(l.password,upass)==0){
                    found=1;
                }
            }
        }
        if(found==1){
            system("clear");
            printf("\n###--------NAME : %s--------###\n",uname);
            printf("\n1. Show All Result\n2. Add Result\n3. Logout\n");
            printf("\nEnter your choice : ");
            scanf("%d",&choice2);
            switch(choice2){
                case 1:
                    display(uname);
                    break;
                case 2:
                    marks(uname);
                    break;
                case 3:
                    coordinator();
                    break;
            }

        }
        else{
            printf("username and password is wrong");
            goto incrt;
        }
        break;

    case 2:
        fpadd = fopen("/home/local/ZOHOCORP/gowtham-pt6112/Downloads/StdResult/coordinatorlogin.txt","a");
        if(fpadd==NULL){
            printf("Error While file Opening");
            exit(1);
        }
        gets(l.bug);
        printf("\n----------------Register----------------\n");
        printf("\nEnter Username    : ");
        gets(l.username);
        printf("Enter Password    : ");
        for(int i = 0;i < 10;i++){
            ch = getch();
            if(ch == 13)
            break;
            l.password[i] = ch;
            ch = '*' ;
            printf("%c", ch);
        }
        fwrite(&l,sizeof(l),1,fpadd);
        fclose(fpadd);
        printf("\nRegister Successfully......Go for Login press 1");
        scanf("%d",&press);
        if(press==1){
            system("clear");
            goto relogin;
        }
        break;
    case 3:
        home();
        break;
    default:
        printf("Invalid input\n");
        goto re;
    }

}


/// Student-------------//
void studentlogin(){
    incrt:
    system("clear");
    login l;
    int found=0,uint,press;
    FILE *fpadd,*fpcheck;
    printf("\n1. Login\n2. Register\n3. Back\n");
    int choice;
    char uname[50],upass[50],ch,usname[50];
    re:
    printf("Enter your choice  :");
    scanf("%d",&choice);
    system("clear");
    switch(choice){
    case 1:
        relogin:
        fpcheck = fopen("/home/local/ZOHOCORP/gowtham-pt6112/Downloads/StdResult/studentlogin.txt","r");
        if(fpcheck==NULL){
            printf("Error While file Opening");
            exit(1);
        }
        gets(l.bug);
        printf("\n----------------LOGIN--------------------\n");
        printf("\nEnter RollNum     : ");
        gets(uname);
        printf("Enter Password    : ");
        for(int i = 0;i < 100;i++){
            ch = getch();
            if(ch == 13)
            break;
            upass[i]= ch;
            ch = '*' ;
            printf("%c", ch);
        }
        while(fread(&l,sizeof(login),1,fpcheck)){
            if((strlen(l.username)==strlen(uname)) && (strlen(l.password)==strlen(upass))){
                if(compare(l.username,uname)==0 && compare(l.password,upass)==0){
                    found=1;
                }
            }
        }
        if(found==1){
            uint= atoi(uname);
            result(uint);
        }
        else{
            printf("username and password is wrong");
            goto incrt;
        }
        break;
    case 2:
        fpadd = fopen("/home/local/ZOHOCORP/gowtham-pt6112/Downloads/StdResult/studentlogin.txt","ar");
        if(fpadd==NULL){
            printf("Error While file Opening");
            exit(1);
        }
        gets(l.bug);
        printf("\n----------------Register----------------\n");
        printf("\nEnter Rollnum     : ");
        gets(l.username);
       // printf("%s",usname);
        /*if(existstudent(usname)==0){
            for(int j=0;j<20;j++){
                l.username[j] = usname[j];
            }*/
            printf("Enter Password    : ");
            for(int i = 0;i < 10;i++){
                ch = getch();
                if(ch == 13)
                break;
                l.password[i] = ch;
                ch = '*' ;
                printf("%c", ch);
            }
            fwrite(&l,sizeof(l),1,fpadd);
        /*}else{
            printf("Already a User go for Login.....");
            goto relogin;
        }*/
        fclose(fpadd);
        printf("\nRegister Successfully......Go for Login press 1");
        scanf("%d",&press);
        if(press==1){
            system("clear");
            goto relogin;
        }
        break;
    case 3:
        system("clear");
        home();
        break;
    default:
        printf("Invalid input\n");
        goto re;
    }
}


///HOME PAGE------------//
void home(){
    system("clear");
    printf("\n1. Coordinator Login\n2. Student Login\n");
    int choice;
    printf("\nEnter Your Choice : ");
    scanf("%d",&choice);
    switch(choice){
    case 1:
        coordinator();
        break;
    case 2:
        studentlogin();
        break;
    case 3:
        read();
        break;
    case 4:
        read2();
        break;
    case 5:
        display("6112");
        break;
    default:
        printf("Not valid");
        break;
    }
}

int main(){
    home();
    return 0;
}