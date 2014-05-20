public class ID4{
  private static final int MAX = 998001; //999 * 999 = 998001

  private int a, b;

  private static boolean isPalindrome(int n){
    String s = Integer.toString(n);
    int i=0, N = s.length()-1;

    while( i <= N/2 ){
      if(s.charAt(i) != s.charAt(N-i)){
        return false;
      }
      i++;
    }
    return true;
  }

  private static int findLargestPal(){
    int n = MAX;
    
    while( n>0 ){
      if(isPalindrome(n)){
        return n;
      }
      n--;
    }
    return -1;
  }

  private static int findNums(int n){


  }

  public static void main(String args[]){
    //System.out.println("isPal: " + isPalindrome(0));
    //System.out.println("isPal: " + isPalindrome(123));
    //System.out.println("isPal: " + isPalindrome(123321));
    //System.out.println("isPal: " + isPalindrome(1235321));
    //System.out.println("isPal: " + isPalindrome(12354321));

    //System.out.println("largest pal: " + findLargestPal());



  }

}
