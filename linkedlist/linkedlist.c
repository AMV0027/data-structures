#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int data;
    struct Node* next;
} Node;

Node* createNode(int data) {
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->data = data;
    newNode->next = NULL;
    return newNode;
}

void append(Node** head, int data) {
    Node* newNode = createNode(data);
    if (*head == NULL) {
        *head = newNode;
        return;
    }
    Node* temp = *head;
    while (temp->next != NULL) {
        temp = temp->next;
    }
    temp->next = newNode;
}

void appendAtBeginning(Node** head, int data) {
    Node* newNode = createNode(data);
    newNode->next = *head;
    *head = newNode;
}

void appendAtPosition(Node** head, int data, int position) {
    Node* newNode = createNode(data);
    if (position == 1) {
        newNode->next = *head;
        *head = newNode;
        return;
    }
    Node* temp = *head;
    for (int i = 1; i < position - 1 && temp != NULL; i++) {
        temp = temp->next;
    }
    if (temp == NULL) return;
    newNode->next = temp->next;
    temp->next = newNode;
}

void deleteAtBeginning(Node** head) {
    if (*head == NULL) return;
    Node* temp = *head;
    *head = (*head)->next;
    free(temp);
}

void deleteAtEnd(Node** head) {
    if (*head == NULL) return;
    if ((*head)->next == NULL) {
        free(*head);
        *head = NULL;
        return;
    }
    Node* temp = *head;
    while (temp->next->next != NULL) {
        temp = temp->next;
    }
    free(temp->next);
    temp->next = NULL;
}

void deleteAtPosition(Node** head, int position) {
    if (*head == NULL) return;
    if (position == 1) {
        Node* temp = *head;
        *head = (*head)->next;
        free(temp);
        return;
    }
    Node* temp = *head;
    for (int i = 1; i < position - 1 && temp != NULL; i++) {
        temp = temp->next;
    }
    if (temp == NULL || temp->next == NULL) return;
    Node* toDelete = temp->next;
    temp->next = temp->next->next;
    free(toDelete);
}

void deleteData(Node** head, int data) {
    if (*head == NULL) return;
    if ((*head)->data == data) {
        Node* temp = *head;
        *head = (*head)->next;
        free(temp);
        return;
    }
    Node* temp = *head;
    while (temp->next != NULL && temp->next->data != data) {
        temp = temp->next;
    }
    if (temp->next == NULL) return;
    Node* toDelete = temp->next;
    temp->next = temp->next->next;
    free(toDelete);
}

void search(Node* head, int data) {
    int position = 1;
    while (head != NULL) {
        if (head->data == data) {
            printf("Data %d found at position %d\n", data, position);
            return;
        }
        head = head->next;
        position++;
    }
    printf("Data %d not found\n", data);
}

void display(Node* head) {
    while (head != NULL) {
        printf("%d -> ", head->data);
        head = head->next;
    }
    printf("NULL\n");
}

int main() {
    Node* head = NULL;
    int choice, data, position;

    while (1) {
        printf("\n1. Append\n2. Append at Beginning\n3. Append at Position\n");
        printf("4. Delete at Beginning\n5. Delete at End\n6. Delete at Position\n");
        printf("7. Delete Data\n8. Search\n9. Display\n10. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter data to append: ");
                scanf("%d", &data);
                append(&head, data);
                break;
            case 2:
                printf("Enter data to append at beginning: ");
                scanf("%d", &data);
                appendAtBeginning(&head, data);
                break;
            case 3:
                printf("Enter data to append: ");
                scanf("%d", &data);
                printf("Enter position: ");
                scanf("%d", &position);
                appendAtPosition(&head, data, position);
                break;
            case 4:
                deleteAtBeginning(&head);
                break;
            case 5:
                deleteAtEnd(&head);
                break;
            case 6:
                printf("Enter position to delete: ");
                scanf("%d", &position);
                deleteAtPosition(&head, position);
                break;
            case 7:
                printf("Enter data to delete: ");
                scanf("%d", &data);
                deleteData(&head, data);
                break;
            case 8:
                printf("Enter data to search: ");
                scanf("%d", &data);
                search(head, data);
                break;
            case 9:
                display(head);
                break;
            case 10:
                exit(0);
            default:
                printf("Invalid choice\n");
        }
    }
    return 0;
}
