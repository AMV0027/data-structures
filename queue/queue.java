import java.util.Scanner;

class Queue {
    private int[] contents;
    private int front, rear, count;

    public Queue(int size) {
        contents = new int[size];
        front = 0;
        rear = -1;
        count = 0;
    }

    public void enQueue(int element) {
        if (count == contents.length) {
            System.out.println("Queue is full");
            return;
        }
        rear = (rear + 1) % contents.length;
        contents[rear] = element;
        count++;
    }

    public int deQueue() {
        if (count == 0) {
            System.out.println("Queue is empty");
            return -1000;
        }
        int data = contents[front];
        front = (front + 1) % contents.length;
        count--;
        return data;
    }

    public void display() {
        if (count == 0) {
            System.out.print(" {}");
            return;
        }
        int j = front;
        for (int i = 0; i < count; i++) {
            System.out.print(" " + contents[j]);
            j = (j + 1) % contents.length;
        }
    }
}

public class QueueApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue queue = new Queue(5);

        while (true) {
            System.out.println("Choice 1 : Enter element into Queue");
            System.out.println("Choice 2 : Delete element from Queue");
            System.out.println("Choice 3 : Display");
            System.out.println("Any other choice : Exit");

            System.out.println("Enter your choice");
            int ch = scanner.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("Enter the element to be inserted/entered");
                    int data = scanner.nextInt();
                    queue.enQueue(data);
                    break;
                case 2:
                    int data1 = queue.deQueue();
                    if (data1 != -1000)
                        System.out.println("The deleted element is " + data1);
                    break;
                case 3:
                    System.out.print("The contents of the queue are");
                    queue.display();
                    System.out.println();
                    break;
                default:
                    System.exit(0);
            }
        }
    }
}
