public class MinimumAmountOfTimeToCollectGarbage {
    public static void main(String[] args) {

    }
    public int garbageCollection(String[] garbage, int[] travel) {
        int i = 0;
        int result = 0;
        for(int j=1;j<travel.length;j++)
            travel[j] += travel[j-1];
        int prevM = 0;
        int prevP = 0;
        int prevG = 0;
        int g;
        int p;
        int m;
        for(String garb : garbage){
            g = 0;
            p = 0;
            m = 0;
            for(int j=0;j<garb.length();j++){
                if(garb.charAt(j) == 'G')
                    g++;
                if(garb.charAt(j) == 'M')
                    m++;
                if(garb.charAt(j) == 'P')
                    p++;
            }
            result+=m+p+g;
            if(m!=0){
                result+= (i == 0)?0:travel[i-1] - prevM;
                prevM = (i == 0)?0:travel[i-1];
            }if(p!=0){
                result+= (i == 0)?0:travel[i-1] - prevP;
                prevP = (i == 0)?0:travel[i-1];
            }if(g!=0){
                result+= (i == 0)?0:travel[i-1] - prevG;
                prevG = (i == 0)?0:travel[i-1];;
            }
            i++;
        }
        return result;
    }
}
