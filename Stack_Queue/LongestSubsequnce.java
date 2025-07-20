class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hm=new HashSet<>();
        for(int i:nums){
            hm.add(i);
        }
        int ans=0;
        for(int i:hm){
            if(hm.contains(i-1)){
                continue;
            }
            else{
                int j=i;
                while(hm.contains(j)){
                   j++;
                }
                ans=Math.max((j-i),ans);
            }
        }
        return ans;
        
    }
}