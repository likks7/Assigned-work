import java.util.Arrays;
import java.util.Scanner;

public class MinimumCoinChange {
    public static int findMinCoins(int[] denominations, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, target + 1);
        dp[0] = 0;
        
        for (int denom : denominations) {
            for (int amount = denom; amount <= target; amount++) {
                dp[amount] = Math.min(dp[amount], dp[amount - denom] + 1);
            }
        }
        
        return dp[target] > target ? -1 : dp[target];
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of denominations: ");
        int n = scanner.nextInt();
        int[] denominations = new int[n];
        
        System.out.println("Enter the denominations: ");
        for (int i = 0; i < n; i++) {
            denominations[i] = scanner.nextInt();
        }
        
        System.out.print("Enter the amount: ");
        int target = scanner.nextInt();
        
        int result = findMinCoins(denominations, target);
        System.out.println("Minimum coins needed: " + result);
        
        scanner.close();
    }
}
