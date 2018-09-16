package leetcode;

/**
 * At a lemonade stand, each lemonade costs $5.

 Customers are standing in a queue to buy from you, and order one at a time (in the order specified by bills).

 Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill.  You must provide the correct change to each customer, so that the net transaction is that the customer pays $5.

 Note that you don't have any change in hand at first.

 Return true if and only if you can provide every customer with correct change.



 Example 1:

 Input: [5,5,5,10,20]
 Output: true
 Explanation:
 From the first 3 customers, we collect three $5 bills in order.
 From the fourth customer, we collect a $10 bill and give back a $5.
 From the fifth customer, we give a $10 bill and a $5 bill.
 Since all customers got correct change, we output true.
 Example 2:

 Input: [5,5,10]
 Output: true
 Example 3:

 Input: [10,10]
 Output: false
 Example 4:

 Input: [5,5,10,10,20]
 Output: false
 Explanation:
 From the first two customers in order, we collect two $5 bills.
 For the next two customers in order, we collect a $10 bill and give back a $5 bill.
 For the last customer, we can't give change of $15 back because we only have two $10 bills.
 Since not every customer received correct change, the answer is false.


 Note:

 0 <= bills.length <= 10000
 If a customer brings a $5 bill, then we take it.

 If a customer brings a $10 bill, we must return a five dollar bill. If we don't have a five dollar bill, the answer is False, since we can't make correct change.

 If a customer brings a $20 bill, we must return $15.

 If we have a $10 and a $5, then we always prefer giving change in that, because it is strictly worse for making change than three $5 bills.

 Otherwise, if we have three $5 bills, then we'll give that.

 Otherwise, we won't be able to give $15 in change, and the answer is False.
 Time Complexity: O(N)O(N), where NN is the length of bills.

 Space Complexity: O(1)O(1).
 */
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill: bills) {
            if (bill == 5)
                five++;
            else if (bill == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
