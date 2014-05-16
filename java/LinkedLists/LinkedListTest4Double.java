public class LinkedListTest4Double{
  public static void main(String args[]){
    LinkedList<String> ll = new LinkedList<>();

    try{
      ll.removeFirst();
    }
    catch (Exception e){
      System.out.println(e);
    }
    System.out.println(ll.toString());

    ll.addBeforeFirst("dog");
    System.out.println(ll.toString());

    ll.addBeforeFirst("baz");
    System.out.println(ll.toString());

    ll.addBeforeFirst("cat");
    System.out.println(ll.toString());

    ll.addAfterLast("foo");
    System.out.println(ll.toString());

    ll.addAfterLast("bar");
    System.out.println(ll.toString());

    /*
    //removeLast isn't working yet
    try{
      while(!ll.isEmpty()){
        System.out.println("Removing node: " + ll.removeLast().data +"\n");
        System.out.println(ll.toString());
      }
    }
    catch (Exception e){
      System.out.println(e);
    }
    */


  }
}

class Node<AnyType>{
  AnyType data;
  Node<AnyType> next;
  Node<AnyType> prev;
}

class LinkedList<AnyType>{
  Node<AnyType> head;
  int count;

  public LinkedList(){
    head = null;
    count = 0;
  }

  public void addBeforeFirst(AnyType val){
    Node<AnyType> newHead = new Node<>();
    newHead.data = val;

    if(isEmpty()){
      head = newHead;
    }
    else {
      Node<AnyType> oldHead = head;
      head = newHead;
      newHead.next = oldHead;

      oldHead.prev = newHead;
      newHead.prev = null;
    }

    count++;

  }//addBeforeHead

  public Node<AnyType> removeFirst() throws Exception{
    Node<AnyType> removeNode = null;

    if(isEmpty()){
      throw new Exception("No nodes to remove from empty list!");
    }

    removeNode = head;         //assign node to be removed

    if(head.next == null){     //only 1 element in list
      head = null;
    }
    else{                       //more than 1 element, so skip to next element
      head = head.next;
    }

    count--;
    return removeNode;
  }//end removeHead

  public void addAfterLast(AnyType val){
    Node<AnyType> newNode = new Node<>();
    newNode.data = val;
    Node<AnyType> curr = null;

    if(isEmpty()){//when you call isEmpty, am i implicitly calling this.isEmpty?
      head = newNode;
    }
    else{
      curr = head;
      while(curr.next != null){
        curr = curr.next;
      }
      curr.next = newNode;
    }

    count++;
  }//end addAfterTail

  public Node<AnyType> removeLast() throws Exception{
    Node<AnyType> removeNode = null;
    Node<AnyType> curr = head;

    if(isEmpty()){
      throw new Exception("No nodes to remove from empty list!");
    }

    while(curr.next != null){
      curr = curr.next;
    }
    removeNode = curr;

    count--;
    return removeNode;
  }


  public String toString(){
    StringBuilder str = new StringBuilder();
    Node<AnyType> curr = head;

    str.append("List: ");
    while(curr != null){
      str.append(curr.data + " ");
      curr = curr.next;
    }
    str.append("\n");
    str.append("Size: " + size() + "\n");
    str.append("Empty: " + isEmpty() + "\n");

    return str.toString();
  }

  public int size(){ return count; }
  public boolean isEmpty(){ return head == null; }

}
