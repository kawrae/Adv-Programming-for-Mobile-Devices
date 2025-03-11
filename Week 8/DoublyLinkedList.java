public class DoublyLinkedList {
    private Node head;

    public DoublyLinkedList() {
        this.head = null;
    }

    public void insertEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    public void insertBefore(int target, int data) {
        if (head == null) return;

        Node current = head;

        // find the node with the target value
        while (current != null && current.data != target) {
            current = current.next;
        }

        // if target isnt found do nothing
        if (current == null) {
            System.out.println("Target value " + target + " not found.");
            return;
        }

        Node newNode = new Node(data);
        newNode.next = current;
        newNode.prev = current.prev;

        if (current.prev != null) {
            current.prev.next = newNode;
        } else {
            head = newNode;
        }

        current.prev = newNode;
    }

    public void display() {
        Node temp = head;
        System.out.println("Doubly Linked List:");
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
