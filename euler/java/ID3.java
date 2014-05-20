import java.util.ArrayList;
import java.util.List;

//TODO replace long with BigInteger (it can handle bigger nums than long)
public class ID3{
  private static List<Long> factors;
  private static long max;

  private static void findPrimes(long n){
    factors = new ArrayList<Long>();

    for(long i=2; i<=n; i++){
      while(n%i == 0){
        factors.add(i);
        n /= i;
      }
    }
  }

  private static void findMax(){
    max = factors.get(0);
    for(int i=1; i<factors.size(); i++){
      if(factors.get(i) > max){
        max = factors.get(i);
      }
    }
  }

  private static void print(){
    for(int i=0; i<factors.size(); i++){
      System.out.print(factors.get(i) + " ");
    }
    System.out.println();
  }

  public static void main(String args[]){
    findPrimes(13195L);
    print();
    findMax();
    System.out.println("max: " + max);

    findPrimes(600851475143L);
    print();
    findMax();
    System.out.println("max: " + max);
  }
}
