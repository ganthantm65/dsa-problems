package zohosetthree;

public class StringComprehension {
    static String compressString(String str){
        StringBuilder res=new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if(Character.isAlphabetic(str.charAt(i))){
                res.append(str.charAt(i));
            }else if(Character.isDigit(str.charAt(i))){
                String no="";
                int l=i;
                while( l<str.length() && Character.isDigit(str.charAt(l))){
                    no+=str.charAt(l);
                    l++;
                }
                i=l-1;
                char c=res.charAt(res.length()-1);
                res.deleteCharAt(res.length()-1);
                for (int j = 0; j < Integer.parseInt(no); j++) {
                    res.append(c);
                }
            }
        }
        return res.toString();
    }
    public static void main(String[] args) {
        System.out.print(compressString("b3c6d15"));
    }
}
