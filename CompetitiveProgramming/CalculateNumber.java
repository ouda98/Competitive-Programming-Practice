import java.util.ArrayList;

public class CalculateNumber {
    public static void main(String[] args) {

    }
    public int[] calculateNumber(int num) {
        String s = Integer.toBinaryString(num);
        System.out.print(s);
        ArrayList<Integer> list = new ArrayList<>();
        int counter = 0;
        list.add(0);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '1'){
                counter++;
                list.add(i+1);
            }
        }
        list.set(0, counter);
        int[] arr = new int[list.size()];
        int i = 0;
        for(Integer e: list){
            arr[i] = e;
            i++;
        }
        return arr;
    }
}
