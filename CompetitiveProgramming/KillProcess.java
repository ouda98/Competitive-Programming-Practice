import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KillProcess {
    public static void main(String[] args) {

    }
    public class Solution {
        /**
         * @param pid: the process id
         * @param ppid: the parent process id
         * @param kill: a PID you want to kill
         * @return: a list of PIDs of processes that will be killed in the end
         */
        static HashMap<Integer, ArrayList<Integer>> adj;
        static List<Integer> result;
        public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
            // Write your code here
            result = new ArrayList<>();
            adj = new HashMap<>();
            for(int i=0;i<pid.size();i++){
                if(adj.containsKey(ppid.get(i))){
                    adj.get(ppid.get(i)).add(pid.get(i));
                }else{
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(pid.get(i));
                    adj.put(ppid.get(i),list);
                }
            }
            dfs(kill);
            return result;
        }
        public static void dfs(int value){
            result.add(value);
            if(adj.get(value) == null)
                return;
            ArrayList<Integer> connected = adj.get(value);
            for(Integer num : connected){
                dfs(num);
            }

        }

    }
}
