package BinarySearch;
import java.util.*;
public class SortStack {
    public static void main(String[] args) {

        Stack<Integer> st=new Stack();
        st.add(5);
        st.add(9);
        st.add(6);
        st.add(7);
        System.out.println(st);

        stacksort2(st);
        System.out.println(st);
    }
    private static void stacksort(Stack<Integer> st,int x){
        if(st.isEmpty() || st.peek() < x){
            st.add(x);
            return;
        }
        int temp=st.pop();
        stacksort(st,x);
        st.add(temp);
    }

    private static void stacksort2(Stack<Integer> st){
        if(!st.isEmpty()){
            int x=st.pop();
            stacksort2(st);
            stacksort(st,x);
        }

    }
}
