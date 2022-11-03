public class Valid_Palindrome {
    public boolean isPalindrome(String s) {
        int length = s.length();
        int headIndex = 0, tailIndex = length - 1;
        char head, tail;
        while (headIndex < tailIndex) {
            head = s.charAt(headIndex);
            tail = s.charAt(tailIndex);
            while (headIndex < length - 1
                    && !(head >= '0' && head <= '9' || head >= 'A' && head <= 'Z' || head >= 'a' && head <= 'z')) {
                headIndex++;
                head = s.charAt(headIndex);
            }
            if (head >= 'A' && head <= 'Z') {
                head += 32;
            }
            while (tailIndex > 0
                    && !(tail >= '0' && tail <= '9' || tail >= 'A' && tail <= 'Z' || tail >= 'a' && tail <= 'z')) {
                tailIndex--;
                tail = s.charAt(tailIndex);
            }
            if (tail >= 'A' && tail <= 'Z') {
                tail += 32;
            }
            if (head == tail || headIndex > tailIndex) {
                headIndex++;
                tailIndex--;
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
