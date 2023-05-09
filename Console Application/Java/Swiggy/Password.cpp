#include <jni.h>        
#include<iostream>
#include "swiggy_Validation.h"

char getch(){
  char c; // This function should return the keystroke without allowing it to echo on screen

  system("stty raw");    // Raw input - wait for only a single keystroke
  system("stty -echo");  // Echo off
  c = getchar();
  system("stty cooked"); // Cooked input - reset
  system("stty echo");   // Echo on - Reset
  return c;
}

JNIEXPORT jstring JNICALL Java_swiggy_Validation_password(JNIEnv *env, jobject thisObj){
  char ch;
    std::string pass="";
    printf("\n\n\t\t\t Password      : ");
    int i=0;
    while(i!=100){
        ch = getch();
        if(ch == 13){
          break;
        }
        else if(ch== 127){
          pass.pop_back();
          if(i!=0)
            i-=1;
        }
        else{
          pass+=ch;
          ch = '*' ;
          i+=1;
          printf("%c", ch);
        }

    }
    return (env)->NewStringUTF(pass.c_str());
}

// gcc -fPIC -I"$JAVA_HOME/include" -I"$JAVA_HOME/include/linux" -shared -o libregister.so Password.cpp