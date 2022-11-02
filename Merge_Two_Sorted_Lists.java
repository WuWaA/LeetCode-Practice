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
public class Merge_Two_Sorted_Lists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        boolean flag = true;
        ListNode node = new ListNode();
        ListNode keep = node;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                node.val = list2.val;
                list2 = list2.next;
            } else if (list2 == null) {
                node.val = list1.val;
                list1 = list1.next;
            } else if (list1.val < list2.val) {
                node.val = list1.val;
                list1 = list1.next;
            } else if (list1.val >= list2.val) {
                node.val = list2.val;
                list2 = list2.next;
            }
            if (list1 != null || list2 != null) {
                node.next = new ListNode();
                node = node.next;
            }
        }
        return keep;
    }
}
