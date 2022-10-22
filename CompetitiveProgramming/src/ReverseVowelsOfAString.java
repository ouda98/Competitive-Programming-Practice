public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        String s = "Dh0p4PjCrZfpEa1cZc3L7xS4moVQJtLum9w86WksSNsoyh3EMh2TCsZnUJuSMV31eKlnZGhIIw2PZ7LqoYA3QORIcIuWbdTJRMe6SIvE1B8HkIanJP0t9dbdPGrZmikiDfrOjbSwqiCqbEvuFVcCGrWuSkwzz4qsLYWDCAnIIq3vhsFoXtJGtGWKRrtC2jggnZ2CertgIuTTDVrszcfpZB0E0Ewfvm0Ocs6kWglMeoctswCMM8MXEHEw5iFYayyS9HGJS1jdLD9J1Ls8Q2KBhKg2wbRx2OOAnSqGw5fKtxglC9YwFaT3kO9gACpLfeSyGkrlFSIQIX5Y4BO9emrPdxuDq5FmmwhalNkiMvwcI0rLuw2jDGknRWbDn7dwHTpwP1WAGjimsRLUrCfcNFKWnXjKVTapKdo1EsIIxa2cdMJTKcde3vNhSjFQrEGDPoBSfsbFk1KSUsZ0wGffF3mL5Q5iKOIscqLCjiEgNYmvJwH5wu53mPnLyPxEmCqEqCgUfvUOMaxbSMi2KsXiEBVZOM1ZHWFd8hRqnXFzaTPQgxHOR3wkbhz3n8wxoRjcToIM2QaOTKMYLje9dLDe0QxZEKZuS2DWUv8PwkJx7vmQcf2WG5ome8uHnWRwgNjt2PngqRttrV1QGVVNyHSzoRR8VvkUo6XqRx9fMSxuJF8e4zSbj1CnPaGz68Tr1BMjJzgPg0WarfR6tLe3wFm3aS9sFnHCSReAugmRePD6rW2JikFTO9XZR5fshTTIAmhnUUbusrjh9IDF71cMiZf8AUEDI7RvsSivmEWlR3TrWxvsbHGJBiJn2rjfQJt3nrkTxjyaRFCBH6CRRlUCG7BxFf10aH0RE8dmegR7QsjNyL28lCFdhbJojOICdK93aBceU051ti9aMD6nC75eukwvZbk2wNUp8BEYMTszTLX7oMlwR4z5uadZ2I6bXINbv4jjzayC0qXznun9l7Ov7x9jhk15YLMdr97XFbsJj1ow0L3a";
        System.out.println(reverseVowels(s));
    }
    public static String reverseVowels(String s) {
        // write your code here
        int i=0;
        int j = s.length()-1;
        String result = "";
        String r = "";
        while(i<j){
            if(!isVowels(s.charAt(i))){
                result+= s.charAt(i);
                i++;
            }
            else if(!isVowels(s.charAt(j))){
                r= s.charAt(j)+r;
                j--;
            }
            else if(isVowels(s.charAt(i)) && isVowels(s.charAt(j))){
                result+=s.charAt(j);
                r+=s.charAt(i);
                i++;
                j--;
            }

        }
        if(i==j){
            result+=s.charAt(j);
        }
        return result+r;
    }
    public static boolean isVowels(char c){
        return (c == 'a' || c== 'o' || c== 'e' || c == 'u' || c =='i');
    }
}
