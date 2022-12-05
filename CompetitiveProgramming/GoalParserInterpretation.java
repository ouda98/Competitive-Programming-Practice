public class GoalParserInterpretation {
    public static void main(String[] args) {

    }
    public String interpret(String command) {
        StringBuilder result = new StringBuilder();
        for(int i=0;i<command.length();i++){
            if(command.charAt(i) == '('){
                if(command.charAt(i+1) == ')'){
                    i++;
                    result.append("o");
                }else{
                    i+=3;
                    result.append("al");
                }
                continue;
            }
            result.append(""+command.charAt(i));
        }
        return result.toString();
    }
}
