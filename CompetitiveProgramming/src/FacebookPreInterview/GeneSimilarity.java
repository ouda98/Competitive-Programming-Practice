package FacebookPreInterview;

public class GeneSimilarity {
    public static void main(String[] args) {
        String one = "3T2G4A1C";
        String two = "6T1A2C1G";
        System.out.println(countSimilar(one,two));
    }
    static int geneOneCounter;
    static int geneTwoCounter;
    static String countSimilar(String firstGene, String SecondGene){

        geneOneCounter = 0;
        geneTwoCounter = 0;
        int count1 = 0;
        int count2 = 0;
        char char1 = 'a';
        char char2 = 'b';
        int result =0;
        int total = 0;
        while(geneOneCounter<firstGene.length() || geneTwoCounter<SecondGene.length()){
            if(count1==0){
                count1 = getDigit1(firstGene);
                char1 = firstGene.charAt(geneOneCounter++);
            }
            if(count2==0){
                count2 = getDigit2(SecondGene);
                total += count2;
                char2 = SecondGene.charAt(geneTwoCounter++);
            }
            if(char1 == char2){
                result += Math.min(count1,count2);
                if(count1<count2){
                    count2 -=count1;
                    count1 =0;
                }else{
                    count1-= count2;
                    count2 =0;
                }
            }
            if(char1 != char2){
                if(count1<count2){
                    count2 -=count1;
                    count1 =0;
                }else{
                    count1-= count2;
                    count2 =0;
                }

            }

        }
        return result+"/"+total;
    }

    static int getDigit1(String firstGene){
        StringBuilder digit = new StringBuilder();
        while(Character.isDigit(firstGene.charAt(geneOneCounter))){
            digit.append(firstGene.charAt(geneOneCounter));
            geneOneCounter++;
        }
        return Integer.parseInt(digit.toString());
    }
    static int getDigit2(String firstGene){
        StringBuilder digit = new StringBuilder();
        while(Character.isDigit(firstGene.charAt(geneTwoCounter))){
            digit.append(firstGene.charAt(geneTwoCounter));
            geneTwoCounter++;
        }
        return Integer.parseInt(digit.toString());
    }

}
