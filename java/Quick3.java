public class Quick3{
  public static void sort(Comparable a[]){
    shuffle(a);
    sort(a, 0, a.length-1);
  }

  public static void sort2(Comparable a[]){
    shuffle(a);
    sort2(a, 0, a.length-1);
  }

  private static void sort(Comparable[] a, int lo, int hi){
    if( hi <= lo) return;

    int lt=lo, gt=hi;
    Comparable v = a[lo];
    int i=lo;

    while(i <= gt){
      int cmp = a[i].compareTo(v);
      
      if      (cmp < 0)   exch(a, i++, lt++);
      else if (cmp > 0)   exch(a, i  , gt--);
      else                i++;
    }
    sort(a, lo, lt-1);
    sort(a, gt+1, hi);
  }//end sort

  private static void sort2(Comparable[] a, int lo, int hi){
    if( hi <= lo) return;

    int lt=lo, gt=hi;
    int i=lo;

    while(i <= gt){
      int cmp = a[i].compareTo(a[lo]);
      
      if      (cmp < 0)   exch(a, i++, lt++);
      else if (cmp > 0)   exch(a, i  , gt--);
      else                i++;
    }
    sort(a, lo, lt-1);
    sort(a, gt+1, hi);
  }//end sort2

  private static void shuffle(Object[] a){
    int idx, N = a.length;
    for(int i=0; i<N; i++){
      idx = i + (int)Math.random()*(N-i);
      exch(a, i, idx);
    }
  }//end shuffle

  private static boolean less(Comparable a, Comparable b){
    return a.compareTo(b) < 0;
  }//end less

  private static void  exch(Object[] a, int i, int j){
    Object tmp  = a[i];
    a[i]        = a[j];
    a[j]        = tmp ;
  }//end exch



  //driver to test Quick3 functionality
  public static void main(String args[]){
    int N = 1000;

    Integer[] array = new Integer[N];
    Integer[] array2 = new Integer[N];

    for(int i=0; i<N; i++){
      array[i] = Integer.valueOf( (int)(Math.random()*(N)) );
      array2[i] = array[i];
    }

    /*
    System.out.println("Orig Array: ");
    for(int i=0; i<N; i++){
      System.out.print(array[i]+" ");
    }
    */

    Quick3.sort(array);
    Quick3.sort2(array2);

    /*
    for(int i=0; i<N; i++){
      if(array[i] != array2[i]){
        System.out.println("Different!");
        return;
      }
    }
    */

    /*
    System.out.println("\n\n\n");
    */

    System.out.println("Sort Array: ");
    for(int i=0; i<N; i++){
      System.out.println(array[i]+" "+array2[i]);
    }

  }//end main

}//end Quick3
