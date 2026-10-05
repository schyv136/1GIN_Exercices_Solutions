package binarySearchTree;

/**
 * Node of a Binary Search Tree
 * Objects MUST be comparable
 * 
 *   * Attention: Pour assurer que Comparable implémente l'interface 'Comparable' il faut 
     * définir Comparable comme <E extends Comparable>. 
     * Il est impossible de définir <E implements Comparable>, mais extends 
     * peut être appliqué sur des interfaces lors de la définition de génériques.
  
     * Comme il est impossible de passer des paramètres par référence, 
     * la racine de l'arbre ne peut pas être changée par une méthode.
     * Ainsi, il faut définir un arbre vide comme suit 
     * (et il faudra en tenir compte dans toutes les méthodes):
     * Un arbre vide est un noeud où tous les attributs (objet, left et right)
     * sont null.
 *
 * @author FabFr297
 */
public class Node implements Comparable {
        protected Comparable data    = null;
        protected Node  left = null;
        protected Node  right= null;
        
        public Node (Comparable data)
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
        @Override
        public int compareTo(Object o) { 
            return this.data.compareTo(((Node)o).data);
        }

    }