package BinarySearch;
import java.util.*;
public class peakElement {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int [] test={5,11,1,8,9,2,7,3};

        helper(test);
    }
    private static void helper(int [] arr){
        int left=0;
        int right=arr.length-1;

                while(left < right){
                    int mid=left +(right- left)/2;
                    if(arr[mid] > arr[mid-1]&& arr[mid] > arr[mid+1]){
                        System.out.println(arr[mid]);
                        System.exit(0);
                    }
                    else if(arr[mid] < arr[mid+1]){
                        left=mid+1;
                    }else{
                        right=mid;
                    }
                }
    }
}
