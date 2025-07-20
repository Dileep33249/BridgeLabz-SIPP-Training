package BinarySearch;
import java.util.*;
public class Twosum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int target=10;
        int [] arr=new int[]{4,5,9,7,8};
         int [] ans=helper(arr,target);

         for(int j=0; j <ans.length;j++){
             System.out.println(ans[j]);
         }
    }
    private static int[] helper(int [] arr,int tar){
        HashMap<Integer,Integer> hm=new HashMap<>();
        int [] ans=new int[2];
        for(int i=0;i<arr.length;i++){
            if(hm.containsKey(tar - arr[i])){
                ans[0]=hm.get(tar- arr[i]);
                ans[1]=i;
                break;
            }
            else{
                hm.put(arr[i],i);
            }
        }
        return ans;
    }
}
