package patterns;

public class Hello{
    public static void main(String[] args){
        String s="Hello";
        // for(int i=0;i<s.length();i++){
        //     for(int j=0;j<s.length();j++){
        //         if(i==j || (i+j)==s.length()-1){
        //             System.out.print(s.charAt(i)+" ");
        //         }else{
        //             System.out.print("  ");
        //         }
        //     }
        //     System.out.println();
        // }

        for(int i=0;i<s.length();i++){
            for(int j=0;j<s.length();j++){
                if((i==j) || (i+j)==s.length()-1  ){
                    System.out.print(s.charAt(s.length()-i-1)+" " );
                }else{
                    System.out.print("  ");
                }
            }
        System.out.println();
        }
    }
}