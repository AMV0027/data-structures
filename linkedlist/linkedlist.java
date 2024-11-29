class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    Node createNode(int data) {
        return new Node(data);
    }

    void append(int data) {
        Node newNode = createNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    void appendAtBeginning(int data) {
        Node newNode = createNode(data);
        newNode.next = head;
        head = newNode;
    }

    void appendAtPosition(int data, int position) {
        Node newNode = createNode(data);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) return;
        newNode.next = temp.next;
        temp.next = newNode;
    }

    void deleteAtBeginning() {
        if (head == null) return;
        head = head.next;
    }

    void deleteAtEnd() {
        if (head == null) return;
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    void deleteAtPosition(int position) {
        if (head == null) return;
        if (position == 1) {
            head = head.next;
            return;
        }
        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) return;
        temp.next = temp.next.next;
    }

    void deleteData(int data) {
        if (head == null) return;
        if (head.data == data) {
            head = head.next;
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.data != data) {
            temp = temp.next;
        }
        if (temp.next == null) return;
        temp.next = temp.next.next;
    }

    void search(int data) {
        int position = 1;
        Node temp = head;
        while (temp != null) {
            if (temp.data == data) {
                System.out.println("Data " + data + " found at position " + position);
                return;
            }
            temp = temp.next;
            position++;
        }
        System.out.println("Data " + data + " not found");
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        while (true) {
            System.out.println("\n1. Append\n2. Append at Beginning\n3. Append at Position\n");
            System.out.println("4. Delete at Beginning\n5. Delete at End\n6. Delete at Position\n");
            System.out.println("7. Delete Data\n8. Search\n9. Display\n10. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to append: ");
                    int data = scanner.nextInt();
                    linkedList.append(data);
                    break;
                case 2:
                    System.out.print("Enter data to append at beginning: ");
                    data = scanner.nextInt();
                    linkedList.appendAtBeginning(data);
                    break;
                case 3:
                    System.out.print("Enter data to append: ");
                    data = scanner.nextInt();
                    System.out.print("Enter position: ");
                    int position = scanner.nextInt();
                    linkedList.appendAtPosition(data, position);
                    break;
                case 4:
                    linkedList.deleteAtBeginning();
                    break;
                case 5:
                    linkedList.deleteAtEnd();
                    break;
                case 6:
                    System.out.print("Enter position to delete: ");
                    position = scanner.nextInt();
                    linkedList.deleteAtPosition(position);
                    break;
                case 7:
                    System.out.print("Enter data to delete: ");
                    data = scanner.nextInt();
                    linkedList.deleteData(data);
                    break;
                case 8:
                    System.out.print("Enter data to search: ");
                    data = scanner.nextInt();
                    linkedList.search(data);
                    break;
                case 9:
                    linkedList.display();
                    break;
                case 10:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
