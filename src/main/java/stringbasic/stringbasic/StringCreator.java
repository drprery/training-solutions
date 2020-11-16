package stringbasic.stringbasic;

public class StringCreator {

    public String createStringForHeap(){
        return new String("This is a String.");
    }

    public String createStringForPool(){
        return "This is a String.";
    }
}