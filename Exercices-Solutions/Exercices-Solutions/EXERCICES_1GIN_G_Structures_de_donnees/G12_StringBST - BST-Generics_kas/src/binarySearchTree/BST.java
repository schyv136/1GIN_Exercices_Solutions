package binarySearchTree;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Binary Search Tree - ABR Arbre Binaire de Recherche
 *
 * @author Fred Faber
 * @param <E>
 */
public class BST<E extends Comparable<E>> {

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
    private Node<E> root = null;

    //constantes et attributs pour le mode de parcours de l'arbre
    /* Les méthodes suivantes dépendent de toArray et par conséquence du mode de parcours
     *  toArray()
     *  toString()
     *  saveToFile(...)
     */
    public static final int PREORDER = 0; // parcours en préordre
    public static final int INORDER = 1; // parcours en ordre
    public static final int POSTORDER = 2; // parcours en postordre
    private int mode = INORDER;          // mode de parcours actuel

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getMode() {
        return mode;
    }

    /* ========================================================================================== */

 /* ========================================================================================== */
    /**
     * Méthode qui a été définie pour être appelée lors de chaque changement
     * dans l'arbre. updateObservers doit être appelée explicitement dans les
     * méthodes du modèle (cette classe) après chaque modification. Avec les 2
     * instructions setChanged et notifyObservers, tous les observateurs sont
     * incités à réafficher les informations de l'arbre ==> plus besoin
     * d'appeler repaint etc.
     */
    public BST() {
        root = null;
    }

    public Node<E> getRoot() {
        return root;
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
     * Recursively add an object to the tree (order : + )
     *
     * @param n the current n of the tree (seen recursively)
     * @param e the object to add
     * @return la nouvelle valeur du noeud (nouveau pointeur)
     */
    private Node<E> addRecursion(Node<E> n, E e) {
        if (n == null) //tree was empty
        {
            n = new Node(e);
        } else {
            if (e.compareTo(n.e) < 0) //add to the left..
            {
                n.left = addRecursion(n.left, e);
            } else //add to the right..
            {
                n.right = addRecursion(n.right, e);
            }
        }
        return n;
    }

    /**
     * Permet d'ajouter un élément à l'arbre. utilise la méthode récursive
     * addRecursion
     *
     * @param e l'objet à ajouter
     * @return true (toujours)
     */
    public boolean add(E e) {
        root = addRecursion(root, e);
        return true; //List has changed!
    }

    /**
     * Vide l'arbre en supprimant tous les éléments.
     */
    public void clear() {
        root = null;
        // everything else is done by the garbage collector...
    }

    private boolean containsRecursion(Node<E> n, E e) {
        if (n == null) {
            return false;
        } else if (n.e.compareTo(e) == 0) {
            return true;
        } else if (n.e.compareTo(e) > 0) {
            return containsRecursion(n.left, e);
        } else {
            return containsRecursion(n.right, e);
        }
    }

    /**
     * Teste si l'arbre contient un objet donné. utilise la méthode récursive
     * containsRecursion
     *
     * @return true si l'objet se trouve dans l'arbre
     */
    public boolean contains(E e) {
        return containsRecursion(root, e);
    }

    private boolean isLeaf(Node n) {
        return n != null && n.left == null && n.right == null;
    }

    /**
     * Removes element e from a tree recursively starting at n
     *
     * @param n root of the current tree
     * @param e object to be removed
     * @return (changed) node n
     */
    private boolean elementRemoved; //used to be compatible with Collection 

    private Node removeRecursion(Node n, E e) {
        if (n == null) //Tree empty or not found
        {
            elementRemoved = false; //nothing to do ...
        } else if (n.e.compareTo(e) > 0) //Go left
        {
            n.left = removeRecursion(n.left, e);
        } else if (n.e.compareTo(e) < 0) //Go right
        {
            n.right = removeRecursion(n.right, e);
        } else //if (n.e==e)
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
                //get right end node of the left subtree (i.e. null pointer on the right)
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

    /**
     * Supprime l'élément à la position indiquée dans le paramètre. (Les
     * éléments qui suivent l'élément supprimé avancent automatiquement d'une
     * position.)
     *
     * @param e l'objet à supprimer
     * @return true if remove successful (uses private elementRemoved
     */
    public boolean remove(E e) {
        elementRemoved = false;
        root = removeRecursion(root, e);
        return elementRemoved;
    }

    private int sizeRecursion(Node n) {
        if (n == null) {
            return 0;
        } else {
            return 1 + sizeRecursion(n.left) + sizeRecursion(n.right);
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

    public Object[] toArray() {
        Object[] result = new Object[size()];
        if (mode == PREORDER) {
            preorderArray_Recursion(root, result, 0);
        }
        if (mode == INORDER) {
            inorderArray_Recursion(root, result, 0);
        }
        if (mode == POSTORDER) {
            postorderArray_Recursion(root, result, 0);
        }
        return result;
    }

    private int inorderArray_Recursion(Node n, Object[] ar, int result) {
        if (n != null) {
            result = inorderArray_Recursion(n.left, ar, result);
            ar[result++] = n.e;
            result = inorderArray_Recursion(n.right, ar, result);
        }
        return result;
    }

    private int preorderArray_Recursion(Node n, Object[] ar, int result) {
        if (n != null) {
            ar[result++] = n.e;
            result = preorderArray_Recursion(n.left, ar, result);
            result = preorderArray_Recursion(n.right, ar, result);
        }
        return result;
    }

    private int postorderArray_Recursion(Node n, Object[] ar, int result) {
        if (n != null) {
            result = postorderArray_Recursion(n.left, ar, result);
            result = postorderArray_Recursion(n.right, ar, result);
            ar[result++] = n.e;
        }
        return result;
    }

    public E[] toArrayPreorder() {
        E[] result = (E[]) new Comparable[size()];
        preorderArray_Recursion(root, result, 0);
        return result;
    }

    public E[] toArrayPostorder() {
        E[] result = (E[]) new Comparable[size()];
        postorderArray_Recursion(root, result, 0);
        return result;
    }

    private int depthRecursion(Node n) {
        if (n == null) {
            return 0;
        } else {
            return 1 + Math.max(depthRecursion(n.left),
                    depthRecursion(n.right));
        }
    }

    /**
     * Retourne la profondeur de l'arbre
     *
     * @return
     */
    public int getDepth() {
        return depthRecursion(root);
    }

    @Override
    public String toString() {
        String el = "";
        String res = "size=" + size() + "\n";
        Object[] elements = toArray();
        for (int i = 0; i < elements.length; i++) {
            el = (String) elements[i];
        }
        res = res + el + "\n";
        return res;
    }

    /**
     * ************************************************************************
     * Pour pouvoir sauvegarder toute sorte de données, on peut : - sauvegarder
     * les données sous forme binaire d'objets - sous forme de texte structuré:
     * XML ou JSON. Malheureusement, il est assez difficile (impossible) de
     * trouver une bibliothèque qui sait charger des éléments qui implémentent
     * une classe générique ET Comparable.
     *
     * Elements in E MUST BE Serializable !!!
     */
    // USING AN ARRAY
    public void saveToObjectFile(String fileName) throws IOException {
        E[] arElements = toArrayPreorder();
        try (ObjectOutputStream obj_out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            obj_out.writeObject(arElements);
        }
    }

    public void loadFromObjectFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream obj_in = new ObjectInputStream(new FileInputStream(fileName))) {
            clear();
            E[] arElements = (E[]) obj_in.readObject();
            for (E e : arElements) {
                add(e);
            }
        }
    }
}
