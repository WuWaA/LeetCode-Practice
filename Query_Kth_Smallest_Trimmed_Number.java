public class Query_Kth_Smallest_Trimmed_Number {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int q_leng = queries.length;
        int result[] = new int[q_leng];
        for (int i = 0; i < q_leng; i++) { // queries
            int s_leng = nums[0].length(); // num digits
            int t_leng = nums.length; // total nums
            int index = queries[i][1]; // x-th smallest
            long save[] = new long[t_leng];
            long copy[] = new long[t_leng];
            if (s_leng >= index) {
                for (int j = 0; j < t_leng; j++) {
                    save[j] = Long.parseLong(nums[j].substring(s_leng - index));
                    copy[j] = save[j];
                }

            } else {
                for (int j = 0; j < t_leng; j++) {
                    save[j] = Long.parseLong(nums[j]);
                    copy[j] = save[j];
                }
            }
            // after trim
            long r = find(copy, queries[i][0]);
            //System.out.println(r);
            for (int j = t_leng - 1; j >= 0; j--) {
                //System.out.println(j+","+save[j]);
                if (save[j] == r) {
                    result[i] = j;
                    break;
                }
            }
        }
        return result;
    }

    public static long quicksort(long[] arr, int left, int right, int k) {
        int p = partition(arr, left, right, k);
        if (p == k) {
            return arr[p];
        } else if (k < p) {
            return quicksort(arr, left, p - 1, k);
        } else {
            return quicksort(arr, p + 1, right, k);
        }
    }

    private static int partition(long[] arr, int left, int right, int k) {
        long base = arr[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < base) {
                swap(arr, i, ++j);
            }
        }
        swap(arr, left, j);
        return j;
    }

    private static void swap(long[] arr, int i, int j) {
        if (i != j) {
            long temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static long find(long[] arr, int k) {
        return quicksort(arr, 0, arr.length - 1, k - 1);
    }
}
