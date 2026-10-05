package binarySearchTree;

/**
 * Binary Search Tree - ABR Arbre Binaire de Recherche
 * @author Fred Faber
 */

public class BST implements java.lang.Iterable
{
/* 
     * Comme il est impossible de passer des paramètres par référence, 
     * la racine de l'arbre ne peut pas être changée par une méthode.
     * Pour simuler le passage par référence, on utilise ici des méthodes 
     * qui obtiennent un noeud (la racine de l'arbre à considérer) comme 
     * paramètre ET LE RETOURNENT COMME RESULTAT.
     * La méthode appelante DOIT AFFECTER LE RESULTAT AU NOEUD (RACINE).
 */
    
    private Node root=null;
    
    /* ========================================================================================== */


	//Send back List's own Iterator
        @Override
	public java.util.Iterator iterator() {
  		return new BSTIterator(root);
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
     * @param data     the object to add
      * @return la nouvelle valeur du noeud (nouveau pointeur)
     */
    private Node addRecursion(Node n, Comparable data) {
        if (n == null)   //tree was empty
            n = new Node(data);
        else     
        {             
            if (data.compareTo(n.data)<0)  //add to the left..
                n.left = addRecursion(n.left,data);
            else                                   //add to the right..
                n.right= addRecursion(n.right,data);
        }   
        return n;
    }

    /**
     * Permet d'ajouter un élément à l'arbre.
     * utilise la méthode récursive addRecursion
     * @param data     l'objet à ajouter
     * @return      true (toujours)
     */
    public boolean add(Comparable data)
    {        
        root = addRecursion(root, data);
        return true; //List has changed!
    }

    /** Vide l'arbre en supprimant tous les éléments.
     */
    public void clear()
    {
        root = null;
        // everything else is done by the garbage collector...
    }


    private boolean containsRecursion(Node n, Comparable data) {
        if (n == null)
            return false;
        else if (n.data.compareTo(data)==0)
            return true;
        else if (n.data.compareTo(data) > 0)
            return containsRecursion(n.left,  data);
        else
            return containsRecursion(n.right, data);
    }

    /**
     * Teste si l'arbre contient un objet donné.
     * utilise la méthode récursive containsRecursion
     * @return true si l'objet se trouve dans l'arbre
     */
    public boolean contains(Comparable data)
    {
        return containsRecursion(root, data);
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
    private Node removeRecursion(Node n, Comparable data)
    {
        if (n==null) //Tree empty or not found
            elementRemoved=false; //nothing to do ...
        else if (n.data.compareTo(data) > 0) //Go left
            n.left  = removeRecursion(n.left, data);
        else if (n.data.compareTo(data) < 0) //Go right
            n.right = removeRecursion(n.right, data);
        else //if (n.data==data)
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
                    //get right end node of the left subtree (i.data. null pointer on the right)
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
    public boolean remove(Comparable data)
    {
        elementRemoved=false;                
        root = removeRecursion(root, data); 
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
 
    
    private int toArrayRecursion(Node n, Object[] ar, int result) {
      if (n != null) {  
        result = toArrayRecursion(n.left , ar, result);
        ar[result++]=n.data;
        result = toArrayRecursion(n.right, ar, result);
      }
      return result;
    }
    
    
    /**
     * Transforme l'arbre en un « Array ». Cette méthode est
     * utile pour la visualisation des éléments à
     * l'aide d'un composant « JList » .
     * Utilise la méthode récursive toArrayRecursion
     */ 
    public Object[] toArray()
    {
         Object[] result=new Object[size()];        
         toArrayRecursion(root, result, 0);
         return result;
     }

   /**
     * Transforme l'arbre en un « Array ». Cette méthode est
     * utile pour la visualisation des éléments à
     * l'aide d'un composant « JList » .
     * utilise l'itérateur à travers for
     * Utilise l'itérateur.
     */ 
    public Object[] toArray_()
    {
         Object[] result=new Object[size()];        
         int i=0;
         for (Object data : this) {  //profite de l'itérateur
             result[i] = data;
             i++;
         }
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
    public   int getDepth()  {
        return depthRecursion(root);
    }
}