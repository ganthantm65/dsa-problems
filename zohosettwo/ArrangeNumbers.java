package zohosettwo;

public class ArrangeNumbers{
    public void arrangeMinMax(int[] arr){
        int l=0,r=arr.length-1,k=0;
        int[] temp=new int[arr.length];
        while(l<=r){
            temp[k++]=arr[r--];
            if(l<=r){
                temp[k++]=arr[l++];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i]=temp[i];
        }
    }
    public static void main(String[] args){
        int[] arr={1,2,3,4,5,6,7};
        ArrangeNumbers arrangeNumbers=new ArrangeNumbers();
        arrangeNumbers.arrangeMinMax(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}