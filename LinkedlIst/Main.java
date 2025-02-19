class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Main {
    public static ListNode removeNodes(ListNode head, int x) {
        while(head != null && head.val > x){
        head = head.next;
        }
     if (head == null) return null;
        ListNode temp = head;
        ListNode prev = null;

        while(temp != null){
        if(temp.val > x ){
            prev.next = temp.next;
        }
        else{
            prev= temp;
        }
        temp = temp.next;
        }
        return head;
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Creating the linked list: [5, 3, 7, 2, 6, 1]
        ListNode listHead = new ListNode(5);
        listHead.next = new ListNode(3);
        listHead.next.next = new ListNode(7);
        listHead.next.next.next = new ListNode(2);
        listHead.next.next.next.next = new ListNode(6);
        listHead.next.next.next.next.next = new ListNode(1);

        int x = 4;
        listHead = removeNodes(listHead, x);
        printList(listHead); // Expected output based on your implementation
    }
}
