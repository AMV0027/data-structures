#include <stdio.h>
#include <stdlib.h>

// Define the structure for the stack
typedef struct {
    int* array;
    int top;
    int capacity;
} Stack;

// Function to create a new stack
Stack* createStack(int capacity) {
    Stack* stack = (Stack*)malloc(sizeof(Stack));
    stack->capacity = capacity;
    stack->top = -1;
    stack->array = (int*)malloc(stack->capacity * sizeof(int));
    return stack;
}

// Function to check if the stack is empty
int isEmpty(Stack* stack) {
    return stack->top == -1;
}

// Function to check if the stack is full
int isFull(Stack* stack) {
    return stack->top == stack->capacity - 1;
}

// Function to push an element onto the stack
void push(Stack* stack, int data) {
    if (isFull(stack)) {
        printf("Stack is full. Cannot push %d.\n", data);
        return;
    }
    stack->array[++stack->top] = data;
    printf("Pushed %d onto the stack\n", data);
}

// Function to pop an element from the stack
void pop(Stack* stack) {
    if (isEmpty(stack)) {
        printf("Stack is empty. Cannot pop.\n");
        return;
    }
    printf("Popped %d from the stack\n", stack->array[stack->top--]);
}

// Function to peek the top element of the stack
void peek(Stack* stack) {
    if (isEmpty(stack)) {
        printf("Stack is empty. Cannot peek.\n");
        return;
    }
    printf("Top element is %d\n", stack->array[stack->top]);
}

// Function to display the stack elements
void display(Stack* stack) {
    if (isEmpty(stack)) {
        printf("Stack is empty.\n");
        return;
    }
    printf("Stack elements: ");
    for (int i = 0; i <= stack->top; i++) {
        printf("%d ", stack->array[i]);
    }
    printf("\n");
}

int main() {
    int capacity;
    printf("Enter the capacity of the stack: ");
    scanf("%d", &capacity);

    Stack* stack = createStack(capacity);
    int choice, data;

    while (1) {
        printf("\n1. Push\n2. Pop\n3. Peek\n4. Display\n5. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter data to push: ");
                scanf("%d", &data);
                push(stack, data);
                break;
            case 2:
                pop(stack);
                break;
            case 3:
                peek(stack);
                break;
            case 4:
                display(stack);
                break;
            case 5:
                free(stack->array);
                free(stack);
                exit(0);
            default:
                printf("Invalid choice\n");
        }
    }
    return 0;
}
