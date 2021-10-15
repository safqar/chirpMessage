
package chirptracker;
import org.junit.Test;
import static org.junit.Assert.*;

public class ChirpTrackerTest {
    public ChirpTrackerTest() {
    }

    @Test 
    public void toShortString() {       //testing trimText when message is less than 140 in length
        String observed = ChirpTracker.trimText("Hello World!", " 06/28/2021 99999 Jack Daniels");  
        String expected = "Hello World! 06/28/2021 99999 Jack Daniels";
        assertEquals(expected, observed);
    }
    @Test 
    public void toLongString() {        //testing trimText when message is greater than 140 in length
        String observed = ChirpTracker.trimText("This is a maximum length chirp because I like writing long chirps. "
                + "Why? I'm not really sure. Maybe I'm just a rebel.. or maybe it's a phase?"
                ," 04/22/2021 100 John Smith");  
        
        String expected = "This is a maximum length chirp because I like writing long chirps. "
                + "Why? I'm not really sure. Maybe I'm just a r... 04/22/2021 100 John Smith";
                
        assertEquals(expected, observed);
    }

 @Test 
    public void emojiString() {         //testing addEmoji to add an emoji when method is called
        String fireEmoji = "🔥";   
        String observed = ChirpTracker.addEmoji("This chirp probably won't get a lot of attention.");   
        String expected = "This chirp probably won't get a lot of attention. "+fireEmoji;
        assertEquals(expected, observed);
    }

}
