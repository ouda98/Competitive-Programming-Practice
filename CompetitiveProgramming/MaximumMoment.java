public class MaximumMoment {
    public class Solution {
        /**
         * @param time: a string of Time
         * @return: The MaximumMoment
         */
        public String MaximumMoment(String time) {
            // Write your code here.
            String result = "";
            if(time.charAt(0) == '?' && (time.charAt(1) == '?' || (time.charAt(1)>='0' && time.charAt(1)<='3'))){
                result+="2";
            }else if(time.charAt(0) == '?'){
                result+="1";

            }else{
                result+= "" + time.charAt(0);
            }

            if(time.charAt(1) == '?' && result.charAt(0) == '2'){
                result+="3";
            }else if(time.charAt(1) == '?' && result.charAt(0) != '2'){
                result+="9";
            }else{
                result+=""+time.charAt(1);
            }

            result+=":";
            if(time.charAt(3) == '?')
                result+= "5";
            else
                result+= "" + time.charAt(3);
            if(time.charAt(4) == '?'){
                result+= "9";
            }
            else
                result+= "" + time.charAt(4);
            return result;
        }
    }
}
