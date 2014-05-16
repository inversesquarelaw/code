public class LinkedListTest{

  public static void main(String args[]){
    int N = 28;
    LinkedList<Integer> ll = new LinkedList<Integer>();
    Node<Integer> cur = ll.head;


    for(int i=0; i<N; i++){
      ll.addTail(i);
    }

    ll.print();

    for(int i=11; i<N; i++){
      ll.head = ll.deleteNode(ll.head, i);
      ll.print();
    }

  }
}

class Node<Item>{
  Item data;
  Node<Item> next;
  Node<Item> prev;

  public Node(){
    next = null;
  }

  public Node(Item d){
    this.data = d;
  }
}//end class Node

class LinkedList<Item>{
  protected Node<Item> head, tail;
  protected int count;

  public LinkedList(){
    head = tail = null;
    count = 0;
  }

  public int size(){
    return count;
  }

  public boolean isEmpty(){
    return (count == 0);
  }

  public void addTail(Item data) {
    Node<Item> newNode = new Node<Item>(data);
    
    if(head == null){           //adding first node to ll
      head = newNode;
      tail = head;
      head.next = tail;
    } else {                    //adding subsequent nodes
      tail.next = newNode;
      tail = tail.next;
    }
    count++;
  }//end addTail

  public void addHead(Item data){
    Node<Item> oldHead = head;
    head = new Node<Item>(data);
    head.next = oldHead;
    if(tail == null){
      tail = head;
    }
    count++;
  }//end addHead

  public void print(){
    Node<Item> cur = head;
    while(cur != null){
      System.out.print(cur.data + " ");
      cur = cur.next;
    }
    System.out.println();
  }//end print()

  public Node<Item> deleteNode(Node<Item> h, Item d) {
    Node<Item> cur = h;
    if (cur.data == d) {
      return h.next; // moved head
    }
    while (cur.next != null) {
      if (cur.next.data == d) {
        cur.next = cur.next.next;
        return h; // head didn’t change
      }
      cur = cur.next;
    }
    count--;
    return h;
  }//end deleteNode


}//end class LinkedList
