package simpleLinkedList;

import java.util.Iterator;

/**
 *
 * @author Fred Faber
 */
public class SimpleLinkedList<E> implements Iterable<E>
{
/*
boolean add(Object)     Permet d'ajouter un élément à la liste.
void clear()            Vide la liste en supprimant tous les éléments.
boolean contains(Object) Teste si la liste contient un élément donné.
Object get(int)         Retourne l'élément à la position indiquée dans le paramètre.
int indexOf(Object)     Retourne la position de l'élément indiqué dans le paramètre 
                        ou -1 si l'élément ne se trouve pas dans la liste.
Object remove(int)      Supprime l'élément à la position indiquée dans le paramètre.
                        (Les éléments qui suivent l'élément supprimé avancent
                        automatiquement d'une position.)
Object set(int, Object) Remplace l'élément à la position spécifiée par celui passé en
                        tant que paramètre.
int size()              Retourne la taille de la liste, donc le nombre d'éléments y
                        contenus.
Object[] toArray()      Transforme la liste en un « Array ». Cette méthode est
                        uniquement nécessaire pour la visualisation des éléments à
                        l'aide d'un composant « JList » (voir chapitre suivant).
     */
    
    private Node first = null;

    /* ========================================================================================== */
    //retourner l'itérateur de la liste
    @Override
    public Iterator<E> iterator() {
        return new SimpleLinkedListIterator<E>(first);
    }


    /* ========================================================================================== */
    /**
     * Permet d'ajouter un élément à la liste.
     *
     * @param o l'objet à ajouter
     * @return true (toujours)
     */
    public boolean add(Object o) {
        Node el = new Node(o);
        if (first == null) {
            first = el;
        } else {
            Node p = first;
            while (p.next != null) {
                p = p.next;
            }
            p.next = el;
        }
        return true;
    }

    /**
     * Vide la liste en supprimant tous les éléments.
     */
    public void clear() {
        first = null;
        //le ramasse-miettes s'occupe du reste...
    }

    /**
     * Teste si la liste contient un objet donné.
     *
     * @return true si l'objet se trouve dans la liste
     */
    public boolean contains(Object o) {
        boolean result = false;
        Node p = first;
        while (!result && p != null) {
            if (p.o == o) {
                result = true;
            } else {
                p = p.next;
            }
        }
        return result;
    }

    /**
     * Retourne l'élément à la position indiquée dans le paramètre.
     *
     * @param n l'indice de l'élément
     * @return l'objet à la position i ou null si on trouvé
     */
    public Object get(int n) {
        Object result = null;
        Node p = first;
        int i = 0;
        while (p != null && i != n) {
            p = p.next;
            i++;
        }
        if (i == n) {
            result = p.o;
        }
        return result;
    }

    /**
     * Retourne la position de l'élément indiqué dans le paramètre ou -1 si
     * l'élément ne se trouve pas dans la liste.
     *
     * @param o l'objet à rechercher
     * @return la position de l'objet ou -1
     */
    public int indexOf(Object o) {
        int result = -1;
        Node p = first;
        int i = -1;
        while (result == -1 && p != null) {
            i++;
            if (p.o == o) {
                result = i;
            } else {
                p = p.next;
            }
        }
        return result;
    }

    /**
     * Supprime l'élément à la position indiquée dans le paramètre. (Les
     * éléments qui suivent l'élément supprimé avancent automatiquement d'une
     * position.)
     *
     * @param i
     * @return l'élément qui a été supprimé de la liste
     */
    public Object remove(int n) {
        Object result = null;
        if (n == 0 && first != null) {
            result = first.o;
            first = first.next;
        } else {
            Node p = first;
            int i = 0;
            while (p.next != null && i != n - 1) {
                p = p.next;
                i++;
            }
            //maintenant p pointe sur le prédécesseur de l'objet à supprimer
            //si p.getNext existe... :
            if (i == n - 1) {
                result = p.next.o;
                p.next = p.next.next;
            }
        }
        return result;
    }

    /**
     * Retourne la taille de la liste, donc le nombre d'éléments y contenus.
     *
     * @return la taille de la liste
     */
    public int size() {
        Node p = first;
        int result = 0;
        while (p != null) {
            p = p.next;
            result++;
        }
        return result;
    }

    /**
     * Remplace l'élément à la position spécifiée par celui passé en tant que
     * paramètre.
     *
     * @return l'objet ou null
     */
    public Object set(int n, Object o) {
        Object result = null;
        Node p = first;
        int i = 0;
        while (p != null && i != n) {
            p = p.next;
            i++;
        }
        if (i == n) {
            result = p.o;
            p.o = o;
        }
        return result;
    }

    /**
     * Transforme la liste en un « Array ». Cette méthode est uniquement
     * nécessaire pour la visualisation des éléments à l'aide d'un composant «
     * JList » (voir chapitre suivant).
     */
    public Object[] toArray() {
        Object[] result = new Object[size()];
        Node p = first;
        for (int i = 0; i < size(); i++) {
            result[i] = p.o;
            p = p.next;
        }
        return result;
    }
    
    //========================================================================
    // ********* new methods  ***************
    
    /**
     * Ajoute l'élément passé comme paramètre à la position spécifiée 
     */
    public void add(int n, Object o) {
        Node el = new Node(o);
        if (n == 0) {
            el.next = first;
            first = el;
        } else {
            Node p = first;
            int i = 0;
            while (p != null && i != n - 1) {
                p = p.next;
                i++;
            }
            if (p!=null) {
                el.next = p.next;
                p.next = el;
            }
        }
    }
    
    /*
     * This implementation of 'remove' uses 'equals' to compare Shapes 
     * ==> 'equals' MUST BE OVERRIDDEN in 'Shape' and all of it's subclasses
     * ==> if 'equals' is overriden, 'hashcode' MUST be overridden, too!
     */
    public void remove(Object o) {
        if (o != null && first != null) {
            if (first.o.equals(o)) {  // ==> equals & hashcode must be overridden
                first = first.next;
            } else {
                Node current = first;
                while (current != null && current.next != null && !current.next.o.equals(o)) {
                    current = current.next;
                }
                if (current != null && current.next != null) {
                    current.next = current.next.next;
                }
            }
        }
    }

    
    
}