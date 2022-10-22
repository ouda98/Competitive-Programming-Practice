import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MeetingRooms {
    public static void main(String[] args) {

    }

  public static class Interval{
      int start, end;
      Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }

  }



    public class Solution {
        /**
         * @param intervals: an array of meeting time intervals
         * @return: if a person could attend all meetings
         */
        public boolean canAttendMeetings(List<Interval> intervals) {
            // Write your code here
            Collections.sort(intervals,new sort());
            for(int i=0;i<intervals.size()-1;i++){
                if(intervals.get(i).end > intervals.get(i+1).start)
                    return false;
            }
            return true;
        }
        public static class sort implements Comparator<Interval> {
            public int compare(Interval a, Interval b){
                return a.start - b.start;
            }
        }
    }
}
