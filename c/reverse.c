#include <stdio.h>

void swap(char* c1, char* c2){
  char tmp = *c2;
  *c2 = *c1;
  *c1 = tmp;
} //end swap

void reversewithswap(char* str){
  char* end = str;
  //str is a ptr to the beginning of string, end is a ptr to end of string

  if(str){
    while(*end){
      ++end;
    }
    --end;

    while(str < end){     
      swap(str, end);

      //don't forget to increment/decrement points
      str++;
      end--;
    }
  }
} //end reversewithswap

void reverse(char* str){
  char* end = str;
  char tmp;

  if (str){
    while(*end){
      ++end;
    }
    --end;

    //the above works, but not the below, WHY?!?!
    /*
    while(*end){
      end++;
    }
    */

    while(str < end){
      tmp = *str;
      *str++ = *end;
      *end-- = tmp;
    }
  }
} //end reverse

void main(){


  //char* myStr = "The quick brown fox jumps over the lazy dog.";
  //THE ABOVE IS A DUMB MISTAKE, YOU ONLY ALLOCATE 1 POINTER TO A STRING

  //THE BELOW IS THE WAY TO DECLARE A C-STRING
  char myStr[] = "The quick brown fox jumps over the lazy dog.";


  printf("original:\n%s\n\n", myStr);
  reverse(myStr);
  printf("reverse:\n%s\n\n", myStr);
  reversewithswap(myStr);
  printf("reverse with swap:\n%s\n\n", myStr);
}
