import java.util.ArrayList;

public class DesignBrowserHistory {
    public static void main(String[] args) {

    }
    class BrowserHistory {
        ArrayList<String> list;
        int pointer;

        public BrowserHistory(String homepage) {
            list = new ArrayList<>();
            list.add(homepage);
            pointer = 0;
        }

        public void visit(String url) {
            if(pointer < list.size()-1){
                while(list.size()>pointer+1)
                    list.remove(list.size()-1);
            }
            list.add(url);
            pointer++;
        }

        public String back(int steps) {
            pointer = Math.max(0, pointer-steps);
            return list.get(pointer);
        }

        public String forward(int steps) {
            pointer = Math.min(list.size()-1,pointer+steps);
            return list.get(pointer);
        }
    }
}
