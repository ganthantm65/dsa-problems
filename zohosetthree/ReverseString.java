package zohosetthree;

public class ReverseString {
    static String reverseString(String str){
        int index=str.indexOf(' ');
        if(index==-1){
            return str;
        }
        return reverseString(str.substring(index+1))+" "+str.substring(0,index);
    }
    public static void main(String[] args) {
        System.out.print(reverseString("I love India"));
    }
}
