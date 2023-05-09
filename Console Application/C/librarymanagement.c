#include <stdio.h>
#include <stdlib.h>

typedef struct student{
    char name[50],dept[50],bug[3];
    int regno,noofbooks,isday,ismon,isyear,reday,remon,reyear;
    struct book{
        int bookid;
    }book[3];
}student;

typedef struct books{
    char bname[50],author[50],bug[3];
    int bid,stday,stmon,styear;
}books;

/// Record View---------//
void read(){
    student s1;
    FILE *fpread;
    fpread = fopen("/home/local/ZOHOCORP/gowtham-pt6112/Downloads/Library/record.txt","r");
    while(fread(&s1,sizeof(student),1,fpread)){
        printf("\n%s\t%d\t%s\t%d",s1.name,s1.regno,s1.dept,s1.noofbooks);
        for(int j=0;j<3;j++){
            printf("\t%d",s1.book[j].bookid);
        }
        printf("\t%d-%d-%d\t%d-%d-%d",s1.isday,s1.ismon,s1.isyear,s1.reday,s1.remon,s1.reyear);
    }
    fclose(fpread);
}
/// Register Number book details--------//
void read1(int regnum){
    student s1;
    FILE *fpread;
    fpread = fopen("/home/local/ZOHOCORP/gowtham-pt6112/Downloads/Library/record.txt","r");
    while(fread(&s1,sizeof(student),1,fpread)){
        if(s1.regno==regnum){
            printf("\n%s\t%d\t%s\t%d",s1.name,s1.regno,s1.dept,s1.noofbooks);
            for(int j=0;j<3;j++){
                printf("\t%d",s1.book[j].bookid);
            }
            printf("\t%d-%d-%d\t%d-%d-%d\n\n",s1.isday,s1.ismon,s1.isyear,s1.reday,s1.remon,s1.reyear);
        }
    }
    fclose(fpread);
}


/// Date Validation------//
int datevalid(int day,int mon,int year){
    if((year>2000 && year<3000)){
        if(mon>0 && mon<=12){
            if((day>=1 && day<=31) && (mon==1 || mon==3 || mon==5 || mon==7 || mon==8 || mon==10 || mon==12)){
                return 0;
            }
            else if((day>=1 && day<=30) &&  (mon==4 || mon==6 || mon==9 || mon==11)){
                return 0;
            }
            else if((day>=1 && day<=28) && (mon==2)){
                return 0;
            }else if((day==29 && mon==2) && ((year%400==0) || (year%100!=0 && year%4==0))){
                return 0;
            }
            }
        }
    return 1;
}


///Delete Record-----------------------///
void deteleitem(int regno){
    student s1;
    int found=0;
    FILE *fp,*fp1,*fp2;
    fp = fopen("/home/local/ZOHOCORP/gowtham-pt6112/Downloads/Library/record.txt","r");
    fp1 = fopen("/home/local/ZOHOCORP/gowtham-pt6112/Downloads/Library/delete.txt","w");
    while(fread(&s1,sizeof(student),1,fp)){
        if(s1.regno==regno){
            found=1;
        }
        else{
            fwrite(&s1,sizeof(student),1,fp1);
        }
    }
    fclose(fp);
    fclose(fp1);
    if(found){
        fp1 = fopen("/home/local/ZOHOCORP/gowtham-pt6112/Downloads/Library/delete.txt","r");
        fp = fopen("/home/local/ZOHOCORP/gowtham-pt6112/Downloads/Library/record.txt","w");
        while(fread(&s1,sizeof(student),1,fp1)){
            fwrite(&s1,sizeof(student),1,fp);
        }
        fclose(fp);
        fclose(fp1);
    }
}



///Difference between Days-------------///
int mon[12]={31,28,31,30,31,30,31,31,30,31,30,31};
int days(int y1,int y2,int m1,int m2,int d1,int d2){
    int count=0,i;
    for(i=y1;i<y2;i++){
        if(i%4==0)
            count+=366;
        else
            count+=365;
        }
    count-=month(m1,y1);
    count-=d1;
    count+=month(m2,y2);
    count+=d2;
    if(count<0)
        count=count*-1;
    return count;
}
int month(int a,int yy){
    int x=0,c;
    for(c=0;c<a-1;c++){
        if(c==1){
            if(yy%4==0)
                x+=29;
            else
                x+=28;
        }
        else{
            x+=mon[c];
        }
    }
    return(x);
}


/// Book is Already exist or not--------////
int existbook(int bookid){
    int found=0;
    books b1;
    FILE *fptr;
    fptr = fopen("/home/local/ZOHOCORP/gowtham-pt6112/Downloads/Library/bookrecord.txt","r");
    if(fptr==NULL){
        printf("Error While File opening");
        exit(1);
    }
    while(fread(&b1,sizeof(books),1,fptr)){
        if(b1.bid==bookid){
            found = 1;
        }
    }
    if(!found){
        return 1;
    }
    else{
        return 0;
    }
    fclose(fptr);
}
/// Register is Already exist or not-------////
int existregnum(int regnum){
    int found=0;
    student b1;
    FILE *fptr;
    fptr = fopen("/home/local/ZOHOCORP/gowtham-pt6112/Downloads/Library/record.txt","r");
    if(fptr==NULL){
        printf("Error While File opening");
        exit(1);
    }
    while(fread(&b1,sizeof(student),1,fptr)){
        if(b1.regno==regnum){
            found = 1;
        }
    }
    if(!found){
        return 1;
    }
    else{
        return 0;
    }
    fclose(fptr);
}
int taken(int bookid){
    int found=0;
    student b1;
    FILE *fptr;
    fptr = fopen("/home/local/ZOHOCORP/gowtham-pt6112/Downloads/Library/record.txt","r");
    if(fptr==NULL){
        printf("Error While File opening");
        exit(1);
    }
    while(fread(&b1,sizeof(student),1,fptr)){
        for(int j=0;j<3;j++){
            if(b1.book[j].bookid==bookid){
                found =1;
            }
        }
    }
    if(!found){
        return 1;
    }
    else{
        return 0;
    }
    fclose(fptr);
}

/// Add Book Details......//
void addbook(){
    int press,bookid;
    int i,day,mon,year;
    books *b1;
    FILE *fptr;
    b1 = (books*)calloc(1,sizeof(books));
    fptr = fopen("/home/local/ZOHOCORP/gowtham-pt6112/Downloads/Library/bookrecord.txt","a");
    if(fptr==NULL){
        printf("Error While opening File");
        exit(1);
    }
    for(i=0;i<1;i++){
        printf("\n###---------ADD BOOK----------###\n");
        printf("\nEnter Book ID            : ");
        scanf("%d",&bookid);
        if(existbook(bookid)==1){
            b1[i].bid = bookid;
            gets(b1->bug);
            printf("Enter Book Name          : ");
            gets(b1->bname);
            printf("Enter Author name        : ");
            gets(b1->author);
            redate:
            printf("Enter Date (DD-MM-YYYY)  : ");
            scanf("%d-%d-%d",&day,&mon,&year);
            if(datevalid(day,mon,year)==0){
                b1[i].stday = day;
                b1[i].stmon = mon;
                b1[i].styear = year;
            }
            else{
                printf("Enter Valid Date........\n");
                goto redate;
            }
            fwrite(&b1[i],sizeof(books),1,fptr);
            fclose(fptr);
            printf("\nBook data are inserted....");
            printf("\nIf you go for Back press 1 : ");
            scanf("%d",&press);
            if(press==1){
                bookrecord();
            }
        }else{
            system("clear");
            printf("\nBook Exists......\n");
            addbook();
        }
    }
}
/// Search Books.........//
void searchbook(){
    int press,bookid,found=0;
    char a[]="Book Id",b[]="Book Name",c[]="Author Name";
    printf("\n###---------Search Book---------###\n");
    printf("\nEnter Book ID : ");
    scanf("%d",&bookid);
    books b1;
    FILE *fptr;
    fptr = fopen("/home/local/ZOHOCORP/gowtham-pt6112/Downloads/Library/bookrecord.txt","r");
    while(fread(&b1,sizeof(books),1,fptr)){
        if(b1.bid==bookid){
            found = 1;
            printf("\n%-5s%15s%25s\n",a,b,c);
            printf("\n%-13d%-23s%-25s",b1.bid,b1.bname,b1.author);
        }
    }
    if(!found){
        printf("\nNo record Available......\n");
    }
    fclose(fptr);
    printf("\n\nIf you go for Back press 1 : ");
    scanf("%d",&press);
    if(press==1){
        bookrecord();
    }
}
/// View Books ..........//
void viewbook(){
    int press,found=0,count=0;
    char a[]="Book Id",b[]="Book Name",c[]="Author Name";
    printf("\n###---------Book Details---------###\n");
    books b1;
    FILE *fptr;
    fptr = fopen("/home/local/ZOHOCORP/gowtham-pt6112/Downloads/Library/bookrecord.txt","r");
    while(fread(&b1,sizeof(books),1,fptr)){
        found=1;
        if(count==0){
            printf("\n%-5s%15s%25s\n",a,b,c);
            count++;
        }
        printf("\n%-13d%-23s%-25s",b1.bid,b1.bname,b1.author);
    }
    if(!found){
        printf("\nNo record Available......");
    }
    fclose(fptr);
    printf("\n\nIf you go for Back press 1 : ");
    scanf("%d",&press);
    if(press==1){
        bookrecord();
    }
}
/// Delete Books.........//
void deletebook(){
    books s1;
    int found=0,bookid,press,p;
    char a[]="Book Id",b[]="Book Name",c[]="Author Name";
    FILE *fp,*fp1;
    printf("\n###--------Delete Book-----###\n");
    redelete:
    printf("\nEnter Book Id  : ");
    scanf("%d",&bookid);
    fp = fopen("/home/local/ZOHOCORP/gowtham-pt6112/Downloads/Library/bookrecord.txt","r");
    fp1 = fopen("/home/local/ZOHOCORP/gowtham-pt6112/Downloads/Library/deletebook.txt","w");
    while(fread(&s1,sizeof(books),1,fp)){
        if(s1.bid==bookid){
            printf("\n%-5s%15s%25s\n",a,b,c);
            printf("\n%-13d%-23s%-25s",s1.bid,s1.bname,s1.author);
            printf("\n\nIf you want to delete book......press 1\n");
            scanf("%d",&p);
            if(p==1){
                found=1;
            }
        }
        else{
            fwrite(&s1,sizeof(books),1,fp1);
        }
    }
    fclose(fp);
    fclose(fp1);
    if(found){
        fp1 = fopen("/home/local/ZOHOCORP/gowtham-pt6112/Downloads/Library/deletebook.txt","r");
        fp = fopen("/home/local/ZOHOCORP/gowtham-pt6112/Downloads/Library/bookrecord.txt","w");
        while(fread(&s1,sizeof(books),1,fp1)){
            fwrite(&s1,sizeof(books),1,fp);
        }
        fclose(fp);
        fclose(fp1);
    }else{
        printf("\nBook is not Available......\n");
        goto redelete;
    }
    printf("\nIf you go for Back press 1 : ");
    scanf("%d",&press);
    if(press==1){
        bookrecord();
    }
}




/// Book Issue ------------//
void bookissue(){
    student *s;
    int i,j,bookid,press,regnum,books[3];
    int day,mon,year;
    FILE *fptr;
    s = (student*)calloc(1,sizeof(student));
    fptr = fopen("/home/local/ZOHOCORP/gowtham-pt6112/Downloads/Library/record.txt","a");
    if(fptr==NULL){
        printf("Error While File opening");
        exit(1);
    }
    printf("\n###----------Book Issue-----------###\n");
    for (i=0;i<1;i++){
        gets(s->bug);
        printf("\nEnter Name         : ");
        gets(s->name);
        printf("Enter Reg No       : ");
        scanf("%d",&regnum);
        if(existregnum(regnum)==1){
            s->regno = regnum;
            gets(s->bug);
            printf("Enter Dept         : ");
            gets(s->dept);
            rebook:
            printf("Enter No.of Books  : ");
            scanf("%d",&s->noofbooks);
            if(s->noofbooks>0 && s->noofbooks<4){
                for(j=0;j<s->noofbooks;j++){
                    rebookid:
                    printf("Enter Book %d ID    : ",j+1);
                    scanf("%d",&bookid);
                    books[j]=bookid;
                    if(existbook(bookid)==0){
                        if(taken(bookid)==1){
                            if(j>0){
                                if(j>1){
                                    if(books[0]!=books[j]){
                                        s[i].book[j].bookid = bookid;
                                    }
                                    else{
                                        printf("\nBook ID 1 and %d are equal....",j+1);
                                        printf("\nRe Enter Book Id.......\n");
                                        goto rebookid;
                                    }
                                }

                                if(books[j-1]!=books[j]){
                                    s[i].book[j].bookid = bookid;
                                }
                                else{
                                    printf("\nBook ID %d and %d are equal....",j,j+1);
                                    printf("\nRe Enter Book Id.......\n");
                                    goto rebookid;

                                }
                            }
                            s[i].book[j].bookid = bookid;
                        }else{
                            printf("\nBook is already taken......\n");
                            printf("\nEnter Book ID.........\n");
                            goto rebookid;
                        }
                    }
                    else{
                        printf("\nEnter Valid Book Id..........\n");
                        goto rebookid;
                    }
                }
            }else{
                printf("Enter Between 1 to 3 .....\n");
                goto rebook;
            }

            redate:
            printf("Issue Date (DD-MM-YYYY)     : ");
            scanf("%d-%d-%d",&day,&mon,&year);
            if(datevalid(day,mon,year)==0){
                s[i].isday = day;
                s[i].ismon = mon;
                s[i].isyear = year;
            }
            else{
                printf("Enter Valid date..........\n");
                goto redate;
            }
            redate2:
            printf("Returning Date (DD-MM-YYYY) : ");
            scanf("%d-%d-%d",&day,&mon,&year);
            if(datevalid(day,mon,year)==0){
                s[i].reday = day;
                s[i].remon = mon;
                s[i].reyear = year;
            }
            else{
                printf("Enter Valid date..........\n");
                goto redate2;
            }
            fwrite(&s[i],sizeof(student),1,fptr);
            printf("\nBook are issued.......Keep Learning\n");
            fclose(fptr);
            printf("\nIf you go for Back press 1 : ");
            scanf("%d",&press);
            if(press==1){
                system("clear");
                home();
            }
        }
        else{
            system("clear");
            printf("\nReturn All book then your Collect New Books.......\n");
            read1(regnum);
            bookreturn();
        }
    }

}

/// Book Return -----------//
void bookreturn(){
    student s1;
    int regno,found=0;
    int day,mon,year,remain,amount=0;
    char a[]="Name",b[]="Dept",c[]="No.of.Books",d[]="Issued Date",e[]="Due Date",f[]="Delay",g[]="Due Amount";
    FILE *fpread;
    printf("\n###----------Book Return--------###\n");
    printf("\nEnter Reg No                 : ");
    scanf("%d",&regno);
    redate:
    printf("Enter Today Date(DD-MM-YYYY) : ");
    scanf("%d-%d-%d",&day,&mon,&year);
    fpread = fopen("/home/local/ZOHOCORP/gowtham-pt6112/Downloads/Library/record.txt","r");
    if(datevalid(day,mon,year)==0){
        while(fread(&s1,sizeof(student),1,fpread)){
            if(s1.regno==regno){
                found=1;
                printf("\n%5s%8s%15s%15s%10s%10s%5s\n",a,b,c,d,e,f,g);
                printf("\n%5s%5s%8d%14d-%d-%d%8d-%d-%d",s1.name,s1.dept,s1.noofbooks,s1.isday,s1.ismon,s1.isyear,s1.reday,s1.remon,s1.reyear);
                if(datevalid(day,mon,year)==0){
                    remain = days(s1.isyear,year,s1.ismon,mon,s1.isday,day);
                    if(s1.reday==day && s1.remon==mon && s1.reyear==year){
                        int x=0;
                        printf("%5d", x);
                        printf("%10d\n",amount);
                    }else{
                        if(remain>30){
                        printf("%5d",remain-31);
                        amount = (s1.noofbooks)*(remain-30)*5;
                        printf("%10d\n",amount);
                        }
                        else{
                            int x=0;
                            printf("%5d",x);
                            printf("%10d\n",amount);
                        }
                    }
                }
            }
        }
        int press;
        printf("\nPress 10 for return :  ");
        scanf("%d",&press);
        if(press==10){
            deteleitem(regno);
        }
        if(!found){
            printf("No Record Available......\n");
        }
    }else{
        printf("Enter Valid Today Date......\n");
        goto redate;
    }
    fclose(fpread);
}

/// Book Record -----------//
void bookrecord(){
    system("clear");
    int choice;
    printf("\n###-------Books Menubar------###\n");
    printf("\n1. Add Book\n2. Search Book\n3. View Book\n4. Delete Book\n5. Back\n");
    printf("\nEnter Your Choice : ");
    scanf("%d",&choice);
    switch(choice){
    case 1:
        system("clear");
        addbook();
        break;
    case 2:
        system("clear");
        searchbook();
        break;
    case 3:
        system("clear");
        viewbook();
        break;
    case 4:
        system("clear");
        deletebook();
        break;
    case 5:
        system("clear");
        home();
        break;
    }
}


/// Welcome Page-----------//
int welcome(){
    system("clear");
    printf("\n\n\n\n   ########################################################################");
    printf("\n   ############                                                   #########");
    printf("\n   ############      Library management System Project in C       #########");
    printf("\n   ############                                                   #########");
    printf("\n   ########################################################################");
    printf("\n   ------------------------------------------------------------------------\n");
    printf("\n\n\n Press 1 to continue.....");
    int press;
    scanf("%d",&press);
    return press;
}

/// Home Page -------------//
void home(){
    int choice;
    printf("\n1. Book Issue\n2. Book Return\n3. Book Record\n");
    printf("\nEnter Your Choice : ");
    scanf("%d",&choice);
    switch(choice){
    case 1:
        system("clear");
        bookissue();
        break;
    case 2:
        system("clear");
        bookreturn();
        break;
    case 3:
        system("clear");
        bookrecord();
        break;
    case 4:
        system("clear");
        read();
        break;
    default:
        printf("\nInvalid Input");
        break;
    }
}


/// Main Function ---------//
int main(){
    if(welcome()==1){
        system("clear");
        home();
    }
    return 0;
}