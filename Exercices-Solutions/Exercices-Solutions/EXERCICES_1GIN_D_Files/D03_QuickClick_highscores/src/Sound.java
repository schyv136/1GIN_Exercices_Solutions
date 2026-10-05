import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
/**
 * Simple replacement for good old Pascal 'Beep' Function
 * 
 * @author  fred faber
 * @version 2013-03-02
 */
public class Sound {
    
    public static final int SAMPLE_RATE = 48 * 1024; // ~48KHz
    private final AudioFormat af;
    private SourceDataLine  line;
    
    //will contain 1 sine wave in best resolution (1s <-> 1Hz)
    //--> data for 1 sinus period only has to be calculated once
    private byte[] sin = new byte[SAMPLE_RATE]; 

    public Sound()  {
        fillSin(); //init sine wave data
        af   = new AudioFormat(SAMPLE_RATE, 8, 1, true, true);        
    }
    
    public void openAudioStream() {
        //Open Audio System                
        if (line == null || !line.isOpen()) {
            try {
                line = AudioSystem.getSourceDataLine(af);
                line.open(af, SAMPLE_RATE);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
            }
            line.start();   
        }   
    }

   
    public void beep(int freq, int ms) {
        final int len = SAMPLE_RATE*ms/1000 + 3; //length of output stream
        final byte[] out = new byte[len]; //output stream
        final int f = freq;               //because freq has to be final inside thread class
       
        (new Thread() {@Override
        public void run() { //thread => don't block calling program
                openAudioStream();
                //get data from sine wave array 
                //Idea: 2Hz   => take every 2nd   byte from 'sin'
                //      3Hz   => take every 3rd   byte from 'sin'
                //      100Hz => take every 100th byte from 'sin'
                for (int i=0 ; i<len ; i++)
                            out[i] = sin[(i*f)%SAMPLE_RATE]; 
                
                //'fade' at the end...
                out[len-3]=(byte)(out[len-4]/2);
                out[len-2]=(byte)(out[len-3]/2);
                out[len-1]=0;
                
                //write output stream to AudioSystem & beep
                line.write(out, 0, len);
                line.drain(); 
                // System.out.println(line.getBufferSize());
                // System.out.println(line.available());
                line.close();   //Windows: Line must be closed (sounds bad on a Mac)     
        }}).start(); //start thread

     }
    
    /**
     * fills 'sin' array with one period of a sine wave 
     * Uses best resolution i.e. SAMPLE_RATE elements for 1 Hz at 1sec.
     * Is only called once during construction
     */
    private void fillSin() { 
            double f = 1;
            for (int i = 0; i < sin.length; i++) {
                double period = (double)SAMPLE_RATE / f;
                double angle = 2.0 * Math.PI * i / period;
                sin[i] = (byte)(Math.sin(angle) * 127f);
            }
    }


    @Override
    protected void finalize() throws Throwable
    {
        //drain remaining data and close line 
        line.drain();
        line.close();
        super.finalize(); //not necessary if extending Object.
    } 
}