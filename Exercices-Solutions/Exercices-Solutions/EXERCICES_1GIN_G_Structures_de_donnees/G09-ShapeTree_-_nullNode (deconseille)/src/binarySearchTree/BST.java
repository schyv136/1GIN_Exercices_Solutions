package binarySearchTree;

/**
 * Binary Search Tree - ABR Arbre Binaire de Recherche
 * @author Fred Faber
 */

public class BST<E extends Comparable<E>> implements java.lang.Iterable<E>
{
/*
 * ATTENTION: Pour assurer que E implémente l'interface 'Comparable' il faut 
 * définir E comme <E extends Comparable>. 
 * Il est impossible de définir <E implements Comparable>, mais extends 
 * peut être appliqué sur des interfaces lors de la définition de génériques.
 * 
 * 
     * Comme il est impossible de passer des paramètres par référence, 
     * la racine de l'arbre ne peut pas être changée par une méthode.
     * Ainsi, il faut définir un arbre vide comme suit 
     * (et en tenir compte dans toutes les méthodes):
     * Un arbre vide est un noeud où tous les attributs (objet, left et right) <====
     * sont null.    										         <====
 */
    
    private Node<E> root=null;
    
    /* ========================================================================================== */


	//Send back List's own Iterator
        @Override
	public java.util.Iterator<E> iterator() {
  		return new BSTIterator<E>(root);
 	}


    /* ========================================================================================== */

    public  BST() {
        root = new Node(null);
    }
     
    
    public boolean isEmpty() {
        return root==null || root.getElement()==null;
    }
    
    /**
     * Recursively add an object to the tree (order : + )
     * @param root  the current root of the tree (seen recursively)
     * @param e     the object to add
     */
    private void addRecursion(Node<E> root, E e) {
        if (isEmpty())   //tree was empty
            root.setElement(e);
        else     
        {             
            if (e.compareTo(root.getElement())<0)  //add to the left..
            { 
                  if (root.getLeft()==null) 
                      root.setLeft(new Node<E>(e));
                  else 
                      addRecursion(root.getLeft(),e);
            }
            else                     //add to the right..
            {
                if (root.getRight()==null) 
                      root.setRight(new Node<E>(e));
                  else 
                      addRecursion(root.getRight(),e);
            }
        }     
    }

    /**
     * Permet d'ajouter un élément à l'arbre.
     * utilise la méthode récursive addRecursion
     * @param e     l'objet à ajouter
     * @return      true (toujours)
     */
    public boolean add(E e)
    {        
        addRecursion(root, e);
        return true; //List has changed!
    }

    /** Vide l'arbre en supprimant tous les éléments.
     */
    public void clear()
    {
        root = new Node(null);
        // everything else is done by the garbage collector...
    }


    private boolean containsRecursion(Node<E> root, E e) {
        if (root==null || isEmpty())
            return false;
        else if (root.getElement().compareTo(e)==0)
            return true;
        else if (root.getElement().compareTo(e) > 0)
            return containsRecursion(root.getLeft(),  e);
        else
            return containsRecursion(root.getRight(), e);
    }

    /**
     * Teste si l'arbre contient un objet donné.
     * utilise la méthode récursive containsRecursion
     * @return true si l'objet se trouve dans l'arbre
     */
    public boolean contains(E e)
    {
        return containsRecursion(root, e);
    }

    private boolean isLeaf(Node n)
    {
            return n!=null && n.getLeft()==null && n.getRight()==null;
    }
    
    /**
     * As there are no reference parameters in Java, 'root' cannot be changed.
     * This implies that a special treatment is necessary for removing leaves
     * @param root root of the current tree
     * @param e object to be removed
     * @return true if object was found and removed
     */
    private boolean removeRecursion(Node root, E e)
    {
        boolean result = false;
        
        if (root==null || root.getElement()==null) //Tree empty or not found
        {
            result = false;
        }
        else if (root.getElement().compareTo(e) > 0) //Go left
        {   //kill left leaf
            if (isLeaf(root.getLeft()) && root.getLeft().getElement()==e )
            {
                root.setLeft(null);
                result =true;
            }
            else
                result = removeRecursion(root.getLeft(), e);
        }
        else if (root.getElement().compareTo(e) < 0) //Go right
        {  
            //kill right leaf
            if (isLeaf(root.getRight()) && root.getRight().getElement()==e )
            {
                root.setRight(null);
                result =true;
            }
            else
                result = removeRecursion(root.getRight(), e);
        }
        else //if (root.getElement()==e)
            {  //object found -> remove it
                result = true;   
                if (root.getLeft()==null && root.getRight()==null) //only 1 node
                    root.setElement(null);
                else if (root.getLeft()==null)  //subtree only on the right side           
                {
                    root.setElement(root.getRight().getElement());
                    root.setLeft(root.getRight().getLeft());
                    root.setRight(root.getRight().getRight()); //must be last action...
                } 
                else if (root.getRight()==null)  //subtree only on the left side         
                {
                    root.setElement(root.getLeft().getElement());
                    root.setRight(root.getLeft().getRight());
                    root.setLeft(root.getLeft().getLeft());  //must be last action...                   
                }
                else //subtree at both sides 
                {
                    Node right = root.getRight(); //memorize top of right subtree
                    root.setElement(root.getLeft().getElement());
                    root.setRight(root.getLeft().getRight());
                    root.setLeft(root.getLeft().getLeft());  //must be last action...   
                    //get right end node (null pointer on the right)
                    Node REnd=root;
                    while (REnd.getRight()!=null) REnd = REnd.getRight();
                    //add right subtree here
                    REnd.setRight(right);
                }                
            }        
        return result;
    }
    
    /**   
     * Supprime l'élément à la position indiquée dans le paramètre.
           (Les éléments qui suivent l'élément supprimé avancent
               automatiquement d'une position.)
     * @param e l'objet à supprimer
     * @return the element that was removed from the list
     */
    public boolean remove(E e)
    {
       return removeRecursion(root, e);
    }
    
    
    private int sizeRecursion(Node root) {
        if (root==null || isEmpty()) return 0;
        else return 1 + sizeRecursion(root.getLeft()) + sizeRecursion(root.getRight());
    }
    
    /**
    * Retourne la taille de l'arbre, donc le nombre d'éléments y contenus. 
    * utilise la méth récursive  sizeRecursion
    * @return la taille de la liste
    */
    public int size()  
    {
       return sizeRecursion(root);
    }
 
    
    private int infixArray(Node n, Object[] ar, int result) {
      if (n!=null && !isEmpty()) {  
        result = infixArray(n.getLeft() , ar, result);
        ar[result++]=n.getElement();
        result = infixArray(n.getRight(), ar, result);
      }
      return result;
    }
    
    
    /**
     * Transforme l'arbre en un « Array ». Cette méthode est
     * uniquement nécessaire pour la visualisation des éléments à
     * l'aide d'un composant « JList » .
     * utilise la méthode récursive infixArray
     * IMPOSSIBLE de retourner un array E[] -> 'ERR: generic array creation'
     * Ne peut pas être évité simplement
     */ 
    public Object[] toArray()
    {
         Object[] result=new Object[size()];        
         infixArray(root,result, 0);
         return result;
     }

   /**
     * Transforme l'arbre en un « Array ». Cette méthode est
     * uniquement nécessaire pour la visualisation des éléments à
     * l'aide d'un composant « JList » .
     * utilise l'itérateur à travers for
     * IMPOSSIBLE de retourner un array E[] -> 'ERR: generic array creation'
     * Ne peut pas être évité simplement
     */ 
    public Object[] toArray_()
    {
         Object[] result=new Object[size()];
        
         int i=0;
         for (Object e : this) { //profite de l'itérateur
             result[i] = e;
             i++;
         }
              
         //infixArray(root,result,0);
         return result;
     }


 

    private int depthRecursion(Node root) {
        if (isEmpty() || root==null) return 0;
        else  return 1 + Math.max( depthRecursion(root.getLeft()),
                                   depthRecursion(root.getRight()));
    }
    /**
     * Retourne la profondeur de l'arbre
     * @return
     */
    public int getDepth()  {
        return depthRecursion(root);
    }
}