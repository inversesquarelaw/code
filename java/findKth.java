
public class findKth{

  private class Node{
    int data;
    Node next;

    public Node(int d){
      this.data = d;
    }
  }

  public static Node findkth (Node head, int count, int k) {
    if(head == null)
      return head;
    else {
      Node n = findKth(head.next,count,k);
      count++;

      if(count == k)
        return head;

      return n;
    }
  }

  public static void main(String args[]){
    Node ll = new Node(i);
  }

}
