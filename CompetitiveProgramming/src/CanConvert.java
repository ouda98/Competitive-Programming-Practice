public class CanConvert {
    public static void main(String[] args) {

    }
    public boolean canConvert(String s, String t) {
        if(s == null || t == null)
            return false;
        int tCounter = 0;
        for(int sCounter=0;sCounter< s.length(); sCounter++){
            if(s.charAt(sCounter) == t.charAt(tCounter))
                tCounter++;
            if(tCounter == t.length())
                return true;
        }
        return false;
    }
}
