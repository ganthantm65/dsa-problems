public class JumpGame{
    public boolean canJump(int[] arr){
        int maxJump=Integer.MIN_VALUE;
        if(arr.length==1){
            return true;
        }
        for(int i=0;i<arr.length;i++){
            if(maxJump<i){
                return false;
            }
            maxJump=Math.max(i+arr[i],maxJump);
        }
        return true;
    }
    public static void main(String[] args){
        JumpGame obj=new JumpGame();
        int[] arr={2,3,1,0,4};
        System.out.println(obj.canJump(arr));
    }
}