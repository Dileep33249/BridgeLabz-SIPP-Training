package Dsa;
import java.util.*;
    public class Merge{
        public static void main(String [] args){

            int [] test={5,5,6,5,9,7,8};

            int [] ans=helper(test);

            for(int i=0;i<ans.length;i++) {
                System.out.print(ans[i] + " ");
            }

        }private static int[] helper(int [] arr){
            if(arr.length <= 1){
                return arr;
            }
            int mid=arr.length/2;

            int n1=mid;
            int n2=arr.length-mid;

            int [] left=new int[n1];
            for(int i=0;i<mid;i++){
                left[i]=arr[i];
            }
            int [] right=new int[n2];
            for(int j=0;j<arr.length-mid;j++){
                right[j]=arr[j+mid];
            }

            int [] first=helper(left);
            int[] second=helper(right);

            return helper2(first,second);


        }
        private static int [] helper2(int [] left,int [] right){
            int [] ans=new int[left.length+right.length];

            int i=0;
            int j=0;
            int k=0;

            while(i < left.length && j < right.length){
                if(left[i] <= right[j]){
                    ans[k++]=left[i++];
                }else{
                    ans[k++]=right[j++];
                }
            }

            while(i < left.length){
                ans[k++]=left[i++];
            }

            while(j < right.length){
                ans[k++]=right[j++];
            }

            return ans;
        }
    }
