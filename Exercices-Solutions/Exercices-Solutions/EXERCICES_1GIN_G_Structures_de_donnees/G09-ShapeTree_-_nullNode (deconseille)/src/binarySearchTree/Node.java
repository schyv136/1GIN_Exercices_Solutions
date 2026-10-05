package binarySearchTree;

/**
 * Node of a Binary Search Tree
 * Objects MUST be comparable
 * 
 *   * Attention: Pour assurer que E implémente l'interface 'Comparable' il faut 
     * définir E comme <E extends Comparable>. 
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
public class Node<E extends Comparable<E>> implements Comparable<Node<E>> {
        private E e    = null;
        private Node<E>  left = null;
        private Node<E>  right= null;
        
        public Node (E e)
        {
            this.e = e;
            left   = null;
            right  = null;
        }
        
        public Node<E> getLeft()
        {
            return left;
        }

        public void setLeft(Node<E> node)
        {
            left = node;
        }

        public Node<E> getRight()
        {
            return right;
        }

        public void setRight(Node<E> node)
        {
            right = node;
        }

        public E getElement()
        {
            return e;
        }

        public void setElement(E e)
        {
            this.e = e;
        }

        @Override
        public int compareTo(Node<E> node) {
            return e.compareTo(node.getElement());
        }

    }