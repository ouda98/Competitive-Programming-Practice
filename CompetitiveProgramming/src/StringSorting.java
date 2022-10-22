import java.util.Arrays;

public class StringSorting {
    public class Solution {
        /**
         * @param s: string
         * @return: sort string in lexicographical order
         */
        public String sorting(String s) {
            // write your code here
            String[] r = s.split(",");
            Arrays.sort(r);
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<r.length;i++){
                if(i == 0)
                    sb.append(r[i]);
                else
                    sb.append(','+r[i]);
            }
            return sb.toString();
        }
    }
}
