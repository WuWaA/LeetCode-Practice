public class Two_Sum {
    public static int[] twoSum(int[] nums, int target) {
        // Constraints: Only one valid answer exists.
        // Thus we could assume some situation to cutting down the average time complexity
        // Faced Problem: -1000 + 1000 = 0, thus cannot ignore number
        // Worst time: O(N^2), Average time: O(1/4N^2)
        for (int i = 0; i < nums.length; i += 2) { // try half num1
                for (int j = i + 1; j < nums.length; j += 2) { // try half num2
                    if (nums[i] + nums[j] == target)
                        return new int[] { i, j };
                }
                for (int j = i + 2; j < nums.length; j += 2) { // if above failed, try another half num2
                    if (nums[i] + nums[j] == target)
                        return new int[] { i, j };
                }
        }
        for (int i = 1; i < nums.length; i += 2) { // if above failed, try another half num1
                for (int j = i + 1; j < nums.length; j += 2) { // try half num2
                    if (nums[i] + nums[j] == target)
                        return new int[] { i, j };
                }
                for (int j = i + 2; j < nums.length; j += 2) { // if above failed, try another half num2
                    if (nums[i] + nums[j] == target)
                        return new int[] { i, j };
                }
        }
        return null;
    }

    public static void main(String[] args) {
        int test[] = twoSum(new int[] { 0, 4, 3, 0 }, 0);
        System.out.println(test[0] + "," + test[1]);
    }
}
