#include <stdio.h>

void reverse(char* str){
  if(*(str+1) != '\0'){     //if next char is not the '\0' (NULL), then recurse
    //some subtle diff between '\0' and NULL
    reverse(str+1);
  }
  printf("%c", *str);
}

int main(){
  char myStr[] = 
  "   01234566789 The   quick  brown fox   jumps over the lazy dog.";

  printf("orig:\n%s\n", myStr);

  printf("reverse:\n");
  reverse(myStr);
  printf("\n");

}
