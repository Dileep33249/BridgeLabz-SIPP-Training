package BinarySearch;
import java.util.*;
public class FirstOccurnce {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int [] a={1,2,5,6,8,8};

        System.out.println(FirstOccur(a,8));

    }
    private static int FirstOccur(int [] arr,int tar){
        int left=0;
        int right=arr.length-1;
        int result=-1;

        while(left <= right){
            int mid=left + (right- left)/2;

            if(arr[mid]==tar){
                right=mid-1;
                result=mid;
            }else if(arr[mid] < tar){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
                return result;
    }

    private static int LastOccur(int [] arr,int tar){
        int left=0;
        int right=arr.length-1;
        int result=-1;

        while(left <= right){
            int mid=left + (right- left)/2;

            if(arr[mid]==tar){
                left=mid+1;
                result=mid;
            }else if(arr[mid] < tar){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
                return result;
    }
}
