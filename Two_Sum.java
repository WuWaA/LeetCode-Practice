public class Two_Sum {

    /**
     * 
     * Constraints: Only one valid answer exists.
     * Thus we could assume some situation to cutting down the average time complexity
     * Faced Problem: -1000 + 1000 = 0, thus cannot ignore number such as "nums[i] <= target"
     * Worst time: N*(N/2) = O(1/2N^2), Expected average time: (N/2)*(N/2) = O(1/4N^2)
     * Runtime: 47 ms, faster than 46.21% of Java online submissions for Two Sum.
     * Memory Usage: 44.9 MB, less than 65.14% of Java online submissions for Two Sum.
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
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

    /**
     * Optimal Solution O(N)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumHashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]))
                return new int[] {map.get(target - nums[i]), i};
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int test[] = twoSum(new int[] { 0, 4, 3, 0 }, 0);
        System.out.println(test[0] + "," + test[1]);
    }
}
