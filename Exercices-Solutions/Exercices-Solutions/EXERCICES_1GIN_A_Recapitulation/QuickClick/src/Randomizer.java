/**
 *										//3p
 * @author fred
 */
public class Randomizer {					
    
    public static int getInt(int min, int max) {
        return (int) (Math.random() * (max-min+1)) + min;
    }
    
}