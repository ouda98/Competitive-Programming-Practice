package LintCodeFacebookQuestions;

public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        int n = 1234;
        String s = "";
        while(n>0){
            n = n-1;
            s = ((char) ('A'+(n%26)))+s;
            n=n/26;
        }
        System.out.println(s);

    }
}
