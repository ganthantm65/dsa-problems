package monotonic_stack;

import java.util.Stack;

public class PreviousSmallerElement {
    static int[] previousSmallerElements(int[] nums){
        int[] res=new int[nums.length];
        Stack<Integer> st=new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while(!st.isEmpty() && st.peek()>=nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i]=-1;
            }else{
                res[i]=st.peek();
            }
            st.push(nums[i]);
        }
        return res;
    }

    public static void main(String[] args){
        int[] nums={4,5,2,10,8};

        int[] res=previousSmallerElements(nums);

        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
