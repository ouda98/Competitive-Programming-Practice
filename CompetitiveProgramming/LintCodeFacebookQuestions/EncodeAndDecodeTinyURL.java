package LintCodeFacebookQuestions;

import java.util.HashMap;

public class EncodeAndDecodeTinyURL {
    public static void main(String[] args) {

    }
    public class Solution {
        static int counter =0;
        static HashMap<String,String> map = new HashMap<>();
        public String encode(String longUrl) {
            // Encodes a URL to a shortened URL.
            map.put(longUrl,"http://tinyurl.com/"+counter);
            map.put("http://tinyurl.com/"+counter,longUrl);
            return "http://tinyurl.com/"+counter++;
        }


        public String decode(String shortUrl) {
            return map.get(shortUrl);
        }
    }

}
