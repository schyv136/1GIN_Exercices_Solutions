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
     * Pour simuler le passage par référence, on utilise ici des méthodes 
     * qui obtiennent un noeud (la racine de l'arbre à considérer) comme 
     * paramètre ET LE RETOURNENT COMME RESULTAT.
     * La méthode appelante DOIT AFFECTER LE RESULTAT AU NOEUD (RACINE).
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
        root = null;
    }
     
    
   /**
     * True ssi l'arbre est vide
     * @return      true si l'arbre est vide
     */
     public boolean isEmpty() {
        return root==null;
    }
    
    /**
     * Recursively add an object to the tree (order : + )
     * @param n  the current n of the tree (seen recursively)
     * @param e     the object to add
      * @return la nouvelle valeur du noeud (nouveau pointeur)
     */
    private Node<E> addRecursion(Node<E> n, E e) {
        if (n == null)   //tree was empty
            n = new Node(e);
        else     
        {             
            if (e.compareTo(n.e)<0)  //add to the left..
                n.left = addRecursion(n.left,e);
            else                                   //add to the right..
                n.right = addRecursion(n.right,e);
        }   
        return n;
    }

    /**
     * Permet d'ajouter un élément à l'arbre.
     * utilise la méthode récursive addRecursion
     * @param e     l'objet à ajouter
     * @return      true (toujours)
     */
    public boolean add(E e)
    {        
        root = addRecursion(root, e);
        return true; //List has changed!
    }

    /** Vide l'arbre en supprimant tous les éléments.
     */
    public void clear()
    {
        root = null;
        // everything else is done by the garbage collector...
    }


    private boolean containsRecursion(Node<E> n, E e) {
        if (n == null)
            return false;
        else if (n.e.compareTo(e)==0)
            return true;
        else if (n.e.compareTo(e) > 0)
            return containsRecursion(n.left,  e);
        else
            return containsRecursion(n.right, e);
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
            return n!=null && n.left==null && n.right==null;
    }
    
    /**
     * Removes element e from a tree recursively starting at n
     * @param n root of the current tree
     * @param e object to be removed
     * @return (changed) node n
     */
    
    private boolean elementRemoved; //used to be compatible with Collection 
    private Node removeRecursion(Node n, E e)
    {
        if (n==null) //Tree empty or not found
            elementRemoved=false; //nothing to do ...
        else if (n.e.compareTo(e) > 0) //Go left
            n.left = removeRecursion(n.left, e) ;
        else if (n.e.compareTo(e) < 0) //Go right
            n.right = removeRecursion(n.right, e);
        else //if (n.e==e)
            {  //object found -> remove it
                if (n.left==null && n.right==null) //only 1 node
                    n=null;
                else if (n.left==null)   //subtree only on the right side           
                    n = n.right; 
                else if (n.right==null)  //subtree only on the left side         
                    n = n.left;                     
                else //subtree at both sides 
                {
                    Node right = n.right; //memorize top of right subtree
                    n = n.left;  //link in the left subtree
                    //get right end node of the left subtree (i.e. null pointer on the right)
                    Node REnd=n;
                    while (REnd.right!=null) REnd = REnd.right;
                    //add right subtree here
                    REnd.right = right;
                }  
                elementRemoved=true;                
            }        
        return n; //return node (maybe changed)
    }
    
    /**   
     * Supprime l'élément à la position indiquée dans le paramètre.
           (Les éléments qui suivent l'élément supprimé avancent
               automatiquement d'une position.)
     * @param e l'objet à supprimer
     * @return true if remove successful (uses private elementRemoved
     */
    public boolean remove(E e)
    {
        elementRemoved=false;                
        root = removeRecursion(root, e); 
        return elementRemoved;                
    }
    
    
    private int sizeRecursion(Node n) {
        if (n == null) return 0;
        else return 1 + sizeRecursion(n.left) + sizeRecursion(n.right);
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
      if (n != null) {  
        result = infixArray(n.left , ar, result);
        ar[result++]=n.e;
        result = infixArray(n.right, ar, result);
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
        
         infixArray(root, result, 0);
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
         for (Object e : this) {
             result[i] = e;
             i++;
         }
              
         //infixArray(root,result,0);
         return result;
    }
    

    private int depthRecursion(Node n) {
        if (n == null) return 0;
        else  return 1 + Math.max( depthRecursion(n.left),
                                   depthRecursion(n.right));
    }
    
    /**
     * Retourne la profondeur de l'arbre
     * @return
     */
    public int getDepth()  {
        return depthRecursion(root);
    }
    
    @Override
	public String toString()
	{
		String res="size="+size()+"\n";
        for (E e : this)
                    res = res + e.toString()+"\n";			
		return res;		
	}
    

    
}