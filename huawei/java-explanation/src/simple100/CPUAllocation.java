package simple100;

import java.util.Arrays;
import java.util.Scanner;

public class CPUAllocation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a1 = scanner.nextInt();
        int a2 = scanner.nextInt();

        int [] arr1 = new int[a1];
        int [] arr2 = new int[a2];

        for (int i=0;i<a1;i++){
            arr1[i] = scanner.nextInt();
        }

        for (int i=0;i<a2;i++){
            arr2[i] = scanner.nextInt();
        }

        int[] res = getSwapPower(arr1, arr2);
        System.out.println(res[0] + " " + res[1]);
    }

    //总公式 sum1 - a1 + a2 = sum2 - a2 + a1
    //sum1 - sum2 = 2*(a2 - a1)
    private static int[] getSwapPower(int[] arr1, int[] arr2) {
        int[] res = new int[2];
        int sum1 = Arrays.stream(arr1).sum();
        int sum2 = Arrays.stream(arr2).sum();
        int diff = sum1 - sum2;
        Arrays.stream(arr1).sorted();
        for (int num : arr1) {
            //二分查找
            if (Arrays.binarySearch(arr2, num - diff / 2) >= 0) {
                res[1] = num - diff / 2;
                res[0] = num;
                break;
            }
        }
        return res;
    }
}
