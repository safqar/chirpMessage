
package chirptracker;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class ChirpTracker {
    String chirp;
    String dated;
    int numViews;
    String Author;
    public ChirpTracker(String message, String date, int views, String authName){
        message = chirp;
        date = dated;
        numViews = views;
        authName = Author;
    }
    public String getMessage() {
    return chirp;
  }
  public void setMessage(String newMessage) {
    this.chirp = newMessage;
  }
  public String getDate() {
    return dated;
  }
  public void setDate(String newDate) {
    this.dated = newDate;
  }
  public String getAuthor() {
    return Author;
  }
  public void setAuthor(String newAuthor) {
    this.Author = newAuthor;
  }
    public static void main(String[] args) {
        String date = new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());      //output date
        String timedDate = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss").format(Calendar.getInstance().getTime());    //date and time
        
        String message = JOptionPane.showInputDialog("please enter Chirp message: ");       //get message
        String numViews = JOptionPane.showInputDialog("please enter Chirp views: ");        //get number of views
        int views = Integer.parseInt(numViews);         //convert views into integer for futher calculation
        String authName = JOptionPane.showInputDialog("please enter Chirp author name: ");  //get author name
        if("".equals(message) || numViews == null || "".equals(authName)){
            System.out.println("Please fill all required fields");
            System.exit(0);
        }
        System.out.printf("Message: %s Author: %s Date: %s Views: %s ", message, authName, timedDate, views);
        modifyChirp(message, date, views, authName); //call method modifyChirp to handle given data
    }
   public static String addEmoji(String rightSide){ 
        String fireEmoji = "🔥";   
        String rSideEmoji = (rightSide +" "+ fireEmoji);        //concat fireEmoji to the right side of message
            return rSideEmoji;
    }
    public static String trimText(String leftText, String rightText){
        String trimmedMessage = "", chirpMessage = "";
        int size = leftText.length()+rightText.length();        //get total size of message prior to trimming
        if(size > 140){
            int leftSide = 140 - rightText.length(); 
                chirpMessage = (leftText.substring(0, leftSide-3))+"...";       //truncate the chirp and append ... to it 
                trimmedMessage = (chirpMessage + rightText);   //after modifying the chirp message, it is concatenated with the right side
            return trimmedMessage;                   //return the trimmed chirp message to modifyChirp method
        }
        else
            return leftText+rightText;      //return concatenation of left and right text if it is not greater than 140
}
    
    public static void modifyChirp(String message, String date, int views, String authName) {
        String rightSide = (" " + date + " " + views + " " + authName);         //concat input data to the right side
        String chirpMessage = message + rightSide;                              //append both sides of the message
        if(views > 100000){                     //handle views and add an emoji if a chirp has greater than 100000 views
            String rSideEmoji = addEmoji(rightSide);    //return right side with emoji added to it
            //get entire size of chirp message including date, views author name and emoji
            int size = (message.length() + rSideEmoji.length());
            if(size > 140)
                {
                System.out.println("Formatted Output: "+trimText(message, rSideEmoji));  //call method trimText when length of message exceeds 140 chars
                }
            else        //if length does not exceed 140 characters then print the entire message in additiion to the emoji
            System.out.println("Formatted Output: "+message + rSideEmoji);
        }
        else if(chirpMessage.length() > 140)    //Handle message length when over 140 while views are equal to or less than 100000 
                {
                System.out.println("Formatted Output: "+trimText(message, rightSide));
        }
        
        else     //when message length is not greater than 140 chars and views do not exceed 100000, concat and display chirp
            System.out.println("Formatted Output: "+(message + rightSide));                    
    }
}

