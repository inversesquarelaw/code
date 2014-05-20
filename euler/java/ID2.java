import java.util.Vector;

public class ID2{
  private static Vector<Integer> fib = new Vector<>();
  private static boolean isEven(int n){ return n%2 == 0; }

  private static final int MAX = 4000000;
  private static int N = 2;


  public static void createFib(int max){
    fib.add(0,1);
    fib.add(1,2);

    int tmp = 0;

    while(fib.elementAt(N-1) + fib.elementAt(N-2) < max){
      tmp = fib.elementAt(N-1) + fib.elementAt(N-2);
      fib.add(N,tmp);
      N++;
    }
  }

  public static int findSum(){
    int sum = 0;
    for(int i=0; i<fib.size(); i++){
      if(isEven(fib.elementAt(i))){
        sum += fib.elementAt(i);
      }
    }
    return sum;
  }

  public static void main(String args[]){
    createFib(MAX);
    //System.out.println(fib.elementAt(31));

    System.out.println( findSum() );

  }
}
