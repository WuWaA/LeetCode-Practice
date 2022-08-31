public class Middle_of_the_Linked_List {
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        boolean flag = false;
        while (head != null) {
            head = head.next;
            if (!flag)
                flag = true;
            else {
                flag = false;
                slow = slow.next;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        // ListNode node5 = new ListNode(1);
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        System.out.println(middleNode(node1));
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
