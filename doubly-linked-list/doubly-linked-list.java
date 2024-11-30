class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    private Node head;

    public void insertAtStart(int data) {
        Node newNode = new Node(data);
        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
        newNode.prev = temp;
    }

    public void insertAfter(int target, int data) {
        Node temp = head;
        while (temp != null && temp.data != target) temp = temp.next;
        if (temp == null) {
            System.out.println("Target " + target + " not found in the list.");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = temp.next;
        newNode.prev = temp;
        if (temp.next != null) temp.next.prev = newNode;
        temp.next = newNode;
    }

    public void deleteAtStart() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        head = head.next;
        if (head != null) head.prev = null;
    }

    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        while (temp.next != null) temp = temp.next;
        if (temp.prev != null) temp.prev.next = null;
        else head = null;
    }

    public void deleteSpecific(int target) {
        Node temp = head;
        while (temp != null && temp.data != target) temp = temp.next;
        if (temp == null) {
            System.out.println("Target " + target + " not found in the list.");
            return;
        }
        if (temp.prev != null) temp.prev.next = temp.next;
        else head = temp.next;
        if (temp.next != null) temp.next.prev = temp.prev;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        System.out.print("List elements: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class DLL {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        java.util.Scanner sc = new java.util.Scanner(System.in);

        while (true) {
            System.out.println("1. Insert at Start\n2. Insert at End\n3. Insert After\n4. Delete at Start\n5. Delete at End\n6. Delete Specific\n7. Display\n8. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to insert at start: ");
                    dll.insertAtStart(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter data to insert at end: ");
                    dll.insertAtEnd(sc.nextInt());
                    break;
                case 3:
                    System.out.print("Enter target after which to insert: ");
                    int target = sc.nextInt();
                    System.out.print("Enter data to insert: ");
                    dll.insertAfter(target, sc.nextInt());
                    break;
                case 4:
                    dll.deleteAtStart();
                    break;
                case 5:
                    dll.deleteAtEnd();
                    break;
                case 6:
                    System.out.print("Enter data to delete: ");
                    dll.deleteSpecific(sc.nextInt());
                    break;
                case 7:
                    dll.display();
                    break;
                case 8:
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
