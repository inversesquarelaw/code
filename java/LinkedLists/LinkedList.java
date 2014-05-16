/**
 ******************************************************************************
 *                      15-111
 ******************************************************************************
 * Recursive implementations of some basic LinkedList operations
 *
 *
 *****************************************************************************/

import java.util.*;

public class LinkedList<AnyType>
{
	private Node<AnyType> head;

 /**
	*  Constructs an empty list
	*/
	public LinkedList()
	{
		head = null;
	}
 /**
   *  Returns true if the list is empty
   *
   */
   public boolean isEmpty()
   {
      return head == null;
   }
 /**
   *  Inserts a new node at the beginning of this list.
   *
   */
	public void addFirst(AnyType item)
	{
		head = new Node<AnyType>(item, head);
	}
 /**
   *  Returns the first element in the list.
   *
   */
	public AnyType getFirst()
	{
		if(head == null) throw new NoSuchElementException();

		return head.data;
	}
 /**
   *  Removes the first element in the list.
   *
   */
	public AnyType removeFirst()
	{
		AnyType tmp = getFirst();
		head = head.next;
		return tmp;
	}
 /**
   *  Recursively inserts a new node to the end of this list.
   *
   */
	public void addLast(AnyType item)
	{
		if( head == null)
			addFirst(item);
		else
			addLast(head, item);
	}
	private void addLast(Node<AnyType> node, AnyType item)
	{
		if(node.next != null) addLast(node.next, item);
		else
			node.next = new Node<AnyType>(item, null);
	}
 /**
   *  Returns a string representation
   *
   */
   public String toString()
   {
      return toString(head);
   }
   private String toString(Node node)
   {
      if(node == null) return "";
      else
      	return node.data + " " + toString(node.next);
   }
 /**
   *  Recursively inserts a new node after a node containing the key.
   *
   */
   public void insertAfter(AnyType key, AnyType toInsert)
   {
      insertAfter(head, key, toInsert);
   }

   public void insertAfter(Node<AnyType> node, AnyType key, AnyType toInsert)
   {
      if(node == null)
         return;
      else
      if(node.data.equals(key))
         node.next = new Node<AnyType>(toInsert, node.next);
      else
         insertAfter(node.next, key, toInsert);
   }
 /**
   *  Recursively inserts a new node before a node containing the key.
   *
   */
   public void insertBefore(AnyType key, AnyType toInsert)
   {
      head = insertBefore(head, key, toInsert);
   }

   public Node<AnyType> insertBefore(Node<AnyType> node, AnyType key, AnyType toInsert)
   {
      if(node == null)
         return null;
      else
      if(node.data.equals(key))
         return new Node<AnyType>(toInsert, node);
      else
         node.next = insertBefore(node.next, key, toInsert);

      return node;
   }
 /**
   *  Recursively deletes the first occurrence of an item.
   *
   */
   public void delete(AnyType x)
   {
      head = delete(head, x);
   }
   private Node<AnyType> delete(Node<AnyType> node, AnyType x)
   {
      if (node == null)
         throw new java.util.NoSuchElementException("cannot delete.");
      else
      if(node.data.equals(x))
         return node.next;
      else
         node.next = delete(node.next, x);

      return node;
   }
 /**
   *  Recursively deletes a node at specified index
   *
   */
   public void deleteAt(int p)
   {
      head = deleteAt(p, head);
   }
   public Node<AnyType> deleteAt(int p, Node<AnyType> node)
   {
      if(node == null)
         throw new java.util.NoSuchElementException("cannot delete.");
      else
      if(p == 0)
         return node.next;
      else
         node.next = deleteAt(p-1, node.next);

      return node;
   }

 /**
   *  Creates a deep copy
   *
   */
	public LinkedList<AnyType> clone()
	{
		LinkedList<AnyType> twin = new LinkedList<AnyType>();
		twin.head = cloneR(head);
		return twin;
	}
	private Node<AnyType> cloneR(Node<AnyType> p)
	{
		if(p == null)
			return null;
		else
			return new Node<AnyType>(p.data, cloneR(p.next) );
	}

 /**
   * Removes all nodes greater than keyItem
   *
   */
	public void removeAllGreaterItems(Comparable<AnyType> keyItem)
	{
		head = removeAllGreaterItems(head, keyItem);
	}
	private Node<AnyType> removeAllGreaterItems(Node<AnyType> p, Comparable<AnyType> key)
	{
		if(p == null) return null;
		else
		if(key.compareTo(p.data) < 0)
			return removeAllGreaterItems(p.next, key);
		else
			p.next = removeAllGreaterItems(p.next, key);
		return p;
	}

 /**
   * Removes all nodes lesser than keyItem
   *
   */
   public void removeAllLesserItems(Comparable<AnyType> keyItem)
   {
      head = removeAllLesserItems(head, keyItem);
   }
   private Node<AnyType> removeAllLesserItems(Node<AnyType> p, Comparable<AnyType> key)
   {
      if(p == null) return null;
      else
      if(key.compareTo(p.data) > 0)
         return removeAllLesserItems(p.next, key);
      else
         p.next = removeAllLesserItems(p.next, key);
      return p;
   }
 /*******************************************************
 *
 *  The Node class
 *
 ********************************************************/
	private static class Node<AnyType>
	{
		private AnyType data;
		private Node<AnyType> next;

		public Node(AnyType data, Node<AnyType> next)
		{
			this.data = data;
			this.next = next;
    	}
    }



/*****   Include the main() for testing and debugging  *****/



	public static void main(String[] args)
   {
		LinkedList<String> list = new LinkedList<String>();
		list.addLast("l");
		list.addLast("i");
		list.addLast("s");
		list.addLast("t");
		list.insertBefore("l", "s");
		list.delete("s");
		System.out.println(list);
	}
}