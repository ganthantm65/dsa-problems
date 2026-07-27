

public class LongestContinousString {
    static int findContinousString(String str,int k){
        int l=0,r=0;
        int D=0,ans=0;
        int[] freq_map=new int[26];
        for (; r < str.length(); r++) {
            if(freq_map[str.charAt(r)-'a']==0){
                D++;
            }
            freq_map[str.charAt(r)-'a']++;
            while ((r-l+1)-D > k) {
                freq_map[str.charAt(l)-'a']--;
                if (freq_map[str.charAt(l)-'a'] == 0)
                    D--;
                l++;
            }
            ans=Math.max(ans,D);
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.print(findContinousString("abcabcbb", 1));
    }
}