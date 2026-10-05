package simpleLinkedList;

/**
 * Node of of linked list defined in LinkedList
 * @author FabFr297
 */
public class Node {
        protected Object  o   = null;
        protected Node next= null;
        
        public Node (Object o)
        {
            this.o = o;
            next=null;
        }       
}