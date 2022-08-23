import java.util.LinkedList;

/**
 * Time Limit Exceeded
 */
public class Split_Array_into_Consecutive_Subsequences {
    public static boolean isPossible(int[] nums) {
        LinkedList<Pair> arr2d = new LinkedList<Pair>();
        boolean noSort = true;
        arr2d.add(new Pair(1, nums[0])); // {size,head}
        for (int i = 1; i < nums.length; i++) {
            int size = arr2d.size();
            boolean flag = true;
            if (!noSort && size > 1) {
                sort(arr2d);
                noSort = true;
            }
            for (int j = 0; j < size; j++) {
                if (nums[i] == arr2d.get(j).tail + 1) {
                    arr2d.get(j).subLen++;
                    arr2d.get(j).tail++;
                    flag = false;
                    break;
                }
            }
            if (flag) {
                arr2d.addFirst(new Pair(1, nums[i]));
                noSort = false;
            }
        }
        for (Pair n : arr2d) {
            if (n.subLen < 3)
                return false;
        }
        return true;
    }

    static void sort(LinkedList<Pair> list) {
        // faster when almost sorted -> insertion sort
        for (int i = 1; i < list.size(); i++) {
            Pair hold = list.get(i);
            int len = hold.subLen;
            int j = i - 1;

            while (j >= 0 && list.get(j).subLen > len) {
                list.set(j + 1, list.get(j));
                j = j - 1;
            }
            list.set(j + 1, hold);
        }
    }

    public static void main(String[] args) {
        System.out.println(isPossible(new int[] { 1, 2, 3, 3, 4, 5 }));

        System.out.println(isPossible(new int[] { 1, 2, 3, 3, 4, 4, 5, 5 }));

        System.out.println(isPossible(new int[] { 1, 2, 3, 4, 4, 5 }));
    }
}

class Pair {
    int subLen, tail;

    Pair(int a, int b) {
        subLen = a;
        tail = b;
    }
}