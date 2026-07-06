public class BuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};

        BuyAndSellStock buyAndSellStock = new BuyAndSellStock();
        int res = buyAndSellStock.maxProfit(prices);
        System.out.println(res);
    }
    public int maxProfit(int[] prices) {
        int l=0;
        int maxPrice=0;
        for(int r=1;r<prices.length;r++){
            if(prices[l]>prices[r]){
                l=r;
            }else{
                maxPrice=Math.max((prices[r]-prices[l]),maxPrice);
            }
        }
        return maxPrice;
    }
}
