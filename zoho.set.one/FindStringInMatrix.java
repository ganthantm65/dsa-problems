public class FindStringInMatrix {
    public static void main(String[] args){
        String str="WELCOMETOZOHOCORPORATION";
        char[][] charMatrix=new char[5][5];
        int k=0;
        for(int i=0;i<5;i++){
            for (int j = 0; j < 5; j++) {
                if (k < str.length()) {
                    charMatrix[i][j] = str.charAt(k++);
                } else {
                    charMatrix[i][j] = ' ';
                }
            }
        }
        String substr="TOO";

        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(charMatrix[i][j]!=substr.charAt(0)){
                    continue;
                }
                if(i+substr.length()<=5){
                    k=0;
                    for(;k<substr.length();k++){
                        if (charMatrix[i+k][j]!=substr.charAt(k)) {
                            break;
                        }
                    }
                    if(k==substr.length()){
                        System.out.println("Found Vertically");
                        System.out.println("Start Index : <" + i + "," + j + ">");
                        System.out.println("End Index   : <" + (i+substr.length()-1) + "," + j + ">");
                        return;
                    }
                }

                if(j+substr.length()<=5){
                    k=0;
                    for(;k<substr.length();k++){
                        if (charMatrix[i][j+k]!=substr.charAt(k)) {
                            break;
                        }
                    }
                    if(k==substr.length()){
                        System.out.println("Found Horizontally");
                        System.out.println("Start Index : <" + i + "," + j + ">");
                        System.out.println("End Index   : <" + i + "," + (j + substr.length() - 1) + ">");
                        return;
                    }
                }
            }
        }
    }
}
