package leetcode.algo.a;

import java.util.HashMap;

public class ApplyDiscountEverynOrders {
    class Cashier {
        private int limit, count;
        private int discount;
        private HashMap<Integer, Integer> priceTag;

        public Cashier(int n, int discount, int[] products, int[] prices) {
            this.count = 0;
            this.limit = n;
            this.discount = discount;
            this.priceTag = new HashMap<Integer, Integer>();
            for(int i = 0; i < products.length; i++){
                this.priceTag.put(products[i], prices[i]);
            }
        }

        public double getBill(int[] product, int[] amount) {
            this.count = (this.count + 1) % this.limit;
            double bill = 0;

            for(int i = 0; i < product.length; i++){
                bill += priceTag.get(product[i]) * amount[i];
            }

            if(this.count == 0){
                bill -= (double) this.discount * bill / 100.0;
            }

            return bill;
        }
    }

}
