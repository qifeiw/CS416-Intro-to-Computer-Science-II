/**
 * @author Qifei Wang
 * @version 1
 */

public class algorithmAnalysis {
   /**
    * 
    * @param array array
    * @param start start
    * @param end end
    * @return int
    */

    public static int sumSubArray(int[] array, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += array[i];
        }
        return sum;
    }
    /**
     * 
     * @param arr array
     * @return max sum of sub array
     */

    // Algorithm 1, O(n^3)
    public static int algorithm1(int[] arr) {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) { //O(n)
            for (int j = 0; j + i <= n; j++) { //O(n)
                int sum = sumSubArray(arr, j, j + i); //O(n)
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }
    /**
     * 
     * @param arr array
     * @return max sum of sub array
     */

    //Algorithm 2, O(n^2)
    public static int algorithm2(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int n = arr.length;
        for (int i = 0; i < n; i++) { //O(n)
            int preSum = 0;
            for (int j = i; j < n; j++) { //O(n)
                preSum += arr[j];
                if (preSum > maxSum) {
                    maxSum = preSum;
                }
            }
        }
            return maxSum;
        }
    
    /**
     * 
     * @param arr arr
     * @return max sum of sub array
     */

     //Algorithm 3 O(n)
    public static int algorithm3(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int j : arr) { //O(n)
            currentSum += j;
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr1 = {-1, 12, -3, 14, -4, 3};
        System.out.println("Algorithm 1: " + algorithm1(arr1));  
        System.out.println("Algorithm 2: " + algorithm2(arr1));  
        System.out.println("Algorithm 3: " + algorithm3(arr1));  
    
        int[] arr2 = {2, -3, 5, -1, 0, 7};
        System.out.println("Algorithm 1: " + algorithm1(arr2));  
        System.out.println("Algorithm 2: " + algorithm2(arr2));  
        System.out.println("Algorithm 3: " + algorithm3(arr2));  
}
}