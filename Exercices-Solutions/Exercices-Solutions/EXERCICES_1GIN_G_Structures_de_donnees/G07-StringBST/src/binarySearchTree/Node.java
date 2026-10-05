package binarySearchTree;

/**
 * Node of a Binary Search Tree
 * Objects MUST be comparable
 * 
 * @author FabFr
 */
public class Node  {
        protected String data = null;
        protected Node   left = null;
        protected Node   right= null;
        
        public Node (String data)
        {
            this.data = data;
            left   = null;
            right  = null;
        }
        
        /*
         * compare this node to another node
         * ==> compare the data objects of the 2 nodes
         * @return  the result of data comparision
         * @param o the other Node to which you compare this one
         */
        public int compareTo(Object o) { 
            return this.data.compareTo(((Node)o).data);
        }

    }