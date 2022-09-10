import java.util.HashMap;
// import java.util.HashSet;

public class The_Number_of_Weak_Characters_in_the_Game {
    public int numberOfWeakCharacters(int[][] properties) {
        // Failed Try
        /*
        int counter = 0;
        for (int i = 0; i < properties.length; i++) {
            for (int j = i; j < properties.length; j++) {
                if (properties[j][0] == properties[i][0] && properties[j][1] > properties[i][1]) {
                    int[] temp = properties[j];
                    properties[j] = properties[i];
                    properties[i] = temp;
                } else if (properties[j][0] > properties[i][0]) {
                    int[] temp = properties[j];
                    properties[j] = properties[i];
                    properties[i] = temp;
                }
            }
        }
        for (int i = 0; i < properties.length - 1; i++) {
            if (properties[i][0] > properties[i + 1][0] && properties[i][1] > properties[i + 1][1]) {
                counter += 1;
            }
        }
        return counter;
        */

        // Time Limit Exceeded O(N^2)
        /*
        int counter = 0;
        HashSet<Integer> s = new HashSet<Integer>();
        for (int i = 0; i < properties.length; i++) {
            for (int j = i; j < properties.length; j++) {
                if (properties[i][0] > properties[j][0] && properties[i][1] > properties[j][1]) {
                    if (!s.contains(j)) {
                        counter += 1;
                        s.add(j);
                    }
                    continue;
                } else if (properties[i][0] < properties[j][0] && properties[i][1] < properties[j][1]) {
                    if (!s.contains(i)) {
                        counter += 1;
                        s.add(i);
                    }
                    continue;
                }
            }
        }
        return counter;
        */

        /**
         * https://leetcode.com/submissions/detail/795927436/
         * Runtime: 78 ms
         * Memory Usage: 94.4 MB
         */
        HashMap<Integer, Integer> map = new HashMap<>();
        int counter = 0;
        int max = 0;
        for (int i = 0; i < properties.length; i++) {
            if (properties[i][0] > max)
                max = properties[i][0];
            if (!map.containsKey(properties[i][0]) || (map.containsKey(properties[i][0]) && map.get(properties[i][0]) < properties[i][1]))
                map.put(properties[i][0], properties[i][1]);
        }
        int previous = map.get(max);
        for (int i = max - 1; i > 0; i--)
            if (!map.containsKey(i))
                map.put(i, previous);
            else if (previous > map.get(i))
                map.put(i, previous);
            else
                previous = map.get(i);
        for (int i = 0; i < properties.length; i++)
            if (properties[i][0] < max && properties[i][1] < map.get(properties[i][0] + 1))
                counter++;
        return counter;
    }
}
