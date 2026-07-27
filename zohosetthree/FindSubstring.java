package zohosetthree;

public class FindSubstring {
    static int findSubString(String s,String l){
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)==l.charAt(0)){
                int j=0;
                while(i+j<s.length() && j<l.length() && s.charAt(i+j)==l.charAt(j)){
                    j++;
                }
                if(j==l.length()){
                    return i;
                }
                i=i+j;
            }else{
                i++;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.print(findSubString("test123str", "123"));
    }
}
