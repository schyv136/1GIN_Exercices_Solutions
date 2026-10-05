import java.text.Normalizer;
import java.util.ArrayList;
 
/**
 * Cette classe contient une série de méthodes utilitaires 
 * pour le traitement de chaînes de caractères.
 * 
 * @author     fabfr
 * @version    27/09/2013 19:26:48
 */
public class GiString
{
	
/**
 * Supprime de la chaîne target la sous-chaîne qui se trouve entre beginIndex et endIndex.
 * La lettre à la position endIndex n'est pas touchée.  
 * La chaîne modifiée est retournée comme résultat. 
 * @param target        la chaîne à transformer
 * @param beginIndex    la position du début du traitement
 * @param endIndex      la position de la fin du traitement
 * @return  
 */
public static String delete(String target, int beginIndex, int endIndex) {
	return target.substring(0, beginIndex) + target.substring(endIndex);  
}


/**
 * Insère la chaîne str dans la chaîne target à la position index. 
 * La chaîne modifiée est retournée comme résultat.
 * @param target    la chaîne à transformer
 * @param str       la chaîne à insérer
 * @param index     la position d'insertion
 * @return          la chaîne transformée
 */
public static String insert (String target, String str, int index) {
	return target.substring(0, index) + str + target.substring(index);
}

/**
 * Compte combien de fois la sous-chaîne str apparaît dans target.
 * @param target    la chaîne à analyser
 * @param str       la chaîne à rechercher
 * @return          le nombre d'apparitions
 */ 
public static int count(String target, String str) {
	int result = 0;
	int l = str.length();
	while (target.indexOf(str)>=0) {
		result++;
		int p=target.indexOf(str);
		target = delete(target, 0 , p+l); // ne pas oublier l'affectation!!
	}
	return result;
}

/**
 * Retourne l'ordre des caractères dans la chaîne target. 
 * La chaîne modifiée est retournée comme résultat.
 * @param target    la chaîne à renverser
 * @return          la chaîne renversée
 */
public static String reverse (String target) {
	String result = "";
	for (int i=0; i<target.length() ; i++) 
		result = target.charAt(i) + result;
	return result;
}

/**
 * Retourne true si la chaîne target est un palindrome 
 * (c.-à-d. un mot qui reste exactement le même si on le lit de la fin vers le début).
 * @param target    la chaîne à analyser
 * @return          true ssi la chaîne est un palindrome, sinon false
 */
public static boolean palindromeWord(String target) {
	return target.equals(reverse(target));
}


/**
 * Remplace toutes les lettres spéciales ou accentuées (âàä,ïîí,ç,...) 
 * par les lettres non accentuées correspondantes (a,i,c,...). 
 * Le reste est inchangé.
 * 
 * @param target    la chaîne à transformer
 * @return          la chaîne transformée
 */
public static String removeAccents(String target) {
	String result = "";
	char c;
	for (int i=0; i<target.length() ; i++) {
		c = target.charAt(i);		
		if      (c=='á' || c=='à' || c=='â' || c=='ä' || c=='ã' )	result = result + 'a';
		else if (c=='Á' || c=='À' || c=='Â' || c=='Ä' || c=='Ã')	result = result + 'A';	
		else if (c=='ç')	result = result + 'c';
		else if (c=='Ç')	result = result + 'C';		
		else if (c=='í' || c=='ì' || c=='î' || c=='ï' )	result = result + 'i';
		else if (c=='Í' || c=='Ì' || c=='Î' || c=='Ï' )	result = result + 'I';
		else if (c=='é' || c=='è' || c=='ê' || c=='ë' )	result = result + 'e';
		else if (c=='É' || c=='È' || c=='Ê' || c=='Ë' )	result = result + 'e';
		else if (c=='ñ')	result = result + 'n';
		else if (c=='Ñ')	result = result + 'N';		
		else if (c=='ó' || c=='ò' || c=='ô' || c=='ö' )	result = result + 'o';
		else if (c=='Ó' || c=='Ò' || c=='Ô' || c=='Ö' )	result = result + 'O';
		else if (c=='ú' || c=='ù' || c=='û' || c=='ü' )	result = result + 'u';
		else if (c=='Ú' || c=='Ũ' || c=='Û' || c=='Ü' )	result = result + 'U';
		else result = result + c;
	}
	return result;
}

    /**
     * Remplace toutes les lettres spéciales ou accentuées (âàä,ïîí,ç,...) 
     * par les lettres non accentuées correspondantes (a,i,c,...). 
     * Le reste est inchangé.
     *
     * @param target    la chaîne à transformer
     * @return          la chaîne transformée
     */
    public static String removeAccents2(String target) {
	String result = "";
	char c;
	for (int i=0; i<target.length() ; i++) {
		c = target.charAt(i);		
		if      ("áàâäã".indexOf(c)!=-1)	result = result + 'a';
		else if ("ÁÀÂÄÃ".indexOf(c)!=-1)	result = result + 'A';	
		else if (c=='ç')				result = result + 'c';
		else if (c=='Ç')				result = result + 'C';		
		else if ("íìîï".indexOf(c)!=-1)	result = result + 'i';
		else if ("ÍÌÎÏ".indexOf(c)!=-1)	result = result + 'I';
		else if ("éèêë".indexOf(c)!=-1)	result = result + 'e';
		else if ("ÉÈÊË".indexOf(c)!=-1)	result = result + 'e';
		else if (c=='ñ')				result = result + 'n';
		else if (c=='Ñ')				result = result + 'N';		
		else if ("óòôö".indexOf(c)!=-1)	result = result + 'o';
		else if ("ÓÒÔÖ".indexOf(c)!=-1)	result = result + 'O';
		else if ("úùûü".indexOf(c)!=-1)	result = result + 'u';
		else if ("ÚŨÛÜ".indexOf(c)!=-1)	result = result + 'U';
		else result = result + c;
	}
	return result;
}


//Méthode Fränz Friederes
   /**
    * Remplace toutes les lettres spéciales ou accentuées (âàä,ïîí,ç,...) 
    * par les lettres non accentuées correspondantes (a,i,c,...). 
    * Le reste est inchangé.
    *
    * @param target    la chaîne à transformer
    * @return          la chaîne transformée
    */
    public static String removeAccents3(String target) {
	String accented    = "áàâäãÁÀÂÄÃçÇíìîïÍÌÎÏéèêëÉÈÊËñÑóòôöÓÒÔÖúùûüÚŨÛÜ";
	String nonAccented = "aaaaaAAAAAcCiiiiIIIIeeeeEEEEnNooooOOOOuuuuUUUU";
	for (int i=0; i<accented.length() ; i++) 
		target = target.replace(accented.charAt(i), nonAccented.charAt(i));
	return target;
}

   /**
    * Profiter de la classe java.text.Normalizer :
    * Remplace toutes les lettres spéciales ou accentuées (âàä,ïîí,ç,...) 
    * par les lettres non accentuées suivies de l'accent (a^,i´,c,...). 
    * Le reste est inchangé.
    * Exemple: 
    *    "J'ai essayé d'éliminer les accents (éàèüäöçñ) de ce texte!"
    * -> "J'ai essayé d'éliminer les accents (éàèüäöçñ) de ce texte!"
    * 
    * @param target    la chaîne à transformer
    * @return          la chaîne transformée
    */
    public static String removeAccents4(String target) {
	return Normalizer.normalize(target, Normalizer.Form.NFD);
    }


/**
 * Supprime tous les espaces et autres caractères spéciaux, 
 * ne laissant que les lettres alphabétiques (majuscules ou minuscules). 
 * La chaîne modifiée est retournée comme résultat.
 * 
 * @param target    la chaîne à transformer
 * @return          la chaîne transformée
 */
public static String removeNonAlphabetic (String target) {
	String result = "";
	char c;
	for (int i=0; i<target.length() ; i++) {
		c = target.charAt(i);		
		if (c>='a' && c<='z' || c>='A' && c<='Z' )
			result = result + c;
	}
	return result;
}


/**
 * Retourne true si la chaîne target est un palindrome. 
 * Cette méthode ignore tous les caractères spéciaux, 
 * la casse (majuscule, minuscule), et considère 
 * les lettres accentuées comme des lettres non accentuées.
 * @param target    la chaîne à analyser
 * @return          true ssi la chaîne est un palindrome, sinon false
 */
public static boolean palindromeSentence(String target) {	
        target = removeAccents(target);
	//System.out.println(target);    
        target = removeNonAlphabetic(target);
	//System.out.println(target);    
	target = target.toLowerCase();
	///System.out.println(target);    
	return palindromeWord(target);
}


/**
 * Soit target une chaîne qui contient un certain nombre de sous-chaînes, 
 * qui sont séparées par un séparateur separator. 
 * La méthode extractString retourne la n-ième sous-chaîne de la chaîne target. 
 * Si le numéro n donné est supérieur au nombre de sous-chaînes, 
 * la fonction retourne une chaîne vide. 
 * @param target    la chaîne à découper
 * @param separator le séparateur des sous-chaînes
 * @param n         l'ordre de la sous-chaîne recherchée
 * @return          la sous-chaîne recherchée
 */
public static String extract(String target, String separator, int n)  {
	String result = "";
	int l = separator.length();
	target = target+separator; // pour trouver plus facilement la dernière sous-chaîne
	while (target.indexOf(separator)>=0 && n>=1) {
		int p=target.indexOf(separator);
		result = target.substring(0,p);
		target = delete(target, 0 , p+l);  // ne pas oublier l'affectation!!
		n--;
	}
	if (n==0)	return result;
	else      return "";      //si on est arrivé à la fin de la chaîne
}




/**
 * Employez la méthode extract pour séparer toutes les sous-chaînes de target 
 * en les ajoutant une à une dans une ArrayList. 
 * @param target        la chaîne à découper
 * @param separator     le séparateur des sous-chaînes
 * @return              la liste contenant les sous-chaînes
 */
public static ArrayList<String> extractAll(String target, String separator) {
	ArrayList<String> al = new ArrayList<>();

	//Ajouter un séparateur à la fin si nécessaire
	if (!separator.equals ( target.substring(target.length()-separator.length())))
	    target = target + separator;
	//découper la chaîne
	for (int i=1 ; i<=count(target,separator) ; i++) {
		al.add(extract(target,separator,i));
	}
	return al;
}

	
}