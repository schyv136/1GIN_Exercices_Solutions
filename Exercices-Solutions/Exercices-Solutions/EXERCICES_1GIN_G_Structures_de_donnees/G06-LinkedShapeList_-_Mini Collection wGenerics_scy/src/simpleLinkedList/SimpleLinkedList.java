package simpleLinkedList;

import java.util.Iterator;

/**
 *
 * @author Fred Faber
 */
public class SimpleLinkedList<E>  implements Iterable<E> {

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
    private Node<E> first = null;

    /* ========================================================================================== */
    //retourner l'itérateur de la liste
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private Node<E> next = first;

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new java.util.NoSuchElementException("ERROR: No such Element in list");
                } else {
                    Node<E> current = next;
                    next = current.next;
                    return current.o;
                }
            }

            @Override
            public boolean hasNext() {
                return next != null;
            }
        };
    }

    /* ========================================================================================== */
    /**
     * Permet d'ajouter un élément à la liste.
     *
     * @param o l'objet à ajouter
     * @return true (toujours)
     */
    public boolean add(E o) {
        Node<E> el = new Node(o);
        if (first == null) {
            first = el;
        } else {
            Node<E> p = first;
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
    public boolean contains(E o) {
        boolean result = false;
        Node<E> p = first;
        while (!result && p != null) {
            if (p.o.equals(o)) {
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
    public E get(int n) {
        E result = null;
        Node<E> p = first;
        int i = 0;
        while (p != null && i != n) {
            p = p.next;
            i++;
        }
        if (p != null && i == n) {
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
    public int indexOf(E o) {
        int result = -1;
        Node<E> p = first;
        int i = -1;
        while (result == -1 && p != null) {
            i++;
            if (p.o.equals(o)) {
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
    public E remove(int n) {
        E result = null;
        if (first != null) {
            if (n == 0) {
                result = first.o;
                first = first.next;
            } else {
                Node<E> p = first;
                int i = 0;
                while (p.next != null && i != n - 1) {
                    p = p.next;
                    i++;
                }
                //maintenant p pointe sur le prédécesseur de l'objet à supprimer
                //si p.next existe... :
                if (i == n - 1) {
                    result = p.next.o;
                    p.next = p.next.next;
                }
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
        Node<E> p = first;
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
    public E set(int n, E o) {
        E result = null;
        Node<E> p = first;
        int i = 0;
        while (p != null && i != n) {
            p = p.next;
            i++;
        }
        if (p != null && i == n) {
            result = p.o;
            p.o = o;
        }
        return result;
    }

    /**
     * Transforme la liste en un « Array ». Cette méthode est uniquement
     * nécessaire pour la visualisation des éléments à l'aide d'un composant «
     * JList » .
     */
    public Object[] toArray() {
        int n = size();
        Object[] result = new Object[n];
        Node<E> p = first;
        for (int i = 0; i < n; i++) {
            result[i] = p.o;
            p = p.next;
        }
        return result;
    }



}
