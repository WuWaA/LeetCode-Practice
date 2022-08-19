public class Remove_Digit_From_Number_to_Maximize_Result {
    /**
     * Runtime: 12 ms; Your runtime beats 7.80 % of java submissions.
     * Memory Usage: 43.3 MB; Your memory usage beats 12.54 % of java submissions.
     * @param number
     * @param digit
     * @return result
     */
    public String removeDigit1(String number, char digit) {
        char current;
        char next;
        String part1 = "";
        String part2 = "";
        String part3 = number;
        for (int i = 0; i < number.length(); i++) {
            current = number.charAt(i);
            // equal and non-end
            if (current == digit && i < number.length() - 1) {
                next = number.charAt(i + 1);
                if (next > current) {
                    part3 = number.substring(i + 1); // i+1 to end
                    return part1 + part2 + part3;
                } else {
                    part1 += part2; // 0 to i-1
                    part2 = current + ""; // i
                }
            }
            // equal and end
            else if (current == digit && i == number.length() - 1) {
                part3 = number.substring(i + 1); // i+1 to end
                return part1 + part2 + part3;
            }
            // not equal
            else {
                part2 += current;
            }
        }
        return part1 + part2.substring(1);
    }

    /**
     * Runtime: 1 ms, faster than 98.67% of Java online submissions for Remove Digit From Number to Maximize Result.
     * Memory Usage: 41.9 MB, less than 88.69% of Java online submissions for Remove Digit From Number to Maximize Result.
     * @param number
     * @param digit
     * @return
     */
    public String removeDigit2(String number, char digit) {
        // I don't need to split and save them at all
        char current;
        char next;
        int last = 0;
        int length = number.length();
        for (int i = 0; i < length; i++) {
            current = number.charAt(i);
            // equal and non-end
            if (current == digit && i < length - 1) {
                next = number.charAt(i + 1);
                if (next > current)
                    return number.substring(0, i) + number.substring(i + 1);
                else
                    last = i; // last seen
            }
            // equal and end
            else if (current == digit)
                return number.substring(0, i);
        }
        return number.substring(0, last) + number.substring(last + 1);
    }
}
