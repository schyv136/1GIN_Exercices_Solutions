/**
 * Write a description of class "Crypter" here.
 * 
 * @author     fred
 * @version    01/10/2012 20:21:08
 */
public class Crypter
{
	
	/**
	 * Encrypte un texte selon l'algorithme "Shift by N"
	 * Uniquement les caractères alphabétiques majuscules sont chiffrés
	 * @param text   le texte à encrypter
	 * @param n      la distance de la rotation (1...26)
	 * @return le texte encrypté
	 */
	public static String encryptShiftByNPure(String text, int key)
	{		
		text = text.toUpperCase();
		String encryptedText = "";
		for (int i=0 ; i<text.length() ; i++)
		{
			char currentChar = text.charAt(i);
			
			if (currentChar>='A' && currentChar<='Z')
			{
				int code = (int)currentChar - (int)'A' + key;
				if (code >= 26) code -= 26;
				code += (int)'A';
				encryptedText = encryptedText + (char)code;	
			}				
			else 
				encryptedText = encryptedText + currentChar;	  //ajouter car. original
		}		
		return encryptedText;
	}

	/**
	 * Décrypte le texte mémorisé selon l'algorithme "Shift by N"
	 * @param text   le texte à décrypter
	 * @param n      la distance de la rotation (1...26)
	 * @return       le texte décrypté
	 */
	public static String decryptShiftByNPure(String text, int key)
	{		
		int keyIndex = 0;
		String decryptedText = "";
		for (int i=0 ; i<text.length() ; i++)
		{
			char currentChar = text.charAt(i);
			
			if (currentChar>='A' && currentChar<='Z')
			{
				int code = (int)currentChar - (int)'A' - key;
				if (code < 0) code += 26;
				code += (int)'A';
				decryptedText = decryptedText + (char)code;	
			}				
			else 
				decryptedText = decryptedText + currentChar;	  //ajouter car. original
		}		
		return decryptedText;
	}

	//===========================================================================================

	/**
	 * Encrypte un texte selon l'algorithme  "Shift by N" 
	 * @param text   le texte à encrypter
	 * @param key    la clé à employer lors de l'encryptage
	 * @return le texte encrypté
	 */
	public static String encryptShiftByN(String text, int n)
	{		
		String encryptedText = "";
		for (int i=0 ; i<text.length() ; i++)
		{
			int currentCode=(int)text.charAt(i);
			char c = (char)(currentCode + n);
			encryptedText = encryptedText + c;			   //ajouter car. chiffré
		}		
		return encryptedText;
	}

	/**
	 * Décrypte le texte mémorisé selon l'algorithme  "Shift by N"
	 * @param text   le texte à décrypter
	 * @param key    la clé à employer lors du décryptage
	 * @return       le texte décrypté
	 */
	public static String decryptShiftByN(String text, int n)
	{
		int keyIndex = 0;
		String decryptedText = "";
		for (int i=0 ; i<text.length() ; i++)
		{
			int currentCode=(int)text.charAt(i);
			char c = (char)(currentCode - n);
			decryptedText = decryptedText + c;		//ajouter car. déchiffré
		}		
		return decryptedText;
	}
	

	//===========================================================================================

	/**
	 * Encrypte un texte selon l'algorithme de Vigenère 
	 * Le déplacement de codes des caractères est de 1 pour 'A' , 2 pour 'B' etc.
	 * @param text   le texte à encrypter
	 * @param key    la clé à employer lors de l'encryptage
	 * @return le texte encrypté
	 */
	public static String encryptVigenere(String text, String key)
	{		
		int keyIndex = 0;
		String encryptedText = "";
		for (int i=0 ; i<text.length() ; i++)
		{
			int currentCode=(int)text.charAt(i);
			char c = (char)(currentCode + ((int)key.charAt(keyIndex) - (int)'A' + 1));
			encryptedText = encryptedText + c;			   //ajouter car. chiffré
			keyIndex = (keyIndex + 1) % key.length();
		}		
		return encryptedText;
	}

	/**
	 * Décrypte le texte mémorisé selon l'algorithme de Vigenère 
	 * @param text   le texte à décrypter
	 * @param key    la clé à employer lors du décryptage
	 * @return       le texte décrypté
	 */
	public static String decryptVigenere(String text, String key)
	{
		int keyIndex = 0;
		String decryptedText = "";
		for (int i=0 ; i<text.length() ; i++)
		{
			int currentCode=(int)text.charAt(i);
			char c = (char)(currentCode - ((int)key.charAt(keyIndex) - (int)'A' + 1));
			decryptedText = decryptedText + c;		//ajouter car. déchiffré
			keyIndex = (keyIndex + 1) % key.length();
		}		
		return decryptedText;
	}
	

	//===========================================================================================

}