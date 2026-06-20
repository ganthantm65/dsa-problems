package monotonic_stack;

import java.util.Stack;

public class SumofSubarrayMinimum {
    public static void main(String[] args){
        int[] arr={3,1,2,4};
        int[] pse=findPse(arr);
        int[] nse=findNse(arr);

        long total=0;
        

        for (int i = 0; i < arr.length; i++) {
            int j=i-pse[i];
            int k=nse[i]-i;

            total+=(long)(j*k*arr[i]);
        }

        System.out.println(total);
    }
    static int[] findNse(int[] arr){
        int[] res=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while (!st.isEmpty() && arr[st.peek()]>=arr[i]) {
                st.pop();
            }

            if(st.isEmpty()){
                res[i]=arr.length;
            }else{
                res[i]=st.peek();
            }
            st.push(i);
        }
        return res;
    }
    static int[] findPse(int[] arr){
        int[] res=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<arr.length;i++){
            while (!st.isEmpty() && arr[st.peek()]>arr[i]) {
                st.pop();
            }

            if(st.isEmpty()){
                res[i]=-1;
            }else{
                res[i]=st.peek();
            }
            st.push(i);
        }
        return res;
    }
}
