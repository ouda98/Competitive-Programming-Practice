import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrangeInterviewCity {
    public class Solution {
        /**
         * @param cost: The cost of each interviewer
         * @return: The total cost of all the interviewers.
         */
        public int TotalCost(List<List<Integer>> cost) {
            // write your code here
            Comparator<List<Integer>> cmp = new Comparator<List<Integer>>() {
                public int compare(List<Integer> first,List<Integer> second) {
                    if (first.get(1) - first.get(0) == second.get(1) - second.get(0)) {
                        return 0;
                    }
                    else if (first.get(1) - first.get(0) < second.get(1) - second.get(0)) {
                        return -1;
                    }
                    else {
                        return 1;
                    }
                }
            };

            Collections.sort(cost, cmp);
            int ans = 0;
            for(int i=0;i<cost.size();i++){
                if(i*2<cost.size())
                    ans+=cost.get(i).get(1);
                else
                    ans+=cost.get(i).get(0);
            }
            return ans;
        }
    }
}
