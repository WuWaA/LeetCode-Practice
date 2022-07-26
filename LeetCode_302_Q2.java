public class LeetCode_302_Q2 {
    public static int maximumSum(int[] nums) {
        int max = -1;
        int leng = nums.length;
        int save[][] = new int[leng][11];
        for (int i = 0; i < leng; i++) { // O(n)
            String a = nums[i] + "";
            int sum = 0;
            for (int m = 0; m < a.length(); m++) // amount of digits
                save[i][(a.charAt(m) - '0')]++;
            for (int m = 0; m < 10; m++) // calculate sum
                sum += save[i][m] * m;
            save[i][10] = sum;
        }
        for (int i = 0; i < leng - 1; i++) { // O(nlogn)
            int sum_a = save[i][10];
            for (int j = i + 1; j < leng; j++) {
                int sum_b = save[j][10];
                if (i != j && sum_a == sum_b) {
                    int sum = nums[i] + nums[j];
                    if (sum > max)
                        max = sum;
                }
            }
        }
        return max;
    }

    public static int maximumSum2(int[] nums) {
        // the max sum is 81, so we save all sum and their index
        // later we will only calculate the value of index with same sum
        int max = -1;
        int leng = nums.length;
        int sum_index[][] = new int[81][10001]; // nums.length <= 10^5
        /** calculate digits sum **/
        for (int i = 0; i < leng; i++) { // loop of nums
            String a = nums[i] + "";
            int sum = 0;
            for (int m = 0; m < a.length(); m++) // loop of digits
                sum += a.charAt(m) - '0'; // or, will "divide by 10" be faster?
            sum_index[sum][sum_index[sum][10000]] = sum;
            sum_index[sum][10000]++; // use last extra index to record the size
        }
        /** find largest sum of "same digits sum" nums **/
    }

    public static void main(String[] args) {
        System.out.println(maximumSum(new int[] { 18, 43, 36, 13, 7 }));
    }
}
