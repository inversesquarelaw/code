import java.util.Iterator;
import java.util.NoSuchElementException;

public class LListArrayTest{
  //driver/tester program
  public static void main(String args[]){
    LListArray<Integer> ll = new LListArray<>();
    int N = 5;

    int tmp;
    boolean tmp2;

    System.out.print("Current items using iterator: \n");
    System.out.print("List: [ ");
    for(Integer someInt: ll){
      System.out.print(someInt + " ");
    }
    System.out.print("]\n\n");

    System.out.println("Creating new list");
    System.out.print(ll.toString());

    for(int i=0; i<N; i++){
      ll.insertHead(100+i);
    }
    System.out.println("Inserting before head");
    System.out.print(ll.toString());

    System.out.print("Current items using iterator: \n");
    System.out.print("List: [ ");
    for(Integer someInt: ll){
      System.out.print(someInt + " ");
    }
    System.out.print("]\n\n");

    for(int i=0; i<N; i++){
      System.out.println("Inserting after tail");
      System.out.print(ll.toString());
      ll.insertTail(200+i);
    }
    System.out.print(ll.toString());

    ll.insert(999, ll.size()/2);
    System.out.println("Inserting at "+ ll.size()/2);
    System.out.print(ll.toString());

    ll.insert(888, ll.size()/2);
    System.out.println("Inserting at "+ ll.size()/2);
    System.out.print(ll.toString());

    ll.insert(777, ll.size()/2);
    System.out.println("Inserting at "+ ll.size()/2);
    System.out.print(ll.toString());

    ll.insert(666, ll.size());
    System.out.println("Inserting at "+ ll.size());
    System.out.print(ll.toString());

    for(int i=0; i<4; i++){
      System.out.println("Inserting after tail");
      System.out.print(ll.toString());
      ll.insertTail(300+i);
    }
    System.out.print(ll.toString());

    System.out.print("Current items using iterator: \n");
    System.out.print("List: [ ");
    for(Integer someInt: ll){
      System.out.print(someInt + " ");
    }
    System.out.print("]\n\n");

    System.out.println("Removing 303");
    tmp2 = ll.removeElmt(303);
    System.out.println("Removed: "+tmp2);
    System.out.print(ll.toString());

    System.out.println("Removing 999");
    tmp2 = ll.removeElmt(999);
    System.out.println("Removed: "+tmp2);
    System.out.print(ll.toString());

    System.out.println("Removing 888");
    tmp2 = ll.removeElmt(888);
    System.out.println("Removed: "+tmp2);
    System.out.print(ll.toString());

    System.out.println("Removing 104");
    tmp2 = ll.removeElmt(104);
    System.out.println("Removed: "+tmp2);
    System.out.print(ll.toString());

    System.out.println("Removing 302");
    tmp2 = ll.removeElmt(302);
    System.out.println("Removed: "+tmp2);
    System.out.print(ll.toString());

    tmp = ll.removeTail();
    System.out.println("Removing "+ tmp);
    System.out.print(ll.toString());

    tmp = ll.removeHead();
    System.out.println("Removing "+ tmp);
    System.out.print(ll.toString());

    System.out.print("Current items using iterator: \n");
    System.out.print("List: [ ");
    for(Integer someInt: ll){
      System.out.print(someInt + " ");
    }
    System.out.print("]\n\n");

    tmp = ll.remove(ll.size()/2);
    System.out.println("Removing "+ tmp + " at index "+ ll.size()/2);
    System.out.print(ll.toString());

    while(!ll.isEmpty()){
      tmp = ll.remove(0);
      System.out.println("Removing head");
      System.out.print(ll.toString());
    }

    System.out.print("Current items using iterator: \n");
    System.out.print("List: [ ");
    for(Integer someInt: ll){
      System.out.print(someInt + " ");
    }
    System.out.print("]\n\n");
  }//end driver tester
}//end LListArrayTest

class LListArray<Item> implements Iterable<Item>{
  private Item[] a;
  private int    N;

  @SuppressWarnings("unchecked")
  public LListArray(int cap){
    N = 0;
    a = (Item[]) new Object[cap];  //I have to do this ugly cast to create array
  }

  public LListArray(){
    this(1);
  }

  public void insertHead(Item d){
    insert(d, 0);
  }

  public void insertTail(Item d){
    insert(d, N); //N is usually 1 less than a.length
  }
  
  public boolean insert(Item data, int pos){
    if( pos < 0 || pos > N ) throw new NoSuchElementException();
    if( N >= a.length ) resize(2*a.length);
    
    for(int i=N; i>pos; i--){
      a[i] = a[i-1];
    }
    a[pos] = data;
    N++;
    return true;
  }//end insert

  public Item removeHead(){
    return remove(0);
  }

  public Item removeTail(){
    return remove(N-1);
  }

  public Item remove(int pos){      //looks for index and removes element at idx
    if( pos < 0 || pos > N-1 ) throw new NoSuchElementException();
    if(isEmpty()) throw new NoSuchElementException(); //or throw some Exception

    Item data = a[pos];
    for(int i=pos; i<N-1; i++){
      a[i] = a[i+1];
    }
    N--;

    if( N > 0 && N == a.length/4 ) resize(a.length/2);
    return data;
  }//end remove

  public boolean removeElmt(Item data){    //looks for element then removes it
    boolean removed = false;

    if(isEmpty()) return removed;

    for(int i=0; i<N; i++){
      if( a[i].equals(data) ){
        removed = true;
      }
      if( removed == true && i<N-1 ){
        a[i] = a[i+1];
      }
    }
    N--;
    a[N] = null;

    if( N > 0 && N == a.length/4 ) resize(a.length/2);
    return removed;
  }//end removeElmt

  public Item get(int pos){
    return a[pos];
  }
  
  public int getIdx(Item d){
    int idx = -1;

    for(int i=0; i<N; i++){
      if( a[i].equals(d) ){
        idx = i;
        break;
      }
    }

    return idx;
  }

  public Iterator<Item> iterator(){
    return new ListArrayIterator();
  }

  private class ListArrayIterator implements Iterator<Item>{
    private int i = 0;

    public void remove()      {                 }

    public boolean hasNext()  { return i < N;   }

    public Item next()        { return a[i++];  }
  }

  public String toString(){
    StringBuilder str = new StringBuilder();
    str.append("List: [ ");
    for(int i=0; i<N; i++){
      str.append(a[i]+ " ");
    }
    str.append("]\n");
    str.append("Size/N: " + size() +"\n");
    str.append("a.length: " + a.length +"\n");
    str.append("Empty: " + isEmpty() +"\n\n");
    return str.toString();
  }

  @SuppressWarnings("unchecked")
    private void resize(int cap){
      Item[] biggerArray = (Item[]) new Object[cap];
      for(int i=0; i<N; i++){
        biggerArray[i] = a[i];
      }
      a = biggerArray;
    }

  public boolean isEmpty(){ return N==0; }
  public int size(){ return N; }

}//end class LListArray
