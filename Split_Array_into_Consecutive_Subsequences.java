import java.util.LinkedList;

/**
 * Time Limit Exceeded
 */
public class Split_Array_into_Consecutive_Subsequences {
    public static boolean isPossible(int[] nums) {
        LinkedList<Pair> arr2d = new LinkedList<Pair>();

        arr2d.add(new Pair(1, nums[0])); // {size,head}
        for (int i = 1; i < nums.length; i++) {
            int size = arr2d.size();
            boolean flag = true;
            if (size > 1)
                sort(arr2d);
            /* try add valid value to shortest subsequence */
            /* need to sort the length of subsequences */
            for (int j = 0; j < size; j++) {
                if (nums[i] == arr2d.get(j).tail + 1) {
                    arr2d.get(j).subLen++;
                    arr2d.get(j).tail++;
                    flag = false;
                    break;
                }
            }
            if (flag)
                arr2d.addFirst(new Pair(1, nums[i]));
        }
        for (Pair n : arr2d) {
            if (n.subLen < 3)
                return false;
        }
        return true;
    }

    static void sort(LinkedList<Pair> list) {
        // use set() to swap
        // bobble sort? or should I use quick sort? see performance
        for (int i = list.size() - 1; i > 0; i--) {
            for (int j = i - 1; j > 0; j--) {
                if (list.get(i).subLen > list.get(j).subLen) {
                    Pair temp = new Pair(list.get(i).subLen, list.get(i).tail);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
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