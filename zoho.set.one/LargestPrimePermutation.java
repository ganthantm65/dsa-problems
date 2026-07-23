public class LargestPrimePermutation {
    private static int largestPrime=Integer.MIN_VALUE;
    static void findLargestPrime(String num,String prime,int n,int[] map){
        if(prime.length()==n){
            int primeNo=Integer.parseInt(prime);
            if(isPrime(primeNo)){
                largestPrime=Math.max(largestPrime, primeNo);
            }
        }
        for (int i = 0; i < n; i++) {
            if(map[i]!=1){
                map[i]=1;
                prime+=num.charAt(i);
                findLargestPrime(num, prime, n, map);
                map[i]=0;
                prime=prime.substring(0,prime.length()-1);
            }
        }
    }
    static boolean isPrime(int n)
    {
        if (n <= 1)
            return false;

        for (int i = 2; i * i <= n; i++)
        {
            if (n % i == 0)
                return false;
        }

        return true;
    }
    public static void main(String[] args) {
        String no="4691";
        int[] map=new int[no.length()];
        findLargestPrime(no, "", no.length(), map);
        System.out.println("Larget Possible Prime from "+no+" is "+largestPrime);
    }
}
