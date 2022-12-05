public class FinalValueOfVariableAfterPerformingOperations {
    public static void main(String[] args) {

    }
    public int finalValueAfterOperations(String[] operations) {
        int result = 0;
        for(String s: operations)
            result+= s.charAt(1) == '+'?1:-1;
        return result;
    }
}
