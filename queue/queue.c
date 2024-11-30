#include <stdio.h>
#include <string.h>

struct queue {
    int contents[5];
    int front;
    int rear;
    int count;
};

void printMenu() {
    printf("Choice 1 : Enter element into Queue\nChoice 2 : Delete element from Queue\nChoice 3 : Display\nAny other choice : Exit\n");
}

void initQueue(struct queue* q) {
    q->front = 0;
    q->rear = -1;
    q->count = 0;
}

void enQueue(struct queue* q, int element) {
    if (q->count == 5) {
        printf("Queue is full\n");
        return;
    }
    q->rear = (q->rear + 1) % 5;
    q->contents[q->rear] = element;
    q->count++;
}

int deQueue(struct queue* q) {
    if (q->count == 0) {
        printf("Queue is empty\n");
        return -1000;
    }
    int d = q->contents[q->front];
    q->front = (q->front + 1) % 5;
    q->count--;
    return d;
}

void display(struct queue* q) {
    if (q->count == 0) {
        printf(" {}");
        return;
    }
    int j = q->front;
    for (int i = 0; i < q->count; i++) {
        printf(" %d", q->contents[j]);
        j = (j + 1) % 5;
    }
}

int main() {
    struct queue p;
    int data, ch, data1;
    initQueue(&p);
    do {
        printMenu();
        printf("Enter your choice\n");
        scanf("%d", &ch);
        switch (ch) {
        case 1:
            printf("Enter the element to be inserted/entered\n");
            scanf("%d", &data);
            enQueue(&p, data);
            break;
        case 2:
            data1 = deQueue(&p);
            if (data1 != -1000)
                printf("The deleted element is %d\n", data1);
            break;
        case 3:
            printf("The contents of the queue are");
            display(&p);
            printf("\n");
            break;
        default:
            return 0;
        }
    } while (1);
    return 0;
}
