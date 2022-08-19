/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Palindrome_Linked_List {
    static ListNode origin;

    public static boolean isPalindrome(ListNode head) {
        origin = head;
        return recursion(head);
    }

    public static boolean recursion(ListNode forward) {
        boolean flag = true;
        if (forward.next != null)
            flag = recursion(forward.next);
        if (!flag)
            return false;
        if (forward.val == origin.val) {
            origin = origin.next;
            return true;
        } else
            return false;
    }

    public static boolean isPalindrome2(ListNode head) {
        ListNode temp_prev = null;
        ListNode temp_next = head;
        ListNode half_speed = head;
        ListNode full_speed = head;
        int counter = 0;
        boolean flag = false;
        // T = N
        while (full_speed != null) {
            counter++;
            full_speed = full_speed.next;
            if (flag) {
                flag = false;
                temp_next = half_speed.next;
                half_speed.next = temp_prev;
                temp_prev = half_speed;
                half_speed = temp_next;
            } else
                flag = true;
        }

        // T = 0.5N
        if (counter % 2 == 0) {
            ListNode half_left = temp_next;
            while (temp_prev != null) {
                if (temp_prev.val != half_left.val)
                    return false;
                temp_prev = temp_prev.next;
                half_left = half_left.next;
            }
        } else {
            ListNode half_left = temp_next.next;
            while (temp_prev != null) {
                if (temp_prev.val != half_left.val)
                    return false;
                temp_prev = temp_prev.next;
                half_left = half_left.next;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(1);
        ListNode node4 = new ListNode(2, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        System.out.println(isPalindrome2(node1));
    }
}
