package zohoprep;

public class RemoveDuplicate {
    static char nextChar(char ch) {
        if (ch >= 'a' && ch <= 'z')
            return ch == 'z' ? 'a' : (char) (ch + 1);

        if (ch >= 'A' && ch <= 'Z')
            return ch == 'Z' ? 'A' : (char) (ch + 1);

        if (ch >= '0' && ch <= '9')
            return ch == '9' ? '0' : (char) (ch + 1);

        return ch;
    }
    static String replaceDuplicate(String str){
        boolean[] visited=new boolean[128];
        StringBuilder res=new StringBuilder();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(!visited[ch]){
                res.append(ch);
                visited[ch]=true;
            }else{
                while(visited[ch]){
                    ch=nextChar(ch);
                }
                res.append(ch);
                visited[ch]=true;
            }
        }
        return res.toString();
    }
    public static void main(String[] args) {
        System.out.println(replaceDuplicate("Java123"));
    }
}
