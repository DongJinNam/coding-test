package leetcode;

public class SolutionArray1 {

    // Remove Duplicates From Sorted Array
    // https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/727/
    public static int removeDuplicates(int[] nums) {
        int count[] = new int[201];
        int answer = 0;
        for (int i = 0; i < nums.length; i++)
            count[nums[i] + 100]++;

        int index = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                answer++;
                nums[index++] = i - 100;
            }
        }
        return answer;
    }

    // Best Time to Buy and Sell Stock II
    // https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/564/
    public static int maxProfit(int[] prices) {
        boolean isBuy = false;
        int buyPrice = 0;
        int answer = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] > prices[i + 1]) {
                if (isBuy) {
                    isBuy = false;
                    answer += (prices[i] - buyPrice);
                }
            } else {
                if (!isBuy) {
                    isBuy = true;
                    buyPrice = prices[i];
                }
            }
        }
        if (isBuy) {
            answer += prices[prices.length - 1] - buyPrice;
        }
        return answer;
    }
}
