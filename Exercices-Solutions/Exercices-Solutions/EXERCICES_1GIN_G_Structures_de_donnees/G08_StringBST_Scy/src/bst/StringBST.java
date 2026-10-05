package bst;

import bst.Node;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.*;

/**
 * Binary Search Tree - ABR Arbre Binaire de Recherche
 *
 * @author Fred Faber
 */
public class StringBST {
    /* 
     * Comme il est impossible de passer des paramètres par référence, 
     * la racine de l'arbre ne peut pas être changée par une méthode.
     * Pour simuler le passage par référence, on utilise ici des méthodes 
     * qui obtiennent un noeud (la racine de l'arbre à considérer) comme 
     * paramètre ET LE RETOURNENT COMME RESULTAT.
     * La méthode appelante DOIT AFFECTER LE RESULTAT AU NOEUD (RACINE).
     */
    
    
    

    private Node root = null;
    //constantes et attributs pour le mode de parcours de l'arbre
    /* Les méthodes suivantes dépendent de toArray et par conséquence du mode de parcours
     *  toArray()
     *  get(i)
     *  indexOf(..)
     *  remove(i)
     *  toString()
     *  saveToFile(...)
     */
    public static final int PREORDER = 0; // parcours en préordre
    public static final int INORDER = 1; // parcours en ordre
    public static final int POSTORDER = 2; // parcours en postordre
    private int mode = INORDER;          // mode de parcours actuel


   //************************* Observers et Observable ********************************
    //la méthode propertyChanged est appelée dans MainFrame 
    // - pour la vue : StringBSTView
    // - ici aussi pour le contrôleur : MainFrame
    /**
     * Méthode qui a été définie pour être appelée lors de chaque changement
     * dans l'arbre. updateObservers doit être appelée explicitement dans les
     * méthodes du modèle (cette classe) après chaque modification. Avec updateListeners(), tous les observateurs sont
     * incités à réafficher les informations de l'arbre ==> plus besoin
     * d'appeler repaint etc.
     */
    public void updateListeners(){
        pcs.firePropertyChange("BSTchanged", null, null);
    }
    
    private final PropertyChangeSupport pcs =new PropertyChangeSupport(this);
     public void addPropertyChangeListener(PropertyChangeListener listener){
        pcs.addPropertyChangeListener(listener);
    }

    /* ========================================================================================== */
    public StringBST() {
        root = null;
    }

    public Node getRoot() {
        return root;
    }

    //fixer le mode de parcours de l'arbre
    public void setMode(int mode) {
        this.mode = mode;
        updateListeners();
    }

    //retourner le mode de parcours de l'arbre
    public int getMode() {
        return mode;
    }

    /**
     * True ssi l'arbre est vide
     *
     * @return true si l'arbre est vide
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Permet d'ajouter un élément à l'arbre. utilise la méthode récursive
     * addRecursion
     *
     * @param data l'objet à ajouter
     * @return true (toujours)
     */
    public boolean add(String data) {
        root = addRecursion(root, data);
        updateListeners();
        return true; //List has changed!
    }

    /**
     * Recursively add an object to the tree (order : + )
     *
     * @param n the current n of the tree (seen recursively)
     * @param data the object to add
     * @return la nouvelle valeur du noeud (nouveau pointeur)
     */
    private Node addRecursion(Node n, String data) {
        if (n == null) //tree was empty
        {
            n = new Node(data);
        } else {
            if (data.compareTo(n.data) < 0) //add to the left..
            {
                n.left = addRecursion(n.left, data);
            } else //add to the right..
            {
                n.right = addRecursion(n.right, data);
            }
        }
        return n;
    }

    /**
     * Vide l'arbre en supprimant tous les éléments.
     */
    public void clear() {
        root = null;
        updateListeners();
        // everything else is done by the garbage collector...
    }

    /**
     * Teste si l'arbre contient un objet donné. utilise la méthode récursive
     * containsRecursion
     *
     * @return true si l'objet se trouve dans l'arbre
     */
    public boolean contains(String data) {
        return containsRecursion(root, data);
    }

    private boolean containsRecursion(Node n, String data) {
        if (n == null) {
            return false;
        } else if (n.data.compareTo(data) == 0) {
            return true;
        } else if (data.compareTo(n.data) < 0) {
            return containsRecursion(n.left, data);
        } else {
            return containsRecursion(n.right, data);
        }
    }

    private boolean isLeaf(Node n) {
        return n != null && n.left == null && n.right == null;
    }

    /**
     * Supprime l'élément à la position indiquée dans le paramètre. (Les
     * éléments qui suivent l'élément supprimé avancent automatiquement d'une
     * position.)
     *
     * @param data l'objet à supprimer
     * @return true if remove successful (uses private elementRemoved
     */
    public boolean remove(String data) {
        elementRemoved = false;
        root = removeRecursion(root, data);
        updateListeners();
        return elementRemoved;
    }
    /**
     * Removes element e from a tree recursively starting at n
     *
     * @param n root of the current tree
     * @param e object to be removed
     * @return (changed) node n
     */
    private boolean elementRemoved; //used to be compatible with Collection 

    private Node removeRecursion(Node n, String data) {
        if (n == null) //Tree empty or not found
        {
            elementRemoved = false; //nothing to do ...
        } else if (data.compareTo(n.data) < 0) //Go left
        {
            n.left = removeRecursion(n.left, data);
        } else if (data.compareTo(n.data) > 0) //Go right
        {
            n.right = removeRecursion(n.right, data);
        } else //if (n.data==data)
        {  //object found -> remove it
            if (n.left == null && n.right == null) //only 1 node
            {
                n = null;
            } else if (n.left == null) //subtree only on the right side           
            {
                n = n.right;
            } else if (n.right == null) //subtree only on the left side         
            {
                n = n.left;
            } else //subtree at both sides 
            {
                Node right = n.right; //memorize top of right subtree
                n = n.left;  //link in the left subtree
                //get right end node of the left subtree (i.data. null pointer on the right)
                Node REnd = n;
                while (REnd.right != null) {
                    REnd = REnd.right;
                }
                //add right subtree here
                REnd.right = right;
            }
            elementRemoved = true;
        }
        return n; //return node (maybe changed)
    }
    
    private Node removeRecursion2(Node n, String data) {
        if (n == null) {
            return null;
        }
        if (data.compareTo(n.data)<0) {
            n.left = removeRecursion2(n.left, data);
        } else if (data.compareTo(n.data)>0) {
            n.right = removeRecursion2(n.right, data);

        } else {
            // if nodeToBeDeleted have both children
            if (n.left != null && n.right != null) {
                Node temp = n;
                // Finding minimum element from right
                Node minNodeForRight = minimumElement(temp.right);
                // Replacing current node with minimum node from right subtree
                n.data = minNodeForRight.data;
                // Deleting minimum node from right now
                n.right = removeRecursion2(n.right, minNodeForRight.data);

            } // if nodeToBeDeleted has only left child
            else if (n.left != null) {
                n = n.left;
            } // if nodeToBeDeleted has only right child
            else if (n.right != null) {
                n = n.right;
            } // if nodeToBeDeleted do not have child (Leaf node)
            else {
                n = null;
            }
        }
        return n;
    }
    
     // Get minimum element in binary search tree
    public static Node minimumElement(Node root) {
        if (root.left == null)
            return root;
        else {
            return minimumElement(root.left);
        }
    }

    /**
     * Retourne la taille de l'arbre, donc le nombre d'éléments y contenus.
     * utilise la méth récursive sizeRecursion
     *
     * @return la taille de la liste
     */
    public int size() {
        return sizeRecursion(root);
    }

    private int sizeRecursion(Node n) {
        if (n == null) {
            return 0;
        } else {
            return 1 + sizeRecursion(n.left) + sizeRecursion(n.right);
        }
    }

    /**
     * Transforme l'arbre en un « Array ». Cette méthode est utile pour tout
     * parcours des éléments. Utilise la méthode récursive toArray...Recursion
     * en 3 variantes
     */
    public Object[] toArray() {
        Object[] result = new Object[size()];
        if (mode == PREORDER) {
            toArrayPreorderRecursion(root, result, 0);
        }
        if (mode == INORDER) {
            toArrayInorderRecursion(root, result, 0);
        }
        if (mode == POSTORDER) {
            toArrayPostorderRecursion(root, result, 0);
        }
        return result;
    }

    private int toArrayPreorderRecursion(Node n, Object[] ar, int result) {
        if (n != null) {
            ar[result++] = n.data;
            result = toArrayPreorderRecursion(n.left, ar, result);
            result = toArrayPreorderRecursion(n.right, ar, result);
        }
        return result;
    }

    private int toArrayInorderRecursion(Node n, Object[] ar, int result) {
        if (n != null) {
            result = toArrayInorderRecursion(n.left, ar, result);
            ar[result++] = n.data;
            result = toArrayInorderRecursion(n.right, ar, result);
        }
        return result;
    }

    private int toArrayPostorderRecursion(Node n, Object[] ar, int result) {
        if (n != null) {
            result = toArrayPostorderRecursion(n.left, ar, result);
            result = toArrayPostorderRecursion(n.right, ar, result);
            ar[result++] = n.data;
        }
        return result;
    }

    /**
     * Retourne la profondeur de l'arbre
     *
     * @return
     */
    public int getDepth() {
        return depthRecursion(root);
    }

    private int depthRecursion(Node n) {
        if (n == null) {
            return 0;
        } else {
            return 1 + Math.max(depthRecursion(n.left),
                    depthRecursion(n.right));
        }
    }

    @Override
    public String toString() {
        String res = "size=" + size() + "\n";
        Object[] arElements = toArray();
        for (Object arElement : arElements) {
            res = res + arElement + "\n";
        }
        return res;
    }

    //************************** OPERATIONS FICHIERS ***********************************
    
    public void saveToFile(String fileName) throws FileNotFoundException, IOException {
        int oldMode = mode;
        mode = PREORDER;
        try (PrintWriter out = new PrintWriter(new FileWriter(fileName))) {
            Object[] arElements = toArray();
            for (Object arElement : arElements) {
                out.println(arElement);
                System.out.println("wrote : " + arElement);
            }
        }
        mode = oldMode;
        System.out.println("saved file closed");
    }

    public void loadFromFile(String fileName) throws FileNotFoundException, IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            clear();
            String line;
            while ((line = in.readLine()) != null) {
                add(line);
            }
            updateListeners();
        }
    }
}