import java.util.*;
public class Nanotime {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);

        long time1=System.nanoTime();
        StringBuilder sb=new StringBuilder();
        StringBuffer sbf=new StringBuffer();

        String str="Hello i am superman";

        for(int i=0;i<str.length();i++){
            sb.append(str.charAt(i));
        }
        long end1=System.nanoTime();
        long time2=System.nanoTime();
        for(int i=0;i<str.length();i++){
            sbf.append(str.charAt(i));
        }
        long end2=System.nanoTime();

        System.out.println("StringBuilder time "+-(time1-end1)+" ns");
        System.out.println("StringBuffer time "+-(time2-end2)+" ns");

    }
}
