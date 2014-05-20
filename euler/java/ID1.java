public class Mult3and5{

  //finds the sum of all the multiples of 3 or 5
  public static int findSum(int max){
    int tmp = 0;

    for(int i=3; i<max; i++){
      if(i%3 == 0 || i%5 == 0){
        tmp += i;
      }
    }

    return tmp;
  }


  public static void main(String args[]){
    int sum = 0;

    //If we list all the natural numbers below 10 that are multiples of 3 or 5, 
    //we get 3, 5, 6 and 9. The sum of these multiples is 23.
    sum = Mult3and5.findSum(10);
    System.out.println("sum: "+sum);

    //find the sum of multipes of 3 or 5 below 1000.
    sum = Mult3and5.findSum(1000);
    System.out.println("sum: "+sum);

  }

}
