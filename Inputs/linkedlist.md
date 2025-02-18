import java.util.Scanner;

class ListNode {
    int data;
    ListNode next;

    // Constructor to initialize the node with a value
    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class linkedlist {

    // Function to insert a node at the tail of the linked list
    public static ListNode insertNodeAtTail(ListNode head, int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            return newNode; // First node becomes the head
        }

        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode; // Insert new node at the end
        return head;
    }

    // Function to print the linked list (each element on a new line)
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of elements to insert at the tail
        int n = scanner.nextInt();

        ListNode head = null;

        // Insert n elements at the tail of the linked list
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            head = insertNodeAtTail(head, data); // Insert each element at the tail
        }

        // Print the resulting linked list
        printList(head);

        scanner.close();
    }
}
