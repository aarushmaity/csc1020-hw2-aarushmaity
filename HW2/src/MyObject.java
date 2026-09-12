import java.io.Serializable;

public class MyObject implements Serializable {
    final int wholeNumber;
    final double fraction;
    final String words;

    public MyObject(int wholeNumber, double fraction, String words){
        this.wholeNumber = wholeNumber;
        this.fraction = fraction;
        this.words = words;
    }

    public String toString() {
        return wholeNumber+" "+fraction+" "+words;
    }
}
