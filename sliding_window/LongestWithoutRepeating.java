public class LongestWithoutRepeating {
    public int findLongest(String s){
        int l=0,r=0;
        int maxLength=0;
        int[] freq=new int[138];

        for(;r<s.length();r++){
            char ch=s.charAt(r);
            freq[ch]++;
            while(freq[ch]>1){
                freq[s.charAt(l)]--;
                l++;
            }
            maxLength=Math.max(maxLength, r-l+1);
        }
        return maxLength;
    }
    public static void main(String[] args) {
        LongestWithoutRepeating obj=new LongestWithoutRepeating();
        String s="abcabcbb";
        int result=obj.findLongest(s);
        System.out.println(result);
    }
}
