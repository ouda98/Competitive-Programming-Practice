package FacebookPreInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class BooleanQueries {
    public static void main(String[] args) {
        boolean [] array = new boolean[10];
        Query [] queries = new Query[10];
        queries[0] = new Query(1,5);
        queries[1] = new Query(1,3);
        queries[2] = new Query(2,4); //5
        queries[3] = new Query(2,6); //-1
        queries[4] = new Query(2,1); //3
        queries[5] = new Query(1,7);
        queries[6] = new Query(1,2);
        queries[7] = new Query(1,9);
        queries[8] = new Query(2,9); //-1
        queries[9] = new Query(2,8);// 9

        System.out.println(Arrays.toString(queries));

        TreeSet<Integer> set = new TreeSet<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            int type = queries[i].type;
            int index = queries[i].index;
            if(type==1) {
                array[index] = true;
                set.add(index);
            }else{
                System.out.println(set);
                if(set.higher(index)!=null)
                    res.add(set.higher(index));
                else
                    res.add(-1);
            }



        }
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(res.toArray()));
    }
    public static class Query{
        int type;
        int index;
        public Query(int type, int index){
            this.type = type;
            this.index = index;
        }

        public String toString(){
            return type+" "+index;
        }
    }
}
