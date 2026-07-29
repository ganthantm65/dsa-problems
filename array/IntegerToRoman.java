public class IntegerToRoman {
    static String convertIntegerToRoman(int num){
        int[] intArray={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] roman={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder result=new StringBuilder();
        for(int i=0;i<intArray.length;i++){
            while(num>=intArray[i]){
                result.append(roman[i]);
                num=num-intArray[i];
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        System.out.println(convertIntegerToRoman(3));
    }
}