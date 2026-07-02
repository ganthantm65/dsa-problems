package monotonic_stack;

import java.util.Stack;

public class LargestRectangle {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new Stack<>();

        int maxArea=Integer.MIN_VALUE;

        for(int i=0;i<=heights.length;i++){
            while(!st.isEmpty() && (i==heights.length || heights[st.peek()]>heights[i])){
                int element=st.peek();
                st.pop();
                int nse=i;
                int pse=st.isEmpty()?-1:st.peek();
                maxArea=Math.max((heights[element]*(nse-pse-1)),maxArea);
            }
            st.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args){
        int[] arr={2,1,5,6,2,3};
        LargestRectangle lr=new LargestRectangle();
        System.out.println(lr.largestRectangleArea(arr));
    }
}
