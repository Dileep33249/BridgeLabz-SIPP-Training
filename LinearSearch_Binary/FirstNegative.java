package BinarySearch;
import java.util.*;
public class SearchForNegative {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int [] arr={4,6,9,7,-6,7};

        System.out.println(arr);
      
        
    }private static int helper(int [] arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i] < 0){
                return i;
            }
        }
        
        return -1;
    }
}
