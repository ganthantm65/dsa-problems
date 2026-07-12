package patterns;

public class Pascal {
    public static void main(String[] args) {
        int val=7;
        for(int i=1;i<=val;i++){
            int k=i;
            for(int j=1;j<=i;j++){
                System.out.print(k+" ");
                k+=(val-j);
            }
            System.out.println();
        }

    }
}
