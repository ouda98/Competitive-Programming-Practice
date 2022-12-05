public class MirrorReflection {
    public static void main(String[] args) {

    }
    public int mirrorReflection(int p, int q) {
        int i=q;
        int count = 1;
        while(i%p != 0){
            i+=q;
            count++;
        }
        if(i/p %2 ==0)
            return 0;
        if(count%2==0)
            return 2;
        return 1;
    }
}
