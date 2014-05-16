import java.lang.Exception;
import java.util.NoSuchElementException;

public class LListNodeTest{

  public static void main(String args[]){
    LinkedList<Integer> ll = new LinkedList<>();
    int N = 10;

    for(int i=0; i<N; i++){
      ll.addHead(i);
    }
    System.out.print(ll.toString());

    System.out.println("List is empty: " + ll.isEmpty()+"\n");

    System.out.println("Removing nodes from tail...\n");
    for(int i=0; i<N+1; i++){
      try{
        ll.removeTail();
      } catch (Exception e){
        System.out.println(e);
      }
      //System.out.print(ll.toString());
      //System.out.println();
    }

    System.out.print(ll.toString());
    System.out.println("List is empty: " + ll.isEmpty()+"\n");

    for(int i=100; i<100+N; i++){
      ll.addTail(i);
    }
    System.out.print(ll.toString());
    System.out.println("List is empty: " + ll.isEmpty()+"\n");

    System.out.println("Removing nodes from head...\n");
    for(int i=0; i<N; i++){
      ll.removeHead();
    }
    System.out.print(ll.toString());
    System.out.println("List is empty: " + ll.isEmpty()+"\n");

    for(int i=100; i<100+N; i++){
      ll.addTail(i);
    }
    System.out.print(ll.toString());
    System.out.println("List is empty: " + ll.isEmpty()+"\n");

    System.out.println("Removed node: " + ll.remove(105).data);
    System.out.print(ll.toString());
    System.out.println("List is empty: " + ll.isEmpty()+"\n");

    System.out.println("Removed node: " + ll.remove(100).data);
    System.out.print(ll.toString());
    System.out.println("List is empty: " + ll.isEmpty()+"\n");

    /*
    LinkedList.deleteNode(ll.head, 109);
    System.out.print(ll.toString());
    System.out.println("List is empty: " + ll.isEmpty()+"\n");
    */

    for(int i=110; i>0; i--){
      if(!ll.isEmpty()){
        Node tmp = ll.remove(i);
        if(tmp != null){
          System.out.println("Removed node: " + tmp.data);
          System.out.print(ll.toString());
          System.out.println("List is empty: " + ll.isEmpty()+"\n");
        }
      }
    }

    for(int i=100; i<100+N; i++){
      ll.addTail(i);
    }
    System.out.print(ll.toString());
    System.out.println("List is empty: " + ll.isEmpty()+"\n");

    System.out.println("Removed node: " + ll.remove(104).data);
    System.out.print(ll.toString());
    System.out.println("List is empty: " + ll.isEmpty()+"\n");

    for(int i=100; i<100+N; i+=2){  //testing just the even-numbered elements
      if(!ll.isEmpty()){
        Node tmp = ll.remove(i);
        if(tmp != null){
          System.out.println("Removed node: " + tmp.data);
          System.out.print(ll.toString());
          System.out.println("List is empty: " + ll.isEmpty()+"\n");
        }
      }
    }

    for(int i=101; i<100+N; i+=2){  //testing just the odd-numbered elements
      if(!ll.isEmpty()){
        Node tmp = ll.remove(i);
        if(tmp != null){
          System.out.println("Removed node: " + tmp.data);
          System.out.print(ll.toString());
          System.out.println("List is empty: " + ll.isEmpty()+"\n");
        }
      }
    }

    for(int i=100; i<100+N; i++){
      ll.addTail(i);
    }
    System.out.print(ll.toString());
    System.out.println("List is empty: " + ll.isEmpty()+"\n");

    ll.add(-1,0);
    System.out.print(ll.toString());
    System.out.println("List is empty: " + ll.isEmpty()+"\n");

    ll.add(-1,N);
    System.out.print(ll.toString());
    System.out.println("List is empty: " + ll.isEmpty()+"\n");
  }
}




class Node<Item>{
  Item data;
  Node<Item> next;
}//end class Node




class LinkedList<Item>{
  Node<Item> head;
  int count;

  public void addHead(Item d){      //this adds to beginning of list
    Node<Item> oldHead = head;
    head = new Node<Item>();
    head.data = d;
    head.next = oldHead;

    count++;
  }//end addHead

  public void addTail(Item d){
    Node<Item> newNode = new Node<>();
    newNode.data = d;

    if(isEmpty()){
      head = newNode;
    } else {
      Node<Item> cur = head;
      while(cur.next != null){
        cur = cur.next;
      }
      cur.next = newNode;
    }

    count++;
  }//end addTail

  public Node<Item> removeTail() throws Exception{
    Node<Item> removedNode;
    Node<Item> cur = head;

    if(isEmpty())        throw new NoSuchElementException("List is empty!"); 
    
    if(head.next == null){             //cases where only 1 elemt in list
      removedNode = head;
      head = null;
    }
    else {
      while(cur.next.next != null){     //loop until find last node
        cur = cur.next;                 //increment
      }
      removedNode = cur.next;            //assign last node to be removed
      cur.next = null;                  //remove the last node
    }

    count--;
    return removedNode;
  }//end removeTail

  public Node<Item> removeHead(){
    Node<Item> removedNode = head;

    if(head.next == null){        //only 1 element in list
      head = null;
    } else {
      head = head.next;
    }

    count--;
    return removedNode;
  }//end removeHead

  //add Item d to a position in list, 0 is 1st position, n-1 is last position.
  public void add(Item d, int pos){      
    //adds after pos, so if pos == 0, it'll add after the head
    Node<Item> newNode = new Node<>();
    newNode.data = d;

    Node<Item> cur = head;

    if(isEmpty()){
      head = newNode;
    }

    int i = 0;
    while( i < pos ){
      cur = cur.next;
      i++;
    }
    newNode.next = cur.next;
    cur.next = newNode;

    count++;
  }//end add

  public Node<Item> remove(Item d){   //remove a specific element in list, if there are duplicates, then it removes the first encounter
    Node<Item> removedNode = null;
    Node<Item> prev = null;

    if(isEmpty()) throw new NoSuchElementException("List is empty!");

    if(head.data == d){             //Item d is at first element in list
      removedNode = head;
      head = head.next;
      
      count--;
      return removedNode;
    }

    removedNode = head;
    while(removedNode.next != null){        //Item d is in the middle of list
      if(removedNode.next.data == d){
        prev = removedNode;
        removedNode = removedNode.next;
        prev.next = removedNode.next;   //delete the next node

        count--;
        return removedNode;
      }
      prev = removedNode;
      removedNode = removedNode.next;
    }

    //if we get to this part of the code, we have looked at all elements of list except the last element
    if(removedNode.data == d){              //Item d is at last element in list
      prev.next = null;

      count--;
      return removedNode;
    }

    return null; //that element is not in the list
    
  }

  /*
  //this version doesn't delete last node
  public static void deleteNode(Node head, int d) {  //crack code version of del
    Node n = head;
    if (n.data == d) {
      head = head.next;
    }
    while (n.next != null) {
      if (n.next.data == d) {
        n.next = n.next.next;
      }
      n = n.next;
    }
  }
  */


  public String toString(){
    StringBuilder str = new StringBuilder();
    str.append("\nList elements: ");

    Node<Item> cur = head;
    while(cur != null){
      str.append(cur.data + " ");
      cur = cur.next;
    }
    str.append("\n# of nodes: " + size()+"\n");

    return str.toString();
  }//end print

  public int size(){ return count; }
  public boolean isEmpty(){ return head==null; }
}//end class LinkedList
