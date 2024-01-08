package medium200;

import java.util.Arrays;
import java.util.Scanner;

public class WonderLand {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line1 = input.nextLine();
        String line2 = input.nextLine();

        int[] prices = Arrays.stream(line1.split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] days = Arrays.stream(line2.split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(getLowestPrice(prices, days));
    }


    private static int getLowestPrice(int[] prices, int[] days) {
        int len = days.length;
        //动态规划，dp[i]表示第i天的最低价格
        int[] dp = new int[365];
        int cnt = 0;
        for (int i = 1; i < 365; i++) {
            dp[i] = dp[i - 1];
            if (i == days[cnt]) {
                dp[i] += prices[0];
                if (i >= 3) {
                    dp[i] = Math.min(dp[i], dp[i - 3] + prices[1]);
                }
                if (i >= 7) {
                    dp[i] = Math.min(dp[i], dp[i - 7] + prices[2]);
                }
                if (i >= 30) {
                    dp[i] = Math.min(dp[i], dp[i - 30] + prices[3]);
                }
                cnt++;
            }
            if (cnt >= len) {
                break;
            }
        }
        return dp[days[len - 1]];
    }
}
