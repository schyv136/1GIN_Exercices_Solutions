/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author yvonschubert
 */
import java.util.ArrayList;

public class GiString {
    
    public static String delete(String target, int beginIndex, int endIndex)
    {
        return target.substring(0,beginIndex)+target.substring(endIndex);
    }
    
    public static String insert(String target, String str, int index)
    {
        return target.substring(0, index)+str+target.substring(index);
    }
    
    public static int count(String target, String str)
    {
        int count=0;
        while(target.contains(str))
        {
            count++;
            int index=target.indexOf(str);
            target=delete(target, index, index+str.length());   
        }
        return count;
    }
    
    public static String reverse (String target)
    {
        String reversed="";
        for(int c=target.length()-1;c>=0;c--)
        {
            reversed+=target.substring(c, c+1);
        }
        return reversed;
    }
    
    public static boolean palindromeWord(String target)
    {
        return target.equals(reverse(target));
    }
    
    public static String removeAccents(String target)
    {
        String accented    = "áàâäãÁÀÂÄÃçÇíìîïÍÌÎÏéèêëÉÈÊËñÑóòôöÓÒÔÖúùûüÚŨÛÜ";
	String nonAccented = "aaaaaAAAAAcCiiiiIIIIeeeeEEEEnNooooOOOOuuuuUUUU";
	for (int i=0; i<accented.length() ; i++) 
		target = target.replace(accented.charAt(i), nonAccented.charAt(i));
	return target;
    }
    
    public static String removeNonAlphabetic(String target)
    {
        return target.replaceAll("[^A-Za-z]", "");
    }
    
    public static boolean palindromeSentence(String target) {	
        target = removeAccents(target);  
        target = removeNonAlphabetic(target);  
	target = target.toLowerCase();   
	return palindromeWord(target);
    }
    
    public static String extract(String target, String seperator, int n)
    {
        String [] words=target.split(seperator);
        String extractedWord="";
        if(n<=words.length) extractedWord=words[n-1]; 
        return extractedWord;
    }
    
    public static ArrayList<String> extractAll(String target, String seperator)
    {
        ArrayList<String> alExtracted=new ArrayList<>();
        String [] words=target.split(seperator);
        for(int w=0;w<words.length;w++)
        {
            alExtracted.add(words[w]);
        }
        return alExtracted;   
    }
    
}
