import java.text.Normalizer;

public class Test
{

    public static void main(String[] args) 
    {
       	String someText = "Hello world";
	System.out.println(someText.substring(3));        
	System.out.println(someText.substring(6,8));    
	System.out.println(someText.substring(1,3));      
	System.out.println(someText.substring(0));      
	System.out.println(someText.substring(1));       
        
        //Test Normalizer:
        someText = "J'ai essayé d'éliminer les accents (éàèüäöçñ) de ce texte!";
	System.out.println(Normalizer.normalize(someText, Normalizer.Form.NFD));        
	//->  J'ai essayé d'éliminer les accents (éàèüäöçñ) de ce texte!
    }
}