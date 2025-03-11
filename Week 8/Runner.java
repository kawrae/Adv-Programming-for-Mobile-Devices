public class Runner {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.insertEnd(10);
        list.insertEnd(20);
        list.insertEnd(30);
        list.display();

        System.out.println();

        list.insertBefore(30, 25);
        list.display();
    }
}
