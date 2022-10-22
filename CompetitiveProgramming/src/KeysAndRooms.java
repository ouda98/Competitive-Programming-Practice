import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms {
    public class Solution {
        /**
         * @param rooms: a list of keys rooms[i]
         * @return: can you enter every room
         */
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            // Write your code here
            int countRooms = rooms.size();
            HashSet<Integer> visited = new HashSet<>();
            visited.add(0);
            Queue<Integer> toVisit = new LinkedList<>();
            for(int i=0;i<rooms.get(0).size();i++){
                if(!visited.contains(rooms.get(0).get(i)))
                    toVisit.add(rooms.get(0).get(i));
            }
            while(!toVisit.isEmpty()){
                int r = toVisit.poll();
                visited.add(r);

                for(int i=0;i<rooms.get(r).size();i++){
                    if(!visited.contains(rooms.get(r).get(i)))
                        toVisit.add(rooms.get(r).get(i));
                }

            }
            if(visited.size() == rooms.size())
                return true;
            return false;
        }
    }
}
