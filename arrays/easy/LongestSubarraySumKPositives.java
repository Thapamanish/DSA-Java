package arrays.easy;

public class LongestSubarraySumKPositives{

    private static int longestSubarray(int[] arr, int k){
    int n = arr == null ? 0: arr.length;

    int l = 0, sum = 0, best = 0;

    for(int r = 0; r < n; r++){
        sum += arr[r];

        if(l <= r && sum > k){
            sum -= arr[l++];
        }

        if(sum == k){
            best = Math.max(best, r - l + 1);
        }
    }
    return best;

    }
    public static void main(String[] main){
        int[] arr = {1, 2, 2, 1, 1, 1};
        int k = 3;

        System.out.println("longest subarray length: " + longestSubarray(arr, k));
    }
}