public class RomanToInteger {
    static int romanToInt(String s){
        int[] value = new int[128];

        value['I'] = 1;
        value['V'] = 5;
        value['X'] = 10;
        value['L'] = 50;
        value['C'] = 100;
        value['D'] = 500;
        value['M'] = 1000;
        int result=0;
        for(int i=0;i<s.length();i++){
            if(value[s.charAt(i)]<value[s.charAt(i+1)]){
                result-=value[s.charAt(i)];
            }else{
                result+=value[s.charAt(i)];
            }
        }
        result+=value[s.charAt(s.length()-1)];
        return result;
    }

    static boolean validateRoman(String roman) {
        int count = 1;

        for (int i = 1; i < roman.length(); i++) {

            if (roman.charAt(i) == roman.charAt(i - 1)) {
                count++;

                if (count > 3) {
                    return false;
                }

                if (roman.charAt(i) == 'V' ||
                    roman.charAt(i) == 'L' ||
                    roman.charAt(i) == 'D') {
                    return false;
                }
            } else {
                count = 1;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        System.out.print(romanToInt("VIIII"));
    }
}
