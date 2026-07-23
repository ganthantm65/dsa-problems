import java.util.Arrays;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums){
        int[] res=new int[nums.length];
        Arrays.fill(res,1);
        int post=1,pre=1;
        for(int i=0;i<nums.length;i++){
            res[i]=pre;
            pre*=nums[i];
        }
        for(int i=nums.length-1;i>=0;i--){
            res[i]*=post;
            post*=nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        ProductExceptSelf obj=new ProductExceptSelf();
        int[] arr={1,2,3,4};
        int[] result=obj.productExceptSelf(arr);
        System.out.println(Arrays.toString(result));
    }
}
