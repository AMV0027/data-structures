#include <stdio.h>
#include <stdlib.h>

struct TreeNode {
    int data;
    struct TreeNode *left, *right;
};

struct TreeNode* createNode(int data) {
    struct TreeNode* newNode = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    newNode->data = data;
    newNode->left = newNode->right = NULL;
    return newNode;
}

void insertNode(struct TreeNode **root, int data) {
    if (*root == NULL) {
        *root = createNode(data);
        return;
    }

    struct TreeNode *queue[100];
    int front = 0, rear = 0;

    queue[rear++] = *root;

    while (front < rear) {
        struct TreeNode *current = queue[front++];
        
        if (current->left == NULL) {
            current->left = createNode(data);
            break;
        } else {
            queue[rear++] = current->left;
        }

        if (current->right == NULL) {
            current->right = createNode(data);
            break;
        } else {
            queue[rear++] = current->right;
        }
    }
}

void inorderTraversal(struct TreeNode *root) {
    if (root == NULL) return;
    inorderTraversal(root->left);
    printf("%d ", root->data);
    inorderTraversal(root->right);
}

int main() {
    struct TreeNode *root = NULL;

    insertNode(&root, 10);
    insertNode(&root, 20);
    insertNode(&root, 30);
    insertNode(&root, 40);
    insertNode(&root, 50);

    printf("Inorder Traversal of the Complete Tree: ");
    inorderTraversal(root);
    printf("\n");

    return 0;
}
