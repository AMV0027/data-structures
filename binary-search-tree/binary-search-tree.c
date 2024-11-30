#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct tnode {
    int data;
    struct tnode *left;
    struct tnode *right;
};

struct tnode* createNode(int n) {
    struct tnode* nn = (struct tnode*)malloc(sizeof(struct tnode));
    nn->data = n;
    nn->left = nn->right = NULL;
    return nn;
}

void insert(struct tnode** root, int value) {
    if (*root == NULL) {
        *root = createNode(value);
        return;
    }
    struct tnode* temp = *root, *pre;
    while (temp != NULL) {
        pre = temp;
        if (value < temp->data)
            temp = temp->left;
        else
            temp = temp->right;
    }
    if (value < pre->data)
        pre->left = createNode(value);
    else
        pre->right = createNode(value);
}

void inorder(struct tnode* root) {
    if (root == NULL) return;
    inorder(root->left);
    printf(" %d", root->data);
    inorder(root->right);
}

void preorder(struct tnode* root) {
    if (root == NULL) return;
    printf(" %d", root->data);
    preorder(root->left);
    preorder(root->right);
}

void postorder(struct tnode* root) {
    if (root == NULL) return;
    postorder(root->left);
    postorder(root->right);
    printf(" %d", root->data);
}

struct tnode* search(struct tnode* root, int data) {
    if (root == NULL || root->data == data) return root;
    if (data < root->data)
        return search(root->left, data);
    return search(root->right, data);
}

int findMin(struct tnode* root) {
    while (root->left != NULL) root = root->left;
    return root->data;
}

struct tnode* deleteNode(struct tnode* root, int key) {
    if (root == NULL) return NULL;
    if (key < root->data)
        root->left = deleteNode(root->left, key);
    else if (key > root->data)
        root->right = deleteNode(root->right, key);
    else {
        if (root->left == NULL) {
            struct tnode* temp = root->right;
            free(root);
            return temp;
        } else if (root->right == NULL) {
            struct tnode* temp = root->left;
            free(root);
            return temp;
        }
        int minValue = findMin(root->right);
        root->data = minValue;
        root->right = deleteNode(root->right, minValue);
    }
    return root;
}

int main() {
    struct tnode* root = NULL;
    int choice, ele;
    printf("Binary Search Tree Implementation.\n");
    printf("1. Insert\n2. Delete\n3. Search\n4. Inorder Traversal\n5. Preorder Traversal\n6. Postorder Traversal\n7. Exit\n");
    while (1) {
        printf("Enter your choice: ");
        scanf("%d", &choice);
        switch (choice) {
            case 1:
                printf("Enter element to insert: ");
                scanf("%d", &ele);
                insert(&root, ele);
                break;
            case 2:
                printf("Enter element to delete: ");
                scanf("%d", &ele);
                root = deleteNode(root, ele);
                break;
            case 3:
                printf("Enter element to search: ");
                scanf("%d", &ele);
                struct tnode* found = search(root, ele);
                if (found)
                    printf("%d found in the tree.\n", ele);
                else
                    printf("%d not found in the tree.\n", ele);
                break;
            case 4:
                printf("Inorder Traversal:");
                inorder(root);
                printf("\n");
                break;
            case 5:
                printf("Preorder Traversal:");
                preorder(root);
                printf("\n");
                break;
            case 6:
                printf("Postorder Traversal:");
                postorder(root);
                printf("\n");
                break;
            case 7:
                exit(0);
        }
    }
    return 0;
}
