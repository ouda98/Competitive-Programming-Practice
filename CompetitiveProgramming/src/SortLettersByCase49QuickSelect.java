import java.util.Arrays;

public class SortLettersByCase49QuickSelect {
    public static void main(String[] args) {
        String r = "AbAbbbbbAcBJKJKJKJKJKaaaaaaaaaaaaaaaaaaaaaaaaaa";
        char[] chars = r.toCharArray();
        partition(chars,0,chars.length-1);
        System.out.println(Arrays.toString(chars));
    }
    public static void quickSelect(char [] nums, int l, int r, int target){
        int index = partition(nums,l,r);
    }

    public static int partition(char [] nums, int l, int r){
        char pivot = 'Z';
        int loc = l;
        char temp;
        for(int i=l;i<r;i++){
            if(nums[i]>pivot){
                temp = nums[i];
                nums[i] = nums[loc];
                nums[loc++] = temp;
            }
        }
        temp = nums[r];
        nums[r] = nums[loc];
        nums[loc] = temp;
        return loc;
    }
}
