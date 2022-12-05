import java.util.ArrayList;

public class MinStack {
    public static void main(String[] args) {

    }
    class MinStack1 {
        int min;
        ArrayList<Integer> arr;
        int pointer;

        public MinStack1() {
            min = Integer.MAX_VALUE;
            arr = new ArrayList<>();
            pointer = -1;
        }

        public void push(int val) {
            min = Math.min(min,val);
            pointer++;
            if(arr.size()<=pointer)
                arr.add(val);
            else
                arr.set(pointer,val);
        }

        public void pop() {
            if(min == arr.get(pointer)){
                min = Integer.MAX_VALUE;
                for(int i=0;i<pointer;i++)
                    min = Math.min(min, arr.get(i));
            }
            pointer--;
        }

        public int top() {
            return arr.get(pointer);
        }

        public int getMin() {
            return min;
        }
    }
}
