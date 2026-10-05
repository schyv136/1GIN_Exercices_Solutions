/*
 * Dictionary based on a BST
 * direct search very efficient
 * reverse search through the whole tree
 */
package dictionary;

import java.util.ArrayList;

    
/**
 * @author fred
 */
//   ----------------------------------------------------------------- 
public class DictionaryTree extends Dictionary {
    
    private Node root = null;    
     
    @Override
    public void clear() {
        root = null;
    }
    
    
    // ----------------------------------------------------------------- 
    @Override
    public void add(String lang1, String lang2) {
        root = addRecursion(lang1, lang2, root);
    }
    
    private Node addRecursion(String lang1, String lang2, Node node) { //<- private
        if (node==null) 
            node = new Node(lang1, lang2);
        else {
            if (lang1.compareTo(node.lang1) < 0)
                node.left  = addRecursion(lang1, lang2, node.left);
            else
                node.right = addRecursion(lang1, lang2, node.right);
        }
        return node;
    }
    
    
    // ----------------------------------------------------------------- 
    @Override
    public Object[] toArray() {
       ArrayList<Node> result = new ArrayList<>();
       toArrayRecursion(root, result);
       return result.toArray();
    }
    
    private void toArrayRecursion(Node node, ArrayList<Node> result) { //<- private
        if (node!=null) {
            toArrayRecursion( node.left, result);
            result.add(node);
            toArrayRecursion( node.right, result);            
        }            
    }
    
    
    // ----------------------------------------------------------------- 
    @Override
    public String translate(String lang1) {
        return translateRecursion(lang1, root);
    }
    
    private String translateRecursion(String lang1, Node node) { //<- private
        if (node == null) return null;
        else 
            if (node.lang1.equals(lang1))
                return node.lang2;
            else 
                if (lang1.compareTo(node.lang1) < 0) 
                    return translateRecursion( lang1,  node.left);
                else 
                    return translateRecursion( lang1,  node.right);                    
    }
    
    
    // ----------------------------------------------------------------- 
    @Override
    public String translateReverse(String lang2) {
        return translateReverseRecursion(lang2, root);
    }
    
    private String translateReverseRecursion(String lang2, Node node) { //<- private
        if (node == null) return null;
        else 
            if (node.lang2.equals(lang2))
                return node.lang1;
            else {
                String result = translateReverseRecursion(lang2,  node.left);
                if ( result != null )
                    return result;
                else
                    return translateReverseRecursion( lang2,  node.right); 
            }
    }
    
    
    // ----------------------------------------------------------------- 
    @Override
    public void delete(String lang1) {
        root = deleteRecursion(lang1, root); 
    }

    private Node deleteRecursion(String lang1, Node node) {
        if (node!=null) {
            if (lang1.compareTo(node.lang1) < 0) 
                node.left = deleteRecursion(lang1, node.left);
            else if (lang1.compareTo(node.lang1) > 0) 
                node.right = deleteRecursion(lang1, node.right);
            else { //found node to delete
                if (node.left==null && node.right==null)
                    node = null;
                else if (node.left==null) 
                    node = node.right;
                else if (node.right==null) 
                    node = node.left;
                else { //node has 2 successors
                    Node help = node.right;
                    node = node.left;
                    Node rightEnd = node;
                    while(rightEnd.right != null) 
                        rightEnd = rightEnd.right;
                    rightEnd.right = help;
                }                
            }
        }
        return node;
    }    
}
