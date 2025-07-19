package Dsa;
import java.util.*;
public class Rotationpoint {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int [] testing={4,5,6,7,8,1,2,3};

        System.out.println(helper(testing));
    }
    private static int helper(int [] arr){
        int left=0;
        int right=arr.length-1;


        while(left < right){
            int mid=left+ (right-left)/2;

            if(arr[mid] > arr[right]){
                left=mid+1;
            }
            else{
                right=mid;
            }
        }
        return arr[left];
    }
}
