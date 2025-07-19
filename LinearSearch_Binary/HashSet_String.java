import java.util.*;
Public class HashSet_String{
    public static void main(System.in);
Scanner sc=new Scanner(System.in);
     StringBuilder sb=new Stringbuilder();\
     String str=sc.next();

     HashnSet<Character> hm=new HashSet<>();
     for(int i=0 ; i< str.length();i++){
        if(hm.contains(str.charAt(i))){
            continue;
        }else{
                sb.append(str.charAt(i));
                hm.add(str.charAt(i));
        }
     }
  System.out.println(sb);
}