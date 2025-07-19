public class WordFinder{
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        String [] sentence=new String[5];

        for(int i=0;i<sentence.length;i++){
            sentence[i]=sc.next();
        }

        String word=sc.next();
    }
    private static boolean helper(String [] ar,String word){
        for(String str : sentence){
            if(str.conatains(word));
            return true;
        }
        return false;
    }
}