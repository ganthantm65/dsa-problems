    package monotonic_stack;

    import java.util.Stack;

    public class SumofSubarrayRanges {

        public static void main(String[] args){
            int[] arr={1,4,3,2};
            long large=sumOfSubarrayMaximum(arr);
            long small=sumOfSubarrayMinimums(arr);

            System.out.print(large-small);
        }

        static long sumOfSubarrayMaximum(int[] arr){
            int[] nge=new int[arr.length];
            Stack<Integer> st=new Stack<>();
            for(int i=arr.length-1;i>=0;i--){
                while (!st.isEmpty() && arr[st.peek()]<=arr[i]) {
                    st.pop();
                }

                if(st.isEmpty()){
                    nge[i]=arr.length;
                }else{
                    nge[i]=st.peek();
                }
                st.push(i);
            }
            st.clear();
            int[] pge=new int[arr.length];
            for(int i=0;i<arr.length;i++){
                while (!st.isEmpty() && arr[st.peek()]<arr[i]) {
                    st.pop();
                }

                if(st.isEmpty()){
                    pge[i]=-1;
                }else{
                    pge[i]=st.peek();
                }
                st.push(i);
            }

            long total=0;
            

            for (int i = 0; i < arr.length; i++) {
                int j=i-pge[i];
                int k=nge[i]-i;

                total+=(long)(j*k*arr[i]);
            }

            return total;
        }
        static long sumOfSubarrayMinimums(int[] arr){
            int[] nse=new int[arr.length];
            Stack<Integer> st=new Stack<>();
            for(int i=arr.length-1;i>=0;i--){
                while (!st.isEmpty() && arr[st.peek()]>=arr[i]) {
                    st.pop();
                }

                if(st.isEmpty()){
                    nse[i]=arr.length;
                }else{
                    nse[i]=st.peek();
                }
                st.push(i);
            }
            st.clear(); 
            int[] pse=new int[arr.length];
            for(int i=0;i<arr.length;i++){
                while (!st.isEmpty() && arr[st.peek()]>arr[i]) {
                    st.pop();
                }

                if(st.isEmpty()){
                    pse[i]=-1;
                }else{
                    pse[i]=st.peek();
                }
                st.push(i);
            }

            long total=0;
            

            for (int i = 0; i < arr.length; i++) {
                int j=i-pse[i];
                int k=nse[i]-i;

                total+=(long)(j*k*arr[i]);
            }

            return total;
        }
    }
