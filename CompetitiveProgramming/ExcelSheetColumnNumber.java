public class ExcelSheetColumnNumber {
    public static void main(String[] args) {

    }
    public int titleToNumber(String columnTitle) {
        int total =0;
        for(int i=0;i<columnTitle.length();i++){
            total += (columnTitle.charAt(i) - 'A' +1) * ((int)Math.pow(26,columnTitle.length()-1-i));
        }
        return total;
    }
}
