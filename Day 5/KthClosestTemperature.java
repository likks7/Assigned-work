import java.util.Random;
import java.util.Scanner;

public class KthClosestTemperature {
    public static int findKthClosest(int[] readings, int target, int k) {
        return quickSelect(readings, target, 0, readings.length - 1, k - 1);
    }

    private static int quickSelect(int[] readings, int target, int left, int right, int k) {
        if (left == right) return readings[left];
        int pivotIndex = partition(readings, target, left, right);
        if (k == pivotIndex) return readings[k];
        return k < pivotIndex ? quickSelect(readings, target, left, pivotIndex - 1, k) 
                              : quickSelect(readings, target, pivotIndex + 1, right, k);
    }

    private static int partition(int[] readings, int target, int left, int right) {
        int pivotIndex = new Random().nextInt(right - left + 1) + left;
        swap(readings, pivotIndex, right);
        int pivotValue = Math.abs(readings[right] - target), storeIndex = left;
        for (int i = left; i < right; i++) {
            if (Math.abs(readings[i] - target) < pivotValue || 
                (Math.abs(readings[i] - target) == pivotValue && readings[i] < readings[right])) {
                swap(readings, storeIndex++, i);
            }
        }
        swap(readings, storeIndex, right);
        return storeIndex;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of readings: ");
        int n = scanner.nextInt();
        int[] readings = new int[n];
        System.out.println("Enter the readings: ");
        for (int i = 0; i < n; i++) readings[i] = scanner.nextInt();
        System.out.print("Enter target temperature: ");
        int target = scanner.nextInt();
        System.out.print("Enter k: ");
        int k = scanner.nextInt();
        
        System.out.println(k + "-th closest temperature: " + findKthClosest(readings, target, k));
        scanner.close();
    }
}
