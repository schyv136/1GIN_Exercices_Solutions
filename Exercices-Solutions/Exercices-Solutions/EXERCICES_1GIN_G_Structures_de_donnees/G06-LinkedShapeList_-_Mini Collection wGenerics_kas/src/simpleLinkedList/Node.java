package simpleLinkedList;

/**
 * Node of of linked list defined in LinkedList
 * @author FabFr297
 */
public class Node<E> {
        protected E    o    = null;
        protected Node<E> next = null;
        
        public Node (E o)
        {
            this.o = o;
            next=null;
        }
       
    }