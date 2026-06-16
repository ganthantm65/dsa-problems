package monotonic_stack;

import java.util.*;

public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums){
        int res[]=new int[nums.length];
        Stack<Integer> st=new Stack<>();
        for(int i=nums.length-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums[i]){
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

    public static void main(String[] args) {
        int nums[]={4,5,2,10};
        NextGreaterElement n=new NextGreaterElement();
        System.out.println(Arrays.toString(n.nextGreaterElement(nums)));
    }
}
