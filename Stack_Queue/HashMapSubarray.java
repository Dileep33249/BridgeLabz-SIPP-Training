package BinarySearch;
import Dsa.HashM;

import java.util.*;
public class PrefixSum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int target=10;
   int [] arr=new int[]{1,8,3,9,1};
        System.out.println(helper(arr,target));

    }private static int helper(int [] arr,int tar){
        HashMap<Integer,Integer> hm=new HashMap<>();
       hm.put(0,1);
        int count=0;
        int prefixsum=0;

        for(int i=0;i<arr.length;i++){
            prefixsum+=arr[i];

            if(hm.containsKey(prefixsum-tar)){
                count+=hm.get(prefixsum-tar);
            }

            hm.put(prefixsum,hm.getOrDefault(prefixsum,0)+1);
        }
        return count;
    }
}
