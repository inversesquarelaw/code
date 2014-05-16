#include <stdio.h>

void rev(char* b, char* e){
  char tmp;
  while(b < e){
    tmp = *b;
    *b++ = *e;
    *e-- = tmp;
  }
}

void revword(char* str){
  char* end = str;
  char tmp;

  if(str){              //string is not null
    while(*end != ' '){    //while end has not found space char
      printf("chars: %c \n", *end);
      ++end;
    }
    --end;

    //rev word
    rev(str, end);
    //printf("rev: %s\n\n", str);

    //skip all space chars
    while(*end == ' '){
      ++end;
    }
    ++end;

    //reset ptr for next word
    str = end;
    //printf("str: %c\n\n", *str);
    //++str;
    //printf("str: %c\n\n", *str);
    //++str;
    //printf("str: %c\n\n", *str);
  }
}

void main(){

  char myStr[] = "123456789 The quick brown fox jumps over the lazy dog.";

  printf("original: %s\n\n", myStr);
  revword(myStr);
  printf("reverse words: %s\n\n", myStr);
}
