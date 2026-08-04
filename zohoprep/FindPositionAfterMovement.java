package zohoprep;

public class FindPositionAfterMovement {
    static int[] findPosition(int x,int y,String movements){
        for (int i = 0; i < movements.length(); i++) {
            char ch=movements.charAt(i);
            if(ch=='U'){
                y++;
            }else if(ch=='D'){
                y--;
            }else if(ch=='L'){
                x--;
            }else if(ch=='R'){
                x++;
            }
        }
        return new int[]{x,y};
    }
    public static void main(String[] args) {
        int[] res=findPosition(4, 5, "ULRRDDULR");
        System.out.println(res[0]+","+res[1]);
    }
}
