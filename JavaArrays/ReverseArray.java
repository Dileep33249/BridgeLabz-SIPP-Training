import java.util.*;

public class ReverseArray{
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

         int num=n;

        String temp=String.valueOf(n);
        int len=temp.length();

        int [] a=new int[len];

        int [] ans=new int[len];

        int idx=len-1;;

        while(num  > 0){
            ans[idx--]=num %10;
            num=num/10;
        }

        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }
    }

}