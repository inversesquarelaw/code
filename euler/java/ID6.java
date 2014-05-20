public class ID6{

  private static int sumOfSquares(int max){
    int sum = 0;
    for(int i=1; i <= max; i++){
      sum += i*i;
    }
    return sum;
  }

  private static int squareOfSums(int max){
    int sum = 0;
    //if you want to be smart, you can use Euler's summation formula
    //which is implemented in squareOfSumsEuler
    for(int i=1; i <= max; i++){
      sum += i;
    }
    return sum * sum;
  }

  private static int squareOfSumsEuler(int n){
    int euler = (n*(n+1))/2;
    return euler*euler;
  }
  
  //there is an identity for the sum of the first n^2 numbers
  private static int sumOfSquaresIdentity(int n){
    return (n*(n+1)*(2*n+1))/6;
  }

  public static void main(String args[]){
    int a, b, c, d, diff;

    //a = squareOfSums(10);
    //b = sumOfSquares(10);

    a = squareOfSums(100);
    b = sumOfSquares(100);
    c = squareOfSumsEuler(100);
    d = sumOfSquaresIdentity(100);

    System.out.println("a: " + a);
    System.out.println("b: " + b);
    System.out.println("c: " + c);
    System.out.println("d: " + d);

    diff  = a - b;
    System.out.println("difference: " + diff);

    diff = c - d;
    System.out.println("difference: " + diff);
  }
}
