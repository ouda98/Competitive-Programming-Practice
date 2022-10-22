package LintCodeFacebookQuestions;

public class FriendsOfAppropriateAges {
    public static void main(String[] args) {
        int [] ages = {53,13,6,79,90,76,74,81,16,36,64,14,68,49,12,19,4,100,8,30,70,113,14,41,96,8,20,34,90,89,70,38,25,68,18,55,117,39,120,12,13};
        System.out.println(numFriendRequests(ages));
    }
    public static int numFriendRequests(int[] ages) {
        //
        int counter =0;
        int r =0;
        int [] sums = new int [121];
        for(int i=0;i<ages.length;i++)
            sums[ages[i]]++;
        int c =0;
        for(int i=1;i<121;i++){
            if(sums[i]==0)
                continue;

            for(int j=1;j<121;j++){
                if(sums[j]==0)
                    continue;

                if(i<j)
                    break;
                if(!((i*0.5+7)>=j || i<j || j>100 && i<100)){
                    counter+= sums[i]*(sums[j]-((i==j)?1:0));
                }
            }
        }
        return counter;
    }
}
